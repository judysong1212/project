package com.app.exterms.payroll.client.form;

 
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0420DTO;
import com.app.exterms.payroll.client.form.defs.Payr0420Def;
import com.app.exterms.payroll.client.form.defs.Payr0425Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0415PayYr;
import com.app.exterms.payroll.client.lookup.LookupPayr0420OccuClssPayStd;
import com.app.exterms.payroll.client.service.Payr5100Service;
import com.app.exterms.payroll.client.service.Payr5100ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
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
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
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
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
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
public class Payr5100  extends MSFPanel { 


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
	   private FormPanel plFrmPayr5100;
	   //private FormData formData; 
	   private String txtForm = "";
	   private XTemplate detailTp; 

	  
		  
		  private Payr0420Def payr0420LeftDef  = new Payr0420Def("LEFT");   //그리드 테이블 컬럼 define  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0420LeftGridPanel;
		  
		  
		  private Payr0420Def payr0420CenterDef  = new Payr0420Def("CENTER");   //단가항목  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0420CenterGridPanel;
		  
		  
          private Payr0425Def payr0425Def  = new Payr0425Def();   //이전기본급  
              // private MSFCustomForm msfCustomForm; 
          private MSFGridPanel payr0425GridPanel;
		  
//		  private Payr0440Def payr0440Def  = new Payr0440Def("PAYR5100");   //그리드 테이블 컬럼 define  
//	      // private MSFCustomForm msfCustomForm; 
//	      private MSFGridPanel payr0440GridPanel;
		  
		  private LookupPayr0415PayYr lkApptnYr = new LookupPayr0415PayYr();  
	      private MSFGridPanel payYrGridPanel;
	      

	      private LookupPayr0420OccuClssPayStd lkOccuClssPayStd = new LookupPayr0420OccuClssPayStd();  
	      private MSFGridPanel occuClssPayStdGridPanel;
	      
	      
	      //직종콤보
//	      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	      private MSFGridPanel typOccuCdGridPanel;
    


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
	      private ButtonBar topPayr5100Bar;
	      private Button btnPayr5100Init;
	     // private Button btnPayr5100Save;
	      private Button btnPayr5100Del;
	      private Button btnPayr5100Sreach;
	      /**
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       * 검색변수 선언 
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       */
	      /** column 급여년도 : payYr */
	      private ComboBox<BaseModel> srhPayYr;
	      private ComboBox<BaseModel>  srhOccuClssPayCmpttnStd; //산정일자  
	      /** column 직종코드 : typOccuCd */
	      private ComboBox<BaseModel> srhTypOccuCd; 
	     // private HiddenField<String> srhPyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
	      
	      /** column 직종세코드 : dtilOccuInttnCd */  
	      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 
	       
	      private List<ModelData> mDtalistDtilOccuInttnCd ;
	       
	      private boolean mutilCombo = false;
	      /**
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       * 입력 변수 선언 
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       */	 
	      
	      /** column 급여년도 : payYr */
	      private ComboBox<BaseModel>  createPayYr;
	      private DateField  createOccuClssPayCmpttnStd; //산정일자  
//	      /** column 직종코드 : typOccuCd */
//	      private ComboBox<BaseModel> createTypOccuCd; 
//	      private HiddenField<String> createPyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//	      
//	      /** column 직종세코드 : dtilOccuInttnCd */  
//	      private ComboBox<BaseModel> createDtilOccuInttnCd; 
	      
	     
        private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */
	//
 	    private TextField<String>   payYr;   /** column 급여년도 : payYr */
	//
 	    private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
 	    private TextField<String>   typOccuNm;   /** column 직종 : typOccuNm */
	//
 	    private HiddenField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
 	    private TextField<String>   pyspGrdeNm;   /** column 호봉등급 : pyspGrdeNm */
	//
//	    private TextField<String> payItemCd   /** column 급여항목코드 : payItemCd */
	//
//	    private TextField<String> payCd   /** column 급여구분코드 : payCd */
	//
        private DateField occuClssPayCmpttnStd;   /** column 생성일자 : occuClssPayCmpttnStd */
	//
        private HiddenField<String> dtilOccuInttnCd;   /** column 직종세코드 : dtilOccuInttnCd */
        private TextField<String> dtilOccuClsDivNm;   /** column 직종세코드 : dtilOccuClsDivnm */
         
        private DateField ucstDgmBgnnDt;   /** column 시작일자 :   */
        private DateField ucstDgmEndDt;   /** column 종료일자 :   */ 
        
//	    private TextField<String> payArithExprCalcDivCd   /** column 급여산식계산구분코드 : payArithExprCalcDivCd */
	//
//	    private TextField<String> arithExprCmpttnPymtItemCd   /** column 산식산정지급항목코드 : arithExprCmpttnPymtItemCd */
	//
//	    private TextField<String> arithExprCmpttnRto   /** column 산식산정비율 : arithExprCmpttnRto */
	//
//	    private TextField<String> arithExprCmpttnSum   /** column 산식산정금액 : arithExprCmpttnSum */
	//
//	    private TextField<String> usalyAmntYn   /** column 통상임금여부 : usalyAmntYn */
	//
//	    private TextField<String> emymtDivCd   /** column 고용구분코드 : emymtDivCd */
	//
//	    private TextField<String> cmpttnStdNoteCtnt   /** column 산정기준비고내용 : cmpttnStdNoteCtnt */
	//
//	    private TextField<String> kybdr   /** column 입력자 : kybdr */
	//
//	    private TextField<String> inptDt   /** column 입력일자 : inptDt */
	//
//	    private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
	//
//	    private TextField<String> ismt   /** column 수정자 : ismt */
	//
//	    private TextField<String> revnDt   /** column 수정일자 : revnDt */
	//
//	    private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
        
//      private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//      private TextField<String> payYr;   /** column 급여년도 : payYr */
//
//      private TextField<String> typOccuGrdeMppgSeilNum;   /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
//
//      private TextField<String> payrItemSeilNum;   /** column 급여항목일련번호 : payrItemSeilNum */
//
//      private TextField<String> pyspLogSvcYrNumCd;   /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
//
//      private TextField<String> occuClssPayCmpttnStd;   /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
//
//      private TextField<String> befSvcYrUcstSum;   /** column 이전근속년수단가금액 : befSvcYrUcstSum */
//
//      private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//      private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//      private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//      private TextField<String> ismt;   /** column 수정자 : ismt */
//
//      private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//      private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
     
      
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
		    private void setPayr5100FormBinding() {
		 	 
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
				  private void checkPayr5100Auth( String authAction, ListStore<BaseModel> bm) {   
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
						 Field<?>[] fldArrField = { srhTypOccuCd,srhDtilOccuInttnCd };
		                    
		     			   gwtAuthorization.formAuthFieldConfig(fldArrField);      			   
		     			   
		     			   
		     			  srhPayYr.setValue(lsPayYrStore.findModel("payYr",DateTimeFormat.getFormat("yyyy").format(new Date())));
		     			  createPayYr.setValue(lscrPayYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
		     			 
			        	  srhOccuClssPayCmpttnStd.setValue(lscrOccuClssPayCmpttnStd.getAt(0));
			                 
						 }
				   final Timer tmMask = new Timer()
				     {
				           public void run()
				           {
				              // if (maskTracker)
				              // { 
				        	   if (lsPayYrStore.getCount() > 0 ) {
				        		   
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
					     authMapDef.put("createPayYr",Boolean.FALSE);  
					     authMapDef.put("srhOccuClssPayCmpttnStd",Boolean.FALSE); 
					    
						 
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
	 * 	Rpc Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
		//입력수정삭제처리 rpc 처리부     
		private Payr5100ServiceAsync payr5100Service = Payr5100Service.Util.getInstance();	    
		
		  //생성변수
		    private ListStore<BaseModel> lscrPayYrStore = new ListStore<BaseModel>();
			
			private ListStore<BaseModel> lscrOccuClssPayCmpttnStd = new ListStore<BaseModel>(); //산정 일자 
//			private ListStore<BaseModel> lscrPayrMangDeptCd = new ListStore<BaseModel>(); //단위기관
//			private ListStore<BaseModel> lscrTypOccuCd = new ListStore<BaseModel>();   /** column 직종코드 : typOccuCd */
//			 
//			private ListStore<BaseModel>  lscrDtilOccuInttnCd = new ListStore<BaseModel>();
		
		//검색조건변수 
	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();
		
		private ListStore<BaseModel> lsOccuClssPayCmpttnStd = new ListStore<BaseModel>(); //산정 일자 
		private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>(); //단위기관
		private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();   /** column 직종코드 : typOccuCd */
		 
		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();
		
		
		
		//일반선언 
		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
		private PrgmComBass0350DTO sysComBass0350Dto;  
		private PrgmComBass0320DTO sysComBass0320Dto;	//직종
		private SysCoCalendarDTO msfCoCalendarDto;  
		private BaseModel record;
		
		private List<BaseModel> records;
	    
		/**
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     * 조회처리부
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     */  
//	    private void readPayr5100(){
//	    	payr0420GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//	    	
//	    	//검색조건 넘김 
//	    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//	        //LOOP QUESTIONARI
//	    	bass0200Service.selectPayr5100List(bass0200Dto, new AsyncCallback<List<Payr5100BM>>(){
//	            public void onFailure(Throwable caught) {
//	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr5100(): "+caught), null);
//	                msfPayr5100GridPanel.unmask(); 
//	            }
	//
//	            public void onSuccess(List<Payr5100BM> result) {
//	            	composedPayr5100List(result);
//	            }
//	        });
//	    }
	    
	    //조회처리부
//	    private void composedPayr5100List(List<Payr5100BM> listaMenu) {
//	        Iterator<Sysm0200BM> iter = listaMenu.iterator();
//	        BaseTreeModel folder = new BaseTreeModel();
//	        BaseTreeModel category = null;
//	        while ( iter.hasNext() ) {
//	        	Sysm0200BM mnu = iter.next();
//	            Integer ord = new Integer(mnu.getMnuPrntOrd().intValue());
//	            BaseTreeModel bm = new BaseTreeModel();
//	            bm.set("sysDivCd", mnu.getSysDivCd());
//	            bm.set("mnuCd", mnu.getMnuCd());
//	            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
//	            bm.set("mnuNm", mnu.getMnuNm());
//	            bm.set("mnuIcn", mnu.getMnuIcn()); 
//	            bm.set("mnuTmbl", mnu.getMnuTmbl());
//	            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
//	            bm.set("mnuTipNm", mnu.getMnuTipNm());
//	            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
//	            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
//	            bm.set("mnuPrntOrd", ord);
//	            bm.set("useYn", mnu.getUseYn());
//	            bm.set("mnuEpln", mnu.getMnuEpln());
//	             
//	            if (mnu.getHhrkMnuCd() == null) {
//	                category = new BaseTreeModel();
//	                category.setProperties(bm.getProperties());
//	                folder.add(category);
//	            } else {
//	                if (category != null) {
//	                    category.add(bm);
//	                }
//	            }
//	        } 
//	        msfPayr5100GridPanel.unmask();  
//	    }
	     
	    /**
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     */  
	    private SelectionListener<ButtonEvent> selectionListener = 
		        new SelectionListener<ButtonEvent>() {
		        public void componentSelected(ButtonEvent ce) { 
//		            if (ce.getButton() == btnPayr5100Save) {
//		                doAction(ActionDatabase.INSERT);
//		            } else if (ce.getButton() == btnPayr5100Save) {
//		                doAction(ActionDatabase.UPDATE);
//		            } else 
		            if (ce.getButton() == btnPayr5100Del) {
		            	
		                  if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
			                	 
		                	  MessageBox.alert("오류", "마스터 관리자만 삭제가 가능합니다.</br>관리자에게 문의해주세요.", null);
		                	  return; 
		                    
		                  }
		            	
		            	doAction(ActionDatabase.DELETE);
//						MessageBox.confirm("경고", "해당 데이터를 삭제하시겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
//							@Override
//							public void handleEvent(MessageBoxEvent be) {
//								if("Yes".equals(be.getButtonClicked().getText())){
//									 doAction(ActionDatabase.DELETE);
//								}
//							}
//						});	
		            }
		        }  
		    };
		  
	    private void doAction(ActionDatabase actionDatabase) {
	        switch (actionDatabase) {
	        case INSERT:
	            doInsert();
	            break;
	        case UPDATE:
	             
	            break;
	        case DELETE:
	                  	
	            break;
	        }
	    }
	    
	    
   /**
    * 단가산정을 신규 직종/직종세를 등록한다.
    */
	      public void doInsert() {
//	        if (isValid()) {
	                
	          Payr0420DTO   payr0420Dto = new Payr0420DTO();
	          
	          payr0420Dto.setPayYr(MSFSharedUtils.getSelectedComboValue(createPayYr,"year"));
	          payr0420Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
	          payr0420Dto.setOccuClssPayCmpttnStd(GWTUtils.getStringFromDate(createOccuClssPayCmpttnStd.getValue(),"yyyyMMdd"));
	          
	          payr5100Service.activityOnPayr5100Insert(payr0420Dto,records, 
	                                    actionDatabase,
	                                    new AsyncCallback<Long>() {
	                public void onFailure(Throwable caught) {
	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr5100Insert(" + actionDatabase.name() + ") : " + caught), null);
	                }
	                public void onSuccess(Long result) { 
	                    if (result == 0) {
	                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                    } else {
	                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                actionDatabase + "처리가 완료되었습니다.", null);
	                        reload();
	                    } 
	                } 
	            });
	       // }
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
//		private void Payr5100Print(String fileName) {
	// 
//			// 출력물 디렉토리 패스경로 인사 : PSNL
//			String strDirPath = "PAYR";
//			// mrd 출력물
//			String rdaFileName = fileName+".mrd";
//			// 보낼 파라미터
//			
//			
//			//검색조건
//	 	String serarchParam = "";
////			
////			String name = searchName.getValue() == null ? "" : searchName.getValue();
////			String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////			String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////			//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////			String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////			String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////			String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////			
////			serarchParam += "["+name+"]";
////			serarchParam += "["+resn+"]";
////			serarchParam += "["+hdofcCodtnCd+"]";
////			serarchParam += "[]";
////			//serarchParam += "["+manageDeptCd+"]";
////			serarchParam += "["+deptCd+"]";
////			serarchParam += "["+emymtDivCd+"]";
////			serarchParam += "["+typOccuCd+"]";
//			
//			List<BaseModel> list = payr0420GridPanel.getGrid().getSelectionModel().getSelectedItems();
//			String checkedSystemKeys = "";
//			if(list != null && list.size() > 0){
//				String chkkey = "";
//				for(BaseModel bm : list){
//					chkkey += "'"+bm.get("systemkey")+"',";
//				}
//				
//				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//				
//			}
//			String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//			
//			//System.out.println(strParam);
//			
//			//String strParam = "/rp " + "[" + "20080311" + "]";
//			// + "[" + cmbxNewCombobox.getSelectedText() + "]";
//			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
//			PrintUtils.setPostCall(true);
//			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	//
//		}

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
					
					initLoad();
					
				    detailTp = XTemplate.create(getDetailTemplate());
				    
				   // formData = new FormData("-650");
				    vp = new VerticalPanel();
				    vp.setSpacing(10);
				     createPayr5100Form();  //화면 기본정보를 설정
				    createSearchForm();    //검색필드를 적용
				     createStandardForm();    //기본정보필드  
				    vp.setSize("1010px", "700px");
				    
				    
				    /**
                     * Create the relations 
                     */
                      final RelationDef  relPayr0425 = new RelationDef(payr0420LeftDef);
                      relPayr0425.addJoinDef("dpobCd", "dpobCd");
                      relPayr0425.addJoinDef("payYr", "payYr");
                      relPayr0425.addJoinDef("typOccuCd", "typOccuCd");
                      //relPayr0425.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
                      relPayr0425.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
                      relPayr0425.addJoinDef("occuClssPayCmpttnStd", "occuClssPayCmpttnStd");
                      relPayr0425.setLinkedObject(payr0420LeftGridPanel);
                      payr0425Def.addRelation(relPayr0425); 
                      
            
                      // DETAILS 
                      final Grid<BaseModel> payr0425LeftGrid = payr0420LeftGridPanel.getMsfGrid().getGrid();
                      payr0425LeftGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
                         public void handleEvent(BaseEvent be) {  
                             if (payr0420LeftGridPanel.getCurrentlySelectedItem() != null) { 
                                
                                 payr0425Def.synchronizeGridDetail(
                                         payr0420LeftGridPanel.getCurrentlySelectedItem(),
                                         payr0425GridPanel ); 
                                 payr0425GridPanel.reload(); 
                              }
                            
                           
                         }
                     }); 
                      
				    /**
			          * Create the relations 
			          */
					   final RelationDef  relPayr0420Left = new RelationDef(payr0420LeftDef);
					   relPayr0420Left.addJoinDef("dpobCd", "dpobCd");
					   relPayr0420Left.addJoinDef("payYr", "payYr");
					   relPayr0420Left.addJoinDef("typOccuCd", "typOccuCd");
					 //  relPayr0420Left.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
					   relPayr0420Left.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
					   relPayr0420Left.addJoinDef("occuClssPayCmpttnStd", "occuClssPayCmpttnStd");
					   relPayr0420Left.setLinkedObject(payr0420LeftGridPanel);
					   payr0420CenterDef.addRelation(relPayr0420Left); 
			           
			 
			           // DETAILS 
			           final Grid<BaseModel> payr0420LeftGrid = payr0420LeftGridPanel.getMsfGrid().getGrid();
			           payr0420LeftGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			              public void handleEvent(BaseEvent be) {  
			            	  if (payr0420LeftGridPanel.getCurrentlySelectedItem() != null) { 
			            		 
			            		  payr0420CenterDef.synchronizeGridDetail(
			            				  payr0420LeftGridPanel.getCurrentlySelectedItem(),
			            				  payr0420CenterGridPanel ); 
			            		  
			            		  payr0420CenterGridPanel.reload(); 
			            	   }
			            	 
			                
			              }
			          }); 
			           
			           
//					    /**
//				          * Create the relations 
//				          */
//						   final RelationDef  relPayr0420Left01 = new RelationDef(payr0440Def);
//						   relPayr0420Left01.addJoinDef("dpobCd", "dpobCd");
//						   relPayr0420Left01.addJoinDef("payYr", "payYr");
//						   relPayr0420Left01.addJoinDef("typOccuCd", "typOccuCd");
//						   relPayr0420Left01.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
//						   relPayr0420Left01.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
//						   relPayr0420Left01.addJoinDef("occuClssPayCmpttnStd", "occuClssPayCmpttnStd");
//						   relPayr0420Left01.setLinkedObject(payr0440GridPanel);
//						   payr0420LeftDef.addRelation(relPayr0420Left01); 
//				           
//				 
//				           // DETAILS 
//				           final Grid payr0420Left01Grid = payr0420LeftGridPanel.getMsfGrid().getGrid();
//				           payr0420Left01Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//				              public void handleEvent(BaseEvent be) {  
//				            	  if (payr0420LeftGridPanel.getCurrentlySelectedItem() != null) { 
//				            		 
//				            		  payr0440Def.synchronizeGridDetail(
//				            				  payr0420LeftGridPanel.getCurrentlySelectedItem(),
//				            				  payr0440GridPanel ); 
//				            	   }
//				            	  payr0440GridPanel.reload(); 
//				                
//				              }
//				          }); 
					            
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
		  public Payr5100() {
			   
				setSize("1010px", "700px");  
		  } 
		
		  public Payr5100(String txtForm) {
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
		  private void createPayr5100Form() {
			  
				plFrmPayr5100 = new FormPanel();
				plFrmPayr5100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr5100());
				//plFrmPayr5100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 단가산정-공무직");
				plFrmPayr5100.setIcon(MSFMainApp.ICONS.text());
				plFrmPayr5100.setBodyStyleName("pad-text");
				plFrmPayr5100.setPadding(2);
				plFrmPayr5100.setFrame(true); 
				
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
				 ************************************************************************/
				final Button btnlogView = new Button("로그");   
				
				btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
				btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						 //로그 뷰화면 호출 메서드 
						  funcLogMessage(lblPayrConst.title_Payr5100(),"PAYR5100");
						}
					});
				plFrmPayr5100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
				plFrmPayr5100.getHeader().addTool(btnlogView); 
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 
				 ************************************************************************/

				

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
				  
				  
				  //멀티콤보박스 닫기 
				  plFrmPayr5100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			            @Override
			            public void handleEvent(ComponentEvent ce) { 
			            
			             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
			                    
			            //        if (f instanceof MSFMultiComboBox<?>) {
			                        
//			                      if ("srhDeptCd".equals(f.getName())) {
//			                          
//			                      } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//			                          
//			                      }
			                        
			              //      } else {
			                   if (mutilCombo) {
			                         if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
			                            //직종세
			                            srhDtilOccuInttnCd.showClose(ce);
			                            mutilCombo = false;
			                        }  
			                   }
			                    
			                //    }
			            //    } 
			            } 
			        }); 
					
				   
				  topPayr5100Bar = new ButtonBar();    
				   layoutContainer_2.add(topPayr5100Bar);
				   topPayr5100Bar.setAlignment(HorizontalAlignment.RIGHT);
				   

			  	
				   btnPayr5100Init = new Button("초기화");  
				   btnPayr5100Init.setIcon(MSFMainApp.ICONS.new16());
				  	topPayr5100Bar.add(btnPayr5100Init);
				  	btnPayr5100Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			    	public void handleEvent(ButtonEvent e) {
			    			 //초기화 
			    			formInit();
			    		}
			      });
				  	
//				  	topBtn = new Button("신규");  
//				  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//				  	buttonBar.add(topBtn);
				  	
				  	btnPayr5100Del = new Button("삭제");  
				  	btnPayr5100Del.setIcon(MSFMainApp.ICONS.delete16());
				  	topPayr5100Bar.add(btnPayr5100Del); 
				  	btnPayr5100Del.addSelectionListener(selectionListener);
				  	
				  	btnPayr5100Sreach = new Button("조회"); 
				  	btnPayr5100Sreach.setIcon(MSFMainApp.ICONS.search16());
				  	topPayr5100Bar.add(btnPayr5100Sreach);
				  	btnPayr5100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			    		public void handleEvent(ButtonEvent e) {
			    			//조회버튼 클릭시 처리 
			    		    reload();  
			    		}
			    	});
//				  	topBtn = new Button("인쇄"); 
//				  	topBtn.setIcon(MSFMainApp.ICONS.print16()); 
//				  	topPayr5100Bar.add(topBtn);  
				  	
			    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			    layoutContainer_2.setBorders(false); 
			    layoutContainer.setBorders(false);
			  	
			    plFrmPayr5100.add(layoutContainer);    
			  	  
			  	
				//파일업로드 처리
				plFrmPayr5100.setAction("bizform");
				plFrmPayr5100.setEncoding(Encoding.MULTIPART);
				plFrmPayr5100.setMethod(Method.POST);
				
			
				vp.add(plFrmPayr5100);
				plFrmPayr5100.setSize("990px", "680px");
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
		 
		 // srhPyspGrdeCd = new HiddenField<String>();   /** column 호봉등급코드 : pyspGrdeCd */
		 
		 sysComBass0150Dto = new PrgmComBass0150DTO(); 
		 sysComBass0350Dto = new PrgmComBass0350DTO(); 
		 sysComBass0320Dto = new PrgmComBass0320DTO();
		 msfCoCalendarDto = new SysCoCalendarDTO();
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		   
		/**
		  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		  * 직종 콤보박스 처리  시작
		  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		  */
//		 		  ContentPanel typOccuCdGrid = new ContentPanel();  
//		 		  typOccuCdGrid.setVisible(false);
//		 		    
//		 		    //직종 콤보처리 
//		 		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		 		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		 			       public void handleEvent(ComponentEvent be) {  
//		 			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		 			          public void handleEvent(StoreEvent<BaseModel> be) {  
//		 			        	  
//		 			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
//		 			          }  
//		 			        });  
//		 			       
//		 			      }  
//		 			    });  
//		 	  
//		 		 typOccuCdGrid.add(typOccuCdGridPanel); 
//		 		plFrmPayr5100.add(typOccuCdGrid);
		  
		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		    
			 
	   /**
		* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		* 년도 콤보박스 처리  시작
		* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		*/
				   ContentPanel payYrGrid = new ContentPanel();  
				   payYrGrid.setVisible(false);
				    
				   //년도 콤보처리 
				   payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
				   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
					       public void handleEvent(ComponentEvent be) {  
					    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
					          public void handleEvent(StoreEvent<BaseModel> be) {  
					        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
					        	//  Date today = new Date(); 
					        	    // A custom date format
					        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
					        	 
					      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
					      	     // srhPayYr.setValue(bm); 
					        	
					          }  
					        });  
					       
					      }  
					    });  
			  
				payYrGrid.add(payYrGridPanel); 
				plFrmPayr5100.add(payYrGrid); 

				lscrPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
				 /**
				* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				* 적용일자 콤보박스 처리  시작
				* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
				*/
						   ContentPanel occuClssPayCmpttnStdGrid = new ContentPanel();  
						   occuClssPayCmpttnStdGrid.setVisible(false);
						    
						   //년도 콤보처리 
						   occuClssPayStdGridPanel = new MSFGridPanel(lkOccuClssPayStd, false, false, false, true); 
						   occuClssPayStdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
							       public void handleEvent(ComponentEvent be) {  
							    	   occuClssPayStdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
							          public void handleEvent(StoreEvent<BaseModel> be) {  
							        	  lscrOccuClssPayCmpttnStd.add(occuClssPayStdGridPanel.getMsfGrid().getStore().getModels()); 
							        	 
							        	//  Date today = new Date(); 
							        	    // A custom date format
							        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
							        	 
							      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
							      	     // srhPayYr.setValue(bm);
							        	  
							          }  
							        });  
							       
							      }  
							    });  
					  
						   occuClssPayCmpttnStdGrid.add(occuClssPayStdGridPanel); 
						   plFrmPayr5100.add(occuClssPayCmpttnStdGrid); 

		  
		  plFrmPayr5100.setLayout(new FlowLayout());
		    
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
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_14.setLayout(frmlytSch);
		    
		    srhTypOccuCd =  new ComboBox<BaseModel>(); 
		    srhTypOccuCd.setName("srhTypOccuCd");
		    srhTypOccuCd.setForceSelection(true);
		    srhTypOccuCd.setMinChars(1);
		    srhTypOccuCd.setDisplayField("typOccuNm");
		    srhTypOccuCd.setValueField("typOccuCd");
		    srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
		    srhTypOccuCd.setEmptyText("--직종선택--");
		    srhTypOccuCd.setSelectOnFocus(true); 
			srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
			srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		    srhTypOccuCd.setStore(lsTypOccuCd);
		    srhTypOccuCd.setFieldLabel("직종");
		    //2015.11.30 추가 
	        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
	            @Override
	            public void handleEvent(BaseEvent ce) {   
	            	 //2015.11.30 추가 
		    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
             	          BaseModel  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
		                   
		                       srhTypOccuCd.setValue(mdSelect);
		                    
                    }  
	            } 
	        }); 
		     
		    srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	  	    		//직종변경에 따른 직종세 값 가져오기
	  	    	     String strTypOccuCd = MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;  
	                 if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
	                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
	                   // sysComBass0350Dto.setPyspGrdeCd((String)srhTypOccuCd.getValue().get("pyspGrdeCd"));
	                     
	                    lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	                   
	                      lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
	                          public void handleEvent(StoreEvent<BaseModel> be) {  
	                              mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
	                              srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
	                              
	                              if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
	                          	    ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
			  		                   
			  		                   
	                          	    srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
	                          	    srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
			  		                  
	      	                 } 
	                          }
	                      });   
	                      
	                 } 
	    
	  	    	 
	  	    	} 
	  	    });
		    layoutContainer_14.add(srhTypOccuCd, new FormData("100%"));
		   
		    layoutContainer_14.setBorders(false);
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		    lcSchCol.add(layoutContainer_10);
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_10.setLayout(frmlytSch);
		    
//		    srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//		    srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//		    srhDtilOccuInttnCd.setForceSelection(true);
//		    srhDtilOccuInttnCd.setMinChars(1);
//		    srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//		    srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//		    srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//		    srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//		    srhDtilOccuInttnCd.setSelectOnFocus(true); 
//		    srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
//		    srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
//		    srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//		    
		    srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
	        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
	        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
	        srhDtilOccuInttnCd.setWidth(100); 
	        srhDtilOccuInttnCd.setFieldLabel("직종세");  
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
		   
		    layoutContainer_10.add(srhDtilOccuInttnCd, new FormData("100%"));
		    layoutContainer_10.setBorders(false);
		 
		    fieldSet.add(lcSchCol, new FormData("100%"));  
		    lcSchLeft.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_8.setLayout(frmlytSch);
		    
		    srhPayYr = new ComboBox<BaseModel>(); 
		    srhPayYr.setName("srhPayYr");
		    srhPayYr.setForceSelection(true);
		    srhPayYr.setMinChars(1);
		    srhPayYr.setDisplayField("payYrDisp");
		    srhPayYr.setValueField("payYr");
		    srhPayYr.setTriggerAction(TriggerAction.ALL);
		    srhPayYr.setEmptyText("--년도선택--");
		    srhPayYr.setSelectOnFocus(true); 
		    srhPayYr.setReadOnly(false);
		    srhPayYr.setEnabled(true); 
		    srhPayYr.setStore(lsPayYrStore); 
		    srhPayYr.setFieldLabel("급여년도"); 
		    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                public void handleEvent(StoreEvent<BaseModel> be) {   
		            
		        	   EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			    		   checkPayr5100Auth("srhPayYr", lsPayYrStore); 
	                	 }
                  
                }
            });
		    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	  	    	
	  	    		IColumnFilter filters = null;
	  	    		occuClssPayStdGridPanel.getTableDef().setTableColumnFilters(filters);
	  				
	  	    		occuClssPayStdGridPanel.getTableDef().addColumnFilter("payYr", srhPayYr.getRawValue(), SimpleColumnFilter.OPERATOR_LIKE); 
	  			  
	  	    		occuClssPayStdGridPanel.reload();
	  	    	} 
	  	    });
		    
		    layoutContainer_8.add(srhPayYr, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		    layoutContainer_8.setBorders(false);
		    
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
		    

		      LayoutContainer layoutContainer = new LayoutContainer();
		      frmlytSch = new FormLayout();  
		      frmlytSch.setLabelWidth(70); 
		      frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		      layoutContainer.setLayout(frmlytSch);
		      
		      srhOccuClssPayCmpttnStd = new ComboBox<BaseModel>(); 
		      srhOccuClssPayCmpttnStd.setName("srhOccuClssPayCmpttnStd");
		      srhOccuClssPayCmpttnStd.setForceSelection(true);
		      srhOccuClssPayCmpttnStd.setMinChars(1);
		      srhOccuClssPayCmpttnStd.setDisplayField("occuClssPayCmpttnStdDisp");
		      srhOccuClssPayCmpttnStd.setValueField("occuClssPayCmpttnStd");
		      srhOccuClssPayCmpttnStd.setTriggerAction(TriggerAction.ALL);
		      srhOccuClssPayCmpttnStd.setEmptyText("--생성일자선택--");
		      srhOccuClssPayCmpttnStd.setSelectOnFocus(true); 
		      srhOccuClssPayCmpttnStd.setReadOnly(false);
		      srhOccuClssPayCmpttnStd.setEnabled(true); 
		      srhOccuClssPayCmpttnStd.setStore(lsOccuClssPayCmpttnStd); 
		      srhOccuClssPayCmpttnStd.setFieldLabel("생성일자"); 
		      srhOccuClssPayCmpttnStd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	                public void handleEvent(StoreEvent<BaseModel> be) {  
 
	                	  EventType type = be.getType();
				    	   if (type == Store.Add) { 
		                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				                	checkPayr5100Auth("srhOccuClssPayCmpttnStd", lsOccuClssPayCmpttnStd); 
		                	 } 
	                }
	            });    
		      layoutContainer.add(srhOccuClssPayCmpttnStd, new FormData("100%"));
		      layoutContainer.setBorders(false);
		      
		      
		      lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		       lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		      lcSchCol.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		      
			
		    plFrmPayr5100.add(fieldSet); 
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
			
			    LayoutContainer layoutContainer_5 = new LayoutContainer();
			    layoutContainer_5.setLayout(new FlowLayout(5));
			
			 
			    LayoutContainer layoutContainer_1 = new LayoutContainer(); 
			    layoutContainer_1.setStyleAttribute("text-align", "right");
			    layoutContainer_1.setLayout(new ColumnLayout());
			    
			    LayoutContainer layoutContainer_4 = new LayoutContainer();
			    layoutContainer_4.setLayout(new FormLayout());
			    layoutContainer_1.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
			    layoutContainer_4.setBorders(false);
			    
			    LayoutContainer layoutContainer_2 = new LayoutContainer();
			    FormLayout frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(80); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
			    layoutContainer_2.setLayout(frmlytSch);
			    
			    
			    createPayYr = new ComboBox<BaseModel>(); 
			    createPayYr.setName("createPayYr");
			    createPayYr.setForceSelection(true);
			    createPayYr.setMinChars(1);
			    createPayYr.setDisplayField("yearDisp");
			    createPayYr.setValueField("year");
			    createPayYr.setTriggerAction(TriggerAction.ALL);
			    createPayYr.setEmptyText("--생성년도선택--");
			    createPayYr.setSelectOnFocus(true); 
			    createPayYr.setReadOnly(false);
			    createPayYr.setEnabled(true); 
			    createPayYr.setStore(lscrPayYrStore); 
			    createPayYr.setFieldLabel("급여년도"); 
			    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			        public void handleEvent(StoreEvent<BaseModel> be) {  
			        	checkPayr5100Auth("createPayYr",lscrPayYrStore);  
			          
			        }
			    });
			    createPayYr.setStyleAttribute("marginTop", "5px"); 
			    layoutContainer_2.add(createPayYr, new FormData("100%")); 
			    layoutContainer_1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			    layoutContainer_2.setBorders(false);
			    
			    
			     
			    LayoutContainer layoutContainer_3 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(80); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
			    layoutContainer_3.setLayout(frmlytSch);
			    
			    createOccuClssPayCmpttnStd = new DateField();
			    createOccuClssPayCmpttnStd.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
			    layoutContainer_3.add(createOccuClssPayCmpttnStd, new FormData("100%"));
			    createOccuClssPayCmpttnStd.setFieldLabel("생성일자");
			    createOccuClssPayCmpttnStd.setStyleAttribute("marginTop", "5px");
			    layoutContainer_1.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			    layoutContainer_3.setBorders(false);
			    
//			    LayoutContainer layoutContainer_6 = new LayoutContainer();
//			    frmlytSch = new FormLayout();  
//			    frmlytSch.setLabelWidth(60); 
//			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//			    layoutContainer_6.setLayout(frmlytSch);
//			    
//			    ComboBox cmbxNewCombobox = new ComboBox();
//			    cmbxNewCombobox.setStore(new ListStore());
//			    layoutContainer_6.add(cmbxNewCombobox, new FormData("100%"));
//			    cmbxNewCombobox.setFieldLabel("직 종");
//			    layoutContainer_1.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//			    layoutContainer_6.setBorders(false);
			    
			    Button btnCreate = new Button("단가적용직종생성");
			    btnCreate.setStyleAttribute("marginTop", "5px");
			    btnCreate.setStyleAttribute("marginLeft", "20px");
			    btnCreate.addListener(Events.Select, new Listener<ButtonEvent>() {
		            public void handleEvent(ButtonEvent e) {
		                fnPopupCommP510();
		            } 
		        });
			    layoutContainer_1.add(btnCreate);
			    
//			    Button btnNewButton_2 = new Button("단가적용직종개별생성");
//			    layoutContainer_1.add(btnNewButton_2);
			    layoutContainer_5.add(layoutContainer_1);
			    layoutContainer_1.setBorders(true);
			    layoutContainer_1.setStyleAttribute("marginLeft", "-5px");
			    layoutContainer_1.setWidth(964);
			    layoutContainer_1.setHeight(35);
		     	plFrmPayr5100.add(layoutContainer_5);
			    layoutContainer_5.setBorders(false);
			    
			    
		  
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_11 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_11.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset = new FieldSet();
			fldstNewFieldset.setSize("200px", "510px");
            fldstNewFieldset.setHeadingHtml("직종정보");
            fldstNewFieldset.setCollapsible(false);

            fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
            
			layoutContainer_11.add(fldstNewFieldset);
			layoutContainer_11.setBorders(false);
			
			
			LayoutContainer layoutContainer_21 = new LayoutContainer();
			frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_21.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset_1 = new FieldSet(); 
			fldstNewFieldset.setSize("662px", "510px"); 
			fldstNewFieldset_1.setHeadingHtml("급여단가산정");
			fldstNewFieldset_1.setCollapsible(false); 
		 
			 
			FieldSet fldstNewFieldsetTop = new FieldSet();
			fldstNewFieldsetTop.setSize(615, 70); 
			fldstNewFieldsetTop.setCollapsible(false); 
			fldstNewFieldsetTop.add(occupationalRTop());
            
			fldstNewFieldset_1.add(fldstNewFieldsetTop,new FormData("100%")); 
			
            layoutContainer_21.add(fldstNewFieldset_1);
            layoutContainer_21.setBorders(false);
            
            
            LayoutContainer layoutContainer_31 = new LayoutContainer();
            layoutContainer_31.setLayout(new ColumnLayout()); 
            layoutContainer_31.setBorders(false);
            
            FieldSet fldstNewFieldset_4 = new FieldSet();
//            fldstNewFieldset_4.setSize(200, 376);
            fldstNewFieldset_4.setHeight(420);
            fldstNewFieldset_4.setCollapsible(false);
            fldstNewFieldset_4.setHeadingHtml("이전기본급"); 
            fldstNewFieldset_4.add(payrLeft01(),new FormData("100%"));
            
            
            FieldSet fldstNewFieldset_2 = new FieldSet();
//            fldstNewFieldset_2.setSize(420, 376);
            fldstNewFieldset_2.setHeight(420);
            fldstNewFieldset_2.setHeadingHtml("급여항목"); 
            fldstNewFieldset_2.setCollapsible(false); 
            fldstNewFieldset_2.add(payrLeft02(),new FormData("100%"));  
            
            layoutContainer_31.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32)); 
            layoutContainer_31.add(fldstNewFieldset_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.68)); 
            
            fldstNewFieldset_1.add(layoutContainer_31,new FormData("100%"));

            layoutContainer.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 
            layoutContainer.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
            			    
			plFrmPayr5100.add(layoutContainer);
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
	 private LayoutContainer occupationalRTop() {
		 
	       dpobCd = new HiddenField<String>();   /** column 사업장코드 : dpobCd */ 
	       typOccuCd  = new HiddenField<String>();   /** column 직종코드 : typOccuCd */ 
	       pyspGrdeCd = new HiddenField<String>();   /** column 호봉등급코드 : pyspGrdeCd */ 
	       dtilOccuInttnCd = new HiddenField<String>();   /** column 직종세코드 : dtilOccuInttnCd */
	         
		   LayoutContainer lcTabFormLayer = new LayoutContainer();
		 
		   ContentPanel cp01 = new ContentPanel();   
		   cp01.setBodyBorder(false); 
		   cp01.setHeaderVisible(false);   
		   cp01.setLayout(new FitLayout());      
		   cp01.setSize(580, 60);  
		   
		   LayoutContainer lytCtr01 = new LayoutContainer();
		   lytCtr01.setLayout(new FlowLayout());
		   
		   LayoutContainer layoutContainer_12 = new LayoutContainer();
		   layoutContainer_12.setLayout(new ColumnLayout());
		   
		   LayoutContainer layoutContainer_13 = new LayoutContainer();
		   FormLayout frmlytStd = new FormLayout();  
		   frmlytStd.setLabelWidth(60); 
		   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		   layoutContainer_13.setLayout(frmlytStd);
		   
		   payYr  = new TextField<String>();
		   payYr.setReadOnly(true);
		   layoutContainer_13.add(payYr, new FormData("100%"));
		   payYr.setFieldLabel("급여년도");
		   layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		   layoutContainer_13.setBorders(false);
		   
		   LayoutContainer layoutContainer_14 = new LayoutContainer();
		   frmlytStd = new FormLayout();  
		   frmlytStd.setLabelWidth(60); 
		   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		   layoutContainer_14.setLayout(frmlytStd);
		   
		   occuClssPayCmpttnStd = new DateField();
		   occuClssPayCmpttnStd.setReadOnly(true);
		   occuClssPayCmpttnStd.setFormatValue(true);
		   occuClssPayCmpttnStd.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		   layoutContainer_14.add(occuClssPayCmpttnStd, new FormData("100%"));
		   occuClssPayCmpttnStd.setFieldLabel("생성일자");
		   layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		   
		   LayoutContainer layoutContainer = new LayoutContainer();
		   frmlytStd = new FormLayout();  
		   frmlytStd.setLabelWidth(70); 
		   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		   layoutContainer.setLayout(frmlytStd);
		   
		   typOccuNm = new TextField<String>();
		   typOccuNm.setReadOnly(true);
		   layoutContainer.add(typOccuNm, new FormData("100%"));
		   typOccuNm.setFieldLabel("직 종");
		   layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.275));
		   layoutContainer.setBorders(false);
		   
		   LayoutContainer layoutContainer_1 = new LayoutContainer();
	       frmlytStd = new FormLayout();  
	       frmlytStd.setLabelWidth(70); 
	       frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	       layoutContainer_1.setLayout(frmlytStd);
	       
	       dtilOccuClsDivNm = new TextField<String>();
	       dtilOccuClsDivNm.setReadOnly(true);
	       layoutContainer_1.add(dtilOccuClsDivNm, new FormData("100%"));
	       dtilOccuClsDivNm.setFieldLabel("직종세");
	       layoutContainer_12.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.275));
	       
		    
		   lytCtr01.add(layoutContainer_12);
		   layoutContainer_12.setBorders(false);
		   
		   LayoutContainer layoutContainer_2 = new LayoutContainer();
		   layoutContainer_2.setLayout(new ColumnLayout());
		   
		   LayoutContainer layoutContainer_3 = new LayoutContainer();
		   frmlytStd = new FormLayout();  
		   frmlytStd.setLabelWidth(60); 
		   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		   layoutContainer_3.setLayout(frmlytStd);
		    
		   ucstDgmBgnnDt = new DateField();
		   ucstDgmBgnnDt.setFormatValue(true);
		   ucstDgmBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		   layoutContainer_3.add(ucstDgmBgnnDt, new FormData("100%"));
		   ucstDgmBgnnDt.setFieldLabel("시작일자");
		   layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		   layoutContainer_3.setBorders(false);
		   
		   LayoutContainer layoutContainer_4 = new LayoutContainer();
		   frmlytStd = new FormLayout();  
		   frmlytStd.setLabelWidth(70); 
		   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		   layoutContainer_4.setLayout(frmlytStd);
		   
		   ucstDgmEndDt = new DateField();
		   ucstDgmEndDt.setFormatValue(true);
		   ucstDgmEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		   layoutContainer_4.add(ucstDgmEndDt, new FormData("100%"));
		   ucstDgmEndDt.setFieldLabel("종료일자");
           
		   layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		   layoutContainer_4.setBorders(false);
		   
//		   LayoutContainer layoutContainer_15 = new LayoutContainer();
//		   frmlytStd = new FormLayout();  
//		   frmlytStd.setLabelWidth(60); 
//		   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		   layoutContainer_15.setLayout(frmlytStd);
//		   layoutContainer_2.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
//		   layoutContainer_15.setBorders(false);
//		   
//		   LayoutContainer layoutContainer_16 = new LayoutContainer();
//		   frmlytStd = new FormLayout();  
//		   frmlytStd.setLabelWidth(60); 
//		   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		   layoutContainer_16.setLayout(frmlytStd);
//		   layoutContainer_2.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
//		   layoutContainer_16.setBorders(false);
		   
		   lytCtr01.add(layoutContainer_2);
		   layoutContainer_2.setBorders(false);
		   cp01.add(lytCtr01);
		  
		      
		    
		   lcTabFormLayer.add(cp01); 
		      
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
	//호봉등급별 근속년수 결과 
	 private LayoutContainer payrLeft01() {
		   
	     LayoutContainer lcTabFormLayer = new LayoutContainer();
	     
         
         ContentPanel cp01 = new ContentPanel();   
         cp01.setBodyBorder(false); 
         cp01.setHeaderVisible(false);   
         cp01.setLayout(new FitLayout());  
         cp01.setSize(190, 390);   
         
         //msfCustomForm.setHeaderVisible(false);
         //Instantiate the GridPanel
         payr0425GridPanel = new MSFGridPanel(payr0425Def, false, false, false, false);
         payr0425GridPanel.setHeaderVisible(false);  
         payr0425GridPanel.setBodyBorder(true);
         payr0425GridPanel.setBorders(true); 
         payr0425GridPanel.setSize(190, 390);  
      //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
 
         cp01.add(payr0425GridPanel); 
         
          lcTabFormLayer.add(cp01); 
           
          return lcTabFormLayer;  
	   
	 } 

	 

	 private LayoutContainer payrLeft02() {
	     
	     LayoutContainer lcTabFormLayer = new LayoutContainer();
	     
         ContentPanel cp01 = new ContentPanel();   
         cp01.setBodyBorder(false); 
         cp01.setHeaderVisible(false);   
         cp01.setLayout(new FitLayout());      
         cp01.setSize(420, 390);  
         
         //msfCustomForm.setHeaderVisible(false);
         //Instantiate the GridPanel
         payr0420CenterGridPanel = new MSFGridPanel(payr0420CenterDef, false, false, false, false, false);
         payr0420CenterGridPanel.setHeaderVisible(false);  
         payr0420CenterGridPanel.setBodyBorder(true);
         payr0420CenterGridPanel.setBorders(true); 
         payr0420CenterGridPanel.setSize(420, 390);  
      //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

          cp01.add(payr0420CenterGridPanel); 
         
          cp01.addButton(new Button("단가산정", new SelectionListener<ButtonEvent>() {   
              @Override  
              public void componentSelected(ButtonEvent ce) { 
            	  
                  if( !"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
	                	 
                	  MessageBox.alert("오류", "마스터 관리자만 단가산정이 가능합니다.</br>관리자에게 문의해주세요.", null);
                	  return; 
                    
                  }
                 
              }   
            }));  
          
          cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
              @Override  
              public void componentSelected(ButtonEvent ce) {   
            	  
                  if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
	                	 
                	  MessageBox.alert("오류", "마스터 관리자만 삭제가 가능합니다.</br>관리자에게 문의해주세요.", null);
                	  return; 
                    
                  }
                 
              }   
            }));  
           
//          cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
//            @Override  
//            public void componentSelected(ButtonEvent ce) {   
//               
//            }   
//          }));  
            
          
          lcTabFormLayer.add(cp01); 
            
          return lcTabFormLayer;
		
		   
	 }
	 

//     private LayoutContainer payrLeft02() {
//         
//         LayoutContainer lcTabFormLayer = new LayoutContainer();
//         
//         ContentPanel cp01 = new ContentPanel();   
//         cp01.setBodyBorder(false); 
//         cp01.setHeaderVisible(false);   
//         cp01.setLayout(new FitLayout());      
//         cp01.setSize(600, 135);  
//         
//         //msfCustomForm.setHeaderVisible(false);
//         //Instantiate the GridPanel
//         payr0440GridPanel = new MSFGridPanel(payr0440Def, false, false, false, false);
//         payr0440GridPanel.setHeaderVisible(false);  
//         payr0440GridPanel.setBodyBorder(true);
//         payr0440GridPanel.setBorders(true); 
//      //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//
//          cp01.add(payr0440GridPanel); 
//         
//          lcTabFormLayer.add(cp01); 
//            
//          return lcTabFormLayer;
//        
//           
//     }
	 

	private LayoutContainer occupationalLeft() {
	 
	 LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	  ContentPanel cp01 = new ContentPanel();   
	  cp01.setBodyBorder(false); 
	  cp01.setHeaderVisible(false);   
	  cp01.setLayout(new FitLayout());      
	  cp01.setSize(330, 480);  
	 

	   //msfCustomForm.setHeaderVisible(false);
	   //Instantiate the GridPanel
	  payr0420LeftGridPanel = new MSFGridPanel(payr0420LeftDef, false, false, false, false, false);
	  payr0420LeftGridPanel.setHeaderVisible(false);  
	  payr0420LeftGridPanel.setBodyBorder(true);
	  payr0420LeftGridPanel.setBorders(true);
	  payr0420LeftGridPanel.setSize(330, 480);  
	//   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

	   cp01.add(payr0420LeftGridPanel); 

	  
	  lcTabFormLayer.add(cp01); 
	   
		return lcTabFormLayer;  
	 
	}	  
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 그리드 처리 함수 종료
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/ 	  
		  
		public void reload() {
				// TODO Auto-generated method stub
			   
				IColumnFilter filters = null;
				payr0420LeftGridPanel.getTableDef().setTableColumnFilters(filters);
				 
				payr0420LeftGridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0420LeftGridPanel.getTableDef().addColumnFilter("occuClssPayCmpttnStd", MSFSharedUtils.getSelectedComboValue(srhOccuClssPayCmpttnStd,"occuClssPayCmpttnStd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0420LeftGridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				//payr0420LeftGridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.allowNulls(srhPyspGrdeCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
				String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
				payr0420LeftGridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	            
				payr0420LeftGridPanel.reload();
			}
		

	    //폼초기화 검색조건포함 
		   private void formInit() {
			   
			   BaseModel bmInit = new BaseModel();
			     /** column 급여년도 : payYr */
			       srhPayYr.setValue(bmInit);
			       srhOccuClssPayCmpttnStd.setValue(bmInit); //산정일자  
			      /** column 직종코드 : typOccuCd */
			      srhTypOccuCd.setValue(bmInit); 
			     // srhPyspGrdeCd.setValue("");   /** column 호봉등급코드 : pyspGrdeCd */
			      /** column 직종세코드 : dtilOccuInttnCd */  
			      srhDtilOccuInttnCd.getInitStore();
			     
			      /** column 급여년도 : payYr */
			      createPayYr.setValue(bmInit);
			      
			      Date today = new Date(); 
           
			      createOccuClssPayCmpttnStd.setValue(today); //산정일자  
			      /** column 직종코드 : typOccuCd */
//			       createTypOccuCd.setValue(bmInit); 
//			       createPyspGrdeCd.setValue("");   /** column 호봉등급코드 : pyspGrdeCd */
//			      
//			      /** column 직종세코드 : dtilOccuInttnCd */  
//			       createDtilOccuInttnCd.setValue(bmInit); 
			       
			       payr0420LeftGridPanel.getMsfGrid().clearData();
			       payr0420CenterGridPanel.getMsfGrid().clearData();
			       
		   }
		  
		   public void setRecord(BaseModel record) {
		       this.record = record;
		   }
		 

		   private Payr5100 getThis(){
		       return this;
		   }
		   
		
	   /**
	       * 신규직종 맵핑생성 
	       */
	        private void fnPopupCommP510() {
	            
	            MSFFormPanel popCom0510 = PrgmComPopupUtils.lovPopUpPrgmCom0510Form();  //직종
	            
	            final FormBinding popBindingCom0510 = popCom0510.getFormBinding();
	           
	            popBindingCom0510.addListener(Events.Change, new Listener<BaseEvent>() {
	                public void handleEvent(BaseEvent be) {
	                    List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
	                    
	                    if (mapModels != null) { 
	                        
	                        setListRecord(mapModels);
	                        actionDatabase = ActionDatabase.INSERT;
	                        doAction(ActionDatabase.INSERT); 

	                         
	                    }  
	                 
	                    
	                }
	            });
	        }
		        
	        

	        public void setListRecord(List<BaseModel> records) {
	            this.records = records;
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
