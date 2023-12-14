package com.app.exterms.payroll.client.form;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0440DTO;
import com.app.exterms.payroll.client.dto.Payr0445DTO;
import com.app.exterms.payroll.client.form.defs.Payr0440Def;
import com.app.exterms.payroll.client.form.defs.Payr0445Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0440PayYr;
import com.app.exterms.payroll.client.lookup.LookupPayr0440UcstDgmApptnDt;
import com.app.exterms.payroll.client.service.Payr5200Service;
import com.app.exterms.payroll.client.service.Payr5200ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.model.Stock;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
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
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr5200  extends MSFPanel { 

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
	  private FormPanel plFrmPayr5200;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  private GridCellRenderer<Stock> gridNumber;   
	  private GridCellRenderer<Stock> change; 
		  
	  private Payr0440Def payr0440ToPayr5200Def  = new Payr0440Def("PAYR5200");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0440ToPayr5200GridPanel;
	  
	  private Payr0440Def payr0440Def  = new Payr0440Def("");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0440GridPanel;
	  
	  private Payr0445Def payr0445Def  = new Payr0445Def();   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0445GridPanel;
 

      private LookupPayr0440PayYr lkApptnYr = new LookupPayr0440PayYr();  
      private MSFGridPanel payYrGridPanel;
      

      private LookupPayr0440UcstDgmApptnDt lkOccuClssPayCmpttnStd = new LookupPayr0440UcstDgmApptnDt();  
      private MSFGridPanel occuClssPayCmpttnStdGridPanel;
      
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
      private ButtonBar topPayr5200Bar;
      private Button btnPayr5200Init;
     // private Button btnPayr5200Save;
      private Button btnPayr5200Del;
      private Button btnPayr5200Sreach;
      private Button btnPayr5200Print;
      private Button btnPayr5200Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      /** column 급여년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
      private ComboBox<BaseModel>  srhOccuClssPayCmpttnStd; //단가표적용일자 
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      /** column 직종코드 : typOccuCd */
     // private ComboBox<BaseModel> srhTypOccuCd; 
  //    private HiddenField<String> srhPyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
      
      /** column 직종세코드 : dtilOccuInttnCd */  
      //private ComboBox<BaseModel> srhDtilOccuInttnCd; 
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
       
      private boolean mutilCombo = false;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */

     private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
     private HiddenField<String> typOccuCd;  /** column 직종코드 : typOccuCd */
     private TextField<String> typOccuNm;   /** column 직종코드 : typOccuCd */
//
//    private TextField<String> payCd   /** column 급여구분코드 : payCd */
//
     private HiddenField<String> pyspLogSvcYrNumCd;   /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
     private TextField<String> pyspLogSvcYrNumNm; /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
//
  //   private HiddenField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//    private TextField<String> payItemCd   /** column 급여항목코드 : payItemCd */
//
      private DateField    occuClssPayCmpttnStd;   /** column 단가표적용일자 : occuClssPayCmpttnStd */
//
      private HiddenField<String> dtilOccuInttnCd;   /** column 직종세코드 : dtilOccuInttnCd */
      private TextField<String> dtilOccuClsDivNm;  /** column 직종세코드 : dtilOccuInttnCd */
//
      private TextField<String> payYr;   /** column 급여년도 : payYr */
//
//    private TextField<String> occuClssPayCmpttnStd   /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
//
//    private TextField<String> ucstSum   /** column 단가금액 : ucstSum */
//
//    private TextField<String> ucstCalcDivCd   /** column 단가계산구분코드 : ucstCalcDivCd */
//
//    private TextField<String> ucstPrntOrd   /** column 단가출력순서 : ucstPrntOrd */
//
//    private TextField<String> ucstDgmBgnnDt   /** column 단가표시작일자 : ucstDgmBgnnDt */
//
//    private TextField<String> ucstDgmEndDt   /** column 단가표종료일자 : ucstDgmEndDt */
//
//    private TextField<String> ucstDgmUseYn   /** column 단가표사용여부 : ucstDgmUseYn */
//
//    private TextField<String> ucstNoteCtnt   /** column 단가비고내용 : ucstNoteCtnt */
  
//    private TextField<String> payrMangDeptCd   /** column null : payrMangDeptCd */
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
   			  private void checkPayr5200Auth( String authAction, ListStore<BaseModel> bm) {   
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
   				Field<?>[] fldArrField = {srhPayrMangDeptCd, srhTypOccuCd};
 				 
			      gwtAuthorization.formAuthFieldConfig(fldArrField); 
			      
			      
			      srhPayYr.setValue(lsPayYrStore.getAt(0)); 
			      srhOccuClssPayCmpttnStd.setValue(lsOccuClssPayCmpttnStd.getAt(0));
	                   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					//gwtAuthorization.formAuthConfig(plFrmPayr5200, "srhPayrMangDeptCd","","","srhTypOccuCd","");
	                   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	             
		                 
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
   				  authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
   			//	  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
   					 
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
	    private void setPayr5200FormBinding() {
	 	 
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
	private Payr5200ServiceAsync payr5200Service = Payr5200Service.Util.getInstance();	    
	 
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();
	
	private ListStore<BaseModel> lsOccuClssPayCmpttnStd = new ListStore<BaseModel>(); //단가표적용일자 
	private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>(); //단위기관
	private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();   /** column 직종코드 : typOccuCd */
	 
	private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();
	
	private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
	private PrgmComBass0350DTO sysComBass0350Dto;  
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
//	            if (ce.getButton() == btnPayr5200Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr5200Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else 
	            if (ce.getButton() == btnPayr5200Del) {
	            	
	                   if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
		                	 
	                	 MessageBox.alert("오류", "마스터 관리자만 삭제 가능합니다.</br>관리자에게 문의해주세요.", null);
	                     return; 
	                     
	                   }
	            	
	                doAction(ActionDatabase.DELETE);
	            }

	        }  
	    };
	  
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
//            GestioneVociMenu caricaVmn = new GestioneVociMenu(ActionDatabase.INSERT, getThis());
//            MSFFormWindows w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtNew(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtSave(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show(); 
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(new BaseModel());
//            caricaVmn.pulisci();
            break;
        case UPDATE:
//            caricaVmn = new GestioneVociMenu(ActionDatabase.UPDATE, getThis());  	 
//            w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtModification(),caricaVmn,MSFMainApp.MSFCONSTANTS.BtRefresh(),MSFMainApp.MSFCONSTANTS.BtDelete());
//            w.show();
//            caricaVmn.setMSFFormWindows(w);
//            caricaVmn.bind(record);	   
            break;
        case DELETE:
             deletePayr0440(record);         	
            break;
        }
        
    }
    
 private void deletePayr0440(BaseModel bmRecord) {
     
     
     if(MSFSharedUtils.paramNotNull(bmRecord)){
         
         final ActionDatabase actionDatabase = ActionDatabase.DELETE;
         
         final Payr0440DTO payr0440Dto = new Payr0440DTO();
      
         payr0440Dto.setDpobCd(MSFSharedUtils.allowNulls(bmRecord.get("dpobCd")));   /** column 사업장코드 : dpobCd */  
         payr0440Dto.setPayYr(MSFSharedUtils.allowNulls(bmRecord.get("payYr")));   /** column 급여년도 : payYr */     
         payr0440Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmRecord.get("typOccuCd")));  /** column 직종코드 : typOccuCd */                           
         payr0440Dto.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmRecord.get("pyspLogSvcYrNumCd$commCd")));   /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */   
       //  payr0440Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmRecord.get("pyspGrdeCd")));   /** column 호봉등급코드 : pyspGrdeCd */                    
         payr0440Dto.setOccuClssPayCmpttnStd(GWTUtils.getStringFromDate((Date)bmRecord.get("occuClssPayCmpttnStd"),"yyyyMMdd") );   /** column 단가표적용일자 : occuClssPayCmpttnStd */          
         payr0440Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmRecord.get("dtilOccuInttnCd")));   /** column 직종세코드 : dtilOccuInttnCd */          
         payr0440Dto.setPayItemCd("");  //근속년수코드
         
         MessageBox.confirm("삭제", "선택하신 단가표를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
             @Override
             public void handleEvent(MessageBoxEvent be) {
               //  if("Yes".equals(be.getButtonClicked().getText())){
            	 if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                      
                     payr5200Service.activityOnPayr5200(payr0440Dto, actionDatabase, new AsyncCallback<Long>(){
                       public void onFailure(Throwable caught) {
                           MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                   MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr5200(): "+caught), null);
                       }

                       public void onSuccess(Long result) {
                           if (result.compareTo(new Long(0))==0) {
                               MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                       MSFMainApp.ADMINMESSAGES.ExceptionMessageService("in activityOnPayr5200()"), null);
                           } else {
                                MessageBox.alert("삭제완료", "선택하신 단가표가 삭제되었습니다.", null);
                                payr0440ToPayr5200GridPanel.reload();
                           }
                       }
                   }); 
                      
                 }
             }
         });
     } else {
         MessageBox.alert("단가표선택", "삭제할 단가표를 선택하십시요.", null);
     }
     
 
	       
 
 }  
 
 
 /**
  * form detail info data update 
  */
 public void detailFormSave() {
//   if (isValid()) {
     if (MSFSharedUtils.paramNotNull(records)) {
               actionDatabase = ActionDatabase.UPDATE;
              
               List<Payr0440DTO> listPayr0440dto = new ArrayList<Payr0440DTO>();  
               
               while (records.hasNext()) {
             
                   Record record = (Record) records.next(); 
                   BaseModel bmMapModel = (BaseModel)record.getModel();
                     
                   Payr0440DTO payr0440Dto = new Payr0440DTO();  
               
                    payr0440Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                    payr0440Dto.setPayYr(MSFSharedUtils.allowNulls(bmMapModel.get("payYr")));    /** column 급여년도 : payYr */
                    payr0440Dto.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspLogSvcYrNumCd$commCd")));    /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
                    payr0440Dto.setTypOccuGrdeMppgSeilNum((Long)bmMapModel.get("typOccuGrdeMppgSeilNum"));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
                    payr0440Dto.setPayrItemSeilNum((Long)bmMapModel.get("payrItemSeilNum"));    /** column 급여항목일련번호 : payrItemSeilNum */
                    payr0440Dto.setOccuClssPayCmpttnStd(GWTUtils.getStringFromDate((Date)bmMapModel.get("occuClssPayCmpttnStd"),"yyyyMMdd"));    /** column 직종세별급여생성일자 : occuClssPayCmpttnStd */
                    payr0440Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
                    payr0440Dto.setUcstSum((Long)bmMapModel.get("ucstSum"));    /** column 단가금액 : ucstSum */
                    payr0440Dto.setUcstCalcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("ucstCalcDivCd$commCd")));    /** column 단가계산구분코드 : ucstCalcDivCd */
                    payr0440Dto.setUcstPrntOrd((Long)bmMapModel.get("ucstPrntOrd"));    /** column 단가출력순서 : ucstPrntOrd */
                    payr0440Dto.setUcstDgmBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("ucstDgmBgnnDt"),"yyyyMMdd"));    /** column 단가표시작일자 : ucstDgmBgnnDt */
                    payr0440Dto.setUcstDgmEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("ucstDgmEndDt"),"yyyyMMdd"));    /** column 단가표종료일자 : ucstDgmEndDt */
                    payr0440Dto.setUcstDgmUseYn((Boolean)bmMapModel.get("ucstDgmUseYn"));    /** column 단가표사용여부 : ucstDgmUseYn */
                    payr0440Dto.setPayrItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrItemCd")));   /** column 지급항목코드 : payrItemCd */
                    payr0440Dto.setUcstNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("ucstNoteCtnt")));    /** column 단가비고내용 : ucstNoteCtnt */
//                    payr0440Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//                    payr0440Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//                    payr0440Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                    payr0440Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//                    payr0440Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//                    payr0440Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
                     
        
                   listPayr0440dto.add(payr0440Dto);
                 
               }    
                   
               payr5200Service.activityOnPayr0440DetailFormSave(listPayr0440dto, 
                                       actionDatabase,
                                       new AsyncCallback<Long>() {
                   public void onFailure(Throwable caught) {
                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0410DetailFormSave(" + actionDatabase.name() + ") : " + caught), null);
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
     } else {
         MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
         return;
     }
//  // }
 } 
 
 
 public void detailSubFormSave() {
//   if (isValid()) {
     if (MSFSharedUtils.paramNotNull(records)) {
               actionDatabase = ActionDatabase.UPDATE;
              
               List<Payr0445DTO> listPayr0445dto = new ArrayList<Payr0445DTO>();  
               
               while (records.hasNext()) {
             
                    Record record = (Record) records.next(); 
                    BaseModel bmMapModel = (BaseModel)record.getModel();
                     
                    Payr0445DTO payr0445Dto = new Payr0445DTO();  
                
                    
                    payr0445Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                    payr0445Dto.setPayYr(MSFSharedUtils.allowNulls(bmMapModel.get("payYr")));    /** column 급여년도 : payYr */
                    payr0445Dto.setTypOccuGrdeMppgSeilNum((Long)bmMapModel.get("typOccuGrdeMppgSeilNum"));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
                    payr0445Dto.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspLogSvcYrNumCd")));    /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
                    payr0445Dto.setPayrItemSeilNum((Long)bmMapModel.get("payrItemSeilNum"));    /** column 급여항목일련번호 : payrItemSeilNum */
                    payr0445Dto.setOccuClssPayCmpttnStd(MSFSharedUtils.allowNulls(bmMapModel.get("occuClssPayCmpttnStd")));    /** column 직종세별급여생성일자 : occuClssPayCmpttnStd */
                    payr0445Dto.setMnthUsalyAmntWag((Long)bmMapModel.get("mnthUsalyAmntWag"));    /** column 월통상임금액 : mnthUsalyAmntWag */
                    payr0445Dto.setMnthUsalyAmntAllwBnusSum((Long)bmMapModel.get("mnthUsalyAmntAllwBnusSum"));    /** column 월통상임금상여금액 : mnthUsalyAmntAllwBnusSum */
                    payr0445Dto.setUsalyAmntPdyQnty((Long)bmMapModel.get("usalyAmntPdyQnty"));    /** column 통상임금일급액 : usalyAmntPdyQnty */
                    payr0445Dto.setUsalyAmntHrwgQnty((Long)bmMapModel.get("usalyAmntHrwgQnty"));    /** column 통상임금시급액 : usalyAmntHrwgQnty */
//                    payr0445Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//                    payr0445Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//                    payr0445Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                    payr0445Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//                    payr0445Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//                    payr0445Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */

                     
                   listPayr0445dto.add(payr0445Dto);
                 
               }    
                   
               payr5200Service.activityOnPayr0445DetailFormSave(listPayr0445dto, 
                                       actionDatabase,
                                       new AsyncCallback<Long>() {
                   public void onFailure(Throwable caught) {
                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0445DetailFormSave(" + actionDatabase.name() + ") : " + caught), null);
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
     } else {
         MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
         return;
     }
//  // }
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
	private void Payr5200Print(String fileName) {
 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		
		//검색조건
 	String serarchParam = "";
 
	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")  +"]";
	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhOccuClssPayCmpttnStd,"occuClssPayCmpttnStd")+"]"; 
	serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]"; 
	String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//	serarchParam += "["+ MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")+"]";
	serarchParam += "["+ strTypOccuCd +"]";
	//serarchParam += "["+MSFSharedUtils.allowNulls(srhPyspGrdeCd.getValue())+"]";   //호봉등급
	String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); 
	//serarchParam += "["+ MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd")+"]";	
	serarchParam += "["+ strDtilOccuInttnCd +"]";	
		  
		String strParam = "/rp " + serarchParam ;
		
		//System.out.println(strParam);
		
		//String strParam = "/rp " + "[" + "20080311" + "]";
		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);

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
			    
			   // formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createPayr5200Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createStandardForm();    //기본정보필드  
			    vp.setSize("1010px", "700px");
				  
			    /**
		          * Create the relations 
		          */
				   final RelationDef  relPayr0440ToPayr5200 = new RelationDef(payr0440ToPayr5200Def,false);
				   relPayr0440ToPayr5200.addJoinDef("dpobCd", "dpobCd");
				   relPayr0440ToPayr5200.addJoinDef("payYr", "payYr");
				   relPayr0440ToPayr5200.addJoinDef("typOccuGrdeMppgSeilNum", "typOccuGrdeMppgSeilNum");
	            //   relPayr0440ToPayr5200.addJoinDef("payrItemSeilNum", "payrItemSeilNum");
	               relPayr0440ToPayr5200.addJoinDef("payrMangDeptCd", "payrMangDeptCd");  
				    relPayr0440ToPayr5200.addJoinDef("typOccuCd", "typOccuCd");
				    relPayr0440ToPayr5200.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
				  // relPayr0440ToPayr5200.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
				   relPayr0440ToPayr5200.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
				   
				   relPayr0440ToPayr5200.addJoinDef("pyspLogSvcYrNumCd", "pyspLogSvcYrNumCd");
				   relPayr0440ToPayr5200.addJoinDef("occuClssPayCmpttnStd", "occuClssPayCmpttnStd");
				   relPayr0440ToPayr5200.setLinkedObject(payr0440ToPayr5200GridPanel);
				   payr0440Def.addRelation(relPayr0440ToPayr5200); 
		           
		  

	                   // DETAILS 
	                   final Grid payr0400Grid = payr0440ToPayr5200GridPanel.getMsfGrid().getGrid();
	                   payr0400Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
	                      public void handleEvent(BaseEvent be) {  
	                          if (payr0440ToPayr5200GridPanel.getCurrentlySelectedItem() != null) { 
	                             
	                              setRecord(payr0440ToPayr5200GridPanel.getCurrentlySelectedItem());
	                            
	                              payr0440Def.synchronizeGridDetail(
	                                      payr0440ToPayr5200GridPanel.getCurrentlySelectedItem(),
	                                      payr0440GridPanel );  
	                              
	                              fnFormTextMapping(record);
	                              
	                              //payr0440GridPanel.reload();   
	                           }
	                        
	                        
	                        
	                      }
	                  }); 
	                   
	                   /**
	                      * Create the relations 
	                      */
	                       final RelationDef  relPayr0445ToPayr5200 = new RelationDef(payr0440ToPayr5200Def,false);
	                       relPayr0445ToPayr5200.addJoinDef("dpobCd", "dpobCd");
	                       relPayr0445ToPayr5200.addJoinDef("payYr", "payYr");
	                       relPayr0445ToPayr5200.addJoinDef("typOccuGrdeMppgSeilNum", "typOccuGrdeMppgSeilNum");
	                    //   relPayr0445ToPayr5200.addJoinDef("payrItemSeilNum", "payrItemSeilNum");
	                       relPayr0445ToPayr5200.addJoinDef("payrMangDeptCd", "payrMangDeptCd");  
	                       relPayr0445ToPayr5200.addJoinDef("typOccuCd", "typOccuCd");
	                       relPayr0445ToPayr5200.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd");
	                      // relPayr0445ToPayr5200.addJoinDef("pyspGrdeCd", "pyspGrdeCd");
	                       relPayr0445ToPayr5200.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd"); 
	                       relPayr0445ToPayr5200.addJoinDef("pyspLogSvcYrNumCd", "pyspLogSvcYrNumCd");
	                       relPayr0445ToPayr5200.addJoinDef("occuClssPayCmpttnStd", "occuClssPayCmpttnStd");
	                       relPayr0445ToPayr5200.setLinkedObject(payr0440ToPayr5200GridPanel);
	                       payr0445Def.addRelation(relPayr0445ToPayr5200); 
	                       
	                       
	                   // DETAILS 
	                   final Grid payr0445Grid = payr0440ToPayr5200GridPanel.getMsfGrid().getGrid();
	                   payr0445Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
	                      public void handleEvent(BaseEvent be) {  
	                          if (payr0440ToPayr5200GridPanel.getCurrentlySelectedItem() != null) { 
	                             
	                              setRecord(payr0440ToPayr5200GridPanel.getCurrentlySelectedItem());
	                            
	                              payr0445Def.synchronizeGridDetail(
	                                      payr0440ToPayr5200GridPanel.getCurrentlySelectedItem(),
	                                      payr0445GridPanel );  
	                              
	                              //payr0445GridPanel.reload(); 
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
	  public Payr5200() {
		   
		   
			setSize("1010px", "700px");  
	  } 
	
	  public Payr5200(String txtForm) {
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
	  private void createPayr5200Form() {
		  
		plFrmPayr5200 = new FormPanel();
		plFrmPayr5200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr5200());
	//	plFrmPayr5200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 단가관리-공무직");
		plFrmPayr5200.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr5200.setBodyStyleName("pad-text");
		plFrmPayr5200.setPadding(2);
		plFrmPayr5200.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr5200(),"PAYR5100");
				}
			});
		plFrmPayr5200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr5200.getHeader().addTool(btnlogView); 
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
		  plFrmPayr5200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) { 
	            
	             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
	                    
	            //        if (f instanceof MSFMultiComboBox<?>) {
	                        
//	                      if ("srhDeptCd".equals(f.getName())) {
//	                          
//	                      } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                          
//	                      }
	                        
	              //      } else {
	            	 if (mutilCombo) {
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
			
		  topPayr5200Bar = new ButtonBar();    
		   layoutContainer_2.add(topPayr5200Bar);
		   topPayr5200Bar.setAlignment(HorizontalAlignment.RIGHT);
		    
	  	
		   btnPayr5200Init = new Button("초기화");  
		   btnPayr5200Init.setIcon(MSFMainApp.ICONS.new16());
		  	topPayr5200Bar.add(btnPayr5200Init);
		  	btnPayr5200Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //초기화 
		    			formInit();
		    		}
		      });
//		  	topBtn = new Button("신규");  
//		  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//		  	buttonBar.add(topBtn);
		  	
		  	btnPayr5200Del = new Button("전체삭제");  
		  	btnPayr5200Del.setIcon(MSFMainApp.ICONS.delete16());
		  	topPayr5200Bar.add(btnPayr5200Del); 
		  	btnPayr5200Del.addSelectionListener(selectionListener);
		  	
		  	
		  	btnPayr5200Sreach = new Button("조회"); 
		  	btnPayr5200Sreach.setIcon(MSFMainApp.ICONS.search16());
		  	topPayr5200Bar.add(btnPayr5200Sreach);
		  	btnPayr5200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//조회버튼 클릭시 처리 
	    		    reload();  
	    		}
	    	});
		  	
		  	btnPayr5200Print = new Button("인쇄"); 
		  	btnPayr5200Print.setIcon(MSFMainApp.ICONS.print16()); 
		  	topPayr5200Bar.add(btnPayr5200Print);  
		  	btnPayr5200Print.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//Print버튼 클릭시 처리 
	    			Payr5200Print("PAYRT5200") ;
	    		}
	    	});
			
		  	btnPayr5200Excel = new Button("엑셀"); 
		  	btnPayr5200Excel.setIcon(MSFMainApp.ICONS.excel16()); 
		  	topPayr5200Bar.add(btnPayr5200Excel);
		  	btnPayr5200Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			exportExcel(); 
	    		}
	    	});
		  	
	    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_2.setBorders(false); 
	    layoutContainer.setBorders(false);
	  	
	    plFrmPayr5200.add(layoutContainer);    
	  	  
	  	
		//파일업로드 처리
		plFrmPayr5200.setAction("bizform");
		plFrmPayr5200.setEncoding(Encoding.MULTIPART);
		plFrmPayr5200.setMethod(Method.POST);
		
	
		vp.add(plFrmPayr5200);
		plFrmPayr5200.setSize("990px", "680px");
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
 
	
	//srhPyspGrdeCd = new HiddenField<String>();
	
    sysComBass0150Dto = new PrgmComBass0150DTO(); 
    sysComBass0350Dto = new PrgmComBass0350DTO(); 
    sysComBass0320Dto = new PrgmComBass0320DTO();
 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
   
/**
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  * 직종 콤보박스 처리  시작
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
  */
// 		  ContentPanel typOccuCdGrid = new ContentPanel();  
// 		  typOccuCdGrid.setVisible(false);
// 		    
// 		    //직종 콤보처리 
// 		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
// 		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
// 			       public void handleEvent(ComponentEvent be) {  
// 			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
// 			          public void handleEvent(StoreEvent<BaseModel> be) {  
// 			        	  
// 			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
// 			          }  
// 			        });  
// 			       
// 			      }  
// 			    });  
// 	  
// 		 typOccuCdGrid.add(typOccuCdGridPanel); 
// 		plFrmPayr5200.add(typOccuCdGrid);
 	      
  lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
  lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
      public void handleEvent(StoreEvent<BaseModel> be) {  
       
        mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
        srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
         
      }
  });  
	 
  lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
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
			        	 
//			        	   Date today = new Date(); 
//			        	    // A custom date format
//			        	   DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//			        	 
//			      	      BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
			      	     
			          }  
			        });  
			       
			      }  
			    });  
	  
		payYrGrid.add(payYrGridPanel); 
		plFrmPayr5200.add(payYrGrid); 

		
		 /**
		* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		* 적용일자 콤보박스 처리  시작
		* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		*/
				   ContentPanel occuClssPayCmpttnStdGrid = new ContentPanel();  
				   occuClssPayCmpttnStdGrid.setVisible(false);
				    
				   //년도 콤보처리 
				   occuClssPayCmpttnStdGridPanel = new MSFGridPanel(lkOccuClssPayCmpttnStd, false, false, false, true); 
				   occuClssPayCmpttnStdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
					       public void handleEvent(ComponentEvent be) {  
					           occuClssPayCmpttnStdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
					          public void handleEvent(StoreEvent<BaseModel> be) {  
					        	  lsOccuClssPayCmpttnStd.add(occuClssPayCmpttnStdGridPanel.getMsfGrid().getStore().getModels()); 
					        	   
					          }   
					        });  
					       
					      }  
					    });  
			  
				   occuClssPayCmpttnStdGrid.add(occuClssPayCmpttnStdGridPanel); 
				   plFrmPayr5200.add(occuClssPayCmpttnStdGrid); 
 
	  
	    plFrmPayr5200.setLayout(new FlowLayout());
	    
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
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    layoutContainer_14.setLayout(frmlytSch);
	    
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
		                	checkPayr5200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
              	 }
            }
        });    
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
  	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
  	    	} 
  	    });
	    layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
	   
	    layoutContainer_14.setBorders(false);
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	    lcSchCol.add(layoutContainer_10);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(50); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_10.setLayout(frmlytSch);
	    
//	    srhTypOccuCd =  new ComboBox<BaseModel>(); 
//	    srhTypOccuCd.setName("srhTypOccuCd");
//	    srhTypOccuCd.setForceSelection(true);
//	    srhTypOccuCd.setMinChars(1);
//	    srhTypOccuCd.setDisplayField("typOccuNm");
//	    srhTypOccuCd.setValueField("typOccuCd");
//	    srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//	    srhTypOccuCd.setEmptyText("--직종선택--");
//	    srhTypOccuCd.setSelectOnFocus(true); 
//	    srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
//	    srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
//	    srhTypOccuCd.setStore(lsTypOccuCd);
//	    srhTypOccuCd.setFieldLabel("직종");
//	    srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//  	    		//직종변경에 따른 직종세 값 가져오기
//  	    		String strTypOccuCd = MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;  
//  	    		 if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//      	    		sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//      	    		sysComBass0350Dto.setPyspGrdeCd((String)srhTypOccuCd.getValue().get("pyspGrdeCd"));
//      	    		lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//      	    		srhDtilOccuInttnCd.reset(); 
//      	    		srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//  	    		 }
//  	    		
//  	    	} 
//  	    });
//	    lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
//            	//2015.11.30 추가 
//	    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
//         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
//	                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//	                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//	                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//	                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//	                      //         mdSelect = tpMdSelect;
//	                         //  } 
//	                     //  }  
//	                   
//	                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
//	                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
//	                   // }  
//	                    
//                }  
//            	  EventType type = be.getType();
//		    	   if (type == Store.Add) { 
//               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		                	//checkPayr5200Auth("srhTypOccuCd", lsTypOccuCd); 
//               	 }  
//            }
//        }); 
	    srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setWidth(100);
        srhTypOccuCd.setFieldLabel("직종");
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            	
    	       EventType type = be.getType();
	    	   if (type == Store.Add) { 
	    		   //2015.11.30 추가 
	    		  // if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
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
	                    
                   } // }
               // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
            		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                	//checkDlgn0250Auth("srhTypOccuCd", lsTypOccuCd); 
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
	     
	 
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
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
	    srhPayYr.setEmptyText("--년도선택--");
	    srhPayYr.setSelectOnFocus(true); 
	    srhPayYr.setReadOnly(false);
	    srhPayYr.setEnabled(true); 
	    srhPayYr.setStore(lsPayYrStore); 
	    srhPayYr.setFieldLabel("급여년도"); 
	    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr5200Auth("srhPayYr", lsPayYrStore); 
              	 }
            }
        });    
	    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
  	    	
  	    		IColumnFilter filters = null;
  	    		occuClssPayCmpttnStdGridPanel.getTableDef().setTableColumnFilters(filters);
  				
  	    		occuClssPayCmpttnStdGridPanel.getTableDef().addColumnFilter("payYr", srhPayYr.getRawValue(), SimpleColumnFilter.OPERATOR_LIKE); 
  			  
  	    		occuClssPayCmpttnStdGridPanel.reload();
  	    	} 
  	    });
	    
	    layoutContainer_8.add(srhPayYr, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	    layoutContainer_8.setBorders(false);
	    
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15)); 
	    

	      LayoutContainer layoutContainer = new LayoutContainer();
	      frmlytSch = new FormLayout();  
	      frmlytSch.setLabelWidth(60); 
	      frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	      layoutContainer.setLayout(frmlytSch);
	      
	      srhOccuClssPayCmpttnStd = new ComboBox<BaseModel>(); 
	      srhOccuClssPayCmpttnStd.setName("srhOccuClssPayCmpttnStd");
	      srhOccuClssPayCmpttnStd.setForceSelection(true);
	      srhOccuClssPayCmpttnStd.setMinChars(1);
	      srhOccuClssPayCmpttnStd.setDisplayField("occuClssPayCmpttnStdDisp");
	      srhOccuClssPayCmpttnStd.setValueField("occuClssPayCmpttnStdDt");
	      srhOccuClssPayCmpttnStd.setTriggerAction(TriggerAction.ALL);
	      srhOccuClssPayCmpttnStd.setEmptyText("--적용일자선택--");
	      srhOccuClssPayCmpttnStd.setSelectOnFocus(true); 
	      srhOccuClssPayCmpttnStd.setReadOnly(false);
	      srhOccuClssPayCmpttnStd.setEnabled(true); 
	      srhOccuClssPayCmpttnStd.setStore(lsOccuClssPayCmpttnStd); 
	      srhOccuClssPayCmpttnStd.setFieldLabel("적용일자");   
		    
	      layoutContainer.add(srhOccuClssPayCmpttnStd, new FormData("100%"));
	      layoutContainer.setBorders(false);
	      
	       LayoutContainer layoutContainer_15 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_15.setLayout(frmlytSch);
		    
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
//		    srhDtilOccuInttnCd.setFieldLabel("직종세");  
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
		    
		    layoutContainer_15.add(srhDtilOccuInttnCd, new FormData("100%"));  
		    layoutContainer_15.setBorders(false);
		    
	      lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));
	      lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	      lcSchCol.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
	      lcSchCol.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	      
		
	    plFrmPayr5200.add(fieldSet); 
	//vp.add(panel);   
 }  
private void  displayDtilOccuInttnCd() {
	  
	   
       //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
           
           sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
         //  List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
         //  String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
         //  sysComBass0350Dto.setDeptCd(strDeptCd);
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
        // pyspGrdeCd =  new HiddenField<String>();   /** column 호봉등급코드 : pyspGrdeCd */
         typOccuCd = new HiddenField<String>();   /** column 직종코드 : typOccuCd */
         pyspLogSvcYrNumCd = new HiddenField<String>();    /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
       //  pyspGrdeCd = new HiddenField<String>();    /** column 호봉등급코드 : pyspGrdeCd */
         dtilOccuInttnCd = new HiddenField<String>();    /** column 직종세코드 : dtilOccuInttnCd */
    
     
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_11 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize(330,550);
		 
		
		layoutContainer_11.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("근속년수");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		layoutContainer_11.setBorders(false);
		
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setSize(625, 80);
		

		layoutContainer_21.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("단가표기본");
		fldstNewFieldset_1.setCollapsible(false);
		
		fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(625, 465);
		layoutContainer_21.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("단가표내역");
		fldstNewFieldset_2.setCollapsible(false);
		
		fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
		
		fldstNewFieldset_2.add(occupationalRBottom02(),new FormData("100%")); 
		
		layoutContainer.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		layoutContainer_21.setBorders(false);
		 
		    
		plFrmPayr5200.add(layoutContainer);
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
 
 /**
  * 단가표기본 
  * @return
  */
 private LayoutContainer occupationalRTop() {
	  
	   LayoutContainer lcTabFormLayer = new LayoutContainer();
	 
	   ContentPanel cp01 = new ContentPanel();   
  	   cp01.setBodyBorder(false); 
  	   cp01.setHeaderVisible(false);   
  	   cp01.setLayout(new FitLayout());      
  	   cp01.setSize(600, 60);  
  	   
  	   LayoutContainer lytCtr01 = new LayoutContainer();
  	   lytCtr01.setLayout(new FlowLayout());
  	   
  	   LayoutContainer layoutContainer_12 = new LayoutContainer();
  	   layoutContainer_12.setLayout(new ColumnLayout());
  	   
  	   LayoutContainer layoutContainer_13 = new LayoutContainer();
  	   FormLayout frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(70); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
  	   layoutContainer_13.setLayout(frmlytStd);
  	
      
  	   payYr = new TextField<String>();
  	   payYr.setReadOnly(true);
  	   layoutContainer_13.add(payYr, new FormData("100%"));
  	   payYr.setFieldLabel("급여년도");
  	   layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
  	   layoutContainer_13.setBorders(false);
  	   
  	   LayoutContainer layoutContainer_14 = new LayoutContainer();
  	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(60); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
  	   layoutContainer_14.setLayout(frmlytStd);
  	   
        
  	   occuClssPayCmpttnStd = new DateField();
  	   occuClssPayCmpttnStd.setReadOnly(true);
  	   occuClssPayCmpttnStd.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
  	   layoutContainer_14.add(occuClssPayCmpttnStd, new FormData("100%"));
  	   occuClssPayCmpttnStd.setFieldLabel("적용일자");
  	   layoutContainer_12.add(layoutContainer_14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
  	   
  	   LayoutContainer layoutContainer = new LayoutContainer();
  	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(50); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
  	   layoutContainer.setLayout(frmlytStd);
  	   
  	   typOccuNm = new TextField<String>();
  	   typOccuNm.setReadOnly(true);
  	   layoutContainer.add(typOccuNm, new FormData("100%"));
  	   typOccuNm.setFieldLabel("직 종");
  	   layoutContainer_12.add(layoutContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
  	   layoutContainer.setBorders(false);
  	   
  	   
  	   LayoutContainer layoutContainer_1 = new LayoutContainer();
 	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(50); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_1.setLayout(frmlytStd);
 	   
 	   dtilOccuClsDivNm = new TextField<String>();
 	   dtilOccuClsDivNm.setReadOnly(true);
 	   layoutContainer_1.add(dtilOccuClsDivNm, new FormData("100%"));
 	   dtilOccuClsDivNm.setFieldLabel("직종세");
 	   layoutContainer_12.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
  	     
  	   lytCtr01.add(layoutContainer_12);
  	   layoutContainer_12.setBorders(false);
  	   
  	   
  	   LayoutContainer layoutContainer_2 = new LayoutContainer();
  	   layoutContainer_2.setLayout(new ColumnLayout());
  	   
  	   LayoutContainer layoutContainer_3 = new LayoutContainer();
  	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(70); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
  	   layoutContainer_3.setLayout(frmlytStd); 

       
       /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
  	   pyspLogSvcYrNumNm = new TextField<String>();
  	   pyspLogSvcYrNumNm.setReadOnly(true);
  	   layoutContainer_3.add(pyspLogSvcYrNumNm, new FormData("100%"));
  	   pyspLogSvcYrNumNm.setFieldLabel("근속년수");
  	   layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
  	   layoutContainer_3.setBorders(false);
  	   
  	   LayoutContainer layoutContainer_4 = new LayoutContainer();
  	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(50); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
  	   layoutContainer_4.setLayout(frmlytStd);
  	   layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
  	   layoutContainer_4.setBorders(false);
  	   
  	   LayoutContainer layoutContainer_15 = new LayoutContainer();
  	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(60); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
  	   layoutContainer_15.setLayout(frmlytStd);
  	   layoutContainer_2.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
  	   layoutContainer_15.setBorders(false);
  	   
  	   LayoutContainer layoutContainer_16 = new LayoutContainer();
  	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(50); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
  	   layoutContainer_16.setLayout(frmlytStd);
  	   layoutContainer_2.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
  	   layoutContainer_16.setBorders(false);
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
 

private LayoutContainer occupationalLeft() {
   
   LayoutContainer lcTabFormLayer = new LayoutContainer();
 
       ContentPanel cp01 = new ContentPanel();   
       cp01.setBodyBorder(false); 
       cp01.setHeaderVisible(false);   
       cp01.setLayout(new FitLayout());      
       cp01.setSize(308, 495);  
       
        //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
       payr0440ToPayr5200GridPanel = new MSFGridPanel(payr0440ToPayr5200Def, false, false, false, false);
       payr0440ToPayr5200GridPanel.setHeaderVisible(false);  
       payr0440ToPayr5200GridPanel.setBodyBorder(true);
       payr0440ToPayr5200GridPanel.setBorders(true);
       payr0440ToPayr5200GridPanel.setSize(308, 495); 
     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
       
        cp01.add(payr0440ToPayr5200GridPanel);
       // grid.setWidth("480px"); 
      
    lcTabFormLayer.add(cp01); 
     
    return lcTabFormLayer;  
   
} 

 private LayoutContainer occupationalRBottom() {
	   

     LayoutContainer lcTabFormLayer = new LayoutContainer();


//     List<Stock> stocks = TestData.getStocks();   
//	    
//	    RowNumberer r = new RowNumberer();   
//
//	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
//	    configs.add(r);   
//
//	    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
//	    // selection model supports the SIMPLE selection mode   
//	    // sm.setSelectionMode(SelectionMode.SIMPLE);   
//	  
//	    configs.add(sm.getColumn());   
//	  
//	    
//	    ColumnConfig column = new ColumnConfig("change", "사용", 40);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column); 
//	    
//	    column = new ColumnConfig();   
//	    column.setId("name");   
//	    column.setHeaderText("지급항목");  
//	    column.setAlignment(HorizontalAlignment.CENTER); 
//	    column.setWidth(120);   
//	    configs.add(column);   
//	  
//	    column = new ColumnConfig();   
//	    column.setId("last");   
//	    column.setHeaderText("단가금액");   
//	    column.setAlignment(HorizontalAlignment.CENTER);   
//	    column.setWidth(100);   
//	    column.setRenderer(gridNumber);   
//	    configs.add(column);   
//	  
//	    
//	    column = new ColumnConfig("change", "급여구분", 90);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);   
//	    
//	    column = new ColumnConfig("change", "통상임금", 60);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column);
//	    
//	    column = new ColumnConfig("change", "계산기준", 80);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column); 
//	    
//	    column = new ColumnConfig("change", "과세구분", 80);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column); 
//	     
//	    
//	    column = new ColumnConfig("change", "비과세금액", 80);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column); 
//	    
//	    column = new ColumnConfig("change", "비과세율", 80);   
//	    column.setAlignment(HorizontalAlignment.CENTER);    
//	    column.setRenderer(change);   
//	    configs.add(column); 
//	    
//	  
//	      
//	    ListStore<Stock> store = new ListStore<Stock>();   
//	    store.add(stocks);   
//	  
//	    ColumnModel cm = new ColumnModel(configs);    
	    
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   //cp01.setSize(600, 395);  
	   cp01.setSize(610, 290);  
	  
//	    Grid<Stock> grid = new Grid<Stock>(store, cm);   
//	    grid.setSelectionModel(sm);   
//	    grid.setBorders(true);   
//	    grid.setColumnReordering(true);   
//	   // grid.getAriaSupport().setLabelledBy(cp01.getHeader().getId() + "-label");   
//	    grid.addPlugin(sm);    
//		
//	    cp01.add(grid);
	   
	   //msfCustomForm.setHeaderVisible(false);
	   //Instantiate the GridPanel
	   payr0440GridPanel = new MSFGridPanel(payr0440Def, false, false, false, false,false);
	   payr0440GridPanel.setHeaderVisible(false);  
	   payr0440GridPanel.setBodyBorder(true);
	   payr0440GridPanel.setBorders(true); 
	   payr0440GridPanel.setSize(610, 290);  
	//   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

	   cp01.add(payr0440GridPanel); 
	   cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
	  	      @Override  
	  	      public void componentSelected(ButtonEvent ce) {   
	  	          
	  	      actionDatabase = ActionDatabase.UPDATE; 
	  	      
              if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
             	 
            	  MessageBox.alert("오류", "마스터 관리자만 수정이 가능합니다.</br>관리자에게 문의해주세요.", null);
            	  return; 
                
              }
	  	        
              if (payr0440GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
                  
                  MessageBox.alert("수정", "수정할 데이타가 없습니다.", null);
                  return;
              }
              
                setListRecord(payr0440GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
                detailFormSave();
	  	      }   
	  	    }));   
	    lcTabFormLayer.add(cp01); 
	      
	    return lcTabFormLayer;
 } 

  
 private LayoutContainer occupationalRBottom02() {
     
     LayoutContainer lcTabFormLayer = new LayoutContainer();
   
         ContentPanel cp01 = new ContentPanel();   
         cp01.setBodyBorder(false); 
         cp01.setHeaderVisible(false);   
         cp01.setLayout(new FitLayout());      
         cp01.setSize(610, 150);  
          
          //msfCustomForm.setHeaderVisible(false);
          //Instantiate the GridPanel
         payr0445GridPanel = new MSFGridPanel(payr0445Def, false, false, false, false,false);
         payr0445GridPanel.setHeaderVisible(false);  
         payr0445GridPanel.setBodyBorder(true);
         payr0445GridPanel.setBorders(true); 
         payr0445GridPanel.getBottomComponent().setVisible(false);
         payr0445GridPanel.setSize(610, 150);
         payr0445GridPanel.setStyleAttribute("marginTop", "10px");
       //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
         
          cp01.add(payr0445GridPanel);
          cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
              @Override  
              public void componentSelected(ButtonEvent ce) {   
                  
              actionDatabase = ActionDatabase.UPDATE; 
              
              if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
              	 
            	  MessageBox.alert("오류", "마스터 관리자만 수정이 가능합니다.</br>관리자에게 문의해주세요.", null);
            	  return; 
                
              }
                
              if (payr0445GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
                  
                  MessageBox.alert("수정", "수정할 데이타가 없습니다.", null);
                  return;
              }
              
                setListRecord(payr0445GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
                detailSubFormSave();
              }   
            }));   
        
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
	        payr0440GridPanel.getMsfGrid().clearData();
            payr0445GridPanel.getMsfGrid().clearData();
        
			IColumnFilter filters = null;
			payr0440ToPayr5200GridPanel.getTableDef().setTableColumnFilters(filters);
			  
			payr0440ToPayr5200GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0440ToPayr5200GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			payr0440ToPayr5200GridPanel.getTableDef().addColumnFilter("occuClssPayCmpttnStd", MSFSharedUtils.getSelectedComboValue(srhOccuClssPayCmpttnStd,"occuClssPayCmpttnStd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0440ToPayr5200GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0440ToPayr5200GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.allowNulls(srhPyspGrdeCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			 String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
			 payr0440ToPayr5200GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//	            String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//	            dlgn0250GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
	         String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	         payr0440ToPayr5200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	         
			 payr0440ToPayr5200GridPanel.reload();
		}
	
	//엑셀저장함수 
	private void exportExcel() {
		// TODO Auto-generated method stub
		payr0440GridPanel.callExportServlet(""); 
	}
	
	  private void fnFormTextMapping(BaseModel bmRecord) {
		    
		      
		  dpobCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("dpobCd")));   /** column 사업장코드 : dpobCd */  
		  payYr.setValue(MSFSharedUtils.allowNulls(bmRecord.get("payYr")));   /** column 급여년도 : payYr */     
		  typOccuCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("typOccuCd")));  /** column 직종코드 : typOccuCd */                           
		  typOccuNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("typOccuNm")));   /** column 직종코드 : typOccuCd */                          
		  pyspLogSvcYrNumCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("pyspLogSvcYrNumCd")));   /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */   
		  pyspLogSvcYrNumNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("pyspLogSvcYrNumNm"))); /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */     
		 // pyspGrdeCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("pyspGrdeCd")));   /** column 호봉등급코드 : pyspGrdeCd */    
	 
		  
		  occuClssPayCmpttnStd.setValue((Date)bmRecord.get("occuClssPayCmpttnStd"));   /** column 단가표적용일자 : occuClssPayCmpttnStd */          
		  dtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(bmRecord.get("dtilOccuInttnCd")));   /** column 직종세코드 : dtilOccuInttnCd */          
		  dtilOccuClsDivNm.setValue(MSFSharedUtils.allowNulls(bmRecord.get("dtilOccuClsDivNm")));  /** column 직종세코드 : dtilOccuInttnCd */           
		                              
		 
	 };
	 
	  
      //폼초기화 검색조건포함 
	   private void formInit() {
		   
		     BaseModel bmBlank = new BaseModel();   
			  
		    srhPayYr.setValue(lsPayYrStore.getAt(0));
		    srhOccuClssPayCmpttnStd.setValue(lsOccuClssPayCmpttnStd.getAt(0)); //단가표적용일자 
		  //  srhPayrMangDeptCd.setValue(bmBlank); //단위기관
		      /** column 직종코드 : typOccuCd */
		 //   srhTypOccuCd.setValue(bmBlank); 
		 //   srhPyspGrdeCd.setValue("");   /** column 호봉등급코드 : pyspGrdeCd */
		      
		      /** column 직종세코드 : dtilOccuInttnCd */  
		 //   srhDtilOccuInttnCd.setValue(bmBlank); 
		   
		      dpobCd.setValue("");   /** column 사업장코드 : dpobCd */  
			  payYr.setValue("");   /** column 급여년도 : payYr */     
			  typOccuCd.setValue("");  /** column 직종코드 : typOccuCd */                           
			  typOccuNm.setValue("");   /** column 직종코드 : typOccuCd */                          
			  pyspLogSvcYrNumCd.setValue("");   /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */   
			  pyspLogSvcYrNumNm.setValue(""); /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */     
			 // pyspGrdeCd.setValue("");   /** column 호봉등급코드 : pyspGrdeCd */                    
			  occuClssPayCmpttnStd.reset();   /** column 단가표적용일자 : occuClssPayCmpttnStd */          
			  dtilOccuInttnCd.setValue("");   /** column 직종세코드 : dtilOccuInttnCd */          
			  dtilOccuClsDivNm.setValue("");  /** column 직종세: dtilOccuInttnCd */ 
	      
			  payr0440ToPayr5200GridPanel.getMsfGrid().clearData();
			  payr0440GridPanel.getMsfGrid().clearData();
			  payr0445GridPanel.getMsfGrid().clearData();
	   }
	  
	   public void setRecord(BaseModel record) {
	       this.record = record;
	       
	   }
	   

       public void setListRecord(Iterator<Record> records) {
           this.records = records;
       }
      

	   private Payr5200 getThis(){
	       return this;
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
