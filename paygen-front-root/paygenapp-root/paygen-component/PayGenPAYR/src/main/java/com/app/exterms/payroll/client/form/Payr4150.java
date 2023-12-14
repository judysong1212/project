package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.form.defs.Payr0250Def;
import com.app.exterms.payroll.client.form.defs.Payr0301Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.service.Payr4150Service;
import com.app.exterms.payroll.client.service.Payr4150ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
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
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
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
public class Payr4150  extends MSFPanel { 



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
	   private PayrConstants lblPayrConst = PayrConstants.INSTANCE;
	
	 
	  private VerticalPanel vp;
	  private FormPanel plFrmPayr4150;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp;
	 
	  
	  private Payr0250Def payr0250Def  = new Payr0250Def("PAYR4150");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0250GridPanel;
	  
	  private Payr0301Def payr0301Def  = new Payr0301Def("PAYR4150");   //그리드 테이블 컬럼 define  
	  // private MSFCustomForm msfCustomForm; 
	 private MSFGridPanel payr0301GridPanel;
	  
	
	  //직종콤보
//	  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	  private MSFGridPanel typOccuCdGridPanel;
	
	  //지급년도 
	  private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
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
      private ButtonBar topPayr4150Bar;
      private Button btnPayr4150Init;
      //private Button btnPayr4150Save;
      //private Button btnPayr4150Del;
      private Button btnPayr4150Sreach;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
      private ComboBox<BaseModel> srhPayMonth;
     
//      private ComboBox<BaseModel> srhTypOccuCd; //직종 
//      private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
//      private HiddenField<String> srhPyspGrdeCd; //직종 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드	
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세  
      
      private ComboBox<BaseModel> srhPayCd;     //급여구분
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
//      private TextField<String> srhDeptCd; //부서코드
//      private TextField<String> srhDeptNm; //부서명  
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정  
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      private List<ModelData> mDtalistHdofcCodtnCd ; 
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

      private Boolean emptyCheck = false ;
      private boolean mutilCombo = false;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      private HiddenField<String> dpobCd;  //사업장코드 
      private TextField<String> creHanNm;         //성명
      private TextField<String> creResnRegnNum;   //주민번호  
      private HiddenField<String> creSystemkey;   //시스템키
     
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
		  private void checkPayr4150Auth( String authAction, ListStore<BaseModel> bm) {   
	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
			   //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
				   if (!maskTracker) { 
					   unmask();
					   authExecEnabled() ;
				}  
	                //MSFMainApp.unmaskMainPage(); 
	                 
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
	                 
			   }
		  }
		  
		  private void authExecEnabled() { 
			   //------------------
			  //----------------------------------------------------
              Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};
              
        	  gwtAuthorization.formAuthFieldConfig(fldArrField); 
        	    
        	   srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
        	  
  	           srhPayCd.setValue(lsPayCd.getAt(0));
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
               // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
                //GWTAuthorization.formAuthPopConfig(plFrmPayr4150, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
                //GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			  // gwtAuthorization.formAuthConfig(plFrmPayr4150, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
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
			     
			     authMapDef.put("srhPayYr",Boolean.FALSE);
			     authMapDef.put("srhPayMonth",Boolean.FALSE);
			     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
			     authMapDef.put("srhPayCd",Boolean.FALSE); 
			     authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
			     authMapDef.put("srhDeptCd",Boolean.FALSE);  
			   //  authMapDef.put("srhTypOccuCd",Boolean.FALSE);     
				 
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
      
	   //화면 폼 바인딩 처리 
	    private void setPayr4150FormBinding() {
	 	 
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
	//입력수정삭제처리 rpc 처리부     
	    private Payr4150ServiceAsync payr4150Service = Payr4150Service.Util.getInstance();	    
	  
	    private ListStore<BaseModel> lsPayYrStore 		= new ListStore<BaseModel>();  	// 년도 
  		private ListStore<BaseModel> lsPayMonth 		= new ListStore<BaseModel>();  	// 급여월   
  		
  		private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분 
  		private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	// 호봉제구분코드 
  		
  		//--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsDeptCd  			= new ListStore<BaseModel>();	// 부서콤보
  		//--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
  		//--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel> lsBusinCd  		= new ListStore<BaseModel>();	// 사업콤보   
  		//--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	// 단위기관 
  		private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	// 부서직종그룹코드  	
  		private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	// 직종 
  		private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>(); 	// 급여구분
  		
  		private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	// 직종세
  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
  		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
  		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
  		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
  		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
  		private PrgmComBass0320DTO sysComBass0320Dto;	//직종
  		
  		private SysCoCalendarDTO  msfCoCalendarDto;  
   
	    private BaseModel record; 
	
	    private Iterator<Record>  records;
   
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
 
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				 
				 //콤보 권한초기화
				   initLoad(); 
			      
			        detailTp = XTemplate.create(getDetailTemplate());
			    
				   // formData = new FormData("-650");
				    vp = new VerticalPanel();
				    vp.setSpacing(10);
				    createPayr4150Form();  //화면 기본정보를 설정
				    createSearchForm();    //검색필드를 적용
				    createStandardForm();    //기본정보필드  
				    vp.setSize("1010px", "700px");
				    
				    /**
			          * Create the relations 
			          */
					   final RelationDef  relPayr0250 = new RelationDef(payr0250Def);
					   relPayr0250.addJoinDef("dpobCd", "dpobCd");
					   relPayr0250.addJoinDef("payCd", "payCd");
					   relPayr0250.addJoinDef("jobYrMnth", "pymtYrMnth"); 
					   relPayr0250.addJoinDef("payScduSeilNum", "payrSeilNum"); 
					   relPayr0250.addJoinDef("emymtDivCd", "emymtDivCd");
		               relPayr0250.addJoinDef("deptCd", "deptCd");
		               relPayr0250.addJoinDef("businCd", "businCd");
		               relPayr0250.addJoinDef("typOccuCd", "typOccuCd");
		               //relPayr0250.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
		               relPayr0250.addJoinDef("payrMangDeptCd", "payrMangDeptCd");
		               relPayr0250.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
					   relPayr0250.setLinkedObject(payr0250GridPanel);
					   payr0301Def.addRelation(relPayr0250); 
			           
			  
			           // DETAILS 
			           final Grid payr0250Grid = payr0250GridPanel.getMsfGrid().getGrid();
			           payr0250Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			              public void handleEvent(BaseEvent be) {  
			            	  if (payr0250GridPanel.getCurrentlySelectedItem() != null) { 
			            		 
			            		  payr0301Def.synchronizeGridDetail(
			            				  payr0250GridPanel.getCurrentlySelectedItem(),
			            				  payr0301GridPanel ); 
			            		  
			            		 // payr0301GridPanel.reload(); 
			            	   }
			            	 
			                
			              }
			          }); 

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
	  public Payr4150() {
		  
		   
			setSize("1010px", "700px");  
	  } 
	
	  public Payr4150(String txtForm) {
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
	  private void createPayr4150Form() {
		  
		plFrmPayr4150 = new FormPanel();
		plFrmPayr4150.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr4150());
		//plFrmPayr4150.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여계산관리");
		plFrmPayr4150.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr4150.setBodyStyleName("pad-text");
		plFrmPayr4150.setPadding(2);
		plFrmPayr4150.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr4150(),"PAYR4150");
				}
			});
		plFrmPayr4150.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr4150.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		  //멀티콤보박스 닫기 
		plFrmPayr4150.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
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
        
		 LayoutContainer layoutContainer = new LayoutContainer();
		  layoutContainer.setLayout(new ColumnLayout());
		  
		  LayoutContainer layoutContainer_1 = new LayoutContainer(); 
		  layoutContainer_1.setLayout(new FlowLayout());
		  
		  ButtonBar buttonBar_1 = new ButtonBar();
		  
		  Button btnNewButton_2 = new Button("");
		 // btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
		  buttonBar_1.add(btnNewButton_2);
		  layoutContainer_1.add(buttonBar_1);
		  layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		  layoutContainer_1.setBorders(false);
		  
		  LayoutContainer layoutContainer_2 = new LayoutContainer();
		  layoutContainer_2.setLayout(new FlowLayout());
		  
		   
		   topPayr4150Bar = new ButtonBar();    
		   layoutContainer_2.add(topPayr4150Bar);
		   topPayr4150Bar.setAlignment(HorizontalAlignment.RIGHT);
		 
	  	
		   btnPayr4150Init = new Button("초기화");  
		   btnPayr4150Init.setIcon(MSFMainApp.ICONS.new16());
		  	topPayr4150Bar.add(btnPayr4150Init);
		  	btnPayr4150Init.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			 //초기화 
	    		 	formInit();
	    		}
	      });
		  	
//		  	topBtn = new Button("삭제");  
//		  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//		  	buttonBar.add(topBtn); 
//		  	btnPayr1300Del.addSelectionListener(selectionListener);
		  	 
		  	btnPayr4150Sreach = new Button("조회"); 
		  	btnPayr4150Sreach.setIcon(MSFMainApp.ICONS.search16());
		  	topPayr4150Bar.add(btnPayr4150Sreach);
		  	btnPayr4150Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//조회버튼 클릭시 처리 
	    		    reloadPayr4200();  
	    		}
	    	});
//		  	topBtn = new Button("인쇄"); 
//		  	topBtn.setIcon(MSFMainApp.ICONS.text()); 
//		  	buttonBar.add(topBtn);  
		  	
	    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_2.setBorders(false); 
	    layoutContainer.setBorders(false);
	  	
	    plFrmPayr4150.add(layoutContainer);    
	  	  
	  	
		//파일업로드 처리
		plFrmPayr4150.setAction("bizform");
		plFrmPayr4150.setEncoding(Encoding.MULTIPART);
		plFrmPayr4150.setMethod(Method.POST);
		
	
		vp.add(plFrmPayr4150);
		plFrmPayr4150.setSize("990px", "680px");
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
     
     
        srhSystemkey = new HiddenField<String>();  //시스템키 
        dpobCd = new HiddenField<String>();  //사업장코드 
	 
	     sysComBass0150Dto = new PrgmComBass0150DTO();
		 sysComBass0300Dto = new PrgmComBass0300DTO();
		 sysComBass0400Dto = new PrgmComBass0400DTO();
		 sysComBass0500Dto = new PrgmComBass0500DTO();
		 msfCoCalendarDto = new SysCoCalendarDTO();
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
		 
		 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			
			
	   /**
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	      * 직종 콤보박스 처리  시작
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	      */
 
	     	    
		  lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	             
                mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                 
              }
          });  

		   
		   //-------------------관리부서 추가  
		   sysComBass0400Dto.setDeptDspyYn("Y");
		  sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		  lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);

			 
	     	   //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
                 sysComBass0400Dto.setDeptDspyYn("Y");
                 sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
                 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
                
                 lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
                
                 lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  
                         mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
                         srhDeptCd.getInitStore().add(mDtalistDeptCd);
                         
                     }
                 });     
                 //--------------------급여부서 불러 오는 함수 ------------------------------------------------
                
			 
		 /**
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   * 년도 콤보박스 처리  시작
	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	   */
            	 
     			//--------------------급여년도 불러 오는 함수 ------------------------------------------------
     			 lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
     			    //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
     			 
//	  		   ContentPanel payYrGrid = new ContentPanel();  
//	  		   payYrGrid.setVisible(false);
//	  		    
//	  		   //년도 콤보처리 
//	  		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//	  		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	  			       public void handleEvent(ComponentEvent be) {  
//	  			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	  			          public void handleEvent(StoreEvent<BaseModel> be) {  
//	  			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//	  			        	 
//	  			        	//  Date today = new Date(); 
//	  			        	    // A custom date format
//	  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//	  			        	 
//	  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//	  			      	     // srhPayYr.setValue(bm);
//	  			        	srhPayYr.setValue(lsPayYrStore.getAt(0));
//	  			           
//	  			        	Date today = new Date(); 
//                            DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//                            srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//                      
//	  			          }  
//	  			        });  
//	  			       
//	  			      }  
//	  			    });  
//	  	  
//	  	payYrGrid.add(payYrGridPanel); 
//	  	plFrmPayr4150.add(payYrGrid); 

	  		
	    plFrmPayr4150.setLayout(new FlowLayout());
	    
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
		
	    fieldSet.setStyleAttribute("marginTop", "10px");
	    
	    LayoutContainer lcSchLeft = new LayoutContainer();

	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_8.setLayout(frmlytSch);
	    
	    /** column 지급년월 : payYr */
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
	    srhPayYr.setFieldLabel("지급년월"); 
	    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4150Auth("srhPayYr", lsPayYrStore); 
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
	    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
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
	    srhPayMonth.select(0);
	    srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {   
            	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   Date today = new Date(); 
		    	       // A custom date format
		    	       DateTimeFormat fmt = DateTimeFormat.getFormat("MM"); 
		    	  
		  	           srhPayMonth.setValue(lsPayMonth.findModel("month", fmt.format(today) ));
		  	           
		    		   checkPayr4150Auth("srhPayMonth", lsPayMonth); 
                	 }
		    	   
	        	  
	        	   
	          }  
	        });  
	    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
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
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4150Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
              	 }
              
            }
        });    
        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

            	sysComBass0400Dto = new PrgmComBass0400DTO();  
                sysComBass0400Dto.setDeptDspyYn("Y");
                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
                //--------------------부서 불러 오는 함수 ------------------------------------------------
                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
                //--------------------부서 불러 오는 함수 ------------------------------------------------
                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
                   public void handleEvent(StoreEvent<BaseModel> be) {  
                     mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
                       
                   }
                });   
            } 
        });
        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
        layoutContainer.setBorders(false);
        
    
  LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
	    
	    
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
		                	checkPayr4150Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	    layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    
	    LayoutContainer layoutContainer_101 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_101.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setHideLabel(true);
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(true);
	    srhRepbtyBusinDivCd.setMinChars(1);
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
	    layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        
        
//	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 			// 지급년월
//	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));	// 급여구분
//	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38));	// 단위기관
//	    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 성명
        
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 지급년월
	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
	    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
	    
	     
	    
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
	    	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
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
	  	      	    				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
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
       // srhDeptCd.setForceSelection(true);
       // srhDeptCd.setMinChars(1);
        //srhDeptCd.setDisplayField("deptNmRtchnt");
        //srhDeptCd.setValueField("deptCd");
       // srhDeptCd.setTriggerAction(TriggerAction.ALL);
        srhDeptCd.setEmptyText("--부서선택--");
       // srhDeptCd.setSelectOnFocus(true); 
       // srhDeptCd.setReadOnly(false);
      //  srhDeptCd.setEnabled(true); 
        //srhDeptCd.setStore(lsDeptCd );
        //srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
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
		    		   
		    		   if (!gwtExtAuth.getEnableDeptCd()) { 
		    			   
		    			     ModelData mdSelect = (ModelData) srhDeptCd.getStore().findModel("deptCd",MSFMainApp.get().getUser().getDeptCd());
			  	             if (MSFSharedUtils.paramNotNull(mdSelect)) {
			  	            	srhDeptCd.getListView().setChecked(mdSelect, true); 
			  	            	srhDeptCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("deptNmRtchnt"))); 
			  	             }   
		                    
		    		   }   
		    		   
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4150Auth("srhDeptCd", lsDeptCd); 
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
                            
                          
                      } else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
   	            		 
                    	  //2015.11.30 권한 직종가져오기  추가 
	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	             
	                             mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                              
	                           }
	                       });  
            	    
	              } else {
	            	  
	            	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	           		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	           		   sysComBass0320Dto.setDeptCd(strDeptCd);
	            	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	         		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	        	            public void handleEvent(StoreEvent<BaseModel> be) {  
	        	             
	                          mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
        frmlytSch.setLabelWidth(0); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_10.setLayout(frmlytSch);
        
        //직종 직종세처리  
        LayoutContainer lcTypOccuCd = new LayoutContainer();
        lcTypOccuCd.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_211 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.LEFT); 
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
//        frmlytSch.setLabelWidth(0); 
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
		                    
	                }  }
		    		   
	            // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkPayr4150Auth("srhTypOccuCd", lsTypOccuCd); 
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
        
        
		layoutContainer_13.add(lcSch2_1 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 관리부서 
		layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
		layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
	    
	    fieldSet.add(layoutContainer_13);
        layoutContainer_13.setBorders(false);
        
        
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
		
        
        LayoutContainer layoutContainer_14 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
        layoutContainer_14.setLayout(frmlytSch);
        
        srhPayCd =  new ComboBox<BaseModel>(); 
        srhPayCd.setName("srhPayCd");
        srhPayCd.setForceSelection(true);
        srhPayCd.setMinChars(1);
        srhPayCd.setDisplayField("commCdNm");
        srhPayCd.setValueField("commCd");
        srhPayCd.setTriggerAction(TriggerAction.ALL);
      //  srhPayCd.setEmptyText("--급여구분선택--");
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
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr4150Auth("srhPayCd", lsPayCd); 
             	 }
            }
        });    
        
        
        layoutContainer_14.add(srhPayCd, new FormData("100%"));
        layoutContainer_14.setBorders(false);
         
        LayoutContainer layoutContainer_5 = new LayoutContainer();
        layoutContainer_5.setLayout(new ColumnLayout());
        
        LayoutContainer layoutContainer_6 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_6.setLayout(frmlytSch);
        
        srhHanNm = new TextField<String>();
        srhHanNm.setName("srhHanNm");
        layoutContainer_6.add(srhHanNm, new FormData("100%"));
        srhHanNm.setFieldLabel("성명");
       
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
        
        
//        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) {  
//                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                    srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//                }
//             
//            } 
//        }); 
        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.44));
        layoutContainer_6.setBorders(false);
        
        LayoutContainer layoutContainer_btn = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(0); 
        layoutContainer_btn.setLayout(frmlytSch);
        
        Button btnHanNm = new Button("검색");
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                srhSystemkey.setValue("");
                srhResnRegnNum.setValue("");  
                fnPopupPsnl0100() ;
                  
            }
        });
        
        layoutContainer_btn.add(btnHanNm);
        layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13));
        
        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytSch = new FormLayout();  
        frmlytSch.setDefaultWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_7.setLayout(frmlytSch);
        
        /** column 주민등록번호 : resnRegnNum */
        srhResnRegnNum = new TextField<String>();
        srhResnRegnNum.setName("srhResnRegnNum");
        srhResnRegnNum.setHideLabel(true);
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
      //  srhResnRegnNum.setFieldLabel("주민번호");
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
//        LayoutContainer layoutContainer_16 = new LayoutContainer();
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(0); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16.setLayout(frmlytSch);
        
        

        
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
	    
	    
	    
        lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 
        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));		// 성명
        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 사업
        
        fieldSet.add(lcSchCol3);
        
	    plFrmPayr4150.add(fieldSet); 
	 //vp.add(panel);   
 }  


 private void  displayDtilOccuInttnCd() {
	  
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
         
         //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
             
             sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
             List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
             String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
             sysComBass0350Dto.setDeptCd(strDeptCd);
             List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
             String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
             sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
             
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
             
             if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                 
                 lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
               //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                 
                 lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  
                         mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
//     String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//     if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//         sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//         sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//         if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//             lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//             srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//         }
//     }   
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
private void createStandardForm() {
		
		LayoutContainer layoutContainer_6 = new LayoutContainer();
		layoutContainer_6.setLayout(new FitLayout());
		plFrmPayr4150.add(layoutContainer_6);
		layoutContainer_6.setBorders(false);
		
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(953, 225); 
		fldstNewFieldset_2.setHeadingHtml("스케줄정보");
		fldstNewFieldset_2.setCollapsible(false);
		layoutContainer_6.add(fldstNewFieldset_2);
	 	fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
	 	fldstNewFieldset_2.setStyleAttribute("marginTop", "10px");
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
//		LayoutContainer layoutContainer_1 = new LayoutContainer();
//		FormLayout frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(0); 
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_1.setLayout(frmlytStd);
//		
//		FieldSet fldstNewFieldset = new FieldSet();
//		fldstNewFieldset.setSize(330,335);
//		
//		
//		layoutContainer_1.add(fldstNewFieldset);
//		fldstNewFieldset.setHeadingHtml("기본정보");
//		fldstNewFieldset.setCollapsible(false);
//		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
//		layoutContainer_1.setBorders(false);
//		
//		fldstNewFieldset.add(occupationalRTop(),new FormData("100%"));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		//fldstNewFieldset_1.setSize(622, 335);
		fldstNewFieldset_1.setSize(962, 275);
		

		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("급여계산내역");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "10px");
	 	fldstNewFieldset_1.add(occupationalLeft(),new FormData("100%"));
		 
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);
		    
		plFrmPayr4150.add(layoutContainer);
		layoutContainer.setBorders(false); 
		    
	  } 

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 그리드 처리 함수 시작 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 

private LayoutContainer occupationalRTop() {
	 
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
	 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(308, 110);  
	   
	   LayoutContainer lytCtr01 = new LayoutContainer();
	   lytCtr01.setLayout(new FlowLayout());
	   
	   LayoutContainer layoutContainer_5 = new LayoutContainer();
	   layoutContainer_5.setLayout(new ColumnLayout());
	   
	   LayoutContainer layoutContainer_6 = new LayoutContainer();
	   FormLayout  frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(50); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_6.setLayout(frmlytStd);
	   
	   TextField textField_2 = new TextField();
	   layoutContainer_6.add(textField_2, new FormData("100%"));
	   textField_2.setFieldLabel("지급일자");
	   layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	   layoutContainer_6.setBorders(false);
	   
	   LayoutContainer layoutContainer_7 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(50); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_7.setLayout(frmlytStd);
	   
	   ButtonBar buttonBar = new ButtonBar();
	   buttonBar.setAlignment(HorizontalAlignment.RIGHT);
	   
	   Button btnCalc = new Button("급여계산");
	   buttonBar.add(btnCalc);
	   btnCalc.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) {
	    	  
	    		  
	    	}
	    });
	      
	   
	   layoutContainer_7.add(buttonBar, new FormData("100%"));
	   layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	   layoutContainer_7.setBorders(false);
	   lytCtr01.add(layoutContainer_5);
	   layoutContainer_5.setBorders(false);
	   cp01.add(lytCtr01);
	   
	    
	   lcTabFormLayer.add(cp01); 
	      
	   return lcTabFormLayer;
	 
}

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

//급여스케줄정보 
private LayoutContainer occupationalRBottom() {
	   
    
       creSystemkey =  new HiddenField<String>(); 

       LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(950, 180);   
	   
	    //msfCustomForm.setHeaderVisible(false);
	    //Instantiate the GridPanel
	    payr0250GridPanel = new MSFGridPanel(payr0250Def, false, false, false, false);
	    payr0250GridPanel.setHeaderVisible(false);  
	    payr0250GridPanel.setBodyBorder(true);
	    payr0250GridPanel.setBorders(true); 
	    //msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	
	     cp01.add(payr0250GridPanel); 
	   
		 LayoutContainer layoutContainer_5_1 = new LayoutContainer();
	 	 layoutContainer_5_1.setLayout(new ColumnLayout());  
	   	 layoutContainer_5_1.setStyleAttribute("paddingTop", "10px");
	 	 
	 	 
	 	 LayoutContainer layoutContainer_6_1 = new LayoutContainer();
         FormLayout frmlytSch = new FormLayout();  
         frmlytSch.setLabelWidth(40); 
         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
         layoutContainer_6_1.setLayout(frmlytSch);
         layoutContainer_6_1.setBorders(false);
	 	   
	 	 LayoutContainer layoutContainer_6 = new LayoutContainer();
         frmlytSch = new FormLayout();  
         frmlytSch.setLabelWidth(40); 
         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
         layoutContainer_6.setLayout(frmlytSch); 
        
         creHanNm = new TextField<String>();
         layoutContainer_6.add(creHanNm, new FormData("100%"));
        
         creHanNm.addKeyListener(new KeyListener() {
        	 @Override
             public void componentKeyDown(ComponentEvent event) {
                
                 creHanNm.validate();
                 if (MSFSharedUtils.allowNulls(creHanNm.getValue()).trim().equals("")) {
                     creSystemkey.setValue("");
                     creResnRegnNum.setValue(""); 
                 }
                 if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                     creSystemkey.setValue("");
                     creResnRegnNum.setValue(""); 
                     fnCreatePsnl0100() ;
                 }
                 super.componentKeyDown(event);
             }
          });
//         creHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//             @Override
//             public void handleEvent(BaseEvent be) {  
//                 if (MSFSharedUtils.allowNulls(creHanNm.getValue()).trim().equals("")) {
//                     creSystemkey.setValue("");
//                     creResnRegnNum.setValue(""); 
//                 }
//              
//             } 
//       }); 
         creHanNm.setFieldLabel("성명"); 
         layoutContainer_6.setBorders(false);
         
         Button btnHanNm = new Button("검색"); 
         btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
             public void handleEvent(ButtonEvent e) {
                 creSystemkey.setValue("");
                 creResnRegnNum.setValue(""); 
                 fnCreatePsnl0100() ;
                   
             }
         });
         
         LayoutContainer layoutContainer_7_1 = new LayoutContainer();
         frmlytSch = new FormLayout();  
         frmlytSch.setLabelWidth(0); 
         frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
         layoutContainer_7_1.setLayout(frmlytSch);
         
         /** column 주민등록번호 : resnRegnNum */
         creResnRegnNum = new TextField<String>();
         creResnRegnNum.setLabelSeparator("");
         new TextFieldMask<String>(creResnRegnNum, "999999-9999999");
         creResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
             @Override
             public void handleEvent(BaseEvent be) {  
                 if (MSFSharedUtils.allowNulls(creResnRegnNum.getValue()).trim().equals("")) {
                     creSystemkey.setValue("");
                     creResnRegnNum.setValue(""); 
                 }
              
             } 
       }); 
        // creResnRegnNum.setFieldLabel("주민번호");
         layoutContainer_7_1.add(creResnRegnNum, new FormData("100%")); 
         layoutContainer_7_1.setBorders(false); 
         
         ButtonBar buttonBar = new ButtonBar();
         buttonBar.setAlignment(HorizontalAlignment.RIGHT);
         
         Button btnSelfCalc = new Button("개별급여계산");
         buttonBar.add(btnSelfCalc);
         btnSelfCalc.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                 //버튼 선택시 급여 대상 정보에 그리드에 선택된 내역을 배치로 보낸다.
                 //하단결과그리드 초기화 
                        
                       if (MSFSharedUtils.paramNull(creSystemkey.getValue())) {
                           
                           return;
                       }
                       payr0301GridPanel.getMsfGrid().clearData(); 
                 
                       if (payr0250GridPanel.getCurrentlySelectedItem() != null) {   
                          
                           final Tracker tracker = new Tracker();
                           tracker.setStatus(false);
                              
                           MessageBox.confirm("개별급여계산", "선택하신 근로자의 기존 생성된 급여데이타를 삭제 후 다시 계산합니다.\n 급여계산을 하시겠습니까?",new Listener<MessageBoxEvent>(){
                               @Override
                               public void handleEvent(MessageBoxEvent be) {
                                   //if("Yes".equals(be.getButtonClicked().getText())){
                            	   if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                                      
                                       setRecord(payr0250GridPanel.getCurrentlySelectedItem());  
                                       
                                       Payr0250DTO dtoPayr0250 = new Payr0250DTO();
                                       PrgmComPsnl0100DTO dtoPsnl0100 = new PrgmComPsnl0100DTO();
                                       
                                       BaseModel bmData = new BaseModel();  
                                       
                                       bmData = payr0250GridPanel.getCurrentlySelectedItem();  


                                       dtoPayr0250.setDpobCd(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                                       dtoPayr0250.setJobYrMnth(MSFSharedUtils.allowNulls(bmData.get("jobYrMnth")).replace(".",""));    /** column 작업년월 : jobYrMnth */
                                       dtoPayr0250.setPayCd(MSFSharedUtils.allowNulls(bmData.get("payCd")));    /** column 급여구분코드 : payCd */
                                       dtoPayr0250.setPayScduSeilNum((Long)bmData.get("payScduSeilNum"));    /** column 급여스케줄일련번호 : payScduSeilNum */
                                       dtoPayr0250.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmData.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
                                       dtoPayr0250.setMangeDeptCd(MSFSharedUtils.allowNulls(bmData.get("mangeDeptCd")));    /** column 부서코드 : mangeDeptCd */
                                       dtoPayr0250.setDeptCd(MSFSharedUtils.allowNulls(bmData.get("deptCd")));    /** column 부서코드 : deptCd */
                                       dtoPayr0250.setTypOccuCd(MSFSharedUtils.allowNulls(bmData.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
                                      // dtoPayr0250.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmData.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
                                       dtoPayr0250.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmData.get("dtilOccuInttnCd")));    /** column 직종세통합코드  :dtilOccuInttnCd */
                                       dtoPayr0250.setBusinCd(MSFSharedUtils.allowNulls(bmData.get("businCd")));    /** column 사업코드 : businCd */
                                       dtoPayr0250.setEmymtDivCd(MSFSharedUtils.allowNulls(bmData.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
                                       dtoPayr0250.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(bmData.get("pernChrgEmpIdenNum")));    /** column 담당직원번호 : pernChrgEmpIdenNum */
                                       dtoPayr0250.setJobNm(MSFSharedUtils.allowNulls(bmData.get("jobNm")));    /** column 작업명 : jobNm */
                                       dtoPayr0250.setPymtDt(GWTUtils.getStringFromDate((Date)bmData.get("pymtDt"), "yyyyMMdd"));    /** column 지급일자 : pymtDt */
                                       dtoPayr0250.setRflctnBgnnDt(GWTUtils.getStringFromDate((Date)bmData.get("rflctnBgnnDt"), "yyyyMMdd") );    /** column 반영시작일자 : rflctnBgnnDt */
                                       dtoPayr0250.setRflctnEndDt(GWTUtils.getStringFromDate((Date)bmData.get("rflctnEndDt"), "yyyyMMdd"));    /** column 반영종료일자 : rflctnEndDt */
                                       dtoPayr0250.setPayDdlneDt(GWTUtils.getStringFromDate((Date)bmData.get("payDdlneDt"), "yyyyMMdd"));    /** column 급여마감일자 : payDdlneDt */
                                       dtoPayr0250.setGroFlCretnDt(GWTUtils.getStringFromDate((Date)bmData.get("groFlCretnDt"), "yyyyMMdd") );    /** column 지로파일생성일자 : groFlCretnDt */ 
                                       if (MSFSharedUtils.paramNotNull(dtoPayr0250.getPayDdlneDt())) { 
                                           MessageBox.alert("마감", " 마감처리된 스케줄은 급여계산을 하실 수 없습니다.", null);
                                           return;
                                       }
                                       //대상자 
                                       dtoPsnl0100.setSystemkey(creSystemkey.getValue());   //시스템키
                                       dtoPsnl0100.setHanNm(creHanNm.getValue());
                                       dtoPsnl0100.setResnRegnNum(creResnRegnNum.getValue());   //주민번호 
                                        
                                       
                                       //급여 배치 호출 
                                       //Progress bar for upload
                                       final MessageBox box = MessageBox.wait("급여계산", "급여대상자 급여반영처리 중 입니다...", "급여계산 중...");
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
                                       
                                      payr4150Service.setPayr4100ToPayCalcSeft(dtoPayr0250, dtoPsnl0100, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
                                               public void onFailure(Throwable caught) {
                                                   tracker.setStatus(true);
                                                   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                                                   ShowMessageBM smBm = new ShowMessageBM();
                                            	   smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
                                            	   smBm.setMenu("Payr");
                                            	   smBm.setPhase("[급여]에러");
                                            	   smBm.setMessage(caught.getLocalizedMessage());
                                            	   smBm.setContent(caught.getMessage());
                                            	   bmResult.add(smBm);  
                                            	   PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
                                            	   
                                                   ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
                          		    			    
                        		    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
                        		    		       msFwMessage.show();
                        		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                                                  // MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                                  //         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4100ToPayCalcSeft(): "+caught), null);
                                               }

                                               public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
                                                   tracker.setStatus(true);
                                                   //if (result == 0) { 
                                                      // 오류를 리턴하는 경우
                                                	   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                             		    			    
                            		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
                            		    		       msFwMessage.show();
                            		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                                                     //  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산이 정상적으로 이루어지지 않았습니다.", null);
                                                      
                                                  // } else {
                                                       //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
                                                    //   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산이 정상적으로 처리되었습니다.", null);
                                                       payr0301GridPanel.reload(); 
                                                  // }
                                               }
                                           });
                                           
                                   }
                               }
                           });   
                       
                         
                       } else {
                           
                           //스케줄링을 선택하지 않은경우 메시지 처리 
                           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
                           
                       } 
              }
          });
         
         Button btnCalc = new Button("급여계산");
         buttonBar.add(btnCalc);
         btnCalc.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                 //버튼 선택시 급여 대상 정보에 그리드에 선택된 내역을 배치로 보낸다.
                
                  //하단결과그리드 초기화 
                       payr0301GridPanel.getMsfGrid().clearData(); 
                 
                       if (payr0250GridPanel.getCurrentlySelectedItem() != null) {   
                          
                           final Tracker tracker = new Tracker();
                           tracker.setStatus(false);
                              
                           MessageBox.confirm("급여계산", "급여계산을 하시면 기존 생성된 급여데이타를 삭제 후 다시 계산합니다.\n 급여계산을 하시겠습니까?",new Listener<MessageBoxEvent>(){
                               @Override
                               public void handleEvent(MessageBoxEvent be) {
                                   //if("Yes".equals(be.getButtonClicked().getText())){
                            	   if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                                      
                                       setRecord(payr0250GridPanel.getCurrentlySelectedItem());  
                                       
                                       Payr0250DTO dtoPayr0250 = new Payr0250DTO();
                                       BaseModel bmData = new BaseModel();  
                                       
                                       bmData = payr0250GridPanel.getCurrentlySelectedItem();  


                                       dtoPayr0250.setDpobCd(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                                       dtoPayr0250.setJobYrMnth(MSFSharedUtils.allowNulls(bmData.get("jobYrMnth")).replace(".",""));    /** column 작업년월 : jobYrMnth */
                                       dtoPayr0250.setPayCd(MSFSharedUtils.allowNulls(bmData.get("payCd")));    /** column 급여구분코드 : payCd */
                                       dtoPayr0250.setPayScduSeilNum((Long)bmData.get("payScduSeilNum"));    /** column 급여스케줄일련번호 : payScduSeilNum */
                                       dtoPayr0250.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmData.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
                                       dtoPayr0250.setMangeDeptCd(MSFSharedUtils.allowNulls(bmData.get("mangeDeptCd")));    /** column 부서코드 : mangeDeptCd */
                                       dtoPayr0250.setDeptCd(MSFSharedUtils.allowNulls(bmData.get("deptCd")));    /** column 부서코드 : deptCd */
                                       dtoPayr0250.setTypOccuCd(MSFSharedUtils.allowNulls(bmData.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
                                       dtoPayr0250.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmData.get("dtilOccuInttnCd")));    /** column 직종세통합코드  :dtilOccuInttnCd */
                                     //  dtoPayr0250.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmData.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
                                       dtoPayr0250.setBusinCd(MSFSharedUtils.allowNulls(bmData.get("businCd")));    /** column 사업코드 : businCd */
                                       dtoPayr0250.setEmymtDivCd(MSFSharedUtils.allowNulls(bmData.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
                                       dtoPayr0250.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(bmData.get("pernChrgEmpIdenNum")));    /** column 담당직원번호 : pernChrgEmpIdenNum */
                                       dtoPayr0250.setJobNm(MSFSharedUtils.allowNulls(bmData.get("jobNm")));    /** column 작업명 : jobNm */
                                       dtoPayr0250.setPymtDt(GWTUtils.getStringFromDate((Date)bmData.get("pymtDt"), "yyyyMMdd"));    /** column 지급일자 : pymtDt */
                                       dtoPayr0250.setRflctnBgnnDt(GWTUtils.getStringFromDate((Date)bmData.get("rflctnBgnnDt"), "yyyyMMdd") );    /** column 반영시작일자 : rflctnBgnnDt */
                                       dtoPayr0250.setRflctnEndDt(GWTUtils.getStringFromDate((Date)bmData.get("rflctnEndDt"), "yyyyMMdd"));    /** column 반영종료일자 : rflctnEndDt */
                                       dtoPayr0250.setPayDdlneDt(GWTUtils.getStringFromDate((Date)bmData.get("payDdlneDt"), "yyyyMMdd"));    /** column 급여마감일자 : payDdlneDt */
                                       dtoPayr0250.setGroFlCretnDt(GWTUtils.getStringFromDate((Date)bmData.get("groFlCretnDt"), "yyyyMMdd") );    /** column 지로파일생성일자 : groFlCretnDt */ 
                                    
                                       if (MSFSharedUtils.paramNotNull(dtoPayr0250.getPayDdlneDt())) { 
                                           MessageBox.alert("마감", " 마감처리된 스케줄은 급여계산을 하실 수 없습니다.", null);
                                           return;
                                       }
                                       //급여 배치 호출 
                                       //Progress bar for upload
                                       final MessageBox box = MessageBox.wait("급여계산", "급여대상자 급여반영처리 중 입니다...", "급여계산 중...");
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
                                       
                                      payr4150Service.setPayr4100ToPayCalculation(dtoPayr0250, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
                                               public void onFailure(Throwable caught) {
                                                   tracker.setStatus(true);
                                                   
                                                   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                                                   ShowMessageBM smBm = new ShowMessageBM();
                                            	   smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
                                            	   smBm.setMenu("Payr");
                                            	   smBm.setPhase("[급여]에러");
                                            	   smBm.setMessage(caught.getLocalizedMessage());
                                            	   smBm.setContent(caught.getMessage());
                                            	   bmResult.add(smBm);  
                                            	   PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
                                            	   
                                                   ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
                          		    			    
                        		    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
                        		    		       msFwMessage.show();
                        		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                        		    		       
                                                   //MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                                     //      MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4100ToPayCalculation(): "+caught), null);
                                               }

                                               public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
                                                   tracker.setStatus(true);
                                                 //  if (result == 0) { 
                                                      // 오류를 리턴하는 경우 
                                                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산이 정상적으로 이루어지지 않았습니다.", null);
                                                	   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                                                	   BaseModel tmRec = new BaseModel();
                            		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
                            		    		       msFwMessage.show();
                            		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                            		    		     //  showMessageForm.bind(tmRec); 
                                                  // } else {
                                                       //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
                                                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산이 정상적으로 처리되었습니다.", null);
                                                	   //급여내역   
                            		    		       //payrP41001Form.bind(ppRecord); 
                                                       payr0301GridPanel.reload(); 
                                                  // }
                                               }
                                           });
                                           
                                   }
                               }
                           });   
                       
                            //선택에 따른 작업처리를 위해 추가 20170626 추가 atres     
                       } else {
                           
                           //스케줄링을 선택하지 않은경우 메시지 처리 
                           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
                           
                       }
              
                    
              }
          }); 
         
         
         //선택에 따른 작업처리를 위해 추가 20170626 추가 atres
        Button btnMultiCalc = new Button("선택급여계산");
        buttonBar.add(btnMultiCalc);
        btnMultiCalc.addListener(Events.Select, new Listener<ButtonEvent>() {
             public void handleEvent(ButtonEvent e) {
                //버튼 선택시 급여 대상 정보에 그리드에 선택된 내역을 배치로 보낸다.
                //하단결과그리드 초기화  
                
                      if (payr0250GridPanel.getCurrentlySelectedItem() != null) {   
                         
                          final Tracker tracker = new Tracker();
                          tracker.setStatus(false);
                             
                          MessageBox.confirm("선택급여계산", "선택하신 근로자의 기존 생성된 급여데이타를 삭제 후 다시 계산합니다.\n 급여계산을 하시겠습니까?",new Listener<MessageBoxEvent>(){
                              @Override
                              public void handleEvent(MessageBoxEvent be) {
                                  //if("Yes".equals(be.getButtonClicked().getText())){
                           	   if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                                     
                                      setRecord(payr0250GridPanel.getCurrentlySelectedItem());  
                                      
                                      Payr0250DTO dtoPayr0250 = new Payr0250DTO();
                                      List<PrgmComPsnl0100DTO> listDtoPsnl0100 = new ArrayList<PrgmComPsnl0100DTO>();  
                               
                                      
                                      BaseModel bmData = new BaseModel();  
                                      
                                      bmData = payr0250GridPanel.getCurrentlySelectedItem();  


                                      dtoPayr0250.setDpobCd(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                                      dtoPayr0250.setJobYrMnth(MSFSharedUtils.allowNulls(bmData.get("jobYrMnth")).replace(".",""));    /** column 작업년월 : jobYrMnth */
                                      dtoPayr0250.setPayCd(MSFSharedUtils.allowNulls(bmData.get("payCd")));    /** column 급여구분코드 : payCd */
                                      dtoPayr0250.setPayScduSeilNum((Long)bmData.get("payScduSeilNum"));    /** column 급여스케줄일련번호 : payScduSeilNum */
                                      dtoPayr0250.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmData.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
                                      dtoPayr0250.setMangeDeptCd(MSFSharedUtils.allowNulls(bmData.get("mangeDeptCd")));    /** column 부서코드 : mangeDeptCd */
                                      dtoPayr0250.setDeptCd(MSFSharedUtils.allowNulls(bmData.get("deptCd")));    /** column 부서코드 : deptCd */
                                      dtoPayr0250.setTypOccuCd(MSFSharedUtils.allowNulls(bmData.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
                                     // dtoPayr0250.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmData.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
                                      dtoPayr0250.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmData.get("dtilOccuInttnCd")));    /** column 직종세통합코드  :dtilOccuInttnCd */
                                      dtoPayr0250.setBusinCd(MSFSharedUtils.allowNulls(bmData.get("businCd")));    /** column 사업코드 : businCd */
                                      dtoPayr0250.setEmymtDivCd(MSFSharedUtils.allowNulls(bmData.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
                                      dtoPayr0250.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(bmData.get("pernChrgEmpIdenNum")));    /** column 담당직원번호 : pernChrgEmpIdenNum */
                                      dtoPayr0250.setJobNm(MSFSharedUtils.allowNulls(bmData.get("jobNm")));    /** column 작업명 : jobNm */
                                      dtoPayr0250.setPymtDt(GWTUtils.getStringFromDate((Date)bmData.get("pymtDt"), "yyyyMMdd"));    /** column 지급일자 : pymtDt */
                                      dtoPayr0250.setRflctnBgnnDt(GWTUtils.getStringFromDate((Date)bmData.get("rflctnBgnnDt"), "yyyyMMdd") );    /** column 반영시작일자 : rflctnBgnnDt */
                                      dtoPayr0250.setRflctnEndDt(GWTUtils.getStringFromDate((Date)bmData.get("rflctnEndDt"), "yyyyMMdd"));    /** column 반영종료일자 : rflctnEndDt */
                                      dtoPayr0250.setPayDdlneDt(GWTUtils.getStringFromDate((Date)bmData.get("payDdlneDt"), "yyyyMMdd"));    /** column 급여마감일자 : payDdlneDt */
                                      dtoPayr0250.setGroFlCretnDt(GWTUtils.getStringFromDate((Date)bmData.get("groFlCretnDt"), "yyyyMMdd") );    /** column 지로파일생성일자 : groFlCretnDt */ 
                                      if (MSFSharedUtils.paramNotNull(dtoPayr0250.getPayDdlneDt())) { 
                                          MessageBox.alert("마감", " 마감처리된 스케줄은 급여계산을 하실 수 없습니다.", null);
                                          return;
                                      }
                                      
                                      //대상자 멀티선택 가능하도록 수정 반영 
                                      Iterator<BaseModel> itBm  = payr0301GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
                                      
                                      List<Record>  lsRec  = new ArrayList<Record>();
                                      
                                      while(itBm.hasNext()) {

                                          Record rec  = new Record(itBm.next()); 
                                          lsRec.add(rec);
                                          
                                      } 
                                      
                                       setListRecord(lsRec.iterator());  
                                       
                                       if (MSFSharedUtils.paramNull(records)) {
                                   
                                           MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
                                           return;
                                       
                                       } 
                                       
                                       while (records.hasNext()) {
                                           
                                           Record record = (Record) records.next(); 
                                           BaseModel bmMapModel = (BaseModel)record.getModel();
                                          
                                           PrgmComPsnl0100DTO   prgmComPsnl0100Dto = new PrgmComPsnl0100DTO();  
                                       
                                        //   prgmComPsnl0100Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                                        //   prgmComPsnl0100Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(record.get("pymtYrMnth")).replace(".", ""));    /** column 지급년월 : pymtYrMnth */
                                           prgmComPsnl0100Dto.setSystemkey(MSFSharedUtils.allowNulls(record.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                                           prgmComPsnl0100Dto.setResnRegnNum(MSFSharedUtils.allowNulls(record.get("resnRegnNum")));    /** column resnRegnNum : 주민등록번호  */
                                           prgmComPsnl0100Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(record.get("emymtDivCd")));    /** column emymtDivCd : 고용구분코드  */ 
                                         //  prgmComPsnl0100Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(record.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
                                         //  prgmComPsnl0100Dto.setPayCd(MSFSharedUtils.allowNulls(record.get("payCd")));    /** column 급여구분코드 : payCd */
                                         //  prgmComPsnl0100Dto.setPayrSeilNum((Long)record.get("payrSeilNum"));    /** column 급여일련번호 : payrSeilNum */ 
                                        //   prgmComPsnl0100Dto.setPayDdlneDt(GWTUtils.getStringFromDate(PayDdlneDt.getValue(),"yyyyMMdd") );
                                            
                                           listDtoPsnl0100.add(prgmComPsnl0100Dto);
                                         
                                       }  
                                      
                                  
                                      //급여 배치 호출 
                                      //Progress bar for upload
                                      final MessageBox box = MessageBox.wait("급여계산", "급여대상자 급여반영처리 중 입니다...", "급여계산 중...");
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
                                      
                                      payr0301GridPanel.getMsfGrid().clearData();  
                                  
                                      
                                     payr4150Service.setPayr4100ToPayCalcMulti(dtoPayr0250, listDtoPsnl0100, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
                                              public void onFailure(Throwable caught) {
                                                  tracker.setStatus(true);
                                                  List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                                                  ShowMessageBM smBm = new ShowMessageBM();
                                           	   smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
                                           	   smBm.setMenu("Payr");
                                           	   smBm.setPhase("[급여]에러");
                                           	   smBm.setMessage(caught.getLocalizedMessage());
                                           	   smBm.setContent(caught.getMessage());
                                           	   bmResult.add(smBm);  
                                            	   PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
                                           	   
                                                  ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
                         		    			    
                       		    		       MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
                       		    		       msFwMessage.show();
                       		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                                                 // MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                                 //         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("setPayr4100ToPayCalcSeft(): "+caught), null);
                                              }

                                              public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
                                                  tracker.setStatus(true);
                                                  //if (result == 0) { 
                                                     // 오류를 리턴하는 경우
                                               	   ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                            		    			    
                           		    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
                           		    		       msFwMessage.show();
                           		    		       showMessageForm.setMSFFormWindows(msFwMessage);
                                                    //  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산이 정상적으로 이루어지지 않았습니다.", null);
                                                     
                                                 // } else {
                                                      //정상처리인 경우에는 하단에 정보를 넘겨 조회한다.
                                                   //   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산이 정상적으로 처리되었습니다.", null);
                                                      payr0301GridPanel.reload(); 
                                                 // }
                                              }
                                          });
                                          
                                  }
                              }
                          });   
                      
                        
                      } else {
                          
                          //스케줄링을 선택하지 않은경우 메시지 처리 
                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"급여계산을 위한 스케줄을 선택하십시요.", null); 
                          
                      } 
             }
         });
        
	 	 layoutContainer_5_1.setBorders(false);
	 	
	 	 layoutContainer_5_1.add(layoutContainer_6_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
         layoutContainer_5_1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
         layoutContainer_5_1.add(btnHanNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06));
         layoutContainer_5_1.add(layoutContainer_7_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
         layoutContainer_5_1.add(buttonBar,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 
	 	 
	 	cp01.setBottomComponent(layoutContainer_5_1);
	  	  
	    lcTabFormLayer.add(cp01); 
	      
	    return lcTabFormLayer;
} 

class Tracker 
{
    public boolean status = false;
    public boolean getStatus(){return status;}
    public void setStatus(boolean stat){status = stat;}
}   
  

private LayoutContainer occupationalLeft() {
 
 LayoutContainer lcTabFormLayer = new LayoutContainer();
 
//	    
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(950,240);
 
 
 //msfCustomForm.setHeaderVisible(false);
 //Instantiate the GridPanel
 payr0301GridPanel = new MSFGridPanel(payr0301Def, false, false, false, false,false);
 payr0301GridPanel.getMsfGrid().setCellModel(true);
 payr0301GridPanel.setHeaderVisible(false);  
 payr0301GridPanel.setBodyBorder(true);
 payr0301GridPanel.setBorders(true); 
// msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

  cp01.add(payr0301GridPanel); 
	    
//	    cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
//	    @Override  
//	    public void componentSelected(ButtonEvent ce) {   
//	       
//	    	 final Grid payr0301Grid = payr0301GridPanel.getMsfGrid().getGrid(); 
//	    	    payr0301Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//		             public void handleEvent(BaseEvent be) {  
//		           
//		           		 if (payr0301GridPanel.getCurrentlySelectedItem() != null) {  
//		           			 
//		           			Payr0301DTO payr0301Dto = new Payr0301DTO();  
//		           			BaseModel bmPayr0301 = new BaseModel(); 
//		           			
//		           			bmPayr0301 =  payr0301GridPanel.getCurrentlySelectedItem();
//		           			
//		           			//payr0301Dto = (Payr0301DTO)ReflectionUtils.convertBaseModelToObject("com.app.exterms.payroll.client.dto.Payr0301DTO",bmPayr0301);
//		           			
//		           			actionDatabase = ActionDatabase.DELETE;
//			 	    		
//		           			payr4150Service.activityOnPayr4150(payr0301Dto, 
//			 	                                    actionDatabase,
//			 	                                    new AsyncCallback<Long>() {
//			 	    			 
//			 	                public void onFailure(Throwable caught) {
//			 	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//			 	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0301(" + actionDatabase.name() + ") : " + caught), null);
//			 	                }
//			 	                public void onSuccess(Long result) { 
//			 	                	
//			 	                	payr0301GridPanel.reload();
//			 	                }	
//			 	            }); 
//		           		 }
//		           		 
//		             }
//		         });  
//	    	    
//	    }   
//	  })); 
//	   cp01.addButton(new Button("재계산", new SelectionListener<ButtonEvent>() {   
//	      @Override  
//	      public void componentSelected(ButtonEvent ce) {   
//	    	  //버튼 선택시 급여 대상 정보에 그리드에 선택된 내역을 배치로 보낸다.
//	    	     
//	    	    final Grid payr0301Grid = payr0301GridPanel.getMsfGrid().getGrid(); 
//	    	    payr0301Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
//		             public void handleEvent(BaseEvent be) {  
//		            	 
//		           	  if (payr0250GridPanel.getCurrentlySelectedItem() != null) {  
//		           		 
//		           		  //급여 배치 호출 
//		           		PayrListenerAdapter payrAdapter = new PayrListenerAdapter();
//		           		Payr0250DTO dtoPayr0250 = new Payr0250DTO();
//		           		SysComPsnl0100DTO dtoPsnl0100 = new SysComPsnl0100DTO();
//		           		BaseModel bmData = new BaseModel(); 
//		           		
//		           		try {
//		           			
//		           			bmData = payr0250GridPanel.getCurrentlySelectedItem();
//		           			 
//		           			//dtoPayr0250  = (Payr0250DTO)ReflectionUtils.convertBaseModelToObject("com.app.exterms.payroll.client.dto.Payr0250DTO",bmData);
//		           			
//		           		 if (payr0301GridPanel.getCurrentlySelectedItem() != null) {  
//		           			 
//		           			BaseModel bmPayr0301 = new BaseModel(); 
//		           			
//		           			bmPayr0301 =  payr0301GridPanel.getCurrentlySelectedItem();
//		           			 
//		           			dtoPsnl0100.setSystemkey((String)bmPayr0301.get("systemkey"));
//		           			dtoPsnl0100.setHanNm((String)bmPayr0301.get("hanNm"));
//		           			dtoPsnl0100.setResnRegnNum((String)bmPayr0301.get("resnRegnNum"));
//		           			
//							payrAdapter.setPayr4100ToPayCalcSeft(dtoPayr0250, dtoPsnl0100);
//		           			 
//		           		 }
//		           		 
//		           		} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		           		
//		           	  }
//		             }
//		         });  
//	      }   
//	    }));  
//	   
//	    cp01.addButton(new Button("엑셀", new SelectionListener<ButtonEvent>() {   
//	      @Override  
//	      public void componentSelected(ButtonEvent ce) {   
//	    	 payr0301GridPanel.callExportServlet("");
//	      }   
//	    }));  
	    
    lcTabFormLayer.add(cp01); 
   
	return lcTabFormLayer;  
 
}	  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 그리드 처리 함수 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 	  
	  
	public void reloadPayr4200() {
			// TODO Auto-generated method stub
	        payr0301GridPanel.getMsfGrid().clearData();
			IColumnFilter filters = null;
			payr0250GridPanel.getTableDef().setTableColumnFilters(filters);
			
			payr0250GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0250GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			payr0250GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0250GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	
			//20180305추가 
			payr0250GridPanel.getTableDef().addColumnFilter("mangeDeptCd"		, MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))	, SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0250GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd"	, MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"))	, SimpleColumnFilter.OPERATOR_EQUALS); 
			
              String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
              payr0250GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
             
             
              String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
              payr0250GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
             
             // String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
             // payr0250GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
            
              String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
              payr0250GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
            
              
		//	payr0250GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
//			payr0250GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//			payr0250GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//			payr0250GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			payr0250GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            
			payr0250GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0250GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
			payr0250GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			
			payr0250GridPanel.reload();
		}
	  
	 //폼초기화 검색조건포함 
	   private void formInit() {
         BaseModel bmInit = new BaseModel();
         
//		   srhPayYr.setValue(bmInit);
//		   srhPayMonth.setValue(bmInit);
//
//		   srhTypOccuCd.setValue(bmInit); //직종 
//		   srhPayCd.setValue(bmInit);     //급여구분
//		   srhEmymtDivCd.setValue(bmInit); //고용구분 
//		   srhPayrMangDeptCd.setValue(bmInit); //단위기관
//
//		   srhDeptCd.setValue(bmInit);   //부서 
//		   srhBusinCd.setValue(bmInit);    //사업
		   srhHanNm.setValue("");         //성명
		   srhResnRegnNum.setValue("");   //주민번호 
		   srhSystemkey.setValue("");   //시스템키
		   
		   creSystemkey.setValue("");    //systemkey 
		   creHanNm.setValue("");        //성명
		   creResnRegnNum.setValue("");  //주민번호 
		    
		   //grid init
		   payr0250GridPanel.getMsfGrid().clearData();
		   payr0301GridPanel.getMsfGrid().clearData();

	   }
	    


public void setRecord(BaseModel record) {
    this.record = record;
}


public void setListRecord(Iterator<Record> records) {
      this.records = records;
  }



private Payr4150 getThis(){
    return this;
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



private void fnCreatePsnl0100() {
    //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
    //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
    //검색.처리하면됨.
    
    MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(creHanNm.getRawValue());  //인사  
    
    final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
   
    popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
            BaseModel mapModel = (BaseModel)be.getSource();
            if (!"".equals(mapModel.get("systemkey"))) { 
                 
                creSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
                creHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
                creResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
                 
            }  
         
            
        }
    });
     
}

//부서 
//  private void fnPopupCommP140(String deptCd) {
//      //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//      //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//      //검색.처리하면됨.
//      
//      MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//      
//      final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//     
//      popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//          public void handleEvent(BaseEvent be) {
//              BaseModel mapModel = (BaseModel)be.getSource();
//              if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                   
//                  srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                  srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//                  srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                  srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//                  srhDeptCd.fireEvent(Events.Add);
//              }  
//                   
//          }
//      });
//  }       
  
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
