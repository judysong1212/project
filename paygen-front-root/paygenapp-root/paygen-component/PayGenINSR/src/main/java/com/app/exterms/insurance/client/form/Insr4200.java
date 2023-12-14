package com.app.exterms.insurance.client.form;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3200BM;
import com.app.exterms.insurance.client.dto.Insr3300BM;
import com.app.exterms.insurance.client.dto.Insr3300DTO;
import com.app.exterms.insurance.client.form.defs.Insr3200Def;
import com.app.exterms.insurance.client.service.Insr4200Service;
import com.app.exterms.insurance.client.service.Insr4200ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.js.JsUtil;
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
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
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
public class Insr4200  extends MSFPanel { 
 

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
   // private RemtConstants lblRemtConst = RemtConstants.INSTANCE; 
    
    private VerticalPanel vp;
    private FormPanel plFrmInsr4200; 
    private String txtForm = "";
    private XTemplate detailTp; 
    
    //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
	  
    //건강보험 고지 정산 대사 
	private Insr3200Def insr3200Def  = new Insr3200Def("INSR4200");   //그리드 테이블 컬럼 define  
    // private MSFCustomForm msfCustomForm; 
    private MSFGridPanel insr3200GridPanel;
     
    //직종콤보
//	private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	private MSFGridPanel typOccuCdGridPanel;
	   
	  
     
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
      private ButtonBar topInsr4200Bar;
      private Button btnInsr4200Init;
      private Button btnInsr4200Save;
      private Button btnInsr4200Del;
      private Button btnInsr4200Sreach;
      private Button btnInsr4200Print;
      private Button btnInsr4200Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhNofctYr;
      private ComboBox<BaseModel> srhNofctMnth;
     
    //  private ComboBox<BaseModel> srhTypOccuCd; //직종 
    //  private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
    //  private HiddenField<String> srhPyspGrdeCd; //직종 
      
    //  private ComboBox<BaseModel> srhPayCd;     //급여구분
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

    //  private TextField<String> srhDeptCd; //부서코드
    //  private TextField<String> srhDeptNm; //부서명  
    //  private Button btnSrhDeptCd;
    //  private TextField<String> srhMangeDeptCd; //관리부서 수정
    //  private TextField<String> srhMangeDeptNm; //관리부서 수정  
      
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; //재직상태  
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      
      /** column 지급공제구분코드 : pymtDducDivCd */
      private ComboBox<BaseModel> srhPymtDducDivCd;
      
      private ComboBox<BaseModel> srhUploadDivCd; //업로드 구분 코드 
      
      private List<ModelData> mDtalistHdofcCodtnCd ;
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      
      private boolean mutilCombo = false;
      private Boolean emptyCheck = false ;
      
      private Boolean picBoolFile;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      //파일업로드처리 부분  
      private FileUploadField insr4200flUp;
      
        
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
   		  private void checkInsr4200Auth( String authAction, ListStore<BaseModel> bm) {   
   	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
   			 
   			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

				   if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ;
  	                //----------------------------------------------------
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
   			   }
   		  }
   		 private void authExecEnabled() { 
    		   //------------------
   		   Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
              
	             gwtAuthorization.formAuthFieldConfig(fldArrField);
	            
	             
	             srhNofctYr.setValue(lsNofctYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
	       	     srhNofctMnth.setValue(lsNofctMnth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
	       	     
	       	     srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
	       	     srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
	       	
				  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	            * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	            * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
	            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	            // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
	            // GWTAuthorization.formAuthPopConfig(plFrmInsr4200, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
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
		     
			   final Timer tmMask2 = new Timer()
			     {
			           public void run()
			           {
			        	   
			        	   plFrmInsr4200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중...");
			        	   tmMask2.scheduleRepeating(20000);
			        	   
			        	   plFrmInsr4200.unmask();
			        	   maskTracker  = true;
			            
			            
			           }
			     };   
		     
		     
   		  private void initLoad() { 

   			    // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
   			     gwtAuthorization = GWTAuthorization.getInstance();
   			     gwtExtAuth = GWTExtAuth.getInstance();
   			    
   			     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
   			     authMapDef.put("srhNofctYr",Boolean.FALSE);
   			  	 authMapDef.put("srhNofctMnth",Boolean.FALSE);
   			  	 authMapDef.put("srhHdofcCodtnCd",Boolean.FALSE);
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
//    	  private void checkInsr4200Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//        	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//    		 
//    		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//    		   
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
      
	   //화면 폼 바인딩 처리 
	    private void setInsr2100FormBinding() {
	 	 
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
	    private Insr4200ServiceAsync insr4200Service = Insr4200Service.Util.getInstance();	    
		 
	    private ListStore<BaseModel> lsNofctYrStore = new ListStore<BaseModel>();  //년도 
  		private ListStore<BaseModel> lsNofctMnth = new ListStore<BaseModel>();  //급여월   
  		
  		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
  		
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
  		 //--------------------부서 불러 오는 함수 ------------------------------------------------
  		private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
  		//--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
  	   //--------------------사업 불러 오는 함수 -------------------------------------------------
  		private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
  		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
  		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
  		
  		private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
  		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
  		

  	    private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
      	private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  
  		
      	private ListStore<BaseModel>  lsUploadDivCd = new ListStore<BaseModel>();//업로드구분코드
      	
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
  		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
  		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
  		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
  		private SysCoCalendarDTO msfCoCalendarDto;  
  		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
  		 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
  		 
  	    private BaseModel record;
  	    
	    private  Iterator<Record> records;
	    
  	    private BaseModel ppRecord; //팝업에 넘길 레코드 값 
    
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
  
  	    
	      private void insr4200FormSave() {  
  	          
//  	          if (MSFSharedUtils.paramNotNull(records)) { 
//  	              
//  	               List<Insr4100DTO> listInsr4100dto = new ArrayList<Insr4100DTO>();  
//  	                
//  	                while (records.hasNext()) {
//  	              
//  	                    Record record = (Record) records.next(); 
//  	                    BaseModel bmMapModel = (BaseModel)record.getModel();
//  	                      
//  	                    Insr4100DTO insr4100Dto = new Insr4100DTO();   
//  	                    
//						
//						insr4100Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */ 
//						insr4100Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */ 
//						insr4100Dto.setNatPennSeilNum((Long)bmMapModel.get("natPennSeilNum"));    /** column 국민연금일련번호 : natPennSeilNum */ 
//						insr4100Dto.setEmymtSeilNum((Long)bmMapModel.get("emymtSeilNum"));    /** column 고용일련번호 : emymtSeilNum */ 
//						insr4100Dto.setNatPennAqtnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("natPennAqtnDt"),"yyyyMMdd") );    /** column 국민연금취득일자 : natPennAqtnDt */  
//						insr4100Dto.setNatPennLssDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("natPennLssDt"),"yyyyMMdd") );    /** column 국민연금상실일자 : natPennLssDt */ 
//						 
//						
//						 
//						//insr4100Dto.setNatPennInsurFlucDt(MSFSharedUtils.allowNulls(bmMapModel.get("natPennInsurFlucDt")));    /** column 국민연금변동일자 : natPennInsurFlucDt */
//						insr4100Dto.setNatPennStdIncmMnthAmnt((Long)record.get("natPennStdIncmMnthAmnt"));    /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
//						insr4100Dto.setNatPennGrde(MSFSharedUtils.allowNulls(record.get("natPennGrde")));    /** column 국민연금등급 : natPennGrde */ 
//  	                       
//  	                   // dlgn0250Dto.setDilnlazExceDutyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("dilnlazDutyBgnnDt"),"yyyyMMdd"));    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
//  	                     
//
//  	                    listInsr4100dto.add(insr4100Dto);
//  	                  
//  	                }  
//  	                
//  	                if (listInsr4100dto.size() <= 0) {
//  	                    
//  	                    MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//  	                    return;
//  	                }
//  	                
//  	              insr4200Service.activityOnInsr4100(listInsr4100dto, actionDatabase, new AsyncCallback<Long>(){
//  	                  public void onFailure(Throwable caught) {
//  	                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//  	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsr4100(" + actionDatabase.name() + ") : " + caught), null);
//  	                  }
//  	                  public void onSuccess(Long result) { 
//  	                     if (result == 0) {
//  	                         MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//  	                                 actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//  	                     } else {
//  	                         MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//  	                                 actionDatabase + "처리가 완료되었습니다.", null);
//  	                         reload();
//  	                         actionDatabase = ActionDatabase.UPDATE;
//  	                     } 
//  	                  } 
//  	                   
//  	              }); 
//  	              
//  	          } else {
//  	              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//  	              return;
//  	          }

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
	private void Insr4200Print(String fileName) {
 
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "INSR";
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		// 보낼 파라미터
//		
//		
//		//검색조건
// 	   String serarchParam = "";
////		
////		String name = searchName.getValue() == null ? "" : searchName.getValue();
////		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////		String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////		
////		serarchParam += "["+name+"]";
////		serarchParam += "["+resn+"]";
////		serarchParam += "["+hdofcCodtnCd+"]";
////		serarchParam += "[]";
////		//serarchParam += "["+manageDeptCd+"]";
////		serarchParam += "["+deptCd+"]";
////		serarchParam += "["+emymtDivCd+"]";
////		serarchParam += "["+typOccuCd+"]";
//		
////		List<BaseModel> list = payr0650GridPanel.getGrid().getSelectionModel().getSelectedItems();
////		String checkedSystemKeys = "";
////		if(list != null && list.size() > 0){
////			String chkkey = "";
////			for(BaseModel bm : list){
////				chkkey += "'"+bm.get("systemkey")+"',";
////			}
////			
////			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
////			
////		}
//		String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
//		 
//		//String strParam = "/rp " + "[" + "20080311" + "]";
//		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
//		
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);

	}

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
              
              vp = new VerticalPanel();
              vp.setSpacing(10);
              createInsr4200Form();  //화면 기본정보를 설정
              createSearchForm();    //검색필드를 적용 
              createForm();    //기본정보필드  
              createBottom();
              add(vp);
              //엣지변환
              //vp.setSize("1010px", "700px");
              vp.setSize("1010px", "750px");
                  
              panel = new ContentPanel();
              panel.setBodyBorder(false);
              panel.setBorders(false);
              panel.setHeaderVisible(false);
              panel.setScrollMode(Scroll.AUTO);  
              panel.add(vp);
              
              
          }
          return panel;
      }
	 
//  @Override
//  protected void onRender(Element parent, int index) {
//    super.onRender(parent, index);
//    
//    detailTp = XTemplate.create(getDetailTemplate()); 
//    
//    vp = new VerticalPanel();
//    vp.setSpacing(10);
//    createInsr4200Form();  //화면 기본정보를 설정
//    createSearchForm();    //검색필드를 적용 
//    createForm();    //기본정보필드  
//    createBottom();
//    add(vp);
//    vp.setSize("1010px", "700px");
//  }
  
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
  public Insr4200() {
	   
	  //엣지변환
	  //setSize("1010px", "700px");  
      setSize("1010px", "750px");  
} 

public Insr4200(String txtForm) {
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
	 
private void createInsr4200Form() {
    
    plFrmInsr4200 = new FormPanel(); 
   // plFrmInsr4200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblRemtConst.title_Remt0100());
    plFrmInsr4200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 건강보험월정산대사"));
    plFrmInsr4200.setIcon(MSFMainApp.ICONS.text());
    //plFrmInsr4200.setBodyStyleName("pad-text");
    plFrmInsr4200.setFrame(true); 
    
    /************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	final Button btnlogView = new Button("로그");   
	
	btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
	btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			 //로그 뷰화면 호출 메서드 
			  funcLogMessage("건강보험월정산대사","INSR4200");
			}
		});
	plFrmInsr4200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
	plFrmInsr4200.getHeader().addTool(btnlogView); 
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 
	 ************************************************************************/

    
	   //멀티콤보박스 닫기 
    plFrmInsr4200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
        @Override
        public void handleEvent(ComponentEvent ce) { 
        
         //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                
        //        if (f instanceof MSFMultiComboBox<?>) {
                    
//                    if ("srhDeptCd".equals(f.getName())) {
//                        
//                    } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                        
//                    }
                    
          //      } else {
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
    
    
	topInsr4200Bar = new ButtonBar();    
	topInsr4200Bar.setAlignment(HorizontalAlignment.RIGHT);

  
	btnInsr4200Init = new Button("초기화");  
    btnInsr4200Init.setIcon(Resources.APP_ICONS.new16());
    topInsr4200Bar.add(btnInsr4200Init);
    btnInsr4200Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			 //초기화 
			formInit();
		}
    });  
  	 
//    btnInsr4200Save = new Button("저장");  
//    btnInsr4200Save.setIcon(Resources.APP_ICONS.save16());
//    topInsr4200Bar.add(btnInsr4200Save); 
//    btnInsr4200Save.addListener(Events.Select, new Listener<ButtonEvent>() {
//		public void handleEvent(ButtonEvent e) {
//			   setListRecord(insr4100GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
//               doAction(actionDatabase); 
//		}
//	});
//    
//    btnInsr4200Del = new Button("취소");  
//    btnInsr4200Del.setIcon(Resources.APP_ICONS.delete16());
//	    topInsr4200Bar.add(btnInsr4200Del);
//	    btnInsr4200Del.addListener(Events.Select, new Listener<ButtonEvent>() {
//		public void handleEvent(ButtonEvent e) {
//			//조회버튼 클릭시 처리 
//		    reload();  
//		}
//	});
//	 
	    btnInsr4200Sreach = new Button("조회"); 
	    btnInsr4200Sreach.setIcon(Resources.APP_ICONS.search16());
	    topInsr4200Bar.add(btnInsr4200Sreach);
	    btnInsr4200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			//조회버튼 클릭시 처리 
		    reload();  
		}
	});
	
	    btnInsr4200Excel = new Button("엑셀"); 
	    btnInsr4200Excel.setIcon(Resources.APP_ICONS.excel16()); 
	    topInsr4200Bar.add(btnInsr4200Excel);  
	  btnInsr4200Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			//엑셀저장  
			excelFileExport();
		}
	});
  	
  	plFrmInsr4200.add(topInsr4200Bar);    
  	
	//파일업로드 처리
	plFrmInsr4200.setAction("bizform");
	plFrmInsr4200.setEncoding(Encoding.MULTIPART);
	plFrmInsr4200.setMethod(Method.POST);
	 
        
    vp.add(plFrmInsr4200);
    //엣지변환
    //plFrmInsr4200.setSize("990px", "680px");
    plFrmInsr4200.setSize("990px", "730px");
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

private void createSearchForm() {   
     
	  //  srhPyspGrdeCd = new HiddenField<String>(); 
    srhSystemkey = new HiddenField<String>();  //시스템키 


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
	 //재직상태  
	 sysComBass0300Dto.setRpsttvCd("A003");
	 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
         public void handleEvent(StoreEvent<BaseModel> be) {  
             mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
             srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
             
         }
     });   
	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 
	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 //고용구분
	 sysComBass0300Dto.setRpsttvCd("A002");
	 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 
	 //보험월별대사 업로드구분
/*	 sysComBass0300Dto.setRpsttvCd("I030");
	 lsUploadDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); */
	//--------------------업로드구분 코드 생성 --------------------------------------------------
	BaseModel uploadDivCdBaseModel = new BaseModel();
	uploadDivCdBaseModel.                set("commCd", "I0300001");
	uploadDivCdBaseModel.set("commCdNm", "기본명세");
	lsUploadDivCd.add(uploadDivCdBaseModel);
	
	uploadDivCdBaseModel = new BaseModel(); 
	uploadDivCdBaseModel.set("commCd", "I0300002");
	uploadDivCdBaseModel.set("commCdNm", "상세명세");
	lsUploadDivCd.add(uploadDivCdBaseModel);
	//--------------------업로드구분 코드 생성 --------------------------------------------------	
	 
	//--------------------급여년도 불러 오는 함수 ------------------------------------------------
    lsNofctYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
	 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
    
	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 //월 
	 
	 lsNofctMnth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------


	 //-------------------관리부서 추가  
	sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
	
	   //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
     sysComBass0400Dto.setDeptDspyYn("Y");
     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
    
     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
    
     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
         public void handleEvent(StoreEvent<BaseModel> be) {  
             mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
             srhDeptCd.getInitStore().add(mDtalistDeptCd);
             
         }
     });     
     
     sysComBass0300Dto.setRpsttvCd("A048");
     lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);


     //--------------------급여부서 불러 오는 함수 ------------------------------------------------
     
	// sysComBass0400Dto.setDeptDspyYn("Y");
	 //--------------------부서 불러 오는 함수 ------------------------------------------------
	// lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
	 //--------------------부서 불러 오는 함수 ------------------------------------------------
	// sysComBass0400Dto.setDeptDspyYn("");
		
  /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 직종 콤보박스 처리  시작
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
     */
//    		  ContentPanel typOccuCdGrid = new ContentPanel();  
//    		  typOccuCdGrid.setVisible(false);
//    		    
//    		    //직종 콤보처리 
//    		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//    		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//    			       public void handleEvent(ComponentEvent be) {  
//    			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//    			          public void handleEvent(StoreEvent<BaseModel> be) {  
//    			        	  
//    			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//    			        	mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//                           srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//    			          }  
//    			        });  
//    			       
//    			      }  
//    			    });  
//    	  
//    		 typOccuCdGrid.add(typOccuCdGridPanel); 
//    		plFrmInsr4200.add(typOccuCdGrid);
    	    
       lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	    lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
          public void handleEvent(StoreEvent<BaseModel> be) {  
           
            mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
            srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
             
          }
      });  
 
   plFrmInsr4200.setLayout(new FlowLayout());
   
   srhSystemkey = new HiddenField<String>(); 
     
   LayoutContainer lcSchCol = new LayoutContainer();
   //lcSchCol.setStyleAttribute("background-color","red");
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
 //  lcSchLeft.setStyleAttribute("paddingRight", "10px");
  

   fieldSet.add(lcSchCol, new FormData("100%"));  
   lcSchLeft.setLayout(new ColumnLayout());
   
   LayoutContainer layoutContainer_8 = new LayoutContainer();
   FormLayout frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_8.setLayout(frmlytSch);
   
   srhNofctYr = new ComboBox<BaseModel>();
   srhNofctYr.setName("srhNofctYr");
   srhNofctYr.setForceSelection(true);
   srhNofctYr.setMinChars(1);
   srhNofctYr.setDisplayField("yearDisp");
   srhNofctYr.setValueField("year");
   srhNofctYr.setTriggerAction(TriggerAction.ALL);
  // srhNofctYr.setEmptyText("--년도선택--");
   srhNofctYr.setSelectOnFocus(true); 
   srhNofctYr.setReadOnly(false);
   srhNofctYr.setEnabled(true); 
   srhNofctYr.setStore(lsNofctYrStore);
   srhNofctYr.setFieldLabel("고지년월"); 
   srhNofctYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
       public void handleEvent(StoreEvent<BaseModel> be) {  
    	   checkInsr4200Auth("srhNofctYr",lsNofctYrStore);  
         
       }
   });
   srhNofctYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
         public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
             //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
          BaseModel bmNofctYr =  se.getSelectedItem(); 
          if (bmNofctYr != null) {
              
              if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                  
                  if (srhDeptCd.getListView().getChecked().size() > 0) {  
                     
                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhNofctYr,"year"));
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
   layoutContainer_8.add(srhNofctYr, new FormData("100%"));
   lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
   layoutContainer_8.setBorders(false);
   
   LayoutContainer layoutContainer_9 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(0); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_9.setLayout(frmlytSch);
   
   /** column 지급년월 : Mnth */ 
   srhNofctMnth = new ComboBox<BaseModel>();
   srhNofctMnth.setName("srhNofctMnth");
   srhNofctMnth.setForceSelection(true);
   srhNofctMnth.setMinChars(1);
   srhNofctMnth.setDisplayField("monthDisp");
   srhNofctMnth.setValueField("month");
   srhNofctMnth.setTriggerAction(TriggerAction.ALL);
  // srhNofctMnth.setEmptyText("--월선택--");
   srhNofctMnth.setSelectOnFocus(true); 
   srhNofctMnth.setReadOnly(false);
   srhNofctMnth.setEnabled(true); 
   srhNofctMnth.setStore(lsNofctMnth);
   srhNofctMnth.setHideLabel(true);
   srhNofctMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
       public void handleEvent(StoreEvent<BaseModel> be) {  
    	   checkInsr4200Auth("srhNofctMnth",lsNofctMnth);  
       }
   });
   layoutContainer_9.add(srhNofctMnth, new FormData("100%"));
   lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
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
                	checkInsr4200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
        	 }   
         
           
       }
   });    
   srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
       public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
    
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
                mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
                srhDeptCd.getInitStore().add(mDtalistDeptCd);
                  
              }
           });  
       } 
   });
   layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
   layoutContainer.setBorders(false);
   

   LayoutContainer layoutContainer_1 = new LayoutContainer();
   layoutContainer_1.setLayout(new ColumnLayout());
   
   LayoutContainer layoutContainer_101 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_101.setLayout(frmlytSch);
   
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
                	checkInsr4200Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
   layoutContainer_101.add(srhEmymtDivCd, new FormData("100%"));
   layoutContainer_101.setBorders(false); 
   
   LayoutContainer layoutContainer_102 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(1); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
   frmlytSch.setDefaultWidth(0);
   layoutContainer_102.setLayout(frmlytSch);
   
   
   
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
   //srhRepbtyBusinDivCd.setLabelSeparator("");
  // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
   lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
       public void handleEvent(StoreEvent<BaseModel> be) {  

//       	  EventType type = be.getType();
//	    	   if (type == Store.Add) { 
//           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//           	 }  
         
       }
   });  
   
   layoutContainer_102.add(srhRepbtyBusinDivCd, new FormData("100%"));
   layoutContainer_102.setBorders(false); 
   

   layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
   layoutContainer_1.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
   layoutContainer_1.setBorders(false); 



   lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
   lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
   lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
   //lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));//

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
   	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
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
 	      	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
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
   //srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
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
                	checkInsr4200Auth("srhDeptCd", lsDeptCd); 
        	 }
         
       }
   });    

   srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
      @Override
     public void handleEvent(ComponentEvent ce) { 
              
                 if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                    
                     if (srhDeptCd.getListView().getChecked().size() > 0) {  
                        
                         sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhNofctYr,"year"));    
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
          		   String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
          		   sysComBass0320Dto.setDeptCd(strDeptCd);
          		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
          		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
         	            public void handleEvent(StoreEvent<BaseModel> be) {  
         	             
                           mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                           srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                            
                         }
                     });  
       	    
		         } else {
		       	  
		       	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		      		   String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		      		   sysComBass0320Dto.setDeptCd(strDeptCd);
		       	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		    		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		   	            public void handleEvent(StoreEvent<BaseModel> be) {  
		   	             
		                     mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
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
          
           //new SelectionChangedListener<ModelData>() {
    //@Override
    //public void selectionChanged(SelectionChangedEvent<ModelData> se) {
    //.addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
    //  public void selectionChanged(SelectionChangedEvent<ModelData> se) {
       
           //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//        BaseModel bmPayCd =  se.getSelectedItem(); 
//        if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//            if (bmPayCd != null) {  
//               
//                sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//                sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//            }      
//         
//            //--------------------사업 불러 오는 함수 -------------------------------------------------
//              lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//             //--------------------사업 불러 오는 함수 -------------------------------------------------
//              srhBusinCd.setStore(lsBusinCd); 
//              srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                  public void handleEvent(StoreEvent<BaseModel> be) {  
//                   //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                  }
//              });    
//        
//        }  
       
       } 
   });
   //검색 소속부서 코드 처리  
//   LayoutContainer lccmlcDeptNm = new LayoutContainer();
//   lccmlcDeptNm.setLayout(new ColumnLayout());
//      //부서 
//   srhDeptCd = new TextField<String>();
//   srhDeptCd.setName("srhDeptCd");
//   srhDeptCd.setVisible(false);
//   srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//       @Override
//       public void handleEvent(BaseEvent be) { 
//         if(srhDeptCd.getValue() != null){ 
//            
//                 PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//                 sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhNofctYr,"year")); 
//                 sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//             
//               //--------------------사업 불러 오는 함수 -------------------------------------------------
//                 lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                //--------------------사업 불러 오는 함수 -------------------------------------------------
//                 srhBusinCd.setStore(lsBusinCd); 
//                 srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                     public void handleEvent(StoreEvent<BaseModel> be) {  
//                      //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//                     }
//                 });    
//            
//         } 
//       }
//    });
//   plFrmInsr4200.add(srhDeptCd);
//   srhMangeDeptCd = new TextField<String>();
//   srhMangeDeptCd.setName("srhMangeDeptCd");
//   srhMangeDeptCd.setVisible(false);
//   plFrmInsr4200.add(srhMangeDeptCd);
//   srhMangeDeptNm = new TextField<String>();
//   srhMangeDeptNm.setName("srhMangeDeptNm");
//   srhMangeDeptNm.setVisible(false);
//   plFrmInsr4200.add(srhMangeDeptNm);
//  
//    LayoutContainer lcDeptNm = new LayoutContainer(); 
//    frmlytSch = new FormLayout();
//    frmlytSch.setLabelWidth(70);
//    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//    lcDeptNm.setLayout(frmlytSch);
// 
//    srhDeptNm = new TextField<String>();
//    srhDeptNm.setName("srhDeptNm");
//    srhDeptNm.setFieldLabel("부서");  
//    srhDeptNm.addKeyListener(new KeyListener() {
//         public void componentKeyUp(ComponentEvent event) {
//             super.componentKeyUp(event); 
//             if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                 if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                     srhDeptCd.setValue("");
//                     srhMangeDeptCd.setValue("");
//                 }
//                 fnPopupCommP140(srhDeptNm.getValue());
//             }
//         }
//     });
//    
//    srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//               @Override
//               public void handleEvent(BaseEvent be) { 
//                    
//                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                       srhDeptCd.setValue("");
//                       srhMangeDeptCd.setValue("");
//                   }
//                
//               } 
//      });        
//     lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//     
//      btnSrhDeptCd = new Button();
//      btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//      btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//          public void handleEvent(ButtonEvent e) { 
//              if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                  srhDeptCd.setValue("");
//                  srhMangeDeptCd.setValue("");
//              }
//              fnPopupCommP140(srhDeptNm.getValue()); 
//          }
//      });
//       
//      lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//      lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
        
   layoutContainer_2.add(srhDeptCd, new FormData("100%"));
   layoutContainer_2.setBorders(false);
   
   LayoutContainer layoutContainer_10 = new LayoutContainer();
  
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_10.setLayout(frmlytSch);
   
//   srhTypOccuCd =  new ComboBox<BaseModel>(); 
//   srhTypOccuCd.setName("srhTypOccuCd");
//   srhTypOccuCd.setForceSelection(true);
//   srhTypOccuCd.setMinChars(1);
//   srhTypOccuCd.setDisplayField("typOccuNm");
//   srhTypOccuCd.setValueField("typOccuCd");
//   srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//   srhTypOccuCd.setEmptyText("--직종선택--");
//   srhTypOccuCd.setSelectOnFocus(true); 
//   srhTypOccuCd.setReadOnly(false);
//   srhTypOccuCd.setEnabled(true); 
//   srhTypOccuCd.setStore(lsTypOccuCd);
//   srhTypOccuCd.setFieldLabel("직종");
   //직종 직종세처리  
   LayoutContainer lcTypOccuCd = new LayoutContainer();
   lcTypOccuCd.setLayout(new ColumnLayout());
      
   LayoutContainer layoutContainer_20 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_20.setLayout(frmlytSch); 
   
   
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
   layoutContainer_20.add(srhDeptGpCd, new FormData("100%")); 
   
   LayoutContainer layoutContainer_21 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(1); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
   frmlytSch.setDefaultWidth(0);
   layoutContainer_21.setLayout(frmlytSch);

   
//   srhTypOccuCd = new ComboBox<BaseModel>(); 
//   srhTypOccuCd.setName("srhTypOccuCd");
//   srhTypOccuCd.setForceSelection(true);
//   srhTypOccuCd.setMinChars(1);
//   srhTypOccuCd.setDisplayField("typOccuNm");
//   srhTypOccuCd.setValueField("typOccuCd");
//   srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//   srhTypOccuCd.setEmptyText("--직종선택--");
//   srhTypOccuCd.setSelectOnFocus(true); 
//   srhTypOccuCd.setReadOnly(false);
//   srhTypOccuCd.setEnabled(true); 
//   srhTypOccuCd.setStore(lsTypOccuCd); 
//   srhTypOccuCd.setFieldLabel("직 종");  
//   srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//       public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//           //직종변경에 따른 직종세 값 가져오기
//           String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//           if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//               sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//               sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//               if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                   LsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                   srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//               }
//           }
//       } 
//   }); 
//   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//       public void handleEvent(StoreEvent<BaseModel> be) {  
 
//         
//           
//       }
//   });    
   srhTypOccuCd = new MSFMultiComboBox<ModelData>();
   srhTypOccuCd.setName("srhTypOccuCd"); 
   srhTypOccuCd.setEmptyText("--직종선택--"); 
   srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
   srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
   srhTypOccuCd.setWidth(100);
   srhTypOccuCd.setHideLabel(true);
   //srhTypOccuCd.setFieldLabel("직종");
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
                	//checkInsr4200Auth("srhTypOccuCd", lsTypOccuCd); 
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
 //  lcSchRight.setStyleAttribute("paddingRight", "10px");
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(1); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
   frmlytSch.setDefaultWidth(0);
  // fieldSet.setLayout(layout);  
   lcSchRight.setLayout(frmlytSch);
   
   /** column 직종세코드 : dtilOccuInttnCd */
//   srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//   srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//   srhDtilOccuInttnCd.setForceSelection(true);
//   srhDtilOccuInttnCd.setMinChars(1);
//   srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//   srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//   srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//   srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//   srhDtilOccuInttnCd.setSelectOnFocus(true); 
//   srhDtilOccuInttnCd.setReadOnly(false);
//   srhDtilOccuInttnCd.setEnabled(true);  
//   srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
// //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//   srhDtilOccuInttnCd.setLabelSeparator("");
  
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
   
   lcTypOccuCd.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
   lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
   lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
   layoutContainer_21.setBorders(false);

   layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
   layoutContainer_10.setBorders(false);


   fieldSet.add(layoutContainer_13);
   layoutContainer_13.setBorders(false);

   //   LayoutContainer layoutContainer_3 = new LayoutContainer();
   //   layoutContainer_3.setLayout(new ColumnLayout());
   //   
   //  
   //    
   //   fieldSet.add(layoutContainer_3);
   //   layoutContainer_3.setBorders(false);
   layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
   layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
   layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
   //layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));

   LayoutContainer lcSchCol3 = new LayoutContainer();
   lcSchCol3.setLayout(new ColumnLayout());

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
//   srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	   @Override
//	   public void handleEvent(BaseEvent be) {  
//		   if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//			   srhSystemkey.setValue("");
//			   srhResnRegnNum.setValue("");
//		   }
//
//	   } 
//   }); 
   layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
   layoutContainer_6.setBorders(false);

   Button btnHanNm = new Button("검색");
   layoutContainer_5.add(btnHanNm);
   btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	   public void handleEvent(ButtonEvent e) {
		   srhSystemkey.setValue("");
		   srhResnRegnNum.setValue("");   
		   fnPopupPsnl0100() ;

	   }
   });

   LayoutContainer layoutContainer_7 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(0); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
   layoutContainer_7.setLayout(frmlytSch);

   /** column 주민등록번호 : resnRegnNum */
   srhResnRegnNum = new TextField<String>();
   srhResnRegnNum.setName("srhResnRegnNum");
   new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
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
   layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.41));
   layoutContainer_7.setBorders(false); 
   layoutContainer_5.setBorders(false);


   LayoutContainer layoutContainer_14 = new LayoutContainer();
   frmlytSch = new FormLayout();  
   frmlytSch.setLabelWidth(60); 
   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
   layoutContainer_14.setLayout(frmlytSch);
   

   srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
   srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
//   srhHdofcCodtnCd.setForceSelection(true);
//   srhHdofcCodtnCd.setMinChars(1);
//   srhHdofcCodtnCd.setDisplayField("commCdNm");
//   srhHdofcCodtnCd.setValueField("commCd");
  // srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
   srhHdofcCodtnCd.setEmptyText("--재직선택--");
//   srhHdofcCodtnCd.setSelectOnFocus(true); 
   srhHdofcCodtnCd.setReadOnly(true);
   srhHdofcCodtnCd.setEnabled(true); 
  // srhHdofcCodtnCd.setStore(lsHdofcCodtnCd); 
   srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
   srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
   srhHdofcCodtnCd.setWidth(100);
//   srhHdofcCodtnCd.setHeight(100);
   srhHdofcCodtnCd.setFieldLabel("재직상태");
   srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
       public void handleEvent(StoreEvent<ModelData> be) {  
    	   checkInsr4200Auth("srhHdofcCodtnCd",lsHdofcCodtnCd);  
         
       }
   }); 
   srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
  
   
   layoutContainer_14.add(srhHdofcCodtnCd, new FormData("100%"));
  
   layoutContainer_14.setBorders(false);
   
 
   lcSchCol3.setBorders(false);
   lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
   lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
   lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
   
   fieldSet.add(lcSchCol3);
   
   plFrmInsr4200.add(fieldSet); 

   //vp.add(panel);   
}  

	private void  displayDtilOccuInttnCd() {
		if(	  (srhTypOccuCd.getListView().getChecked().size() > 0)
		   && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")))) {
			
			/* 2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 */
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
			List<ModelData> mdDeptCdSelect = srhDeptCd.getListView().getChecked();
			String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect, "deptCd");
			sysComBass0350Dto.setDeptCd(strDeptCd);
			List<ModelData> mdListSelect = srhTypOccuCd.getListView().getChecked();
			String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect, "typOccuCd");
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//			sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "pyspGrdeCd"));
			
			if(MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
				lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
//				srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
				lsDtilOccuInttnCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistDtilOccuInttnCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd);
						srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
						if(!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0);
							
//							if(MSFSharedUtils.paramNotNull(lsMdSelect) && (lsMdSelect.size() > 0)) {
//								for(int iTyCnt = 0; iTyCnt < lsMdSelect.size(); iTyCnt++) {
//									ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//									if(tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//										mdSelect = tpMdSelect;
//									}
//								}
								
								srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true);
								srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
//							}  
						}
					}
				});
			}
		} else {
			
		}
		
		/* 직종변경에 따른 직종세 값 가져오기 */
//		String strTypOccuCd = MSFSharedUtils.getSelectedComboValue(srhTypOccuCd, "typOccuCd");
//		if(MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//			sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//			sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd, "pyspGrdeCd"));
//			if(MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//				lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
//				srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
//			}
//		}
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
	
	private void createForm() {
//		FieldSet fieldSet = new FieldSet();
//		fieldSet.setSize("958px", "442px");  //492
//		fieldSet.setHeadingHtml("");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setSize(958, 445);
		cp01.setLayout(new FitLayout());
		
		LayoutContainer layoutContainer_16 = new LayoutContainer();
		layoutContainer_16.setLayout(new ColumnLayout());
//		layoutContainer_16.setBorders(false);
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
//		fldstNewFieldset.setSize("934px", "424px");
		
		fldstNewFieldset.add(createCheckBoxGrid(),new FormData("100%"));
		fldstNewFieldset.setHeadingHtml("월정산대사정보");
		fldstNewFieldset.setCollapsible(false);
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");
		layoutContainer_1.add(fldstNewFieldset);
		layoutContainer_16.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		cp01.add(layoutContainer_16);
		layoutContainer_16.setSize("958", "450");
		layoutContainer.add(cp01);
//		fieldSet.add(layoutContainer,new FormData("100%"));
		
		plFrmInsr4200.add(layoutContainer);
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
	
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 그리드 처리 함수 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	private LayoutContainer createCheckBoxGrid() {
		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);
		
		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(945, 400);
		
		insr3200GridPanel = new MSFGridPanel(insr3200Def, false, false, false, false, false );
		insr3200GridPanel.setHeaderVisible(false);
		insr3200GridPanel.setBodyBorder(true);
		insr3200GridPanel.setBorders(true);
		
		AggregationRowConfig<BaseModel> insr3200SummaryRow = new AggregationRowConfig<BaseModel>();  
		 
		insr3200SummaryRow.setCellStyle(Insr3200BM.ATTR_NOFCTYRMNTH,"summary_color");
		insr3200SummaryRow.setCellStyle(Insr3300BM.ATTR_HLTHINSRPRMMSRD,"summary_color");
		insr3200SummaryRow.setCellStyle(Insr3300BM.ATTR_LGTMRCPTNINSURSRD,"summary_color");
		insr3200SummaryRow.setCellStyle(Insr3300BM.ATTR_SRDAGGRSUM,"summary_color");
		    
		insr3200SummaryRow.setHtml(Insr3200BM.ATTR_NOFCTYRMNTH, "합 계");   
		    
		// with summary type and format  
		insr3200SummaryRow.setSummaryType(Insr3300BM.ATTR_HLTHINSRPRMMSRD, SummaryType.SUM);   
		insr3200SummaryRow.setSummaryFormat(Insr3300BM.ATTR_HLTHINSRPRMMSRD, NumberFormat.getFormat("#,##0;(#,##0)"));  
		
		insr3200SummaryRow.setSummaryType(Insr3300BM.ATTR_LGTMRCPTNINSURSRD, SummaryType.SUM);   
		insr3200SummaryRow.setSummaryFormat(Insr3300BM.ATTR_LGTMRCPTNINSURSRD, NumberFormat.getFormat("#,##0;(#,##0)"));  
		
		insr3200SummaryRow.setSummaryType(Insr3300BM.ATTR_SRDAGGRSUM, SummaryType.SUM);   
		insr3200SummaryRow.setSummaryFormat(Insr3300BM.ATTR_SRDAGGRSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		      
		insr3200GridPanel.getGrid().getColumnModel().addAggregationRow(insr3200SummaryRow);  		
		
		/* 2줄파싱 */
		insr3200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 9,  new HeaderGroupConfig("건강보험",		1, 4));
		insr3200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 13, new HeaderGroupConfig("장기요양보험",	1, 4));
		
		cpGrid.add(insr3200GridPanel);
		lcStdGrid.add(cpGrid);
		
		return lcStdGrid;
	}
	
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 그리드 처리 함수 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	private void createBottom() {
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("건강보험월정산대사내역업로드");
		//fldstNewFieldset.setStyleAttribute("marginTop", "15px");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout());
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);
		layoutContainer_21.setBorders(false);
		
		insr4200flUp = new FileUploadField();
		insr4200flUp.setName("insr4200flUp");
		insr4200flUp.setValidator(new Validator() {
			@Override
			public String validate(Field<?> field, String value) {
				value = value.toLowerCase();
				String result = "xls 파일이 아닙니다., 다시선택하십시요.";
				if(value.endsWith(".xls") || value.endsWith(".xlsx")) {
					result = null;
				}
				return result;
			}
		});
		layoutContainer_21.add(insr4200flUp, new FormData("100%"));
		insr4200flUp.setFieldLabel("양식선택");
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setStyleAttribute("paddingRight", "5px");
		/*layoutContainer_3.setStyleAttribute("paddingLeft", "5px");*/
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSch);
		
		Button btnButton01 = new Button("업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsImportData();
			}
		});
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		layoutContainer_3.setBorders(false);
		
		LayoutContainer layoutContainer_42 = new LayoutContainer();
		//layoutContainer_42.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytSch);
		
		srhUploadDivCd  =  new ComboBox<BaseModel>(); 
		srhUploadDivCd.setName("srhRepbtyBusinDivCd");
		srhUploadDivCd.setForceSelection(true);
		srhUploadDivCd.setAllowBlank(false);
		srhUploadDivCd.setMinChars(1);
		srhUploadDivCd.setDisplayField("commCdNm");
		srhUploadDivCd.setValueField("commCd");
		srhUploadDivCd.setTriggerAction(TriggerAction.ALL);
		srhUploadDivCd.setEmptyText("--업로드구분--");
		srhUploadDivCd.setSelectOnFocus(true); 
		srhUploadDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		srhUploadDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		srhUploadDivCd.setStore(lsUploadDivCd);
		srhUploadDivCd.setHideLabel(true);
		lsUploadDivCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
		

			EventType type = be.getType();
			if (type == Store.Add) { 
				lsUploadDivCd.getAt(0);
			 }  
			
		
		}
		}); 
		
		LayoutContainer layoutContainer_43 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.LEFT);
		layoutContainer_43.setLayout(frmlytSch);
		
		layoutContainer_43.add(srhUploadDivCd, new FormData("70%"));
		layoutContainer_43.setBorders(false); 
		
		
		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportData();
			}
		});
		layoutContainer_42.add(btnButton02, new FormData("100%"));
		layoutContainer_42.setBorders(false);
		
		layoutContainer_2.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_2.add(layoutContainer_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		layoutContainer_2.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.1);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
		layoutContainer.add(layoutContainer_1);
		layoutContainer_1.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
//		layoutContainer_4.setStyleAttribute("paddingRight", "10px");
//		layoutContainer_4.setStyleAttribute("paddingLeft", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(400);
		frmlytSch.setLabelAlign(LabelAlign.LEFT);
		layoutContainer_4.setLayout(frmlytSch);
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button topBtn01 = new Button("월별변동");
//		topBtn.setIcon(Resources.APP_ICONS.print16());
		buttonBar.add(topBtn01);
		topBtn01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				InsrP420001 insrP42001Form = new InsrP420001(ActionDatabase.CUSTOM, getThis());
				MSFFormWindows msFwInsr42001 = new MSFFormWindows("월별변동내역", insrP42001Form, "닫기", "1010px", "650px", true);
				msFwInsr42001.show();
				insrP42001Form.setMSFFormWindows(msFwInsr42001);
//				insrP41002Form.bind(ppRecord);
			}
		});
		
		Button topBtn05 = new Button("정산대사");
//		topBtn03.setIcon(Resources.APP_ICONS.excel16());
		buttonBar.add(topBtn05);
		topBtn05.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				payRflctn("pay");
			}
		});
		
		Button topBtn03 = new Button("당월반영");
//		topBtn03.setIcon(Resources.APP_ICONS.excel16());
		buttonBar.add(topBtn03);
		topBtn03.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				payRflctn("this");
			}
		});
		
		
		Button topBtn02 = new Button("차월반영");
//		topBtn02.setIcon(Resources.APP_ICONS.print16());
		buttonBar.add(topBtn02);
		topBtn02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				payRflctn("next");
			}
		});
		

		
		Button topBtn04 = new Button("반영취소");
//		topBtn03.setIcon(Resources.APP_ICONS.excel16());
		buttonBar.add(topBtn04);
		topBtn04.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				payRflctn("cancel");
			}
		});
		
		layoutContainer_4.add(buttonBar, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_4, hbld_layoutContainer_2);
		layoutContainer_4.setBorders(false);
		
		plFrmInsr4200.add(fldstNewFieldset);
		
		
		LabelField lbFld = new LabelField();
		lbFld.setValue("※ 정산대사는 급여마감 후에 처리 가능합니다.");
		plFrmInsr4200.add(lbFld);
		
	}
	
	public void reload() {
		// formInit();
		
	 
		IColumnFilter filters = null;
		
		String strDeptCd		  = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,			 srhDeptCd.getValue(),			"deptNmRtchnt",	 "deptCd");
		String strTypOccuCd		  = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,		 srhTypOccuCd.getValue(),		"typOccuNm",	 "typOccuCd");
		
		String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm", "dtilOccuInttnCd"); /*직종세*/ 
		String strHdofcCodtnCd	  = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		
		insr3200GridPanel.getTableDef().setTableColumnFilters(filters);
		
		insr3200GridPanel.getTableDef().addColumnFilter(   "nofctYrMnth"
														,  (MSFSharedUtils.getSelectedComboValue(srhNofctYr,   "year")
														  + MSFSharedUtils.getSelectedComboValue(srhNofctMnth, "month")
														   )
														,  SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3200GridPanel.getTableDef().addColumnFilter(  "payrMangDeptCd"
														, MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd")
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );
		insr3200GridPanel.getTableDef().addColumnFilter(  "emymtDivCd"
														, MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")
														, SimpleColumnFilter.OPERATOR_EQUALS
													   ); 
		
		//20180305추가 
		insr3200GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr3200GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		insr3200GridPanel.getTableDef().addColumnFilter("deptCd",		   strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
		insr3200GridPanel.getTableDef().addColumnFilter("typOccuCd",	   strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
		insr3200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
		insr3200GridPanel.getTableDef().addColumnFilter(  "businCd"
														, MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd")
														, SimpleColumnFilter.OPERATOR_EQUALS
													   ); 
		insr3200GridPanel.getTableDef().addColumnFilter(  "systemkey"
														, MSFSharedUtils.allowNulls(srhSystemkey.getRawValue())
														, SimpleColumnFilter.OPERATOR_EQUALS
													   ); 
		insr3200GridPanel.getTableDef().addColumnFilter(  "hanNm"
														, MSFSharedUtils.allowNulls(srhHanNm.getRawValue())
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );    
		insr3200GridPanel.getTableDef().addColumnFilter(  "resnRegnNum"
														, MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue())
														, SimpleColumnFilter.OPERATOR_EQUALS
													   );  
		
		if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for(int i = 0; i < ray.length; i++) {
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd") + ",";
			}
			strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		}
		insr3200GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS);
		
		insr3200GridPanel.reload();
	}
	
	/* 폼초기화 검색조건포함   - 권한 문제로 인하여 초기화시 성명, 주민번호 만 초기화 해줄것(배다은 주임) 2017.04.19 */
	private void formInit() {
		
		authExecEnabled();
		srhHanNm.clear(); /* 성명 */
		srhResnRegnNum.clear(); /* 주민번호 */
		
		insr4200flUp.clear(); /* 파일업로드 필드  */

		insr3200GridPanel.getMsfGrid().clearData(); /*그리드 초기화 */
	}
	
	public void setRecord(BaseModel record) {
		this.record = record;
	}
	
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	private Insr4200 getThis() {
		return this;
	}
	
	private void fnPopupPsnl0100() {
		/* 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.	*/
		/* 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.		*/	
		/* 	검색.처리하면됨.										*/
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());	/* 인사 */
//		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();	/* 우편번호 */
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
		
		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if(!"".equals(mapModel.get("systemkey"))) {
					srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));	/* 시스템키 */
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));	/* 주민번호 */
				}
			}
		});
	}
	
	private void xlsImportData() {
		MessageBox.confirm(	 "건강보험 월별대사-업로드"
						   , "월별대사내역을 업데이트 하시겠습니까?<br>(등록되어있는 월별대사 내역은 삭제 처리 됩니다.)"
						   , new Listener<MessageBoxEvent>() {
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					HashMap<String, String> param = new HashMap<String, String>();
					String year	 = InsrUtils.getSelectedComboValue(srhNofctYr,	 "year");
					String month = InsrUtils.getSelectedComboValue(srhNofctMnth, "month");
					String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
					if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
						String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
						String chkkey = "";
						for(int i = 0; i < ray.length; i++) {
							BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
							chkkey += bmData.get("commCd") + ",";
						}
						strHdofcCodtnCd = chkkey.substring(0, chkkey.length() - 1);
					}
					
					param.put("nofctYrMnth", year.concat(month));
					param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
					param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
					param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));
					param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));
//					param.put("pyspGrdeCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "pyspGrdeCd"));
					param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm", "dtilOccuInttnCd"));
					param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
					param.put("hdofcCodtnCd", strHdofcCodtnCd);
					param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
					param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
					param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
					String filename = MSFSharedUtils.allowNulls(insr4200flUp.getValue());
					
//                     if("".equals(year) || "".equals(month)){
//                         MessageBox.info("", "작업년월은 필수 입니다.", null);
//                     }else if("".equals(payCd)){
//                         MessageBox.info("", "급여구분은 필수 입니다.", null);
//                     }else if("".equals(workDayS) || "".equals(workDayE)){
//                         MessageBox.info("", "근태기간은 필수 입니다.", null);
//                     } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
//                  	    if("".equals(businCd)){
//                     			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//              	                         "사업명을 선택하십시요.", null);
//                       		 
//               		     } else {
//               		    	   //get the filename to be uploaded
//                               String filename = MSFSharedUtils.allowNulls(dlgn0250flUp.getValue());
//                               if (filename.length() == 0) {
//                                  Window.alert("선택된 파일이 없습니다.");
//                               } else {
//                                  //submit the form
//                                   plFrmInsr4200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
//                                   //파일업로드 처리
//                                   plFrmInsr4200.setAction(GWT.getHostPageBaseURL() + "imp/XlsInsr4200Import.do");
//                                   plFrmInsr4200.setEncoding(Encoding.MULTIPART);
//                                   plFrmInsr4200.setMethod(Method.POST);   
////                                   FormElement frmEl=FormElement.as(plFrmInsr4200.getElement()); 
////                                   frmEl.setAcceptCharset("UTF-8"); 
//                                   plFrmInsr4200.submit();  
//                                   plFrmInsr4200.onFrameLoad();  
//                                   picBoolFile = true;
//                                                   
//                               }               
//                                
//                             // reset and unmask the form 
//                             // after file upload 
//                             plFrmInsr4200.addListener(Events.Submit, new Listener<FormEvent>() {
//                                 public void handleEvent(FormEvent evt) {   
//                                     if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//                                         //업로드가  성공했으면 인서트 모듈을 태운다. 
//                                           plFrmInsr4200.unmask();  
//                                           MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
//                                           picBoolFile = false;
//                                           evt.setResultHtml("");
//                                     } else {
//
//                                         if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
//                                             //업로드가  성공했으면 인서트 모듈을 태운다.
//                                             MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
//                                             picBoolFile = false;
//                                             evt.setResultHtml("");
//                                         } else {
//                                             //실패 메시지나 에러 메시지 처리 . 
//                                             evt.setResultHtml("");
//                                         } 
//                                     }
//                                     
//                                 };
//                              }); 
//               		     }
//                     }else{ 
                         

                         //get the filename to be uploaded					
					if (filename.length() == 0) {
						Window.alert("선택된 파일이 없습니다.");
					} else {
				   		if("".equals( MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd")) )){
							MessageBox.info("", "업로드구분은 필수 입니다.", null);
							return;
						}
						
						/* submit the form */

						plFrmInsr4200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중...");
						
					    // Create a new timer that calls Window.alert().
					    Timer t = new Timer() {
					      @Override
					      public void run() {
					    	  plFrmInsr4200.unmask();
					    	
					      }
					    };
					    t.schedule(4000);
					    // Schedule the timer to run once in 5 seconds.
					   
					    String strUpDivCd =  MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd"));
						 
					    String rtnRequestUrl = "";
					    
					    if("I0300002".equals(strUpDivCd)){  //세부업로드
				        	
					    	rtnRequestUrl = "imp/XlsInsr4200Import.do";
				        }else{  // 간단업로드 
				        	
				        	rtnRequestUrl = "imp/XlsInsr4200_1Import.do";
				        }
					    
						
						/* 파일업로드 처리 */
						plFrmInsr4200.setAction(GWT.getHostPageBaseURL() + rtnRequestUrl);
						plFrmInsr4200.setEncoding(Encoding.MULTIPART);
						plFrmInsr4200.setMethod(Method.POST);
//						FormElement frmEl=FormElement.as(plFrmInsr4200.getElement());
//						frmEl.setAcceptCharset("UTF-8");
						plFrmInsr4200.submit();
						plFrmInsr4200.onFrameLoad();
						
						 
						
						picBoolFile = true;
					}
					/* reset and unmask the form */
					/* after file upload */ 
					plFrmInsr4200.addListener(Events.Submit, new Listener<FormEvent>() {
						public void handleEvent(FormEvent evt) {
							if("success".endsWith(evt.getResultHtml()) && picBoolFile) {
								/* 업로드가  성공했으면 인서트 모듈을 태운다. */
								//plFrmInsr4200.unmask();
								//Window.alert(evt.getResultHtml());
								//MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null);
								picBoolFile = false;
								evt.setResultHtml("");
							} else {
								if("error".endsWith(evt.getResultHtml()) && picBoolFile) {
									/* 업로드가  성공했으면 인서트 모듈을 태운다. */
									MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
									picBoolFile = false;
									evt.setResultHtml("");
								} else {
									/* 실패 메시지나 에러 메시지 처리 . */
									evt.setResultHtml("");
								}
							}
						};
					});
				}
			}
		});
	}
	
	/* 엑셀 양식 다운 */
	private void xlsExportData() {
		
		if("".equals(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd")) ){
			MessageBox.info("", "업로드구분은 필수 입니다.", null);
			return;
		}
		
		MessageBox.info("", "건강보험 가입자 고지(산출)내역서를 다운받아 업로드 하시면됩니다.\n(엑셀형식만 적용가능)", null);
		HashMap<String, String> param = new HashMap<String, String>();
		
		String year	 = InsrUtils.getSelectedComboValue(srhNofctYr,	 "year");
		String month = InsrUtils.getSelectedComboValue(srhNofctMnth, "month");
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for(int i = 0; i < ray.length; i++) {
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd") + ",";
			}
			strHdofcCodtnCd = chkkey.substring(0, chkkey.length() - 1);
		}
		
		param.put("nofctYrMnth",	 year.concat(month));
		param.put("payrMangDeptCd",	 MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
		param.put("emymtDivCd",		 MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
		param.put("deptCd",			 InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));
		param.put("typOccuCd",		 InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));
		param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(	 lsDtilOccuInttnCd
																	   , srhDtilOccuInttnCd.getValue()
																	   , "dtilOccuClsNm"
																	   , "dtilOccuInttnCd")
																	  );
		param.put("businCd",		 MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
		param.put("hdofcCodtnCd",	 strHdofcCodtnCd);
		param.put("systemkey",		 MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
		param.put("hanNm",			 MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum",	 MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		param.put("uploadDivCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd")));
		
		GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsInsr4200TempExport.do", "extgwtFrame", JsUtil.toJavaScriptObject(param));
	}
	
	/* 엑셀 다운로드 */
	private void excelFileExport() {
		HashMap<String, String> param = new HashMap<String, String>();
		
		String year	 = InsrUtils.getSelectedComboValue(srhNofctYr,	 "year");
		String month = InsrUtils.getSelectedComboValue(srhNofctMnth, "month");
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if(MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for(int i = 0; i < ray.length; i++) {
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd") + ",";
			}
			strHdofcCodtnCd = chkkey.substring(0, chkkey.length() - 1);
		}
		
		param.put("nofctYrMnth",	 year.concat(month));
		param.put("payrMangDeptCd",	 MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		param.put("emymtDivCd",		 MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
		param.put("deptCd",			 InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));
		param.put("typOccuCd",		 InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));
		param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(	 lsDtilOccuInttnCd
																	   , srhDtilOccuInttnCd.getValue()
																	   , "dtilOccuClsNm"
																	   , "dtilOccuInttnCd"
																	  ));
		param.put("businCd",		 MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
		param.put("hdofcCodtnCd",	 strHdofcCodtnCd);
		param.put("systemkey",		 MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
		param.put("hanNm",			 MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum",	 MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		
		GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsFileInsr4200Export.do", "extgwtFrame", JsUtil.toJavaScriptObject(param));
	}
	
	/* 당/차월 급여 반영 */
	private void payRflctn(String monthDiv) {
		
		Iterator<BaseModel> itBm = insr3200GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		
		if(MSFSharedUtils.paramNotNull(itBm)) {
			List<Insr3300DTO> listInsr3300dto = new ArrayList<Insr3300DTO>();
			List<Record>  lsRec  = new ArrayList<Record>();
			
			while(itBm.hasNext()) {
				Record rec  = new Record(itBm.next());
				lsRec.add(rec);
			}
			
			Iterator<Record> iterRecords = lsRec.iterator();
			
			while(iterRecords.hasNext()) {
//			while(records.hasNext()) {
				
				actionDatabase = ActionDatabase.UPDATE;
//				Record record = (Record)records.next();
				Record record = (Record)iterRecords.next();
				BaseModel bmMapModel = (BaseModel)record.getModel();
				
				Insr3300DTO insr3300dto = new Insr3300DTO();
				
				insr3300dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get(		   "dpobCd")));			/** 사업장코드		: dpobCd			*/
				insr3300dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get(	   "systemkey")));		/** SYSTEMKEY		: systemkey			*/
				insr3300dto.setNofctYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get(   "nofctYrMnth")));	/** 고지년월			: nofctYrMnth		*/
				insr3300dto.setNofctDspty((Long)bmMapModel.get(						   "nofctDspty"));		/** 고지차수			: nofctDspty		*/
				insr3300dto.setDducYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get(	   "dducyrMnth")));		/** 공제년월			: dducyrMnth		*/
				insr3300dto.setHlthInsrPrmmSrd((Long)bmMapModel.get(						   "hlthInsrPrmmSrd"));		/** 건강보험보험료차액			: hlthInsrPrmmSrd		*/
				insr3300dto.setLgtmRcptnInsurSrd((Long)bmMapModel.get(						   "lgtmRcptnInsurSrd"));		/** 장기요양보험차액			: lgtmRcptnInsurSrd		*/
				insr3300dto.setSrdAggrSum((Long)bmMapModel.get(						   "srdAggrSum"));		/** 차액합계			: srdAggrSum		*/
				insr3300dto.setHlthInsrPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("hlthInsrPrcsDt")));	/** 건강보험처리일자	: hlthInsrPrcsDt	*/
				insr3300dto.setHlthInsrPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("hlthInsrPrcsYn")));	/** 건강보험처리여부	: hlthInsrPrcsYn	*/
				insr3300dto.setDivdPymt((Long)bmMapModel.get(						   "divdPymt"));		/** 분할납부횟수		: divdPymt			*/
				insr3300dto.setCalcPrmm((Long)bmMapModel.get(						   "calcPrmm"));		/** 급여 건강보험 산출보험료		: divdPymt			*/
				insr3300dto.setLgtmRcptnCalcPrmm((Long)bmMapModel.get(						   "lgtmRcptnCalcPrmm"));		/**급여 장기요양 산출보험료		: divdPymt			*/
				
				if(monthDiv.equals("this")) {
					insr3300dto.setDducYrMnth("this");
				} else if(monthDiv.equals("next")) {
					insr3300dto.setDducYrMnth("next");
				} else if(monthDiv.equals("cancel")) {
					insr3300dto.setDducYrMnth("cancel");
				}else if(monthDiv.equals("pay")) {
					insr3300dto.setDducYrMnth("pay");
				}
				
				listInsr3300dto.add(insr3300dto);
			}
			
			if(listInsr3300dto.size() <= 0) {
				MessageBox.alert(actionDatabase + "저장", actionDatabase + "처리할 데이타가 존재하지 않습니다.", null);
				return;
			}
			
			insr4200Service.activityOnInsr3300(listInsr3300dto, actionDatabase, new AsyncCallback<Long>() {
				public void onFailure(Throwable caught) {
					MessageBox.alert(  MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									 , MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsr3300(" + actionDatabase.name() + ") : " + caught)
									 , null
									);
				}
				public void onSuccess(Long result) {
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					} else {
                        if(result == -99L){
                        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "미마감된 급여월 대상자는 정산대사가 불가합니다.",null);
                        }else if(result == -88L){
                        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "마감된 급여월 대상자는 당월반영이 불가합니다.",null);
                        }else{
						
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + "처리가 완료되었습니다.", null);
							reload();
							actionDatabase = ActionDatabase.UPDATE;
                        }
					}
				}
			});
		} else {
			MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
			return;
		}
	}
	
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
