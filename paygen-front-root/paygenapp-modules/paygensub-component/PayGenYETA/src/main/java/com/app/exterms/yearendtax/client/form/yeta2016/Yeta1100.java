package com.app.exterms.yearendtax.client.form.yeta2016;

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
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2016.Ye16Ta2000Def;
import com.app.exterms.yearendtax.client.languages.YetaConstants;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1100Service;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1100ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaComboUtils;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style;
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
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
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
public class Yeta1100   extends MSFPanel {
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
		
//		private Ye161010Def yeta1100def = new Ye161010Def("Yeta1100");
	    private Ye16Ta2000Def yeta2000def = new Ye16Ta2000Def("YETA1100");
		private MSFGridPanel yeta1100GridPanel;
	  
		// -------------- 권한 설정 객체 시작 --------------
		private GWTAuthorization gwtAuthorization;
		private GWTExtAuth gwtExtAuth;
		private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
		// -------------- 권한 설정 객체 종료 --------------
	     

		  
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
		private Button btnYeta0100Init; 		// 초기화
		private Button btnYeta0100Cre; 			// 대상자생성
		private Button btnYeta0100Del; 			// 삭제
		private Button btnYeta0100Sreach; 		// 조회
		private Button btnYeta0100Excel; 		// 엑셀
		
		private Button btnAllUsed;
		private Button btnUnUsed;
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
		private MSFComboBox<BaseModel> srhClutYr; 				// 정산년
		// private ComboBox<BaseModel> srhClutMnth; // 정산월
		private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
		private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
		private TextField<String> srhHanNm; 					// 성명
		private TextField<String> srhResnRegnNum; 				// 주민번호
		private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
		private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드
		private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
		private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드
		private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
		private ComboBox<BaseModel> srhBusinCd; 				// 사업
		private HiddenField<String> srhSystemkey; 				// 시스템키
		
		private ComboBox<BaseModel> srhYetaDpcd; 				// 원천신고부서
		private ComboBox<BaseModel> srhBusoprRgstnum; 			// 사업자등록번호

	    	      
	    	      
		// -------------- 연말정산대상자-생성 폼 시작 --------------
		private MSFTextField deptCd; // 부서명
		private MSFTextField deptNm; // 부서명
		private Button btnDeptCd;  
		// -------------- 연말정산대상자-생성 폼 종료 --------------   	      
	    	      
		private List<ModelData> mDtalistHdofcCodtnCd;
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;

		private boolean mutilCombo = false;
			
		private HiddenField<String> systemkey;	/** column SYSTEMKEY : systemkey */
		private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */

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
		//  private Yeta0100ServiceAsync yeta0100Service = Yeta0100Service.Util.getInstance();      
		  private Yeta1100ServiceAsync yeta1100Service = Yeta1100Service.Util.getInstance(); 
		  
		  
	    // -------------- stroe [검색부]선언 시작 --------------
	      private ListStore<BaseModel> lsClutYrStore 			= new ListStore<BaseModel>();	// 정산년도
	      private ListStore<BaseModel> lsCrCalcSevePayPsnDivCd 	= new ListStore<BaseModel>();	// 정산구분
	      private ListStore<BaseModel> lsPayrMangDeptCd 		= new ListStore<BaseModel>(); 	// 단위기관
	      private ListStore<BaseModel> lsEmymtDivCd 			= new ListStore<BaseModel>(); 	// 고용구분
	      private ListStore<BaseModel> lsRepbtyBusinDivCd 		= new ListStore<BaseModel>();	// 호봉제구분코드 
	      private ListStore<BaseModel> lsDeptCd 				= new ListStore<BaseModel>(); 	// 부서콤보
	      private ListStore<BaseModel> lsBusinCd 				= new ListStore<BaseModel>(); 	// 사업콤보
	      private ListStore<BaseModel> lsDeptGpCd 				= new ListStore<BaseModel>();	// 부서직종그룹코드  
	      private ListStore<BaseModel> lsTypOccuCd 				= new ListStore<BaseModel>(); 	// 직종
	      private ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>(); 	// 직종세
	      private ListStore<BaseModel> lsCalcSevePayPsnDivCd 	= new ListStore<BaseModel>(); 	// 정산구분
	      
	      private ListStore<BaseModel> lsYetaDpcd  				= new ListStore<BaseModel>();	// 원천징수부서코드  
	      private ListStore<BaseModel> lsBusoprRgstnum  		= new ListStore<BaseModel>();	// 사업자등록번호  

		    
		  private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
		  private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
		  private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
		  private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
		  private SysCoCalendarDTO  msfCoCalendarDto;  
		  private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
		  private PrgmComBass0320DTO sysComBass0320Dto;	//직종
		  private Ye16Ta1005DTO ye16Ta1005Dto;
		    
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
				 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
				 gwtAuthorization.formAuthFieldConfig(fldArrField);
				 
				 srhClutYr.setValue(lsClutYrStore.findModel("year", "2016"));
				 srhClutSeptCd.setValue(lsCalcSevePayPsnDivCd.getAt(0));
	          
				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				  * 권한설정을 위한 콤보처리를 위한 메서드 종료
				  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//				 creDeptCd.getListView().fireEvent(Events.CheckChanged); 
			
			 }

		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) {
				if (lsEmymtDivCd.getCount() > 0) {

					cancel();
					unmask();
					authExecEnabled();
					maskTracker = true;

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
			    
			   
//			    authMapDef.put("crePayrMangDeptCd",Boolean.FALSE); 
//			    authMapDef.put("creEmymtDivCd",Boolean.FALSE); 
//			    authMapDef.put("creDeptCd",Boolean.FALSE); 
			   // authMapDef.put("creTypOccuCd",Boolean.FALSE);	 		

		 		 gwtExtAuth.setCheckMapDef(authMapDef);
		 		
		 		 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//		 			 권한 검색조건처리를 위해 추가된 부분
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
//		    private SelectionListener<ButtonEvent> selectionListener = 
//			        new SelectionListener<ButtonEvent>() {
//			        public void componentSelected(ButtonEvent ce) { 
//			            if (ce.getButton() == btnRemt0100Save) {
//			                doAction(ActionDatabase.INSERT);
//			            } else if (ce.getButton() == btnRemt0100Save) {
//			                doAction(ActionDatabase.UPDATE);
//			            } else if (ce.getButton() == btnRemt0100Del) {
//			                doAction(ActionDatabase.DELETE);
//			            }
		//
//			        }  
//			    };
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
		        	Yeta1100_menuDelete();	
		            break;
		        }
		    }
			
		    
		/**
		 * 데이타를 삭제한다.
		 */
		private void Yeta1100_menuDelete() {
		       
			MessageBox.confirm("연말정산 대상자 삭제", "선택된 데이타를 삭제 하시겠습니까?<br>(연말정산 대상자를 삭제합니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//   if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		             
//						if ("admin".equals(MSFMainApp.get().getUser().getUsrId())) {
//							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "삭제권한이 없습니다.삭제하시려면 [관리자]에게 요청하십시요.", null);
//							return;
//						}
		                	 
						Iterator<BaseModel> itBm = yeta1100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); 
						List<Record>  lsRec  = new ArrayList<Record>();
						List<Ye16Ta2000DTO> listYe16Ta2000Dto = new ArrayList<Ye16Ta2000DTO>();       
						
						while (itBm.hasNext()) {

							Record rec = new Record(itBm.next());
							lsRec.add(rec);

						}

						setListRecord(lsRec.iterator());
					                 
						if (MSFSharedUtils.paramNotNull(records)) {   
						   
						   while (records.hasNext()) {
	       	             
							   Record record = (Record) records.next(); 
							   BaseModel bmMapModel = (BaseModel)record.getModel();
	       	                  
	       	                  	// select에 null값이 들어가있으므로 널포인트에러뜸.
							   // 그래서 null인것은 false로 강제변환시킴.
	       						if ((Boolean) bmMapModel.get("select") == null) {
	       							bmMapModel.set("select", false);
	       						}

	       						if ((Boolean) bmMapModel.get("select")) {
	       							Ye16Ta2000DTO ye16Ta2000Dto = new Ye16Ta2000DTO();
	       							
	       							ye16Ta2000Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));   	 				/** column 사업장코드 : dpobCd */
	       							ye16Ta2000Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    				/** column 연말정산귀속년도 : edacRvyy */
	       							ye16Ta2000Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    				/** column 정산구분코드 : settGbcd */
	       							ye16Ta2000Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    				/** column SYSTEMKEY : systemkey */
	       							ye16Ta2000Dto.setEdacSeilNum((Long)bmMapModel.get("edacSeilNum"));    								/** column 연말정산마감일련번호 : edacSeilNum */
	       							ye16Ta2000Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));		/** column 급여관리부서코드 : payrMangDeptCd */
	       							ye16Ta2000Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    			/** column 고용구분코드 : emymtDivCd */
	       							ye16Ta2000Dto.setHanNm(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));    						/** column 한글성명 : hanNm */
	       							ye16Ta2000Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    			/** column 주민등록번호 : resnRegnNum */
	       							ye16Ta2000Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    					/** column 부서코드 : deptCd */
	       							ye16Ta2000Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    					/** column 사업코드 : businCd */
	       							ye16Ta2000Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    				/** column 직종코드 : typOccuCd */
	       							ye16Ta2000Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));		/** column 직종세통합코드 : dtilOccuInttnCd */
	       							ye16Ta2000Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));	/** column 직종세구분코드 : dtilOccuClsDivCd */
	       							ye16Ta2000Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    					/** column 직책코드 : odtyCd */
	       							ye16Ta2000Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    					/** column 호봉코드 : pyspCd */
	       							ye16Ta2000Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));   	 		/** column 호봉등급코드 : pyspGrdeCd */
	       							ye16Ta2000Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    		/** column 근속년수코드 : logSvcYrNumCd */
	       							ye16Ta2000Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    	/** column 근속월수코드 : logSvcMnthIcmCd */
	       							ye16Ta2000Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    			/** column 최초고용일자 : frstEmymtDt */
	    							ye16Ta2000Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    			/** column 고용시작일자 : emymtBgnnDt */
	    							ye16Ta2000Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    			/** column 고용종료일자 : emymtEndDt */
	    							ye16Ta2000Dto.setHdofcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcDivCd")));    			/** column 재직구분코드 : hdofcDivCd */
	    							ye16Ta2000Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    					/** column 퇴직일자 : retryDt */
	    							ye16Ta2000Dto.setYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxApptnYrMnth")));    	/** column 연말정산적용년월 : yrtxApptnYrMnth */
	    							ye16Ta2000Dto.setYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsDt")));   			/** column 연말정산처리일자 : yrtxPrcsDt */
//	    							yeta2000Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
	    							ye16Ta2000Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    							/** column 연말정산처리여부 : yrtxPrcsYn */
	    							ye16Ta2000Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    		/** column 분할납부구분코드 : divdPymtDivCd */
	    							ye16Ta2000Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    				/** column 분할납부횟수 : divdPymt */ 
	       						
//	       							Ye160401DTO ye160401Dto = new Ye160401DTO();   
//	       					
//	       							ye160401Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
//	       							ye160401Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    	/** column 귀속연도 : yrtxBlggYr */
//	       							ye160401Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    	/** column 연말정산구분코드 : clutSeptCd */
//	       							ye160401Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));  		/** column SYSTEMKEY : systemkey */

	       							
//	       							Window.alert("시스템키 + " + bmMapModel.get("systemkey"));
	       							
	       							listYe16Ta2000Dto.add(ye16Ta2000Dto);
	       						}
						   }
	       				}   
	       				
	       				
	       				if(listYe16Ta2000Dto.size() <= 0 ) {
	       					MessageBox.info("경고", "삭제할 연말정산 대상자를 선택해 주세요.", null);
	       					return;
	       				}
	       	                 
		                       
	       				yeta1100Service.YETA1100_TO_YETA2000_DELETE(listYe16Ta2000Dto , new AsyncCallback<Long>() {
		                       public void onFailure(Throwable caught) {
		                    	   MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                               MSFMainApp.ADMINMESSAGES.ExceptionMessageService("YETA1100_TO_YETA2000_DELETE(삭제) : " + caught), null);
		                       }
		                       public void onSuccess(Long result) { 
		                    	   if (result == 0) {
		                    		   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "삭제처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
		                    	   } else {
		                          MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  "삭제처리가 완료되었습니다.", null);
		                          reload();

		                    	   }
								}
							});
				       } else {
				    	   MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
				    	   return;
				       }
					}
				});
		    }

		private void PayrExec_Yeta_Insert() {
			
			final Tracker tracker = new Tracker();
	        tracker.setStatus(false);
		        
		 
			//Iterator<BaseModel> itBm = yeta1100GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

			Iterator<BaseModel> itBm = yeta1100GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();
			
			List<Record> lsRec = new ArrayList<Record>();

			while (itBm.hasNext()) {

				Record rec = new Record(itBm.next());
				lsRec.add(rec);

			}
			setListRecord(lsRec.iterator());

			if (MSFSharedUtils.paramNotNull(records)) {
				List<Ye16Ta2000DTO> listYeta2000Dto = new ArrayList<Ye16Ta2000DTO>();

				while (records.hasNext()) {

					Record record = (Record) records.next();
					BaseModel bmMapModel = (BaseModel) record.getModel();
					
					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}

					if ((Boolean) bmMapModel.get("select")) {

						Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO(); 
						
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
		//				yeta2000Dto.setYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxPrcsYn")));    /** column 연말정산처리여부 : yrtxPrcsYn */
						yeta2000Dto.setYrtxPrcsYn((Boolean) bmMapModel.get("yrtxPrcsYn"));    /** column 연말정산처리여부 : yrtxPrcsYn */
						yeta2000Dto.setDivdPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymtDivCd")));    /** column 분할납부구분코드 : divdPymtDivCd */
						yeta2000Dto.setDivdPymt(MSFSharedUtils.allowNulls(bmMapModel.get("divdPymt")));    /** column 분할납부횟수 : divdPymt */ 				
		
						listYeta2000Dto.add(yeta2000Dto);
					}
				}   
				
				
				if(listYeta2000Dto.size() <= 0 ) {
					MessageBox.info("경고", "급여데이터를 이관할 대상자를 선택해 주세요.", null);
					return;
				}
				
	            //Progress bar for upload
	            final MessageBox box = MessageBox.wait("급여자료이관", "급여내역(정산용)을 이관 중 입니다...", "급여내역이관 중...");
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
	            
	            yeta1100Service.PayrExec_Yeta_2016_Insert(listYeta2000Dto , new AsyncCallback<Long>() {
	            	public void onFailure(Throwable caught) {
	            		tracker.setStatus(true);
	            		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("PayrExec_Yeta_Insert(급여자료이관) : " + caught), null);
	                }
	                public void onSuccess(Long result) { 
	                	if (result == 0) {
	                		tracker.setStatus(true);
	                		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),  "급여자료이관이 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                	} else {
	                		tracker.setStatus(true);
	                		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "급여자료이관 처리가 완료되었습니다.", null);
	                		reload();
	                	} 
	                } 
	            });            
			} else {
				MessageBox.alert(actionDatabase.name() + "선택",actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
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

		}

		private void Payr06420_All_Add_Create() {

		}
		    
		    
		private void savePayr06420_SelfAll_Create() {

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
		  
		public ContentPanel getViewPanel() {
			if (panel == null) {

				// 콤보 권한초기화
				initLoad();

				detailTp = XTemplate.create(getDetailTemplate());
				vp = new VerticalPanel();
				vp.setSpacing(10);
				createYeta0100Form(); 	// 화면 기본정보를 설정
				createSearchForm();		// 검색조건 및 생성부
				createMsfGridForm(); 	// 그리드설정
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
			public Yeta1100() {
				setSize("1600px", "700px");
			}
		
			public Yeta1100(String txtForm) {
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

			btnlogView.setHeight("10px"); // 로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					// 로그 뷰화면 호출 메서드
					funcLogMessage("연말정산대상자관리", "YETA0100");
				}
			});
			plFrmYeta0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmYeta0100.getHeader().addTool(btnlogView);
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/
	 
			// 멀티콤보박스 닫기
			plFrmYeta0100.addListener(Events.OnClick, new Listener<ComponentEvent>() {
				@Override
				public void handleEvent(ComponentEvent ce) {
					if (mutilCombo) {
						if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
							srhDeptCd.showClose(ce);
							mutilCombo = false;
						} else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
							//직종
							srhTypOccuCd.showClose(ce);
							mutilCombo = false;
						} else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
							//직종세
							srhDtilOccuInttnCd.showClose(ce);
							mutilCombo = false;
						} 
					}
				} 
			});
		        
			/** 상단 버튼 ButtonBar **/
			topYeta0100Bar = new ButtonBar();
			topYeta0100Bar.setAlignment(HorizontalAlignment.RIGHT);

			btnYeta0100Init = new Button("초기화");
			btnYeta0100Init.setIcon(MSFMainApp.ICONS.new16());
			topYeta0100Bar.add(btnYeta0100Init);
			btnYeta0100Init.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					yeta1100GridPanel.getMsfGrid().clearData();
				}
			});

			btnYeta0100Cre = new Button("대상자생성");
			btnYeta0100Cre.setIcon(MSFMainApp.ICONS.upload16());
			topYeta0100Bar.add(btnYeta0100Cre);
			btnYeta0100Cre.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
//					if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"))){
//						MessageBox.info("", "단위기관을 선택해 주세요.", null);
//						return;
//					}else if(MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"))) {
//						MessageBox.info("", "급여구분을 선택해 주세요.", null);
//						return;
//					}
////					else if(MSFSharedUtils.paramNull(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"))) {
////						MessageBox.info("", "부서를 선택해 주세요.", null);
////						return;
////					}
//					
					YetaP110001 yetaP110001Form = new YetaP110001(ActionDatabase.READ, getThis());

					final MSFFormWindows msFwYeta110001 = new MSFFormWindows("연말정산대상자검색",yetaP110001Form, "닫기", "920px", "710px", false);
					msFwYeta110001.show();
					yetaP110001Form.setMSFFormWindows(msFwYeta110001);
					
					BaseModel bmRecord = new BaseModel();

					bmRecord.set("dpobCd", dpobCd.getValue());
					bmRecord.set("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd"));
					bmRecord.set("clutYr", MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));
					
					bmRecord.set("deptCd",YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));// 부서
					bmRecord.set("deptNm", srhDeptCd.getValue());
					bmRecord.set("srhHanNm", srhHanNm.getValue());
					bmRecord.set("systemkey", systemkey.getValue());
					bmRecord.set("srhResnRegnNum", srhResnRegnNum.getValue());
					
					
					bmRecord.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
					bmRecord.set("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
					bmRecord.set("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd, "commCd"));
					bmRecord.set("typOccuCd",YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));// 직종
					bmRecord.set("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),	"dtilOccuClsNm", "dtilOccuInttnCd"));// 직종세
					bmRecord.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
					
					setPPRecord(bmRecord); 
					
					yetaP110001Form.bind(ppRecord);
					
				}
			});

			btnYeta0100Del = new Button("삭 제");
			btnYeta0100Del.setIcon(MSFMainApp.ICONS.delete16());
			topYeta0100Bar.add(btnYeta0100Del);
			btnYeta0100Del.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					if(!"D0010090".equals(MSFMainApp.get().getUser().getUsrDivCd())) {
	                	 
            	 		MessageBox.alert("오류", "마스터 관리자만 삭제 가능합니다.</br>관리자에게 문의해주세요.", null);
            	 		return; 
                     
                   }
					
					doAction(actionDatabase.DELETE);
//					Window.alert("준비중");
				}
			});

			btnYeta0100Sreach = new Button("조 회");
			btnYeta0100Sreach.setIcon(MSFMainApp.ICONS.search());
			topYeta0100Bar.add(btnYeta0100Sreach);
			btnYeta0100Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					// 조회버튼 클릭시 처리
					reload();
				}
			});

			btnYeta0100Excel = new Button("엑 셀");
			btnYeta0100Excel.setIcon(MSFMainApp.ICONS.excel16());
			topYeta0100Bar.add(btnYeta0100Excel);
			btnYeta0100Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					// 엑셀 저장
					xlsExportData();
//					Window.alert("준비중");
				}
			});

			plFrmYeta0100.add(topYeta0100Bar);

			// 파일업로드 처리
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
		

		/**
		 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 검색 함수 선언부 시작
		 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
		 **/ 
	    private void createSearchForm() {   		
				
			dpobCd = new HiddenField<String>(); 		// 사업장코드
			systemkey = new HiddenField<String>(); 	// 시스템키

			sysComBass0150Dto 	= new PrgmComBass0150DTO();
			sysComBass0300Dto 	= new PrgmComBass0300DTO();
			sysComBass0400Dto 	= new PrgmComBass0400DTO();
			sysComBass0500Dto 	= new PrgmComBass0500DTO();
			msfCoCalendarDto 	= new SysCoCalendarDTO();
			sysComBass0350Dto 	= new PrgmComBass0350DTO();
			sysComBass0320Dto 	= new PrgmComBass0320DTO();
				
			    
			//--------------------단위기관 불러 오는 함수 ------------------------------------------------
			lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);		//단위기관_검색조건
			//--------------------단위기관 불러 오는 함수 ------------------------------------------------
			     
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			sysComBass0300Dto.setRpsttvCd("Y002");
			lsCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);//정산구분
			     
//			sysComBass0300Dto.setRpsttvCd("Y002");
//			lsCrCalcSevePayPsnDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);// 정산구분

			// 호봉
			sysComBass0300Dto.setRpsttvCd("A048");
			lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

			sysComBass0300Dto.setRpsttvCd("A002");
			lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); // 고용구분_검색조건

			sysComBass0300Dto = new PrgmComBass0300DTO();
			sysComBass0300Dto.setRpsttvCd("A002");

			// --------------------공통 코드 불러 오는 함수--------------------------------------------------

			// --------------------정산년도 불러 오는 함수------------------------------------------------
			lsClutYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			// --------------------정산년도 불러 오는 함수------------------------------------------------

			sysComBass0400Dto.setDeptDspyYn("Y");
			sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
			sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

			lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);

			lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
				public void handleEvent(StoreEvent<BaseModel> be) {
					mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
					srhDeptCd.getInitStore().add(mDtalistDeptCd);
				}
			});

			sysComBass0400Dto.setDeptDspyYn("Y");
			sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
			sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
			
			
			
			// --------------------연말정산 불러 오는 함수------------------------------------------------	
//			ye16Ta1005Dto = new Ye16Ta1005DTO();
//			ye16Ta1005Dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());	/** column 사업장코드 : dpobCd */
//			ye16Ta1005Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//			ye16Ta1005Dto.setDeptCd(MSFMainApp.get().getUser().getDeptCd());    /** column 부서코드 : deptCd */
//			lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdList(ye16Ta1005Dto);
			lsYetaDpcd = YetaComboUtils.getYeta2000YetaDpcdListNoAuth();
			// --------------------연말정산 불러 오는 함수------------------------------------------------				
			
			
			     
			/**
			 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
			 * 직종 콤보박스 처리 시작
			 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			 */
			lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
				public void handleEvent(StoreEvent<BaseModel> be) {

					mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd);
					srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

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
			// fieldSet.setHeight("80px");

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
								srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
									public void handleEvent(StoreEvent<BaseModel> be) {
												// searchBusinCd.setValue(lsBusinCd.getAt(0));
									}
								});

							} else {
									// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
									// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
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
			frmlytSch.setLabelWidth(80);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer77.setLayout(frmlytSch);
				    
			srhEmymtDivCd = new ComboBox<BaseModel>();
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
						/**
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
						 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서
						 *  : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 """srhPayrMangDeptCd","srhEmymtDivCd" ,"srhDeptCd","srhTypOccuCd","srhBusinCd"
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 */
						checkYeta0100Auth("srhEmymtDivCd", lsEmymtDivCd);
					}
				}
			});    
			srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
				public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
					// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
					BaseModel bmPayCd = se.getSelectedItem();
					if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
						if ((srhDeptCd.getListView().getChecked().size() == 1) 
							&& (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
							if (srhDeptCd.getListView().getChecked().size() > 0) {
								sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));
								List<ModelData> mdListSelect = srhDeptCd.getListView().getChecked();
								sysComBass0500Dto.setDeptCd(MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd")));
							}

							// --------------------사업 불러 오는 함수-------------------------------------------------
							lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
							// --------------------사업 불러 오는 함수 -------------------------------------------------
							srhBusinCd.setStore(lsBusinCd);
							srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
								public void handleEvent(StoreEvent<BaseModel> be) {
											// searchBusinCd.setValue(lsBusinCd.getAt(0));
								}
							});

						} else {
									// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
									// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
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
//						srhBusinCd.reset();
//						srhBusinCd.setEnabled(false);
//						
//						if (gwtAuthorization.getCheckOccuDisabled()) {
//							srhTypOccuCd.setEnabled(true);
//							srhDtilOccuInttnCd.setEnabled(true);
//						} else {
//							srhTypOccuCd.setEnabled(false);
//							srhDtilOccuInttnCd.setEnabled(false);
//						}
					}
				}
			});
			layoutContainer77.add(srhEmymtDivCd, new FormData("100%"));
			layoutContainer4.add(layoutContainer77,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

			LayoutContainer layoutContainer_101 = new LayoutContainer();
			layoutContainer_101.setBorders(false);

			frmlytSch = new FormLayout();
			frmlytSch.setDefaultWidth(0);
			// frmlytSch.setLabelWidth(0);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_101.setLayout(frmlytSch);

			srhRepbtyBusinDivCd = new ComboBox<BaseModel>();
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
			lsRepbtyBusinDivCd.addStoreListener(new StoreListener<BaseModel>() {
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
					if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
						srhSystemkey.setValue("");
						srhResnRegnNum.setValue("");
						fnPopupPsnl0100();
					}
					super.componentKeyDown(event);
				}
			});
			layoutContainer1_2.add(layoutContainer5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
			layoutContainer5.setBorders(false);

			LayoutContainer layoutContainer_btn = new LayoutContainer();
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(0);
			layoutContainer_btn.setLayout(frmlytSch);

			Button btnHanNm = new Button("검색");
			// layoutContainer1_2.add(btnHanNm);
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
			// frmlytSch.setLabelWidth(0);
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

			srhClutSeptCd = new ComboBox<BaseModel>();
			srhClutSeptCd.setName("srhClutSeptCd");
			srhClutSeptCd.setForceSelection(true);
			srhClutSeptCd.setMinChars(1);
			srhClutSeptCd.setDisplayField("commCdNm");
			srhClutSeptCd.setValueField("commCd");
			srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
			srhClutSeptCd.setEmptyText("--정산구분선택--");
			srhClutSeptCd.setSelectOnFocus(true);
			srhClutSeptCd.setReadOnly(false);
			srhClutSeptCd.setEnabled(true);
			srhClutSeptCd.setStore(lsCalcSevePayPsnDivCd);
			srhClutSeptCd.setFieldLabel("정산구분");
			srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
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
			srhDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
				public void handleEvent(StoreEvent<ModelData> be) {
					EventType type = be.getType();
					if (type == Store.Add) {
						/**
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
						 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
						 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 */
						checkYeta0100Auth("srhDeptCd", lsDeptCd);
					}
				}
			});

			srhDeptCd.getListView().addListener(Events.CheckChanged, new Listener<ComponentEvent>() {
				@Override
				public void handleEvent(ComponentEvent ce) {
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
						srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
							public void handleEvent(StoreEvent<BaseModel> be) {
												// searchBusinCd.setValue(lsBusinCd.getAt(0));
							}
						});
					} else {
								// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
								// "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
								// return;
					}
				}

			});

			srhDeptCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
				@Override
				public void handleEvent(ComponentEvent ce) {
					if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
						mutilCombo = true;
					} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
						mutilCombo = true;
						// GWT.log(" b" + ce.getEvent().getType());
					} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
						mutilCombo = false;
						// GWT.log(" b" + ce.getEvent().getType());
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
			frmlytSch.setLabelWidth(80);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_211.setLayout(frmlytSch);

			srhDeptGpCd = new ComboBox<BaseModel>();
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
			// frmlytSch.setLabelWidth(70);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			lcTypOccuCd.setLayout(frmlytSch);
			
			srhTypOccuCd = new MSFMultiComboBox<ModelData>();
			srhTypOccuCd.setName("srhTypOccuCd");
			srhTypOccuCd.setEmptyText("--직종선택--");
			srhTypOccuCd.setHideLabel(true);
			srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
			srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
			srhTypOccuCd.setWidth(100);
//			srhTypOccuCd.setFieldLabel("직종");
			//srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
			//srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
			srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
				public void handleEvent(StoreEvent<ModelData> be) {  
					EventType type = be.getType();
					if (type == Store.Add) { 
						/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
						 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
						 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				    		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
							//checkYeta1300Auth("srhTypOccuCd", lsTypOccuCd); 
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
						// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
			                        
			        	if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
			                            
			        		lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
			        		//  srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
				        	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
				        		public void handleEvent(StoreEvent<BaseModel> be) {  
				        			mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
			// frmlytSch.setLabelWidth(1);
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
			srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
				@Override
				public void handleEvent(ComponentEvent ce) {
					if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
						mutilCombo = true;
					} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
						mutilCombo = true;
						// GWT.log(" b" + ce.getEvent().getType());
					} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
						mutilCombo = false;
						// GWT.log(" b" + ce.getEvent().getType());
					} else {
						
					}
				}
			});

			lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));

			layoutContainer1_3.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
			layoutContainer1_3.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
			layoutContainer1_3.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
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
			
			
			LayoutContainer layoutContainer_16 = new LayoutContainer(new ColumnLayout());

			LayoutContainer layoutContainer_16_1 = new LayoutContainer();

			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(80);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_16_1.setLayout(frmlytSch);
				    
			srhYetaDpcd = new ComboBox<BaseModel>();
			srhYetaDpcd.setName("srhYetaDpcd");
			srhYetaDpcd.setForceSelection(true);
			srhYetaDpcd.setMinChars(1);
			srhYetaDpcd.setDisplayField("yetaDpnm");
			srhYetaDpcd.setValueField("yetaDpcd");
			srhYetaDpcd.setTriggerAction(TriggerAction.ALL);
			srhYetaDpcd.setEmptyText("--원천신고부서--");
			srhYetaDpcd.setSelectOnFocus(true);
			srhYetaDpcd.setReadOnly(false);
			srhYetaDpcd.setEnabled(true);
			srhYetaDpcd.setStore(lsYetaDpcd);
			srhYetaDpcd.setFieldLabel("원천신고부서");
			layoutContainer_16_1.add(srhYetaDpcd, new FormData("100%"));
			layoutContainer_16_1.setBorders(false);
			srhYetaDpcd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
				public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
					// 원천신고부서가 변경될 경우 해당하는 사업자등록번호를 가져옴
					BaseModel bmClutYr = se.getSelectedItem();
					
					if (bmClutYr != null) {
						
						// TODO 콤보 선택시 사업자번호 스토어 
						lsBusoprRgstnum.removeAll();
						srhBusoprRgstnum.setStore(new ListStore<BaseModel>());
						srhBusoprRgstnum.setValue(new BaseModel());
						
						Ye16Ta1005DTO yeta161005Dto = new Ye16Ta1005DTO();
						yeta161005Dto.setDpobCd(dpobCd.getValue());
						yeta161005Dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
						
						lsBusoprRgstnum = YetaComboUtils.getYeta2000busoprRgstnumList(yeta161005Dto);
						srhBusoprRgstnum.setStore(lsBusoprRgstnum);
						
					}
				}
			}); 
			layoutContainer_16_1.add(srhYetaDpcd, new FormData("100%"));
			layoutContainer_16.add(layoutContainer_16_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

			LayoutContainer layoutContainer_16_2 = new LayoutContainer();
			layoutContainer_16_2.setBorders(false);

			frmlytSch = new FormLayout();
			frmlytSch.setDefaultWidth(0);
			// frmlytSch.setLabelWidth(0);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_16_2.setLayout(frmlytSch);

			srhBusoprRgstnum = new ComboBox<BaseModel>();
			srhBusoprRgstnum.setName("srhBusoprRgstnum");
			srhBusoprRgstnum.setHideLabel(true);
			srhBusoprRgstnum.setForceSelection(true);
			srhBusoprRgstnum.setMinChars(1);
			srhBusoprRgstnum.setDisplayField("busoprRgstnum");
			srhBusoprRgstnum.setValueField("busoprRgstnum");
			srhBusoprRgstnum.setTriggerAction(TriggerAction.ALL);
			srhBusoprRgstnum.setEmptyText("--원천신고부서--");
			srhBusoprRgstnum.setSelectOnFocus(false);
			srhBusoprRgstnum.setReadOnly(false);
			srhBusoprRgstnum.setEnabled(true);
			srhBusoprRgstnum.setStore(lsBusoprRgstnum);
			srhBusoprRgstnum.setLabelSeparator("");
//			srhBusoprRgstnum.setFieldLabel("사업자등록번호");
			lsRepbtyBusinDivCd.addStoreListener(new StoreListener<BaseModel>() {
				public void handleEvent(StoreEvent<BaseModel> be) {

				}
			});
			layoutContainer_16_2.add(srhBusoprRgstnum, new FormData("100%"));
			layoutContainer_16.add(layoutContainer_16_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));			
			
			

			plFrmYeta0100.add(fieldSet);

			// 연말정산대상자-생성
			FieldSet fieldSet_2 = new FieldSet();
			fieldSet_2.setHeadingHtml("");
//			fieldSet_2.setHeight("50px");
			fieldSet_2.setCollapsible(false);
			
			
			LayoutContainer lcSchCol2 = new LayoutContainer();
			
			ButtonBar btnBar = new ButtonBar();
			btnBar.setAlignment(HorizontalAlignment.RIGHT);
			
			
			Button btnSelApp = new Button("원천징수부서등록");
			btnSelApp.setWidth(130);
			btnSelApp.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					YetaP110002 yetaP110002Form = new YetaP110002(ActionDatabase.READ, getThis());

					final MSFFormWindows msFwYeta110002 = new MSFFormWindows("원천신고부서",yetaP110002Form, "닫기", "920px", "710px", false);
					msFwYeta110002.show();
					yetaP110002Form.setMSFFormWindows(msFwYeta110002);
					
					BaseModel bmRecord = new BaseModel();

					bmRecord.set("dpobCd", dpobCd.getValue());
					
					bmRecord.set("clutYr", MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));
					
					bmRecord.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
					bmRecord.set("payrMangDeptNm", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptNm"));
					
					bmRecord.set("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
					bmRecord.set("emymtDivNm", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCdNm"));
					
					bmRecord.set("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd, "commCd"));
					bmRecord.set("repbtyBusinDivNm", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd, "commCdNm"));
//					
					bmRecord.set("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd"));
					bmRecord.set("clutSeptNm", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCdNm"));
					
					bmRecord.set("deptCd",YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));// 부서
					bmRecord.set("deptNm", srhDeptCd.getValue());
//					
//					bmRecord.set("deptGpCd", MSFSharedUtils.getSelectedComboValue(srhDeptGpCd, "commCd"));
//					bmRecord.set("deptGpNm", MSFSharedUtils.getSelectedComboValue(srhDeptGpCd, "commCdNm"));
//					
					bmRecord.set("typOccuCd",YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));// 직종
					bmRecord.set("typOccuNm",srhTypOccuCd.getValue());// 직종
					
					bmRecord.set("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),	"dtilOccuClsNm", "dtilOccuInttnCd"));// 직종세
					bmRecord.set("dtilOccuInttnNm", srhDtilOccuInttnCd.getValue());// 직종세

					bmRecord.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
					bmRecord.set("businNm", MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businNm"));
					
					bmRecord.set("hanNm", srhHanNm.getValue());
					bmRecord.set("systemkey", systemkey.getValue());
					bmRecord.set("resnRegnNum", srhResnRegnNum.getValue());
					
					setPPRecord(bmRecord); 

					yetaP110002Form.bind(ppRecord);
				}
			});
			btnBar.add(btnSelApp);
			
			
			
			Button btnPayrTrans = new Button("급여자료이관");
			btnPayrTrans.setWidth(130);
			btnPayrTrans.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					MessageBox.confirm("급여자료이관", "선택된 대상자의 급여 내역을 이관 하시겠습니까?<br>(기존 급여내역은 삭제 후 다시 생성됩니다.)",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//   if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								PayrExec_Yeta_Insert();
								
							}
						}
					});
				}
			});
			btnBar.add(btnPayrTrans);
			
			fieldSet_2.add(lcSchCol2);
			plFrmYeta0100.add(fieldSet_2);	

				    
			lcSchCol1.add(layoutContainer1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));   	// 정산년,월
			lcSchCol1.add(layoutContainer3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 단위기관
			lcSchCol1.add(layoutContainer4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 		// 고용구분
				    
			lcSchCol1.add(layoutContainer7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 정산구분
			lcSchCol1.add(layoutContainer8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 		// 부서
			lcSchCol1.add(layoutContainer1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 직종
				    
			lcSchCol1.add(layoutContainer9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 		// 사업
			lcSchCol1.add(layoutContainer1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 	// 성명, 주민등록번호
			lcSchCol1.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43)); 	// 
			
			lcSchCol2.add(btnBar);
				    
		}	  
				  

		class Tracker {
			public boolean status = false;

			public boolean getStatus() {
				return status;
			}

			public void setStatus(boolean stat) {
				status = stat;
			}
		}
		   
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 폼 생성시 기본 처리 함수 선언부 종료
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
			
		private void createMsfGridForm() {
			// 연말정산대상자 및 내역

			FieldSet fieldSetGrd = new FieldSet();
			fieldSetGrd.setHeadingHtml("연말정산대상자 및 내역");

			ContentPanel cp01 = new ContentPanel();
			cp01.setBodyBorder(false);
			cp01.setHeaderVisible(false);
			cp01.setLayout(new FitLayout());
			cp01.setSize(960, 440);

			yeta1100GridPanel = new MSFGridPanel(yeta2000def, false, false, false,false, false);
			// yeta1100GridPanel.setSize(960, 400);
			yeta1100GridPanel.setHeaderVisible(false);
			yeta1100GridPanel.setBorders(true);
			// yeta1100GridPanel.getBottomComponent().setVisible(false);
			
	        //툴바메뉴
	        ToolBar bottomToolbar = new ToolBar();  
	        bottomToolbar.add(new FillToolItem());
	        
	        // 첫번째 사용직종정보 툴바
	        // ================전체선택버튼=========================
	        btnAllUsed = new Button("전체선택");
	        btnAllUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
	            public void componentSelected(ButtonEvent ce) { 
	            	
	            	  int  lsCnt = yeta1100GridPanel.getMsfGrid().getGrid().getStore().getCount();
	            	  
	            	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
	            		  
	            		  yeta1100GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
	            		  yeta1100GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
	            		   
	            	  } 
	            	  yeta1100GridPanel.getMsfGrid().getGrid().getView().refresh(true);
			    }
	        });
	        
	        
	        bottomToolbar.add(btnAllUsed);
	        bottomToolbar.add(new SeparatorMenuItem());
	        //====================================================
	        
	       // ================전체해제버튼=========================
	        btnUnUsed = new Button("전체해제");
	        btnUnUsed.addSelectionListener(new SelectionListener<ButtonEvent>() {
	            public void componentSelected(ButtonEvent ce) {  
	            	
	            	  int  lsCnt = yeta1100GridPanel.getMsfGrid().getGrid().getStore().getCount();
	            	  
	            	  for(int iCnt=0;iCnt < lsCnt;iCnt++) {
	            		  
	            		  yeta1100GridPanel.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
	            		  yeta1100GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
	            		   
	            	  } 
	            	  yeta1100GridPanel.getMsfGrid().getGrid().getView().refresh(true);
	            }  
	        });

	        bottomToolbar.add(btnUnUsed);
	        bottomToolbar.add(new SeparatorMenuItem());
	        //====================================================	
	        
	        //툴바 넣어주는것
	        yeta1100GridPanel.setBottomComponent(bottomToolbar);
			
			
			
			
			
	        final Grid<BaseModel> grid = yeta1100GridPanel.getMsfGrid().getGrid();
	        final ColumnModel columnModel =  grid.getColumnModel();
	        final List<ColumnConfig> columnConfigs = columnModel.getColumns();
	        final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 45); 
	        check.setAlignment(Style.HorizontalAlignment.CENTER);		            
	        check.setEditor(columnConfigs.get(0).getEditor());
	        columnConfigs.set(0, check);

	        check.setRenderer(columnConfigs.get(0).getRenderer());  
	        grid.addPlugin(check);
	        grid.getView().setForceFit(false);


			cp01.add(yeta1100GridPanel); 
		  
			fieldSetGrd.add(cp01);
			plFrmYeta0100.add(fieldSetGrd);
		}

		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
		
		// 부서
		private void fnPopupCommP150(String deptNmStr) {
			//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	        //검색.처리하면됨. 
			MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptNmStr);  //부서
	           
			final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
	          
			popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
				public void handleEvent(BaseEvent be) {
					BaseModel mapModel = (BaseModel)be.getSource();
					
					if (!"".equals(mapModel.get("deptCd"))) {  
						deptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
						deptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
					}
				}
			});
		}	
		
			
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
						systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); // 시스템키
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

		private Yeta1100 getThis() {
			return this;
		}
		
		
		
		@Override
		public void reload() {

			IColumnFilter filters = null;
			yeta1100GridPanel.getTableDef().setTableColumnFilters(filters);
			
			yeta1100GridPanel.getTableDef().addColumnFilter("edacRvyy",MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"), SimpleColumnFilter.OPERATOR_EQUALS);	
			yeta1100GridPanel.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS);	
					 
			yeta1100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			yeta1100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 		
			
			
			String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			yeta1100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
			           
			String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
			yeta1100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
			
			String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
			yeta1100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
			
			yeta1100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);	
			yeta1100GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls( srhHanNm.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);	
			yeta1100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			yeta1100GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			
			yeta1100GridPanel.getTableDef().addColumnFilter("yetaDpcd", MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"), SimpleColumnFilter.OPERATOR_EQUALS);
			yeta1100GridPanel.getTableDef().addColumnFilter("busoprRgstnum", MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"), SimpleColumnFilter.OPERATOR_EQUALS);
			
			
			
			yeta1100GridPanel.reload();

		}
			   
			   
		// 엑셀 양식 저장
		private void xlsExportData() {

			HashMap<String, String> param = new HashMap<String, String>();
			param.put("yrtxBlggYr",MSFSharedUtils.getSelectedComboValue(srhClutYr, "year"));// 귀속년도
			param.put("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd, "commCd"));// 정산구분
			param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));// 단위기관
			param.put("emymtDivCd",MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));// 고용구분
			param.put("deptCd",YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));// 부서
			param.put("typOccuCd",YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));// 직종
			param.put("dtilOccuInttnCd", YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(),	"dtilOccuClsNm", "dtilOccuInttnCd"));// 직종세
			param.put("businCd",MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
			param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
			param.put("fnm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
			param.put("yetaDpcd", MSFSharedUtils.getSelectedComboValue(srhYetaDpcd, "yetaDpcd"));
			param.put("busoprRgstnum", MSFSharedUtils.getSelectedComboValue(srhBusoprRgstnum, "busoprRgstnum"));
			
//			param.put("resnRegnNum",MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));

			if ("".equals(srhClutYr)) {
				MessageBox.info("", "년도는 필수 입니다.", null);

			} else if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils
					.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
				if ("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
							"사업명을 선택하십시요.", null);
				} else {
					yeta1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsYeta1100Export.do", "extgwtFrame", param);
				}
			} else {
				yeta1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL()+ "exp/XlsYeta1100Export.do", "extgwtFrame", param);
			}
		}	   
		
		
			
		public native String getDetailTemplate() /*-{
			return [ '<div class="details">', '<tpl for=".">',
					'<img src="{modPath}"><div class="details-info">',
					'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
					'<span>{sizeString}</span>', '<b>Last Modified:</b>',
					'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
					.join("");
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
			public void funcLogMessage(String wndName, String wndId) {
		
				ShowMessageBM smForm = new ShowMessageBM();
				smForm.setWindowId(wndId);
				smForm.setWindowNm(wndName);
				// 개별 화면 에러메시지 검색 팝업
				GWTUtils.funcLogMessage(smForm);
			}
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
		 

}
