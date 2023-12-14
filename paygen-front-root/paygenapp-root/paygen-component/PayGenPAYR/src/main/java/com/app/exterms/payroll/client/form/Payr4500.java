package com.app.exterms.payroll.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0305BM;
import com.app.exterms.payroll.client.form.defs.Payr0305Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.utils.PayrUtils;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
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
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr4500  extends MSFPanel { 



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
	 private PayrConstants lblBasisConst = PayrConstants.INSTANCE;
	

      private VerticalPanel vp;
	  private FormPanel plFrmPayr4500;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
		   
	  
	  private Payr0305Def payr0305Def  = new Payr0305Def();   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0305GridPanel;
	  private String checkedSystemKeys;
	  

		
      //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
  
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
      private ButtonBar topPayr4500Bar;
      private Button btnPayr4500Init;
      //private Button btnPayr4500Save;
      //private Button btnPayr4500Del;
      private Button btnPayr4500Sreach;
      private Button btnPayr4500Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
      private ComboBox<BaseModel> srhPayMonth;
      /** set 단위기관코드 : payrMangDeptCd */
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관 
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드  
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
    //  private ComboBox<BaseModel> srhDeptCd ;    //부서   
      private ComboBox<BaseModel> srhBusinCd;    //사업 
      private ComboBox<BaseModel> srhPayCd;   /** column 급여구분코드 : payCd */ 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
     // private ComboBox<BaseModel> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
       
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      private List<ModelData> mDtalistHdofcCodtnCd ;
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
   			  private void checkPayr4500Auth( String authAction, ListStore<BaseModel> bm) {   
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
        	
                 srhPayYr.setValue(lsPayYrStore.getAt(0));
        	
        	  srhPayCd.setValue(lsPayCd.getAt(0));
               /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			//	gwtAuthorization.formAuthConfig(plFrmPayr4500, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
            //  GWTAuthorization.formAuthConfig(plFrmPayr4500, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
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
   				  authMapDef.put("srhPayCd",Boolean.FALSE);
   				  authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
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
	    private void setPayr4550FormBinding() {
	 	 
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
	//private Payr4550ServiceAsync payr4550Service = Payr4550Service.Util.getInstance();	
	    
	// -------------- store 선언 시작 --------------
	private ListStore<BaseModel> lsPayYrStore 		= new ListStore<BaseModel>();	//년도 
	private ListStore<BaseModel> lsPayMonth 		= new ListStore<BaseModel>();  	//급여월 
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>(); 	//단위기관
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();  	//고용구분 
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>(); 	//부서
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>(); 	//사업
	private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>(); 	//급여구분
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>(); 	//직종
    private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
    private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
    
	// -------------- store 선언 종료 --------------
    
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; 
	private PrgmComBass0150DTO sysComBass0150Dto;
	private PrgmComBass0400DTO sysComBass0400Dto;	//부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드  
	private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
	private SysCoCalendarDTO msfCoCalendarDto; 
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	// -------------- DTO 선언 종료 --------------
	
	
	private BaseModel record;
    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr4550(){
//    	payr0301GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectPayr4550List(bass0200Dto, new AsyncCallback<List<Payr4550BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr4550(): "+caught), null);
//                msfPayr4550GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr4550BM> result) {
//            	composedPayr4550List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr4550List(List<Payr4550BM> listaMenu) {
//        Iterator<Sysm0200BM> iter = listaMenu.iterator();
//        BaseTreeModel folder = new BaseTreeModel();
//        BaseTreeModel category = null;
//        while ( iter.hasNext() ) {
//        	Sysm0200BM mnu = iter.next();
//            Integer ord = new Integer(mnu.getMnuPrntOrd().intValue());
//            BaseTreeModel bm = new BaseTreeModel();
//            bm.set("sysDivCd", mnu.getSysDivCd());
//            bm.set("mnuCd", mnu.getMnuCd());
//            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
//            bm.set("mnuNm", mnu.getMnuNm());
//            bm.set("mnuIcn", mnu.getMnuIcn()); 
//            bm.set("mnuTmbl", mnu.getMnuTmbl());
//            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
//            bm.set("mnuTipNm", mnu.getMnuTipNm());
//            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
//            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
//            bm.set("mnuPrntOrd", ord);
//            bm.set("useYn", mnu.getUseYn());
//            bm.set("mnuEpln", mnu.getMnuEpln());
//             
//            if (mnu.getHhrkMnuCd() == null) {
//                category = new BaseTreeModel();
//                category.setProperties(bm.getProperties());
//                folder.add(category);
//            } else {
//                if (category != null) {
//                    category.add(bm);
//                }
//            }
//        } 
//        msfPayr4550GridPanel.unmask();  
//    }
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnPayr4500Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr4500Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnPayr4500Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
//	  
//    private void doAction(ActionDatabase actionDatabase) {
//        switch (actionDatabase) {
//        case INSERT:
//            GestioneVociMenu caricaVmn = new GestioneVociMenu(ActionDatabase.INSERT, getThis());
//            MSFFormWindows w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtNew(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtSave(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show(); 
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(new BaseModel());
//            caricaVmn.pulisci();
//            break;
//        case UPDATE:
//            caricaVmn = new GestioneVociMenu(ActionDatabase.UPDATE, getThis());  	 
//            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtModification(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtRefresh(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show();
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(record);	   
//            break;
//        case DELETE:
//            caricaVmn = new GestioneVociMenu(ActionDatabase.DELETE, getThis());  	 
//            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtCancel(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtCancel(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show();  
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(record);	            	
//            break;
//        }
//    }
	
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

	private void Payr4500Print(String fileName, String repType) {
		if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			RdaPrint(fileName);
		} else if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			RexPrint(fileName);
		} else {
			Window.alert("출력 타입 오류!");
		}
	}

	
	//rda
	private void RdaPrint(String fileName) {
		 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		//검색조건
		String serarchParam = "";
		
		//권한 설정으로 인해 추가된 부분 
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
		String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
		
		String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
 	
		serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";   //$1
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]";  //$2
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";   //$3
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";    //$4
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]";           //$5
		//20151212-추가 시작 
	    if (payrMangDeptCd.equals(deptCdAuth)) { 
	    	serarchParam += "[]"; //$6
        } else {
        	serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; 		//$6
        }  
	    //20151212-추가 끝		
		serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$7
		serarchParam += "["+ MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", "") +"]"; //$8
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";       //$9
		
		checkedSystemKeys = "";
        
		if("PAYRT4500".equals(fileName)){
			List<BaseModel> list = payr0305GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
					for(BaseModel bm : list){
                        chkkey += "'"+bm.get("systemkey")+"',";
                    }
                    checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
				}
		} else {
			//원천징수분 아님
        }
            
            serarchParam = serarchParam+"["+checkedSystemKeys+"]";	//$10
			
            //20151212-변경추가 시작 
		    serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  //$11 //유우져 아이디 넘김 
			serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$12
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += "["+deptCdAuth+"]"; //$13 부서 
			serarchParam += "["+dtilOccuInttnCdAuth+"]"; //$14 직종세 
			//20151212-추가 끝 	
			
			GWT.log("popup : " + serarchParam);			
			String strParam = "/rp " + serarchParam ; 
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
		}
		
		
		
		
		
//		//TODO 확인
//	   if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
//           serarchParam += "[]";  //$11
//           serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$12
//       } else {
//           
           //직종 권한에 대한 처리 추가 기본 처리  $11로해서 처리 할것...$11
//           if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                     && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//               serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
//           } else {
//               serarchParam += "[]";
//           } 
//           serarchParam += "[]";  //$12
//       }

	
	//rex
	private void RexPrint(String fileName) {
		 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
				
		// reb 출력물
		String rexFileName = fileName+".crf";
		
		// 보낼 파라미터
		
		//검색조건
		String serarchParam = "";
		
		//권한 설정으로 인해 추가된 부분 
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
		String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
		String repbtyBusinDivCd = MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd") ;
		
		
		String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
 	
		serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";			// parameter1
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"⊥";			// parameter2
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";   // parameter3
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";	// parameter4
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"⊥";         // parameter5
		//20151212-추가 시작 
	    if (payrMangDeptCd.equals(deptCdAuth)) { 
	    	serarchParam += "⊥"; // parameter6
        } else {
        	serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; 		// parameter6
        }  
	    //20151212-추가 끝 
		
		serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";	// parameter7
		serarchParam += ""+ MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", "") +"⊥"; // parameter8
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";		// parameter9

		checkedSystemKeys = "";
            
		if("PAYRT4500".equals(fileName)){
			List<BaseModel> list = payr0305GridPanel.getGrid().getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0){
				String chkkey = "";
					for(BaseModel bm : list){
                        chkkey += "'"+bm.get("systemkey")+"',";
                    }
                    checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
				}
		} else {
			//원천징수분 아님
        }
            
            serarchParam = serarchParam+""+checkedSystemKeys+"⊥";	// parameter10
			
            //20151212-변경추가 시작 
		    serarchParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  // parameter11 //유우져 아이디 넘김 
			serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; // parameter12
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += ""+deptCdAuth+"⊥"; // parameter13 부서 
			serarchParam += ""+dtilOccuInttnCdAuth+"⊥"; // parameter14 직종세 
			//20151212-추가 끝 	
			
			serarchParam += ""+mangeDeptCd+"⊥"; // parameter15 관리부서
			serarchParam += ""+repbtyBusinDivCd+"⊥"; // parameter16 호봉제구분
			
			
			GWT.log("popup : " + serarchParam);
			String strParam = "" + serarchParam ;		
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
	}
	
//	private void Payr4500Print(String fileName) {
//		 
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "PAYR";
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		// 보낼 파라미터
//		
//		
//		//검색조건
// 	String serarchParam = "";
// 	
// 	serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";   //$1
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month") +"]";  //$2
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";   //$3
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";    //$4
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]";           //$5
//	
//	serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$6
//	serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$7
//	serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd") +"]";  //$8
//	//serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$9
//	    
////	serarchParam += "["+MSFSharedUtils.allowNulls( srhDeptCd.getValue())+"]";              //$6
////	serarchParam += "["+ MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")+"]";      //$7
////	serarchParam += "["+ MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd")+"]"; //$8  
//	
//	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";       //$9
//	serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";               //$10
////	serarchParam += "["+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"]";
////	serarchParam += "["+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"]";
//	
//		
////		List<BaseModel> list = payr0305GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
//	
//	   if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
//	        
//           serarchParam += "[]";  //$11
//           serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$12
//       
//       } else {
//           
//           //직종 권한에 대한 처리 추가 기본 처리  $11로해서 처리 할것...$11
//           if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                     && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//               serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
//           } else {
//               serarchParam += "[]";
//           } 
//           
//           serarchParam += "[]";  //$12
//       }
//    
//		String strParam = "/rp " + serarchParam ; //+"["+checkedSystemKeys+"]";
//		
//		
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//
//	}

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
    
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPayr4500Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createCheckBoxGrid();     
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				
				 //콤보 권한초기화
				   initLoad(); 
				
			    detailTp = XTemplate.create(getDetailTemplate());
			    
			   // formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createPayr4500Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createCheckBoxGrid();     
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
	  public Payr4500() {
		   
		  //엣지변환
		  //setSize("1010px", "700px");
			setSize("1010px", "750px");  
	  } 
	
	  public Payr4500(String txtForm) {
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
	  private void createPayr4500Form() {
		  
			plFrmPayr4500 = new FormPanel();
			plFrmPayr4500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblBasisConst.title_Payr4500()));
		//	plFrmPayr4500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 소득세납부내역");
			plFrmPayr4500.setIcon(MSFMainApp.ICONS.text());
			plFrmPayr4500.setBodyStyleName("pad-text");
			plFrmPayr4500.setPadding(2);
			plFrmPayr4500.setFrame(true);  

			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage(lblBasisConst.title_Payr4500(),"PAYR4500");
					}
				});
			plFrmPayr4500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPayr4500.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

			
			  //멀티콤보박스 닫기 
			plFrmPayr4500.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) { 
	            
	             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
	                    
	            //        if (f instanceof MSFMultiComboBox<?>) {
	                        
//	                    if ("srhDeptCd".equals(f.getName())) {
//	                        
//	                    } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                        
//	                    }
	                        
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
                        } 
//                        else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
//                            //직종세
//                            srhDtilOccuInttnCd.showClose(ce);
//                            mutilCombo = false;
//                        }  
                   }
	                //    }
	            //    } 
	            } 
	        });
	        
			topPayr4500Bar = new ButtonBar();    
			topPayr4500Bar.setAlignment(HorizontalAlignment.RIGHT);
  
		  
//				Button topBtn = new Button("신규");  
//			  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//			  	buttonBar.add(topBtn);
			  	 
//			  	topBtn = new Button("저장");  
//			  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//			  	buttonBar.add(topBtn); 
			   
				btnPayr4500Init = new Button("초기화");  
				btnPayr4500Init.setIcon(MSFMainApp.ICONS.new16());
			  	topPayr4500Bar.add(btnPayr4500Init);
			  	btnPayr4500Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //초기화 
		    			formInit();
		    		}
		    	});
			  	 
			    Button btnPayr4500Sreach = new Button("조회"); 
			    btnPayr4500Sreach.setIcon(MSFMainApp.ICONS.search16());
			    topPayr4500Bar.add(btnPayr4500Sreach);
			  	btnPayr4500Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
			  	
			  	
			  	Button btnPayr4500Print = new Button("인쇄"); 
			  	btnPayr4500Print.setIcon(MSFMainApp.ICONS.print16()); 
			  	topPayr4500Bar.add(btnPayr4500Print); 
			  	btnPayr4500Print.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			Payr4500Print("PAYRT4500", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
		    		}
		    	});
			  	
			  	btnPayr4500Excel = new Button("엑셀"); 
			  	btnPayr4500Excel.setIcon(MSFMainApp.ICONS.excel16()); 
			  	topPayr4500Bar.add(btnPayr4500Excel); 
			  	btnPayr4500Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			
		    			excelFileExport();
		    		}
		    	});
			  	
			  	
//			  	topBtn = new Button("엑셀"); 
//			  	topBtn.setIcon(MSFMainApp.ICONS.excel16()); 
//			  	buttonBar.add(topBtn); 
			  	
		  	
		  	plFrmPayr4500.add(topPayr4500Bar);    
		  	 
		
			vp.add(plFrmPayr4500);
			//엣지변환
			//plFrmPayr4500.setSize("990px", "680px");
			plFrmPayr4500.setSize("990px", "730px");
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
		 	     		   ContentPanel payYrGrid = new ContentPanel();  
		 	     		   payYrGrid.setVisible(false);
		 	     		    
		 	     		   //년도 콤보처리 
		 	     		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
		 	     		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
		 	     			       public void handleEvent(ComponentEvent be) {  
		 	     			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
		 	     			          public void handleEvent(StoreEvent<BaseModel> be) {  
		 	     			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
		 	     			        	 
		 	     			          }  
		 	     			        });  
		 	     			       
		 	     			      }  
		 	     			    });  
		 	     	  
		 	     		payYrGrid.add(payYrGridPanel); 
		 	     		plFrmPayr4500.add(payYrGrid); 
		  
		   plFrmPayr4500.setLayout(new FlowLayout());
		    
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
		    srhPayYr.setDisplayField("payYrDisp");
		    srhPayYr.setValueField("payYr");
		    srhPayYr.setTriggerAction(TriggerAction.ALL);
//		    srhPayYr.setEmptyText("--년도선택--");
		    srhPayYr.setSelectOnFocus(true); 
		    srhPayYr.setReadOnly(false);
		    srhPayYr.setEnabled(true); 
		    srhPayYr.setStore(lsPayYrStore); 
		    srhPayYr.setFieldLabel("지급년도");    
		    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

	            	  EventType type = be.getType();
			    	   if (type == Store.Add) { 
	               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkPayr4500Auth("srhPayYr", lsPayYrStore); 
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
	                        
	                         sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
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
		    
//		    lcSchLeft.add(srhPayYr, new FormData("100%")); 
		    layoutContainer_8.add(srhPayYr, new FormData("100%"));
		    layoutContainer_8.setBorders(false);
		    
		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_9.setLayout(frmlytSch);
		    
		    srhPayMonth = new ComboBox<BaseModel>(); 
		    srhPayMonth.setName("srhPayMonth");
		    srhPayMonth.setForceSelection(true);
		    srhPayMonth.setMinChars(1);
		    srhPayMonth.setDisplayField("monthDisp");
		    srhPayMonth.setValueField("month");
		    srhPayMonth.setTriggerAction(TriggerAction.ALL);
		  //srhPayMonth.setEmptyText("--월선택--");
		    srhPayMonth.setSelectOnFocus(true); 
		    srhPayMonth.setReadOnly(false);
		    srhPayMonth.setEnabled(true); 
		    srhPayMonth.setStore(lsPayMonth);
		    srhPayMonth.setHideLabel(true);
		    srhPayMonth.select(0);
		    lsPayMonth.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

	            	  EventType type = be.getType();
			    	   if (type == Store.Add) { 
	               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			    		  Date today = new Date(); 
			         	  //   A custom date format
			         	  DateTimeFormat fmt = DateTimeFormat.getFormat("MM"); 
			         	  srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
			         	  
			              checkPayr4500Auth("srhPayMonth", lsPayMonth); 
	               	 }
	                
	                
	            }
	        }); 
		    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_9.setBorders(false);
		    
            LayoutContainer layoutContainer = new LayoutContainer();
            layoutContainer.setBorders(false);
            
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
			                	checkPayr4500Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
			                	checkPayr4500Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	               // srhDtilOccuInttnCd.reset();
	              //  srhDtilOccuInttnCd.setEnabled(false);
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
		    layoutContainer_14.setBorders(false); 
		    
		    
		    LayoutContainer layoutContainer_101 = new LayoutContainer();
			layoutContainer_101.setBorders(false);

		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_101.setLayout(frmlytSch);
		    
		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		    srhRepbtyBusinDivCd.setForceSelection(true);
		    srhRepbtyBusinDivCd.setAllowBlank(true);
		    srhRepbtyBusinDivCd.setMinChars(1);
		    srhRepbtyBusinDivCd.setLabelSeparator("");
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
            layoutContainer_6.add(srhHanNm, new FormData("100%"));
            srhHanNm.setFieldLabel("성명");
          
            srhHanNm.addKeyListener(new KeyListener() {
            	 @Override
                public void componentKeyDown(ComponentEvent event) {
//                    
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
            layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.44));
            layoutContainer_6.setBorders(false);
            
            
            LayoutContainer layoutContainer_btn = new LayoutContainer();
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(0); 
            layoutContainer_btn.setLayout(frmlytSch);
            
            Button btnHanNm = new Button("검색");
            layoutContainer_5.add(btnHanNm); 
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
            
            srhResnRegnNum = new TextField<String>();
            srhResnRegnNum.setName("srhResnRegnNum");
            srhResnRegnNum.setHideLabel(true);
            new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
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
            
  
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 			// 지급년도
		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 단위기관
		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); // 고용구분
		    
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    layoutContainer_13.setLayout(new ColumnLayout());
		    layoutContainer_13.setBorders(false);
		    
		    
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
			                	checkPayr4500Auth("srhDeptCd", lsDeptCd); 
	                	 }
	            }
	        });    
	 
	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	           @Override
	          public void handleEvent(ComponentEvent ce) { 
	                   
	                      if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                         
	                          if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                             
	                              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
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

            LayoutContainer layoutContainer_10 = new LayoutContainer(); 
            frmlytSch = new FormLayout();  
//            frmlytSch.setLabelWidth(70); 
            frmlytSch.setDefaultWidth(0);
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_10.setLayout(frmlytSch);
            
     
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
			                    
	                    }  
			    		   }
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	//checkPayr4500Auth("srhTypOccuCd", lsTypOccuCd); 
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
	        
            layoutContainer_10.add(srhTypOccuCd, new FormData("100%"));
            layoutContainer_10.setBorders(false); 
            
            LayoutContainer lcSchRight = new LayoutContainer();
  	      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
  	        frmlytSch = new FormLayout();  
  	        frmlytSch.setLabelWidth(1); 
  	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
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
  	        lcTypOccuCd.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
	        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
	          
	        
		    layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 관리부서 
		    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 부서
		    layoutContainer_13.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));			// 직종
		    
		    fieldSet.add(layoutContainer_13);
		    
	        LayoutContainer lcSchCol3 = new LayoutContainer();
	        lcSchCol3.setLayout(new ColumnLayout());
	        
	        
	        LayoutContainer layoutContainer_1 = new LayoutContainer();
            layoutContainer_1.setBorders(false);
            
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(60); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
            layoutContainer_1.setLayout(frmlytSch);
            
            /* 급여구분코드 : srhPayCd */
            srhPayCd = new ComboBox<BaseModel>(); 
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
     
                	checkPayr4500Auth("srhPayCd",lsPayCd);   
                }
            });  
            layoutContainer_1.add(srhPayCd, new FormData("100%"));
            
 
            
		    LayoutContainer layoutContainer_4 = new LayoutContainer();
		    layoutContainer_4.setBorders(false);
		    
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
		    
		    
//	        LayoutContainer layoutContainer_16 = new LayoutContainer();
//	        
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(0); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_16.setLayout(frmlytSch);
		    
	        
	        lcSchCol3.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 사업
	        lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 성명
	        lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));// 
	        
		    fieldSet.add(lcSchCol3);
			
		    plFrmPayr4500.add(fieldSet); 
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
   * 그리드 처리 함수 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 
	  private void createCheckBoxGrid() {   
 
		  
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("소득세납부내역");
		    fieldSet.setStyleAttribute("marginTop", "10px");
		    LayoutContainer lcStdGrid = new LayoutContainer();
		 //   lcStdGrid.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(950, 490);  
 
		    //msfCustomForm.setHeaderVisible(false);
	        //Instantiate the GridPanel
		    payr0305GridPanel = new MSFGridPanel(payr0305Def, false, false, false, false,false);
		    payr0305GridPanel.setHeaderVisible(false);  
		    payr0305GridPanel.setBodyBorder(true);
		    payr0305GridPanel.setBorders(true);
		  //  payr0305GridPanel.setSize(935, 455);  
	     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	    
		    
		    AggregationRowConfig<BaseModel> payr0305SummaryRow = new AggregationRowConfig<BaseModel>();  
			 
		    payr0305SummaryRow.setCellStyle(Payr0305BM.ATTR_PYMTYRMNTH,"summary_color");
		    payr0305SummaryRow.setCellStyle(Payr0305BM.ATTR_WORKINCMTXTNSUM,"summary_color");
		    payr0305SummaryRow.setCellStyle(Payr0305BM.ATTR_DEINTXAMNT,"summary_color");
		    payr0305SummaryRow.setCellStyle(Payr0305BM.ATTR_TXTBSIMFTXS,"summary_color");
		    payr0305SummaryRow.setCellStyle(Payr0305BM.ATTR_TURTYINCMTXQNTY,"summary_color");
		    payr0305SummaryRow.setCellStyle(Payr0305BM.ATTR_LOCINCMTXAMT,"summary_color");
		   //  String htmlAttr = "<span style='background-color:yellow; background-repeat: no-repeat;'>합 계</span>" ;
		    
		    payr0305SummaryRow.setHtml(Payr0305BM.ATTR_PYMTYRMNTH, "합 계");   
		    
		    // with summary type and format  
		    payr0305SummaryRow.setSummaryType(Payr0305BM.ATTR_WORKINCMTXTNSUM, SummaryType.SUM);   
		    payr0305SummaryRow.setSummaryFormat(Payr0305BM.ATTR_WORKINCMTXTNSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		    payr0305SummaryRow.setSummaryType(Payr0305BM.ATTR_DEINTXAMNT, SummaryType.SUM);   
		    payr0305SummaryRow.setSummaryFormat(Payr0305BM.ATTR_DEINTXAMNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		    payr0305SummaryRow.setSummaryType(Payr0305BM.ATTR_TXTBSIMFTXS, SummaryType.SUM);   
		    payr0305SummaryRow.setSummaryFormat(Payr0305BM.ATTR_TXTBSIMFTXS, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		    payr0305SummaryRow.setSummaryType(Payr0305BM.ATTR_TURTYINCMTXQNTY, SummaryType.SUM);   
		    payr0305SummaryRow.setSummaryFormat(Payr0305BM.ATTR_TURTYINCMTXQNTY, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		    payr0305SummaryRow.setSummaryType(Payr0305BM.ATTR_LOCINCMTXAMT, SummaryType.SUM);   
		    payr0305SummaryRow.setSummaryFormat(Payr0305BM.ATTR_LOCINCMTXAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
		      
		    // with renderer  
//		    averages.setSummaryType("change", SummaryType.AVG);  
//		    averages.setRenderer("change", new AggregationRenderer<Stock>() {  
//		      public Object render(Number value, int colIndex, Grid<Stock> grid, ListStore<Stock> store) {  
//		        // you can return html here  
//		        return number.format(value.doubleValue());  
//		      }  
//		    });  
		    payr0305GridPanel.getGrid().getColumnModel().addAggregationRow(payr0305SummaryRow);  
		     
		    cpGrid.add(payr0305GridPanel); 
		    
		    lcStdGrid.add(cpGrid);   
		    fieldSet.add(lcStdGrid);   
		      
		    plFrmPayr4500.add(fieldSet);
		     
		  }    

		  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reload() {
			// TODO Auto-generated method stub
	        payr0305GridPanel.getMsfGrid().clearData();
	        
			IColumnFilter filters = null;
			payr0305GridPanel.getTableDef().setTableColumnFilters(filters);
			
			payr0305GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0305GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			payr0305GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0305GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			//20180305추가 
			payr0305GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0305GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			
			String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			payr0305GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS); 
             
             String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
             payr0305GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           //  String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
           //  payr0305GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
           //  String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
          //   payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
          
			
			//payr0305GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
			//payr0305GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0305GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0305GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0305GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0305GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
			payr0305GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			
			payr0305GridPanel.reload();
		}
	  
	 //폼초기화 검색조건포함 
	   private void formInit() {
		   BaseModel bmInit = new BaseModel();
		
		  // srhPayYr.setValue(bmInit);
		  // srhPayMonth.setValue(bmInit);

		  // srhTypOccuCd.setValue(bmInit); //직종 
		  // srhPayCd.setValue(bmInit);     //급여구분
		  // srhEmymtDivCd.setValue(bmInit); //고용구분 
		   //srhPayrMangDeptCd.setValue(bmInit); //단위기관

		 //  srhDeptCd.setValue("") ;    //부서 
		 //  srhBusinCd.setValue(bmInit);    //사업
		   srhHanNm.setValue("");         //성명
		   srhResnRegnNum.setValue("");   //주민번호 
		   srhSystemkey.setValue("");   //시스템키

		   //grid init
		   payr0305GridPanel.getMsfGrid().clearData();
		    
		   
	   }
	   
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 

	   private Payr4500 getThis(){
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
		
		
		//엑셀 저장
		private void excelFileExport() {
		                     
			HashMap<String, String> param = new HashMap<String, String>(); 
			
			
			param.put("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month"))); 
			param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			
			param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
			param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
			
			param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); 
			param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")); 
			 
			String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			param.put("deptCd", strDeptCd); 
             
			String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
            param.put("typOccuCd", strTypOccuCd); 
            param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
            param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
            param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
            param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		   
		                     
			if("".equals(srhPayYr)){
				MessageBox.info("", "년도는 필수 입니다.", null);
			}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//				if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
//					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//				} else { 
					payr0305GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr4500Export.do","extgwtFrame" ,param);   
//				}
			}else{ 
				payr0305GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr4500Export.do","extgwtFrame" ,param);  
			}
		}	
		
		
	 

}
