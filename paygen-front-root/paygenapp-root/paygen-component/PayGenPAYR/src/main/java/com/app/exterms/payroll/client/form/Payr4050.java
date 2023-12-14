package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.form.defs.Payr0250Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr4050Service;
import com.app.exterms.payroll.client.service.Payr4050ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0350;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFServiceFailureHandler;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
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
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr4050  extends MSFPanel { 

	 
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
	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;
	 
	  private VerticalPanel vp;
	  private FormPanel plFrmPayr4050;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	      
	   private Payr0250Def payr0250Def  = new Payr0250Def();   //그리드 테이블 컬럼 define  
	  // private MSFCustomForm msfCustomForm; 
	   private MSFGridPanel payr0250GridPanel;


      //지급년도  
//      private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
//      private MSFGridPanel payYrGridPanel;
       

      //직종세콤보
      private LookupPrgmComBass0350 lkDtilOccuClsDivCd = new LookupPrgmComBass0350();  
      private MSFGridPanel dtilOccuClsDivCdGridPanel;
      
      private ContentPanel cpGridPayr0250;
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
     private ButtonBar topPayr4050Bar;
     private Button btnPayr4050New;
     private Button btnPayr4050Save;
     private Button btnPayr4050Del;
     private Button btnPayr4050Sreach;
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
      
     private ComboBox<BaseModel> srhBusinCd;    //사업 
     
     //private ComboBox<BaseModel> srhTypOccuCd; //직종 
     //private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
     //private HiddenField<String> srhPyspGrdeCd; //직종
      
     private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
     private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
     private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
     
     private TextField<String> srhDeptCd; //부서코드
     private TextField<String> srhDeptNm; //부서명  
     private Button btnSrhDeptCd;
  //   private TextField<String> srhMangeDeptCd; //관리부서 수정
  //   private TextField<String> srhMangeDeptNm; //관리부서 수정  
     
     private List<ModelData> mDtalistDeptCd ;
     private List<ModelData> mDtalistTypOccuCd ;
     private List<ModelData> mDtalistDtilOccuInttnCd ;
     private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

 	 private Boolean emptyCheck = false ;
     private boolean mutilCombo = false;
     private boolean statCheck = false;
     
     private BaseModel ppRecord; //팝업에 넘길 레코드 값 
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
      
    // 
     
     
	  private void checkPayr4050Auth(String authAction, ListStore<BaseModel> bm) {   
    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
               //------------------------------  
              //  if (!maskTracker) { unmask(); }
               //MSFMainApp.unmaskMainPage();
                authExecEnabled() ;
                gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
		   }
	  } 
 
	 private void authExecEnabled() { 
	  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       * 권한설정을 위한 콤보처리를 위한 메서드 시작 
       * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	     Field<?>[] fldArrField = {srhDeptCd,srhDeptNm,srhPayrMangDeptCd,srhEmymtDivCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd}; 
	     gwtAuthorization.formAuthFieldConfig(fldArrField);
	     
	     
	     srhPayYr.setValue(lsPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date()))); 
	     srhPayCd.setValue(lsPayCd.getAt(0));
	     payr0250Def.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));
	  //   gwtAuthorization.formAuthFieldConfig(srhPayrMangDeptCd,srhEmymtDivCd,strArrDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd);
//             gwtAuthorization.formAuthPopConfig(plFrmPayr4050, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
//            gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
        //GWTAuthorization.formAuthConfig(plFrmPayr4050, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
      /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       * 권한설정을 위한 콤보처리를 위한 메서드 종료
       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        srhDeptCd.fireEvent(Events.Add); 
        
      
	 }
	 
//	 private void initPayComboDisplay() {
//		      
//		     String usrDivCd = ""; 
//		     usrDivCd =  MSFMainApp.get().getUser().getUsrDivCd(); 
//		     
//		     if (lsEmymtDivCd.getCount() > 0 && lsPayrMangDeptCd.getCount() > 0) {
//		    	 
//			      if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(usrDivCd)) || (MSFConfiguration.AUTH_USR_DIV_40.equals(usrDivCd))) {
//		              //기간제업무담당자- 기간제업무담당자  총괄 
//			    		srhPayrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()));
//			    		srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
//			    		 
//			    		srhDeptCd.setValue(MSFMainApp.get().getUser().getDeptCd()); 
//			    		//srhDeptCd.setValue(lsDeptCd.findModel("deptCd",MSFMainApp.get().getUser().getDeptCd()));  
//			    		srhDeptNm.setValue(MSFMainApp.get().getUser().getDeptNm());
//			    		
//		           } else  if (MSFConfiguration.AUTH_USR_DIV_10.equals(usrDivCd)) {
//		                //무기계약직업무담당자- 무기계약직업무담당자
//		        	    srhPayrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()));
//			    		srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
//			    		srhDeptCd.setValue(MSFMainApp.get().getUser().getDeptCd());
//			    		//srhDeptCd.setValue(lsDeptCd.findModel("deptCd",MSFMainApp.get().getUser().getDeptCd())); 
//			    		srhDeptNm.setValue(MSFMainApp.get().getUser().getDeptNm());
//		        	    
//		           } else  if (MSFConfiguration.AUTH_USR_DIV_25.equals(usrDivCd)) {
//		               //[겸직] 무기계약직및 기간제 동일처리 필요한 부분 
//		        	    srhPayrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd()));
//			    		srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
//			    		//텍스트 
//			    		srhDeptCd.setValue(MSFMainApp.get().getUser().getDeptCd());
//			    		//srhDeptCd.setValue(lsDeptCd.findModel("deptCd",MSFMainApp.get().getUser().getDeptCd())); 
//			    		srhDeptNm.setValue(MSFMainApp.get().getUser().getDeptNm());
//		                 
//		           } else  if (MSFConfiguration.AUTH_USR_DIV_30.equals(usrDivCd)) {
//		             //무기계약직업무담당자- 무기계약직업무담당자 총괄 
//		        	  //콤보일경우
//		        	    srhPayrMangDeptCd.setValue(lsPayrMangDeptCd.getAt(0));
//			    		srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
//		        	   //텍스트일경우 두가지처리
//		           } else  if (MSFConfiguration.AUTH_USR_DIV_60.equals(usrDivCd)) { 
//		        	     srhPayrMangDeptCd.setValue(lsPayrMangDeptCd.getAt(0));
//			    		 srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0));
//		           } else   { 
//		        	     srhPayrMangDeptCd.setValue(lsPayrMangDeptCd.getAt(0));
//			    		 srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
//		           }  
//		 
//		     }
//		 
//	 }
	 
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
	        		 //  authExecEnabled() ;
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
		     authMapDef.put("PayYr",Boolean.FALSE);
		     authMapDef.put("PayMonth",Boolean.FALSE);
		     authMapDef.put("srhPayCd",Boolean.FALSE);
			 authMapDef.put("PayrMangDeptCd",Boolean.FALSE);
			 authMapDef.put("EmymtDivCd",Boolean.FALSE); 
			// authMapDef.put("TypOccuCd",Boolean.FALSE); 
			 
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
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   //입력수정삭제처리 rpc 처리부     
 	    private Payr4050ServiceAsync payr4050Service = Payr4050Service.Util.getInstance();	 
 	    
 	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
 		private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
 		
 		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
 		
 		private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
 		
 		private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  
 		 //--------------------부서 불러 오는 함수 ------------------------------------------------
 		//private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
 		 //--------------------부서 불러 오는 함수 ------------------------------------------------
 		private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
 		//--------------------사업 불러 오는 함수 -------------------------------------------------
 		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
 	   //--------------------사업 불러 오는 함수 -------------------------------------------------
 		private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
 		 
 		private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
 		
 	    private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
 		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
 		
 		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
 		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
 		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
 		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
 		private SysCoCalendarDTO msfCoCalendarDto;  
 		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
 	 	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
 	 	
 	    private BaseModel record;
 	    
 	   private Iterator<Record> records;
     
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
     private SelectionListener<ButtonEvent> selectionListener = 
 	        new SelectionListener<ButtonEvent>() {
 	        public void componentSelected(ButtonEvent ce) { 
 	        	 if (ce.getButton() == btnPayr4050Save) {
 	            	if (ActionDatabase.INSERT.equals(actionDatabase)) { 
 	            			doAction(ActionDatabase.INSERT);
 	            	} else if (ActionDatabase.UPDATE.equals(actionDatabase) ){ 
 	            	        doAction(ActionDatabase.UPDATE);
 	            	}
 	            }  else if (ce.getButton() == btnPayr4050Del) {
 	                doAction(ActionDatabase.DELETE);
 	            }
 
 	        }  
 	    };
 	  
     private void doAction(ActionDatabase actionDatabase) {
         switch (actionDatabase) {
         case INSERT:
             payr4050Save();  
             break;
         case UPDATE: 
             payr4050Save();
             break;
         case DELETE:  
             payr40500Delete();
             break;
		default:
			break;
         }
     }
      
     public void  payr4050Save() {
    	 //   if (isValid()) {

    	 statCheck = false;
    	 //         setListRecord(payr0250GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator());
    	 records = payr0250GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();

    	 if (payr0250GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {

    		 MessageBox.alert("급여스케줄", "저장할 급여스케줄데이타가 존재하지 않습니다.", null);
    		 return;
    	 }

    	 List<Payr0250DTO> listPayr0250dto = new ArrayList<Payr0250DTO>();  

    	 while (records.hasNext()) {

    		 Record record = (Record) records.next(); 
    		 BaseModel bmMapModel = (BaseModel)record.getModel();

    		 Payr0250DTO payr0250Dto = new Payr0250DTO();

    		 payr0250Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
    		 payr0250Dto.setJobYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("jobYrMnth")));    /** column 작업년월 : jobYrMnth */
    		 payr0250Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));         /** column 급여구분코드 : payCd */

    		 payr0250Dto.setPayScduSeilNum((Long)bmMapModel.get("payScduSeilNum"));            /** column 급여스케줄일련번호 : payScduSeilNum */
    		 payr0250Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
    		
    		 
    		 payr0250Dto.setMangeDeptNm(MSFSharedUtils.allowNulls(bmMapModel.get("mangeDeptCd$deptNmRtchnt")));    /** column 부서코드 : mangeDeptCd */
    		 
    		 if (MSFSharedUtils.paramNotNull(payr0250Dto.getMangeDeptNm())) {
    			 payr0250Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("mangeDeptCd$mangeDeptCd")));    /** column 부서코드 : mangeDeptCd */
			 } else {
				 payr0250Dto.setMangeDeptCd("");    /** column 부서코드 : mangeDeptCd */
				 
			 }  
    		 
    		 
    		 payr0250Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd$deptCd")));    /** column 부서코드 : deptCd */
    		 
    		 payr0250Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd$businCd")));    /** column 사업코드 : businCd */
    		 payr0250Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd$commCd")));    /** column 고용구분코드 : emymtDivCd */
    		 payr0250Dto.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("repbtyBusinDivCd$commCd")));    /** column 구분코드 : repbtyBusinDivCd */
    	 
    		 payr0250Dto.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(bmMapModel.get("pernChrgEmpIdenNum")));    /** column 담당직원번호 : pernChrgEmpIdenNum */
    		 payr0250Dto.setJobNm(MSFSharedUtils.allowNulls(bmMapModel.get("jobNm")));                         /** column 작업명 : jobNm */
    		 payr0250Dto.setPymtDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("pymtDt"),"yyyyMMdd"));    /** column 지급일자 : pymtDt */
    		 payr0250Dto.setRflctnBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("rflctnBgnnDt"),"yyyyMMdd"));    /** column 반영시작일자 : rflctnBgnnDt */
    		 payr0250Dto.setRflctnEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("rflctnEndDt"),"yyyyMMdd"));    /** column 반영종료일자 : rflctnEndDt */
    		 payr0250Dto.setPayDdlneDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("payDdlneDt"),"yyyyMMdd"));    /** column 급여마감일자 : payDdlneDt */
    		 payr0250Dto.setGroFlCretnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("groFlCretnDt"),"yyyyMMdd"));    /** column 지로파일생성일자 : groFlCretnDt */

    		 payr0250Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd$typOccuCd")));    /** column 직종코드 : typOccuCd */
    		 payr0250Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd$dtilOccuInttnCd")));   /** column 직종세종통합코드 : dtilOccuInttnCd */
    		 
    		 
    		 // payr0250Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */

    		 //                     payr0250Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
    		 //                     payr0250Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
    		 //                     payr0250Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
    		 //                     payr0250Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
    		 //                     payr0250Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
    		 //                     payr0250Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */

    		 //                    payr0520Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));    /** column 사업장코드 : dpobCd */
    		 //                    payr0520Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
    		 //                    payr0520Dto.setPayItemCd(MSFSharedUtils.allowNulls(payItemCd.getValue()));    /** column 급여항목코드 : payItemCd */
    		 //                    payr0520Dto.setPymtDducItemSilNum((Long)bmMapModel.get("pymtDducItemSilNum"));    /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
    		 //                    payr0520Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
    		 //                    payr0520Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    /** column 지급공제금액 : pymtDducSum */
    		 //                    payr0520Dto.setPymtDducRate((Double)bmMapModel.get("pymtDducRate"));    /** column 지급공제율 : pymtDducRate */
    		 //                    payr0520Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
    		 //                    payr0520Dto.setPymtDducItemCretnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducItemCretnDivCd")));    /** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
    		 //                    payr0520Dto.setPymtDducItemBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("pymtDducItemBgnnDt"),"yyyyMMdd"));    /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
    		 //                    payr0520Dto.setPymtDducItemEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("pymtDducItemEndDt"),"yyyyMMdd"));    /** column 지급공제항목종료일자 : pymtDducItemEndDt */
    		 //                    payr0520Dto.setPymtDducItemDelYn((Boolean)bmMapModel.get("pymtDducItemDelYn"));    /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
    		 //                    payr0520Dto.setPymtDducItemNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducItemNoteCtnt")));    /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
    		 //                    payr0520Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
    		 //                    payr0520Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
    		 //                    payr0520Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
    		 //                    payr0520Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
    		 //                    payr0520Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
    		 //                    payr0520Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */

    		 if (actionDatabase.equals(ActionDatabase.INSERT)) {
    			 if ( bmMapModel.get("typOccuCd$typOccuCd") == null || bmMapModel.get("dtilOccuInttnCd$dtilOccuInttnCd") == null) {

	    			 payr4050Service.checkSysm0700Auth(payr0250Dto, actionDatabase, new AsyncCallback<Long>() {
	    				 public void onFailure(Throwable caught) {
	    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	    							 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("checkSysm0700Auth : " + caught), null);
	    				 }
	    				 public void onSuccess(Long result) { 
	    					 if (result > 0) {
	    						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"[급여] 직종과 직종세를 입력하십시요.", null);
	    						 return;
	    					 } 
	    				 }  
	    			 });
    			 }

    			 if (MSFConfiguration.EMYMT_DIVCD02.equals(payr0250Dto.getEmymtDivCd())) {
    				 
    				 if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobYrMnth())) {
    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    							 "[급여] 작업년월을 입력하십시요.", null);
    					 statCheck = true;
    					 break;
    				 } else if (MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) && MSFSharedUtils.paramNotNull(payr0250Dto.getMangeDeptCd())) {
    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    							 "[급여] 관리부서 또는 부서 중 하나만 입력 가능합니다.", null);
    					 statCheck = true;
    					 break;
    				 }  else { 
    				 
	    				 if (MSFSharedUtils.isNullAsString(payr0250Dto.getDeptCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
	    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	    							 "[급여] 관리부서 또는 부서를 입력하십시요.", null);
	    					 statCheck = true;
	    					 break;
	    				 } 
	    				 else if (MSFSharedUtils.isNullAsString(payr0250Dto.getEmymtDivCd())) {
	    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	    							 "[급여] 고용구분을 입력하십시요.", null);
	    					 statCheck = true;
	    					 break;		
	    				 } 
	    				 else if (MSFSharedUtils.isNullAsString(payr0250Dto.getBusinCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
	    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	    							 "[급여] 사업을 입력하십시요.", null);
	    					 statCheck = true;
	    					 break;
	    				 } 
    				 }  
    				 if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobNm())) {
    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    							 "[급여] 작업명을 입력하십시요.", null);
    					 statCheck = true;
    					 break;
    				 }
    				 payr0250Dto.setTypOccuCd("");    /** column 직종코드 : typOccuCd */
    				 payr0250Dto.setDtilOccuInttnCd("");   /** column 직종세종통합코드 : dtilOccuInttnCd */
    				 payr0250Dto.setPyspGrdeCd("");    /** column 호봉등급코드 : pyspGrdeCd */

    			 } 

    			 else if (MSFConfiguration.EMYMT_DIVCD01.equals(payr0250Dto.getEmymtDivCd())) {

	    				 if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobYrMnth())) {
	    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	    							 "[급여] 작업년월을 입력하십시요.", null);
	    					 statCheck = true;
	    					 break;
	    				 }   else if (MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) && MSFSharedUtils.paramNotNull(payr0250Dto.getMangeDeptCd())) {
	    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	    							 "[급여] 관리부서 또는 부서 중 하나만 입력 가능합니다.", null);
	    					 statCheck = true;
	    					 break;
	    				 }  else {  
    				  
		    			     if (MSFSharedUtils.isNullAsString(payr0250Dto.getDeptCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
		    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		    							 "[급여] 관리부서 또는 부서를 입력하십시요.", null);
		    					 statCheck = true;
		    					 break;
		    				 } 
		    				 else if (MSFSharedUtils.isNullAsString(payr0250Dto.getEmymtDivCd())) {
		    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		    							 "[급여] 고용구분을 입력하십시요.", null);
		    					 statCheck = true;
		    					 break;		
		    				 }  
		    				 else if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobNm())) {
		    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		    							 "[급여] 작업명을 입력하십시요.", null);
		    					 statCheck = true;
		    					 break;
		    				 }
		    				 //환경미화원인경우 처리 
		    				 //TODO 직종세직종명이 있는경우 직종명을 입력하도록 하는 루틴 생각 추가 
		    				 //if ( MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd())
		    				 //	        .concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))))) {
		
		    				 if (!gwtExtAuth.getEnableTypOccuCd())	{
		    					 if (MSFSharedUtils.isNullAsString(payr0250Dto.getTypOccuCd())) {
		    						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		    								 "[급여] 직종을 입력하십시요.", null);
		    						 statCheck = true;
		    						 break;
		    					 }
		    				 } 
		
		    				 if (!gwtExtAuth.getEnableDtilOccuInttnCd())	{
		    					 if (MSFSharedUtils.isNullAsString(payr0250Dto.getDtilOccuInttnCd())) {
		    						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		    								 "[급여] 직종세를 입력하십시요.", null);
		    						 statCheck = true;
		    						 break;
		    					 }
		    				 } 
		    			 }
    				 payr0250Dto.setBusinCd("");    /** column 사업코드 : businCd */
    			 }                   		
    			 else {

		    				 if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobYrMnth())) {
		    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		    							 "[급여] 작업년월을 입력하십시요.", null);
		    					 statCheck = true;
		    					 break;
		    				 }   else if (MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) && MSFSharedUtils.paramNotNull(payr0250Dto.getMangeDeptCd())) {
		    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		    							 "[급여] 관리부서 또는 부서 중 하나만 입력 가능합니다.", null);
		    					 statCheck = true;
		    					 break;
		    				 }  else { 
				    				  if (MSFSharedUtils.isNullAsString(payr0250Dto.getDeptCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
				    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
				    							 "[급여] 관리부서 또는 부서를 입력하십시요.", null);
				    					 statCheck = true;
				    					 break;
				    				 }  
				    				 else if (MSFSharedUtils.isNullAsString(payr0250Dto.getEmymtDivCd())) {
				    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
				    							 "[급여] 고용구분을 입력하십시요.", null);
				    					 statCheck = true;
				    					 break;	
				    				 } 
				    				 else if (MSFSharedUtils.isNullAsString(payr0250Dto.getJobNm())) {
				    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
				    							 "[급여] 작업명을 입력하십시요.", null);
				    					 statCheck = true;
				    					 break;
				    				 }
				
				    				 if (MSFConfiguration.EMYMT_DIVCD02.equals(payr0250Dto.getEmymtDivCd())) {
				    					 if (MSFSharedUtils.isNullAsString(payr0250Dto.getBusinCd()) && MSFSharedUtils.isNullAsString(payr0250Dto.getMangeDeptCd())) {
				    						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
				    								 "[급여] 사업을 입력하십시요.", null);
				    						 statCheck = true;
				    						 break;
				    					 } 
				    				 } 
				    				 else if (MSFConfiguration.EMYMT_DIVCD01.equals(payr0250Dto.getEmymtDivCd())) {
				    					 if (MSFSharedUtils.isNullAsString(payr0250Dto.getTypOccuCd())) {
				    						 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
				    								 "[급여] 직종을 입력하십시요.", null);
				    						 statCheck = true;
				    						 break;
				    					 }
				    				 } 
		    			 }
    			 }

    			 if (MSFSharedUtils.paramNull(payr0250Dto.getPymtDt())) {
    				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						 "[급여] 지급일자를 입력하십시요.", null);
    				 statCheck = true;
    				 break;
    			 } else if (MSFSharedUtils.paramNull(payr0250Dto.getRflctnBgnnDt())) {
    				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						 "[급여] 시작일자를 입력하십시요.", null);
    				 statCheck = true;
    				 break;
    			 } else if (MSFSharedUtils.paramNull(payr0250Dto.getRflctnEndDt())) {
    				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						 "[급여] 종료일자를 입력하십시요.", null);
    				 statCheck = true;
    				 break;
    			 } 
    		 }

    		 listPayr0250dto.add(payr0250Dto);

    	 }  

    	 if (!statCheck) {

    		 payr4050Service.activityOnPayr4050Save(listPayr0250dto, actionDatabase, new AsyncCallback<Long>() {
    			 public void onFailure(Throwable caught) {
    				 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
    						 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr4050Save(save) : " + caught), null);
    			 }
    			 public void onSuccess(Long result) { 
    				 if (result == 0) {
    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
    							 "저장이 완료되지 않았습니다. 데이타를 확인하십시요.", null);
    				 } else {

    					 actionDatabase = ActionDatabase.UPDATE;
    					 MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장이 완료되었습니다.", null);
    					 reload();
    				 } 
    			 }  
    		 });
    		 statCheck = false;
    	 }
     }
      
     
     public void payr40500Delete() {
//   if (isValid()) { 
         
         if(payr0250GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
             MessageBox.confirm("삭제", "선택된 데이타을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
                 @Override
                 public void handleEvent(MessageBoxEvent be) {
                    // if("Yes".equals(be.getButtonClicked().getText())){
                	 if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                          
                          List<BaseModel> listModels = payr0250GridPanel.getGrid().getSelectionModel().getSelectedItems();
                          
                          payr4050Service.deletePayr0250(listModels,actionDatabase , new AsyncCallback<Long>() {
                                public void onFailure(Throwable caught) {
                                	 MSFServiceFailureHandler handler = new MSFServiceFailureHandler();
                                     handler.handleServiceFailure(caught);
                                  //  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                  //         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("payr40500Delete(" + actionDatabase.name() + ") : " + caught), null);
                                }
                               
                                @Override
                                public void onSuccess(Long result) {
                                    if (result == 0) {
                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                                "삭제가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                                    } else {
                                        MessageBox.alert("삭제완료", "선택하신 급여스케줄 ("+result+")건이 삭제되었습니다.", null);
                                        reload();
                                    } 
                                    
                                  
                                    
                                }
                              
                            });   
                     }
                 }
             }); 
         } else {
             MessageBox.alert("스케줄선택", "삭제할 급여스케줄을 선택하십시요.", null);
         }
          
//   }
   }  	 
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
				
			       detailTp = XTemplate.create(getDetailTemplate());
			    
				   // formData = new FormData("-650");
				    vp = new VerticalPanel();
				    vp.setSpacing(10);
				    createPayr4050Form();  //화면 기본정보를 설정
				    createSearchForm();    //검색필드를 적용
				    createStandardForm();    //기본정보필드  
				    vp.setSize("1010px", "700px");
				    
				    actionDatabase = ActionDatabase.UPDATE;
				
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
	  public Payr4050() {
		   
		
			setSize("1010px", "700px");  
	  } 
	
	  public Payr4050(String txtForm) {
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
	  private void createPayr4050Form() {
		  
		 plFrmPayr4050 = new FormPanel();
		 plFrmPayr4050.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr4050());
		 //plFrmPayr4050.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 급여스케줄관리");
		 plFrmPayr4050.setIcon(MSFMainApp.ICONS.text());
		 plFrmPayr4050.setBodyStyleName("pad-text");
		 plFrmPayr4050.setPadding(2);
		 plFrmPayr4050.setFrame(true); 
		
		 /************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage(lblPayrConst.title_Payr4050(),"PAYR4050");
					}
				});
			plFrmPayr4050.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPayr4050.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

		   //멀티콤보박스 닫기 
		 plFrmPayr4050.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
             @Override
             public void handleEvent(ComponentEvent ce) { 
             
              //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                     
             //        if (f instanceof MSFMultiComboBox<?>) {
                         
//                       if ("srhDeptCd".equals(f.getName())) {
//                           
//                       } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                           
//                       }
                         
               //      } else {
                    if (mutilCombo) {
//                         if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
//                             //부서
//                             srhDeptCd.showClose(ce);
//                             mutilCombo = false;
//                         } else 
                         if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
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
		  
		   
		   topPayr4050Bar = new ButtonBar();    
		   layoutContainer_2.add(topPayr4050Bar);
		   topPayr4050Bar.setAlignment(HorizontalAlignment.RIGHT);
		     
 
		   btnPayr4050New = new Button("신규");  
		   btnPayr4050New.setIcon(MSFMainApp.ICONS.new16());
		   topPayr4050Bar.add(btnPayr4050New);
		   btnPayr4050New.addSelectionListener(new SelectionListener<ButtonEvent>() {  
			      @Override  
			      public void componentSelected(ButtonEvent ce) {  
			    	  formNew();
			      }
			    
	    	});
			
		  	btnPayr4050Save = new Button("저장");  
		  	btnPayr4050Save.setIcon(MSFMainApp.ICONS.save16());
		  	topPayr4050Bar.add(btnPayr4050Save); 
		  	btnPayr4050Save.addSelectionListener(selectionListener);
		   
		  	btnPayr4050Del = new Button("삭제");  
		  	btnPayr4050Del.setIcon(MSFMainApp.ICONS.delete16());
		  	topPayr4050Bar.add(btnPayr4050Del); 
		  	btnPayr4050Del.addSelectionListener(selectionListener);
		  	
		  	btnPayr4050Sreach = new Button("조회"); 
		  	btnPayr4050Sreach.setIcon(MSFMainApp.ICONS.search16());
		  	topPayr4050Bar.add(btnPayr4050Sreach);
		  	btnPayr4050Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//조회버튼 클릭시 처리 
	    		    reload();  
	    		    actionDatabase = ActionDatabase.UPDATE;
	    		}
	    	});
		  	
//		    topBtn = new Button("엑셀"); 
//		  	topBtn.setIcon(MSFMainApp.ICONS.excel16());
//		  	buttonBar.add(topBtn);
		 
		  	
	    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_2.setBorders(false); 
	    layoutContainer.setBorders(false);
	  	
	    plFrmPayr4050.add(layoutContainer);    
	  	  
	  	
		//파일업로드 처리
		plFrmPayr4050.setAction("bizform");
		plFrmPayr4050.setEncoding(Encoding.MULTIPART);
		plFrmPayr4050.setMethod(Method.POST);
		
	
		vp.add(plFrmPayr4050);
		plFrmPayr4050.setSize("990px", "680px");
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
		  
		     sysComBass0150Dto = new PrgmComBass0150DTO();
			 sysComBass0300Dto = new PrgmComBass0300DTO();
			 sysComBass0400Dto = new PrgmComBass0400DTO();
			 sysComBass0500Dto = new PrgmComBass0500DTO();
			 sysComBass0350Dto = new PrgmComBass0350DTO();
			 msfCoCalendarDto = new SysCoCalendarDTO();
			 sysComBass0320Dto = new PrgmComBass0320DTO();
			 
				//--------------------급여년도 불러 오는 함수 ------------------------------------------------
			 
			 lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			    //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
  
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //월 
			 msfCoCalendarDto = new SysCoCalendarDTO(); 
		 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 
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
			 
			 sysComBass0300Dto.setRpsttvCd("A048");
			 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			    
			 
		
			 //-------------------관리부서 추가  
			 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
			 lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
			 
			 //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
             // sysComBass0400Dto.setDeptDspyYn("Y");
//              sysComBass0400Dto.setDeptCd(GWTAuthorization.getStrGWTAuthDept()); 
//              sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//             
//              lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//             
//              lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//                  public void handleEvent(StoreEvent<BaseModel> be) {  
//                      mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
//                      srhDeptCd.getStore().add(mDtalistDeptCd);
//                      
//                  }
//              });     
              //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
			 //--------------------부서 불러 오는 함수 ------------------------------------------------
			// lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
			 //--------------------부서 불러 오는 함수 ------------------------------------------------
			   
			 /**
		   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		   * 년도 콤보박스 처리  시작
		   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		   */
		
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
   		   
		    plFrmPayr4050.setLayout(new FlowLayout());
		    
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
		  

		    LayoutContainer layoutContainer = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(80); 
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
			    		     checkPayr4050Auth("PayrMangDeptCd", lsPayrMangDeptCd );   
	                	 }

	                
	            }
	        });    
		    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	  	    		sysComBass0400Dto = new PrgmComBass0400DTO();  
	  	    	   // sysComBass0400Dto.setDeptDspyYn("Y");
//	                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	                   public void handleEvent(StoreEvent<BaseModel> be) {  
//	                     mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
//	                     srhDeptCd.getStore().add(mDtalistDeptCd);
//	                       
//	                   }
//	                });   
//	                
	  	    	} 
	  	    });
		    layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
		    layoutContainer.setBorders(false);
		    
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
		    srhPayCd.setEmptyText("--급여구분선택--");
		    srhPayCd.setSelectOnFocus(true); 
		    srhPayCd.setReadOnly(false);
		    srhPayCd.setEnabled(true); 
		    srhPayCd.setStore(lsPayCd);
		    srhPayCd.setFieldLabel("급여구분");
		    srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	 
	            	checkPayr4050Auth("srhPayCd",lsPayCd);   
	            }
	        });  
	        
		    layoutContainer_14.add(srhPayCd, new FormData("100%"));
		    layoutContainer_14.setBorders(false);
		    
		    
		    LayoutContainer lc_101 = new LayoutContainer();
		    lc_101.setLayout(new ColumnLayout());
		    
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		  //  lcSchCol.add(layoutContainer_10);
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_10.setLayout(frmlytSch);
		    
		    srhEmymtDivCd =  new ComboBox<BaseModel>(); 
	        srhEmymtDivCd.setName("srhEmymtDivCd");
	        srhEmymtDivCd.setForceSelection(true);
	        srhEmymtDivCd.setAllowBlank(false);
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
			    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
	                	 }  
	              
	            }
	        });  
		    srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	  	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	  	    	 BaseModel bmPayCd =  se.getSelectedItem(); 
	  	    	 
	  	    	 if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
	  	    	    srhDeptCd.fireEvent(Events.Add); 
	  	    	    srhBusinCd.setEnabled(true);
	  	    	    srhTypOccuCd.reset();
	                srhTypOccuCd.setEnabled(false);
	                srhDtilOccuInttnCd.reset();
	                srhDtilOccuInttnCd.setEnabled(false);
	                payr0250Def.setEmymtDivCd(MSFSharedUtils.defaultNulls(bmPayCd.get("commCd"),MSFConfiguration.EMYMT_DIVCD02));
	             } else {
	                 srhBusinCd.reset();
	                 srhBusinCd.setEnabled(false);  
	                 //20151130 추가 수정
	                 srhDeptCd.fireEvent(Events.Add); 
	                 if (gwtExtAuth.getEnableTypOccuCd()) {
	                	 srhTypOccuCd.setEnabled(true);
	                     srhDtilOccuInttnCd.setEnabled(true); 
	                 } else {
	                	 srhTypOccuCd.setEnabled(false);
	                     srhDtilOccuInttnCd.setEnabled(false);
	                     
	                 }
//	                 if (gwtAuthorization.getCheckOccuDisabled()) {
//	                    
//	                 } else {
//	                    
//	                   
//	                  
//	                 }   
	                 payr0250Def.setEmymtDivCd(MSFSharedUtils.defaultNulls(bmPayCd.get("commCd"),MSFConfiguration.EMYMT_DIVCD01));
	             }  
	  	    	 
	  	    	} 
	  	    });
		    layoutContainer_10.add(srhEmymtDivCd, new FormData("100%"));
		    layoutContainer_10.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_101 = new LayoutContainer();
		  //  lcSchCol.add(layoutContainer_101);
		    frmlytSch = new FormLayout();  
		    frmlytSch.setDefaultWidth(0);
//		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_101.setLayout(frmlytSch);
		    
		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		    srhRepbtyBusinDivCd.setForceSelection(true);
		    srhRepbtyBusinDivCd.setAllowBlank(true);
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
	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
		    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

//	            	  EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//	                	 }  
	              
	            }
	        });  
		    
		    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
		    layoutContainer_101.setBorders(false);
		 
		 
		    lc_101.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7)); 
		    lc_101.add(layoutContainer_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    
		     
		    
		    lcSchLeft.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
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
			    		   checkPayr4050Auth("PayYr", lsPayYrStore); 
			    		 
	                	 } 
		            	 
	            }
	        });    
		    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		           BaseModel bmPayYr =  se.getSelectedItem(); 
		           if (bmPayYr != null) {
		            
		              sysComBass0500Dto.setDeptCd(srhDeptCd.getValue());
		              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));
		              payr0250Def.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));
		              //--------------------사업 불러 오는 함수 -------------------------------------------------
		               lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
		              //--------------------사업 불러 오는 함수 -------------------------------------------------
		               srhBusinCd.setStore(lsBusinCd);
		               srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		                   public void handleEvent(StoreEvent<BaseModel> be) {  
		                     //  srhBusinCd.setValue(lsBusinCd.getAt(0));  
		                   }
		               });    
		           
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
		    srhPayMonth.setEmptyText("--월선택--");
		    srhPayMonth.setSelectOnFocus(true); 
		    srhPayMonth.setReadOnly(false);
		    srhPayMonth.setEnabled(true); 
		    srhPayMonth.setStore(lsPayMonth);
		    srhPayMonth.setLabelSeparator(""); 
		    
		    //srhPayMonth.setValue(lsPayMonth.getAt(0) );
		    srhPayMonth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                public void handleEvent(StoreEvent<BaseModel> be) {   
	      	      
                	  EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			    		   srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
			    		   checkPayr4050Auth("PayMonth", lsPayMonth); 
	                	 }
			    	   
		        	  
		        	   
		          }  
		        });  
		     
		     
		    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_9.setBorders(false);
		  
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
		    lcSchCol.add(lc_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
		    
		     
		    fieldSet.add(lcSchCol, new FormData("100%"));  
		    
		    
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
//		    		sysComBass0400Dto = new PrgmComBass0400DTO();
//	  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
//	  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
//	  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//	  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//	  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//	  	    		
//	  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//	  	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//	  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
//	  	    			}
//	  	    		});  
	  	    		emptyCheck = true;
		    	} 
		    });
	        srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) {    
	            	
	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
	                	
	                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
//		                	sysComBass0400Dto = new PrgmComBass0400DTO();
//		      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
//		      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
//		      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//		      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//		      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
//		      	    		
//		      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//		      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//		      	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//		      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
//		      	    			} 
//		      	    			
//		      	    		}); 
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
		    
//		    srhDeptCd = new ComboBox<BaseModel>();
//		    srhDeptCd.setName("srhDeptCd");
//		    srhDeptCd.setForceSelection(true);
//		    srhDeptCd.setMinChars(1);
//		    srhDeptCd.setDisplayField("deptNmHan");
//		    srhDeptCd.setValueField("deptCd");
//		    srhDeptCd.setTriggerAction(TriggerAction.ALL);
//		    srhDeptCd.setEmptyText("--부서선택--");
//		    srhDeptCd.setSelectOnFocus(true); 
//		    srhDeptCd.setReadOnly(false);
//		    srhDeptCd.setEnabled(true); 
//		    srhDeptCd.setStore(lsDeptCd);
//		    srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
//		    srhDeptCd.setFieldLabel("부서");
//		    srhDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//	               // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
//	                
//	                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//	                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	                GWTAuthorization.formAuthConfig(plFrmPayr4050,"srhPayrMangDeptCd", "srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
//	                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//	                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//	                
//	            }
//	        });   
//		    srhDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	  	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	  	    	 BaseModel bmPayCd =  se.getSelectedItem(); 
//	  	    	 
//	  	    	 if (bmPayCd != null && Constants.EMYMT_DIVCD02.equals(srhEmymtDivCd.getValue().get("commCd"))) {
//	  	                if (bmPayCd != null) {
//			  	    		sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd"));
//			  	    		sysComBass0500Dto.setBusinApptnYr((String)srhPayYr.getValue().get("year")); 
//			  	    	 }  	
//			  	    	//--------------------사업 불러 오는 함수 -------------------------------------------------
//			    		 lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//			    	    //--------------------사업 불러 오는 함수 -------------------------------------------------
//			    		 srhBusinCd.setStore(lsBusinCd);
//		                 srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//		                        public void handleEvent(StoreEvent<BaseModel> be) {  
//		                            srhBusinCd.setValue(lsBusinCd.getAt(0));  
//		                        }
//		                    });    	
//	  	    	 }  
//	  	    	} 
//	  	    });
		  //검색 소속부서 코드 처리  
	        LayoutContainer lccmlcDeptNm = new LayoutContainer();
	        lccmlcDeptNm.setLayout(new ColumnLayout());
	           //부서 
	        srhDeptCd = new TextField<String>();
	        srhDeptCd.setName("srhDeptCd");
	        srhDeptCd.setVisible(false); 
	        srhDeptCd.setEnabled(false); //2015.11.30 추가 중요 
	        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
	            @Override
	            public void handleEvent(BaseEvent be) { 
	              if(srhDeptCd.getValue() != null){ 
	            	  
	            	  if (!gwtExtAuth.getEnableDeptCd()) { 
		    			   
	            		  srhDeptCd.setValue(MSFMainApp.get().getUser().getDeptCd());
			  	          srhDeptNm.setValue(MSFMainApp.get().getUser().getDeptNm()); 
			  	           
		    		   }   
	                 
	            	   if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
	            		   //2015.11.30 권한 직종가져오기  추가 
	            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	            		   sysComBass0320Dto.setDeptCd(srhDeptCd.getValue());
	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
	           	             
	                             mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                              
	                           }
	                       });    
	            	   } else {
	            		      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
		                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")); 
		                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
		                  
		                    //--------------------사업 불러 오는 함수 -------------------------------------------------
		                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
		                     //--------------------사업 불러 오는 함수 -------------------------------------------------
		                      srhBusinCd.setStore(lsBusinCd); 
		                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		                          public void handleEvent(StoreEvent<BaseModel> be) {  
		                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
		                          }
		                      });    
	            	   } 
	              } 
	            }
	         });
	        plFrmPayr4050.add(srhDeptCd);
	        
	        
	        //srhMangeDeptCd = new TextField<String>();
	        //srhMangeDeptCd.setName("srhMangeDeptCd");
	       // srhMangeDeptCd.setVisible(false);
	        //plFrmPayr4050.add(srhMangeDeptCd);
	        //srhMangeDeptNm = new TextField<String>();
	        //srhMangeDeptNm.setName("srhMangeDeptNm");
	        //srhMangeDeptNm.setVisible(false);
	        //plFrmPayr4050.add(srhMangeDeptNm);
	  
	         LayoutContainer lcDeptNm = new LayoutContainer(); 
	         frmlytSch = new FormLayout();
	         frmlytSch.setLabelWidth(60);
	         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	         lcDeptNm.setLayout(frmlytSch);
	      
	         srhDeptNm = new TextField<String>();
	         srhDeptNm.setName("srhDeptNm");
	         srhDeptNm.setFieldLabel("부서");  
	         srhDeptNm.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
	         srhDeptNm.setEnabled(gwtExtAuth.getEnableDeptCd());
	         srhDeptNm.addKeyListener(new KeyListener() {
	              public void componentKeyDown(ComponentEvent event) {
	            	  if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
                          srhDeptCd.setValue("");
                   //       srhMangeDeptCd.setValue("");
                      }
	                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) { 
	                      fnPopupCommP140(srhDeptNm.getValue());
	                  }
	                  
	                  super.componentKeyDown(event); 
	              }
	          });
	         
//	         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	                    @Override
//	                    public void handleEvent(BaseEvent be) { 
//	                         
//	                        if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
//	                            srhDeptCd.setValue("");
//	                            srhMangeDeptCd.setValue("");
//	                        }
//	                     
//	                    } 
//	           });        
	          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
	          
	           btnSrhDeptCd = new Button();
	           btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
	           btnSrhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	           btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
	               public void handleEvent(ButtonEvent e) { 
	                   if (MSFSharedUtils.allowNulls(srhDeptNm.getValue()).trim().equals("")) {
	                       srhDeptCd.setValue("");
	                     //  srhMangeDeptCd.setValue("");
	                   }
	                   fnPopupCommP140(srhDeptNm.getValue()); 
	               }
	           });
	            
	           lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
	           lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	             
		    layoutContainer_2.add(lccmlcDeptNm, new FormData("100%"));
		    layoutContainer_2.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_1.setLayout(frmlytSch);
	        layoutContainer_1.setBorders(false); 
		    
	        
	        //직종 직종세처리  
	        LayoutContainer lcTypOccuCd = new LayoutContainer();
	        lcTypOccuCd.setLayout(new ColumnLayout());
	           
	        LayoutContainer layoutContainer_211 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(80); 
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
	        
	       // srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	        //    public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
//	            @Override
//	           public void handleEvent(ComponentEvent ce) { 
//	            	//2015.11.30 추가 
//	            	displayDtilOccuInttnCd(); 
//	            	 
//	            } 
//	        }); 
//	       // lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//           //     public void handleEvent(StoreEvent<BaseModel> be) {  
//	        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
//	            public void handleEvent(StoreEvent<ModelData> be) {  
//	            
//	            	  EventType type = be.getType();
//			    	   if (type == Store.Add) {  
//			    			 //2015.11.30 추가 
//			    		   
//			    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//				    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
//		                	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
//				                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//				                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//				                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//				                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//				                      //         mdSelect = tpMdSelect;
//				                         //  } 
//				                     //  }  
//				                   
//				                       srhTypOccuCd.getListView().setChecked(mdSelect, true);  
//				                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
//				                        
//				                   // }  
//				                    
//		                       }   
//				    		   srhTypOccuCd.fireEvent(Events.Add);
//			    		   }  
//	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			    		   //checkPayr4050Auth("TypOccuCd", lsTypOccuCd); 
//	                	 } 
//                    
//                }
//            });    
//	         
//	        srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	            @Override
//	            public void handleEvent(ComponentEvent ce) {   
//	                
//	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//	                   // GWT.log(" a" + ce.getEvent().getType());
//	                    mutilCombo = true;
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	                    mutilCombo = true;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	                    mutilCombo = false;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                }  
//	            
//	            } 
//	        });
//	      //2015.11.30 추가 
//	        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent ce) {   
//	            	
//	            	displayDtilOccuInttnCd();
//	            } 
//	        });
	        
	        layoutContainer_211.add(srhDeptGpCd, new FormData("100%")); 
	        
	        
	        LayoutContainer layoutContainer_21 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setDefaultWidth(0);
//	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_21.setLayout(frmlytSch); 
	        
	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	        srhTypOccuCd.setName("srhTypOccuCd"); 
	        srhTypOccuCd.setEmptyText("--직종선택--"); 
	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	        srhTypOccuCd.setWidth(100);
	        srhTypOccuCd.setHideLabel(true);
	       // srhTypOccuCd.setFieldLabel("직종");
	        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
	        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
	       // srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	        //    public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	            @Override
	           public void handleEvent(ComponentEvent ce) { 
	            	//2015.11.30 추가 
	            	displayDtilOccuInttnCd(); 
	            	 
	            } 
	        }); 
	       // lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
           //     public void handleEvent(StoreEvent<BaseModel> be) {  
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
				    		   srhTypOccuCd.fireEvent(Events.Add);
			    		   }  
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			    		   //checkPayr4050Auth("TypOccuCd", lsTypOccuCd); 
	                	 } 
                    
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
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        frmlytSch.setDefaultWidth(0);
	       // fieldSet.setLayout(layout);  
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
//	        srhDtilOccuInttnCd.setStyleAttribute("paddingLeft", "5px");
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
	        layoutContainer_1.add(lcTypOccuCd, new FormData("100%"));
		    
		    		 
            layoutContainer_13.add( lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
            layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
            layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.52)); 
            
		    fieldSet.add(layoutContainer_13);
		    layoutContainer_13.setBorders(false); 
			
		    
		    
		    LayoutContainer layoutContainer_13_1 = new LayoutContainer();
		    layoutContainer_13_1.setLayout(new ColumnLayout());
		    
		    
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
		    srhBusinCd.setStore(lsBusinCd);
		    srhBusinCd.setFieldLabel("사업");
		    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
		    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		    layoutContainer_4.setBorders(false);
		    
		    layoutContainer_13_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.48));
		  //  layoutContainer_13_1.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.47)); 
		 //   layoutContainer_13_1.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
            
		    fieldSet.add(layoutContainer_13_1);
		    layoutContainer_13_1.setBorders(false);  
		    
		    
		    plFrmPayr4050.add(fieldSet); 
		//vp.add(panel);   
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
		  
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_1 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_1.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset = new FieldSet();
			fldstNewFieldset.setSize("963px", "500px"); 
			
			layoutContainer_1.add(fldstNewFieldset);
			fldstNewFieldset.setHeadingHtml("급여스케줄정보");
			fldstNewFieldset.setCollapsible(false);
			layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_1.setBorders(false);
			layoutContainer_1.setStyleAttribute("margintTop", "10px");
			fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
			 
			    
			plFrmPayr4050.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
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
	  
	private LayoutContainer occupationalLeft() {

//		LayoutContainer lcTabFormLayer = new LayoutContainer(new FitLayout());
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");

		cpGridPayr0250 = new ContentPanel();
		cpGridPayr0250.setBodyBorder(false);
		cpGridPayr0250.setHeaderVisible(false);
		cpGridPayr0250.setLayout(new FitLayout());
		cpGridPayr0250.setSize(945, 485);
 
	 	   
		// Instantiate the Custom Form
		// MSFCustomForm msfCustomForm = new MSFCustomForm(payr0250Def, 0, 0,
		// false, false, false);
		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		payr0250GridPanel = new MSFGridPanel(payr0250Def, false, false, false,false, false);
		payr0250GridPanel.setHeaderVisible(false);
		payr0250GridPanel.setBodyBorder(true);
		payr0250GridPanel.setBorders(true);
		// payr0250GridPanel.setSize(936, 460);
		// Set the CustomForm to be used by the GridPanel
		// payr0250GridPanel.setMSFFormPanel(msfCustomForm);

		final Grid payr0250Grid = payr0250GridPanel.getMsfGrid().getGrid();
		payr0250Grid.addListener(Events.Select, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				if (payr0250GridPanel.getCurrentlySelectedItem() != null) {
					setRecord(payr0250GridPanel.getCurrentlySelectedItem());
					actionDatabase = ActionDatabase.DELETE;
				}
			}
		});

//            payr0250Grid.addListener(Events.Render,  new Listener<BaseEvent>() {
//                  public void handleEvent(BaseEvent be) {  
////                      GWT.log("keypress1 : " + result.getId());
//	        GWT.log("keypress2 : " + result.getItemId());
//	        MaskUtils.setReMask(result.getId(), "9999.99", null);  
//	        
//                      MaskUtils.setReMask("jobYrMnth", "9999.99", null);
//                  }
//              });  
		 
	     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	         
		cpGridPayr0250.add(payr0250GridPanel);

		cpGridPayr0250.addButton(new Button("스케줄일괄생성", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				createSchedulePayr4050();
			}
		}));

		// cp01.addButton(new Button("스케줄이전", new
		// SelectionListener<ButtonEvent>() {
		// @Override
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));

		lcTabFormLayer.add(cpGridPayr0250);

		return lcTabFormLayer;

	}
	  
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
	  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	 
	   
		public void reload() {
				// TODO Auto-generated method stub
		        formInit() ;
				IColumnFilter filters = null;
				payr0250GridPanel.getTableDef().setTableColumnFilters(filters);

				payr0250GridPanel.getTableDef().addColumnFilter("jobYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0250GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);

				//20180305추가 
				payr0250GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
 
				payr0250GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				
 
				payr0250GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0250GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0250GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
				
			    String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
			    payr0250GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	            // psnl0100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
	             String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
	             payr0250GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
	           //  psnl0100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
	             String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	             payr0250GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	          
	             
//	            payr0250GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	            payr0250GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//	            payr0250GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0250GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			  
				payr0250GridPanel.reload();
			}
		   
		 //폼초기화 검색조건포함 
		   private void formNew() { 
			   
		       if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"))) {
		           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"검색조건에 단위기관을 선택하여 주십시요.", null);
		           return;
		       }
		       
		        payr0250Def.setPayrMangDeptCd(MSFSharedUtils.defaultNulls( MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"),MSFMainApp.get().getUser().getPayrMangDeptCd()));
		        payr0250Def.setMangeDeptCd(MSFSharedUtils.defaultNulls( MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"),""));
		       
		        payr0250GridPanel.getMsfGrid().clearData();
		        int maxDays = 0; 
		        //TODO 부서에 따른 사업 및 직종처리 로직 추가해야 함
		         BaseModel bmData = payr0250GridPanel.getMsfGrid().getTableDef().getDefaultValues();  
		         
		         bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */
 //		         bmData.set("payrMangDeptCd",MSFSharedUtils.defaultNulls( MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"),MSFMainApp.get().getUser().getPayrMangDeptCd()));/** column 단위기관코드 : payrMangDeptCd */
		         bmData.set("jobYrMnth",(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")+ "." + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")));    /** column 작업년월 : jobYrMnth */
		         
		         bmData.set("payCd$commCd",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"));    /** column 급여구분코드 : payCd */ 
		         bmData.set("payCd$commCdNm",MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCdNm"));    /** column 급여구분코드 : payCd */ 
		          
		         bmData.set("payScduSeilNum",0L);    /** column 급여스케줄일련번호 : payScduSeilNum */
		         bmData.set("payrMangDeptCd",MSFSharedUtils.defaultNulls( MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"),MSFMainApp.get().getUser().getPayrMangDeptCd()));    /** column 급여관리부서코드 : payrMangDeptCd */
		         bmData.set("payrMangDeptNm",MSFSharedUtils.defaultNulls( MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptNm"),MSFMainApp.get().getUser().getPayrMangDeptNm()));  
		        
		         bmData.set("mangeDeptCd$mangeDeptCd",MSFSharedUtils.defaultNulls( MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"),""));    /** column 부서코드 : deptCd */
		         bmData.set("mangeDeptCd$deptNmRtchnt",MSFSharedUtils.defaultNulls( MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"deptNmRtchnt"),""));    /** column 부서코드 : deptCd */
		         
		         bmData.set("deptCd$deptCd",gwtAuthorization.getBmGWTAuthDept().get("deptCd"));    /** column 부서코드 : deptCd */
		         bmData.set("deptCd$deptNmRtchnt",gwtAuthorization.getBmGWTAuthDept().get("deptNm"));    /** column 부서코드 : deptCd */
		     
		         if (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
		        	  if (!gwtExtAuth.getEnableTypOccuCd()) {
		        		     bmData.set("typOccuCd$typOccuCd",PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"))    ;    /** column 직종코드 : typOccuCd */
				        	 bmData.set("typOccuCd$typOccuNm",srhTypOccuCd.getValue())    ;    /** column 직종코드 : typOccuCd */
		        	  }
		        	  if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
			        	 bmData.set("dtilOccuInttnCd$dtilOccuInttnCd",PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));   /** column 직종세종통합코드 : dtilOccuInttnCd */
			        	 bmData.set("dtilOccuInttnCd$dtilOccuClsMm",srhDtilOccuInttnCd.getValue());   /** column 직종세종통합코드 : dtilOccuInttnCd */ 
		        	  }
		         }	
		      //   bmData.set("businCd$businCd","");    /** column 사업코드 : businCd */
		      //   bmData.set("businCd$businNm","");   /** column 사업코드 : businCd */ 
		         bmData.set("emymtDivCd$commCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));    /** column 고용구분코드 : emymtDivCd */
		         bmData.set("emymtDivCd$commCdNm",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCdNm"));    /** column 고용구분코드 : emymtDivCd */
		         bmData.set("pernChrgEmpIdenNum",MSFMainApp.get().getUser().getUsrId());    /** column 담당직원번호 : pernChrgEmpIdenNum */
		         bmData.set("jobNm","");    /** column 작업명 : jobNm */
		       //  bmData.set("pymtDt",);    /** column 지급일자 : pymtDt */
	             Calendar  intiCal =   Calendar.getInstance(); 
		         intiCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")) - 1, 1 );
		         bmData.set("rflctnBgnnDt",intiCal.getTime());    /** column 반영시작일자 : rflctnBgnnDt */
		         maxDays = intiCal.getActualMaximum ( intiCal.DAY_OF_MONTH);  
		         
//		           if ("02".equals(PayrUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 28) {
//		        	   maxDays = 28;
//		           } else if ("04".equals(PayrUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//		        	   maxDays = 30;
//		           } else if ("06".equals(PayrUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//		        	   maxDays = 30;
//		           } else if ("09".equals(PayrUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//		        	   maxDays = 30;
//		           } else if ("11".equals(PayrUtils.getSelectedComboValue(srhPayMonth,"month")) && maxDays != 30) {
//		        	   maxDays = 30; 
//		           }
		         
		         Calendar  intieCal =   Calendar.getInstance();
		         intieCal.set ( Integer.parseInt(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")), Integer.parseInt(MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")) - 1, maxDays );
	             bmData.set("rflctnEndDt",intieCal.getTime());    /** column 반영종료일자 : rflctnEndDt */
		     
		       //  bmData.set("payDdlneDt",);    /** column 급여마감일자 : payDdlneDt */
		       //  bmData.set("groFlCretnDt",);    /** column 지로파일생성일자 : groFlCretnDt */
//		         bmData.set("kybdr",);    /** column 입력자 : kybdr */
//		         bmData.set("inptDt",);    /** column 입력일자 : inptDt */
//		         bmData.set("inptAddr",);    /** column 입력주소 : inptAddr */
//		         bmData.set("ismt",);    /** column 수정자 : ismt */
//		         bmData.set("revnDt",);    /** column 수정일자 : revnDt */
//		         bmData.set("revnAddr",);    /** column 수정주소 : revnAddr */
		         
		       //  bm.set("payrMangDeptCd", MSFMainApp.get().getUser().getUserInfo().getPayrMangDeptCd());
		       
		        payr0250GridPanel.getMsfGrid().getGrid().stopEditing();      
		        payr0250GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
		        payr0250GridPanel.getMsfGrid().getGrid().startEditing(payr0250GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 5);   
		        payr0250GridPanel.setSize(940, (498 - (cpGridPayr0250.getButtonBar().getHeight() + 10)));
		        payr0250GridPanel.getMsfGrid().getStore().getRecord(payr0250GridPanel.getMsfGrid().getGrid().getStore().getAt(0));
		         
		        
//		        final ColumnDef deptCdColumnDef = GWTUtils.findColumnDef(payr0250GridPanel.getMsfGrid().getTableDef(), "deptCd") ;
//		        
//		        final List<MSFTrigger> trg = deptCdColumnDef.getTriggers();
//		        
//		        for(int iCnt =0;iCnt < trg.size();iCnt++) {
//		        	 if (trg.get(iCnt).getEventType() == Events.Select) {
//		        		 deptCdColumnDef.getColumnConfig().fireEvent(trg.get(iCnt).getEventType())  ;
//		        	 }
//		        }
		         
		        
		        actionDatabase = ActionDatabase.INSERT;
		        
		       
		   }
		   
 
		   
		 //폼초기화 검색조건포함 
		   private void formInit() {
		       
		       payr0250GridPanel.getMsfGrid().clearData();
		       actionDatabase = ActionDatabase.UPDATE;
		   }
		   
		   public void setRecord(BaseModel record) {
		       this.record = record;
		   }
		 

		   private Payr4050 getThis(){
		       return this;
		   } 
		    

	      public void setListRecord(Iterator<Record> records) {
	         this.records = records;
	      } 
		   /**
		    * 스케줄 신규 일괄생성처리 화면 구성  
		    */
		   private void createSchedulePayr4050() {
			   
//    		   BaseModel bmData = new BaseModel(); 
	           
//               setPPRecord(bmData); //팝업에 넘길값 
                  
			   PayrP405001 payrP42001Form = new PayrP405001(ActionDatabase.READ, getThis());   
 			    
			   //엣지변환
			   //MSFFormWindows msFwPayr42001 = new MSFFormWindows("스케줄일괄생성",payrP42001Form,"닫기","520px", "300px",true);
 		       MSFFormWindows msFwPayr42001 = new MSFFormWindows("스케줄일괄생성",payrP42001Form,"닫기","520px", "350px",true);
 		       msFwPayr42001.show();
 		       payrP42001Form.setMSFFormWindows(msFwPayr42001);
 		       
 		      funcSetPopUpRecord();
 		      payrP42001Form.bind(ppRecord); 
		       
//		        PayrP405001 caricaVmn = new PayrP405001(ActionDatabase.INSERT, getThis());
//	            MSFFormWindows w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtNew(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtSave(),MSFMainApp.MSFCONSTANTS.BtDelete());
//	            w.show(); 
	         //   caricaVmn.setMSFFormWindows(w);
	         //   caricaVmn.bind(new BaseModel());
	         //   caricaVmn.pulisci();   
		   }
		   
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
	                   if (!"".equals(mapModel.get("mangeDeptCd"))) { 
	                        
	                      // srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
	                      // srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
	                       srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	                       srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
	                       srhDeptCd.fireEvent(Events.Add);
	                   }  
	                        
	               }
	           });
	       }       
	       

	       
	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
               
               //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기
           	
                   List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked();  
                   sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                   sysComBass0350Dto.setDeptCd(srhDeptCd.getValue());
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
//           String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//           if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//               sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//               sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//               if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                   lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                   srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//               }
//           }   
	}
	  
	private void funcSetPopUpRecord() {

		BaseModel ppRecord = new BaseModel();
			
			
		List<ModelData> mdListSelect1 = srhTypOccuCd.getListView().getChecked();
		List<ModelData> mdListSelect2 = srhDtilOccuInttnCd.getListView().getChecked();
			
//			ppRecord.set("dpobCd", dpobCd.getValue());
		ppRecord.set("dpobCd", MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getDpobCd()));
		ppRecord.set("srhPayYr_S", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year")));
		ppRecord.set("srhPayMonth_S", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")));
		ppRecord.set("srhPayCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")));
		ppRecord.set("srhPayrMangDeptCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")));
		ppRecord.set("srhEmymtDivCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")));
		ppRecord.set("srhDeptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
		ppRecord.set("srhTypOccuCd",  MSFSharedUtils.allowNulls(PayrUtils.getStrValToMDMultiCombo(mdListSelect1,"typOccuCd")));
		ppRecord.set("srhDtilOccuInttnCd", MSFSharedUtils.allowNulls(PayrUtils.getStrValToMDMultiCombo(mdListSelect2,"dtilOccuInttnCd")));
		ppRecord.set("srhBusinCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")));
			
		setPPRecord(ppRecord);
	}
	  	
	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
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
