package com.app.exterms.yearendtax.client.form.yeta2017;

import java.util.ArrayList;
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
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta1000Def;
import com.app.exterms.yearendtax.client.languages.YetaConstants;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0100Service;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0100ServiceAsync;
import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2500Service;
import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2500ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
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
public class Yeta2500   extends MSFPanel {

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    private YetaConstants lblYetaConst = YetaConstants.INSTANCE; 
    
    private VerticalPanel vp;
    private FormPanel plFrmYeta2500; 
    private String txtForm = "";
    private XTemplate detailTp;
 
    private Yeta1000Def yeta1000def = new Yeta1000Def("YETA2500");
    private MSFGridPanel msfGridPanel;
  
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
   private ButtonBar topYeta2500Bar;
   private Button btnYeta2500Init; 
//   private Button btnYeta0100Save;
//   private Button btnYeta0100Del;
   private Button btnYeta2500Sreach;
//   private Button btnYeta0100Print;
   private Button btnYeta2500Excel;
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
    	private MSFComboBox<BaseModel> srhYrtxBlggYr;				//정산년
    	//private ComboBox<BaseModel> srhClutMnth;				//정산월
    	private MSFComboBox<BaseModel> srhClutSeptCd;     			//정산구분
    	private ComboBox<BaseModel> srhPayrMangDeptCd; 			//단위기관
    	private TextField<String> srhHanNm;        				//성명
    	private TextField<String> srhResnRegnNum;   			//주민번호 
    	private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분
    	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드  
    	private MSFMultiComboBox<ModelData> srhDeptCd; 			//부서
    	private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	
    	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
		private ComboBox<BaseModel> srhBusinCd; 				//사업
		private HiddenField<String> srhSystemkey;   			//시스템키 
		private ComboBox<BaseModel> srhItem14;					//금액(환급차액)
    	      
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
	// -------------- 서비스 호출 시작 --------------
	private Yeta0100ServiceAsync yeta0100Service = Yeta0100Service.Util.getInstance();
	private Yeta2500ServiceAsync yeta2500Service = Yeta2500Service.Util.getInstance();
	// -------------- 서비스 호출 종료 -------------- 
	
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
      private ListStore<BaseModel> listStoreY010 = new ListStore<BaseModel>(); 			// 금액 구분 
   // -------------- stroe [검색부]선언 시작 -------------- 
	    
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
	  	private void checkYeta2500Auth( String authAction, ListStore<BaseModel>bm) {
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
			 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
			 gwtAuthorization.formAuthFieldConfig(fldArrField);
			 
			 srhYrtxBlggYr.setValue(lsClutYrStore.findModel("year",String.valueOf(Integer.parseInt(DateTimeFormat.getFormat("yyyy").format(new Date())) - 1)));
			 srhClutSeptCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
          
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  * 권한설정을 위한 콤보처리를 위한 메서드 종료
			  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
		
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
//	    private void doAction(ActionDatabase actionDatabase) {
//	        switch (actionDatabase) {
//	        case INSERT:
//	        	//saveStandData(); 
//	            break;
//	        case UPDATE:
//	        	//saveStandData(); 
//	            break;
//	        case DELETE:
//	        	//Payr06420_menuDelete();	
//	            break;
//	        }
//	    }
		
	    
		  /**
	     * 데이타를 삭제한다.
	     */
//	    private void Payr06420_menuDelete() {
//	        
//	       
//	        MessageBox.confirm("연말정산 대상자 삭제", "선택된 데이타를 삭제 하시겠습니까?<br>(연말정산 대상자를 삭제합니다.)",new Listener<MessageBoxEvent>(){
//	            @Override
//	             public void handleEvent(MessageBoxEvent be) {
//	                 if("Yes".equals(be.getButtonClicked().getText())){
//	             
//	                	 Iterator<BaseModel> itBm  = msfGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//				          
//				          List<Record>  lsRec  = new ArrayList<Record>();
//				          
//				          while(itBm.hasNext()) {
//				
//				              Record rec  = new Record(itBm.next()); 
//				              lsRec.add(rec);
//				              
//				          } 
//				         
//				          setListRecord(lsRec.iterator()); 
//				           
//				   if (MSFSharedUtils.paramNotNull(records)) {           
//	                	  List<Ye161010DTO> listYe161010Dto = new ArrayList<Ye161010DTO>();  
//       	               
//       	               while (records.hasNext()) {
//       	             
//       	                  Record record = (Record) records.next(); 
//       	                  BaseModel bmMapModel = (BaseModel)record.getModel();
//       	                     
//       	                  Ye161010DTO ye161010Dto = new Ye161010DTO();   
//       	                
////       	  				remt2300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
////       	  				remt2300Dto.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("calcSevePayPsnDivCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
////       	  				remt2300Dto.setClutYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("clutYrMnth")));    /** column 정산년월 : clutYrMnth */
////       	  				remt2300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
////       	  				remt2300Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
////       	  				remt2300Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
////       	  				remt2300Dto.setPymtSum((Long)bmMapModel.get("pymtSum") );    /** column 지급금액 : pymtSum */
//
//
//							ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//							ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    /** column 연말정산귀속년도 : yrtxBlggYr */
//							ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    /** column 정산구분코드 : clutSeptCd */
//							ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//							ye161010Dto.setEdacSeilNum((Long)bmMapModel.get("edacSeilNum"));    /** column 연말정산마감일련번호 : edacSeilNum */
//							ye161010Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
//							ye161010Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
//							ye161010Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    /** column 한글성명 : hanNm */
//							ye161010Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
//							ye161010Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
//							ye161010Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
//							ye161010Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
//							ye161010Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
//							ye161010Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
//							ye161010Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    /** column 직책코드 : odtyCd */
//							ye161010Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    /** column 호봉코드 : pyspCd */
//							ye161010Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//							ye161010Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
//							ye161010Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
//							ye161010Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
//							ye161010Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
//							ye161010Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
//							ye161010Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
//							ye161010Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    /** column 퇴직일자 : retryDt */
//							ye161010Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));    /** column 연말정산적용년월 : yrtxApptnYrMnth */
//							ye161010Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));    /** column 연말정산처리일자 : yrtxPrcsDt */
////							ye161010Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
//							ye161010Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    /** column 연말정산처리여부 : yrtxPrcsYn */
//							ye161010Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    /** column 분할납부구분코드 : divdPymtDivCd */
//							ye161010Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    /** column 분할납부횟수 : divdPymt */ 
// 
//       	                  
//       	               listYe161010Dto.add(ye161010Dto);
//       	                 
//       	               }    
//	                       
//       	            yeta0100Service.Payr06420_Payr400_Delete(listYe161010Dto ,
//	                               new AsyncCallback<Long>() {
//	                       public void onFailure(Throwable caught) {
//	                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("Payr06420_Payr400_Delete(삭제) : " + caught), null);
//	                       }
//	                       public void onSuccess(Long result) { 
//	                       if (result == 0) {
//	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//	                                  "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//	                       } else {
//	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//	                                   "삭제처리가 완료되었습니다.", null);
//	                        
//	                          reloadYeta2500();
//	                          
//	                       } 
//	                       } 
//	                       });
//				       } else {
//	  	  	              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//	  	  	              return;
//	  	  	          } 
//	                 }  
//	            }
//	            
//	        });
//	        
//	        
//	    }    
	    
	    
//	    private void PayrExec_Yeta_Insert() {
//	        
//	 
//            	 Iterator<BaseModel> itBm  = msfGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//		          
//		          List<Record>  lsRec  = new ArrayList<Record>();
//		          
//		          while(itBm.hasNext()) {
//		
//		              Record rec  = new Record(itBm.next()); 
//		              lsRec.add(rec);
//		              
//		          } 
//		         
//		          setListRecord(lsRec.iterator()); 
//				           
//				   if (MSFSharedUtils.paramNotNull(records)) {           
//	                	  List<Ye161010DTO> listYe161010Dto = new ArrayList<Ye161010DTO>();  
//       	               
//       	               while (records.hasNext()) {
//       	             
//       	                  Record record = (Record) records.next(); 
//       	                  BaseModel bmMapModel = (BaseModel)record.getModel();
//       	                     
//       	                  Ye161010DTO ye161010Dto = new Ye161010DTO();    
//
//							ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//							ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    /** column 연말정산귀속년도 : yrtxBlggYr */
//							ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    /** column 정산구분코드 : clutSeptCd */
//							ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//							ye161010Dto.setEdacSeilNum((Long)bmMapModel.get("edacSeilNum"));    /** column 연말정산마감일련번호 : edacSeilNum */
//							ye161010Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));    /** column 급여관리부서코드 : payrMangDeptCd */
//							ye161010Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
//							ye161010Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    /** column 한글성명 : hanNm */
//							ye161010Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
//							ye161010Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    /** column 부서코드 : deptCd */
//							ye161010Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
//							ye161010Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
//							ye161010Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
//							ye161010Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
//							ye161010Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    /** column 직책코드 : odtyCd */
//							ye161010Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    /** column 호봉코드 : pyspCd */
//							ye161010Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//							ye161010Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
//							ye161010Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
//							ye161010Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
//							ye161010Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
//							ye161010Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
//							ye161010Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    /** column 재직구분코드 : hdofcDivCd */
//							ye161010Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    /** column 퇴직일자 : retryDt */
//							ye161010Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));    /** column 연말정산적용년월 : yrtxApptnYrMnth */
//							ye161010Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));    /** column 연말정산처리일자 : yrtxPrcsDt */
////							ye161010Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
//							ye161010Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    /** column 연말정산처리여부 : yrtxPrcsYn */
//							ye161010Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    /** column 분할납부구분코드 : divdPymtDivCd */
//							ye161010Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    /** column 분할납부횟수 : divdPymt */ 
// 
//       	                  
//       	               listYe161010Dto.add(ye161010Dto);
//       	                 
//       	               }    
//	                       
//       	            yeta0100Service.PayrExec_Yeta_Insert(listYe161010Dto ,
//	                               new AsyncCallback<Long>() {
//	                       public void onFailure(Throwable caught) {
//	                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("PayrExec_Yeta_Insert(급여자료이관) : " + caught), null);
//	                       }
//	                       public void onSuccess(Long result) { 
//	                       if (result == 0) {
//	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
//	                                  "급여자료이관이 완료되지 않았습니다. 데이타를 확인하십시요.", null);
//	                       } else {
//	                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//	                                   "급여자료이관 처리가 완료되었습니다.", null);
//	                        
//	                          reloadYeta2500();
//	                          
//	                       } 
//	                       } 
//	                       });
//				       } else {
//	  	  	              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
//	  	  	              return;
//	  	  	          }  
//	        
//	    }  
//	    
	    

	  
	    
	    
	    
	     
		
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
	  		vp = new VerticalPanel();
	  		vp.setSpacing(10);
	  		createYeta0100Form();	//화면 기본정보를 설정
	  		createSearchForm();		//검색조건		
	  		createMsfGridForm();	//그리드설정
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
		public Yeta2500() {
			setSize("1600px", "700px");  
		} 

		public Yeta2500(String txtForm) {
		      this.txtForm = txtForm;
		}
	  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/		  
		private void createYeta0100Form() {
			
			plFrmYeta2500 = new FormPanel(); 
			plFrmYeta2500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산급여반영"));
			plFrmYeta2500.setIcon(MSFMainApp.ICONS.text());
			plFrmYeta2500.setPadding(2);
			plFrmYeta2500.setFrame(true); 
			
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage("연말정산급여반영","YETA2500");
					}
				});
			plFrmYeta2500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmYeta2500.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/
 
		     //멀티콤보박스 닫기 
			plFrmYeta2500.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
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
                            } 
	                   }
                    //    }
	            //    } 
	            } 
	        });
	        
			/** 상단 버튼 ButtonBar**/
			topYeta2500Bar = new ButtonBar();    
			topYeta2500Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
			btnYeta2500Init = new Button("초기화");  
			btnYeta2500Init.setIcon(MSFMainApp.ICONS.new16());
			topYeta2500Bar.add(btnYeta2500Init); 
			btnYeta2500Init.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//초기화 
	    			formInit();
	    		}
	        });  
		      
			btnYeta2500Sreach = new Button("조 회");  
			btnYeta2500Sreach.setIcon(MSFMainApp.ICONS.search());
			topYeta2500Bar.add(btnYeta2500Sreach);
			btnYeta2500Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//조회버튼 클릭시 처리 
	    			reloadYeta2500();  
	    		}
	    	});
//			btnYeta0100Print = new Button("인 쇄");  
//			btnYeta0100Print.setIcon(MSFMainApp.ICONS.print16());
//			topYeta2500Bar.add(btnYeta0100Print);	
			
//			btnYeta0100Print = new Button("인 쇄");  
//			btnYeta0100Print.setIcon(MSFMainApp.ICONS.print16());
//			topYeta2500Bar.add(btnYeta0100Print);	
			
			btnYeta2500Excel = new Button("엑 셀");  
			btnYeta2500Excel.setIcon(MSFMainApp.ICONS.excel16());
			topYeta2500Bar.add(btnYeta2500Excel);
			btnYeta2500Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//엑셀 저장
	    			xlsExportData();  
	    		}
	    	});
			
			
			
 
			plFrmYeta2500.add(topYeta2500Bar);
		      
			//파일업로드 처리
			plFrmYeta2500.setAction("myurl");
			plFrmYeta2500.setEncoding(Encoding.MULTIPART);
			plFrmYeta2500.setMethod(Method.POST);		         
			vp.add(plFrmYeta2500);	
			
			plFrmYeta2500.setSize("990px", "680px");	      
			plFrmYeta2500.setLayout(new FlowLayout());
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
		    //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		     
		    //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		    sysComBass0300Dto.setRpsttvCd("Y002");
		    lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);//정산구분
		     
		    sysComBass0300Dto.setRpsttvCd("Y002");
		    lsCrCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);//정산구분 
		    
		    sysComBass0300Dto.setRpsttvCd("A002");
		    lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);			//고용구분_검색조건
		    
		    /**
		     * Y0100001	Y010	0001	전체
		     * Y0100002	Y010	0002	10만원 이상
		     * Y0100003	Y010	0003	10만원 이하
		     * Y0100004	Y010	0004	환급금
			 * Y0100005	Y010	0005	환수금
		     * **/
		    sysComBass0300Dto.setRpsttvCd("Y010");
		    listStoreY010 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);		//금액구분
		    
			
			sysComBass0300Dto.setRpsttvCd("A048");
			lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);	//호봉
		    
		    
		    sysComBass0300Dto = new PrgmComBass0300DTO();
		    sysComBass0300Dto.setRpsttvCd("A002");
		    
		    
		     //--------------------정산년도 불러 오는 함수 ------------------------------------------------
		     lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		     //--------------------정산년도 불러 오는 함수 ------------------------------------------------
		     
   
		     
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
//		  	plFrmYeta2500.add(typOccuCdGrid);

		      lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            public void handleEvent(StoreEvent<BaseModel> be) {  
		             
	                 mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
	                 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
	                  
	               }
	           });  
			   
			   
		  	srhSystemkey = new HiddenField<String>(); 
			plFrmYeta2500.setLayout(new FlowLayout());
		    
		     
		      
		      
			  FieldSet fieldSet = new FieldSet();  
			  fieldSet.setHeadingHtml("검색조건");
		        /****************************************************************
				 * 검색조건 배경 변경 스타일시트 추가 시작
				 ****************************************************************/
				fieldSet.addStyleName("x-fieldset-serarch-back-color");
				/****************************************************************
				 * 검색조건 배경 변경 스타일시트 추가 끝
				 ****************************************************************/
			  fieldSet.setHeight("95px");   			  

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
			  
			    srhYrtxBlggYr = new MSFComboBox<BaseModel>();
			    srhYrtxBlggYr.setName("srhYrtxBlggYr");
			    srhYrtxBlggYr.setForceSelection(true);
			    srhYrtxBlggYr.setMinChars(1);
			    srhYrtxBlggYr.setDisplayField("yearDisp");
			    srhYrtxBlggYr.setValueField("year");
			    srhYrtxBlggYr.setTriggerAction(TriggerAction.ALL);
			    srhYrtxBlggYr.setSelectOnFocus(true); 
			    srhYrtxBlggYr.setReadOnly(true);
			    srhYrtxBlggYr.setEnabled(true); 
			    srhYrtxBlggYr.setStore(lsClutYrStore);
			    srhYrtxBlggYr.setFieldLabel("정산년도"); 
			    srhYrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						
					}
				});
				srhYrtxBlggYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
					public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
						// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
						BaseModel bmClutYr = se.getSelectedItem();
						if (bmClutYr != null) {
							if ((srhDeptCd.getListView().getChecked().size() == 1)
											&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {

									if (srhDeptCd.getListView().getChecked().size() > 0) {
											sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));
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
			    layoutContainer1.add(srhYrtxBlggYr, new FormData("100%"));
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
			        	checkYeta2500Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
				    		   checkYeta2500Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
			                  
			                   sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));    
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
						srhTypOccuCd.setEnabled(true);
						srhDtilOccuInttnCd.setEnabled(true);
						
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
			    
			    
			    /** column 정산구분 : CalcSevePayPsnDivCd */ 
			    LayoutContainer layoutContainer7 = new LayoutContainer();
			    layoutContainer7.setBorders(false);		
			    
			    frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
			    layoutContainer7.setLayout(frmlytSch);
			    
			    srhClutSeptCd =  new MSFComboBox<BaseModel>(); 
			    srhClutSeptCd.setName("srhClutSeptCd");
			    srhClutSeptCd.setForceSelection(true);
			    srhClutSeptCd.setMinChars(1);
			    srhClutSeptCd.setDisplayField("commCdNm");
			    srhClutSeptCd.setValueField("commCd");
			    srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
			    srhClutSeptCd.setEmptyText("--정산구분선택--");
			    srhClutSeptCd.setSelectOnFocus(true); 
			    srhClutSeptCd.setReadOnly(true);
			    srhClutSeptCd.setEnabled(true); 
			    srhClutSeptCd.setStore(lsCalcSevePayPsnDivCd);
			    srhClutSeptCd.setFieldLabel("정산구분");
			    srhClutSeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			        public void handleEvent(StoreEvent<BaseModel> be) {  
			        	
			        }
			    });  			    
			    layoutContainer7.add(srhClutSeptCd, new FormData("100%"));
			    
			    
			    
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
				    		   checkYeta2500Auth("srhDeptCd", lsDeptCd); 
			           	 }
			         
			        }
			    });    

			    srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			       @Override
			      public void handleEvent(ComponentEvent ce) { 
			               
			                  if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
			                     
			                      if (srhDeptCd.getListView().getChecked().size() > 0) {  
			                         
			                          sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr,"year"));    
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
				    		 //  checkYeta2500Auth("srhTypOccuCd", lsTypOccuCd); 
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
			    
			    
			    /** column 금액 :  */
			    LayoutContainer layoutContainer10 = new LayoutContainer();
				frmlytSch = new FormLayout();  
			    frmlytSch.setLabelWidth(60); 
			    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			    layoutContainer10.setLayout(frmlytSch);
			    
			    srhItem14 = new ComboBox<BaseModel>();
			    srhItem14.setName("srhItem14");
			    srhItem14.setForceSelection(true);
			    srhItem14.setMinChars(1);
			    srhItem14.setDisplayField("commCdNm");
			    srhItem14.setValueField("commCd");
			    srhItem14.setTriggerAction(TriggerAction.ALL);
			    srhItem14.setEmptyText("--금액선택--");
			    srhItem14.setSelectOnFocus(true);  
			    srhItem14.getListView().setWidth("200px");
			    srhItem14.setStore(listStoreY010);
			    srhItem14.setFieldLabel("금액");
			    layoutContainer10.add(srhItem14, new FormData("100%"));
			    layoutContainer10.setBorders(false);	
			    
			    plFrmYeta2500.add(fieldSet);
			    
			  
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
//			    lcSchCol1.add(layoutContainer10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18)); 		// 금액
			    
			    
			    lcSchCol1.add(layoutContainer1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));   	// 정산년,월
			    lcSchCol1.add(layoutContainer3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 단위기관
			    lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 		// 고용구분
			    
			    
			    lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 정산구분
			    lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 부서
			    lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
			    
			    lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 사업
			    lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 성명, 주민등록번호
			    lcSchCol1.add(layoutContainer10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 금액
			    
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
		// 연말정산대상자 및 내역

		FieldSet fieldSetGrd = new FieldSet();
		fieldSetGrd.setHeadingHtml("연말정산대상자 및 내역");
		    
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(960, 490);
				
		msfGridPanel = new MSFGridPanel(yeta1000def, false, false, false, false, false);
		// msfGridPanel.setSize(960, 400);
		msfGridPanel.setHeaderVisible(false);
		msfGridPanel.setBorders(true);
		// msfGridPanel.getBottomComponent().setVisible(false);
		
//		GWTUtils.findColumnConfig(msfGridPanel, Ye161010BM.ATTR_DIVDPYMTDIVCD).setStyle("background-color:#F5F6CE;");
			    
		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
			@Override  
			public void componentSelected(ButtonEvent ce) { 
//				Iterator<BaseModel> itBm  = msfGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

				Iterator<Record> iterRecords = msfGridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
				
				
//				List<Record>  lsRec  = new ArrayList<Record>();
//		          
//				while(itBm.hasNext()) {
//		
//					Record rec  = new Record(itBm.next()); 
//					lsRec.add(rec);
//		              
//				} 
//				setListRecord(lsRec.iterator()); 
			        	
				if (MSFSharedUtils.paramNotNull(msfGridPanel.getCurrentlySelectedItem())) { 
		              
					List<Ye161010DTO> listYe161010dto = new ArrayList<Ye161010DTO>();
					
					while (iterRecords.hasNext()) {
						
//					while (records.hasNext()) {
		              
//						Record record = (Record) records.next(); 
//		                BaseModel bmMapModel = (BaseModel)record.getModel();
						
						
						Record recData = (Record) iterRecords.next(); 
						BaseModel bmMapModel = (BaseModel)recData.getModel();
		                      
		                Ye161010DTO ye161010Dto= new Ye161010DTO();  
		                      
		                ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
		                ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** SYSTEMKEY : systemkey */
		                ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    	/** column 연말정산귀속년도 : yrtxBlggYr */
		                ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    	/** column 정산구분코드 : clutSeptCd */
		                ye161010Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd$commCd")));/** column 분할납부구분코드 : divdPymtDivCd */
		                ye161010Dto.setDivdPymt("0");    	/** column 분할납부횟수 : divdPymt */
		                ye161010Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));		/** column 연말정산처리여부 : yrtxPrcsYn */
		                
		                listYe161010dto.add(ye161010Dto);
		                
		                //환급차액이 10만원 미만인 경우 수정 불가
						if ((Long) bmMapModel.get("item14") < 100000) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "환수금이 10만원 미만인 사람이 존재합니다. 10만원 미만인경우 분할납부 해당자가 아닙니다."
									+ "", null);
							return;
						}
					}  
		                
					if (listYe161010dto.size() <= 0) {
						MessageBox.alert("저장", "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
		                
					yeta2500Service.saveYeta2500Grid(listYe161010dto, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta2500Grid(" + "저장" + ") : " + caught), null);
						}
						public void onSuccess(Long result) { 
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "처리가 완료되었습니다.", null);
								reloadYeta2500();
							} 
						} 
		                   
					}); 
		              
				} else {
					MessageBox.alert("선택", "처리할 데이타가 존재하지 않습니다.", null);
					return;
				} 				
				
			}   
		}));  
			     
		cp01.addButton(new Button("2월급여반영", new SelectionListener<ButtonEvent>() {   
			@Override  
			public void componentSelected(ButtonEvent ce) {   
			           
				Iterator<BaseModel> itBm  = msfGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		          
				List<Record>  lsRec  = new ArrayList<Record>();
		          
				while(itBm.hasNext()) {
		
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
		              
				} 
				setListRecord(lsRec.iterator()); 
			        	
				if (MSFSharedUtils.paramNotNull(msfGridPanel.getCurrentlySelectedItem())) { 
					
//					Calendar c = Calendar.getInstance();
					String ntime = new String();
//					ntime = String.valueOf(c.get(Calendar.YEAR));
//					ntime += String.valueOf(c.get(Calendar.MONTH) + 1);
					
//					SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//					ntime = format.format(c.getTime());
					
					Date today = new Date(); 
	          	     // A custom date format
					DateTimeFormat fmt1 = DateTimeFormat.getFormat("yyyy"); 
					ntime = fmt1.format(today);
					
					DateTimeFormat fmt2= DateTimeFormat.getFormat("MM"); 
					ntime += fmt2.format(today)  ;
		              
					List<Ye161010DTO> listYe161010dto = new ArrayList<Ye161010DTO>();  
		                
					while (records.hasNext()) {
		              
						Record record = (Record) records.next(); 
		                BaseModel bmMapModel = (BaseModel)record.getModel();
		                      
		                Ye161010DTO ye161010Dto= new Ye161010DTO();  
		                      
		                ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
		                ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** SYSTEMKEY : systemkey */
		                ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")));    	/** column 연말정산귀속년도 : yrtxBlggYr */
		                ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd")));    	/** column 정산구분코드 : clutSeptCd */
		                  
		                ye161010Dto.setYrtxApptnYrMnth("201802");		/** column 연말정산적용년월 : yrtxApptnYrMnth */
		                ye161010Dto.setYrtxPrcsDt("");	/** column 연말정산처리일자 : yrtxPrcsDt */
		                ye161010Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));		/** column 연말정산처리여부 : yrtxPrcsYn */
//		                ye161010Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd$commCd")));/** column 분할납부구분코드 : divdPymtDivCd */
		                //ye161010Dto.setDivdPymt("0");    	/** column 분할납부횟수 : divdPymt */
		               
		                
		                listYe161010dto.add(ye161010Dto);
					}  
		                
					if (listYe161010dto.size() <= 0) {
						MessageBox.alert("저장", "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
		                
					yeta2500Service.activityOnYeta2500List(listYe161010dto, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta2500List(" + "2월급여반영" + ") : " + caught), null);
						}
						public void onSuccess(Long result) { 
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "처리가 완료되었습니다.", null);
								reloadYeta2500();
								actionDatabase = ActionDatabase.UPDATE;
							} 
						} 
		                   
					}); 
		              
				} else {
					MessageBox.alert("선택", "처리할 데이타가 존재하지 않습니다.", null);
					return;
				} 
				
			}   
		}));  
		
		cp01.addButton(new Button("3월급여반영", new SelectionListener<ButtonEvent>() {   
			@Override  
			public void componentSelected(ButtonEvent ce) {   
			           
				Iterator<BaseModel> itBm  = msfGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		          
				List<Record>  lsRec  = new ArrayList<Record>();
		          
				while(itBm.hasNext()) {
		
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
		              
				} 
				setListRecord(lsRec.iterator()); 
			        	
				if (MSFSharedUtils.paramNotNull(msfGridPanel.getCurrentlySelectedItem())) { 
					
					Date today = new Date(); 
					String ntime = new String();
	          	     // A custom date format
					DateTimeFormat fmt1 = DateTimeFormat.getFormat("yyyy"); 
					ntime = fmt1.format(today);
					
					DateTimeFormat fmt2= DateTimeFormat.getFormat("MM"); 
					if (Integer.parseInt(fmt2.format(today)) <= 10 ) {
						ntime += 0 + String.valueOf(Integer.parseInt(fmt2.format(today))+1) ;
				    }
					else {
						ntime += String.valueOf(Integer.parseInt(fmt2.format(today))+1) ;
				    }
					
//					Calendar c = Calendar.getInstance();
//					String ntime = new String();
//					ntime = String.valueOf(c.get(Calendar.YEAR));
//					
//					Window.alert(""+c.get(Calendar.MONTH));
//					if (c.get(Calendar.MONTH) <= 10 ) {
//						ntime += 0 + String.valueOf(c.get(Calendar.MONTH) + 1);
//				    }
//					else {
//						ntime += String.valueOf(c.get(Calendar.MONTH) + 1);
//				    }
//					SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//					ntime = format.format(c.getTime());
					
//					Date today = new Date(); 
	          	     // A custom date format
//					DateTimeFormat fmt1 = DateTimeFormat.getFormat("yyyy"); 
//					ntime = fmt1.format(today);
					
//					DateTimeFormat fmt2= DateTimeFormat.getFormat("MM") ; 
//					ntime += fmt2.format(today);
					
					
		              
					List<Ye161010DTO> listYe161010dto = new ArrayList<Ye161010DTO>();  
		                
					while (records.hasNext()) {
		              
						Record record = (Record) records.next(); 
		                BaseModel bmMapModel = (BaseModel)record.getModel();
		                      
		                Ye161010DTO ye161010Dto= new Ye161010DTO();  
		                      
		                ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
		                ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** SYSTEMKEY : systemkey */
		                ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")));    	/** column 연말정산귀속년도 : yrtxBlggYr */
		                ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd")));    	/** column 정산구분코드 : clutSeptCd */
		                
		                ye161010Dto.setYrtxApptnYrMnth("201803");		/** column 연말정산적용년월 : yrtxApptnYrMnth */
		                ye161010Dto.setYrtxPrcsDt("");	/** column 연말정산처리일자 : yrtxPrcsDt */
		                ye161010Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));		/** column 연말정산처리여부 : yrtxPrcsYn */
		              //  ye161010Dto.setDivdPymtDivCd("B0300010");/** column 분할납부구분코드 : divdPymtDivCd */
		              //  ye161010Dto.setDivdPymt("0");    	/** column 분할납부횟수 : divdPymt */
		               
		                
		                listYe161010dto.add(ye161010Dto);
					}  
		                
					if (listYe161010dto.size() <= 0) {
						MessageBox.alert("저장", "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
		                
					yeta2500Service.activityOnYeta2500List(listYe161010dto, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta2500List(" + "3월급여반영" + ") : " + caught), null);
						}
						public void onSuccess(Long result) { 
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "처리가 완료되었습니다.", null);
								reloadYeta2500();
								actionDatabase = ActionDatabase.UPDATE;
							} 
						} 
		                   
					}); 
		              
				} else {
					MessageBox.alert("선택", "처리할 데이타가 존재하지 않습니다.", null);
					return;
				} 
				
			}   
		}));  
		
		cp01.addButton(new Button("급여반영취소", new SelectionListener<ButtonEvent>() {   
			@Override  
			public void componentSelected(ButtonEvent ce) {   
			           
				Iterator<BaseModel> itBm  = msfGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		          
				List<Record>  lsRec  = new ArrayList<Record>();
		          
				while(itBm.hasNext()) {
		
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
		              
				} 
				setListRecord(lsRec.iterator()); 
			        	
				if (MSFSharedUtils.paramNotNull(msfGridPanel.getCurrentlySelectedItem())) { 
					
//					Calendar c = Calendar.getInstance();
					String ntime = new String();
//					ntime = String.valueOf(c.get(Calendar.YEAR));
//					ntime += String.valueOf(c.get(Calendar.MONTH) + 1);
					
//					SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//					ntime = format.format(c.getTime());
					
					Date today = new Date(); 
	          	     // A custom date format
					DateTimeFormat fmt1 = DateTimeFormat.getFormat("yyyy"); 
					ntime = fmt1.format(today);
					
					DateTimeFormat fmt2= DateTimeFormat.getFormat("MM"); 
					ntime += fmt2.format(today);
					
					
		              
					List<Ye161010DTO> listYe161010dto = new ArrayList<Ye161010DTO>();  
		                
					while (records.hasNext()) {
		              
						Record record = (Record) records.next(); 
		                BaseModel bmMapModel = (BaseModel)record.getModel();
		                      
		                Ye161010DTO ye161010Dto= new Ye161010DTO();  
		                      
		                ye161010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));			/** 사업장코드 : dpobCd */
		                ye161010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   /** SYSTEMKEY : systemkey */
		                ye161010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")));    	/** column 연말정산귀속년도 : yrtxBlggYr */
		                ye161010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd")));    	/** column 정산구분코드 : clutSeptCd */
		               
		                ye161010Dto.setYrtxApptnYrMnth("");			/** column 연말정산적용년월 : yrtxApptnYrMnth */
		                ye161010Dto.setYrtxPrcsDt("");				/** column 연말정산처리일자 : yrtxPrcsDt */
		                ye161010Dto.setYrtxPrcsYn(false);			/** column 연말정산처리여부 : yrtxPrcsYn */
		              //  ye161010Dto.setDivdPymtDivCd("B0300010");	/** column 분할납부구분코드 : divdPymtDivCd */
		              //  ye161010Dto.setDivdPymt("0");    			/** column 분할납부횟수 : divdPymt */
		               
		                listYe161010dto.add(ye161010Dto);
					}  
		                
					if (listYe161010dto.size() <= 0) {
						MessageBox.alert("저장", "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
		                
					yeta2500Service.activityOnYeta2500List(listYe161010dto, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta2500List(" + "당월급여반영" + ") : " + caught), null);
						}
						public void onSuccess(Long result) { 
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "처리가 완료되었습니다.", null);
								reloadYeta2500();
								actionDatabase = ActionDatabase.UPDATE;
							} 
						} 
		                   
					}); 
		              
				} else {
					MessageBox.alert("선택", "처리할 데이타가 존재하지 않습니다.", null);
					return;
				} 
				
			}   
		}));  

		cp01.add(msfGridPanel);   
		  	   
	  
		fieldSetGrd.add(cp01);
		plFrmYeta2500.add(fieldSetGrd);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
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
		
	// 폼초기화
	private void formInit() {
		//그리드 초기화
		msfGridPanel.getMsfGrid().clearData();

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

	public Iterator<Record> getListRecord() {
		return this.records;
	}
	  

	private Yeta2500 getThis() {
		return this;
	}
		   
	private void reloadYeta2500() {

		if ("".equals(YetaUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
				return;
			}
		}

		IColumnFilter filters = null;
		msfGridPanel.getTableDef().setTableColumnFilters(filters);

		msfGridPanel.getTableDef().addColumnFilter("systemkey",MSFSharedUtils.allowNulls(srhSystemkey.getValue()),SimpleColumnFilter.OPERATOR_EQUALS);//systemkey

		msfGridPanel.getTableDef().addColumnFilter("yrtxBlggYr",MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"),SimpleColumnFilter.OPERATOR_EQUALS);// 정산년도

		msfGridPanel.getTableDef().addColumnFilter("clutSeptCd",MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);// 정산구분
		msfGridPanel.getTableDef().addColumnFilter("payrMangDeptCd",MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);// 단위기관
		msfGridPanel.getTableDef().addColumnFilter("emymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS); // 고용구분

		String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
		msfGridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd,SimpleColumnFilter.OPERATOR_EQUALS);// 부서

		String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
		msfGridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd,SimpleColumnFilter.OPERATOR_EQUALS); // 직종

		String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm", "dtilOccuInttnCd");
		msfGridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd",strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); // 직종세

		// msfGridPanel.getTableDef().addColumnFilter("businCd",MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"),SimpleColumnFilter.OPERATOR_EQUALS);//사업
		msfGridPanel.getTableDef().addColumnFilter("businCd",YetaUtils.getSelectedComboValue(srhBusinCd, "businCd"),SimpleColumnFilter.OPERATOR_EQUALS);// 사업
		
		msfGridPanel.getTableDef().addColumnFilter("iTem14", YetaUtils.getSelectedComboValue(srhItem14, "commCd"),SimpleColumnFilter.OPERATOR_EQUALS);// 금액

		msfGridPanel.reload();

	}
		   
		   
	// 엑셀 양식 저장
	private void xlsExportData() {

		HashMap<String, String> param = new HashMap<String, String>();
				   
		param.put("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year"));//귀속년도
		param.put("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd"));//정산구분
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));//단위기관
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));//고용구분
		param.put("deptCd", YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));//부서
		param.put("typOccuCd", YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));//직종
		param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));//직종세
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
		param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
				                     
		if ("".equals(srhYrtxBlggYr)) {
			MessageBox.info("", "년도는 필수 입니다.", null);

		} else if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
			if ("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"사업명을 선택하십시요.", null);
			} else {
				msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsYeta2500Export.do", "extgwtFrame", param);
			}
		} else {
			msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsYeta2500Export.do", "extgwtFrame", param);
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
