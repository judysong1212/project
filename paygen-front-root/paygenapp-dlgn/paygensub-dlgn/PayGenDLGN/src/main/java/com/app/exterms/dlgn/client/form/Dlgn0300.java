package com.app.exterms.dlgn.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.dlgn.client.form.defs.Dlgn0300Def;
import com.app.exterms.dlgn.client.languages.DlgnConstants;
import com.app.exterms.dlgn.client.service.Dlgn0300Service;
import com.app.exterms.dlgn.client.service.Dlgn0300ServiceAsync;
import com.app.exterms.dlgn.client.utils.DlgnUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0320;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
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
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.lookup.LookupSysComYear;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
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
import com.google.gwt.user.client.Window;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Dlgn0300 extends MSFPanel {

	

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
	  private DlgnConstants lblDlgnConst = DlgnConstants.INSTANCE;
	
 		
	  private VerticalPanel vp;
	  private FormPanel plFrmDlgn0300;
	//  private FormData formData; 
	  private String txtForm = "";  
	  
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	 
	  
	  private Dlgn0300Def dlgn0300Def  = new Dlgn0300Def();   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel dlgn0300GridPanel;
      
      
      //직종콤보
      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
      private MSFGridPanel typOccuCdGridPanel;
  
      //지급년도 
      private LookupSysComYear lkPayYr = new LookupSysComYear();  
      private MSFGridPanel payYrGridPanel;
      
      
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
      private ButtonBar topDlgn0300Bar;
      private Button btnDlgn0300New;
      private Button btnDlgn0300Save;
      private Button btnDlgn0300Del;
      private Button btnDlgn0300Sreach;
      private Button btnDlgn0300Excel;
      private Button btnDlgn0300Print;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
      private ComboBox<BaseModel> srhPayMonth;
     
      
      private ComboBox<BaseModel> srhPayCd;     //급여구분
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
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정
 
  	  private Boolean emptyCheck = false ;
      private boolean mutilCombo = false;
      
     
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
     
       
      //중간 근태생성 부분 끝
      //파일업로드처리 부분  
//      private FileUploadField dlgn0300flUp;
//      private List<ModelData> mDtalistcrDeptCd ;
//      private List<ModelData> mDtalistcrTypOccuCd ;
//      private List<ModelData> mDtalistcrDtilOccuInttnCd ;
//      
//      private boolean mutilcrCombo = false;
	private String systemKeys;
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
		  private void checkDlgn0300Auth( String authAction, ListStore<BaseModel> bm) {   
	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
			   //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
				  
				   //----------------------------------------------------
				   if (!maskTracker) { unmask(); }  
				   authExecEnabled() ;
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
		          
	                 
			   }
		  }
		  private void authExecEnabled() { 
			   //------------------
			  Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd };
              
			   gwtAuthorization.formAuthFieldConfig(fldArrField);
			   
               //MSFMainApp.unmaskMainPage();
			    
			   srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()))); 
	           srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
              srhPayCd.setValue(lsPayCd.getAt(0)); 
           	 
              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			//   gwtAuthorization.formAuthConfig(plFrmDlgn0300, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 종료
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
              srhDeptCd.getListView().fireEvent(Events.CheckChanged);
                
			 }

		   final Timer tmMask = new Timer()
		     {
		           public void run()
		           {
		              // if (maskTracker)
		              // { 
		        	  
		        	   if (lsEmymtDivCd.getCount() > 0 && lsPayYrStore.getCount() > 0) {
		        		   
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
			     
                 authMapDef.put("srhPayYr",Boolean.FALSE); 
                 authMapDef.put("srhPayMonth",Boolean.FALSE); 
                 authMapDef.put("srhPayCd",Boolean.FALSE); 
                 
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
     private Dlgn0300ServiceAsync payr0250Service = Dlgn0300Service.Util.getInstance();
      
      private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
      private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
      
      private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분
      private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
      
       //--------------------부서 불러 오는 함수 ------------------------------------------------
      private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
       //--------------------부서 불러 오는 함수 ------------------------------------------------
      private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
      
      //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
     //--------------------사업 불러 오는 함수 -------------------------------------------------
      private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
      private ListStore<BaseModel> lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  		
		
      private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();//직종 
      private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
      private ListStore<BaseModel> lsPayCd = new ListStore<BaseModel>(); //급여구분
      
      private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
      private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
      private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
      private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
      private SysCoCalendarDTO  msfCoCalendarDto;  
      private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
      private PrgmComBass0320DTO sysComBass0320Dto;  //직종
     
      private BaseModel record;
  
      private  Iterator<Record> records;
  	 
      
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
			    createCheckBoxGrid();  //근무실적 
			    vp.setSize("1010px", "700px"); 
			    
			    
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
	  public Dlgn0300() {
		    
			setSize("1010px", "700px");  
	  } 
	
	  public Dlgn0300(String txtForm) {
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
		  
		plFrmDlgn0300 = new FormPanel();
		plFrmDlgn0300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  근태월별집계")); //+ lblDlgnConst.title_Dlgn0300());
	 
		plFrmDlgn0300.setIcon(MSFMainApp.ICONS.text());
		plFrmDlgn0300.setPadding(2);
		plFrmDlgn0300.setBodyStyleName("pad-text");
		plFrmDlgn0300.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("근태월별집계","DLGN0300");
				}
			});
		plFrmDlgn0300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmDlgn0300.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		//멀티콤보박스 닫기 
		plFrmDlgn0300.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) { 
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
        
		 topDlgn0300Bar = new ButtonBar();    
		 topDlgn0300Bar.setAlignment(HorizontalAlignment.RIGHT);
 
		 
//	   //신규 
//        btnDlgn0300New = new Button("신규");  
//        btnDlgn0300New.setIcon(MSFMainApp.ICONS.new16());
//        topDlgn0300Bar.add(btnDlgn0300New);
//        btnDlgn0300New.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//                //초기화 버튼 클릭시 처리     
//                dlgn0300GridPanel.getMsfGrid().clearData();
//                fnPopupPsnl0110();   
//                 
//            }
//        });
//        //저장 -신규/수정 동시 처리 부분으로 나뉨 
//        btnDlgn0300Save = new Button("저장");  
//        btnDlgn0300Save.setIcon(MSFMainApp.ICONS.save16());
//        topDlgn0300Bar.add(btnDlgn0300Save); 
//        btnDlgn0300Save.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//                
//                setListRecord(dlgn0300GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
//                doAction(actionDatabase); 
//                 
//            }
//        });
//       
//        //삭제       
//        btnDlgn0300Del = new Button("삭제");  
//        btnDlgn0300Del.setIcon(MSFMainApp.ICONS.delete16());
//        topDlgn0300Bar.add(btnDlgn0300Del);
//        btnDlgn0300Del.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) {
//                
//                Iterator<BaseModel> itBm  = dlgn0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
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
        
	  
	  	btnDlgn0300Sreach = new Button("조회"); 
	  	btnDlgn0300Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topDlgn0300Bar.add(btnDlgn0300Sreach);
	  	btnDlgn0300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//조회버튼 클릭시 처리 
    		    reload();  
    		}
    	});
	  	
	  	btnDlgn0300Excel = new Button("엑셀"); 
	  	btnDlgn0300Excel.setIcon(MSFMainApp.ICONS.excel16());
	  	topDlgn0300Bar.add(btnDlgn0300Excel);
	  	btnDlgn0300Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//엑셀저장  
    			excelFileExport();
    		}
    	});
	  	
//	  	btnDlgn0300Print = new Button("인쇄");
//	  	btnDlgn0300Print.setIcon(MSFMainApp.ICONS.text());
//	  	topDlgn0300Bar.add(btnDlgn0300Print);
//		btnDlgn0300Print.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				RexPrint("DlgnP030001");
//			}
//		});
	  	
	  	
//	  	topBtn = new Button("인쇄"); 
//	  	topBtn.setIcon(MSFMainApp.ICONS.text()); 
//	  	buttonBar.add(topBtn);  
	  	
	  	plFrmDlgn0300.add(topDlgn0300Bar);    	
	  	
		vp.add(plFrmDlgn0300);
		plFrmDlgn0300.setSize("990px", "690px");
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

		//TODO 검색필드 시작
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
		    sysComBass0300Dto.setRpsttvCd("B015");
		    lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
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
			lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
		         
			lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
			
			 //-------------------관리부서 추가  
			sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
			lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
			
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			sysComBass0400Dto.setDeptDspyYn("Y");
			sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
			sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	         
			lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	         
			lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
				public void handleEvent(StoreEvent<BaseModel> be) {  
					mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
	                srhDeptCd.getInitStore().add(mDtalistDeptCd);
				}
			});  
	          
			lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
				public void handleEvent(StoreEvent<BaseModel> be) {  
					mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
					srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
				}
			});  
		             
			/**
			 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		     * 년도 콤보박스 처리  시작
		     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
		     */

			plFrmDlgn0300.setLayout(new FlowLayout());
		        
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
		    // lcSchLeft.setStyleAttribute("paddingRight", "10px"); 
		     
		    fieldSet.add(lcSchCol, new FormData("100%"));  
		    lcSchLeft.setLayout(new ColumnLayout());
		        
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_8.setLayout(frmlytSch);
		        
		    srhPayYr = new ComboBox<BaseModel>();
		    srhPayYr.setName("srhPayYr");
		    srhPayYr.setForceSelection(true);
		 	srhPayYr.setMinChars(1);
		    srhPayYr.setDisplayField("yearDisp");
		    srhPayYr.setValueField("year");
		    srhPayYr.setTriggerAction(TriggerAction.ALL);
		   // srhPayYr.setEmptyText("--년도선택--");
		    srhPayYr.setSelectOnFocus(true); 
		    srhPayYr.setReadOnly(false);
		    srhPayYr.setEnabled(true); 
		    srhPayYr.setStore(lsPayYrStore);
		    srhPayYr.setFieldLabel("작업년월"); 
		    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		    	public void handleEvent(StoreEvent<BaseModel> be) {   
		    		EventType type = be.getType();
		    			if (type == Store.Add) { 
		    				/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		    				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				             * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
								++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    					checkDlgn0300Auth("srhPayYr", lsPayYrStore); 
		    			}
		    		}
		    	});
		    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		    		BaseModel bmPayYr =  se.getSelectedItem(); 
		    			if (bmPayYr != null) {
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
		                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
		                      // return;
		                   } 
		    			}       
		    		} 
		    	});   
		    	layoutContainer_8.add(srhPayYr, new FormData("100%"));
		        lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.74));
		        layoutContainer_8.setBorders(false);
		        
		        LayoutContainer layoutContainer_9 = new LayoutContainer();
		        frmlytSch = new FormLayout();  
		        frmlytSch.setLabelWidth(0); 
		        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		        layoutContainer_9.setLayout(frmlytSch);
		        
		        /** column 지급년월 : Mnth */ 
		        srhPayMonth = new ComboBox<BaseModel>();
		        srhPayMonth.setName("srhPayMonth");
		        srhPayMonth.setForceSelection(true);
		        srhPayMonth.setMinChars(1);
		        srhPayMonth.setDisplayField("monthDisp");
		        srhPayMonth.setValueField("month");
		        srhPayMonth.setTriggerAction(TriggerAction.ALL);
		       // srhPayMonth.setEmptyText("--월선택--");
		        srhPayMonth.setSelectOnFocus(true); 
		        srhPayMonth.setReadOnly(false);
		        srhPayMonth.setEnabled(true); 
		        srhPayMonth.setStore(lsPayMonth);
		        srhPayMonth.setHideLabel(true);
		        srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        	public void handleEvent(StoreEvent<BaseModel> be) {  
		        		checkDlgn0300Auth("srhPayMonth", lsPayMonth); 
		        	}
		        });
		        layoutContainer_9.add(srhPayMonth, new FormData("100%"));
		        lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
		        layoutContainer_9.setBorders(false);
		        
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
		        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				 				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		        				checkDlgn0300Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
		        		}
		            }
		        });    
		        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		        		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
		        		sysComBass0400Dto = new PrgmComBass0400DTO(); 
		        		srhDeptCd.reset();  //2015.12.07 추가 
		        		sysComBass0400Dto.setDeptDspyYn("Y");
		                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
		  	    		
		                //--------------------부서 불러 오는 함수 ------------------------------------------------
		                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		                //--------------------부서 불러 오는 함수 ------------------------------------------------
		                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		                	public void handleEvent(StoreEvent<BaseModel> be) {  
		                		mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
		                		srhDeptCd.getInitStore().add(mDtalistDeptCd);
		                	}
		                });   
		            } 
		        });
		        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
		        layoutContainer.setBorders(false);
		        
		        
		        LayoutContainer layoutContainer_14 = new LayoutContainer(new ColumnLayout());
		        layoutContainer_14.setBorders(false); 
		        
		        LayoutContainer layoutContainer_111 = new LayoutContainer();
		        
		        frmlytSch = new FormLayout();  
		        frmlytSch.setLabelWidth(60); 
		        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		        layoutContainer_111.setLayout(frmlytSch);
		        
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
		        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		  						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		        				checkDlgn0300Auth("srhEmymtDivCd", lsEmymtDivCd ); 
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
		        layoutContainer_111.add(srhEmymtDivCd, new FormData("100%"));
		        layoutContainer_111.setBorders(false); 
		        
		        layoutContainer_111.add(srhEmymtDivCd, new FormData("100%"));
		        layoutContainer_14.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		        
		        
			    LayoutContainer layoutContainer_101 = new LayoutContainer();
				layoutContainer_101.setBorders(false);

			    frmlytSch = new FormLayout();  
			    frmlytSch.setDefaultWidth(0);
//			    frmlytSch.setLabelWidth(0); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_101.setLayout(frmlytSch);
			    
			    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
			    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
			    srhRepbtyBusinDivCd.setForceSelection(true);
			    srhRepbtyBusinDivCd.setHideLabel(true);
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
//			    creRepbtyBusinDivCd.setLabelSeparator("");
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
//		        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//		        	@Override
//		        	public void handleEvent(BaseEvent be) {  
//		        		if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//		        			srhSystemkey.setValue("");
//		        			srhResnRegnNum.setValue("");
//		        		}
//	             	} 
//		        }); 
		        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		        layoutContainer_6.setBorders(false);
		        
		        LayoutContainer layoutContainer_btn = new LayoutContainer();
		        frmlytSch = new FormLayout();  
		        frmlytSch.setLabelWidth(0); 
		        layoutContainer_btn.setLayout(frmlytSch);
		        
		        Button btnHanNm = new Button("검색");
//		        layoutContainer_5.add(btnHanNm);
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
		        frmlytSch.setLabelWidth(0); 
		        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		        layoutContainer_7.setLayout(frmlytSch);
		        
		        /** column 주민등록번호 : resnRegnNum */
		        srhResnRegnNum = new TextField<String>();
		        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");  
		        srhResnRegnNum.setName("srhResnRegnNum");
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
		        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
		        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		        layoutContainer_7.setBorders(false); 
		        layoutContainer_5.setBorders(false);
		        
//		        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 			// 작업년월
//		        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24)); // 급여구분
//		        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));	// 단위기관
//		        lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명, 주민등록번호
		        
		        
		        
		        lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 작업년월
		        lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); // 단위기관
		        lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
		        
		        
		        
		        LayoutContainer layoutContainer_13 = new LayoutContainer();
		        layoutContainer_13.setLayout(new ColumnLayout());
		        
				//관리부서 
				LayoutContainer lcSch2_1 = new LayoutContainer();
				FormLayout frmlytSch2_1 = new FormLayout();
				frmlytSch2_1.setLabelWidth(60);
				frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
				lcSch2_1.setLayout(frmlytSch2_1);
				
				srhMangeDeptCd = new ComboBox<BaseModel>();
				srhMangeDeptCd.setName("srhMangeDeptCd"); 
				srhMangeDeptCd.setEmptyText("--관리부서선택--");
				srhMangeDeptCd.setDisplayField("deptNmRtchnt");
				srhMangeDeptCd.setStore(lsMangeDeptCd); 
				srhMangeDeptCd.setWidth(100);
				srhMangeDeptCd.setFieldLabel("관리부서");
				srhMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		        srhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		        srhMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	EventType type = be.getType();
		            	if (type == Store.Add) { 
		            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		            		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
		            	}
		            }
		        });  
		        srhMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
			    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
			    		sysComBass0400Dto = new PrgmComBass0400DTO();
		  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
		  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
		  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
		  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
		  	    		
		  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
		  	    				mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
		  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
		  	    			}
		  	    		});  
		  	    		emptyCheck = true;
			    	} 
			    });
		        srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
		            @Override
		            public void handleEvent(ComponentEvent ce) {    
		            	
		                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
		                	
		                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
			                	sysComBass0400Dto = new PrgmComBass0400DTO();
			      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
			      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
			      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
			      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
			      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
			      	    		
			      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
			      	    				mDtalistDeptCd = DlgnUtils.getDeptCdModelData(lsDeptCd) ; 
			      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			      	    			} 
			      	    			
			      	    		}); 
			      	    		emptyCheck = false;
		                	}
		                 }  
		            } 
		        });   
		       
		        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
		        
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
		        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				         	 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		        				checkDlgn0300Auth("srhDeptCd", lsDeptCd); 
		        		}
		        	}
		        });    

		        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
		        	@Override
		        	public void handleEvent(ComponentEvent ce) { 
		        		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
		        			PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
		        			sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")); 
		        			List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
		        			sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
	  		                  
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
		        			String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			       	 		sysComBass0320Dto.setDeptCd(strDeptCd);
			       	 		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			       	 		lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			       	 			public void handleEvent(StoreEvent<BaseModel> be) {  
			       	 				mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
			       	 				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			       	 			}
			       	 		});  
		        		} else {
		        			sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		        			String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		        			sysComBass0320Dto.setDeptCd(strDeptCd);
		        			lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		        			lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		        				public void handleEvent(StoreEvent<BaseModel> be) {  
		        					mDtalistTypOccuCd = DlgnUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
//		        frmlytSch.setLabelWidth(60); 
		        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		        layoutContainer_21.setLayout(frmlytSch);
		       
		        
		        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		        srhTypOccuCd.setName("srhTypOccuCd"); 
		        srhTypOccuCd.setEmptyText("--직종선택--"); 
		        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		        srhTypOccuCd.setWidth(100);
		        srhTypOccuCd.setHideLabel(true);
//		        srhTypOccuCd.setFieldLabel("직종");
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
				    			   srhTypOccuCd.getListView().setChecked(mdSelect, true); 
				    			   srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
				                    
				    		   }  
				    		   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
			    			  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			    			   * 권한설정을 위한 콤보처리를 위한 메서드 시작 
			    			   * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			    			   * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			         			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	//checkDlgn0300Auth("srhTypOccuCd", lsTypOccuCd); 
			    			  }
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
		        
		        lcTypOccuCd.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		        
		        layoutContainer_21.setBorders(false);
		        
		        
		        
		     
//		        layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
//		        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
//		        layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
		        
		        
		        layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		        layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		        layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		        
		        
		        fieldSet.add(layoutContainer_13);
		        
		        
		        
		        LayoutContainer lcSchCol3 = new LayoutContainer();
		        lcSchCol3.setLayout(new ColumnLayout());
	
		        LayoutContainer layoutContainer_1 = new LayoutContainer();
		        layoutContainer_1.setBorders(false);
		        
		        frmlytSch = new FormLayout();  
		        frmlytSch.setLabelWidth(60); 
		        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		        layoutContainer_1.setLayout(frmlytSch);
		        
		        srhPayCd =  new ComboBox<BaseModel>(); 
		        srhPayCd.setName("srhPayCd");
		        srhPayCd.setForceSelection(true);
		        srhPayCd.setMinChars(1);
		        srhPayCd.setDisplayField("commCdNm");
		        srhPayCd.setValueField("commCd");
		        srhPayCd.setTriggerAction(TriggerAction.ALL);
		        srhPayCd.setEmptyText("--급여구분선택--");
		        srhPayCd.setSelectOnFocus(true); 
		        srhPayCd.setReadOnly(false);
		        srhPayCd.setEnabled(true); 
		        srhPayCd.setStore(lsPayCd);
		        srhPayCd.setFieldLabel("급여구분");
		        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		           	   EventType type = be.getType();
			    	   if (type == Store.Add) { 
	             		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	             		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	             		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	             		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			    			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			    		   checkDlgn0300Auth("srhPayCd", lsPayCd); 
			    	   }
		            }
		        });    
		        
		        layoutContainer_1.add(srhPayCd, new FormData("100%"));
		        
		        
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
		        layoutContainer_4.setBorders(false);
		        
		        
		        
//		        LayoutContainer layoutContainer_16 = new LayoutContainer();
//		        
//		        frmlytSch = new FormLayout();  
//		        frmlytSch.setLabelWidth(0); 
//		        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		        layoutContainer_16.setLayout(frmlytSch);
		        
		        lcSchCol3.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 사업
		        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 성명
		        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));// 
		        
		        
		        fieldSet.add(lcSchCol3, new FormData("100%"));
		        
		        
		        layoutContainer_13.setBorders(false);
		        
		        plFrmDlgn0300.add(fieldSet); 
		} 
      
	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
              
              //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                  
                  sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                  List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                  String strDeptCd = DlgnUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                  sysComBass0350Dto.setDeptCd(strDeptCd);
                  List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                  String strTypOccuCd = DlgnUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                  
                 // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                  
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                      
                      lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
                    //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                      
                      lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                          public void handleEvent(StoreEvent<BaseModel> be) {  
                              mDtalistDtilOccuInttnCd = DlgnUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
	    fieldSet1.setHeadingHtml("근무실적");
	    fieldSet1.setSize("965px", "527px");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	    lcStdGrid.setStyleAttribute("paddingLeft", "5px");
	    lcStdGrid.setStyleAttribute("paddingRight", "5px");
	    FormLayout frmlytStd = new FormLayout();  
	  //  frmlytStd.setLabelWidth(85); 
	   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(955, 500);  
	    
	    //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
	  //  dlgn0300GridPanel = new MSFGridPanel(dlgn0300Def, false, false, false, false,MSFGridType.GROUPBY,"deptNm");
	    dlgn0300GridPanel = new MSFGridPanel(dlgn0300Def, false, false, false, false);
	  //   dlgn0300GridPanel.getMsfGrid().setCellModel(true);
	    
	    dlgn0300GridPanel.setHeaderVisible(false);  
	    dlgn0300GridPanel.setBodyBorder(true);
	    dlgn0300GridPanel.setBorders(true);
	    
	    
	    dlgn0300GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 6, new HeaderGroupConfig("실근무일수", 1, 4));
	    dlgn0300GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 21, new HeaderGroupConfig("휴일근무", 1, 3));
	    dlgn0300GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 28, new HeaderGroupConfig("시간외 근무", 1, 3));
 
	    
	 //   dlgn0300GridPanel.setFrame(true); 
	 //   dlgn0300GridPanel.showExportButton(true); 
     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//	    dlgn0300GridPanel.getGrid().addListener(Events.Render, new Listener<BaseEvent>() {
//	        public void handleEvent(BaseEvent be)
//	        {
//	        	 dlgn0300GridPanel.getGrid().disableTextSelection(false);
//	        }
//	    });    
//	    dlgn0300GridPanel.getGrid().removeStyleName("x-unselectable"); 
	    
	    cpGrid.add(dlgn0300GridPanel); 
	    
	 
	    lcStdGrid.add(cpGrid);   
	    fieldSet1.add(lcStdGrid);   
	      
	    plFrmDlgn0300.add(fieldSet1);
	     
	  }     
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
		public void reload() {
			// TODO Auto-generated method stub
			//선택된 데이터가 있는지 여부를 체크 함. 년도는 필수 선택임 
			if ( MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")) ) { 
		          return;
			} else if ( MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")) ) { 
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
            dlgn0300GridPanel.getTableDef().setTableColumnFilters(filters);
             
            dlgn0300GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
            dlgn0300GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            dlgn0300GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            dlgn0300GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
          
          //20180305추가 
            dlgn0300GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
    		
            //dlgn0300GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            //dlgn0300GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            String strDeptCd = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            dlgn0300GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
            String strTypOccuCd = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            dlgn0300GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           // String strPyspGrdeCd = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
           // dlgn0300GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
            String strDtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
            dlgn0300GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
       
            
            dlgn0300GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
            dlgn0300GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
            dlgn0300GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
            dlgn0300GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
            
			dlgn0300GridPanel.reload();
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
 

   private Dlgn0300 getThis(){
       return this;
   }	   
 
   
   private void excelFileExport() {
       
       //  MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
         //    @Override
         //    public void handleEvent(MessageBoxEvent be) {
         //        if("Yes".equals(be.getButtonClicked().getText())){
	    // if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                     
	  				  HashMap<String, String> param = new HashMap<String, String>(); 
   
	  				  String year = DlgnUtils.getSelectedComboValue(srhPayYr,"year");
	  	              String month = DlgnUtils.getSelectedComboValue(srhPayMonth,"month");
	  	               
	   
				      
					   param.put("pymtYrMnth", year.concat(month));
						
			           param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			           param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
			           param.put("deptCd", DlgnUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
			           param.put("typOccuCd", DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
			        //   param.put("pyspGrdeCd", DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));
			           param.put("dtilOccuInttnCd", DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			           param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
			           param.put("payCd",  DlgnUtils.getSelectedComboValue(srhPayCd,"commCd"));
			           param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
			           param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
			           param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
                     
                     
			           
	                      if("".equals(year) || "".equals(month)){
	                          MessageBox.info("", "작업년월은 필수 입니다.", null);
	                      }else if("".equals(DlgnUtils.getSelectedComboValue(srhPayCd,"commCd"))){
	                          MessageBox.info("", "급여구분은 필수 입니다.", null);
	                
	                      } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
	                    	  
	                    	  if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
	                     			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	              	                         "사업명을 선택하십시요.", null);
	                       		 
	               		     } else { 
	                         
	                          dlgn0300GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileDlgn0300Export.do","extgwtFrame" ,param);   
	               		     }
	                      }else{ 
	                           
	                          dlgn0300GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileDlgn0300Export.do","extgwtFrame" ,param);  
	                      }
	                    
           //      }
       //      }
             
      //   });
          
         
	  }	 

	private void DlgnP0300Print(String fileName, String repType) {
		if(PayGenConst.REPORT_DIV_TYPE02.equals(repType.trim())) {
			RdaPrint(fileName);
		} else if(PayGenConst.REPORT_DIV_TYPE01.equals(repType.trim())) {
			RexPrint(fileName);
		} else {
			Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		}
	}
	
	private void RdaPrint(String fileName) {
		
	}
	
	private void RexPrint(String fileName) {
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
		System.out.println("출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR");
		String strDirPath = "DLGN";
		
		// reb 출력물
		String rexFileName = fileName + ".crf";
//		String rexFileName = fileName + ".reb";
		
		// 보낼 파라미터
		
		// 검색조건
		String serarchParam = "";
		
		String year	 = DlgnUtils.getSelectedComboValue(srhPayYr,	"year");
		String month = DlgnUtils.getSelectedComboValue(srhPayMonth,	"month");
		
		String pymtYrMnth	   = year.concat(month);
		String payCd		   = DlgnUtils.getSelectedComboValue(srhPayCd, "commCd");
 		String payrMangDeptCd  = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd");
		String emymtDivCd	   = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd");
		String deptCd		   = DlgnUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
		String typOccuCd	   = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
//		String pyspGrdeCd	   = DlgnUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "pyspGrdeCd");
		String dtilOccuInttnCd = DlgnUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
		String businCd		   = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd");
		String hanNm		   = MSFSharedUtils.allowNulls(srhHanNm.getValue());
		String resnRegnNum	   = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 

		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
		
		String deptCdAuth	   = MSFSharedUtils.allowNulls(DlgnUtils.getStrValToBMMultiCombo(  lsDeptCd
																							 , MSFSharedUtils.allowNulls(srhDeptCd.getValue())
																							 , "deptNmRtchnt", "deptCd"
																							)
														  ).replace(",", "");
		String dtilOccuInttnCdAuth = MSFSharedUtils.allowNulls(DlgnUtils.getStrValToBMMultiCombo(  lsDtilOccuInttnCd
																								 , MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue())
																								 , "dtilOccuClsNm"
																								 , "dtilOccuInttnCd")).replace(",", "");

		//그리드 선택 데이터 출력
		System.out.println("그리드 선택 데이터 출력");
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = dlgn0300GridPanel.getGrid().getSelectionModel().getSelectedItems();

		if(list != null && list.size() > 0) {
			String chkSysKey = "";
			int iCnt = 0;

			for(BaseModel bm : list){
				chkSysKey += bm.get("systemkey") + ",";
				iCnt = iCnt + 1;
			}
			keyCnt = iCnt;
			checkedSystemKeys = chkSysKey.substring(0, chkSysKey.length() - 1); //$10 시스템키
			System.out.println("시스템키는 넘기지 않고 검색조건만 넘김");
			//시스템키는 넘기지 않고 검색조건만 넘김
			if(keyCnt > 200) {
				MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.", new Listener<MessageBoxEvent>() {
					@Override
					public void handleEvent(MessageBoxEvent be) {
						// TODO Auto-generated method stub
						//if("Yes".equals(be.getButtonClicked().getText())) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							systemKeys = "";
						} else {
							return;
						}
					}
				});
				System.out.println("선택한 시스템키 넘김");
				//선택한 시스템키 넘김
			} else {
				systemKeys = checkedSystemKeys;
			}
		}
//		if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)) {
		
			//도장 출력을 위해 추가 2014-11-06 //$9
			String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
			if(MSFSharedUtils.paramNull(myImgUrl)) {
			// myImgUrl = "http://105.19.10.32:8080";
			//경로오류 출력
			}
			
			serarchParam += "" + MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())	+ "⊥";	/*$1							*/
			serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$2  기간검색시작				*/
			serarchParam += "" + MSFSharedUtils.allowNulls("")										+ "⊥";	/*$3  기간검색종료				*/
			serarchParam += "" + MSFSharedUtils.allowNulls(payrMangDeptCd)							+ "⊥";	/*$4  단위기간					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(emymtDivCd)								+ "⊥";	/*$5  고용구분					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(deptCd)									+ "⊥";	/*$6  부서코드					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(typOccuCd)								+ "⊥";	/*$7  직종						*/
			serarchParam += "" + MSFSharedUtils.allowNulls(dtilOccuInttnCd)							+ "⊥";	/*$8  직종세						*/
			serarchParam += "" + MSFSharedUtils.allowNulls(businCd)									+ "⊥";	/*$9  사업코드					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(systemKeys)								+ "⊥";	/*$10 시스템키					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(hanNm)									+ "⊥";	/*$11 성명						*/
			serarchParam += "" + MSFSharedUtils.allowNulls(resnRegnNum)								+ "⊥";	/*$12 주민번호					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(payCd)									+ "⊥";	/*$13 급여구분					*/
			
			/* 20151212-변경추가 시작				*/
			serarchParam += "" + MSFMainApp.get().getUser().getUsrId()								+ "⊥"; /*$14 유저 아이디					*/
			serarchParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn()						+ "⊥";	/*$15 관리자 유무					*/
			
			/* 권한처리를위해 넘기는 변수 2개추가	*/
			serarchParam += "" + deptCdAuth															+ "⊥";	/*$16 부서						*/
			serarchParam += "" + dtilOccuInttnCdAuth												+ "⊥";	/*$17 직종세						*/
			
			/* 20151212-추가 끝					*/
			serarchParam += "" + MSFSharedUtils.allowNulls(myImgUrl)								+ "⊥";	/*$18 직인경로					*/
			serarchParam += "0⊥";																			/*$19 단건 1 복수건 0 프린트 추가	*/
			serarchParam += "" + year																+ "⊥";	/*$20 년							*/
			serarchParam += "" + pymtYrMnth															+ "⊥";	/*$21 년월						*/
			serarchParam += "" + month																+ "⊥";	/*$21 월							*/
			
			String strParam = "" + serarchParam ;
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);

		//}else{
		//	MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
		//}
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
