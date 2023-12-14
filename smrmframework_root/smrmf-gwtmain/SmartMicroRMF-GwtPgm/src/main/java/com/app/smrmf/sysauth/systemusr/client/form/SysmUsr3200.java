package com.app.smrmf.sysauth.systemusr.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0200DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.sysauth.system.client.utils.SysmUtils;
import com.app.smrmf.sysauth.systemusr.client.form.defs.SysUsrHist0200Def;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr3200Service;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr3200ServiceAsync;
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
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
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
public class SysmUsr3200   extends MSFPanel {

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    
    private VerticalPanel vp;
    private FormPanel plFrmSysm3200; 
    private String txtForm = "";
    private XTemplate detailTp;
  
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
	private ButtonBar topSysm3200Bar;
//	private Button btnStts0100Init;
	private Button btnSysm3200Sreach;
	private Button btnSysm3200Del;
//	private Button btnStts0100Print;
	private Button btnSysm3200Excel;
   /**
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    * 검색변수 선언 
    * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    */
	
	
	private HiddenField<String> srhSystemkey;   					// 시스템키 
	
	private ComboBox<BaseModel> srhDataType;						// 조회구분
	private ComboBox<BaseModel> srhDateType;						// 기간구분
    private DateField srhDayS;      								// 시작일
    private DateField srhDayE;      								// 종료일
    
	private ComboBox<BaseModel> srhHourS;							// 시작시간
	private ComboBox<BaseModel> srhMinuteS;							// 시작분
	private ComboBox<BaseModel> srhHourE;							// 시작시간
	private ComboBox<BaseModel> srhMinuteE;							// 시작분
	
    
	private MSFMultiComboBox<ModelData> srhDeptCd; 					// 부서
	private TextField<String> srhHanNm; 							// 성명
	private TextField<String> srhResnRegnNum;						// 주민등록번호
	
	private List<ModelData> mDtalistDeptCd;							// 부서 멀티	

	private boolean mutilCombo = false;
	
	private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
//	private HiddenField<String> systemkey;	/** column SYSTEMKEY : systemkey */

   
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 **/
	
	
	// -------------- grid 선언 시작  ---------------
 	private SysUsrHist0200Def hist0200Def  = new SysUsrHist0200Def("");   //그리드 테이블 컬럼 define  
 	private MSFGridPanel hist0200GridPanel;
 	// -------------- grid 선언 종료  ---------------
	
	
		
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
	private BaseModel record;
    private Iterator<Record> records;
	
	
    // -------------- store 선언 시작 ---------------
	private ListStore<BaseModel> lsDataType 	    = new ListStore<BaseModel>();		// 조회구분콤보
	private ListStore<BaseModel> lsDateType 	    = new ListStore<BaseModel>();		// 기간구분콤보
	private ListStore<BaseModel> lsHour 	    		= new ListStore<BaseModel>();		// 시
	private ListStore<BaseModel> lsMinute 	    	= new ListStore<BaseModel>();		// 분
	private ListStore<BaseModel> lsDeptCd 		    = new ListStore<BaseModel>();		// 부서콤보
	private ListStore<BaseModel> lsUsrCd 		    = new ListStore<BaseModel>();		// 사용자콤보
	// -------------- store 선언 종료 ---------------
    
    
	// -------------- DTO 선언 시작 --------------
	private SysIfBass0300DTO sysIfBass0300Dto; 		//공통코드 dto
	private SysIfBass0400DTO sysIfBass0400Dto; 		//부서코드
    // -------------- DTO 선언 종료 --------------
    
    
	// -------------- 코드 호출 시작 --------------
	private SysmUsr3200ServiceAsync hist0200Service = SysmUsr3200Service.Util.getInstance();										//공통코드 
	// -------------- 코드 호출 종료 --------------
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */	

	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */		
    
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	    

	  /**
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	   **/
	   
	  	/**
	 	 * 권한설정 처리 체크 AuthAction
	 	 */
	  	private void checkHist0200Auth( String authAction, ListStore<BaseModel>bm) {
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
			 Field<?>[] fldArrField = {srhDeptCd};
			 gwtAuthorization.formAuthFieldConfig(fldArrField);
			 
			 srhDataType.setValue(lsDataType.findModel("commCd", "APP")); 				// 구분 셋팅
			 srhDateType.setValue(lsDateType.findModel("commCd", "DATE01")); 		// 기간 셋팅
			 
			 srhHourS.setValue(lsHour.findModel("commCd", "00")); 							// 시간셋팅
			 srhMinuteS.setValue(lsMinute.findModel("commCd", "00")); 					// 분셋팅
			 
			 srhHourE.setValue(lsHour.findModel("commCd", "23")); 							// 시간셋팅
			 srhMinuteE.setValue(lsMinute.findModel("commCd", "59")); 					// 분셋팅
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			  * 권한설정을 위한 콤보처리를 위한 메서드 종료
			  *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
		
		 }
		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker) { 
				 if (lsDeptCd.getCount() > 0 ) {
	        		   
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
		     
		
//			authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
//			authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
			authMapDef.put("srhDeptCd",Boolean.FALSE); 
		   // authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
		    
		   

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
		
		//버튼에 따른 Action
		private void doAction(ActionDatabase actionDatabase) {
			switch (actionDatabase) {
				case INSERT:
					this.actionDatabase = ActionDatabase.INSERT;
					hist0200FormSave();
					break;
				case UPDATE:
					this.actionDatabase = ActionDatabase.UPDATE;
					hist0200FormSave();
					break;
				case DELETE:
					this.actionDatabase = ActionDatabase.DELETE;
					hist0200FormSave();
					break;
			}
		}
		
		private void hist0200FormSave() {  
			if (MSFSharedUtils.paramNotNull(records)) { 
	              
				List<SysIfHist0200DTO> listHist0200dto = new ArrayList<SysIfHist0200DTO>();  
	                
				while (records.hasNext()) {
	              
					Record record = (Record) records.next(); 
	                BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
	                SysIfHist0200DTO Hist0200Dto = new SysIfHist0200DTO();  
	                
	                Hist0200Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    				/** column 사업장코드 : dpobCd */
	                Hist0200Dto.setUsrJobYr(MSFSharedUtils.allowNulls(bmMapModel.get("usrConnectYr")));    		/** column 사용자작업년도 : usrJobYr */
	                Hist0200Dto.setUsrId(MSFSharedUtils.allowNulls(bmMapModel.get("usrId")));   						/** column 사용자아이디 : usrId */
	                Hist0200Dto.setUsrJobSeilNum((Long) bmMapModel.get("usrJobSeilNum"));    						/** column 사용자작업일련번호 : usrJobSeilNum */
	                
	                listHist0200dto.add(Hist0200Dto);
				}  
	                
				if (listHist0200dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "삭제", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
	                
				hist0200Service.deleteHist0200(listHist0200dto, new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("deleteHist0200(" + actionDatabase.name() + ") : " + caught), null);
					}
					public void onSuccess(Integer result) { 
						if (result == 0) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
						} else {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
							reload();
						} 
					} 
				}); 
	              
			} else {
				MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
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
	  		
//	  		detailTp = XTemplate.create(getDetailTemplate());
	  		vp = new VerticalPanel();
	  		vp.setSpacing(10);
	  		createStts0100Form();  	// 화면 기본정보를 설정
	  		createSearchForm();		// 검색조건
	  		createMsfGridForm();  	// 출력화면
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
		public SysmUsr3200() {
			setSize("1010px", "700px");  
		} 

		public SysmUsr3200(String txtForm) {
		      this.txtForm = txtForm;
		}
	  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/		  
		
	private void createStts0100Form() {
			
		plFrmSysm3200 = new FormPanel();
//		plFrmSysm3200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 프로그램사용로그"));
		plFrmSysm3200.setHeadingText("ExTerms Ver1.0 - " + " - 프로그램사용로그");
		plFrmSysm3200.setIcon(MSFMainApp.ICONS.text());
		plFrmSysm3200.setPadding(2);
		plFrmSysm3200.setFrame(true);
		
		plFrmSysm3200.setSize("990px", "680px");
		plFrmSysm3200.setLayout(new FlowLayout());
		
 
		//멀티콤보박스 닫기 
		plFrmSysm3200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
	            
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						//부서
						srhDeptCd.showClose(ce);
						mutilCombo = false;
					} 
				}
			} 
		});
	        
		/** 상단 버튼 ButtonBar**/
		topSysm3200Bar = new ButtonBar();    
		topSysm3200Bar.setAlignment(HorizontalAlignment.RIGHT);
			    
//			btnStts0100Init = new Button("초기화");  
//			btnStts0100Init.setIcon(MSFMainApp.ICONS.new16());
//			topSysm3200Bar.add(btnStts0100Init);
			    
		      
		btnSysm3200Sreach = new Button("조 회");
		btnSysm3200Sreach.setIcon(MSFMainApp.ICONS.search());
		topSysm3200Bar.add(btnSysm3200Sreach);
		btnSysm3200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});
		
		btnSysm3200Del = new Button("삭 제");
		btnSysm3200Del.setIcon(MSFMainApp.ICONS.delete16());
		topSysm3200Bar.add(btnSysm3200Del);
		btnSysm3200Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				MessageBox.confirm("경고", "해당 데이터를 삭제하시겠습니까?", new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						// TODO Auto-generated method stub
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							Iterator<BaseModel> itBm  = hist0200GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
			                List<Record>  lsRec  = new ArrayList<Record>();
			                
			                while(itBm.hasNext()) {
			                	Record rec  = new Record(itBm.next()); 
			                    lsRec.add(rec);
			                } 
			                setListRecord(lsRec.iterator()); 
			                  
			                actionDatabase = ActionDatabase.DELETE;
			                doAction(actionDatabase);
						}else {
							return;
						}
					}
				});
			}
		});
		
		btnSysm3200Excel = new Button("엑 셀");  
		btnSysm3200Excel.setIcon(MSFMainApp.ICONS.excel16());
		topSysm3200Bar.add(btnSysm3200Excel); 
		btnSysm3200Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//엑셀저장  
    			excelFileExport();
    		}
    	});
		
 
		plFrmSysm3200.add(topSysm3200Bar);
		      
//		// 파일업로드 처리
//		plFrmSysm3200.setAction("myurl");
//		plFrmSysm3200.setEncoding(Encoding.MULTIPART);
//		plFrmSysm3200.setMethod(Method.POST);
		vp.add(plFrmSysm3200);

	}
  
		
	/** 검색조건 **/
    private void createSearchForm() { 
    	
        sysIfBass0300Dto = new SysIfBass0300DTO();
        sysIfBass0400Dto = new SysIfBass0400DTO();
        
        //--------------------조회구분 코드 불러 오는 함수 --------------------------------------------------
        lsDataType = new ListStore<BaseModel>();
		BaseModel DataTypeBaseModel = new BaseModel();
		DataTypeBaseModel.set("commCd", "APP");
		DataTypeBaseModel.set("commCdNm", "업무시스템");
		
		lsDataType.add(DataTypeBaseModel);
		DataTypeBaseModel = new BaseModel();
		DataTypeBaseModel.set("commCd", "WEB");
		DataTypeBaseModel.set("commCdNm", "마이페이지");
		lsDataType.add(DataTypeBaseModel);
        //--------------------조회구분 불러 오는 함수 --------------------------------------------------
		
		
        //--------------------기간 구분 코드 불러 오는 함수 --------------------------------------------------
		lsDateType = new ListStore<BaseModel>();
		
		BaseModel DateTypeBaseModel = new BaseModel();
		
		DateTypeBaseModel.set("commCd", "DATE04");
		DateTypeBaseModel.set("commCdNm", "1개월");
		lsDateType.add(DateTypeBaseModel);
		
		DateTypeBaseModel = new BaseModel();
		DateTypeBaseModel.set("commCd", "DATE03");
		DateTypeBaseModel.set("commCdNm", "3개월");
		lsDateType.add(DateTypeBaseModel);
		
		DateTypeBaseModel = new BaseModel();
		DateTypeBaseModel.set("commCd", "DATE02");
		DateTypeBaseModel.set("commCdNm", "6개월");
		lsDateType.add(DateTypeBaseModel);
		
		DateTypeBaseModel = new BaseModel();
		DateTypeBaseModel.set("commCd", "DATE01");
		DateTypeBaseModel.set("commCdNm", "1년");
		lsDateType.add(DateTypeBaseModel);
        //--------------------기간 구분 불러 오는 함수 --------------------------------------------------
		
		
        //--------------------시간 구분 코드 불러 오는 함수 --------------------------------------------------
		//시간
		hist0200Service.getHourList(new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				lsHour.add(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "시간코드 에러!", null);
			}
		});
		
		//분
		hist0200Service.getMinuteList(new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				lsMinute.add(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "분 에러!", null);
			}
		});
        //--------------------시간 구분 불러 오는 함수 --------------------------------------------------

        
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        sysIfBass0300Dto.setRpsttvCd("D001");		// 사용자구분
        lsUsrCd = SysifComServiceUtils.getSingleBass0300ComboData(sysIfBass0300Dto);
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        
        sysIfBass0400Dto.setDeptDspyYn("Y");
    	//--------------------부서 불러 오는 함수 ------------------------------------------------
        lsDeptCd = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
        //--------------------부서 불러 오는 함수 ------------------------------------------------
        lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
                mDtalistDeptCd = SysmUtils.getDeptCdModelData(lsDeptCd) ; 
                srhDeptCd.getInitStore().add(mDtalistDeptCd);
                
            }
        });     
		dpobCd = new HiddenField<String>(); 			// 사업장코드
		srhSystemkey = new HiddenField<String>(); 		// 시스템키
		
		plFrmSysm3200.setLayout(new FlowLayout());


		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		// fieldSet.setCheckboxToggle(false);
		
		LayoutContainer lcSchCol = new LayoutContainer();
		
		LayoutContainer lcSchCol1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcSchCol1_1 = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_1.setLayout(frmlytSch);
		
		srhDataType = new ComboBox<BaseModel>();
		srhDataType.setName("srhDataType");
		srhDataType.setForceSelection(true);
		srhDataType.setMinChars(1);
		srhDataType.setDisplayField("commCdNm");
		srhDataType.setValueField("commCd");
		srhDataType.setTriggerAction(TriggerAction.ALL);
    	srhDataType.setEmptyText("-- 구분선택 --");
    	srhDataType.setSelectOnFocus(true); 
    	srhDataType.setStore(lsDataType);  
    	srhDataType.setFieldLabel("구분");
    	
    	lcSchCol1_1.add(srhDataType, new FormData("100%"));
    	
		LayoutContainer lcSchCol1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_2.setLayout(frmlytSch);
		
		srhDateType = new ComboBox<BaseModel>();
		srhDateType.setName("srhDateType");
		srhDateType.setForceSelection(true);
		srhDateType.setMinChars(1);
		srhDateType.setDisplayField("commCdNm");
		srhDateType.setValueField("commCd");
		srhDateType.setTriggerAction(TriggerAction.ALL);
		srhDateType.setEmptyText("-- 구분선택 --");
		srhDateType.setSelectOnFocus(true); 
		srhDateType.setStore(lsDateType);  
    	srhDateType.setFieldLabel("기간");
		srhDateType.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// TODO Auto-generated method stub
				// 기간 선택에 따라 날짜를 보여준다.
				
				
				if("DATE04".equals(MSFSharedUtils.getSelectedComboValue(srhDateType))) {			// 1개월
					setInitDate("1month");
				}else if("DATE03".equals(MSFSharedUtils.getSelectedComboValue(srhDateType))) {		// 3개월
					setInitDate("3month");
				}else if("DATE02".equals(MSFSharedUtils.getSelectedComboValue(srhDateType))) {		// 6개월
					setInitDate("6month");
				}else if("DATE01".equals(MSFSharedUtils.getSelectedComboValue(srhDateType)) ){		// 1년
					setInitDate("year");
				}
			}
	    });
		lcSchCol1_2.add(srhDateType, new FormData("100%"));
    	
    	
    	
		LayoutContainer lcSchCol1_3 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcSchCol1_3_1 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_3_1.setLayout(frmlytSch);
		
     	srhDayS = new DateField();
     	srhDayS.setName("srhDayS");
     	srhDayS.setLabelSeparator("");
        new DateFieldMask(srhDayS, "9999.99.99"); 
        srhDayS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        lcSchCol1_3_1.add(srhDayS, new FormData("100%"));
        lcSchCol1_3.add(lcSchCol1_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
        
        
		LayoutContainer lcSchCol1_3_2 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_3_2.setLayout(frmlytSch);
		
     	srhDayE = new DateField();
     	srhDayE.setName("srhDayE");
        new DateFieldMask(srhDayE, "9999.99.99"); 
        srhDayE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        srhDayE.setLabelSeparator("~");

        
        lcSchCol1_3_2.add(srhDayE, new FormData("100%"));
        lcSchCol1_3.add(lcSchCol1_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
        
        
		LayoutContainer lcSchCol1_4 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcSchCol1_4_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(50);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_4_1.setLayout(frmlytSch);
		
		srhHourS = new ComboBox<BaseModel>();
		srhHourS.setName("srhHourS");
		srhHourS.setForceSelection(true);
		srhHourS.setMinChars(1);
		srhHourS.setDisplayField("commCd");
		srhHourS.setValueField("commCd");
		srhHourS.setTriggerAction(TriggerAction.ALL);
		srhHourS.setEmptyText("-- 시간선택 --");
		srhHourS.setSelectOnFocus(true); 
		srhHourS.setStore(lsHour);  
		srhHourS.setFieldLabel("시간");
    	lcSchCol1_4_1.add(srhHourS, new FormData("100%"));
		
    	lcSchCol1_4.add(lcSchCol1_4_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.325));
		
		LayoutContainer lcSchCol1_4_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_4_2.setLayout(frmlytSch);
		
		srhMinuteS = new ComboBox<BaseModel>();
		srhMinuteS.setName("srhMinuteS");
		srhMinuteS.setForceSelection(true);
		srhMinuteS.setMinChars(1);
		srhMinuteS.setDisplayField("commCd");
		srhMinuteS.setValueField("commCd");
		srhMinuteS.setTriggerAction(TriggerAction.ALL);
		srhMinuteS.setEmptyText("-- 시간선택 --");
		srhMinuteS.setSelectOnFocus(true); 
		srhMinuteS.setLabelSeparator(":");
		srhMinuteS.setStore(lsMinute);  
		lcSchCol1_4_2.add(srhMinuteS, new FormData("100%"));
		
    	lcSchCol1_4.add(lcSchCol1_4_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.225));
		
		LayoutContainer lcSchCol1_4_3 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(10);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_4_3.setLayout(frmlytSch);
		
		srhHourE = new ComboBox<BaseModel>();
		srhHourE.setName("srhHourE");
		srhHourE.setForceSelection(true);
		srhHourE.setMinChars(1);
		srhHourE.setDisplayField("commCd");
		srhHourE.setValueField("commCd");
		srhHourE.setTriggerAction(TriggerAction.ALL);
		srhHourE.setEmptyText("-- 시간선택 --");
		srhHourE.setSelectOnFocus(true); 
		srhHourE.setLabelSeparator("~");
		srhHourE.setStore(lsHour);  
		lcSchCol1_4_3.add(srhHourE, new FormData("100%"));
		
		lcSchCol1_4.add(lcSchCol1_4_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.225));
		
		LayoutContainer lcSchCol1_4_4 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(5);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_4_4.setLayout(frmlytSch);
		
		srhMinuteE = new ComboBox<BaseModel>();
		srhMinuteE.setName("srhMinuteE");
		srhMinuteE.setForceSelection(true);
		srhMinuteE.setMinChars(1);
		srhMinuteE.setDisplayField("commCd");
		srhMinuteE.setValueField("commCd");
		srhMinuteE.setTriggerAction(TriggerAction.ALL);
		srhMinuteE.setEmptyText("-- 시간선택 --");
		srhMinuteE.setSelectOnFocus(true); 
		srhMinuteE.setLabelSeparator(":");
		srhMinuteE.setStore(lsMinute);  
		lcSchCol1_4_4.add(srhMinuteE, new FormData("100%"));
		
		lcSchCol1_4.add(lcSchCol1_4_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.225));
		
    	
//		LayoutContainer lcSchCol1_5 = new LayoutContainer();
//		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(40);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		lcSchCol1_5.setLayout(frmlytSch);
//		
//        srhDeptCd = new MSFMultiComboBox<ModelData>();
//        srhDeptCd.setName("srhDeptCd");
//        srhDeptCd.setEmptyText("--부서선택--");
//        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
//        srhDeptCd.getStore().add(mDtalistDeptCd);
//        srhDeptCd.setWidth(100);
//        srhDeptCd.setFieldLabel("부서");
//	    srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
//	        public void handleEvent(StoreEvent<ModelData> be) {  
//	        	  EventType type = be.getType();
//		    	   if (type == Store.Add) { 
//	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	           		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//	           		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	           		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//		        		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    		   	checkHist0200Auth("srhDeptCd", lsDeptCd); 
//	           	 	}
//	        	}
//	    	});    
//        srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//            @Override
//            public void handleEvent(ComponentEvent ce) {   
//                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//                    mutilCombo = true;
//                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//                    mutilCombo = true;
//                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//                    mutilCombo = false;
//                }  
//            } 
//        }); 
//        lcSchCol1_5.add(srhDeptCd, new FormData("100%"));
		
        
        lcSchCol1.add(lcSchCol1_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));			// 조회 구분
        lcSchCol1.add(lcSchCol1_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));			// 기간 구분
        lcSchCol1.add(lcSchCol1_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.235));		// 기간
        lcSchCol1.add(lcSchCol1_4,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));		// 시간
//        lcSchCol1.add(lcSchCol1_5,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.225));		// 부서
		
        
        LayoutContainer lcSchCol2 = new LayoutContainer(new ColumnLayout());
        
		LayoutContainer lcSchCol2_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(40);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol2_1.setLayout(frmlytSch);
		
        srhDeptCd = new MSFMultiComboBox<ModelData>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setEmptyText("--부서선택--");
        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
        srhDeptCd.getStore().add(mDtalistDeptCd);
        srhDeptCd.setWidth(100);
        srhDeptCd.setFieldLabel("부서");
	    srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	        public void handleEvent(StoreEvent<ModelData> be) {  
	        	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	           		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	           		  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	           		  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		        		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		    		   	checkHist0200Auth("srhDeptCd", lsDeptCd); 
	           	 	}
	        	}
	    	});    
        srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {   
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                }  
            } 
        }); 
        lcSchCol2_1.add(srhDeptCd, new FormData("100%"));
        
        
		LayoutContainer lcSchCol2_2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcSchCol_Nm = new LayoutContainer();
		lcSchCol_Nm.setLayout(new ColumnLayout());
		
		FormLayout frmlytSch_Nm = new FormLayout();  
		frmlytSch_Nm.setLabelWidth(40); 
		frmlytSch_Nm.setLabelAlign(LabelAlign.RIGHT); 
		lcSchCol_Nm.setLayout(frmlytSch_Nm);
        
        srhHanNm = new TextField<String>();
        srhHanNm.setName("srhHanNm");
        srhHanNm.setFieldLabel("성명");
        lcSchCol_Nm.add(srhHanNm, new FormData("100%"));
        srhHanNm.addKeyListener(new KeyListener() {
            public void componentKeyUp(ComponentEvent event) {
                super.componentKeyUp(event);
                srhHanNm.validate();
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	srhSystemkey.setValue("");
                    srhResnRegnNum.setValue(""); 
                    fnPopupPsnl0100();
                }
            }
        });
        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
                	srhSystemkey.setValue("");
                    srhResnRegnNum.setValue("");
                }
             
            } 
        }); 
        lcSchCol2_2.add(lcSchCol_Nm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
        lcSchCol_Nm.setBorders(false);
        
        
        LayoutContainer lcSchCol_btnHanNm = new LayoutContainer();
        
        FormLayout frmlytSch_btnHanNm = new FormLayout();  
        frmlytSch_btnHanNm.setLabelWidth(0); 
        frmlytSch_btnHanNm.setLabelAlign(LabelAlign.RIGHT); 
        lcSchCol_btnHanNm.setLayout(frmlytSch_btnHanNm);
        
        Button btnHanNm = new Button("검색");
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	srhSystemkey.setValue("");
                srhResnRegnNum.setValue("");  
                fnPopupPsnl0100() ;
            }
        });
        lcSchCol_btnHanNm.add(btnHanNm, new FormData("100%"));
        lcSchCol2_2.add(lcSchCol_btnHanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
        
        LayoutContainer lcSchCol_Jumin = new LayoutContainer();
        
        FormLayout frmlytSch_Jumin = new FormLayout();  
        frmlytSch_Jumin.setLabelAlign(LabelAlign.RIGHT); 
        lcSchCol_Jumin.setLayout(frmlytSch_Jumin);
        
        srhResnRegnNum = new TextField<String>();
        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");  
        srhResnRegnNum.setName("srhResnRegnNum");
        srhResnRegnNum.setHideLabel(true);
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
        lcSchCol_Jumin.add(srhResnRegnNum, new FormData("100%"));
        lcSchCol2_2.add(lcSchCol_Jumin, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
        
        
        lcSchCol2.add(lcSchCol2_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 성명
        lcSchCol2.add(lcSchCol2_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));			// 부서
        
        
        lcSchCol.add(lcSchCol1, new FormData("100%"));
        lcSchCol.add(lcSchCol2, new FormData("100%"));
        
		fieldSet.add(lcSchCol, new FormData("100%"));
		

		plFrmSysm3200.add(fieldSet);		
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

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
		
		
	private void createMsfGridForm() {
		

		FieldSet fieldSetGrd = new FieldSet();  
		fieldSetGrd.setHeadingHtml("");
		    
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();  
		lcStdGrid.setLayout(frmlytStd);  
		    
		ContentPanel cpGrid = new ContentPanel();   
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());  
		cpGrid.setSize(955, 500);
//		cpGrid.setSize(940, 430);
		    
		hist0200GridPanel = new MSFGridPanel(hist0200Def, false, false, false, false);
		hist0200GridPanel.setHeaderVisible(false);  
		hist0200GridPanel.setBodyBorder(true);
		hist0200GridPanel.setBorders(true);
		
		final Grid hist0200Grid = hist0200GridPanel.getMsfGrid().getGrid();
		hist0200Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (hist0200GridPanel.getCurrentlySelectedItem() != null) {    
//					setRecord(hist0100GridPanel.getCurrentlySelectedItem());
	   			} 
	   		}
		}); 
		cpGrid.add(hist0200GridPanel); 
	
		lcStdGrid.add(cpGrid);   
		fieldSetGrd.add(lcStdGrid);   
		
		LabelField lblfldNewLabelfield = new LabelField(" * 작업코드분류 : [C : 생성] [R : 읽기 ] [D : 삭제] [S : 조회] [B : 배치] "
														+ "[L : 로그인] [O : 로그아웃] , 구분 : [ APP : 업무페이지 ] [ WEB : 마이페이지 ]");
		fieldSetGrd.add(lblfldNewLabelfield, new FormData("100%"));
			      
		plFrmSysm3200.add(fieldSetGrd, new FormData("100%"));
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/


	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
		
	// 폼초기화 검색조건포함
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
		

	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}
	
	public void setRecord(BaseModel record) {
		this.record = record;
	}	
	
	public void setListRecord(Iterator<Record> records) {
	    this.records = records;
	 } 


	private SysmUsr3200 getThis() {
		return this;
	}
	
	public void reload() {
		
		//그리드 초기화
		hist0200GridPanel.getMsfGrid().clearData();
				    
		IColumnFilter filters = null;
		hist0200GridPanel.getTableDef().setTableColumnFilters(filters);
		
		hist0200GridPanel.getTableDef().addColumnFilter("usrConnectDivCd"
				, MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);								// 조회구분 
		
		hist0200GridPanel.getTableDef().addColumnFilter("usrConnectBgnnDtntm"
				, ( MSFSharedUtils.getConvertDateToString(srhDayS, "yyyyMMdd") + MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") 
						+ MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 				// 접속시작시간
		
		hist0200GridPanel.getTableDef().addColumnFilter("usrConnectEndDtntm"
				, ( MSFSharedUtils.getConvertDateToString(srhDayE, "yyyyMMdd") + MSFSharedUtils.getSelectedComboValue(srhHourE,"commCd") 
						+ MSFSharedUtils.getSelectedComboValue(srhMinuteE,"commCd")), SimpleColumnFilter.OPERATOR_EQUALS); 				// 접속종료시간
		
		String strDeptCd = MSFSharedUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		hist0200GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);							// 부서

		
		hist0200GridPanel.getTableDef().addColumnFilter("systemkey", srhSystemkey.getValue() , SimpleColumnFilter.OPERATOR_EQUALS);	// 시스템키
		
		hist0200GridPanel.reload();
		
	}
	
	//엑셀 저장
	private void excelFileExport() {
	                     
		HashMap<String, String> param = new HashMap<String, String>(); 
	   
		param.put("usrConnectDivCd", MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"));															// 조회구분 
		param.put("usrConnectBgnnDtntm", ( MSFSharedUtils.getConvertDateToString(srhDayS, "yyyyMMdd") 
				+ MSFSharedUtils.getSelectedComboValue(srhHourS,"commCd") + MSFSharedUtils.getSelectedComboValue(srhMinuteS,"commCd")));	// 접속시작시간
		param.put("usrConnectEndDtntm", ( MSFSharedUtils.getConvertDateToString(srhDayE, "yyyyMMdd") 
				+ MSFSharedUtils.getSelectedComboValue(srhHourE,"commCd") + MSFSharedUtils.getSelectedComboValue(srhMinuteE,"commCd")));	// 접속종료시간
		param.put("deptCd", MSFSharedUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));						// 부서
		param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));																			// 시스템키
	                     
	                     
				           
		if("".equals(srhDataType)){
			MessageBox.info("", "구분은 필수입니다.", null);
		}else{ 
			hist0200GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileSysm3200Export.do","extgwtFrame" ,param);  
		}
	}	
	
    
	// 기간 셋팅
	private void setInitDate(String flag) {
		
		Calendar  intiCal =  Calendar.getInstance(); 
		
		if("year".equals(flag)) {
			
			intiCal =  Calendar.getInstance(); 
			intiCal.setTime(new Date());
			srhDayE.setValue(intiCal.getTime());
			
			
        	 intiCal =  Calendar.getInstance(); 
    		intiCal.setTime(srhDayE.getValue());
    		intiCal.add(Calendar.YEAR, -1);
    		intiCal.add(Calendar.DATE, +1);
    		
    		srhDayS.setValue(intiCal.getTime());
		    
		}else if("1month".equals(flag)) {
			
			intiCal =  Calendar.getInstance(); 
			intiCal.setTime(new Date());
			srhDayE.setValue(intiCal.getTime());
			
			intiCal =  Calendar.getInstance(); 
    		intiCal.setTime(srhDayE.getValue());
    		intiCal.add(Calendar.MONTH, -1);
    		intiCal.add(Calendar.DATE, +1);
    		
    		srhDayS.setValue(intiCal.getTime());
    		
		}else if("3month".equals(flag)) {
			
			intiCal =  Calendar.getInstance(); 
			intiCal.setTime(new Date());
			srhDayE.setValue(intiCal.getTime());
			
			intiCal =  Calendar.getInstance(); 
    		intiCal.setTime(srhDayE.getValue());
    		intiCal.add(Calendar.MONTH, -3);
    		intiCal.add(Calendar.DATE, +1);
    		
    		srhDayS.setValue(intiCal.getTime());
    		
		}else if("6month".equals(flag)) {
			
			intiCal =  Calendar.getInstance(); 
			intiCal.setTime(new Date());
			srhDayE.setValue(intiCal.getTime());
			
			intiCal =  Calendar.getInstance(); 
    		intiCal.setTime(srhDayE.getValue());
    		intiCal.add(Calendar.MONTH, -6);
    		intiCal.add(Calendar.DATE, +1);
    		
    		srhDayS.setValue(intiCal.getTime());
		}
	    
	}
	
	
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/
	//성명
	private void fnPopupPsnl0100()  {
        MSFFormPanel popCom0100 = SysifComServiceUtils.lovPopUpMsfCom0100Form(srhHanNm.getValue());  //인사 
         
        final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
         
        popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
        	public void handleEvent(BaseEvent be) {
        		BaseModel mapModel = (BaseModel)be.getSource();
        		if (!"".equals(mapModel.get("systemkey"))) { 
                      
        			srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   			//시스템키
                    srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));						//성명
                    srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));	//주민번호 
        		}  
        	}
        });
	 }
	
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 종료
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/	

		
//	public native String getDetailTemplate() /*-{
//												return ['<div class="details">',
//												'<tpl for=".">',
//												'<img src="{modPath}"><div class="details-info">',
//												'<b>Image Name:</b>',
//												'<span>{name}</span>',
//												'<b>Size:</b>',
//												'<span>{sizeString}</span>',
//												'<b>Last Modified:</b>',
//												'<span>{dateString}</span></div>',
//												'</tpl>',
//												'</div>'].join("");
//												}-*/; 


}
