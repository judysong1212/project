package com.app.exterms.basis.client.form;

import java.util.Date;
import java.util.HashMap;

import com.app.exterms.basis.client.dto.Bass5510DTO;
import com.app.exterms.basis.client.form.defs.Bass5510Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.lookup.LookupBass5510ApptnStdBgnnDt;
import com.app.exterms.basis.client.lookup.LookupBass5510ApptnYr;
import com.app.exterms.basis.client.service.Bass5510Service;
import com.app.exterms.basis.client.service.Bass5510ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bass5510  extends MSFPanel { 

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
	  private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
	
 		
	  private VerticalPanel vp;
	  private FormPanel plFrmBass5510;
	//  private FormData formData; 
	  private String txtForm = "";  
	  
	  private Bass5510Def bass5510Def  = new Bass5510Def();   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel bass5510GridPanel;
      
      private LookupBass5510ApptnYr lkApptnYr = new LookupBass5510ApptnYr();  
      private MSFGridPanel apptnYrGridPanel;
      
      //일자처리콤보 
      private LookupBass5510ApptnStdBgnnDt lkApptnStdBgnnDt = new LookupBass5510ApptnStdBgnnDt();  
      private MSFGridPanel apptnStdBgnnDtGridPanel;
      
      private String storeFlag;
      
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
      private ButtonBar topBass5510Bar;
      private Button btnBass5510New;
      private Button btnBass5510Save;
      private Button btnBass5510Del;
      private Button btnBass5510Sreach;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ComboBox<BaseModel> srhApptnYr;   		/** column 적용년도 : apptnYr */  
      private ComboBox<BaseModel> srhApptnStdBgnnDt;   	/** column 적용기준시작일자 : apptnStdBgnnDt */
      
      private ComboBox<BaseModel> creApptnYr;			// 적용년도
      private ComboBox<BaseModel> crdApptnStdBgnnDt;	// 적용일자
      private ComboBox<BaseModel> creTransferYr;		// 이관년도
      private DateField creTransferStdBgnnDt;			// 이관일자
       
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      private ComboBox<BaseModel> createApptnYr;   /** column 년도 : payYr */  
      private DateField  createApptnStdBgnnDt;   /** column 년도 : payYr */  
      
      private FileUploadField bass5510flUp;
      private Boolean picBoolFile;
      
//    private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//    private TextField<String> apptnYr   /** column 적용년도 : apptnYr */
//
//    private TextField<String> eandIncmTxtbSimfTxsNum   /** column 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
//
//    private TextField<String> apptnStdBgnnDt   /** column 적용기준시작일자 : apptnStdBgnnDt */
//
//    private TextField<String> apptnStdEndDt   /** column 적용기준종료일자 : apptnStdEndDt */
//
//    private TextField<String> ovr   /** column 이상 : ovr */
//
//    private TextField<String> udr   /** column 미만 : udr */
//
//    private TextField<String> oneOfPepl   /** column 1인 : oneOfPepl */
//
//    private TextField<String> twoOfPepl   /** column 2인 : twoOfPepl */
//
//    private TextField<String> treOfGerl   /** column 3인일반 : treOfGerl */
//
//    private TextField<String> treOfMlchd   /** column 3인다자녀 : treOfMlchd */
//
//    private TextField<String> furOfGerl   /** column 4인일반 : furOfGerl */
//
//    private TextField<String> furOfMlchd   /** column 4인다자녀 : furOfMlchd */
//
//    private TextField<String> fveOfGerl   /** column 5인일반 : fveOfGerl */
//
//    private TextField<String> fveOfMlchd   /** column 5인다자녀 : fveOfMlchd */
//
//    private TextField<String> sixOfGerl   /** column 6인일반 : sixOfGerl */
//
//    private TextField<String> sixOfMlchd   /** column 6인다자녀 : sixOfMlchd */
//
//    private TextField<String> svnOfGerl   /** column 7인일반 : svnOfGerl */
//
//    private TextField<String> svnOfMlchd   /** column 7인다자녀 : svnOfMlchd */
//
//    private TextField<String> egtOfGerl   /** column 8인일반 : egtOfGerl */
//
//    private TextField<String> egtOfMlchd   /** column 8인다자녀 : egtOfMlchd */
//
//    private TextField<String> nineOfGerl   /** column 9인일반 : nineOfGerl */
//
//    private TextField<String> nineOfMlchd   /** column 9인다자녀 : nineOfMlchd */
//
//    private TextField<String> tenOfGerl   /** column 10인일반 : tenOfGerl */
//
//    private TextField<String> tenOfMlchd   /** column 10인다자녀 : tenOfMlchd */
//
//    private TextField<String> evthOfGerl   /** column 11인일반 : evthOfGerl */
//
//    private TextField<String> evthOfMlchd   /** column 11인다자녀 : evthOfMlchd */
//
//    private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//    private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//    private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//    private TextField<String> ismt   /** column 수정자 : ismt */
//
//    private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//    private TextField<String> revnAddr   /** column 수정주소 : revnAddr */    
	 
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
  	private Bass5510ServiceAsync payr1100Service = Bass5510Service.Util.getInstance();	    
  	private ListStore<BaseModel> apptnYrSrhStore = new ListStore<BaseModel>();
  	private ListStore<BaseModel> apptnStdBgnnDtSrhStore = new ListStore<BaseModel>();
  	private ListStore<BaseModel> creStdBgnnDtSrhStore = new ListStore<BaseModel>();
  	private ListStore<BaseModel> lscrPayYr = new ListStore<BaseModel>();
  	private ListStore<BaseModel> lscrPayYr01 = new ListStore<BaseModel>();
  	private ListStore<BaseModel> lscrPayYr02 = new ListStore<BaseModel>();
  	 
	private SysCoCalendarDTO  msfCoCalendarDto;   
	
	private BaseModel record;
  	
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
 
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnBass5510Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnBass5510Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnBass5510Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
	  
    private void doAction(final ActionDatabase actionDatabase) {
    	
		String msg = "";
	    	
		if((ActionDatabase.DELETE).equals(actionDatabase)) {
			msg = "삭제";
		}else if((ActionDatabase.INSERT).equals(actionDatabase)){
			msg = "저장";
		}
		
		//선택된 데이터가 있는지 여부를 체크 함. 년도는 필수 선택임 
		if ( MSFSharedUtils.paramNull(srhApptnYr.getRawValue()) ) {
			  MessageBox.alert("데이터 오류", "검색조건 년도는 필수 선택사항입니다.", null);
			  srhApptnYr.focus();
	          return;
		}
		
		if ( MSFSharedUtils.paramNull(srhApptnStdBgnnDt.getRawValue()) ) {
			  MessageBox.alert("데이터 오류", "검색조건 기준일자는 필수 선택사항입니다.", null);
			  srhApptnStdBgnnDt.focus();
	          return;
		}
    	
		MessageBox.confirm("알림", "해당 간이세액표를 " + msg + "하시겠습니까?",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					Bass5510DTO bass5510Dto = new Bass5510DTO();
					
					bass5510Dto.setApptnYr(MSFSharedUtils.getSelectedComboValue(srhApptnYr,"apptnYr"));	//적용년도
					bass5510Dto.setApptnStdBgnnDt(MSFSharedUtils.getSelectedComboValue(srhApptnStdBgnnDt,"apptnStdBgnnDt"));//기준일자
					
			    	payr1100Service.activityOnBass5510(bass5510Dto, actionDatabase, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
			                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass5510(" + actionDatabase.name() + ") : " + caught), null);
						}
						public void onSuccess(Long result) { 
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
								
								reload();
								
								//년도 store 재조회
								storeFlag = new String();
				  	    		storeFlag = "all";
				  	    		
								apptnYrGridPanel.reload();
//								actionDatabase = ActionDatabase.UPDATE;
							} 
						} 
					});
				}
			}
		});
    	
    	
    	

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
 
	  
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	     
//	  //  formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createBass5510Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createCheckBoxGrid();    //간이조건세액표
//	    createXlsForm();    //엑셀업로드기능
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	  public ContentPanel getViewPanel(){
			if(panel == null){
				
				  //  formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createBass5510Form();  	//화면 기본정보를 설정
			    createSearchForm();    	//검색필드를 적용
			    createTransForm();		//간이소득세액이관
			    createCheckBoxGrid();	//간이조건세액표
			    createXlsForm();    	//엑셀업로드기능
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
	  public Bass5510() {
		    
			setSize("1010px", "700px");  
	  } 
	
	  public Bass5510(String txtForm) {
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
	  
	  private void createBass5510Form() {
		  
		plFrmBass5510 = new FormPanel();
		plFrmBass5510.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblBasisConst.title_Bass5510());
		//plFrmBass5510.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 간이소득세액표관리");
		plFrmBass5510.setIcon(MSFMainApp.ICONS.text());
		plFrmBass5510.setBodyStyleName("pad-text");
		plFrmBass5510.setPadding(2);
		plFrmBass5510.setFrame(true); 
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblBasisConst.title_Bass5510(),"BASS5510");
				}
			});
		plFrmBass5510.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass5510.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		 topBass5510Bar = new ButtonBar();    
		 topBass5510Bar.setAlignment(HorizontalAlignment.RIGHT);
//	      buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {   
//	        public void componentSelected(ButtonEvent ce) {   
//	         
//	        }   
//	      }));   
//	      buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {   
//	        public void componentSelected(ButtonEvent ce) {   
//	           
//	        }   
//	      }));    
	  
	  	btnBass5510Sreach = new Button("조회"); 
	  	btnBass5510Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topBass5510Bar.add(btnBass5510Sreach);
	  	btnBass5510Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//조회버튼 클릭시 처리 
    		    reload();  
    		}
    	});
	  	
	  	btnBass5510Del = new Button("삭제"); 
	  	btnBass5510Del.setIcon(MSFMainApp.ICONS.delete16());
	  	topBass5510Bar.add(btnBass5510Del);
	  	btnBass5510Del.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			MessageBox.confirm("경고", "데이터를 삭제하시겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
    				@Override
    				public void handleEvent(MessageBoxEvent be) {
    					//if("Yes".equals(be.getButtonClicked().getText())){
    					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
    						actionDatabase = ActionDatabase.DELETE;
    						doAction(actionDatabase);
    					}
    				}
    			});
    		}
    	});
//	  	topBtn = new Button("인쇄"); 
//	  	topBtn.setIcon(MSFMainApp.ICONS.text()); 
//	  	buttonBar.add(topBtn);  
	  	
	  	plFrmBass5510.add(topBass5510Bar);    	
	  	
	  //파일업로드 처리
	  	plFrmBass5510.setAction("myurl");
	  	plFrmBass5510.setEncoding(Encoding.MULTIPART);
  		plFrmBass5510.setMethod(Method.POST);
	  	
		vp.add(plFrmBass5510);
		plFrmBass5510.setSize("990px", "690px");
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
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 년도 콤보박스 처리  시작
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
 */
		ContentPanel apptnYrGrid = new ContentPanel();
		apptnYrGrid.setVisible(false);
		    
		//년도 콤보처리 
		apptnYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
		apptnYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
			public void handleEvent(ComponentEvent be) {  
				apptnYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
					public void handleEvent(StoreEvent<BaseModel> be) {  
						
//						// -- 초기화 -- 
//						srhApptnYr.setStore(new ListStore<BaseModel>());
//						srhApptnYr.setValue(new BaseModel());
//						apptnYrSrhStore.removeAll();
//    					// -- 초기화 -- 
						
						apptnYrSrhStore.add(apptnYrGridPanel.getMsfGrid().getStore().getModels()); 
						lscrPayYr01.add(apptnYrGridPanel.getMsfGrid().getStore().getModels()); 
			        	 
						//Date today = new Date(); 
						// A custom date format
						// DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
						
						BaseModel bm = new BaseModel();
						
						if("srh".equals(storeFlag)) {
							
							bm = new BaseModel();
							bm  =  srhApptnYr.getStore().findModel("apptnYr", DateTimeFormat.getFormat("yyyy").format(new Date())); 
							srhApptnYr.setValue(bm);
							
						}else if("cre".equals(storeFlag)) {
							bm = new BaseModel();
							bm  =  creApptnYr.getStore().findModel("apptnYr", DateTimeFormat.getFormat("yyyy").format(new Date())); 
							creApptnYr.setValue(bm);
							
						}else if("all".equals(storeFlag)){
							
							// -- 초기화 -- 
							srhApptnYr.setStore(new ListStore<BaseModel>());
							srhApptnYr.setValue(new BaseModel());
							apptnYrSrhStore.removeAll();
	    					// -- 초기화 -- 
	    					
	    					// -- 초기화 -- 
	    					crdApptnStdBgnnDt.setStore(new ListStore<BaseModel>());
	    					crdApptnStdBgnnDt.setValue(new BaseModel());
	    					lscrPayYr01.removeAll();
	    					// -- 초기화 -- 
	    					
	    					apptnYrSrhStore.add(apptnYrGridPanel.getMsfGrid().getStore().getModels()); 
							lscrPayYr01.add(apptnYrGridPanel.getMsfGrid().getStore().getModels()); 
							
							bm = new BaseModel();
							bm  =  srhApptnYr.getStore().findModel("apptnYr", DateTimeFormat.getFormat("yyyy").format(new Date())); 
							srhApptnYr.setValue(bm);
							srhApptnYr.setStore(apptnYrSrhStore);
							
							bm = new BaseModel();
							bm  =  creApptnYr.getStore().findModel("apptnYr", DateTimeFormat.getFormat("yyyy").format(new Date())); 
							creApptnYr.setValue(bm);
							creApptnYr.setStore(lscrPayYr01);
						}
					}
				});
			}
		});
		apptnYrGrid.add(apptnYrGridPanel); 
	    plFrmBass5510.add(apptnYrGrid);
	    
	    //일자가져오기 
	    apptnStdBgnnDtGridPanel = new MSFGridPanel(lkApptnStdBgnnDt, false, false, false, true); 
	    apptnStdBgnnDtGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
	    	public void handleEvent(ComponentEvent be) {  
	    		apptnStdBgnnDtGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	    				if("srh".equals(storeFlag)) {
	    					// -- 초기화 -- 
	    					srhApptnStdBgnnDt.setStore(new ListStore<BaseModel>());
	    					srhApptnStdBgnnDt.setValue(new BaseModel());
	    					apptnStdBgnnDtSrhStore.removeAll();
	    					// -- 초기화 -- 
	    					
	    					apptnStdBgnnDtSrhStore.add(apptnStdBgnnDtGridPanel.getMsfGrid().getStore().getModels());
		    				srhApptnStdBgnnDt.setStore(apptnStdBgnnDtSrhStore);
	    				}else if("cre".equals(storeFlag)) {
	    					// -- 초기화 -- 
	    					crdApptnStdBgnnDt.setStore(new ListStore<BaseModel>());
	    					crdApptnStdBgnnDt.setValue(new BaseModel());
	    					creStdBgnnDtSrhStore.removeAll();
	    					// -- 초기화 -- 
	    					
	    					creStdBgnnDtSrhStore.add(apptnStdBgnnDtGridPanel.getMsfGrid().getStore().getModels()); 	
			        	 	crdApptnStdBgnnDt.setStore(creStdBgnnDtSrhStore);
	    				}
	    			}
	    		});
	    	}
	    });
		  
		apptnYrGrid.add(apptnStdBgnnDtGridPanel);
		plFrmBass5510.add(apptnYrGrid);
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 년도 콤보박스 처리  종료 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
 */
	    
		plFrmBass5510.setLayout(new FlowLayout());

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
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(100); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	   // fieldSet.setLayout(layout);  
	    lcSchLeft.setLayout(frmlytSch);
	    
	    
        srhApptnYr = new ComboBox<BaseModel>();
	    srhApptnYr.setName("srhApptnYr");
	    srhApptnYr.setForceSelection(true);
	    srhApptnYr.setMinChars(1);
	    srhApptnYr.setDisplayField("apptnYrDisp");
	    srhApptnYr.setValueField("apptnYr");
	    srhApptnYr.setTriggerAction(TriggerAction.ALL);
	    srhApptnYr.setAllowBlank(true);
		srhApptnYr.setEmptyText("--년도선택--");
	    srhApptnYr.setSelectOnFocus(true); 
	    srhApptnYr.setReadOnly(false);
	    srhApptnYr.setEnabled(true); 
	    srhApptnYr.setStore(apptnYrSrhStore);  
	    srhApptnYr.setFieldLabel("적용년도");
	    srhApptnYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
  	    		
  	    		//년도 store 재조회
  	    		/** 엑셀 업로드 후 store 변경사항 반영하기 위해....**/
				storeFlag = new String();
  	    		storeFlag = "all";
  	    		apptnYrGridPanel.reload();
  	    		
  	    		storeFlag = new String();
  	    		storeFlag = "srh";
//  	    		apptnYrGridPanel.fireEvent(Events.Change);
  	    		IColumnFilter filters = null;
  	    		apptnStdBgnnDtGridPanel.getTableDef().setTableColumnFilters(filters);
  	    		apptnStdBgnnDtGridPanel.getTableDef().addColumnFilter("apptnYr", srhApptnYr.getRawValue(), SimpleColumnFilter.OPERATOR_LIKE); 
  	    		apptnStdBgnnDtGridPanel.reload();
  	    	} 
  	    });
	    
	    lcSchLeft.add(srhApptnYr, new FormData("100%")); 
	    
	    LayoutContainer lcSchRight = new LayoutContainer();
	    lcSchRight.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(100); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);    
	    lcSchRight.setLayout(frmlytSchRight);
	    
	    LayoutContainer layoutContainer = new LayoutContainer();
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(100); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);  
	    layoutContainer_1.setLayout(frmlytSchRight); 
	    
	    //DateTimePropertyEditor propertyEditor = new DateTimePropertyEditor();
        //propertyEditor.setFormat(DateTimeFormat.getFormat("yyyy.MM.dd"));
         
	    srhApptnStdBgnnDt = new ComboBox<BaseModel>();
		srhApptnStdBgnnDt.setName("srhApptnStdBgnnDt");
	    srhApptnStdBgnnDt.setForceSelection(true); 
	    srhApptnStdBgnnDt.setMinChars(1);
	    srhApptnStdBgnnDt.setDisplayField("apptnStdBgnnDtDisp");
	    srhApptnStdBgnnDt.setValueField("apptnStdBgnnDt");
	    srhApptnStdBgnnDt.setTriggerAction(TriggerAction.ALL);
		srhApptnStdBgnnDt.setEmptyText("--기준일자선택--");
	    srhApptnStdBgnnDt.setSelectOnFocus(true); 
	    srhApptnStdBgnnDt.setReadOnly(false);
	    srhApptnStdBgnnDt.setEnabled(true); 
	    srhApptnStdBgnnDt.setStore(apptnStdBgnnDtSrhStore);  
	    srhApptnStdBgnnDt.setFieldLabel("기준일자");
	   // srhApptnStdBgnnDt.setPropertyEditor(propertyEditor);
	    
	    
	    layoutContainer_1.add(srhApptnStdBgnnDt, new FormData("100%"));
	    layoutContainer_1.setBorders(false);
	    
	    layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
	    layoutContainer_2.setLayout(new FormLayout());
	    layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	    layoutContainer_2.setBorders(false);
	    lcSchRight.add(layoutContainer, new FormData("100%"));
	    layoutContainer.setLayout(new ColumnLayout());
	    layoutContainer.setBorders(false);
	  
 
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
	    lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7)); 
	    
		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmBass5510.add(fieldSet);

		// vp.add(panel);
	} 
	  
	/** 간이세액소득이관 **/
	private void createTransForm() {  
		
		
//		ContentPanel apptnYrGrid = new ContentPanel();  
//	    apptnYrGrid.setVisible(false);
//	    
//	    //년도 콤보처리 
//	    apptnYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
//		apptnYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//			public void handleEvent(ComponentEvent be) {  
//				apptnYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//					public void handleEvent(StoreEvent<BaseModel> be) {  
//						lscrPayYr01.add(apptnYrGridPanel.getMsfGrid().getStore().getModels()); 
//						//Date today = new Date(); 
//		        	    // A custom date format
//						// DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//						BaseModel  bm  =  creApptnYr.getStore().findModel("apptnYr", DateTimeFormat.getFormat("yyyy").format(new Date()) ); 
//						creApptnYr.setValue(bm);
//					}  
//				});  			       
//			}  
//		});  
//		apptnYrGrid.add(apptnYrGridPanel); 
//		
//	    //일자가져오기 
//	    apptnStdBgnnDtGridPanel = new MSFGridPanel(lkApptnStdBgnnDt, false, false, false, true); 
//	    apptnStdBgnnDtGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//	    	public void handleEvent(ComponentEvent be) {  
//	    		apptnStdBgnnDtGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//	    			public void handleEvent(StoreEvent<BaseModel> be) {  
//	    				apptnStdBgnnDtSrhStore.add(apptnStdBgnnDtGridPanel.getMsfGrid().getStore().getModels()); 		        	 
//	    			}  
//	    		});  		       
//	    	}  
//	    });  
//		  
//	    apptnYrGrid.add(apptnStdBgnnDtGridPanel); 
//	    plFrmBass5510.add(apptnYrGrid);
		     
		//--------------------년도 불러 오는 함수 ------------------------------------------------
	    msfCoCalendarDto = new SysCoCalendarDTO();
		lscrPayYr02 = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------년도 불러 오는 함수 ------------------------------------------------
		  
		FieldSet fieldSet2 = new FieldSet();
		fieldSet2.setHeadingHtml("간이세액소득이관");

		LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());

		LayoutContainer lcSch1 = new LayoutContainer();
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(80);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSch1.setLayout(frmlytSchRight);
		  
		creApptnYr = new ComboBox<BaseModel>();
		creApptnYr.setStore(lscrPayYr01);
		creApptnYr.setForceSelection(true);
		creApptnYr.setMinChars(1);
		creApptnYr.setDisplayField("apptnYrDisp");
		creApptnYr.setValueField("apptnYr");
		creApptnYr.setTriggerAction(TriggerAction.ALL);
		creApptnYr.setAllowBlank(true);
		creApptnYr.setEmptyText("--년도선택--");
		creApptnYr.setSelectOnFocus(true);
		creApptnYr.setReadOnly(false);
		creApptnYr.setEnabled(true);
		creApptnYr.setFieldLabel("적용년도");
		creApptnYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
  	    		
  	    		storeFlag = new String();
  	    		storeFlag = "cre";
  	    		
//  	    		creApptnYr.fireEvent(Events.Change);  	    		
				
  	    		IColumnFilter filters = null;
  	    		apptnStdBgnnDtGridPanel.getTableDef().setTableColumnFilters(filters);
  	    		apptnStdBgnnDtGridPanel.getTableDef().addColumnFilter("apptnYr", creApptnYr.getRawValue(), SimpleColumnFilter.OPERATOR_LIKE); 
  	    		apptnStdBgnnDtGridPanel.reload();
  	    	} 
  	    });
		lcSch1.add(creApptnYr, new FormData("100%"));
		lcSchCol2.add(lcSch1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
		    
		LayoutContainer lcSch2 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(80);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSch2.setLayout(frmlytSchRight);
		
		crdApptnStdBgnnDt = new ComboBox<BaseModel>();
		crdApptnStdBgnnDt.setName("crdApptnStdBgnnDt");
		crdApptnStdBgnnDt.setForceSelection(true); 
		crdApptnStdBgnnDt.setMinChars(1);
		crdApptnStdBgnnDt.setDisplayField("apptnStdBgnnDtDisp");
		crdApptnStdBgnnDt.setValueField("apptnStdBgnnDt");
		crdApptnStdBgnnDt.setTriggerAction(TriggerAction.ALL);
		crdApptnStdBgnnDt.setEmptyText("--일자선택--");
		crdApptnStdBgnnDt.setSelectOnFocus(true); 
		crdApptnStdBgnnDt.setReadOnly(false);
		crdApptnStdBgnnDt.setEnabled(true); 
		crdApptnStdBgnnDt.setStore(creStdBgnnDtSrhStore);  
		crdApptnStdBgnnDt.setFieldLabel("기준일자");

		lcSch2.add(crdApptnStdBgnnDt, new FormData("100%"));
		lcSchCol2.add(lcSch2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		
		LayoutContainer lcSch3 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(80);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSch3.setLayout(frmlytSchRight);
		
		creTransferYr = new ComboBox<BaseModel>();
		creTransferYr.setStore(lscrPayYr02);
//		    creTransferYr.setName("creTransferYr");
		creTransferYr.setForceSelection(true);
		creTransferYr.setMinChars(1);
		creTransferYr.setDisplayField("yearDisp");
		creTransferYr.setValueField("year");
		creTransferYr.setTriggerAction(TriggerAction.ALL);
		creTransferYr.setAllowBlank(true);
		creTransferYr.setEmptyText("--년도선택--");
		creTransferYr.setSelectOnFocus(true);
		creTransferYr.setReadOnly(false);
		creTransferYr.setEnabled(true);
		creTransferYr.setStore(lscrPayYr02); 
		creTransferYr.setFieldLabel("이관년도");
		lscrPayYr02.addStoreListener(new StoreListener<BaseModel>() {
			@Override
			public void storeAdd(StoreEvent<BaseModel> se) {
				Date today = new Date(); 
				// A custom date format
				DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
          	 
				BaseModel  bm  =  creTransferYr.getStore().findModel("year", fmt.format(today)); 
				creTransferYr.setValue(bm); 
			}
		});
	   // srhApptnStdBgnnDt.setPropertyEditor(propertyEditor);
		lcSch3.add(creTransferYr, new FormData("100%"));
		lcSchCol2.add(lcSch3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		LayoutContainer lcSch4 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(80);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSch4.setLayout(frmlytSchRight);
		
		creTransferStdBgnnDt = new DateField(); 
		new DateFieldMask(creTransferStdBgnnDt, "9999.99.99");
		creTransferStdBgnnDt.setFieldLabel("적용일자");
		creTransferStdBgnnDt.setFormatValue(true);
		creTransferStdBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		creTransferStdBgnnDt.setValue(new Date());
		lcSch4.add(creTransferStdBgnnDt, new FormData("100%"));
		lcSchCol2.add(lcSch4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		LayoutContainer lcSchBtn2 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
//		frmlytSchRight.setLabelWidth(80);
//		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchBtn2.setLayout(frmlytSchRight); 
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		    
		Button btnTranster = new Button("간이소득세액이관");
//		lcSchBtn2.add(btnTranster, new FormData("100%"));
		btnTranster.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 간이소득세액이관
				bass5510Transfer();
			}
		});
		btnBar.add(btnTranster);
		lcSchBtn2.add(btnBar, new FormData("100%"));
		lcSchCol2.add(lcSchBtn2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		fieldSet2.add(lcSchCol2, new FormData("100%"));
		
		plFrmBass5510.add(fieldSet2);
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
   
	  
	  private void createXlsForm() {
		  
		  
		      msfCoCalendarDto = new SysCoCalendarDTO();
		     
		     //--------------------급여년도 불러 오는 함수 ------------------------------------------------
		     lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		     
//		     lscrPayYr01 = lscrPayYr;
//		     lscrPayYr02 = lscrPayYr;
			 //--------------------급여년도 불러 오는 함수 ------------------------------------------------
		     
		     
		     
		     
			FieldSet fldstNewFieldset = new FieldSet();
			
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new FlowLayout(5));
			
			LayoutContainer layoutContainer03 = new LayoutContainer();
			layoutContainer03.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer031 = new LayoutContainer();
			FormLayout frmlytSch1 = new FormLayout();  
			frmlytSch1.setLabelWidth(100); 
			frmlytSch1.setLabelAlign(LabelAlign.RIGHT);   
			layoutContainer031.setLayout(frmlytSch1); 
			
			
			createApptnYr = new ComboBox<BaseModel>();
			createApptnYr.setName("createApptnYr");
		   // createApptnYr.setName("srhApptnYr");
			createApptnYr.setForceSelection(true);
			createApptnYr.setMinChars(1);
			createApptnYr.setDisplayField("yearDisp");
			createApptnYr.setValueField("year");
			createApptnYr.setTriggerAction(TriggerAction.ALL);
		    createApptnYr.setAllowBlank(false);
			// createApptnYr.setEmptyText("--년도선택--");
		    createApptnYr.setSelectOnFocus(true); 
		    createApptnYr.setReadOnly(false);
		    createApptnYr.setEnabled(true); 
		    createApptnYr.setStore(lscrPayYr);  
		    createApptnYr.setFieldLabel("년도"); 
		    createApptnYr.setLazyRender(false);
		    lscrPayYr.addStoreListener(new StoreListener<BaseModel>() {

	            @Override
	            public void storeAdd(StoreEvent<BaseModel> se) {
	            	 Date today = new Date(); 
          	     // A custom date format
          	     DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
          	 
        	     BaseModel  bm  =  createApptnYr.getStore().findModel("year", fmt.format(today) ); 
        	     createApptnYr.setValue(bm); 
	            }
	        });

//		    createApptnYr.getStore().addStoreListener(new StoreListener<BaseModel>(){
//			@Override
//			public void storeDataChanged(StoreEvent<BaseModel> se) {
//				super.storeDataChanged(se);
//                 List<BaseModel> list = new ArrayList<BaseModel>();
//				 list.add(createApptnYr.getStore().getAt(0));
//				 createApptnYr.setSelection(list);
//               }
//            }); 
//		    lscrPayYr.addStoreListener(new StoreListener() { 
		    	 
//            @Override
//            public void storeUpdate(StoreEvent se) {
//              	 super.storeUpdate(se);
//              	 
//            	 Date today = new Date(); 
//          	     // A custom date format
//          	     DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//          	 
//        	     BaseModel  bm  =  createApptnYr.getStore().findModel("year", fmt.format(today) ); 
//        	     createApptnYr.setValue(bm); 
//            	
//            }
//           }); 
		    
			layoutContainer031.add(createApptnYr, new FormData("100%"));    
			    
						
			LayoutContainer layoutContainer032 = new LayoutContainer();
			frmlytSch1 = new FormLayout();  
			frmlytSch1.setLabelWidth(100); 
			frmlytSch1.setLabelAlign(LabelAlign.RIGHT);   
			layoutContainer032.setLayout(frmlytSch1); 
			
			 /** set 년월일 : yearMnthDay */
			createApptnStdBgnnDt = new DateField();
			createApptnStdBgnnDt.setName("createApptnStdBgnnDt");
			new DateFieldMask(createApptnStdBgnnDt, "9999.99.99");
			createApptnStdBgnnDt.setFieldLabel("적용일자");
			createApptnStdBgnnDt.setFormatValue(true);
			createApptnStdBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			createApptnStdBgnnDt.setValue(new Date());
			
			layoutContainer032.add(createApptnStdBgnnDt, new FormData("100%"));
			 
			layoutContainer03.add(layoutContainer031,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
			layoutContainer03.add(layoutContainer032,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
			 
			layoutContainer.add(layoutContainer03);
			
			
			LayoutContainer layoutContainer_1 = new LayoutContainer();
			layoutContainer_1.setLayout(new HBoxLayout()); 
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			layoutContainer_2.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
			layoutContainer_2.setLayout(frmlytSch);
			
			bass5510flUp = new FileUploadField();
			bass5510flUp.setFieldLabel("간이조건세액표");
			bass5510flUp.setName("bass5510flUp");
			bass5510flUp.setValidator(new Validator() {  
	       		@Override  
	       		public String validate(Field<?> field, String value) { 
	       			value = value.toLowerCase();        
	       			String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
	       			if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
	       				result = null;        
	       			}        
	       			return result;  
	       		} 
	       	});
			layoutContainer_2.add(bass5510flUp, new FormData("100%"));
			
			 
			HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
			hbld_layoutContainer_2.setFlex(1.0);
			layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
			layoutContainer_2.setBorders(false);
			
			LayoutContainer layoutContainer_4 = new LayoutContainer();
			layoutContainer_4.setStyleAttribute("paddingRight", "10px");
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
			layoutContainer_4.setLayout(frmlytSch);
			
			Button btnBass5510Save = new Button("저장");
			layoutContainer_4.add(btnBass5510Save, new FormData("100%"));
			btnBass5510Save.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {	
					// 엑셀 업로드
					xlsImportData();  
				}
			});
			layoutContainer_1.add(layoutContainer_4);
			layoutContainer_4.setBorders(false);
			
			LayoutContainer layoutContainer_3 = new LayoutContainer();
			layoutContainer_1.add(layoutContainer_3);
			layoutContainer_3.setStyleAttribute("paddingRight", "20px");
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(100); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
			layoutContainer_3.setLayout(frmlytSch);
			
			Button btnBass5510down = new Button("양식다운로드");
			btnBass5510down.addListener(Events.Select, new Listener<ButtonEvent>() {
	  	    	public void handleEvent(ButtonEvent e) {
//	  	    		bass5510GridPanel.callExportServlet("");
	  	    		xlsExportData();
	  	    	}
	  	    });
			layoutContainer_3.add(btnBass5510down, new FormData("100%"));
			layoutContainer_3.setBorders(false);
			
			layoutContainer.add(layoutContainer_1);
			layoutContainer_1.setBorders(false);
			fldstNewFieldset.add(layoutContainer);
			layoutContainer.setBorders(false);
		  	plFrmBass5510.add(fldstNewFieldset);
		  	fldstNewFieldset.setHeadingHtml("간이조건세액표-업로드");
		  	fldstNewFieldset.setStyleAttribute("marginTop", "10px");
		  
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


	  private void createCheckBoxGrid() {   
 
	       
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("간이조건세액표");
	    
	    LayoutContainer lcStdGrid = new LayoutContainer();
	  //  lcStdGrid.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytStd = new FormLayout();  
	  //  frmlytStd.setLabelWidth(85); 
	   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
	    lcStdGrid.setLayout(frmlytStd);  
	    
	    ContentPanel cpGrid = new ContentPanel();   
	    cpGrid.setBodyBorder(false); 
	    cpGrid.setHeaderVisible(false);   
	    cpGrid.setLayout(new FitLayout());      
	    cpGrid.setSize(952, 380);  
	    
	    //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
	    bass5510GridPanel = new MSFGridPanel(bass5510Def, false, false, false, false, false);
	    bass5510GridPanel.setHeaderVisible(false);  
	    bass5510GridPanel.setBodyBorder(true);
	    bass5510GridPanel.setBorders(true);
	 //   bass5510GridPanel.setFrame(true);
	  //  bass5510GridPanel.setSize(935, 400);  
	 //   bass5510GridPanel.showExportButton(true); 
     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	       
	    cpGrid.add(bass5510GridPanel); 
	    
	 
	    lcStdGrid.add(cpGrid);   
	    fieldSet.add(lcStdGrid);   
	      
	    plFrmBass5510.add(fieldSet);
	     
	  }     
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 
	// 간이소득세액이관
	private void bass5510Transfer() {
		
		//수정
		MessageBox.confirm("간이소득세액이관", "간이소득세액표를 이관하시겠습니까?<br>(등록되어있는 세액표가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					Bass5510DTO bass5510Dto = new Bass5510DTO();
					
					bass5510Dto.setApptnYr(MSFSharedUtils.getSelectedComboValue(creApptnYr,"apptnYr"));	//적용년도
					bass5510Dto.setApptnStdBgnnDt(MSFSharedUtils.getSelectedComboValue(crdApptnStdBgnnDt, "apptnStdBgnnDt"));//적용일자
					bass5510Dto.setCreTransferYr(MSFSharedUtils.getSelectedComboValue(creTransferYr, "year"));//이관년도
					bass5510Dto.setCreTransferStdBgnnDt(GWTUtils.getStringFromDate(creTransferStdBgnnDt.getValue(), "yyyyMMdd"));//이관일자
					
					
					payr1100Service.bass5510Transfer(bass5510Dto,  new AsyncCallback<Long>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							MessageBox.info("이관 실패", "세액표 이관에 실패하였습니다. <br>" + caught, null);
						}

						@Override
						public void onSuccess(Long result) {
							// TODO Auto-generated method stub
							if(result == 1) {
								
								//년도 store 재조회
								storeFlag = new String();
				  	    		storeFlag = "all";
				  	    		
								apptnYrGridPanel.reload();
								
								MessageBox.info("이관 성공", "이관에 성공하였습니다. <br> 세액표를 재조회 하시길 바랍니다.", null);
							}
						}
					});
				}
			}
		});
	}		  
	  
	  
	//세액표 업로드
	private void xlsImportData() { 
		
		MessageBox.confirm("간이조건세액표 업로드", "간이조건세액표를 생성하시겠습니까?<br>(등록되어있는 세액표가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
	      	@Override
	    	public void handleEvent(MessageBoxEvent be) {
	      		//if("Yes".equals(be.getButtonClicked().getText())){
	      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      			
//					HashMap<String, String> param = new HashMap<String, String>(); 
//					     		   
//					param.put("apptnYr", MSFSharedUtils.getSelectedComboValue(createApptnYr,"year"));
//					param.put("apptnStdBgnnDt", PayrUtils.getConvertDateToString(createApptnStdBgnnDt, "yyyyMMdd"));
					                  
					if("".equals(createApptnYr)){
						MessageBox.info("", "년도는 필수 입니다.", null);
					}else if("".equals(createApptnStdBgnnDt)){
						MessageBox.info("", "적용일자는 필수 입니다.", null);
					}else{ 
						String filename = MSFSharedUtils.allowNulls(bass5510flUp.getValue());
				       	if (filename.length() == 0) {
				       		Window.alert("선택된 파일이 없습니다.");
				       	} else {
				       		//submit the form
				       		plFrmBass5510.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
				                
				       		//파일업로드 처리
				            plFrmBass5510.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadBass5510Import.do");
							plFrmBass5510.setEncoding(Encoding.MULTIPART);
							plFrmBass5510.setMethod(Method.POST);
							plFrmBass5510.submit();
							plFrmBass5510.onFrameLoad();
							picBoolFile = true;
				       	}               
				       	// reset and unmask the form 
				        // after file upload 
				        plFrmBass5510.addListener(Events.Submit, new Listener<FormEvent>() {
				        	public void handleEvent(FormEvent evt) {   
				        		if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
				        			
				        			//업로드가  성공했으면 인서트 모듈을 태운다. 
				                  	plFrmBass5510.unmask();  
//				                   	MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.<br> 세액표를 재조회 하시길 바랍니다.", null); 
				                   	
//				                   	storeFlag = new String();
//				                   	storeFlag = "excel";
				                   	
//				                   	apptnStdBgnnDtGridPanel.reload();
				                   	picBoolFile = false;
				                   	evt.setResultHtml("");
				               	} else {
				               		if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
										// 업로드가 성공했으면 인서트 모듈을 태운다.
										MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
										picBoolFile = false;
										evt.setResultHtml("");
									} else {
										// 실패 메시지나 에러 메시지 처리 .
										evt.setResultHtml("");
									}
								}
							};
						});
					}
	      		}
	      	}
		});
	}	  
	  
	//엑셀 양식 저장
	private void xlsExportData() {
		
		HashMap<String, String> param = new HashMap<String, String>(); 
		   
		param.put("apptnYr", MSFSharedUtils.getSelectedComboValue(createApptnYr,"year"));
		param.put("apptnStdBgnnDt", GWTUtils.getStringFromDate(createApptnStdBgnnDt.getValue(), "yyyyMMdd"));
		
		
						           
		if("".equals(createApptnYr)){
			MessageBox.info("", "년도는 필수 입니다.", null);
		}else{ 
			bass5510GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsBass5510Export.do","extgwtFrame", param);   
		}
	}	
	
	  
	public void reload() {
			// TODO Auto-generated method stub
			//선택된 데이터가 있는지 여부를 체크 함. 년도는 필수 선택임 
			if ( MSFSharedUtils.paramNull(srhApptnYr.getRawValue()) ) {
				  MessageBox.alert("데이터 오류", "년도는 필수 선택사항입니다.", null);
				  srhApptnYr.focus();
		          return;
			}
			
			if ( MSFSharedUtils.paramNull(srhApptnStdBgnnDt.getRawValue()) ) {
				  MessageBox.alert("데이터 오류", "기준일자는 필수 선택사항입니다.", null);
				  srhApptnStdBgnnDt.focus();
		          return;
			}
			
			
			IColumnFilter filters = null;
			bass5510GridPanel.getTableDef().setTableColumnFilters(filters);
			
			bass5510GridPanel.getTableDef().addColumnFilter("apptnYr", MSFSharedUtils.allowNulls(srhApptnYr.getRawValue()), SimpleColumnFilter.OPERATOR_LIKE); 
			bass5510GridPanel.getTableDef().addColumnFilter("apptnStdBgnnDt", MSFSharedUtils.getSelectedComboValue(srhApptnStdBgnnDt,"apptnStdBgnnDt"), SimpleColumnFilter.OPERATOR_LIKE); 
		  
			bass5510GridPanel.reload();
		}
  
   public void setRecord(BaseModel record) {
       this.record = record;
   }
 

   private Bass5510 getThis(){
       return this;
   }
   


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
