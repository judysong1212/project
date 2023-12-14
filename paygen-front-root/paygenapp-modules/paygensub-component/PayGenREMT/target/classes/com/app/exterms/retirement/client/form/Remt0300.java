package com.app.exterms.retirement.client.form;

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
import com.app.exterms.retirement.client.form.def.Remt3100Def;
import com.app.exterms.retirement.client.languages.RemtConstants;
import com.app.exterms.retirement.client.service.Remt0300Service;
import com.app.exterms.retirement.client.service.Remt0300ServiceAsync;
import com.app.exterms.retirement.client.utils.RemtUtils;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
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
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

public class Remt0300   extends MSFPanel { 
	

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
	  private RemtConstants lblRemtConst = RemtConstants.INSTANCE;
	
 		
	  private VerticalPanel vp;
	  private FormPanel plFrmRemt0300;
	//  private FormData formData; 
	  private String txtForm = "";  
	 
	  
	  private Remt3100Def remt3100Def  = new Remt3100Def("REMT0300");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel remt3100GridPanel;
      
      
      //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
  
    
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
       
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * Button 변수 선언
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ButtonBar topRemt0300Bar;
      private Button btnRemt0300New;
      private Button btnRemt0300Save;
      private Button btnRemt0300Del;
      private Button btnRemt0300Sreach;
      private Button btnRemt0300Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhClutYr01;
      private ComboBox<BaseModel> srhClutMnth01;
      private ComboBox<BaseModel> srhClutYr02;
      private ComboBox<BaseModel> srhClutMnth02;
      
      private ComboBox<BaseModel> srhCalcSevePayPsnDivCd;     //퇴직정산구분코드
     
       
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
//      private TextField<String> srhDeptCd ;    //부서 
//      private TextField<String> srhDeptNm ;    //부서 
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정 
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드	 
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
       
      private Boolean picBoolFile;
       
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      
      private boolean mutilCombo = false;
      
     
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
     
       
      //중간 근태생성 부분 끝
      //파일업로드처리 부분  
//      private FileUploadField remt0300flUp;
//       
//      private List<ModelData> mDtalistcrDeptCd ;
//      private List<ModelData> mDtalistcrTypOccuCd ;
//      private List<ModelData> mDtalistcrDtilOccuInttnCd ;
//      
//      private boolean mutilcrCombo = false;
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
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
   		   * 권한설정 처리 체크 
   		   * AuthAction 
   		   */
   		  private void checkRemt0300Auth( String authAction, ListStore<BaseModel> bm) {   
   	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
   			 
   			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

				   if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ;
	                 
  	               
   	                
   	                 
   			   }
   		  }
   		private void authExecEnabled() { 
   		   //------------------
   		 //----------------------------------------------------
            Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
            
            gwtAuthorization.formAuthFieldConfig(fldArrField);
            gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
            
            srhClutYr01.setValue(lsClutYr01Store.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
        	srhClutMnth01.setValue(lsClutMnth01.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	        srhClutYr02.setValue(lsClutYr02Store.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
	        srhClutMnth02.setValue(lsClutMnth02.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	        srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
	        	 
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            * 권한설정을 위한 콤보처리를 위한 메서드 시작 
            * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
            // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
            // GWTAuthorization.formAuthPopConfig(plFrmRemt0300, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
            // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			//gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
           /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            * 권한설정을 위한 콤보처리를 위한 메서드 종료
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
           //  srhDeptCd.fireEvent(Events.Add); 
             srhDeptCd.getListView().fireEvent(Events.CheckChanged);  
           
   		 }

		   final Timer tmMask = new Timer()
		     {
		           public void run()
		           {
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
   			    
   			     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
   			     authMapDef.put("srhClutYr01",Boolean.FALSE);
			  	 authMapDef.put("srhClutMnth01",Boolean.FALSE);
			  	 authMapDef.put("srhClutYr02",Boolean.FALSE);
			  	 authMapDef.put("srhClutMnth02",Boolean.FALSE);
			     authMapDef.put("srhCalcSevePayPsnDivCd",Boolean.FALSE);
			     
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
   	 
   		  
//    	  private AuthAction authAction;
//    	  private int checkCntDef = 4;   //체크 값 갯수 
//    	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//    	  /**
//    	   * 권한설정 처리 체크 
//    	   * AuthAction 
//    	   */
//    	  private void checkRemt0300Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//        	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//    		 
//    		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//    		    
//                    
//                
//                    //----------------------------------------------------
//                    unmask(); 
//                    //MSFMainApp.unmaskMainPage();
//                     
//    		   }
//    	  }
        
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
   // 검색 폼 바인딩 처리 함수 
      
     
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    
	//입력수정삭제처리 rpc 처리부     
	private Remt0300ServiceAsync payr0250Service = Remt0300Service.Util.getInstance();
      
    private ListStore<BaseModel> lsClutYr01Store 		= new ListStore<BaseModel>();  	//년도 
    private ListStore<BaseModel> lsClutMnth01 			= new ListStore<BaseModel>();  	//월   
    private ListStore<BaseModel> lsClutYr02Store 		= new ListStore<BaseModel>();  	//년도 
    private ListStore<BaseModel> lsClutMnth02 			= new ListStore<BaseModel>();  	//월   
     
    private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>();	//고용구분 
    private ListStore<BaseModel> lsRepbtyBusinDivCd 	= new ListStore<BaseModel>();	//호봉제구분코드 
      
    //--------------------부서 불러 오는 함수 ------------------------------------------------
    private ListStore<BaseModel> lsDeptCd  				= new ListStore<BaseModel>();	//부서콤보
    //--------------------부서 불러 오는 함수 ------------------------------------------------
         
    //--------------------사업 불러 오는 함수 -------------------------------------------------
    private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>();	//사업콤보   
    //--------------------사업 불러 오는 함수 -------------------------------------------------
    private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>();	//단위기관 
    private ListStore<BaseModel> lsDeptGpCd 			= new ListStore<BaseModel>();	//부서직종그룹코드  	
    private ListStore<BaseModel> lsTypOccuCd 			= new ListStore<BaseModel>();	//직종 
    private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();	//직종세
    private ListStore<BaseModel> lsCalcSevePayPsnDivCd 	= new ListStore<BaseModel>(); 	//퇴직정산구분코드
      
    private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
    private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
    private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
    private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
    private SysCoCalendarDTO  msfCoCalendarDto;  
    private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
    private PrgmComBass0320DTO sysComBass0320Dto;	//직종
     
	private BaseModel record;

	private Iterator<Record> records;
  	 
      
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
 
 
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				
				 //콤보 권한초기화
				   initLoad(); 
				//formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createPsnl0100Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			  
			    createCheckBoxGrid();    //근무실적 
			    //엣지변환
			    //vp.setSize("1010px", "700px"); 
			    vp.setSize("1010px", "750px"); 
			    
			    
			    this.actionDatabase = ActionDatabase.UPDATE;
			     
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
	  public Remt0300() {
		    
		  //엣지변환
		  //setSize("1010px", "700px");  
			setSize("1010px", "750px");  
	  } 
	
	  public Remt0300(String txtForm) {
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
	  
	  private void createPsnl0100Form() {
		  
		plFrmRemt0300 = new FormPanel();
		plFrmRemt0300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  퇴직소득지급현황")); //+ lblDlgnConst.title_Remt0300());
		//plFrmRemt0300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 간이소득세액표관리");
		plFrmRemt0300.setIcon(MSFMainApp.ICONS.text());
		plFrmRemt0300.setBodyStyleName("pad-text");
		plFrmRemt0300.setPadding(2);
		plFrmRemt0300.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("퇴직소득지급현황","REMT0300");
				}
			});
		plFrmRemt0300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmRemt0300.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		   //멀티콤보박스 닫기 
		plFrmRemt0300.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) { 
            
             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                    
            //        if (f instanceof MSFMultiComboBox<?>) {
                        
//                      if ("srhDeptCd".equals(f.getName())) {
//                          
//                      } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                          
//                      }
                        
              //      } else {
                   if (mutilCombo) {
                        if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
                            //부서
                            srhDeptCd.showClose(ce);
                            mutilCombo = false;
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
        
		 topRemt0300Bar = new ButtonBar();    
		 topRemt0300Bar.setAlignment(HorizontalAlignment.RIGHT);
 
		 
//	   //신규 
//        btnRemt0300New = new Button("신규");  
//        btnRemt0300New.setIcon(MSFMainApp.ICONS.new16());
//        topRemt0300Bar.add(btnRemt0300New);
//        btnRemt0300New.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//                //초기화 버튼 클릭시 처리     
//                remt3100GridPanel.getMsfGrid().clearData();
//                fnPopupPsnl0110();   
//                 
//            }
//        });
//        //저장 -신규/수정 동시 처리 부분으로 나뉨 
//        btnRemt0300Save = new Button("저장");  
//        btnRemt0300Save.setIcon(MSFMainApp.ICONS.save16());
//        topRemt0300Bar.add(btnRemt0300Save); 
//        btnRemt0300Save.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//                
//                setListRecord(remt3100GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
//                doAction(actionDatabase); 
//                 
//            }
//        });
//       
//        //삭제       
//        btnRemt0300Del = new Button("삭제");  
//        btnRemt0300Del.setIcon(MSFMainApp.ICONS.delete16());
//        topRemt0300Bar.add(btnRemt0300Del);
//        btnRemt0300Del.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//                
//                Iterator<BaseModel> itBm  = remt3100GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//                
//                List<Record>  lsRec  = new ArrayList<Record>();
//                
//                while(itBm.hasNext()) {
//   
//                    Record rec  = new Record(itBm.next()); 
//                    lsRec.add(rec);
//                    
//                } 
//                 setListRecord(lsRec.iterator()); 
//                  
//                actionDatabase = ActionDatabase.DELETE;
//                doAction(actionDatabase);
//                 
//            }
//        });
        
	  
	  	btnRemt0300Sreach = new Button("조회"); 
	  	btnRemt0300Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topRemt0300Bar.add(btnRemt0300Sreach);
	  	btnRemt0300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//조회버튼 클릭시 처리 
    		    reload();  
    		}
    	});
	  	
	  	btnRemt0300Excel = new Button("엑셀"); 
	  	btnRemt0300Excel.setIcon(MSFMainApp.ICONS.excel16());
	  	topRemt0300Bar.add(btnRemt0300Excel);
	  	btnRemt0300Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//엑셀저장  
    			excelFileExport();
    		}
    	});
	  	
	  	
//	  	topBtn = new Button("인쇄"); 
//	  	topBtn.setIcon(MSFMainApp.ICONS.text()); 
//	  	buttonBar.add(topBtn);  
	  	
	  	plFrmRemt0300.add(topRemt0300Bar);    	
	  	
		vp.add(plFrmRemt0300);
		//엣지변환
		//plFrmRemt0300.setSize("990px", "690px");
		plFrmRemt0300.setSize("990px", "740px");
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

	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {  
	    
	         sysComBass0150Dto = new PrgmComBass0150DTO();
	         sysComBass0300Dto = new PrgmComBass0300DTO();
	         sysComBass0400Dto = new PrgmComBass0400DTO();
	         sysComBass0500Dto = new PrgmComBass0500DTO();
	         msfCoCalendarDto  = new SysCoCalendarDTO();
	         sysComBass0350Dto = new PrgmComBass0350DTO();
	         sysComBass0320Dto = new PrgmComBass0320DTO();
	         
	         //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	         lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	         //--------------------단위기관 불러 오는 함수 ------------------------------------------------
	       
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         //급여구분 
	         sysComBass0300Dto.setRpsttvCd("B027");
	         lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
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
	       
	       //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         //월  
		     //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	         lsClutYr01Store = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	     
	         lsClutMnth01 = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         //월  
		     //--------------------급여년도 불러 오는 함수 ------------------------------------------------
	         lsClutYr02Store = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	         
	         lsClutMnth02 = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
 
 
	         
	         //--------------------부서 불러 오는 함수 ------------------------------------------------
	        // lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
	         //--------------------부서 불러 오는 함수 ------------------------------------------------
	         sysComBass0400Dto.setDeptDspyYn("Y");
	         sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
             sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
            
             lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
            
             lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
                 public void handleEvent(StoreEvent<BaseModel> be) {  
                     mDtalistDeptCd = RemtUtils.getDeptCdModelData(lsDeptCd) ; 
                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
                     
                    
                 }
             });  
             
             
             //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
            lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
	            
	       /**
	          * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	          * 직종 콤보박스 처리  시작
	          * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
	          */
//	                  ContentPanel typOccuCdGrid = new ContentPanel();  
//	                  typOccuCdGrid.setVisible(false);
//	                    
//	                    //직종 콤보처리 
//	                   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//	                   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	                           public void handleEvent(ComponentEvent be) {  
//	                             typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	                              public void handleEvent(StoreEvent<BaseModel> be) {  
//	                                  
//	                                lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
//	                                mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//	                               
//	                              }  
//	                            });  
//	                           
//	                          }  
//	                        });  
//	              
//	                 typOccuCdGrid.add(typOccuCdGridPanel); 
//	                 plFrmRemt0300.add(typOccuCdGrid); 
            lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
  		    lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
 	            public void handleEvent(StoreEvent<BaseModel> be) {  
 	             
                   mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                   srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                    
                 }
             });  
	             
	         /**
	       * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	       * 년도 콤보박스 처리  시작
	       * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
	       */
//	               ContentPanel yearGrid = new ContentPanel();  
//	               yearGrid.setVisible(false);
//	                
//	               //년도 콤보처리 
//	               yearGridPanel = new MSFGridPanel(lkClutYr01, false, false, false, true); 
//	               yearGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	                       public void handleEvent(ComponentEvent be) {  
//	                         yearGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	                          public void handleEvent(StoreEvent<BaseModel> be) {  
//	                             lsClutYr01Store.add(yearGridPanel.getMsfGrid().getStore().getModels()); 
//	                             
//	                            //  Date today = new Date(); 
//	                                // A custom date format
//	                            //  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	                             
//	                             // BaseModel  bm  =  srhClutYr01.getStore().findModel("apptnYr", fmt.format(today) ); 
//	                             // srhClutYr01.setValue(bm);
//	                            srhClutYr01.setValue(lsClutYr01Store.getAt(0));
//	                            Date today = new Date(); 
//	                            DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//	                            srhClutMnth01.setValue(lsClutMnth01.getAt(Integer.parseInt(fmt.format(today)) - 1));
//	                          
//	                          }  
//	                        });  
//	                       
//	                      }  
//	                    });  
//	          
//	            yearGrid.add(yearGridPanel); 
//	            plFrmRemt0300.add(yearGrid); 
 
	        plFrmRemt0300.setLayout(new FlowLayout());
	        
	        srhSystemkey = new HiddenField<String>(); 
	          
	        LayoutContainer lcSchCol = new LayoutContainer();
	        lcSchCol.setLayout(new ColumnLayout()); 
	        
	        FieldSet fieldSet = new FieldSet();  
	        fieldSet.setHeadingHtml("검색조건");  
	        /****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 시작
			 ****************************************************************/
			fieldSet.addStyleName("x-fieldset-serarch-back-color");
			/****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 끝
			 ****************************************************************/
			
	       // fieldSet.setCheckboxToggle(false); 
	        
	        LayoutContainer lcSchLeft = new LayoutContainer();
	        lcSchLeft.setStyleAttribute("paddingRight", "10px"); 
	     
	        fieldSet.add(lcSchCol, new FormData("100%"));  
	        lcSchLeft.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_8 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_8.setLayout(frmlytSch);
		    
		    srhClutYr01 = new ComboBox<BaseModel>(); 
		    srhClutYr01.setName("srhClutYr01");
		    srhClutYr01.setForceSelection(true);
		    srhClutYr01.setMinChars(1);
		    srhClutYr01.setDisplayField("yearDisp");
		    srhClutYr01.setValueField("year");
		    srhClutYr01.setTriggerAction(TriggerAction.ALL);
		   // srhClutYr01.setEmptyText("--년도선택--");
		    srhClutYr01.setSelectOnFocus(true); 
		    srhClutYr01.setReadOnly(false);
		    srhClutYr01.setEnabled(true); 
		    srhClutYr01.setStore(lsClutYr01Store); 
		    srhClutYr01.setFieldLabel("지급기간");   
		    srhClutYr01.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        public void handleEvent(StoreEvent<BaseModel> be) {  

		        	checkRemt0300Auth("srhClutYr01", lsClutYr01Store);  
		        }
		    });
		    srhClutYr01.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	             BaseModel bmClutYr =  se.getSelectedItem(); 
	             if (bmClutYr != null) {
	                 
	                 if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                     
	                     if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                        
	                         sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr01,"year"));
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
	                 
	                 
	             
	             }       
	            } 
	        });   
		    layoutContainer_8.add(srhClutYr01, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		    layoutContainer_8.setBorders(false);
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_9.setLayout(frmlytSch);
		    
		    srhClutMnth01 = new ComboBox<BaseModel>(); 
		    srhClutMnth01.setName("srhClutMnth01");
		    srhClutMnth01.setForceSelection(true);
		    srhClutMnth01.setMinChars(1);
		    srhClutMnth01.setDisplayField("monthDisp");
		    srhClutMnth01.setValueField("month");
		    srhClutMnth01.setTriggerAction(TriggerAction.ALL);
		  //srhClutMnth01.setEmptyText("--월선택--");
		    srhClutMnth01.setSelectOnFocus(true); 
		    srhClutMnth01.setReadOnly(false);
		    srhClutMnth01.setEnabled(true); 
		    srhClutMnth01.setStore(lsClutMnth01); 
		    srhClutMnth01.setHideLabel(true);
		    srhClutMnth01.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		         public void handleEvent(StoreEvent<BaseModel> be) {  
		        	 checkRemt0300Auth("srhClutMnth01", lsClutMnth01); 
		         }
		     });
		    layoutContainer_9.add(srhClutMnth01, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		    layoutContainer_9.setBorders(false);
		    
		    LayoutContainer layoutContainer_11 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(10); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_11.setLayout(frmlytSch);
		    
		    srhClutYr02 = new ComboBox<BaseModel>(); 
		    srhClutYr02.setName("srhClutYr02");
		    srhClutYr02.setForceSelection(true);
		    srhClutYr02.setMinChars(1);
		    srhClutYr02.setDisplayField("yearDisp");
		    srhClutYr02.setValueField("year");
		    srhClutYr02.setTriggerAction(TriggerAction.ALL);
		    //srhClutYr02.setEmptyText("--년도선택--");
		    srhClutYr02.setSelectOnFocus(true); 
		    srhClutYr02.setReadOnly(false);
		    srhClutYr02.setEnabled(true); 
		    srhClutYr02.setStore(lsClutYr02Store); 
		    srhClutYr02.setLabelSeparator("~");
		    srhClutYr02.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        public void handleEvent(StoreEvent<BaseModel> be) {  
		        	checkRemt0300Auth("srhClutYr02", lsClutYr02Store); 
		        }
		    });
		    layoutContainer_11.add(srhClutYr02, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_11.setBorders(false);
		    
		    LayoutContainer layoutContainer_12 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_12.setLayout(frmlytSch);
		    
		    srhClutMnth02 = new ComboBox<BaseModel>(); 
		    srhClutMnth02.setName("srhClutMnth02");
		    srhClutMnth02.setForceSelection(true);
		    srhClutMnth02.setMinChars(1);
		    srhClutMnth02.setDisplayField("monthDisp");
		    srhClutMnth02.setValueField("month");
		    srhClutMnth02.setTriggerAction(TriggerAction.ALL);
		  //srhClutMnth02.setEmptyText("--월선택--");
		    srhClutMnth02.setSelectOnFocus(true); 
		    srhClutMnth02.setReadOnly(false);
		    srhClutMnth02.setEnabled(true); 
		    srhClutMnth02.setStore(lsClutMnth02); 
		    srhClutMnth02.setHideLabel(true);
		    srhClutMnth02.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		         public void handleEvent(StoreEvent<BaseModel> be) {  

		        	 checkRemt0300Auth("srhClutMnth02", lsClutMnth02); 
		         }
		     });
		    layoutContainer_12.add(srhClutMnth02, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		    layoutContainer_12.setBorders(false);

		    LayoutContainer layoutContainer = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
            layoutContainer.setLayout(frmlytSch);
            
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
			                	checkRemt0300Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
                         mDtalistDeptCd = RemtUtils.getDeptCdModelData(lsDeptCd) ; 
                         srhDeptCd.getInitStore().add(mDtalistDeptCd);
                           
                       }
                    });  
                } 
            }); 
            layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
            layoutContainer.setBorders(false);
            
            LayoutContainer layoutContainer_14 = new LayoutContainer(new ColumnLayout());
            
            LayoutContainer layoutContainer_15 = new LayoutContainer();
            
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_15.setLayout(frmlytSch);
            
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
			                	checkRemt0300Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
            layoutContainer_15.add(srhEmymtDivCd, new FormData("100%"));
            layoutContainer_14.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
            
		    
		    LayoutContainer layoutContainer_101 = new LayoutContainer();
			layoutContainer_101.setBorders(false);

		    frmlytSch = new FormLayout();  
		    frmlytSch.setDefaultWidth(0);
//		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_101.setLayout(frmlytSch);
		    
		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		    srhRepbtyBusinDivCd.setForceSelection(true);
		    srhRepbtyBusinDivCd.setAllowBlank(false);
		    srhRepbtyBusinDivCd.setMinChars(1);
		    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
		    srhRepbtyBusinDivCd.setValueField("commCd");
		    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
		    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
		    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
		    srhRepbtyBusinDivCd.setHideLabel(true);
//		    srhRepbtyBusinDivCd.setLabelSeparator("");
	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
		    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

	              
	            }
	        });  
		    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
		    layoutContainer_14.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
            
            
            
            LayoutContainer layoutContainer_5 = new LayoutContainer();
            layoutContainer_5.setLayout(new ColumnLayout());
            
            LayoutContainer layoutContainer_6 = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_6.setLayout(frmlytSch);
            
            srhHanNm = new TextField<String>();
            srhHanNm.setName("srhHanNm");
            srhHanNm.setFieldLabel("성명");
            layoutContainer_6.add(srhHanNm, new FormData("100%"));
           
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
                        fnPopupPsnl0100() ;
                    }
                    super.componentKeyDown(event);
                }
             });
//            srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                @Override
//                public void handleEvent(BaseEvent be) {  
//                    if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                        srhSystemkey.setValue("");
//                        srhResnRegnNum.setValue("");
//                    }
//                 
//                } 
//          }); 
            layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
            layoutContainer_6.setBorders(false);
            
            
            LayoutContainer layoutContainer_btn = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(0); 
            layoutContainer_btn.setLayout(frmlytSch);
            
            Button btnHanNm = new Button("검색");
//            layoutContainer_5.add(btnHanNm);
            btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
                  srhSystemkey.setValue("");
                  srhResnRegnNum.setValue("");
                  fnPopupPsnl0100() ;
                      
                }
            });
            layoutContainer_btn.add(btnHanNm);
            layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
            
            LayoutContainer layoutContainer_7 = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setDefaultWidth(0);
//            frmlytSch.setLabelWidth(5); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_7.setLayout(frmlytSch);
            
            srhResnRegnNum = new TextField<String>();
            srhResnRegnNum.setHideLabel(true);
            srhResnRegnNum.setName("srhResnRegnNum");
            new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
            srhResnRegnNum.setLabelSeparator("");
            // srhResnRegnNum.setFieldLabel("주민번호");
            srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
                @Override
                public void handleEvent(BaseEvent be) {  
                    if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
                        srhSystemkey.setValue("");
                        srhHanNm.setValue("");
                    }
                 
                } 
          }); 
            layoutContainer_7.add(srhResnRegnNum, new FormData("100%")); 
            layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
            layoutContainer_7.setBorders(false); 
            layoutContainer_5.setBorders(false);
            
            
//		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29)); 			// 지급기간
//		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17)); 	// 단위기관
//		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32)); // 고용구분
//		    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));  // 성명 
            
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 지급기간
		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 단위기관
		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); // 고용구분
		    
		    LayoutContainer layoutContainer_3 = new LayoutContainer();
		    layoutContainer_3.setLayout(new ColumnLayout()); 

		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
		    layoutContainer_1.setBorders(false);
          
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(60);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_1.setLayout(frmlytSch);
          
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
					checkRemt0300Auth("srhCalcSevePayPsnDivCd",lsCalcSevePayPsnDivCd);
				}
			});
			layoutContainer_1.add(srhCalcSevePayPsnDivCd, new FormData("100%"));
            
            
            
            layoutContainer_1.setBorders(false); 
         
            
		    LayoutContainer layoutContainer_2 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_2.setLayout(frmlytSch);
		    
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
			                	checkRemt0300Auth("srhDeptCd", lsDeptCd); 
	                	 }
	           
	            }
	        });    
	 
	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	           @Override
	          public void handleEvent(ComponentEvent ce) { 
	                   
	                      if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                         
	                          if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                             
	                              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr01,"year")); 
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
   	            		   String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
   	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
   	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
   	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
   	           	             
   	                             mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
   	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
   	                              
   	                           }
   	                       });  
                	    
		                  } else {
		                	  
		                	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			            		   String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		                	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		             		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            	            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	             
		                              mDtalistTypOccuCd = RemtUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
	           
		    layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		   
		    layoutContainer_2.setBorders(false);
		    

            LayoutContainer layoutContainer_10 = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_10.setLayout(frmlytSch);
            
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
	        
               
            LayoutContainer layoutContainer_21 = new LayoutContainer();
            frmlytSch = new FormLayout();
            frmlytSch.setDefaultWidth(0);
//            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_21.setLayout(frmlytSch); 
            
            srhTypOccuCd = new MSFMultiComboBox<ModelData>();
            srhTypOccuCd.setName("srhTypOccuCd"); 
            srhTypOccuCd.setEmptyText("--직종선택--"); 
            srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
            srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
            srhTypOccuCd.setWidth(100);
            srhTypOccuCd.setHideLabel(true);
//            srhTypOccuCd.setFieldLabel("직종");
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
			                    
	                    }  }
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	//checkRemt0300Auth("srhTypOccuCd", lsTypOccuCd); 
	                	 }
                }
            });     
            
            srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
               @Override
              public void handleEvent(ComponentEvent ce) { 
                       
            	    //2015.11.30 추가 
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
//            srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//            srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//            srhDtilOccuInttnCd.setForceSelection(true);
//            srhDtilOccuInttnCd.setMinChars(1);
//            srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//            srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//            srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//            srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//            srhDtilOccuInttnCd.setSelectOnFocus(true); 
//            srhDtilOccuInttnCd.setReadOnly(false);
//            srhDtilOccuInttnCd.setEnabled(true);  
//            srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//          //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//            srhDtilOccuInttnCd.setLabelSeparator("");
           
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
            layoutContainer_21.setBorders(false);
            
            layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
           
            layoutContainer_10.setBorders(false); 
            
		    LayoutContainer layoutContainer_4 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_4.setLayout(frmlytSch);
		    
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
		    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		    
		    
//			layoutContainer_3.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));	// 정산구분
//			layoutContainer_3.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	// 부서
//			layoutContainer_3.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));// 직종
//		    layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 사업
		    
			layoutContainer_3.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 정산구분
			layoutContainer_3.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
			layoutContainer_3.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));// 직종
		    
		     
		    fieldSet.add(layoutContainer_3);
		    
	        LayoutContainer lcSchCol3 = new LayoutContainer();
	        lcSchCol3.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_16 = new LayoutContainer();
	        
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_16.setLayout(frmlytSch);
	        
	        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 사업
	        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));		// 성명
	        lcSchCol3.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 
	        
	        fieldSet.add(lcSchCol3);
	         
	         
	        plFrmRemt0300.add(fieldSet); 
	    //vp.add(panel);   
	  }  

	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
              
              //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                  
                  sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                  List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                  String strDeptCd = RemtUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                  sysComBass0350Dto.setDeptCd(strDeptCd);
                  List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                  String strTypOccuCd = RemtUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                  
                 // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                  
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                      
                      lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
                    //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                      
                      lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                          public void handleEvent(StoreEvent<BaseModel> be) {  
                              mDtalistDtilOccuInttnCd = RemtUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
          //직종변경에 따른 직종세 값 가져오기
//          String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//          if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//              sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//              sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//              if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                  lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//              }
//          }   
	  }    
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/   
  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 기본등록화면 입력 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/  
   
	   

  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 기본등록화면 입력 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/   
  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 
	 
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 


	  private void createCheckBoxGrid() {   
 
	       
	    FieldSet fieldSet1 = new FieldSet();  
	    fieldSet1.setHeadingHtml("퇴직소득지급내역");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	  //  lcStdGrid.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytStd = new FormLayout();  
	  //  frmlytStd.setLabelWidth(85); 
	   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(950, 505);  
	    
	    //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
	    remt3100GridPanel = new MSFGridPanel(remt3100Def, false, false, false, false);
	    remt3100GridPanel.getMsfGrid().setCellModel(true);
	    
	    remt3100GridPanel.setHeaderVisible(false);  
	    remt3100GridPanel.setBodyBorder(true);
	    remt3100GridPanel.setBorders(true);
	 //   remt3100GridPanel.setFrame(true); 
	 //   remt3100GridPanel.showExportButton(true); 
     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//	    remt3100GridPanel.getGrid().addListener(Events.Render, new Listener<BaseEvent>() {
//	        public void handleEvent(BaseEvent be)
//	        {
//	        	 remt3100GridPanel.getGrid().disableTextSelection(false);
//	        }
//	    });    
//	    remt3100GridPanel.getGrid().removeStyleName("x-unselectable"); 
	    
	    cpGrid.add(remt3100GridPanel); 
	    
	 
	    lcStdGrid.add(cpGrid);   
	    fieldSet1.add(lcStdGrid);   
	      
	    plFrmRemt0300.add(fieldSet1);
	     
	  }     
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
		public void reload() {
			// TODO Auto-generated method stub
			//선택된 데이터가 있는지 여부를 체크 함. 년도는 필수 선택임 
			if ( MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutYr01,"year")) && MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutYr02,"year")) ) { 
		          return;
			} else if ( MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutMnth01,"month")) && MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutMnth02,"month"))  ) { 
		          return;
			}
//			
//			if ( MSFSharedUtils.paramNull(srhApptnStdBgnnDt.getRawValue()) ) {
//				  MessageBox.alert("데이터 오류", "기준일자는 필수 선택사항입니다.", null);
//				  srhApptnStdBgnnDt.focus();
//		          return;
//			}
//			
		  if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
      	     if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
    			 
          			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
   	                         "사업명을 선택하십시요.", null);
            		 return;
    		     } 
           } 
		    
            IColumnFilter filters = null;
            remt3100GridPanel.getTableDef().setTableColumnFilters(filters);
             
            
            remt3100GridPanel.getTableDef().addColumnFilter("clutYrMnth01", (MSFSharedUtils.getSelectedComboValue(srhClutYr01,"year")+ MSFSharedUtils.getSelectedComboValue(srhClutMnth01,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
            remt3100GridPanel.getTableDef().addColumnFilter("clutYrMnth02", (MSFSharedUtils.getSelectedComboValue(srhClutYr02,"year")+ MSFSharedUtils.getSelectedComboValue(srhClutMnth02,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
            
            remt3100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            remt3100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            remt3100GridPanel.getTableDef().addColumnFilter("calcSevePayPsnDivCd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
          
            //remt3100GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            //remt3100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            String strDeptCd = RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            remt3100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
            String strTypOccuCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            remt3100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           // String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
           // remt3100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
            String strDtilOccuInttnCd = RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
            remt3100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
       
            
            remt3100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            remt3100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            remt3100GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
            remt3100GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
            
			remt3100GridPanel.reload();
		}
   

	       private void fnPopupPsnl0100()  {
	           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	           //검색.처리하면됨.
	          MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
	          //  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();  //우편번호 
	           
	           final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	           
	           popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
	               public void handleEvent(BaseEvent be) {
	                   BaseModel mapModel = (BaseModel)be.getSource();
	                   if (!"".equals(mapModel.get("systemkey"))) { 
	                        
	                       srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
	                       srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
	                       srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
	                   }  
	                  
	               }
	           });
	   }
	       
	       
	        
	       
	           
 public void setListRecord(Iterator<Record> records) {
    this.records = records;
 } 
 
  public void setRecord(BaseModel record) {
       this.record = record;
   }
 

   private Remt0300 getThis(){
       return this;
   }	   
 
   
   private void excelFileExport() {
       
       //  MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
         //    @Override
         //    public void handleEvent(MessageBoxEvent be) {
         //        if("Yes".equals(be.getButtonClicked().getText())){
                     
	  				  HashMap<String, String> param = new HashMap<String, String>(); 
   
	  				 String year01 = RemtUtils.getSelectedComboValue(srhClutYr01,"year");
	  	              String month01 = RemtUtils.getSelectedComboValue(srhClutMnth01,"month");
	  	               
	  	              String year02 = RemtUtils.getSelectedComboValue(srhClutYr02,"year");
	  	              String month02 = RemtUtils.getSelectedComboValue(srhClutMnth02,"month");
				      
					   param.put("clutYrMnth01", year01.concat(month01));
					   param.put("clutYrMnth02", year01.concat(month02));
						
			           param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			           param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
			           param.put("deptCd", RemtUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
			           param.put("typOccuCd", RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
			          // param.put("pyspGrdeCd", RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));
			           param.put("dtilOccuInttnCd", RemtUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			           param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
			           param.put("calcSevePayPsnDivCd",  RemtUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"));
			           param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
			           param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
			           param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
                      
	                      if(("".equals(year01) || "".equals(month01)) && ("".equals(year02) || "".equals(month02)) ){
	                          MessageBox.info("", "기간은 필수 입니다.", null);
	                      }else if("".equals(RemtUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"))){
	                          MessageBox.info("", "퇴직정산구분은 필수 입니다.", null);
	                
	                      } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
	                    	  
	                    	  if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
	                     			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	              	                         "사업명을 선택하십시요.", null);
	                       		 
	               		     } else { 
	                         
	                          remt3100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileRemt0300Export.do","extgwtFrame" ,param);   
	               		     }
	                      }else{ 
	                           
	                          remt3100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileRemt0300Export.do","extgwtFrame" ,param);  
	                      }
	                    
           //      }
       //      }
             
      //   });
          
         
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
