package com.app.exterms.yearendtax.client.form.yeta2015;

import java.util.ArrayList;
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
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta1000DTO;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta2000DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta2000Def;
import com.app.exterms.yearendtax.client.languages.YetaConstants;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0100Service;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0100ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
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
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow {
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Yeta0100   extends MSFPanel {

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    private YetaConstants lblYetaConst = YetaConstants.INSTANCE; 
    
    private VerticalPanel vp;
    private FormPanel plFrmYeta0100; 
    private String txtForm = "";
    private XTemplate detailTp;
 
    private Yeta2000Def yeta2000def = new Yeta2000Def("YETA0100");
    private MSFGridPanel yeta2000GridPanel;
  
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
     
	//직종콤보
//		private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		private MSFGridPanel typOccuCdGridPanel;

	  
	   /**
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    * 상태처리 전역변수
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    */
   private ActionDatabase actionDatabase;
   
   private boolean statCheck = false;
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
   private ButtonBar topYeta0100Bar;
   private Button btnYeta0100Init; 
   private Button btnYeta0100Save;
   private Button btnYeta0100Del;
   private Button btnYeta0100Sreach;
   private Button btnYeta0100Print;
   private Button btnYeta0100Excel;
   /**
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    * 검색변수 선언 
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    */

   
     /**
      * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      * 검색변수 선언 
      * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      **/
		// -------------- 검색조건 생성 폼 시작 --------------
    	private MSFComboBox<BaseModel> srhClutYr;				// 정산년
    	//private ComboBox<BaseModel> srhClutMnth;				// 정산월
    	private ComboBox<BaseModel> srhCalcSevePayPsnDivCd;     // 정산구분
    	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
    	private TextField<String> srhHanNm;        				// 성명
    	private TextField<String> srhResnRegnNum;   			// 주민번호 
    	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
    	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드
    	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
    	private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드	   
    	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
		private ComboBox<BaseModel> srhBusinCd; 				// 사업
		private HiddenField<String> srhSystemkey;   			// 시스템키 
    	      
    	      
		// -------------- 연말정산대상자-생성 폼 시작 --------------
		private MSFComboBox<BaseModel> crePayrMangDeptCd;		// 단위기관
		MSFComboBox<BaseModel> creCalcSevePayPsnDivCd; 			// 정산구분
    	private ComboBox<BaseModel> creEmymtDivCd;				// 고용구분
    	private ComboBox<BaseModel> creRepbtyBusinDivCd; 		// 호봉제구분코드
    	private MSFComboBox<BaseModel> creBusinCd;				// 사업
    	private MSFComboBox<BaseModel> crePayCd;				// 급여구분
    	private MSFComboBox<BaseModel> creYear;        			// 년도
    	private MSFMultiComboBox<ModelData> creDeptCd; 			// 부서
    	private ComboBox<BaseModel> creDeptGpCd; 				// 부서직종그룹코드	
    	private MSFMultiComboBox<ModelData> creTypOccuCd; 		// 직종
    	private MSFMultiComboBox<ModelData> creDtilOccuInttnCd; // 직종세
    	private List<ModelData> mDtalistcrDeptCd;
    	private List<ModelData> mDtalistcrTypOccuCd;
    	private List<ModelData> mDtalistcrDtilOccuInttnCd;
	// private FileUploadField psnl0290flUp; //파일업로드처리 부분
	// private Boolean picBoolFile;
    	      
    	      
		/** column 지급공제구분코드 : pymtDducDivCd */
		private ComboBox<BaseModel> srhPymtDducDivCd;
		private List<ModelData> mDtalistHdofcCodtnCd;
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;
	
		private boolean mutilCombo = false;
		
	
		private HiddenField<String> systemkey;	/** column SYSTEMKEY : systemkey */
		private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
		//private HiddenField<String> clutYrMnth;	/** column 정산년월 : clutYrMnth */
		//private HiddenField<String> pyspGrdeCd;	/** column 호봉등급코드 : pyspGrdeCd */
		
		private BaseModel ppRecord; // 팝업에 넘길 레코드 값
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	 
    
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	  private Yeta0100ServiceAsync yeta0100Service = Yeta0100Service.Util.getInstance();      
    // -------------- stroe [검색부]선언 시작 --------------
      private ListStore<BaseModel> lsClutYrStore = new ListStore<BaseModel>();			// 정산년도
      private ListStore<BaseModel> lsCrCalcSevePayPsnDivCd = new ListStore<BaseModel>();// 정산구분
      private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>(); 		// 단위기관
      private ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>(); 			// 고용구분
      private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();		// 호봉제구분코드 
      private ListStore<BaseModel> lsDeptCd = new ListStore<BaseModel>(); 				// 부서콤보
      private ListStore<BaseModel> lsBusinCd = new ListStore<BaseModel>(); 				// 사업콤보
      private ListStore<BaseModel> lsDeptGpCd = new ListStore<BaseModel>();				// 부서직종그룹코드  
      private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>(); 			// 직종
      private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>(); 		// 직종세
      private ListStore<BaseModel> lsCalcSevePayPsnDivCd = new ListStore<BaseModel>(); 	// 정산구분
      private ListStore<BaseModel> lsPymtDducDivCd = new ListStore<BaseModel>(); 		// 지급공제구분코드

      // -------------- stroe [생성부]선언 시작 --------------
      private ListStore<BaseModel> lscrPayYr			= new ListStore<BaseModel>();	// 년도 
      private ListStore<BaseModel> lscrPayrMangDeptCd 	= new ListStore<BaseModel>();	// 단위기관 
	  private ListStore<BaseModel> lscrEmymtDivCd 		= new ListStore<BaseModel>();	// 고용구분 
	  private ListStore<BaseModel> lscreRepbtyBusinDivCd= new ListStore<BaseModel>();	// 호봉제구분코드 
	  private ListStore<BaseModel> lscrDeptCd  			= new ListStore<BaseModel>();	// 부서콤보
	  private ListStore<BaseModel> lscreDeptGpCd 		= new ListStore<BaseModel>();	// 부서직종그룹코드  
	  private ListStore<BaseModel> lscrTypOccuCd 		= new ListStore<BaseModel>();	// 직종 
	  private ListStore<BaseModel> lscrDtilOccuInttnCd 	= new ListStore<BaseModel>();	// 직종세
	  private ListStore<BaseModel> lscrBusinCd  		= new ListStore<BaseModel>();	// 사업콤보   
	  // -------------- store 선언 종료  ---------------  
	    
	    
	  private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
	  private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
	  private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	  private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	  private SysCoCalendarDTO  msfCoCalendarDto;  
	  private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	  private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	    
	  private BaseModel record;
	  private  Iterator<Record> records;

	  /**
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	   **/
	   
	  	/**
	 	 * 권한설정 처리 체크 AuthAction
	 	 */
	  	private void checkYeta0100Auth( String authAction, ListStore<BaseModel>bm) {
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
			 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd
					 						,crePayrMangDeptCd, creEmymtDivCd, creDeptCd, creTypOccuCd, creDtilOccuInttnCd, creBusinCd};
			 gwtAuthorization.formAuthFieldConfig(fldArrField);
			 
			 srhClutYr.setValue(lsClutYrStore.findModel("year","2015"));
          srhCalcSevePayPsnDivCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
          
          creYear.setValue(lscrPayYr.findModel("year","2015"));
          creCalcSevePayPsnDivCd.setValue(lsCrCalcSevePayPsnDivCd.getAt(0));
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  * 권한설정을 위한 콤보처리를 위한 메서드 종료
			  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
			 creDeptCd.getListView().fireEvent(Events.CheckChanged); 
		
		 }
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) { 
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

	 		HashMap<String, Boolean> authMapDef = new HashMap<String,Boolean>(); 
		     
		
			authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
			authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
			authMapDef.put("srhDeptCd",Boolean.FALSE); 
		   // authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
		    
		   
		    authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
		    authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
		    authMapDef.put("creDeptCd",Boolean.FALSE); 
		   // authMapDef.put("creTypOccuCd",Boolean.FALSE);	 		

	 		 gwtExtAuth.setCheckMapDef(authMapDef);
	 		
	 		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//	 			 권한 검색조건처리를 위해 추가된 부분
	 			 mask("[화면로딩] 초기화 진행 중!");
	 		 }	
	 		 tmMask.scheduleRepeating(5000);
	 	 }
	 	/**
	 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 	 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	 	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 	 **/   
	    
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
//	    private SelectionListener<ButtonEvent> selectionListener = 
//		        new SelectionListener<ButtonEvent>() {
//		        public void componentSelected(ButtonEvent ce) { 
//		            if (ce.getButton() == btnRemt0100Save) {
//		                doAction(ActionDatabase.INSERT);
//		            } else if (ce.getButton() == btnRemt0100Save) {
//		                doAction(ActionDatabase.UPDATE);
//		            } else if (ce.getButton() == btnRemt0100Del) {
//		                doAction(ActionDatabase.DELETE);
//		            }
	//
//		        }  
//		    };
//		  
	    private void doAction(ActionDatabase actionDatabase) {
	        switch (actionDatabase) {
	        case INSERT:
	        	//saveStandData(); 
	            break;
	        case UPDATE:
	        	//saveStandData(); 
	            break;
	        case DELETE:
	        	Payr06420_menuDelete();	
	            break;
	        }
	    }
		
	    
		  /**
	     * 데이타를 삭제한다.
	     */
	    private void Payr06420_menuDelete() {
	        
	       
	        MessageBox.confirm("연말정산 대상자 삭제", "선택된 데이타를 삭제 하시겠습니까?<br>(연말정산 대상자를 삭제합니다.)",new Listener<MessageBoxEvent>(){
	            @Override
	             public void handleEvent(MessageBoxEvent be) {
	              //   if("Yes".equals(be.getButtonClicked().getText())){
	            	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	             
	                	  if (!("yongbc".equals(MSFMainApp.get().getUser().getUsrId()) || "admin".equals(MSFMainApp.get().getUser().getUsrId()))) {
	                		  
	                		  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                   "삭제권한이 없습니다.삭제하시려면 관리자[]에게 요청하십시요.", null);
	                		  return;
	                	  }
	                	 
	                	 Iterator<BaseModel> itBm  = yeta2000GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				          
				          List<Record>  lsRec  = new ArrayList<Record>();
				          
				          while(itBm.hasNext()) {
				
				              Record rec  = new Record(itBm.next()); 
				              lsRec.add(rec);
				              
				          } 
				         
				          setListRecord(lsRec.iterator()); 
				           
				   if (MSFSharedUtils.paramNotNull(records)) {           
	                	  List<Yeta2000DTO> listYeta2000Dto = new ArrayList<Yeta2000DTO>();  
       	               
       	               while (records.hasNext()) {
       	             
       	                  Record record = (Record) records.next(); 
       	                  BaseModel bmMapModel = (BaseModel)record.getModel();
       	                     
       	                  Yeta2000DTO yeta2000Dto = new Yeta2000DTO();   
       	                
//       	  				remt2300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//       	  				remt2300Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//       	  				remt2300Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    /** column 정산년월 : clutYrMnth */
//       	  				remt2300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//       	  				remt2300Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
//       	  				remt2300Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
//       	  				remt2300Dto.setPymtSum((Long)bmMapModel.get("pymtSum") );    /** column 지급금액 : pymtSum */


							yeta2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							yeta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
							yeta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
							yeta2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
							yeta2000Dto.setEdacSeilNum((Long)bmMapModel.get("edacSeilNum"));    /** column 연말정산마감일련번호 : edacSeilNum */
							yeta2000Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
							yeta2000Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
							yeta2000Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    /** column 한글성명 : hanNm */
							yeta2000Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
							yeta2000Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
							yeta2000Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
							yeta2000Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
							yeta2000Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
							yeta2000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
							yeta2000Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    /** column 직책코드 : odtyCd */
							yeta2000Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    /** column 호봉코드 : pyspCd */
							yeta2000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
							yeta2000Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
							yeta2000Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
							yeta2000Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
							yeta2000Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
							yeta2000Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
							yeta2000Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
							yeta2000Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    /** column 퇴직일자 : retryDt */
							yeta2000Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));    /** column 연말정산적용년월 : yrtxApptnYrMnth */
							yeta2000Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));    /** column 연말정산처리일자 : yrtxPrcsDt */
//							yeta2000Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
							yeta2000Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    /** column 연말정산처리여부 : yrtxPrcsYn */
							yeta2000Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    /** column 분할납부구분코드 : divdPymtDivCd */
							yeta2000Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    /** column 분할납부횟수 : divdPymt */ 
 
       	                  
       	               listYeta2000Dto.add(yeta2000Dto);
       	                 
       	               }    
	                       
       	            yeta0100Service.Payr06420_Payr400_Delete(listYeta2000Dto ,
	                               new AsyncCallback<Long>() {
	                       public void onFailure(Throwable caught) {
	                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("Payr06420_Payr400_Delete(삭제) : " + caught), null);
	                       }
	                       public void onSuccess(Long result) { 
	                       if (result == 0) {
	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                  "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                       } else {
	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                   "삭제처리가 완료되었습니다.", null);
	                        
	                          reloadYeta0100();
	                          
	                       } 
	                       } 
	                       });
				       } else {
	  	  	              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
	  	  	              return;
	  	  	          } 
	                 }  
	            }
	            
	        });
	        
	        
	    }    
	    
	    
	    private void PayrExec_Yeta_Insert() {
	        
	 
            	 Iterator<BaseModel> itBm  = yeta2000GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		          
		          List<Record>  lsRec  = new ArrayList<Record>();
		          
		          while(itBm.hasNext()) {
		
		              Record rec  = new Record(itBm.next()); 
		              lsRec.add(rec);
		              
		          } 
		         
		          setListRecord(lsRec.iterator()); 
				           
				   if (MSFSharedUtils.paramNotNull(records)) {           
	                	  List<Yeta2000DTO> listYeta2000Dto = new ArrayList<Yeta2000DTO>();  
       	               
       	               while (records.hasNext()) {
       	             
       	                  Record record = (Record) records.next(); 
       	                  BaseModel bmMapModel = (BaseModel)record.getModel();
       	                     
       	                  Yeta2000DTO yeta2000Dto = new Yeta2000DTO();    

							yeta2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							yeta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
							yeta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
							yeta2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
							yeta2000Dto.setEdacSeilNum((Long)bmMapModel.get("edacSeilNum"));    /** column 연말정산마감일련번호 : edacSeilNum */
							yeta2000Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
							yeta2000Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
							yeta2000Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    /** column 한글성명 : hanNm */
							yeta2000Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
							yeta2000Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
							yeta2000Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
							yeta2000Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
							yeta2000Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
							yeta2000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
							yeta2000Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    /** column 직책코드 : odtyCd */
							yeta2000Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    /** column 호봉코드 : pyspCd */
							yeta2000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
							yeta2000Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
							yeta2000Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
							yeta2000Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
							yeta2000Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
							yeta2000Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
							yeta2000Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
							yeta2000Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    /** column 퇴직일자 : retryDt */
							yeta2000Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));    /** column 연말정산적용년월 : yrtxApptnYrMnth */
							yeta2000Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));    /** column 연말정산처리일자 : yrtxPrcsDt */
//							yeta2000Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
							yeta2000Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    /** column 연말정산처리여부 : yrtxPrcsYn */
							yeta2000Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    /** column 분할납부구분코드 : divdPymtDivCd */
							yeta2000Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    /** column 분할납부횟수 : divdPymt */ 
 
       	                  
       	               listYeta2000Dto.add(yeta2000Dto);
       	                 
       	               }    
	                       
       	            yeta0100Service.PayrExec_Yeta_Insert(listYeta2000Dto ,
	                               new AsyncCallback<Long>() {
	                       public void onFailure(Throwable caught) {
	                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("PayrExec_Yeta_Insert(급여자료이관) : " + caught), null);
	                       }
	                       public void onSuccess(Long result) { 
	                       if (result == 0) {
	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                  "급여자료이관이 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                       } else {
	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
	                                   "급여자료이관 처리가 완료되었습니다.", null);
	                        
	                          reloadYeta0100();
	                          
	                       } 
	                       } 
	                       });
				       } else {
	  	  	              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
	  	  	              return;
	  	  	          }  
	        
	    }  
	    
	    

	    /**
	     * 
	     * <pre>
	     * 1. 개요 : 연말정산 대상자 생성  
	     * 2. 처리내용 : 
	     * </pre>
	     * @Method Name : Payr06420_All_Create
	     * @date : Jan 18, 2016
	     * @author : leeheuisung
	     * @history : 
	     *	-----------------------------------------------------------------------
	     *	변경일				작성자						변경내용  
	     *	----------- ------------------- ---------------------------------------
	     *	Jan 18, 2016		leeheuisung				최초 작성 
	     *	-----------------------------------------------------------------------
	     *
	     */
	    private void Payr06420_All_Create() {
	        
	    	
	    					final Tracker tracker = new Tracker();
	    					tracker.setStatus(false);
             
	    	 				Yeta1000DTO yeta1000Dto = new Yeta1000DTO();    
	    	 				yeta1000Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
							yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(creYear,"year"));    /** column 연말정산귀속년도 : edacRvyy */
							yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(creCalcSevePayPsnDivCd,"commCd"));    /** column 정산구분코드 : settGbcd */
							yeta1000Dto.setEdacSeilNum(0L);    /** column 연말정산마감일련번호 : edacSeilNum */
							yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));    /** column 급여관리부서코드 : payrMangDeptCd */
						

							String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
							String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
							String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  

							yeta1000Dto.setDeptCd(strDeptCd);    /** column 부서코드 : deptCd */
							yeta1000Dto.setTypOccuCd(strTypOccuCd);    /** column 직종코드 : typOccuCd */
							//yeta1000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(dtilOccuClsDivCd.getValue()));    /** column 직종세구분코드 : dtilOccuClsDivCd */
							//yeta1000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(pyspGrdeCd.getValue()));    /** column 호봉등급코드 : pyspGrdeCd */
							yeta1000Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);    /** column 직종세통합코드 : dtilOccuInttnCd */
							yeta1000Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"));    /** column 사업코드 : businCd */
							yeta1000Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));    /** column 고용구분코드 : emymtDivCd */
						//	yeta1000Dto.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(pernChrgEmpIdenNum.getValue()));    /** column 생성직원번호 : pernChrgEmpIdenNum */
						   
		
//		             		remt2000Dto.setDpobCd(dpobCd.getValue());    /** column 사업장코드 : dpobCd */
//		             		remt2000Dto.setSystemkey(systemkey.getValue());    /** column SYSTEMKEY : systemkey */
//		             		remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//		             		remt2000Dto.setClutYrMnth(clutYrMnth.getValue());    /** column 정산년월 : clutYrMnth */
//		             	 
//		             		remt2000Dto.setRkfcdDt(RemtUtils.getConvertDateToString(rkfcdDt, "yyyyMMdd") );    /** column 기산일자 : rkfcdDt */
//		             		remt2000Dto.setRetryDt(RemtUtils.getConvertDateToString(retryDt, "yyyyMMdd") );    /** column 퇴직일자 : retryDt */
//		             	 
//		             		remt2000Dto.setEepnMnthIcm2012Bfr((Long)eepnMnthIcm2012Bfr.getValue());    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//		             		remt2000Dto.setEepnMnthIcm2013Aft((Long)eepnMnthIcm2013Aft.getValue());    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//		             		remt2000Dto.setAddMnthIcm2012Bfr((Long)addMnthIcm2012Bfr.getValue());    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//		             		remt2000Dto.setAddMnthIcm2013Aft((Long)addMnthIcm2013Aft.getValue());    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//		             		remt2000Dto.setEepnDayIcmDys((Long)eepnDayIcmDys.getValue());    /** column 제외일수 : eepnDayIcmDys */
//		             		 
//		             		//remt2000Dto.setPayCmpttnBgnnDt(payCmpttnBgnnDt.getValue());    /** column 급여산정시작일자 : payCmpttnBgnnDt */
//		             		//remt2000Dto.setPayCmpttnEndDt(payCmpttnEndDt.getValue());    /** column 급여산정종료일자 : payCmpttnEndDt */
//		             		 
//		             		remt2000Dto.setSevePayAddRate((Double)sevePayAddRate.getValue());    /** column 퇴직금가산율 : sevePayAddRate */ 
//		             		remt2000Dto.setAmcrrClutInsnYn(amcrrClutInsnYn.getValue());    /** column 군경력정산포함여부 : amcrrClutInsnYn */
//		             		  
//		             		remt2000Dto.setSevePayNoteCtnt("");    /** column 퇴직금비고내용 : sevePayNoteCtnt */
//		             		remt2000Dto.setSevePayPymtDt(RemtUtils.getConvertDateToString(sevePayPymtDt, "yyyyMMdd"));    /** column 퇴직금지급일자 : sevePayPymtDt */
		             		 
							 //Progress bar for upload
				              final MessageBox box = MessageBox.wait("연말정산 대상자생성", "연말정산 반영처리 중 입니다...", "대상자 생성 중...");
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
		                     
	    	 				 yeta0100Service.Payr06420_All_Create(yeta1000Dto ,
		                             new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
		                     public void onFailure(Throwable caught) {
		                    	 tracker.setStatus(true);
		                     	 List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		                          ShowMessageBM smBm = new ShowMessageBM();
		                  	      smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
		                  	      smBm.setMenu("Yeta");
		                  	      smBm.setPhase("[연말정산생성]연말정산대상자에러");
		                  	      smBm.setMessage(caught.getLocalizedMessage());
		                  	      smBm.setContent(caught.getMessage());
		                  	      bmResult.add(smBm);  
		                  	      PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
		                  	   
		                          ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
		             			    
		             		      MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
		             		      msFwMessage.show();
		             		      showMessageForm.setMSFFormWindows(msFwMessage);
		             		          
		//                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		//                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100Save(저장(수정)) : " + caught), null);
		                     }
		                     public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
		                    	    tracker.setStatus(true);
		                     	      if (MSFSharedUtils.paramNotNull(result)) {
		                    	           ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
		                          	   BaseModel tmRec = new BaseModel();
		             	    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
		             	    		       msFwMessage.show();
		             	    		       showMessageForm.setMSFFormWindows(msFwMessage);
		                    	        }
		                     	  
		                     	  
		                     	  reloadYeta0100();
	 
		                     } 
		                     });
	                 
	        
	    }
	    
	    
	    private void Payr06420_All_Add_Create() {
	        
	    	
			final Tracker tracker = new Tracker();
			tracker.setStatus(false);

				Yeta1000DTO yeta1000Dto = new Yeta1000DTO();    
				yeta1000Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());
			yeta1000Dto.setEdacRvyy(MSFSharedUtils.getSelectedComboValue(creYear,"year"));    /** column 연말정산귀속년도 : edacRvyy */
			yeta1000Dto.setSettGbcd(MSFSharedUtils.getSelectedComboValue(creCalcSevePayPsnDivCd,"commCd"));    /** column 정산구분코드 : settGbcd */
			yeta1000Dto.setEdacSeilNum(0L);    /** column 연말정산마감일련번호 : edacSeilNum */
			yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));    /** column 급여관리부서코드 : payrMangDeptCd */
		

			String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
			String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  

			yeta1000Dto.setDeptCd(strDeptCd);    /** column 부서코드 : deptCd */
			yeta1000Dto.setTypOccuCd(strTypOccuCd);    /** column 직종코드 : typOccuCd */
			//yeta1000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(dtilOccuClsDivCd.getValue()));    /** column 직종세구분코드 : dtilOccuClsDivCd */
			//yeta1000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(pyspGrdeCd.getValue()));    /** column 호봉등급코드 : pyspGrdeCd */
			yeta1000Dto.setDtilOccuInttnCd(strDtilOccuInttnCd);    /** column 직종세통합코드 : dtilOccuInttnCd */
			yeta1000Dto.setBusinCd(MSFSharedUtils.getSelectedComboValue(creBusinCd,"businCd"));    /** column 사업코드 : businCd */
			yeta1000Dto.setEmymtDivCd(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd"));    /** column 고용구분코드 : emymtDivCd */
		//	yeta1000Dto.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(pernChrgEmpIdenNum.getValue()));    /** column 생성직원번호 : pernChrgEmpIdenNum */
		   

//     		remt2000Dto.setDpobCd(dpobCd.getValue());    /** column 사업장코드 : dpobCd */
//     		remt2000Dto.setSystemkey(systemkey.getValue());    /** column SYSTEMKEY : systemkey */
//     		remt2000Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.getSelectedComboValue(calcSevePayPsnDivCd,"commCd"));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//     		remt2000Dto.setClutYrMnth(clutYrMnth.getValue());    /** column 정산년월 : clutYrMnth */
//     	 
//     		remt2000Dto.setRkfcdDt(RemtUtils.getConvertDateToString(rkfcdDt, "yyyyMMdd") );    /** column 기산일자 : rkfcdDt */
//     		remt2000Dto.setRetryDt(RemtUtils.getConvertDateToString(retryDt, "yyyyMMdd") );    /** column 퇴직일자 : retryDt */
//     	 
//     		remt2000Dto.setEepnMnthIcm2012Bfr((Long)eepnMnthIcm2012Bfr.getValue());    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//     		remt2000Dto.setEepnMnthIcm2013Aft((Long)eepnMnthIcm2013Aft.getValue());    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//     		remt2000Dto.setAddMnthIcm2012Bfr((Long)addMnthIcm2012Bfr.getValue());    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//     		remt2000Dto.setAddMnthIcm2013Aft((Long)addMnthIcm2013Aft.getValue());    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//     		remt2000Dto.setEepnDayIcmDys((Long)eepnDayIcmDys.getValue());    /** column 제외일수 : eepnDayIcmDys */
//     		 
//     		//remt2000Dto.setPayCmpttnBgnnDt(payCmpttnBgnnDt.getValue());    /** column 급여산정시작일자 : payCmpttnBgnnDt */
//     		//remt2000Dto.setPayCmpttnEndDt(payCmpttnEndDt.getValue());    /** column 급여산정종료일자 : payCmpttnEndDt */
//     		 
//     		remt2000Dto.setSevePayAddRate((Double)sevePayAddRate.getValue());    /** column 퇴직금가산율 : sevePayAddRate */ 
//     		remt2000Dto.setAmcrrClutInsnYn(amcrrClutInsnYn.getValue());    /** column 군경력정산포함여부 : amcrrClutInsnYn */
//     		  
//     		remt2000Dto.setSevePayNoteCtnt("");    /** column 퇴직금비고내용 : sevePayNoteCtnt */
//     		remt2000Dto.setSevePayPymtDt(RemtUtils.getConvertDateToString(sevePayPymtDt, "yyyyMMdd"));    /** column 퇴직금지급일자 : sevePayPymtDt */
     		 
			 //Progress bar for upload
              final MessageBox box = MessageBox.wait("연말정산 대상자생성", "연말정산 반영처리 중 입니다...", "대상자 생성 중...");
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
             
				 yeta0100Service.Payr06420_All_Add_Create(yeta1000Dto ,
                     new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
             public void onFailure(Throwable caught) {
            	 tracker.setStatus(true);
             	 List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                  ShowMessageBM smBm = new ShowMessageBM();
          	      smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
          	      smBm.setMenu("Yeta");
          	      smBm.setPhase("[연말정산생성]연말정산 추가대상자 생성에러");
          	      smBm.setMessage(caught.getLocalizedMessage());
          	      smBm.setContent(caught.getMessage());
          	      bmResult.add(smBm);  
          	      PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
          	   
                  ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
     			    
     		      MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
     		      msFwMessage.show();
     		      showMessageForm.setMSFFormWindows(msFwMessage);
     		          
//                     MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateRemt0100Save(저장(수정)) : " + caught), null);
             }
             public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
            	    tracker.setStatus(true);
             	      if (MSFSharedUtils.paramNotNull(result)) {
            	           ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                  	   BaseModel tmRec = new BaseModel();
     	    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
     	    		       msFwMessage.show();
     	    		       showMessageForm.setMSFFormWindows(msFwMessage);
            	        } 
             	  
             	  reloadYeta0100();

             } 
             });
     

}
	    
	    
	    
	    private void savePayr06420_SelfAll_Create() { 
	        
	        if (MSFSharedUtils.paramNotNull(systemkey.getValue())) {
	        	
	        	
	        	BaseModel bmMapModel = yeta2000GridPanel.getMsfGrid().getStore().getAt(0); 
	        	Yeta1000DTO yeta1000Dto = new Yeta1000DTO();   
	        	
	        	yeta1000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	        	yeta1000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
	        	yeta1000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
	        	yeta1000Dto.setSystemkey(systemkey.getValue());    /** column SYSTEMKEY : systemkey */
	        	yeta1000Dto.setEdacSeilNum((Long)bmMapModel.get("edacSeilNum"));    /** column 연말정산마감일련번호 : edacSeilNum */
	        	yeta1000Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
	        	yeta1000Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
	        	//yeta1000Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
	        	yeta1000Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
	        	//yeta1000Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
	        	//yeta1000Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
	        	//yeta1000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
	        	//yeta1000Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    /** column 직책코드 : odtyCd */
	        	//yeta1000Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    /** column 호봉코드 : pyspCd */
	        	//yeta1000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
	        	//yeta1000Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
//	        	yeta1000Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
//				yeta1000Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
//				yeta1000Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
//				yeta1000Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
//				yeta1000Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
//				yeta1000Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    /** column 퇴직일자 : retryDt */
//				yeta1000Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));    /** column 연말정산적용년월 : yrtxApptnYrMnth */
//				yeta1000Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));    /** column 연말정산처리일자 : yrtxPrcsDt */
//				yeta1000Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
//				yeta1000Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    /** column 분할납부구분코드 : divdPymtDivCd */
//				yeta1000Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    /** column 분할납부횟수 : divdPymt */ 
				 
           
                 
	        	yeta0100Service.Payr06420_All_Create(yeta1000Dto ,
                        new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {
                public void onFailure(Throwable caught) {
                	
                	 List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
                     ShowMessageBM smBm = new ShowMessageBM();
             	      smBm.setDivision(MSFConfiguration.PAYGEN_ERROR);
             	      smBm.setMenu("Yeta");
             	      smBm.setPhase("[연말정산생성]연말정산대상자에러");
             	      smBm.setMessage(caught.getLocalizedMessage());
             	      smBm.setContent(caught.getMessage());
             	      bmResult.add(smBm);  
             	      PagingLoadResult<ShowMessageBM> retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
             	   
                     ShowMessageForm showMessageForm = new ShowMessageForm(retval,ActionDatabase.READ, getThis());   
        			    
        		      MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showMessageForm,"닫기","620px", "510px",true);
        		      msFwMessage.show();
        		      showMessageForm.setMSFFormWindows(msFwMessage);
        		          
 
                }
                
                 public void onSuccess(PagingLoadResult<ShowMessageBM> result) { 
                 	
                 	   if (MSFSharedUtils.paramNotNull(result)) {
                	           ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
                      	   BaseModel tmRec = new BaseModel();
         	    		       MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
         	    		       msFwMessage.show();
         	    		       showMessageForm.setMSFFormWindows(msFwMessage);
                	        } 
                 	  
                 	  reloadYeta0100();
                      systemkey.setValue("");
                 } 
                 });
 				
	        } else {
	            MessageBox.alert("연말정산 개별생성","개별 생성할 데이타가 존재하지 않습니다.", null);
	            return;
	        }

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
//	    	private void Remt0100Print(String fileName) {
//	     
//	    		// 출력물 디렉토리 패스경로 인사 : PSNL
//	    		String strDirPath = "REMT";
//	    		// mrd 출력물
//	    		String rdaFileName = fileName+".mrd";
//	    		// 보낼 파라미터
//	    		
//	    		
//	    		   //검색조건
//	         	    String serarchParam = "";
//	         	 
//	    		 	 String year = RemtUtils.getSelectedComboValue(srhClutYr,"year");
//	    	         String month = RemtUtils.getSelectedComboValue(srhClutMnth,"month");
//	    	             
//
//	    		    String strCalcSevePayPsnDivCd = RemtUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd");
//	    		      
//	    			String pymtYrMnth = year.concat(month);
//	    			   
//	    			String strDpobCd =  dpobCd.getValue();
//	    		 	String payrMangDeptCd =  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
//	    		 	String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
//	    			String deptCd = RemtUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd");
//	    		 	String typOccuCd = RemtUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd");
//	    		 	//String pyspGrdeCd = RemtUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd");
//	    		 	String dtilOccuInttnCd = RemtUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd");
//	    		 	String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
//	    		 //	String hdofcCodtnCd = strHdofcCodtnCd;
//	    		 	String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
//	    		 	String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
//	    		 	String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
//	    	         
//	    				
//	    		 	serarchParam += "["+strDpobCd+"]";   //$1
//	    		 	serarchParam += "["+pymtYrMnth+"]";    //$2
//	    		 	serarchParam += "["+strCalcSevePayPsnDivCd+"]";  //$3 
//	    			serarchParam += "["+payrMangDeptCd+"]";      //$4
//	    			serarchParam += "["+emymtDivCd+"]";      //$5
//	    			serarchParam += "["+deptCd+"]";       //$6
//	    			serarchParam += "["+typOccuCd+"]";   //$7
//	    			serarchParam += "[]";   //$8
//	    			serarchParam += "["+dtilOccuInttnCd+"]";  //$9
//	    			serarchParam += "["+businCd+"]";      //$10 
//	    			 
//	    		
//	    		List<BaseModel> list = remt2000DefGridPanel.getGrid().getSelectionModel().getSelectedItems();
//	    		String checkedSystemKeys = "";
//	    		if(list != null && list.size() > 0){
//	    			String chkkey = "";
//	    			for(BaseModel bm : list){
//	    				chkkey += "'"+bm.get("systemkey")+"',";
//	    			}
//	    			
//	    			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//	    			
//	    		}   //$11
//	    		
//	    		
//	    	      serarchParam += "["+checkedSystemKeys+"]";  //$11
//	    	      
//	    	      //TODO 확인  출력 확인 해야함 
//	    	      if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
//	    	          
//	    	          serarchParam += "[]";  //$12
//	    	          serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$13
//	    	      
//	    	      } else {
//	    	           
//	    	          		  
//	    	          //직종 권한에 대한 처리 추가 기본 처리  $14로해서 처리 할것...$12
////	    	          if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
////	    	                    && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
////	    	              serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
////	    	          } else {
////	    	              serarchParam += "[]";
////	    	          } 
//	    	          
//	    	          serarchParam += "[]";  //$13
//	    	      }
//	    	      
//	    			 
//	    		 String strParam = "/rp " + serarchParam;
//	    		 
//	    		
//	    		//GWT 타입으로 팝업 호출시  postCall true 설정
//	    		PrintUtils.setPostCall(true);
//	    		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//
//	    	}

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
	  		createYeta0100Form();  //화면 기본정보를 설정
	  		createSearchForm(); 
	  		createMsfGridForm();  //그리드설정
	  		vp.setSize("1010px", "700px");
	                  
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
		public Yeta0100() {
			setSize("1600px", "700px");  
		} 

		public Yeta0100(String txtForm) {
		      this.txtForm = txtForm;
		}
	  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/		  
		private void createYeta0100Form() {
			
			plFrmYeta0100 = new FormPanel(); 
			plFrmYeta0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산대상자관리"));
			plFrmYeta0100.setIcon(MSFMainApp.ICONS.text());
			plFrmYeta0100.setPadding(2);
			plFrmYeta0100.setFrame(true); 
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage("연말정산대상자관리","YETA0100");
					}
				});
			plFrmYeta0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmYeta0100.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/
 
		     //멀티콤보박스 닫기 
			plFrmYeta0100.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) { 
	            
	             //   for (Field<?>  f : ((FormPanel) plFrmRemt0100).getFields()) {
                        
	            //        if (f instanceof MSFMultiComboBox<?>) {
	                        
//	                        if ("srhDeptCd".equals(f.getName())) {
//	                            
//	                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                            
//	                        }
                            
                  //      } else {
	                   if (mutilCombo) {
                            if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
                                srhDeptCd.showClose(ce);
                                mutilCombo = false;
                         //   } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
                         //       srhHdofcCodtnCd.showClose(ce);
                          //      mutilCombo = false;
                            } else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
                                //직종
                                srhTypOccuCd.showClose(ce);
                                mutilCombo = false;
                              //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
                            } else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                                //직종세
                                srhDtilOccuInttnCd.showClose(ce);
                                mutilCombo = false;
                            } else if ( creDeptCd.getCheckBoxListHolder().isVisible() ) {
                            	creDeptCd.showClose(ce);
                                mutilCombo = false;
                         //   } else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
                         //       srhHdofcCodtnCd.showClose(ce);
                          //      mutilCombo = false;
                            } else if (creTypOccuCd.getCheckBoxListHolder().isVisible() ) {
                                //직종
                            	creTypOccuCd.showClose(ce);
                                mutilCombo = false;
                              //  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
                            } else if ( creDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                                //직종세
                            	creDtilOccuInttnCd.showClose(ce);
                                mutilCombo = false;
                            }  
	                   }
                    //    }
	            //    } 
	            } 
	        });
	        
			/** 상단 버튼 ButtonBar**/
			topYeta0100Bar = new ButtonBar();    
			topYeta0100Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
//			btnYeta0100Init = new Button("초기화");  
//			btnYeta0100Init.setIcon(MSFMainApp.ICONS.new16());
//			topYeta0100Bar.add(btnYeta0100Init);
			    
			btnYeta0100Init = new Button("초기화");  
			btnYeta0100Init.setIcon(MSFMainApp.ICONS.new16());
			topYeta0100Bar.add(btnYeta0100Init); 
			btnYeta0100Init.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			 //초기화 
	    			formInit();
	    		}
	        });  
 
			btnYeta0100Del = new Button("삭 제");  
			btnYeta0100Del.setIcon(MSFMainApp.ICONS.delete16());
			topYeta0100Bar.add(btnYeta0100Del);
			btnYeta0100Del.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			doAction(actionDatabase.DELETE);
	    		}
	    	});	  	   
		//	btnYeta0100Save = new Button("저 장");  
		//	btnYeta0100Save.setIcon(MSFMainApp.ICONS.save16());
		//	topYeta0100Bar.add(btnYeta0100Save);
		      
			btnYeta0100Sreach = new Button("조 회");  
			btnYeta0100Sreach.setIcon(MSFMainApp.ICONS.search());
			topYeta0100Bar.add(btnYeta0100Sreach);
			btnYeta0100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//조회버튼 클릭시 처리 
	    			reloadYeta0100();  
	    		}
	    	});
//			btnYeta0100Print = new Button("인 쇄");  
//			btnYeta0100Print.setIcon(MSFMainApp.ICONS.print16());
//			topYeta0100Bar.add(btnYeta0100Print);	
			
//			btnYeta0100Print = new Button("인 쇄");  
//			btnYeta0100Print.setIcon(MSFMainApp.ICONS.print16());
//			topYeta0100Bar.add(btnYeta0100Print);	
			
			btnYeta0100Excel = new Button("엑 셀");  
			btnYeta0100Excel.setIcon(MSFMainApp.ICONS.excel16());
			topYeta0100Bar.add(btnYeta0100Excel);
			btnYeta0100Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//엑셀 저장
	    			xlsExportData();  
	    		}
	    	});
			
			
			
 
			plFrmYeta0100.add(topYeta0100Bar);
		      
			//파일업로드 처리
			plFrmYeta0100.setAction("myurl");
			plFrmYeta0100.setEncoding(Encoding.MULTIPART);
			plFrmYeta0100.setMethod(Method.POST);		         
			vp.add(plFrmYeta0100);	
			
			plFrmYeta0100.setSize("990px", "680px");	      
			plFrmYeta0100.setLayout(new FlowLayout());
		}
  
		
  /**
    * 		
    * <pre>
    * 1. 개요 : 연말정산 검색 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : createSearchForm
    * @date : Jan 15, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 15, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    *
    */
    private void createSearchForm() {   		
			
			dpobCd = new HiddenField<String>();            //사업장코드 
	        systemkey = new HiddenField<String>();         //시스템키 
	    
			
			sysComBass0150Dto = new PrgmComBass0150DTO();
		    sysComBass0300Dto = new PrgmComBass0300DTO();
		    sysComBass0400Dto = new PrgmComBass0400DTO();
		    sysComBass0500Dto = new PrgmComBass0500DTO();
		    msfCoCalendarDto = new SysCoCalendarDTO();
		    sysComBass0350Dto = new PrgmComBass0350DTO();
		    sysComBass0320Dto = new PrgmComBass0320DTO();
			
		    
		  //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		    lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);		//단위기관_검색조건
		    lscrPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);		//단위기관_연말정산대상자생성
		    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		     
		    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		    sysComBass0300Dto.setRpsttvCd("Y002");
		    lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);//정산구분
		     
		    sysComBass0300Dto.setRpsttvCd("Y002");
		    lsCrCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);//정산구분 
		    
		    
			//호봉
			sysComBass0300Dto.setRpsttvCd("A048");
			lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			lscreRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			
			
		    sysComBass0300Dto.setRpsttvCd("A002");
		    lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);			//고용구분_검색조건
		    
		    
		    sysComBass0300Dto = new PrgmComBass0300DTO();
		    sysComBass0300Dto.setRpsttvCd("A002");
		    
		    
		    lscrEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);		//고용구분_연말정산대상자생성
		    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		     
		     
		     //--------------------정산년도 불러 오는 함수 ------------------------------------------------
		     lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		     //--------------------정산년도 불러 오는 함수 ------------------------------------------------
		     
		     //--------------------년도 불러 오는 함수 ------------------------------------------------
		     lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		
		     //--------------------년도 불러 오는 함수 ------------------------------------------------  
   
		     
		     sysComBass0400Dto.setDeptDspyYn("Y");
		     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		     
		     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		     
		     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		    	 public void handleEvent(StoreEvent<BaseModel> be) {  
		    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd); 
		    		 srhDeptCd.getInitStore().add(mDtalistDeptCd);
		    	 }
		     });
		     
		     
		     sysComBass0400Dto.setDeptDspyYn("Y");
		     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		     
		     lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		     
		     lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		    	 public void handleEvent(StoreEvent<BaseModel> be) {  
		    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lscrDeptCd);
		    		 creDeptCd.getInitStore().add(mDtalistDeptCd);
		    	 }
		     });
		     
		     
		     /**
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		      * 직종 콤보박스 처리  시작
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          
		      */
		     
//		     ContentPanel typOccuCdGrid = new ContentPanel();  
//		     typOccuCdGrid.setVisible(false);
//		                
//		        //직종 콤보처리 
//		        typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		        typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		        	public void handleEvent(ComponentEvent be) {  
//		        		typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		        			public void handleEvent(StoreEvent<BaseModel> be) {  
//		        				lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
//		        				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//		        				srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//		        				lscrTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//		        				mDtalistcrTypOccuCd = YetaUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//		        				creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
//		    			   		}  
//		        		});  
//		        	}  
//		        });  
//			typOccuCdGrid.add(typOccuCdGridPanel); 
//		  	plFrmYeta0100.add(typOccuCdGrid);

		      lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		             
	                 mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                  
	               }
	           });  
			   
			   lscrTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			   lscrTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	 
        				mDtalistcrTypOccuCd = YetaUtils.getTypOccuCdModelData(lscrTypOccuCd) ;  
        				creTypOccuCd.getInitStore().add(mDtalistcrTypOccuCd);
	                  
	               }
	           });  
			   
		  	srhSystemkey = new HiddenField<String>(); 
			plFrmYeta0100.setLayout(new FlowLayout());
		    
		     
		      
			FieldSet fieldSet = new FieldSet();
			fieldSet.setHeadingHtml("검색조건");
			/****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 시작
			 ****************************************************************/
				fieldSet.addStyleName("x-fieldset-serarch-back-color");
			/****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 끝
			 ****************************************************************/
//			fieldSet.setHeight("80px");   			  

			  // 컬럼 총 열에 대한 컨테이너
			  LayoutContainer lcSchCol1 = new LayoutContainer();
			  lcSchCol1.setLayout(new ColumnLayout());
			  fieldSet.add(lcSchCol1, new FormData("100%"));		  
			  
			  // 부속 열 컨테이너 묶음			  
			  LayoutContainer layoutContainer1_1 = new LayoutContainer();
			  layoutContainer1_1.setLayout(new ColumnLayout());
		
			  
			  /** column 지급년 : ClutYr */
			  LayoutContainer layoutContainer1 = new LayoutContainer();
			  FormLayout frmlytSch = new FormLayout();  
			  frmlytSch.setLabelWidth(60); 
			  frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			  layoutContainer1.setLayout(frmlytSch);				  
			  
			    srhClutYr = new MSFComboBox<BaseModel>();
			    srhClutYr.setName("srhClutYr");
			    srhClutYr.setForceSelection(true);
			    srhClutYr.setMinChars(1);
			    srhClutYr.setDisplayField("yearDisp");
			    srhClutYr.setValueField("year");
			    srhClutYr.setTriggerAction(TriggerAction.ALL);
			    srhClutYr.setSelectOnFocus(true); 
			    srhClutYr.setReadOnly(true);
			    srhClutYr.setEnabled(true); 
			    srhClutYr.setStore(lsClutYrStore);
			    srhClutYr.setFieldLabel("정산년도"); 
			    srhClutYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						
					}
				});
				srhClutYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
					public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
						// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
						BaseModel bmClutYr = se.getSelectedItem();
						if (bmClutYr != null) {
							if ((srhDeptCd.getListView().getChecked().size() == 1)
											&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

									if (srhDeptCd.getListView().getChecked().size() > 0) {
											sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));
											List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
											sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
									}

										// --------------------사업 불러 오는 함수-------------------------------------------------
										lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
										// --------------------사업 불러 오는 함수-------------------------------------------------
										srhBusinCd.setStore(lsBusinCd);
										srhBusinCd.getStore().addStoreListener(
												new StoreListener<BaseModel>() {
													public void handleEvent(StoreEvent<BaseModel> be) {
//														 searchBusinCd.setValue(lsBusinCd.getAt(0));
													}
												});

							} else {
										// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
										// return;
							}
						}
					}
				});		    
			    layoutContainer1.add(srhClutYr, new FormData("100%"));
			    layoutContainer1_1.add(layoutContainer1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			    layoutContainer1.setBorders(false);
			    
	    
			    
			    /** column 단위기관 : PayrMangDeptCd */ 
			    LayoutContainer layoutContainer3 = new LayoutContainer();
			    layoutContainer3.setBorders(false);
			    
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
			    layoutContainer3.setLayout(frmlytSch);			    

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
			        	checkYeta0100Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
			            	   mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
				                 srhDeptCd.getInitStore().add(mDtalistDeptCd);
			               }
			            });  
			        } 
			    });
			    layoutContainer3.add(srhPayrMangDeptCd, new FormData("100%"));
			    
			    /** column 고용구분 : EmymtDivCd */
			    LayoutContainer layoutContainer4 = new LayoutContainer(new ColumnLayout());
			    layoutContainer4.setBorders(false); 
			    
			    LayoutContainer layoutContainer77 = new LayoutContainer();
			    
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer77.setLayout(frmlytSch);
			    
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
				    		   checkYeta0100Auth("srhEmymtDivCd", lsEmymtDivCd); 
			           	 }
			        }
			    });    
			    srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
			            //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
			         BaseModel bmPayCd =  se.getSelectedItem(); 
			         if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
			           if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
			               
			               if (srhDeptCd.getListView().getChecked().size() > 0) {  
			                  
			                   sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year"));    
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
			           srhBusinCd.setEnabled(true);
			           srhTypOccuCd.reset();
			           srhTypOccuCd.setEnabled(false);
			           srhDtilOccuInttnCd.reset();
			           srhDtilOccuInttnCd.setEnabled(false);
			        } else {
			            srhBusinCd.reset();
			            srhBusinCd.setEnabled(false);  
			            
			            if (gwtAuthorization.getCheckOccuDisabled()) {
			                srhTypOccuCd.setEnabled(true);
			                srhDtilOccuInttnCd.setEnabled(true); 
			            } else {
			                srhTypOccuCd.setEnabled(false);
			                srhDtilOccuInttnCd.setEnabled(false);
			            }
			        }
			        }
			    });
			    layoutContainer77.add(srhEmymtDivCd, new FormData("100%"));
			    layoutContainer4.add(layoutContainer77, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			    
			    LayoutContainer layoutContainer_101 = new LayoutContainer();
				layoutContainer_101.setBorders(false);

			    frmlytSch = new FormLayout();  
			    frmlytSch.setDefaultWidth(0);
//			    frmlytSch.setLabelWidth(0); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer_101.setLayout(frmlytSch);
			    
			    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
			    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
			    srhRepbtyBusinDivCd.setHideLabel(true);
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
			    srhRepbtyBusinDivCd.setLabelSeparator("");
		       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
			    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  

		              
		            }
		        });  
			    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
			    layoutContainer4.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			     
			    
			    
			    // 부속 열 컨테이너 묶음
			    LayoutContainer layoutContainer1_2 = new LayoutContainer();
			    layoutContainer1_2.setLayout(new ColumnLayout());
			    
			    
			    /** column 성명 : HanNm */
			    LayoutContainer layoutContainer5 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer5.setLayout(frmlytSch);
			    
			    srhHanNm = new TextField<String>();
			    srhHanNm.setName("srhHanNm");
			    srhHanNm.setFieldLabel("성명");
			    layoutContainer5.add(srhHanNm, new FormData("100%"));
			   
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
			            super.componentKeyDown(event);
			        }
			     });
//			    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			        @Override
//			        public void handleEvent(BaseEvent be) {  
//			            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//			            	srhSystemkey.setValue("");
//			                srhResnRegnNum.setValue("");
//			            }
//			         
//			        } 
//			   }); 
			    layoutContainer1_2.add(layoutContainer5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
			    layoutContainer5.setBorders(false);
			    
			    
			    
		        LayoutContainer layoutContainer_btn = new LayoutContainer();
		        frmlytSch = new FormLayout();  
		        frmlytSch.setLabelWidth(0); 
		        layoutContainer_btn.setLayout(frmlytSch);
			    
			    Button btnHanNm = new Button("검색");
//			    layoutContainer1_2.add(btnHanNm);
			    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			        public void handleEvent(ButtonEvent e) {
			        	srhSystemkey.setValue("");
			            srhResnRegnNum.setValue("");
			            fnPopupPsnl0100();			              
			        }
			    });
			    
		        layoutContainer_btn.add(btnHanNm);
		        layoutContainer1_2.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
			    
			    /** column 주민등록번호 : resnRegnNum */
			    LayoutContainer layoutContainer6 = new LayoutContainer();
			    
			    frmlytSch = new FormLayout();  
			    frmlytSch.setDefaultWidth(0);
//			    frmlytSch.setLabelWidth(0); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer6.setLayout(frmlytSch);		
			    
			    
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
			    layoutContainer6.add(srhResnRegnNum, new FormData("100%"));
			    layoutContainer1_2.add(layoutContainer6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
			    layoutContainer6.setBorders(false); 
			    layoutContainer1_2.setBorders(false);
			    
			    LayoutContainer layoutContainer_16 = new LayoutContainer();
			    layoutContainer_16.setBorders(false);		   
			    
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
			    layoutContainer_16.setLayout(frmlytSch);
			    
			    
			    
			    /** column 정산구분 : CalcSevePayPsnDivCd */ 
			    LayoutContainer layoutContainer7 = new LayoutContainer();
			    layoutContainer7.setBorders(false);		   
			    
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
			    layoutContainer7.setLayout(frmlytSch);
			    
			    srhCalcSevePayPsnDivCd =  new ComboBox<BaseModel>(); 
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
			    srhCalcSevePayPsnDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			        public void handleEvent(StoreEvent<BaseModel> be) {  
			        	
			        }
			    });  			    
			    layoutContainer7.add(srhCalcSevePayPsnDivCd, new FormData("100%"));
			    
			    
			    LayoutContainer layoutContainer8 = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer8.setLayout(frmlytSch);
			    
			    srhDeptCd = new MSFMultiComboBox<ModelData>();
			    srhDeptCd.setName("srhDeptCd");
			    srhDeptCd.setEmptyText("--부서선택--");
			    srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
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
				    		   checkYeta0100Auth("srhDeptCd", lsDeptCd); 
			           	 }
			         
			        }
			    });    

			    srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			       @Override
			      public void handleEvent(ComponentEvent ce) { 
			               
			                  if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
			                     
			                      if (srhDeptCd.getListView().getChecked().size() > 0) {  
			                         
			                          sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr,"year"));    
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
			                	// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
				               // return;
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
			         
			    layoutContainer8.add(srhDeptCd, new FormData("100%"));
			    layoutContainer8.setBorders(false);
			    
			    
			    
			    
			    // 부속 열 컨테이너 묶음			  
				LayoutContainer layoutContainer1_3 = new LayoutContainer();
				layoutContainer1_3.setLayout(new ColumnLayout());
				
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
				
				
			    /** column 직종 : srhTypOccuCd */
			    LayoutContainer lcTypOccuCd = new LayoutContainer();
			    frmlytSch = new FormLayout();  
			    frmlytSch.setDefaultWidth(0);
//			    frmlytSch.setLabelWidth(70); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    lcTypOccuCd.setLayout(frmlytSch);   	    
  
			    srhTypOccuCd = new MSFMultiComboBox<ModelData>();
			    srhTypOccuCd.setName("srhTypOccuCd"); 
			    srhTypOccuCd.setEmptyText("--직종선택--"); 
			    srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
			    srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
			    srhTypOccuCd.setWidth(100);
			    srhTypOccuCd.setHideLabel(true);
//			    srhTypOccuCd.setFieldLabel("직종");
			    srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
			    srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
			    srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			        public void handleEvent(StoreEvent<ModelData> be) {  
			        	  EventType type = be.getType();
				    	   if (type == Store.Add) { 
			           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				    		 //  checkYeta0100Auth("srhTypOccuCd", lsTypOccuCd); 
			           	 }
			        }
			    });     
			    
			    srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			       @Override
			      public void handleEvent(ComponentEvent ce) { 			               
			                  if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
			                     //직종변경에 따른 직종세 값 가져오기
			                        List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked();  
			                        
			                        String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			                        sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
			                       // sysComBass0350Dto.setPyspGrdeCd(YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
			                        
			                        if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
			                            
			                            lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
			                          //  srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
			                            
			                            lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
			                                public void handleEvent(StoreEvent<BaseModel> be) {  
			                                    mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuClsDivCdModelData(lsDtilOccuInttnCd) ; 
			                                    srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
			                                    
			                                }
			                            });     
			                            
			                        } 
			                     
			                  } else {
			                   
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
			    lcTypOccuCd.add(srhTypOccuCd, new FormData("100%")); 			    
			    
			    
			    
			    
			    LayoutContainer lcSchRight = new LayoutContainer();			   
			    
			    frmlytSch = new FormLayout();  
//			    frmlytSch.setLabelWidth(1); 
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
			    
			    layoutContainer1_3.add(layoutContainer_211,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
			    layoutContainer1_3.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
			    layoutContainer1_3.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
			    layoutContainer1_3.setBorders(false);
			    
			    
			    
			    
			    /** column 사업 : BusinCd */
			    LayoutContainer layoutContainer9 = new LayoutContainer();
				frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer9.setLayout(frmlytSch);
			    
			    srhBusinCd = new ComboBox<BaseModel>();
			    srhBusinCd.setName("srhBusinCd");
			    srhBusinCd.setForceSelection(true);
			    srhBusinCd.setMinChars(1);
			    srhBusinCd.setDisplayField("businNm");
			    srhBusinCd.setValueField("businCd");
			    srhBusinCd.setTriggerAction(TriggerAction.ALL);
			    srhBusinCd.setEmptyText("--사업선택--");
			    srhBusinCd.setSelectOnFocus(true);  
			    srhBusinCd.getListView().setWidth("200px");
			    srhBusinCd.setStore(lsBusinCd);
			    srhBusinCd.setFieldLabel("사업");
			    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
			    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
			    layoutContainer9.add(srhBusinCd, new FormData("100%"));
			    layoutContainer9.setBorders(false);			    
			    
			    plFrmYeta0100.add(fieldSet);
			    
			    
			    
			    
			    
			    // 연말정산대상자-생성			    
			    FieldSet fieldSet_2 = new FieldSet();  
			    fieldSet_2.setHeadingHtml("연말정산대상자-생성");
			    fieldSet_2.setHeight("100px");
			    fieldSet_2.setCollapsible(false);
			    
			    // 컬럼 총 열에 대한 컨테이너
				LayoutContainer lcSchCol2 = new LayoutContainer();
				lcSchCol2.setLayout(new ColumnLayout());
				fieldSet_2.add(lcSchCol2, new FormData("100%"));	
				
				/** column 년도 : creYear */
				LayoutContainer layoutContainer10 = new LayoutContainer(new ColumnLayout());
				layoutContainer10.setBorders(false);				
				//LayoutContainer lc11 = new LayoutContainer();
				
				
				LayoutContainer lc1_1 = new LayoutContainer();
				FormLayout fl1_1 = new FormLayout();
				fl1_1.setLabelWidth(60);
				fl1_1.setLabelAlign(LabelAlign.RIGHT);
				lc1_1.setLayout(fl1_1);			    
				creYear = new MSFComboBox<BaseModel>();
		        creYear.setName("creYear");
		        creYear.setFieldLabel("정산년도");
		        creYear.setForceSelection(true);
		        creYear.setMinChars(1);
		        creYear.setDisplayField("yearDisp");
		        creYear.setValueField("year");
		        creYear.setTriggerAction(TriggerAction.ALL);
		        creYear.setEmptyText("--년도--");
		        creYear.setReadOnly(true);
		        creYear.setSelectOnFocus(true);
		        creYear.setStore(lscrPayYr);
		        creYear.getStore().addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						
					}
				});
				creYear.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
					public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
						// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
						BaseModel bmClutYr = se.getSelectedItem();
						if (bmClutYr != null) {
							if ((creDeptCd.getListView().getChecked().size() == 1)&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {

									if (creDeptCd.getListView().getChecked().size() > 0) {
											sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear, "year"));
											List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
											sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
									}

										// --------------------사업 불러 오는 함수-------------------------------------------------
										lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
										// --------------------사업 불러 오는 함수-------------------------------------------------
										creBusinCd.setStore(lscrBusinCd);
										creBusinCd.getStore().addStoreListener(
												new StoreListener<BaseModel>() {
													public void handleEvent(StoreEvent<BaseModel> be) {
//														 searchBusinCd.setValue(lscrBusinCd.getAt(0));
													}
												});

							} else {
										// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
										// return;
							}
						}
					}
				});
		        
		        
		        
		        lc1_1.add(creYear, new FormData("100%"));
		       // lc11.add(lc1_1, new FormData("100%"));	        
		        
		        
		        /** column 단위기관 : crePayrMangDeptCd */
		        LayoutContainer layoutContainer11 = new LayoutContainer();
				
				FormLayout frmlytSch01_1_2 = new FormLayout();
				frmlytSch01_1_2.setLabelWidth(60);
				frmlytSch01_1_2.setLabelAlign(LabelAlign.RIGHT);
				layoutContainer11.setLayout(frmlytSch01_1_2);
				
				crePayrMangDeptCd = new MSFComboBox<BaseModel>();
				crePayrMangDeptCd.setName("crePayrMangDeptCd");
				crePayrMangDeptCd.setForceSelection(true);
				crePayrMangDeptCd.setMinChars(1);
				crePayrMangDeptCd.setDisplayField("payrMangDeptNm");
				crePayrMangDeptCd.setValueField("payrMangDeptCd");
				crePayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
				crePayrMangDeptCd.setEmptyText("--단위기관선택--");
				crePayrMangDeptCd.setSelectOnFocus(true); 
				crePayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
				crePayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
				crePayrMangDeptCd.setStore(lscrPayrMangDeptCd);  
				crePayrMangDeptCd.setFieldLabel("단위기관"); 
		        lscrPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	 EventType type = be.getType();
				    	   if (type == Store.Add) { 
		                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				    		   		checkYeta0100Auth("crePayrMangDeptCd", lscrPayrMangDeptCd); 
		                	 }
		             
		            }
		        });    
		        crePayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		                //단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
		                sysComBass0400Dto.setDeptDspyYn("Y");
		                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"));
		                //--------------------부서 불러 오는 함수 ------------------------------------------------
		                lscrDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		                //--------------------부서 불러 오는 함수 ------------------------------------------------
		                lscrDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		                   public void handleEvent(StoreEvent<BaseModel> be) {  
		                     mDtalistDeptCd = YetaUtils.getDeptCdModelData(lscrDeptCd) ; 
		                     creDeptCd.getInitStore().add(mDtalistDeptCd);
		                       
		                   }
		                });   
		            } 
		        });
		        layoutContainer11.add(crePayrMangDeptCd, new FormData("100%"));
		        layoutContainer11.setBorders(false);
		        
		        
		        
		        
		        
		        
		        /** column 고용구분 : EmymtDivCd */
				LayoutContainer layoutContainer12 = new LayoutContainer(new ColumnLayout());
				layoutContainer12.setBorders(false);
				
				LayoutContainer layoutContainer122 = new LayoutContainer();
				
				FormLayout frmlytSch03_1 = new FormLayout();
				frmlytSch03_1.setLabelWidth(60);
				frmlytSch03_1.setLabelAlign(LabelAlign.RIGHT);
				layoutContainer122.setLayout(frmlytSch03_1);
				
				creEmymtDivCd = new ComboBox<BaseModel>();
				creEmymtDivCd.setName("creEmymtDivCd");
				creEmymtDivCd.setFieldLabel("고용구분");
				creEmymtDivCd.setForceSelection(true);
				creEmymtDivCd.setMinChars(1);
				creEmymtDivCd.setDisplayField("commCdNm");
				creEmymtDivCd.setValueField("commCd");
				creEmymtDivCd.setTriggerAction(TriggerAction.ALL);
				creEmymtDivCd.setEmptyText("--고용구분선택--");
				creEmymtDivCd.setSelectOnFocus(true);
				creEmymtDivCd.setStore(lscrEmymtDivCd);
				creEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
			    creEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
			    lscrEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			    	public void handleEvent(StoreEvent<BaseModel> be) { 
			    		EventType type = be.getType();
			    		if (type == Store.Add) { 
			    			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			    			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			    			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			    			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
							++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			    			checkYeta0100Auth("creEmymtDivCd", lscrEmymtDivCd); 
			    		}
			    	}
			    });
			    creEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		            	BaseModel bmPayCd =  se.getSelectedItem(); 
		            		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
		            			if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
		            				if (creDeptCd.getListView().getChecked().size() > 0) {  
		            					sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));    
		            					List<ModelData> mdListSelect = creDeptCd.getListView().getChecked(); 
		            					sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
		            				}      
		                  
		            				//--------------------사업 불러 오는 함수 -------------------------------------------------
		            				lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
		            				//--------------------사업 불러 오는 함수 -------------------------------------------------
		                	 
		            				creBusinCd.setStore(lscrBusinCd); 
		            				creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		            					public void handleEvent(StoreEvent<BaseModel> be) {  
		            						//   searchBusinCd.setValue(lscrBusinCd.getAt(0));  
		            					}
		            				});    
		            			} else {
		            				// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
		            				// return;
		            			}  
		            			creBusinCd.setEnabled(true);
		            			creTypOccuCd.reset();
		            			creTypOccuCd.setEnabled(false);
		            			creDtilOccuInttnCd.reset();
		            			creDtilOccuInttnCd.setEnabled(false);
		            		} else {
		            			creBusinCd.reset();
		            			creBusinCd.setEnabled(false);
		            			
		            			if (gwtAuthorization.getCheckOccuDisabled()) {
		            				creTypOccuCd.setEnabled(true);
		            				creDtilOccuInttnCd.setEnabled(true); 
		            			} else {
		            				creTypOccuCd.setEnabled(false);
		            				creDtilOccuInttnCd.setEnabled(false);		                     

		            		}  
		            	}  
		            } 
			    });
			    layoutContainer122.add(creEmymtDivCd, new FormData("100%"));
			    layoutContainer12.add(layoutContainer122, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
			    
			    
			    LayoutContainer layoutContainer123 = new LayoutContainer();
			    layoutContainer123.setBorders(false);

			    frmlytSch = new FormLayout();  
			    frmlytSch.setDefaultWidth(0);
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer123.setLayout(frmlytSch);
			    
			    creRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
			    creRepbtyBusinDivCd.setName("creRepbtyBusinDivCd");
			    creRepbtyBusinDivCd.setForceSelection(true);
			    creRepbtyBusinDivCd.setHideLabel(true);
			    creRepbtyBusinDivCd.setAllowBlank(false);
			    creRepbtyBusinDivCd.setMinChars(1);
			    creRepbtyBusinDivCd.setDisplayField("commCdNm");
			    creRepbtyBusinDivCd.setValueField("commCd");
			    creRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
			    creRepbtyBusinDivCd.setEmptyText("--호봉제--");
			    creRepbtyBusinDivCd.setSelectOnFocus(true); 
			    creRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
			    creRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
			    creRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
		       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
			    lscreRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  

		              
		            }
		        });  
			    
			    layoutContainer123.add(creRepbtyBusinDivCd, new FormData("100%"));
			    layoutContainer12.add(layoutContainer123, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			    
			     
			    
			    
			    LayoutContainer layoutContainer13 = new LayoutContainer();
		      	FormLayout fl4 = new FormLayout();
		      	fl4.setLabelWidth(60);
				fl4.setLabelAlign(LabelAlign.RIGHT);
				layoutContainer13.setLayout(fl4);
			  	 
			   		        
		       	LayoutContainer lc2_1_1 = new LayoutContainer();
		    	FormLayout fl2_1 = new FormLayout();
		      	fl2_1.setLabelWidth(60);
		      	fl2_1.setLabelAlign(LabelAlign.RIGHT);
		     	lc2_1_1.setLayout(fl2_1);
		             
		     	creCalcSevePayPsnDivCd =  new MSFComboBox<BaseModel>(); 
		     	creCalcSevePayPsnDivCd.setName("srhCalcSevePayPsnDivCd");
		     	creCalcSevePayPsnDivCd.setForceSelection(true);
		     	creCalcSevePayPsnDivCd.setMinChars(1);
		     	creCalcSevePayPsnDivCd.setDisplayField("commCdNm");
		     	creCalcSevePayPsnDivCd.setValueField("commCd");
		     	creCalcSevePayPsnDivCd.setTriggerAction(TriggerAction.ALL);
		     	creCalcSevePayPsnDivCd.setEmptyText("--정산구분선택--");
		     	creCalcSevePayPsnDivCd.setSelectOnFocus(true); 
		     	creCalcSevePayPsnDivCd.setReadOnly(false);
		     	creCalcSevePayPsnDivCd.setEnabled(true); 
		     	creCalcSevePayPsnDivCd.setStore(lsCrCalcSevePayPsnDivCd);
		     	creCalcSevePayPsnDivCd.setFieldLabel("정산구분");
		     	creCalcSevePayPsnDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			        public void handleEvent(StoreEvent<BaseModel> be) {  
			        	
			        }
			    });  			    
		       
		        lc2_1_1.add(creCalcSevePayPsnDivCd, new FormData("100%")); 
		            
		        layoutContainer13.add(lc2_1_1, new FormData("100%")); 
			    
	
			    
			    /** column 부서 : DeptCd */
			    LayoutContainer layoutContainer14 = new LayoutContainer();
		    	FormLayout fl11 = new FormLayout();
		     	fl11.setLabelWidth(60);
		     	fl11.setLabelAlign(LabelAlign.RIGHT);
		     	layoutContainer14.setLayout(fl11);
		     	
		     	creDeptCd = new MSFMultiComboBox<ModelData>();
		        creDeptCd.setName("creDeptCd");
		        creDeptCd.setEmptyText("--부서선택--");
		        creDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		    	creDeptCd.getStore().add(mDtalistcrDeptCd);
		        creDeptCd.setWidth(100);
		        creDeptCd.setFieldLabel("부서");
		        creDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		        creDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		        creDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
		        	public void handleEvent(StoreEvent<ModelData> be) {  
		        		EventType type = be.getType();
		        		if (type == Store.Add) { 
		        			/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		        			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		        			 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		        			 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
							++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		        			checkYeta0100Auth("creDeptCd", lscrDeptCd); 
		        		}
		        	}
		        });    
		             
		        creDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
		        	@Override
		        	public void handleEvent(ComponentEvent ce) { 
		        		if ((creDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
		        			if (creDeptCd.getListView().getChecked().size() > 0) {  
		        				sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(creYear,"year"));  
		                        List<ModelData> mdListSelect =  creDeptCd.getListView().getChecked(); 
		                        sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
		        			}      
		                            
		        			//--------------------사업 불러 오는 함수 -------------------------------------------------
		        			lscrBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
		        			//--------------------사업 불러 오는 함수 -------------------------------------------------
		        			
		        			creBusinCd.setStore(lscrBusinCd); 
		        			creBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        				public void handleEvent(StoreEvent<BaseModel> be) {  
		                                      //   creBusinCd.setValue(lscrBusinCd.getAt(0));  
		        				}
		        			});    
		                                 
		                              
		        		} else {
		        			// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
		        			// return;
		        		} 
		        	}  
		        });  
		              
		        creDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
		        	@Override
		        	public void handleEvent(ComponentEvent ce) {   
		        		if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//		                        // GWT.log(" a" + ce.getEvent().getType());
		        			mutilCombo = true;
		        		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
		        			mutilCombo = true;
//		                       //  GWT.log(" b" + ce.getEvent().getType());
		        		} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
		        			mutilCombo = false;
//		                       //  GWT.log(" b" + ce.getEvent().getType());
		        		} 
		        	} 
		        });                       
		                 
		        layoutContainer14.add(creDeptCd, new FormData("100%"));
		        
		        
		        
		        /** column 직종 : creTypOccuCd */
		        LayoutContainer layoutContainer2_1 = new LayoutContainer();
		        FormLayout fl31 = new FormLayout();
//		    	fl31.setLabelWidth(30);
//		     	fl31.setLabelAlign(LabelAlign.RIGHT);
		     	layoutContainer2_1.setLayout(fl31);
		        
		     	//직종 직종세처리 
		     	LayoutContainer crTypOccuCd = new LayoutContainer();
		      	crTypOccuCd.setLayout(new ColumnLayout());
		      	
		      	
		        LayoutContainer layoutContainer_212 = new LayoutContainer();
		        frmlytSch = new FormLayout();  
		        frmlytSch.setLabelWidth(60); 
		        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		        layoutContainer_212.setLayout(frmlytSch); 
		       
		        creDeptGpCd  =  new ComboBox<BaseModel>(); 
		        creDeptGpCd.setName("creDeptGpCd");
		        creDeptGpCd.setForceSelection(true);
		        creDeptGpCd.setAllowBlank(false);
		        creDeptGpCd.setMinChars(1);
		        creDeptGpCd.setDisplayField("commCdNm");
		        creDeptGpCd.setValueField("commCd");
		        creDeptGpCd.setTriggerAction(TriggerAction.ALL);
		        creDeptGpCd.setEmptyText("--그룹--");
		        creDeptGpCd.setSelectOnFocus(true); 
		        creDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		        creDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		        creDeptGpCd.setStore(lscreDeptGpCd);
		        creDeptGpCd.setFieldLabel("직종"); 
		        
		        
		        layoutContainer_212.add(creDeptGpCd, new FormData("100%")); 
		               
		      	LayoutContainer layoutContainer15 = new LayoutContainer();
		     	frmlytSch = new FormLayout(); 
		     	frmlytSch.setDefaultWidth(0);
//		       	frmlytSch.setLabelWidth(65); 
		       	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		       	layoutContainer15.setLayout(frmlytSch);
		            
		      	creTypOccuCd = new MSFMultiComboBox<ModelData>();
		      	creTypOccuCd.setName("creTypOccuCd"); 
		       	creTypOccuCd.setEmptyText("--직종선택--"); 
		      	creTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		     	creTypOccuCd.getStore().add(mDtalistcrTypOccuCd);
		     	creTypOccuCd.setWidth(100);
		     	creTypOccuCd.setHideLabel(true);
//		      	creTypOccuCd.setFieldLabel("직종");
		      	creTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		      	creTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		     	creTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
		     		public void handleEvent(StoreEvent<ModelData> be) {  
		     			EventType type = be.getType();
		     			if (type == Store.Add) { 
		     				/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		     				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
		     				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		     				 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					     		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		     				//checkYeta0100Auth("creTypOccuCd", lscrTypOccuCd); 
		     			}
		     		}
		     	});     
		            
		     	creTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
		     		@Override
		     		public void handleEvent(ComponentEvent ce) { 
		     			if ((creTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(creEmymtDivCd,"commCd")))) {
		                                
		     				//직종변경에 따른 직종세 값 가져오기
		     				List<ModelData> mdListSelect =  creTypOccuCd.getListView().getChecked();  
		                                
		                	String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
		                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
//		                    sysComBass0350Dto.setPyspGrdeCd(PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
		                                
		                    if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
		                                    
		                    	lscrDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
		                    	//  creDtilOccuInttnCd.setStore(lscrDtilOccuInttnCd); 
		                    	lscrDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
		                    		public void handleEvent(StoreEvent<BaseModel> be) {  
		                    			mDtalistcrDtilOccuInttnCd = YetaUtils.getDtilOccuClsDivCdModelData(lscrDtilOccuInttnCd) ; 
		                    			creDtilOccuInttnCd.getInitStore().add(mDtalistcrDtilOccuInttnCd);
		                        		}
		                    		});     
		                    	} 
		     			} else {
		     				
		     			} 
		     		}  
		     	});  
		             
		     	creTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
		     		@Override
		     		public void handleEvent(ComponentEvent ce) {   
		     			if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//		                       // GWT.log(" a" + ce.getEvent().getType());
		     				mutilCombo = true;
		     			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
		     				mutilCombo = true;
//		                      //  GWT.log(" b" + ce.getEvent().getType());
		     			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//		     				mutilcrCombo = false;
//		                      //  GWT.log(" b" + ce.getEvent().getType());
		     			}  
		     		} 
		     	});
		           
		     	layoutContainer15.add(creTypOccuCd, new FormData("100%")); 
		            
		     	
		     	
		     	LayoutContainer layoutContainer16 = new LayoutContainer();
		     	frmlytSch = new FormLayout();  
		       	frmlytSch.setLabelWidth(0); 
		       	frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		     	frmlytSch.setDefaultWidth(0);
		     	layoutContainer16.setLayout(frmlytSch);
		            
		     	/** column 직종세코드 : dtilOccuInttnCd */  
		       	creDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		     	creDtilOccuInttnCd.setName("creDtilOccuInttnCd"); 
		    	creDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
		       	creDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
		       	creDtilOccuInttnCd.getStore().add(mDtalistcrDtilOccuInttnCd);
		      	creDtilOccuInttnCd.setWidth(100);
		    	creDtilOccuInttnCd.setHideLabel(true);
		    	creDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		    	creDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		       	creDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
		       		@Override
		         	public void handleEvent(ComponentEvent ce) {    
		       			if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
		       				mutilCombo = true;
		       			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
		       				mutilCombo = true;
//		                      //  GWT.log(" b" + ce.getEvent().getType());
		       			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
		       				mutilCombo = false;
//		                      //  GWT.log(" b" + ce.getEvent().getType());
		             	} else {
		                       
		             	}  
		       		} 
		       	});
		            
		       	layoutContainer16.add(creDtilOccuInttnCd, new FormData("100%")); 
		       	
		       	
		    	crTypOccuCd.add(layoutContainer_212,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31)); 
		       	crTypOccuCd.add(layoutContainer15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		       	crTypOccuCd.add(layoutContainer16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));		            
		       	layoutContainer15.setBorders(false);
		       	layoutContainer2_1.add(crTypOccuCd, new FormData("100%")); 
			    
		       	
		       	/** column 사업 : BusinCd */
		    	LayoutContainer layoutContainer17 = new LayoutContainer();
		       	
		       	FormLayout frm4 = new FormLayout();
		       	frm4.setLabelWidth(60);
		       	frm4.setLabelAlign(LabelAlign.RIGHT);
		       	layoutContainer17.setLayout(frm4);
		       	
		       	creBusinCd = new MSFComboBox<BaseModel>();
		        creBusinCd.setName("creBusinCd");
		        creBusinCd.setFieldLabel("사업");
		        creBusinCd.setForceSelection(true);
		        creBusinCd.setMinChars(1);
		        creBusinCd.setDisplayField("businNm");
		        creBusinCd.setValueField("businCd");
		        creBusinCd.setTriggerAction(TriggerAction.ALL);
		        creBusinCd.setEmptyText("--사업선택--");
		        creBusinCd.setSelectOnFocus(true);
		        creBusinCd.setStore(lscrBusinCd); 
//		        creBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		        creBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		        creBusinCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		        		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		        		BaseModel bmPayCd =  se.getSelectedItem(); 
		        		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
		        			creBusinCd.setValue(lscrBusinCd.findModel("businCd",bmPayCd.get("businCd")) );
		        		}  
		        	} 
		        });
		            
		        layoutContainer17.add(creBusinCd, new FormData("100%"));   
		        
		        
		        
		        LayoutContainer layoutContainer18 = new LayoutContainer();
		       	
		       	frm4 = new FormLayout();
		       	frm4.setLabelWidth(60);
		       	frm4.setLabelAlign(LabelAlign.RIGHT);
		       	layoutContainer18.setLayout(frm4);
		        
		       
		       	ButtonBar buttonBar = new ButtonBar();    
		       	buttonBar.setAlignment(HorizontalAlignment.RIGHT);
				    
		       	Button topBtn = new Button("대상자생성");  
		    	buttonBar.add(topBtn);
		       	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			
		    			
		    			  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(creYear, "year"))) {
		    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "생성정산년도를 선택하십시요.", null); 
		    				  return;
		    			  }
		    			  
		    			  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(creCalcSevePayPsnDivCd, "commCd"))) {
		    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "정산구분을 선택하십시요.", null); 
		    				  return;
		    			  } 
		    			   
							          
		    			   MessageBox.confirm("연말정산 대상자생성", "생성년도의 데이터가 존재하는경우 삭제 후 \n" + 
						             "신규로 데이터가 생성됩니다.(개별대상자가선택경우단건생성) \n"+
						            "정산 자료를 신규로 생성하시겠습니까?",new Listener<MessageBoxEvent>(){
				                  @Override
				                  public void handleEvent(MessageBoxEvent be) {
				                   //   if("Yes".equals(be.getButtonClicked().getText())){
				                	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
				                          //급여 배치 호출 
	                                       
				                           Payr06420_All_Create(); 
				                              
				                      }
				                  }
				              }); 
		    			   
		    		  
		    		}
		    	});
		       	
		    	Button topBtn1 = new Button("누락대상자추가생성");  
		    	buttonBar.add(topBtn1);
		    	topBtn1.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			
		    			
		    			  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(creYear, "year"))) {
		    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "생성정산년도를 선택하십시요.", null); 
		    				  return;
		    			  }
		    			  
		    			  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(creCalcSevePayPsnDivCd, "commCd"))) {
		    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "정산구분을 선택하십시요.", null); 
		    				  return;
		    			  } 
		    			   
							          
		    			   MessageBox.confirm("연말정산 누락대상자생성", "생성조건에 따른 누락 추가대상자에 대해 \n" + 
						             "신규로 데이터가 생성됩니다.(개별대상자가선택경우단건생성) \n"+
						            "정산 자료를 생성하시겠습니까?",new Listener<MessageBoxEvent>(){
				                  @Override
				                  public void handleEvent(MessageBoxEvent be) {
				                    //  if("Yes".equals(be.getButtonClicked().getText())){
				                	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
				                          //급여 배치 호출 
	                                       
				                           Payr06420_All_Add_Create(); 
				                              
				                      }
				                  }
				              }); 
		    			   
		    		  
		    		}
		    	});
		        
		       	layoutContainer18.add(buttonBar);      
	  
			    plFrmYeta0100.add(fieldSet_2);	

//			    lcSchCol1.add(layoutContainer1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));   	// 정산년,월
//			    lcSchCol1.add(layoutContainer3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 		// 단위기관
//			    lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38)); 		// 고용구분
//			    lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 	// 성명, 주민등록번호
//			    
//			    
//			    lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 		// 정산구분
//			    lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 		// 부서
//			    lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.38)); 	// 직종
//			    lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22)); 		// 사업
//			    
//			    
//			    lcSchCol2.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 				// 년도
//			    lcSchCol2.add(layoutContainer13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));  	// 정산구분
//			    lcSchCol2.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));  	// 단위기관			    
//			    lcSchCol2.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));  	// 고용구분
//			    
//			    
//			    lcSchCol2.add(layoutContainer14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));  	// 부서			    
//			    lcSchCol2.add(layoutContainer2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));  	// 직종
//			    lcSchCol2.add(layoutContainer17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));  	// 사업
			    
			    lcSchCol1.add(layoutContainer1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));   	// 정산년,월
			    lcSchCol1.add(layoutContainer3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 단위기관
			    lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 		// 고용구분
			    
			    
			    
			    lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 정산구분
			    lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 부서
			    lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
			    
			    
			    lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 사업
			    lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 성명, 주민등록번호
			    lcSchCol1.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 
			    
			    
			    
			    
			    lcSchCol2.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 				// 년도
			    lcSchCol2.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));  	// 단위기관			    
			    lcSchCol2.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));  	// 고용구분
			    
			    lcSchCol2.add(layoutContainer13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));  	// 정산구분
			    lcSchCol2.add(layoutContainer14, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));  	// 부서			    
			    lcSchCol2.add(layoutContainer2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));  	// 직종
			    
			    
			    lcSchCol2.add(layoutContainer17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));  	// 사업
			    lcSchCol2.add(layoutContainer18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));  	// 대상자생성, 급여자료이관 버튼
			    
		  }	  
			  

class Tracker 
{
    public boolean status = false;
    public boolean getStatus(){return status;}
    public void setStatus(boolean stat){status = stat;}
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
		
		
		private void createMsfGridForm() {
		    //연말정산대상자 및 내역
			
			FieldSet fieldSetGrd = new FieldSet();  
		    fieldSetGrd.setHeadingHtml("연말정산대상자 및 내역");
		    
		    
			   ContentPanel cp01 = new ContentPanel();   
		  	   cp01.setBodyBorder(false); 
		  	   cp01.setHeaderVisible(false);   
		  	   cp01.setLayout(new FitLayout());      
		  	   cp01.setSize(960, 390);

				
			    yeta2000GridPanel = new MSFGridPanel(yeta2000def, false, false, false, false,false);
			  //  yeta2000GridPanel.setSize(960, 400);
			    yeta2000GridPanel.setHeaderVisible(false); 
			    yeta2000GridPanel.setBorders(true);
			  //  yeta2000GridPanel.getBottomComponent().setVisible(false);
		 
				 
//				 	  

			  cp01.add(yeta2000GridPanel);   
		  	   
		 		 
			  cp01.addButton(new Button("대상자개별생성", new SelectionListener<ButtonEvent>() {   
				        @Override  
				        public void componentSelected(ButtonEvent ce) { 
				        	
				        	  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"))) {
			    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "정산년도를 선택하십시요.", null); 
			    				  return;
			    			  }
			    			  
			    			  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd, "commCd"))) {
			    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "정산구분을 선택하십시요.", null); 
			    				  return;
			    			  } 
			    			  
			    			  if (yeta2000GridPanel.getMsfGrid().getStore().getCount() <= 0) {
			    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "개별 대상자 생성은 조회 후 가능합니다.", null); 
			    				  return;
			    			  } 
								          
			    			   MessageBox.confirm("연말정산 개별대상자생성", "생성년도의 데이터가 존재하는경우 삭제 후 \n" + 
							             "신규로 데이터가 생성됩니다.(개별대상자가선택경우단건생성) \n"+
							            "개별 정산 자료를  생성하시겠습니까?",new Listener<MessageBoxEvent>(){
					                  @Override
					                  public void handleEvent(MessageBoxEvent be) {
					                     // if("Yes".equals(be.getButtonClicked().getText())){
					                	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

					                    	  fnPopupSelfCreatePsnl0100(); 
					                              
					                      }
					                  }
					           }); 
 
				        }   
				      }));  
				     
				      cp01.addButton(new Button("급여자료이관", new SelectionListener<ButtonEvent>() {   
				        @Override  
				        public void componentSelected(ButtonEvent ce) {   
				           
 			              if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"))) {
		    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "정산년도를 선택하십시요.", null); 
		    				  return;
		    			  }
		    			  
		    			  if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd, "commCd"))) {
		    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "정산구분을 선택하십시요.", null); 
		    				  return;
		    			  } 
		    			  
		    			  if (yeta2000GridPanel.getMsfGrid().getStore().getCount() <= 0) {
		    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "급여자료이관은 조회 후 가능합니다.", null); 
		    				  return;
		    			  } 
							          
		    			   MessageBox.confirm("급여자료이관", "급여 데이타가 생성년도에 존재하는경우 삭제 후 \n" + 
						             "신규로급여 데이타가 이관 생성됩니다. \n"+
						            "연말정산 급여 자료를 이관 하시겠습니까?",new Listener<MessageBoxEvent>(){
				                  @Override
				                  public void handleEvent(MessageBoxEvent be) {
				                    //  if("Yes".equals(be.getButtonClicked().getText())){
				                	  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

				                           PayrExec_Yeta_Insert(); 
				                              
				                      }
				                  }
				           }); 	 
				        	
				        }   
				      }));  
	  
	    	
			fieldSetGrd.add(cp01);
			plFrmYeta0100.add(fieldSetGrd);
		}

		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
		
		private void Payr06420_SelfAll_Create() {
			 
			if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		         return;
		     }
			
			savePayr06420_SelfAll_Create();
			
		}
		private void fnPopupSelfCreatePsnl0100() {
			// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
			// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
			// 검색.처리하면됨.
			MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사

			final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

			popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					BaseModel mapModel = (BaseModel) be.getSource();
					if (!"".equals(mapModel.get("systemkey"))) {
						systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); 		// 시스템키 
						Payr06420_SelfAll_Create(); 
					}
				}
			});
		}
		private void fnPopupPsnl0100() {
			// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
			// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
			// 검색.처리하면됨.
			MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사

			final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

			popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					BaseModel mapModel = (BaseModel) be.getSource();
					if (!"".equals(mapModel.get("systemkey"))) {
						srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); // 시스템키
						srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
						srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum"))); // 주민번호
						 
					}
				}
			});
		}	
		 
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 종료
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
		
		 //폼초기화 검색조건포함 
		   private void formInit() {
		       
//		    edSETT_GBNM.Text := '';
//			lblSETT_GBCD01.Caption := '';
//			edEDAC_RVYY.Text := IntToStr(StrToInt(leftStr(DateToStr(Date),4)) - 1);
//			edKORN_NAME.Text := '';
//			lblPSNL_NUMB.Caption := '';
//
//			Payr06420_OnMenuInit;
//			_MethodAction := 'insert';
		       
	        //remtPayr0100GridPanel.getMsfGrid().clearData();  
		      
		   }
		
		   public void setRecord(BaseModel record) {
		       this.record = record;
		   }
		 
		
		   public void setPPRecord(BaseModel ppRecord) {
		       this.ppRecord = ppRecord;
		   }
		   
 		   public void setListRecord(Iterator<Record> records) {
				    this.records = records;
		   }
			  
  	       public Iterator<Record>  getListRecord() {
		          return this.records;
		   }
	  

		   private Yeta0100 getThis(){
		       return this;
		   }
		   
		   private void reloadYeta0100(){
				 
			   IColumnFilter filters = null;
			   yeta2000GridPanel.getTableDef().setTableColumnFilters(filters);
				 
				//정산년
			   yeta2000GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhClutYr,"year") , SimpleColumnFilter.OPERATOR_EQUALS); 
			        
				//정산구분
			   yeta2000GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			          
			   yeta2000GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			   yeta2000GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			
			   String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			   yeta2000GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
	            
	           String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	           yeta2000GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	             
	         //    String strPyspGrdeCd = RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
	          //   remt2000DefGridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
	             
	           String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	           yeta2000GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		       
	           yeta2000GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				   
	             
	           yeta2000GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
	           yeta2000GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
	           yeta2000GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
				
	           yeta2000GridPanel.reload();  
			   
		   }
		   
		   
		   //엑셀 양식 저장
		   private void xlsExportData() {
				                    
			   HashMap<String, String> param = new HashMap<String, String>(); 
				   
				param.put("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));//귀속년도
				param.put("settGbcd", MSFSharedUtils.getSelectedComboValue(srhCalcSevePayPsnDivCd,"commCd"));//정산구분
				param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));//단위기관
				param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));//고용구분
				param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));//부서
				param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));//직종
				param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));//직종세
				param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
				param.put("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
				param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
				param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
				                     
							           
				if("".equals(srhClutYr)){
					MessageBox.info("", "년도는 필수 입니다.", null);
					
				}else  if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
					if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){ 
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
					} else { 
						yeta2000GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta0100Export.do","extgwtFrame" ,param);   
					}
				}else{ 
					yeta2000GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta0100Export.do","extgwtFrame" ,param);  
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
