/*
 * 채권관리  
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.payroll.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0220DTO;
import com.app.exterms.payroll.client.form.defs.Payr0220Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr3100Service;
import com.app.exterms.payroll.client.service.Payr3100ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
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
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
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
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
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
/**
 * 
 * @author leeheuisung
 *
 */
public class Payr3100  extends MSFPanel { 



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
	  private FormPanel plFrmPayr3100; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
		  
		 
	  private Payr0220Def payr0220Def  = new Payr0220Def("");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0220GridPanel;
 
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
      

      private Button topPayr0220Btn;     
       
      
      private ButtonBar topPayr3100Bar;
      private Button btnPayr3100New;
      private Button btnPayr3100Save;
      private Button btnPayr3100Del;
      private Button btnPayr3100Sreach;
      private Button btnPayr3100Print;
      private Button btnPayr3100Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      private ComboBox<BaseModel> srhPayrMangDeptCd; 	//단위기관
      private ComboBox<BaseModel> srhEmymtDivCd; 		//고용구분 
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; 	//호봉제구분코드  	
      
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
//      private TextField<String> srhDeptCd; //부서코드
//      private TextField<String> srhDeptNm; //부서명  
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정  
      
      //private ComboBox<BaseModel> srhTypOccuCd; //직종 
      private ComboBox<BaseModel> srhDeptGpCd; 			//부서직종그룹코드	
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종   
      
      private ComboBox<BaseModel> srhBusinCd;    		//사업
      private TextField<String> srhHanNm;         		//성명
      private TextField<String> srhResnRegnNum;   		//주민번호 
      private HiddenField<String> srhSystemkey;   		//시스템키 
      
      private List<ModelData> mDtalistHdofcCodtnCd ;
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      
      private boolean mutilCombo = false;
      
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
	  private HiddenField<String> dpobCd;   	/** column 사업장코드 : dpobCd */
	  private HiddenField<String> systemkey;   	/** column SYSTEMKEY : systemkey */
	  
	  private TextField<String> hanNm;         	//성명
	  private TextField<String> resnRegnNum;   	//주민번호  
	  private HiddenField<String> secRegnNum;   //주민번호  
	  Button btnHanNm;
	  
	  private TextField<String>  emymtDivNm;
	  private TextField<String>  typOccuNm; 	//직종 
     
      private TextField<String> deptNm ;    	//부서 
      private TextField<String> businNm;    	//사업
	   

	  private HiddenField<Long> provAthmSeilNum ;  /** column 가압류일련번호 : provAthmSeilNum */

	  private TextField<String> icntNum;   /** column 사건번호 : icntNum */

	  private TextField<String> icntNm;   /** column 사건명 : icntNm */

	  private TextField<String> cdtrNm ;  /** column 채권자명 : cdtrNm */

	  private TextField<String> bondIstut;   /** column 채권기관 : bondIstut */

	  private ComboBox<BaseModel> bnkCd;   /** column 은행코드 : bnkCd */

	  private TextField<String> bnkAccuNum ;  /** column 은행계좌번호 : bnkAccuNum */

	  private TextField<String> acntHodrNm ;  /** column 예금주명 : acntHodrNm */

	  private DateField  rcptDt;   /** column 접수일자 : rcptDt */

	  private HiddenField<Date>  dlvyDt;   /** column 송달일자 : dlvyDt */

	  private DateField  dducPridBgnnDt;   /** column 공제기간시작일자 : dducPridBgnnDt */

	  private DateField  dducPridEndDt;   /** column 공제기간종료일자 : dducPridEndDt */

	  private CheckBox bondFrclrEndYn;   /** column 채권압류종료여부 : bondFrclrEndYn */

	  private CheckBox payDducYn ;  /** column 급여공제여부 : payDducYn */

	  private NumberField clmSum;   /** column 청구금액 : clmSum */

	  private NumberField clmBaln;  /** column 청구잔액 : clmBaln */

	  private HiddenField<Long> bondFrclrLmtSum;   /** column 채권압류제한금액 : bondFrclrLmtSum */

	  private NumberField acmlteDducSum;  /** column 누적공제금액 : acmlteDducSum */

	  private NumberField dducSum;   /** column 공제금액 : dducSum */

	  private HiddenField<Double> dducRto;  /** column 공제비율 : dducRto */

	  private HiddenField<String> provAthmNoteCtnt;  /** column 가압류비고내용 : provAthmNoteCtnt */

	 
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
		  private void checkPayr3100Auth( String authAction, ListStore<BaseModel> bm) {   
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
			  Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhBusinCd};
              
        	  	gwtAuthorization.formAuthFieldConfig(fldArrField);
        	    
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
              * 권한설정을 위한 콤보처리를 위한 메서드 시작 
              * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
              ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
              // String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
              // GWTAuthorization.formAuthPopConfig(plFrmPayr3100, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhBusinCd");
              // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			   //gwtAuthorization.formAuthConfig(plFrmPayr3100, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"); 
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
		private Payr3100ServiceAsync payr3100Service = Payr3100Service.Util.getInstance();	    
		
	    private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분 
	    private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	// 호봉제구분코드 
		
	    //--------------------부서 불러 오는 함수 ------------------------------------------------
	 	private ListStore<BaseModel> lsDeptCd 	 		= new ListStore<BaseModel>();	// 부서콤보
	 	//--------------------부서 불러 오는 함수 ------------------------------------------------
		   
		//--------------------사업 불러 오는 함수 -------------------------------------------------
		private ListStore<BaseModel> lsBusinCd  		= new ListStore<BaseModel>();	// 사업콤보   
		//--------------------사업 불러 오는 함수 -------------------------------------------------
		private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관 
		private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  	
		private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	//직종
		private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>();	//급여구분		  
		private ListStore<BaseModel> lsBnkCd 			= new ListStore<BaseModel>(); 	//은행코드
		
		
		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
	 	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관  
		private PrgmComBass0320DTO sysComBass0320Dto;	//직종
		
		private BaseModel record;
	    
		/**
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     * 조회처리부
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     */  
//	    private void readPayr3100(){
//	    	payr0301GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//	    	
//	    	//검색조건 넘김 
//	    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//	        //LOOP QUESTIONARI
//	    	bass0200Service.selectPayr3100List(bass0200Dto, new AsyncCallback<List<Payr3100BM>>(){
//	            public void onFailure(Throwable caught) {
//	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr3100(): "+caught), null);
//	                msfPayr3100GridPanel.unmask(); 
//	            }
	//
//	            public void onSuccess(List<Payr3100BM> result) {
//	            	composedPayr3100List(result);
//	            }
//	        });
//	    }
	    
	    //조회처리부
//	    private void composedPayr3100List(List<Payr3100BM> listaMenu) {
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
//	        msfPayr3100GridPanel.unmask();  
//	    }
	     
	    /**
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     */  
	    private SelectionListener<ButtonEvent> selectionListener = 
		        new SelectionListener<ButtonEvent>() {
		        public void componentSelected(ButtonEvent ce) { 
		            if (ce.getButton() == btnPayr3100Save) {
		                if (actionDatabase == ActionDatabase.INSERT) {
		                    doAction(ActionDatabase.INSERT);
		                } else {
		                    doAction(ActionDatabase.UPDATE);
		                }
		                
		            }  else if (ce.getButton() == btnPayr3100Del) {
		                doAction(ActionDatabase.DELETE);
		            }
	
		        }  
		    };
		  
	    private void doAction(ActionDatabase actionDatabase) {
	        switch (actionDatabase) {
	        case INSERT:
	            this.actionDatabase = ActionDatabase.INSERT;
	            payr3100FormSave();
	            break;
	        case UPDATE:
	            this.actionDatabase = ActionDatabase.UPDATE;
	            payr3100FormSave();
	            break;
	        case DELETE:
	            this.actionDatabase = ActionDatabase.DELETE;
				MessageBox.confirm("경고", "해당 정보를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							  payr3100FormSave();
						}
					}
				});
	            break;
	        }
	    }
				
		
	    public void payr3100FormSave() {
//	      if (isValid()) {
	            
	            Payr0220DTO payr0220Dto = new Payr0220DTO(); 
	         
	            payr0220Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());    /** column 사업장코드 : dpobCd */
                payr0220Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));    /** column SYSTEMKEY : systemkey */
                payr0220Dto.setProvAthmSeilNum(provAthmSeilNum.getValue());    /** column 가압류일련번호 : provAthmSeilNum */
                payr0220Dto.setIcntNum(MSFSharedUtils.allowNulls(icntNum.getValue()));    /** column 사건번호 : icntNum */
                payr0220Dto.setIcntNm(MSFSharedUtils.allowNulls(icntNm.getValue()));    /** column 사건명 : icntNm */
                payr0220Dto.setCdtrNm(MSFSharedUtils.allowNulls(cdtrNm.getValue()));    /** column 채권자명 : cdtrNm */
                payr0220Dto.setBondIstut(MSFSharedUtils.allowNulls(bondIstut.getValue()));    /** column 채권기관 : bondIstut */
                payr0220Dto.setBnkCd(MSFSharedUtils.getSelectedComboValue(bnkCd,"commCd"));    /** column 은행코드 : bnkCd */
                payr0220Dto.setBnkAccuNum(MSFSharedUtils.allowNulls(bnkAccuNum.getValue()));    /** column 은행계좌번호 : bnkAccuNum */
                payr0220Dto.setAcntHodrNm(MSFSharedUtils.allowNulls(acntHodrNm.getValue()));    /** column 예금주명 : acntHodrNm */
                payr0220Dto.setRcptDt(GWTUtils.getStringFromDate(rcptDt.getValue(),"yyyyMMdd"));    /** column 접수일자 : rcptDt */
                payr0220Dto.setDlvyDt(GWTUtils.getStringFromDate(dlvyDt.getValue(),"yyyyMMdd") );    /** column 송달일자 : dlvyDt */
                payr0220Dto.setDducPridBgnnDt(GWTUtils.getStringFromDate(dducPridBgnnDt.getValue(),"yyyyMMdd"));    /** column 공제기간시작일자 : dducPridBgnnDt */
                payr0220Dto.setDducPridEndDt(GWTUtils.getStringFromDate(dducPridEndDt.getValue(),"yyyyMMdd"));    /** column 공제기간종료일자 : dducPridEndDt */
                payr0220Dto.setBondFrclrEndYn(bondFrclrEndYn.getValue());    /** column 채권압류종료여부 : bondFrclrEndYn */
                payr0220Dto.setPayDducYn(payDducYn.getValue());    /** column 급여공제여부 : payDducYn */
                payr0220Dto.setClmSum((Long)clmSum.getValue());    /** column 청구금액 : clmSum */
                payr0220Dto.setClmBaln((Long)clmBaln.getValue());    /** column 청구잔액 : clmBaln */
                payr0220Dto.setBondFrclrLmtSum((Long)bondFrclrLmtSum.getValue());    /** column 채권압류제한금액 : bondFrclrLmtSum */
                payr0220Dto.setAcmlteDducSum((Long)acmlteDducSum.getValue());    /** column 누적공제금액 : acmlteDducSum */
                payr0220Dto.setDducSum((Long)dducSum.getValue());    /** column 공제금액 : dducSum */
                payr0220Dto.setDducRto((Double)dducRto.getValue());    /** column 공제비율 : dducRto */
                payr0220Dto.setProvAthmNoteCtnt(MSFSharedUtils.allowNulls(provAthmNoteCtnt.getValue()));    /** column 가압류비고내용 : provAthmNoteCtnt */
	            
	          
//            payr0220Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
//            payr0220Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
//            payr0220Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
//            payr0220Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
//            payr0220Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
//            payr0220Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */
 
	          payr3100Service.activityOnPayr0220Save(payr0220Dto, 
	                                  actionDatabase,
	                                  new AsyncCallback<Long>() {
	              public void onFailure(Throwable caught) {
	                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0220Save(" + actionDatabase.name() + ") : " + caught), null);
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
     *  rex 추가로 리포트 타입변경
     *  fileName : 출력파일명 
     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
    	private void Payr3100Print(String fileName,String repType) {
     
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			   
			   RdaPrint( fileName);
			   
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			   
			   RexPrint( fileName);
			   
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		   }
	    
	    }

    	//rda 
    	private void RdaPrint(String fileName) {
    		
    		// 출력물 디렉토리 패스경로 인사 : PSNL
    		String strDirPath = "PAYR";
    		// mrd 출력물
    		String rdaFileName = fileName+".mrd";
        		
        	//검색조건
         	String serarchParam = "";
         	
         	//권한 설정으로 인해 추가된 부분 
     	    String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
     	 	String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
     	 	      
         	serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";  //$1
    	   	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]"; //$2
        	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]"; //$3
        	
        	 //20151212-추가 시작 
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "[]"; //$4
            } else {
            	serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$4
            }  
		    //20151212-추가 끝
        	serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")  +"]"; //$5   
           // serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd")  +"]";         //$6  
         	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]"; //$7
        	serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";  //$8
    	    
        	//20151212-변경추가 시작 
		    serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  //$9 유저아이디
			serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$10 
		    
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += "["+deptCdAuth+"]"; //$11 부서
			//20151212-추가 끝        	

			GWT.log("popup : " + serarchParam);
    		String strParam = "/rp " + serarchParam;
    		
    		//GWT 타입으로 팝업 호출시  postCall true 설정
    		PrintUtils.setPostCall(true);
    		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
    	}
    	
    	//rex
    	private void RexPrint(String fileName) {
    		
    		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
    		String strDirPath = "PAYR";
    		// mrd 출력물
    		String rexFileName = fileName+".crf";

    		// 검색조건
    		String serarchParam = "";

    		//권한 설정으로 인해 추가된 부분 
     	    String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
     	 	String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
     	 	
         	serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";         	// $1 사업장코드
    	   	serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";   	// $2 단위기관코드
        	serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";           		// $3고용구분코드 	
        	//20151212-추가 시작 
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "⊥"; // $4 부서코드
            } else {
            	serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; 	// $4 부서코드
            }  
        	serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")  +"⊥"; // $5 직종코드   
            serarchParam += ""+ "⊥";  //PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd")  +"⊥";         //$6  
        	serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";  	// $7 사업코드
        	serarchParam += ""+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"⊥";   			// $8 시스템키
    	    	
        	//20151212-변경추가 시작 
		    serarchParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  						//$9 유저아이디
			serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; 					//$10 
		    
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += ""+deptCdAuth+"⊥"; 														//$11  부서
			//20151212-추가 끝       	
        	
        	
			GWT.log("popup : " + serarchParam);
    		String strParam = "" + serarchParam;
    		
    		//GWT 타입으로 팝업 호출시  postCall true 설정
    		PrintUtils.setPostCall(true);
    		PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
    	}
/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/

//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate()); 
//	    
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPayr3100Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createListGrid();
//	    createStandardForm();    //기본정보필드  
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				 //콤보 권한초기화
				   initLoad(); 
				
			    detailTp = XTemplate.create(getDetailTemplate()); 
			    
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createPayr3100Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createListGrid();
			    createStandardForm();    //기본정보필드 
			    //엣지변환
			    //vp.setSize("1010px", "700px");
			    vp.setSize("1010px", "750px");
				            
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
	  public Payr3100() {
		 
		  //엣지변환
		  //setSize("1010px", "700px");  
			setSize("1010px", "750px");  
	  } 
	
	  public Payr3100(String txtForm) {
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
	  private void createPayr3100Form() {
		  
		plFrmPayr3100 = new FormPanel();
		//plFrmPayr3100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 채권압류공제관리");
		plFrmPayr3100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr3100());
		plFrmPayr3100.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr3100.setBodyStyleName("pad-text");
		plFrmPayr3100.setPadding(2);
		plFrmPayr3100.setFrame(true); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr3100(),"PAYR3100");
				}
			});
		plFrmPayr3100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr3100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		  //멀티콤보박스 닫기 
		plFrmPayr3100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
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
                            srhDeptCd.showClose(ce);
                            mutilCombo = false;
                        } else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
                            //직종
                            srhTypOccuCd.showClose(ce);
                            mutilCombo = false;
                          //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
                        } 
                   } 
                //    }
            //    } 
            } 
        });
        
		topPayr3100Bar = new ButtonBar();    
		topPayr3100Bar.setAlignment(HorizontalAlignment.RIGHT);
  
	  
		btnPayr3100New = new Button("신규");  
		btnPayr3100New.setIcon(MSFMainApp.ICONS.new16());
	  	topPayr3100Bar.add(btnPayr3100New);
	  	btnPayr3100New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			 formNew();
    		}
    	});
	  	 
	  	btnPayr3100Save = new Button("저장");  
	  	btnPayr3100Save.setIcon(MSFMainApp.ICONS.save16());
	  	topPayr3100Bar.add(btnPayr3100Save); 
	  	btnPayr3100Save.addSelectionListener(selectionListener);
	  	
	  	btnPayr3100Del = new Button("삭제");  
	  	btnPayr3100Del.setIcon(MSFMainApp.ICONS.delete16());
	  	topPayr3100Bar.add(btnPayr3100Del);
	  	btnPayr3100Del.addSelectionListener(selectionListener);
	  	
	  	btnPayr3100Sreach = new Button("조회"); 
	  	btnPayr3100Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topPayr3100Bar.add(btnPayr3100Sreach);
	  	btnPayr3100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//조회버튼 클릭시 처리 
    		    reload();  
    		}
    	});
		
	  	btnPayr3100Print = new Button("인쇄"); 
	  	btnPayr3100Print.setIcon(MSFMainApp.ICONS.print16()); 
	  	topPayr3100Bar.add(btnPayr3100Print);  
	  	btnPayr3100Print.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			Payr3100Print("PAYRT3100",MSFMainApp.getMsg("PayGen.ReportDivisionType"));
    		}
    	});

	  	btnPayr3100Excel = new Button("엑셀"); 
	  	btnPayr3100Excel.setIcon(MSFMainApp.ICONS.excel16()); 
	  	topPayr3100Bar.add(btnPayr3100Excel);  
	  	btnPayr3100Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    		    payr0220GridPanel.callExportServlet("");  
    		}
    	});
	  	
	  	plFrmPayr3100.add(topPayr3100Bar);    	
	  	
		//파일업로드 처리
		plFrmPayr3100.setAction("myurl");
		plFrmPayr3100.setEncoding(Encoding.MULTIPART);
		plFrmPayr3100.setMethod(Method.POST);
		    
		vp.add(plFrmPayr3100);
		//엣지변환
		//plFrmPayr3100.setSize("990px", "680px");
		plFrmPayr3100.setSize("990px", "730px");
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
	      
	      
	         srhSystemkey =  new HiddenField<String>();   //시스템키
		  
		     sysComBass0150Dto = new PrgmComBass0150DTO();
			 sysComBass0300Dto = new PrgmComBass0300DTO();
			 sysComBass0400Dto = new PrgmComBass0400DTO();
			 sysComBass0500Dto = new PrgmComBass0500DTO(); 
			 sysComBass0320Dto = new PrgmComBass0320DTO();
			 
			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
			 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
			 lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
				  public void handleEvent(StoreEvent<BaseModel> be) {  
                	  EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkPayr3100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	                	 }
				  }	 
	            });    
			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //급여구분 
//			 sysComBass0300Dto.setRpsttvCd("B015");
//			 lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //고용구분
			 sysComBass0300Dto.setRpsttvCd("A002");
			 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	              public void handleEvent(StoreEvent<BaseModel> be) {   
                	  EventType type = be.getType();
			    	   if (type == Store.Add) { 

	                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	checkPayr3100Auth("srhEmymtDivCd", lsEmymtDivCd); 
			    	   }
	                }
	            });  
			 
			 // 호봉
			 sysComBass0300Dto.setRpsttvCd("A048");
			 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 
			   
		   /**
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		      * 직종 콤보박스 처리  시작
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		      */
//		     		  ContentPanel typOccuCdGrid = new ContentPanel();  
//		     		  typOccuCdGrid.setVisible(false);
//		     		    
//		     		    //직종 콤보처리 
//		     		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		     		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		     			       public void handleEvent(ComponentEvent be) {  
//		     			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		     			          public void handleEvent(StoreEvent<BaseModel> be) {  
//		     			        	  
//		     			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels()); 
//		     			        	mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//		     			          }  
//		     			        });  
//		     			       
//		     			      }  
//		     			});  
//		     	  
//		     		 typOccuCdGrid.add(typOccuCdGridPanel); 
//		     		 plFrmPayr3100.add(typOccuCdGrid);
			    lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   		        lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
  	            public void handleEvent(StoreEvent<BaseModel> be) {  
  	             
                    mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                    srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                     
                  }
              });  
			       
            
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
				 
				 
		    plFrmPayr3100.setLayout(new FlowLayout());
		    
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
		    FormLayout frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(70); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            lcSchLeft.setLayout(frmlytSch);
            
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
            srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                     sysComBass0400Dto.setDeptDspyYn("Y");
                    sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
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
            lcSchLeft.add(srhPayrMangDeptCd, new FormData("100%"));
            
            LayoutContainer layoutContainer_2 = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(70); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_2.setLayout(frmlytSch);
            layoutContainer_2.setBorders(false);
            
           
          
            
            LayoutContainer layoutContainer_4 = new LayoutContainer(new ColumnLayout());
            
            LayoutContainer layoutContainer_4_1 = new LayoutContainer();
            
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(70); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_4_1.setLayout(frmlytSch);
            layoutContainer_4_1.setBorders(false);
            
            
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
            srhEmymtDivCd.setReadOnly(false);
            srhEmymtDivCd.setEnabled(true); 
            srhEmymtDivCd.setStore(lsEmymtDivCd);
            srhEmymtDivCd.setFieldLabel("고용구분");  
            srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
            srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
            srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                    //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                 BaseModel bmPayCd =  se.getSelectedItem(); 
                 if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
                     
                	 srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
                    srhBusinCd.setEnabled(true);
                    srhTypOccuCd.reset();
                    srhTypOccuCd.setEnabled(false);
                  //  srhDtilOccuInttnCd.reset();
                  //  srhDtilOccuInttnCd.setEnabled(false);
                 } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
	            	 //20151130 추가 수정 
            	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	            	 srhBusinCd.reset();
                     srhBusinCd.setEnabled(false);   
	                 if (gwtExtAuth.getEnableTypOccuCd()) {
	                	 srhTypOccuCd.setEnabled(true);
	                    // srhDtilOccuInttnCd.setEnabled(true); 
	                 } else {
	                	 srhTypOccuCd.setEnabled(false);
	                    // srhDtilOccuInttnCd.setEnabled(false);
	                     
	                 }
            	     
                  } 
                 
                } 
            });
            layoutContainer_4_1.add(srhEmymtDivCd, new FormData("100%"));
            layoutContainer_4.add(layoutContainer_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
            layoutContainer_4.setBorders(false);
            
            
		    LayoutContainer layoutContainer_4_2 = new LayoutContainer();
		  //  lcSchCol.add(layoutContainer_101);
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_4_2.setLayout(frmlytSch);
		    
		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
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
		    
		    layoutContainer_4_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
		    layoutContainer_4_2.setBorders(false);
		    layoutContainer_4.add(layoutContainer_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
            
            
            LayoutContainer layoutContainer_5 = new LayoutContainer();
            layoutContainer_5.setLayout(new ColumnLayout());
            
            LayoutContainer layoutContainer_6 = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(70); 
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
            			fnPopupPsnl0100();
                    }
                    
                    if (event.getKeyCode() == KeyCodes.KEY_BACKSPACE) {
                    	srhSystemkey.setValue("");
                    	srhResnRegnNum.setValue("");
                    }
                    
                    super.componentKeyDown(event);
            	}
            });
//            srhHanNm.addKeyListener(new KeyListener() {
//                public void componentKeyUp(ComponentEvent event) {
//                    super.componentKeyUp(event);
//                    srhHanNm.validate();
//                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                        
//                        srhSystemkey.setValue("");
//                        srhResnRegnNum.setValue(""); 
//                        
//                        MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사  
//                        
//                        final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
//                        
//                        popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
//                            public void handleEvent(BaseEvent be) {
//                                if (!"".equals(popBindingCom0100.getModel().get("hanNm"))) { 
//                                    srhSystemkey.setValue((String)popBindingCom0100.getModel().get("systemkey"));   //시스템키
//                                    srhHanNm.setValue((String)popBindingCom0100.getModel().get("hanNm"));
//                                    srhResnRegnNum.setValue((String)popBindingCom0100.getModel().get("resnRegnNum"));   //주민번호 
//                                }  
//      
//                            }
//                        });
//                    }
//                }
//             });
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
            layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
            layoutContainer_6.setBorders(false);
            
            Button btnHanNm = new Button("검색");
            layoutContainer_5.add(btnHanNm);
            btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
                public void handleEvent(ButtonEvent e) {
             
                 srhSystemkey.setValue("");
                 srhResnRegnNum.setValue("");
                    
//                  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사  
//                    
//                    final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
//                    
//                    popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
//                        public void handleEvent(BaseEvent be) {
//                            if (!"".equals(popBindingCom0100.getModel().get("hanNm"))) { 
//                                srhSystemkey.setValue((String)popBindingCom0100.getModel().get("systemkey"));   //시스템키
//                                srhHanNm.setValue((String)popBindingCom0100.getModel().get("hanNm"));
//                                srhResnRegnNum.setValue((String)popBindingCom0100.getModel().get("resnRegnNum"));   //주민번호 
//                            }  
//  
//                        }
//                    });
                      
                 fnPopupPsnl0100();
                }
            });
            
            LayoutContainer layoutContainer_7 = new LayoutContainer();
            //layoutContainer_7.setStyleAttribute("paddingRight", "15px");
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(5); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_7.setLayout(frmlytSch);
            
            /** column 주민등록번호 : resnRegnNum */
            srhResnRegnNum = new TextField<String>();
            srhResnRegnNum.setName("srhResnRegnNum");
            new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
            srhResnRegnNum.setLabelSeparator("");
            srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
                @Override
                public void handleEvent(BaseEvent be) {  
                    if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
                        srhSystemkey.setValue("");
                        srhHanNm.setValue("");
                    }
                 
                } 
          }); 
          //  srhResnRegnNum.setFieldLabel("주민번호");
            layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
            layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		   
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
		    lcSchCol.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 
		    
		    fieldSet.add(lcSchCol, new FormData("100%"));
		    
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    layoutContainer_13.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(70); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
            layoutContainer.setLayout(frmlytSch);
            layoutContainer.setBorders(false);
            
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
			                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                    checkPayr3100Auth("srhDeptCd", lsDeptCd);  
			    	   }  
                }
            });     
            srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
               @Override
              public void handleEvent(ComponentEvent ce) { 
                       
                          if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
                             
                              if (srhDeptCd.getListView().getChecked().size() > 0) {  
                                 
                                  sysComBass0500Dto.setBusinApptnYr(PayGenConst.ACC_CURR_YEAR);    
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
         
                 
            layoutContainer.add(srhDeptCd, new FormData("100%"));
            
            
            
            LayoutContainer layoutContainer_14 = new LayoutContainer(new ColumnLayout());
            
             LayoutContainer layoutContainer_1 = new LayoutContainer();
             
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(70);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_1.setLayout(frmlytSch);
			layoutContainer_1.setBorders(false);
            
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
 	       layoutContainer_1.add(srhDeptGpCd, new FormData("100%"));

            layoutContainer_14.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
            
            
            LayoutContainer layoutContainer_211 = new LayoutContainer();
            
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(0); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_211.setLayout(frmlytSch);
            layoutContainer_211.setBorders(false);
            
            srhTypOccuCd = new MSFMultiComboBox<ModelData>();
            srhTypOccuCd.setName("srhTypOccuCd"); 
            srhTypOccuCd.setEmptyText("--직종선택--"); 
            srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
            srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
            srhTypOccuCd.setWidth(100);
            srhTypOccuCd.setLabelSeparator("");
//            srhTypOccuCd.setFieldLabel("직종"); 
            srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
            srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		     srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
		       public void handleEvent(StoreEvent<ModelData> be) { 
		    	  
		        //	@Override 
	             //   public void storeDataChanged(StoreEvent<ModelData> se){ 	
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
			    		   }
			                   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
			                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			        	     // checkPayr3100Auth("srhTypOccuCd", lsTypOccuCd); 
			                   
			               }
		          }
		      }); 
            srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
                @Override
               public void handleEvent(ComponentEvent ce) { 
               	  //2015.11.30 추가 
	            	// displayDtilOccuInttnCd(); 
	            	 
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
            layoutContainer_211.add(srhTypOccuCd, new FormData("100%"));
            layoutContainer_14.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
          

            
            LayoutContainer layoutContainer_10 = new LayoutContainer();
            
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(70); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_10.setLayout(frmlytSch);
            layoutContainer_10.setBorders(false);
            
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
            layoutContainer_10.add(srhBusinCd, new FormData("100%"));
            lcSchCol.add(layoutContainer_10);
            
            

          
		    layoutContainer_13.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_13.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		    layoutContainer_13.add(layoutContainer_10 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_13.setBorders(false);
		    
		    fieldSet.add(layoutContainer_13); 
			
		    plFrmPayr3100.add(fieldSet); 
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
		   
 
	      dpobCd = new HiddenField<String>();   /** column 사업장코드 : dpobCd */
	      systemkey = new HiddenField<String>();   /** column SYSTEMKEY : systemkey */
	      provAthmSeilNum = new HiddenField<Long>();  /** column 가압류일련번호 : provAthmSeilNum */
	      bondFrclrLmtSum  = new HiddenField<Long>(); /** column 채권압류제한금액 : bondFrclrLmtSum */
	      dducRto = new HiddenField<Double>();  /** column 공제비율 : dducRto */
	      provAthmNoteCtnt = new HiddenField<String>();  /** column 가압류비고내용 : provAthmNoteCtnt */
	      dlvyDt = new HiddenField<Date>();
	        
	      
	      //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
          //은행코드  
          sysComBass0300Dto.setRpsttvCd("B001");
          lsBnkCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
          //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	      
		   FieldSet fieldSet = new FieldSet();  
		   fieldSet.setHeadingHtml("기본사항"); 
		   fieldSet.setStyleAttribute("marginTop", "10px");
		     
		    LayoutContainer layoutContainer = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		    layoutContainer.setLayout(frmlytSch);
		    
		    LayoutContainer layoutContainer_7 = new LayoutContainer();
		    layoutContainer_7.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    layoutContainer_8.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_2 = new LayoutContainer();
		    layoutContainer_2.setLayout(new FormLayout());
		    
		    hanNm = new TextField<String>();
		    layoutContainer_2.add(hanNm, new FormData("100%"));
	        KeyListener listener = new KeyListener() {
	            @Override
	            public void componentKeyDown(ComponentEvent event) {
	            	
	            	hanNm.validate();
	            	
	                if(event.getKeyCode()==13)
	                {
	                	fnCreatePsnl0100() ;
	                }
	                super.componentKeyDown(event);
	            }

	        };
	        hanNm.addKeyListener(listener);
//		    hanNm.addKeyListener(new KeyListener() {
//	             public void componentKeyUp(ComponentEvent event) {
//	                 super.componentKeyUp(event);
//	                 hanNm.validate();
//	                 if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                    
//	                     fnCreatePsnl0100() ;
//	                 }
//	             }
//	          });
		    hanNm.setFieldLabel("성 명");
		    layoutContainer_8.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		    layoutContainer_2.setBorders(false);
		    
		    btnHanNm = new Button("검색");
		    layoutContainer_8.add(btnHanNm);
		    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	             public void handleEvent(ButtonEvent e) { 
	                 
	                 fnCreatePsnl0100() ;
	                  
	                   
	             }
	         });
		    
		    layoutContainer_7.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_8.setBorders(false);
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(5); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_9.setLayout(frmlytSch);
		    
		    
		    secRegnNum = new HiddenField<String>();
		    
		    resnRegnNum = new TextField<String>();
		    resnRegnNum.setLabelSeparator("");
		    layoutContainer_9.add(resnRegnNum, new FormData("100%")); 
		    layoutContainer_7.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_9.setBorders(false);
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_10.setLayout(frmlytSch);
		    
		    
		    emymtDivNm = new TextField<String>();
		    layoutContainer_10.add(emymtDivNm, new FormData("100%"));
		    emymtDivNm.setFieldLabel("고용구분");
		    layoutContainer_7.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_10.setBorders(false);
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_1.setLayout(frmlytSch);
		    
		    typOccuNm = new TextField<String>();
		    layoutContainer_1.add(typOccuNm, new FormData("100%"));
		    typOccuNm.setFieldLabel("직종");
		    layoutContainer_7.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_1.setBorders(false);
		    layoutContainer.add(layoutContainer_7, new FormData("100%"));
		    layoutContainer_7.setBorders(false);
		     
		    LayoutContainer layoutContainer_4 = new LayoutContainer();
		    layoutContainer_4.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_5 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_5.setLayout(frmlytSch);
		    
		    deptNm = new TextField<String>();
		    layoutContainer_5.add(deptNm, new FormData("100%"));
		    deptNm.setFieldLabel("부서명");
		    layoutContainer_4.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_5.setBorders(false);
		    
		    LayoutContainer layoutContainer_6 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_6.setLayout(frmlytSch);
		    
		    businNm = new TextField<String>();
		    layoutContainer_6.add(businNm, new FormData("100%"));
		    businNm.setFieldLabel("사업명");
		    layoutContainer_4.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_6.setBorders(false);
		    layoutContainer.add(layoutContainer_4, new FormData("100%"));
		    layoutContainer_4.setBorders(false);
	
		    LayoutContainer layoutContainer_11 = new LayoutContainer();
		    layoutContainer_11.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_12 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_12.setLayout(frmlytSch);
		    
		    icntNum = new TextField<String>(); 
		    layoutContainer_12.add(icntNum, new FormData("100%"));
		    icntNum.setFieldLabel("사건번호");
		    layoutContainer_11.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_12.setBorders(false);
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_13.setLayout(frmlytSch);
		    
		    icntNm = new TextField<String>();
		    layoutContainer_13.add(icntNm, new FormData("100%"));
		    icntNm.setFieldLabel("사건명");
		    layoutContainer_11.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_13.setBorders(false);
		    layoutContainer.add(layoutContainer_11, new FormData("100%"));
		    layoutContainer_11.setBorders(false);
		    fieldSet.add(layoutContainer);
		    layoutContainer.setBorders(false);
		    
		    FieldSet fldstNewFieldset_1 = new FieldSet();
		    fieldSet.add(fldstNewFieldset_1); 
		    fldstNewFieldset_1.setCollapsible(false);
		    fldstNewFieldset_1.setSize(953, 90);
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    layoutContainer_14.setLayout(new FlowLayout(5));
		    
		    LayoutContainer layoutContainer_16 = new LayoutContainer();
		    layoutContainer_14.add(layoutContainer_16);
		    layoutContainer_16.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_18 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_18.setLayout(frmlytSch);
		    
		    cdtrNm = new TextField<String>();
		    layoutContainer_18.add(cdtrNm, new FormData("100%"));
		    cdtrNm.setFieldLabel("채권자명");
		    layoutContainer_16.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_18.setBorders(false);
		    
		    LayoutContainer layoutContainer_17 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_17.setLayout(frmlytSch);
		    
		    bondIstut = new TextField<String>();
		    layoutContainer_17.add(bondIstut, new FormData("100%"));
		    bondIstut.setFieldLabel("채권기관");
		    layoutContainer_16.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_17.setBorders(false);
		    layoutContainer_16.setBorders(false);
		    
		    LayoutContainer layoutContainer_21 = new LayoutContainer();
		    layoutContainer_14.add(layoutContainer_21);
		    layoutContainer_21.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_22 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_22.setLayout(frmlytSch);
		    
		    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         //고용구분
	         sysComBass0300Dto.setRpsttvCd("B001");
	         lsBnkCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         
		    
		    bnkCd =  new ComboBox<BaseModel>(); 
		    bnkCd.setName("bnkCd");
		    bnkCd.setForceSelection(true);
		    bnkCd.setMinChars(1);
		    bnkCd.setDisplayField("commCdNm");
		    bnkCd.setValueField("commCd");
		    bnkCd.setTriggerAction(TriggerAction.ALL);
		    bnkCd.setEmptyText("--은행선택--");
		    bnkCd.setSelectOnFocus(true); 
		    bnkCd.setReadOnly(false);
		    bnkCd.setEnabled(true); 
		    bnkCd.setStore(lsBnkCd);
		    bnkCd.setFieldLabel("은행명");  
		     
		    layoutContainer_22.add(bnkCd, new FormData("100%"));
		    layoutContainer_21.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer_22.setBorders(false);
		    
		    LayoutContainer layoutContainer_23 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_23.setLayout(frmlytSch);
		    
		    bnkAccuNum = new TextField<String>();
		    layoutContainer_23.add(bnkAccuNum, new FormData("100%"));
		    bnkAccuNum.setFieldLabel("계좌번호");
		    layoutContainer_21.add(layoutContainer_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		    layoutContainer_23.setBorders(false);
		    
		    LayoutContainer layoutContainer_24 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_24.setLayout(frmlytSch);
		    
		    acntHodrNm = new TextField<String>();
		    layoutContainer_24.add(acntHodrNm, new FormData("100%"));
		    acntHodrNm.setFieldLabel("예금주");
		    layoutContainer_21.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
		    layoutContainer_24.setBorders(false);
		    layoutContainer_21.setBorders(false);
		    fldstNewFieldset_1.add(layoutContainer_14);
		    layoutContainer_14.setBorders(false);
		    fldstNewFieldset_1.setHeadingHtml("채권압류내역"); 
		    
		    LayoutContainer layoutContainer_3 = new LayoutContainer();
		    layoutContainer_3.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_19 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_19.setLayout(frmlytSch);
		    
		    rcptDt = new DateField();
		    new DateFieldMask(rcptDt, "9999.99.99"); 
		    rcptDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
		    layoutContainer_19.add(rcptDt, new FormData("100%"));
		    rcptDt.setFieldLabel("접수일자");
		    layoutContainer_3.add(layoutContainer_19, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_19.setBorders(false);
		    
		    LayoutContainer layoutContainer_20 = new LayoutContainer();
		    layoutContainer_20.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_25 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_25.setLayout(frmlytSch);
		    
		    dducPridBgnnDt = new DateField();
		    new DateFieldMask(dducPridBgnnDt, "9999.99.99"); 
		    dducPridBgnnDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
		    layoutContainer_25.add(dducPridBgnnDt, new FormData("100%"));
		    dducPridBgnnDt.setFieldLabel("공제기간");
		    layoutContainer_20.add(layoutContainer_25, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		    layoutContainer_25.setBorders(false);
		    
		    LayoutContainer layoutContainer_30 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(10); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_30.setLayout(frmlytSch);
		    
		    dducPridEndDt = new DateField();
		    new DateFieldMask(dducPridEndDt, "9999.99.99"); 
		    dducPridEndDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
		    dducPridEndDt.setLabelSeparator("~");
		    layoutContainer_30.add(dducPridEndDt, new FormData("100%"));
		    layoutContainer_20.add(layoutContainer_30, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    layoutContainer_30.setBorders(false);
		    layoutContainer_3.add(layoutContainer_20, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		    layoutContainer_20.setBorders(false);
		    
		    LayoutContainer layoutContainer_26 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_26.setLayout(frmlytSch);
		    
		    CheckBoxGroup checkBoxGroup = new CheckBoxGroup();
		    checkBoxGroup.setHideLabel(true);
		   
		    payDducYn = new CheckBox();
		    checkBoxGroup.add(payDducYn);
		    payDducYn.setBoxLabel("급여공제여부");
		    payDducYn.setHideLabel(true);
		    payDducYn.setStyleAttribute("marginLeft", "10px");
		    bondFrclrEndYn = new CheckBox();
		    checkBoxGroup.add(bondFrclrEndYn);
		    bondFrclrEndYn.setBoxLabel("채권압류종료여부");
		    bondFrclrEndYn.setHideLabel(true);
		    bondFrclrEndYn.setStyleAttribute("marginLeft", "10px");
		    layoutContainer_26.add(checkBoxGroup, new FormData("100%"));
		    checkBoxGroup.setFieldLabel("압류종료여부");
		    layoutContainer_3.add(layoutContainer_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.36));
		    layoutContainer_26.setBorders(false);
		    fieldSet.add(layoutContainer_3);
		    layoutContainer_3.setBorders(false);
		    
		    LayoutContainer layoutContainer_15 = new LayoutContainer();
		    layoutContainer_15.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_27 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_27.setLayout(frmlytSch);
		    
		    clmSum = new NumberField();
		    clmSum.setAllowDecimals(true); 
		    clmSum.setPropertyEditorType(Long.class); 
		    clmSum.setFormat(NumberFormat.getDecimalFormat());
		    layoutContainer_27.add(clmSum, new FormData("100%"));
		    clmSum.setFieldLabel("청구금액");
		    layoutContainer_15.add(layoutContainer_27, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_27.setBorders(false);
		    
		    LayoutContainer layoutContainer_28 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_28.setLayout(frmlytSch);
		    
		    dducSum = new NumberField();
		    dducSum.setAllowDecimals(true); 
		    dducSum.setPropertyEditorType(Long.class); 
		    dducSum.setFormat(NumberFormat.getDecimalFormat());
		    layoutContainer_28.add(dducSum, new FormData("100%"));
		    dducSum.setFieldLabel("공제금액");
		    layoutContainer_15.add(layoutContainer_28, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_28.setBorders(false);
		    
		    LayoutContainer layoutContainer_29 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_29.setLayout(frmlytSch);
		    
		    acmlteDducSum = new NumberField();
		    acmlteDducSum.setAllowDecimals(true); 
		    acmlteDducSum.setPropertyEditorType(Long.class); 
		    acmlteDducSum.setFormat(NumberFormat.getDecimalFormat());
		    layoutContainer_29.add(acmlteDducSum, new FormData("100%"));
		    acmlteDducSum.setFieldLabel("누적공제금액");
		    layoutContainer_15.add(layoutContainer_29, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_29.setBorders(false);
		    
		    LayoutContainer layoutContainer_31 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		    layoutContainer_31.setLayout(frmlytSch);
		    
		    clmBaln = new NumberField();
		    clmBaln.setAllowDecimals(true); 
		    clmBaln.setPropertyEditorType(Long.class); 
		    clmBaln.setFormat(NumberFormat.getDecimalFormat()); 
		    layoutContainer_31.add(clmBaln, new FormData("100%"));
		    clmBaln.setFieldLabel("청구잔액");
		    layoutContainer_15.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_31.setBorders(false);
		    fieldSet.add(layoutContainer_15);
		    layoutContainer_15.setBorders(false);
		    
		    plFrmPayr3100.add(fieldSet); 
			//vp.add(panel);   
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
   
	  private void createListGrid() {
		  
 
		    FieldSet fldstNewFieldset = new FieldSet(); 
	    	fldstNewFieldset.setHeadingHtml("채권압류정보");
	    	fldstNewFieldset.setCollapsible(false);
	    	fldstNewFieldset.setStyleAttribute("marginTop", "10px");
		    LayoutContainer lcStdGrid = new LayoutContainer();
		   // lcStdGrid.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(true); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(950, 235);     
		    
		    //msfCustomForm.setHeaderVisible(false);
	        //Instantiate the GridPanel
		    payr0220GridPanel = new MSFGridPanel(payr0220Def, false, false, false, false);
		    payr0220GridPanel.setHeaderVisible(false);  
		    payr0220GridPanel.setBodyBorder(true);
		    payr0220GridPanel.setBorders(true);
	     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
		    final Grid payr0410Grid = payr0220GridPanel.getMsfGrid().getGrid();
            payr0410Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
               public void handleEvent(BaseEvent be) {  
                if (payr0220GridPanel.getCurrentlySelectedItem() != null) {    
                   
                    setRecord(payr0220GridPanel.getCurrentlySelectedItem());
                    setFormDataMapping();
                    actionDatabase = ActionDatabase.UPDATE;
                 } 
               }
           }); 
            
		    cpGrid.add(payr0220GridPanel); 
		    
		    lcStdGrid.add(cpGrid);   
		    fldstNewFieldset.add(lcStdGrid);   
		      
		    plFrmPayr3100.add(fldstNewFieldset, new FormData("100%"));
		    
	  }

  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	 
	  
		public void reload() {
				// TODO Auto-generated method stub
		       formInit();
		    
				IColumnFilter filters = null;
				payr0220GridPanel.getTableDef().setTableColumnFilters(filters);
				
				payr0220GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				payr0220GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				
				 String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				 payr0220GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
				// payr0220GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
				
	             String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	             payr0220GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	           //  payr0220GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	            // String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
	            // payr0220GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);   
			
				payr0220GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0220GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0220GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
				payr0220GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
				 
				payr0220GridPanel.reload();
				
			}
		  

		 //폼초기화  
		   private void formNew() {
		       
		       
               BaseModel bmBlank = new BaseModel();  
               
               dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd());    /** column 사업장코드 : dpobCd */
               systemkey.setValue("");    /** column SYSTEMKEY : systemkey */
               hanNm.setReadOnly(false);
               resnRegnNum.setReadOnly(false);
               btnHanNm.setEnabled(true);
                
               dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd());    /** column 사업장코드 : dpobCd */
               systemkey.setValue("");    /** column SYSTEMKEY : systemkey */
               
               hanNm.setValue("");         //성명
               resnRegnNum.setValue(""); //주민번호  
               secRegnNum.setValue(""); //주민번호  
               
               emymtDivNm.setValue("");
               typOccuNm.setValue(""); //직종 
              
               deptNm.setValue("");    //부서 
               businNm.setValue("");    //사업 
               
               provAthmSeilNum.setValue(0L);    /** column 가압류일련번호 : provAthmSeilNum */
               icntNum.setValue("");    /** column 사건번호 : icntNum */
               icntNm.setValue("");    /** column 사건명 : icntNm */
               cdtrNm.setValue("");    /** column 채권자명 : cdtrNm */
               bondIstut.setValue("");    /** column 채권기관 : bondIstut */
               bnkCd.setValue(bmBlank);    /** column 은행코드 : bnkCd */
               bnkAccuNum.setValue("");    /** column 은행계좌번호 : bnkAccuNum */
               acntHodrNm.setValue("");    /** column 예금주명 : acntHodrNm */
               rcptDt.reset();     /** column 접수일자 : rcptDt */
               dlvyDt.reset();    /** column 송달일자 : dlvyDt */
               dducPridBgnnDt.reset();    /** column 공제기간시작일자 : dducPridBgnnDt */
               dducPridEndDt.reset();    /** column 공제기간종료일자 : dducPridEndDt */
               bondFrclrEndYn.setValue(false);    /** column 채권압류종료여부 : bondFrclrEndYn */
               payDducYn.setValue(false);    /** column 급여공제여부 : payDducYn */
               clmSum.setValue(0L);    /** column 청구금액 : clmSum */
               clmBaln.setValue(0L);    /** column 청구잔액 : clmBaln */
               bondFrclrLmtSum.setValue(0L);    /** column 채권압류제한금액 : bondFrclrLmtSum */
               acmlteDducSum.setValue(0L);    /** column 누적공제금액 : acmlteDducSum */
               dducSum.setValue(0L);    /** column 공제금액 : dducSum */
               dducRto.setValue(0.0);    /** column 공제비율 : dducRto */
               provAthmNoteCtnt.setValue("");    /** column 가압류비고내용 : provAthmNoteCtnt */ 
               
		       actionDatabase = ActionDatabase.INSERT;
		       
		       
		   } 
		   
		   

   private void fnCreatePsnl0100() {
   
        MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(hanNm.getRawValue());  //인사  
        
        final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
       
        popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource();
                if (!"".equals(mapModel.get("systemkey"))) { 
                     
                    systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
                    hanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
                    resnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
                    secRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("secRegnNum")));   //주민번호 
                    emymtDivNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("emymtDivNm")));
                    typOccuNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("typOccuNm"))); //직종 
                    
                    deptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNm")));    //부서 
                    businNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("businNm")));    //사업 
                }  
             
                
            }
        });
    
   }     
   
   private void setFormDataMapping() { 
       
       hanNm.setReadOnly(true);
       resnRegnNum.setReadOnly(true);
       btnHanNm.setEnabled(false);
 
       dpobCd.setValue(MSFSharedUtils.allowNulls(record.get("dpobCd")));    /** column 사업장코드 : dpobCd */
       systemkey.setValue(MSFSharedUtils.allowNulls(record.get("systemkey")));    /** column SYSTEMKEY : systemkey */
        
       
       hanNm.setValue(MSFSharedUtils.allowNulls(record.get("hanNm")));         //성명
       resnRegnNum.setValue(MSFSharedUtils.allowNulls(record.get("resnRegnNum"))); //주민번호  
       secRegnNum.setValue(MSFSharedUtils.allowNulls(record.get("secRegnNum"))); //주민번호 
       emymtDivNm.setValue(MSFSharedUtils.allowNulls(record.get("emymtDivNm")));
       typOccuNm.setValue(MSFSharedUtils.allowNulls(record.get("typOccuNm"))); //직종 
      
       deptNm.setValue(MSFSharedUtils.allowNulls(record.get("deptNm")));    //부서 
       businNm.setValue(MSFSharedUtils.allowNulls(record.get("businNm")));    //사업 
        
       provAthmSeilNum.setValue((Long)record.get("provAthmSeilNum"));    /** column 가압류일련번호 : provAthmSeilNum */
       icntNum.setValue(MSFSharedUtils.allowNulls(record.get("icntNum")));    /** column 사건번호 : icntNum */
       icntNm.setValue(MSFSharedUtils.allowNulls(record.get("icntNm")));    /** column 사건명 : icntNm */
       cdtrNm.setValue(MSFSharedUtils.allowNulls(record.get("cdtrNm")));    /** column 채권자명 : cdtrNm */
       bondIstut.setValue(MSFSharedUtils.allowNulls(record.get("bondIstut")));    /** column 채권기관 : bondIstut */
       bnkCd.setValue(lsBnkCd.findModel("commCd",MSFSharedUtils.allowNulls(record.get("bnkCd"))));    /** column 은행코드 : bnkCd */
       bnkAccuNum.setValue(MSFSharedUtils.allowNulls(record.get("bnkAccuNum")));    /** column 은행계좌번호 : bnkAccuNum */
       acntHodrNm.setValue(MSFSharedUtils.allowNulls(record.get("acntHodrNm")));    /** column 예금주명 : acntHodrNm */
       rcptDt.setValue((Date)record.get("rcptDt"));    /** column 접수일자 : rcptDt */
       dlvyDt.setValue((Date)record.get("dlvyDt"));    /** column 송달일자 : dlvyDt */
       dducPridBgnnDt.setValue((Date)record.get("dducPridBgnnDt"));    /** column 공제기간시작일자 : dducPridBgnnDt */
       dducPridEndDt.setValue((Date)record.get("dducPridEndDt"));    /** column 공제기간종료일자 : dducPridEndDt */
       bondFrclrEndYn.setValue((Boolean)record.get("bondFrclrEndYn"));    /** column 채권압류종료여부 : bondFrclrEndYn */
       payDducYn.setValue((Boolean)record.get("payDducYn"));    /** column 급여공제여부 : payDducYn */
       clmSum.setValue((Long)record.get("clmSum"));    /** column 청구금액 : clmSum */
       clmBaln.setValue((Long)record.get("clmBaln"));    /** column 청구잔액 : clmBaln */
       bondFrclrLmtSum.setValue((Long)record.get("bondFrclrLmtSum"));    /** column 채권압류제한금액 : bondFrclrLmtSum */
       acmlteDducSum.setValue((Long)record.get("acmlteDducSum"));    /** column 누적공제금액 : acmlteDducSum */
       dducSum.setValue((Long)record.get("dducSum"));    /** column 공제금액 : dducSum */
       dducRto.setValue((Double)record.get("dducRto"));    /** column 공제비율 : dducRto */
       provAthmNoteCtnt.setValue(MSFSharedUtils.allowNulls(record.get("provAthmNoteCtnt")));    /** column 가압류비고내용 : provAthmNoteCtnt */
 
        
   }
		   
		 //폼초기화 검색조건포함 
		   private void formInit() {
		      
		       BaseModel bmBlank = new BaseModel();  
		        
		       hanNm.setReadOnly(false);
		       resnRegnNum.setReadOnly(false);
		       btnHanNm.setEnabled(true);
		       
		       dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd());    /** column 사업장코드 : dpobCd */
		       systemkey.setValue("");    /** column SYSTEMKEY : systemkey */
		       
		       hanNm.setValue("");         //성명
		       resnRegnNum.setValue(""); //주민번호  
		       secRegnNum.setValue(""); //주민번호  
		       
		       emymtDivNm.setValue("");
		       typOccuNm.setValue(""); //직종 
		      
		       deptNm.setValue("");    //부서 
		       businNm.setValue("");    //사업 
		        
		       provAthmSeilNum.setValue(0L);    /** column 가압류일련번호 : provAthmSeilNum */
		       icntNum.setValue("");    /** column 사건번호 : icntNum */
		       icntNm.setValue("");    /** column 사건명 : icntNm */
		       cdtrNm.setValue("");    /** column 채권자명 : cdtrNm */
		       bondIstut.setValue("");    /** column 채권기관 : bondIstut */
		       bnkCd.setValue(bmBlank);    /** column 은행코드 : bnkCd */
		       bnkAccuNum.setValue("");    /** column 은행계좌번호 : bnkAccuNum */
		       acntHodrNm.setValue("");    /** column 예금주명 : acntHodrNm */
		       rcptDt.reset();    /** column 접수일자 : rcptDt */
		       dlvyDt.reset();    /** column 송달일자 : dlvyDt */
		       dducPridBgnnDt.reset();    /** column 공제기간시작일자 : dducPridBgnnDt */
		       dducPridEndDt.reset();    /** column 공제기간종료일자 : dducPridEndDt */
		       bondFrclrEndYn.setValue(false);    /** column 채권압류종료여부 : bondFrclrEndYn */
		       payDducYn.setValue(false);    /** column 급여공제여부 : payDducYn */
		       clmSum.setValue(0L);    /** column 청구금액 : clmSum */
		       clmBaln.setValue(0L);    /** column 청구잔액 : clmBaln */
		       bondFrclrLmtSum.setValue(0L);    /** column 채권압류제한금액 : bondFrclrLmtSum */
		       acmlteDducSum.setValue(0L);    /** column 누적공제금액 : acmlteDducSum */
		       dducSum.setValue(0L);    /** column 공제금액 : dducSum */
		       dducRto.setValue(0.0);    /** column 공제비율 : dducRto */
		       provAthmNoteCtnt.setValue("");    /** column 가압류비고내용 : provAthmNoteCtnt */
		       
		    //   payr0220GridPanel.getMsfGrid().clearData();
		       actionDatabase = ActionDatabase.UPDATE;
		       
		   }
			   
		   public void setRecord(BaseModel record) {
		       this.record = record;
		   }
		 

		   private Payr3100 getThis(){
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
		   

		     //부서 
//		       private void fnPopupCommP140(String deptCd) {
//		           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//		           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//		           //검색.처리하면됨.
//		           
//		           MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//		           
//		           final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//		          
//		           popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//		               public void handleEvent(BaseEvent be) {
//		                   BaseModel mapModel = (BaseModel)be.getSource();
//		                   if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//		                        
//		                       srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//		                       srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//		                       srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//		                       srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//		                       srhDeptCd.fireEvent(Events.Add);
//		                   }  
//		                        
//		               }
//		           });
//		       }
		       
		      
		  
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
