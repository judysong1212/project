/**
 * 신규고용일괄등록
 */
package com.app.exterms.personal.client.form;
  

import com.app.exterms.personal.client.dto.Psnl0134DTO;
import com.app.exterms.personal.client.service.Psnl0134Service;
import com.app.exterms.personal.client.service.Psnl0134ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PsnlP010003   extends MSFFormPanel {  

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
 
	private  FormPanel cpPsnl010003; 
	  
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
 		private MSFPanel caller;
 		private Boolean reading = false;
 		public FormBinding formBinding;
// 		private String labelStr = "";
  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */	
 		private ButtonBar btnBar;	
		private Button btnReset;			// 초기화 버튼
		private Button btnSave;				// 저장 버튼
		private Button btnDelete;			// 삭제 버튼

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	* 검색변수 선언 
	* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	*/
		
		private HiddenField<String> dpobCd;  			// 사업장코드
		private HiddenField<String> systemkey;			// 시스템키
		private HiddenField<String> acmpInspnSeilNum;	// 수행시찰일련번호
		
		
		private TextField<String> acmpInspnTtl;			// 수행시찰제목	
		private ComboBox<BaseModel> acmpInspnDivCd;		// 수행시찰구분코드	
		private HiddenField<String> acmpInspnDivCdFld;	// 수행시찰구분코드	
//		private TextField<String> acmpInspnDivNm;		// 수행시찰구분명
		private DateField acmpInspnBgnnDt;				// 수행시찰시작일자	
		private DateField acmpInspnEndDt;				// 수행시찰종료일자	
		private TextField<String> acmpInspnNmCty;		// 수행시찰국명	
		private TextField<String> acmpInspnPurCtnt;		// 수행시찰목적내용	
		private TextField<String> acmpInspnRstCtnt;		// 수행시찰성과내용	
		private TextField<String> acmpInspnEtcCtnt;		// 수행시찰기타내용	
		private TextField<String> acmpInspnDys;			// 수행시찰기간수	
		

			
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
      
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
	    private void setPayr410001FormBinding() {
	 	 
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
 
	    private Psnl0134ServiceAsync psnl0134Service = Psnl0134Service.Util.getInstance();
	    private ListStore<BaseModel> listStoreA052 	= new ListStore<BaseModel>();  		// 시찰(수행)구분 
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드  
  		private Psnl0134DTO psnl0134Dto;
	    
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
  		
	private void doAction(ActionDatabase actionDatabase) {
    	
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			savePsnl0134();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			savePsnl0134();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			savePsnl0134();
			break;
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
 
	/**
	 *############################################################################# 
	 * 프로그램 종료  	  
	 *############################################################################# 
	 **/	  


  		/**
  		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
  		 * 	file upload  선언부 시작
  		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
  		 **/
  	 
//  	  FlowPanel panelImages = new FlowPanel();
//  	  OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
//  	    public void onLoad(PreloadedImage img) {
//  	      img.setWidth("75px");
//  	      panelImages.add(img);
//  	    }
//  	  };
//
//  	  protected UploaderConstants i18nStrs;;
//
//  	  private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
//  	    public void onFinish(IUploader uploader) {
//  	      if (uploader.getStatus() == Status.SUCCESS) {
//  	        for (String url : uploader.getServerMessage().getUploadedFileUrls()) {
//  	          new PreloadedImage(url, showImage);
//  	        }
//  	      }
//  	    }
//  	  };
		/**
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 	file upload  선언부 닫기
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 **/  
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/ 		    
	public PsnlP010003(final ActionDatabase ad, final MSFPanel caller) {
		    
 
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = ad;
		this.caller = caller;

		cpPsnl010003 = new FormPanel();
		
		
		createInfoForm(); 	// 검색필드를 적용

		cpPsnl010003.setBodyBorder(false);
		cpPsnl010003.setBorders(false);
		cpPsnl010003.setHeaderVisible(false);
		cpPsnl010003.setSize("470px", "210px");
	//	cpPsnl010003.add(single1);
		this.add(cpPsnl010003);
		formBinding = new FormBinding(this, true);

		this.setSize("480px", "220px");
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
	private void createPayrP410001Form() {

	}
	  
	private void createInfoForm() {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("A052");
		listStoreA052 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); 		// 관련근거
		
		
		dpobCd = new HiddenField<String>();	
		dpobCd.setName("dpobCd");
		cpPsnl010003.add(dpobCd);
		
		systemkey = new HiddenField<String>();	
	    systemkey.setName("systemkey");
		cpPsnl010003.add(systemkey);
		
		acmpInspnSeilNum = new HiddenField<String>();	
		acmpInspnSeilNum.setName("acmpInspnSeilNum");
		cpPsnl010003.add(acmpInspnSeilNum);	
		
		acmpInspnDivCdFld = new HiddenField<String>();	
		acmpInspnDivCdFld.setName("acmpInspnDivCdFld");
		cpPsnl010003.add(acmpInspnDivCdFld);	
		

		cpPsnl010003.setLayout(new FlowLayout());

		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");
		fieldSet.setBorders(false);
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setStyleAttribute("paddingRight", "40px");
		
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);
		
		
		acmpInspnTtl = new TextField<String>();
		acmpInspnTtl.setFieldLabel("제 목");
//		repbtyBusinNm.setReadOnly(false);
//		repbtyBusinNm.setEnabled(false);
		layoutContainer_1.add(acmpInspnTtl, new FormData("100%"));
		layoutContainer.add(layoutContainer_1);

		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
		
		
		acmpInspnDivCd = new ComboBox<BaseModel>();
		acmpInspnDivCd.setName("acmpInspnDivCd");
		acmpInspnDivCd.setFieldLabel("구 분");
		acmpInspnDivCd.setForceSelection(true);
		acmpInspnDivCd.setMinChars(1);
		acmpInspnDivCd.setDisplayField("commCdNm");
		acmpInspnDivCd.setValueField("commCd");
		acmpInspnDivCd.setTriggerAction(TriggerAction.ALL);
		acmpInspnDivCd.setEmptyText("--구분선택--");
		acmpInspnDivCd.setSelectOnFocus(true);
		acmpInspnDivCd.setReadOnly(true);
		acmpInspnDivCd.setStore(listStoreA052);
		acmpInspnDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				PersonalUtil.setSelectedComboValue(acmpInspnDivCd, acmpInspnDivCdFld.getValue(), "commCd");
			}
		});
		layoutContainer_2.add(acmpInspnDivCd, new FormData("50%"));
		layoutContainer.add(layoutContainer_2);
		
		LayoutContainer layoutContainer_3 = new LayoutContainer(new ColumnLayout());
		
//		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(60);
//		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_3.setLayout(frmlytSch);
		
		
		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3_1.setLayout(frmlytSch);
		
		acmpInspnBgnnDt = new DateField();
		new DateFieldMask(acmpInspnBgnnDt, "9999.99.99");
		acmpInspnBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		acmpInspnBgnnDt.setFieldLabel("시작일");
		acmpInspnBgnnDt.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
            	setAcmpInspnDys();
             
            } 
      }); 		
		
		layoutContainer_3_1.add(acmpInspnBgnnDt, new FormData("100%"));
		
		layoutContainer_3.add(layoutContainer_3_1 , new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer layoutContainer_3_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3_2.setLayout(frmlytSch);
		
		acmpInspnEndDt = new DateField();
		new DateFieldMask(acmpInspnEndDt, "9999.99.99");
		acmpInspnEndDt.setFieldLabel("종료일");
		acmpInspnEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		acmpInspnEndDt.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
            	setAcmpInspnDys();
             
            } 
		}); 
		layoutContainer_3_2.add(acmpInspnEndDt, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_3_2 , new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer.add(layoutContainer_3);
		
		
		
		LayoutContainer layoutContainer_4 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer_4_1 = new LayoutContainer(new ColumnLayout());
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4_1.setLayout(frmlytSch);
		
		
		acmpInspnNmCty = new TextField<String>();
//		acmpInspnNmCty.setFieldLabel("기 간");
//		repbtyBusinNm.setReadOnly(false);
//		repbtyBusinNm.setEnabled(false);
		layoutContainer_4_1.add(acmpInspnNmCty, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_4_1 , new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer_4_2 = new LayoutContainer(new ColumnLayout());
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4_2.setLayout(frmlytSch);
		
		
		acmpInspnDys = new TextField<String>();
		acmpInspnDys.setFieldLabel("기간");
//		repbtyBusinNm.setReadOnly(false);
//		repbtyBusinNm.setEnabled(false);
		layoutContainer_4_2.add(acmpInspnDys, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_4_2 , new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer.add(layoutContainer_4);
		
		
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmlytSch);
		
		acmpInspnPurCtnt = new TextField<String>();
		acmpInspnPurCtnt.setFieldLabel("목 적");
//		repbtyBusinNm.setReadOnly(false);
//		repbtyBusinNm.setEnabled(false);
		layoutContainer_5.add(acmpInspnPurCtnt, new FormData("100%"));
		
		layoutContainer.add(layoutContainer_5);
		
		
		LayoutContainer layoutContainer_6 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytSch);
		
		acmpInspnRstCtnt = new TextField<String>();
		acmpInspnRstCtnt.setFieldLabel("성 과");
//		repbtyBusinNm.setReadOnly(false);
//		repbtyBusinNm.setEnabled(false);
		layoutContainer_6.add(acmpInspnRstCtnt, new FormData("100%"));
		
		layoutContainer.add(layoutContainer_6);
		
		LayoutContainer layoutContainer_7 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSch);
		
		acmpInspnEtcCtnt = new TextField<String>();
		acmpInspnEtcCtnt.setFieldLabel("비 고");
//		repbtyBusinNm.setReadOnly(false);
//		repbtyBusinNm.setEnabled(false);
		layoutContainer_6.add(acmpInspnEtcCtnt, new FormData("100%"));
		
		layoutContainer.add(layoutContainer_7);
		
		
		
		LayoutContainer layoutContainer_8 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		layoutContainer_8.add(btnBar);
		
		btnReset = new Button("초기화"); 
		btnReset.setWidth("70px");
		btnReset.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
    			psnl0134Init();
    			
    		}
    	});
		btnBar.add(btnReset);
		
		
		btnSave = new Button("저장"); 
		btnSave.setWidth("70px");
		btnSave.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) { 
    			
    			MessageBox.confirm("알림", "해당 정보를 저장하시겠습니까?", new Listener<MessageBoxEvent>(){
    				@Override
    				public void handleEvent(MessageBoxEvent be) {
    					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
    						
    						if( MSFSharedUtils.getConvertDateToString(acmpInspnBgnnDt, "yyyyMMdd") == null || "".equals(MSFSharedUtils.getConvertDateToString(acmpInspnBgnnDt, "yyyyMMdd")) )  {
    							MessageBox.info("경고", "기간(시작일)을 입력해주세요.", null);
    							return;
    						}else if(MSFSharedUtils.getConvertDateToString(acmpInspnEndDt, "yyyyMMdd") == null || "".equals(MSFSharedUtils.getConvertDateToString(acmpInspnEndDt, "yyyyMMdd"))) {
    							MessageBox.info("경고", "기간(종료일)을 입력해주세요.", null);
    							return;
    						}else if(!acmpInspnDys.getValue().matches("^[0-9]+$")) {
    							MessageBox.info("경고", "기간은 숫자만 입력 가능합니다.", null);
    							return;
    						}else {
    							doAction(actionDatabase);
    						}
    					}
    				}
    			});
    		}
    	});
		btnBar.add(btnSave);
		
		btnDelete = new Button("삭제"); 
		btnDelete.setWidth("70px");
		btnDelete.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
				doAction(ActionDatabase.DELETE);
    			
//	    		// 마스터이거나 입력자가 아니면 삭제처리 하지 못하게 kybdr
//	    		if(!"D0010090".equals(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getUsrDivCd())) 
//	    				|| "D0010090" != MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getUsrDivCd()) )	 {
//	    			if(!MSFMainApp.get().getUser().getUsrId().equals(kybdr.getValue()) || MSFMainApp.get().getUser().getUsrId() != kybdr.getValue()) {
//	    				MessageBox.info("오류", "마스터 관리자 또는 작성자 이외에는 삭제할 수 없습니다.", null);
//						return;
//					}
//				}
//				else {
//					
//	    			MessageBox.confirm("알림", "해당 정보를 삭제하시겠습니까?", new Listener<MessageBoxEvent>(){
//	    				@Override
//	    				public void handleEvent(MessageBoxEvent be) {
//	    					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//	    						if("0".equals(MSFSharedUtils.defaultNulls(refeSeilNum.getValue(), "0")) || MSFSharedUtils.defaultNulls(refeSeilNum.getValue(), "0") == "0") {
//	    							MessageBox.info("알림", "삭제할 데이터가 없습니다.", null);
//	    							return;
//	    						}else{
//	    							doAction(actionDatabase = ActionDatabase.DELETE);
//	    						}
//	    					}
//	    				}
//	    			});
//					
//				}
    		}
    	});
		btnBar.add(btnDelete);
		layoutContainer_8.add(btnBar);
		layoutContainer.add(layoutContainer_8);
		
		
		
	 	fieldSet.add(layoutContainer);
		cpPsnl010003.add(fieldSet);
		
	  } 
	  
	 
	  
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
				
				if(acmpInspnDivCdFld.getValue() == "A0520010" || "A0520010".equals(acmpInspnDivCdFld.getValue())) {
					acmpInspnNmCty.setFieldLabel("국 가");
				}else {
					acmpInspnNmCty.setFieldLabel("도 시");
				}
				PersonalUtil.setSelectedComboValue(acmpInspnDivCd, acmpInspnDivCdFld.getValue(), "commCd");	/** column 수행시찰구분코드 : acmpInspnDivCd */
				
				// 기존 데이터 수정일 경우 해당 데이터 가져와 보여준다.
				if(actionDatabase  ==  ActionDatabase.UPDATE) {
					dataReLoad();
				}else if(actionDatabase  ==  ActionDatabase.INSERT) {
					
				}
			}
		});
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onSuccessSave() {
		// TODO Auto-generated method stub

	}
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	}  
	
    /** 시찰(수행)내역 저장  **/
    private void savePsnl0134() {
    	
    	psnl0134Dto = new Psnl0134DTO();
    	
    	psnl0134Dto.setSystemkey(MSFSharedUtils.allowNulls(systemkey.getValue()));    											/** column SYSTEMKEY : systemkey */
    	psnl0134Dto.setAcmpInspnSeilNum(MSFSharedUtils.allowNulls(acmpInspnSeilNum.getValue()));    							/** column 수행시찰일련번호 : acmpInspnSeilNum */
		psnl0134Dto.setAcmpInspnDivCd(MSFSharedUtils.getSelectedComboValue(acmpInspnDivCd, "commCd"));    						/** column 수행시찰구분코드 : acmpInspnDivCd */
		psnl0134Dto.setAcmpInspnTtl(MSFSharedUtils.allowNulls(acmpInspnTtl.getValue()));    									/** column 수행시찰제목 : acmpInspnTtl */
		psnl0134Dto.setAcmpInspnBgnnDt(acmpInspnBgnnDt.getValue());																/** column 수행시찰시작일자 : acmpInspnBgnnDt */
		psnl0134Dto.setAcmpInspnEndDt(acmpInspnEndDt.getValue());    															/** column 수행시찰종료일자 : acmpInspnEndDt */
		psnl0134Dto.setAcmpInspnDys(acmpInspnDys.getValue());   																/** column 수행시찰기간수 : acmpInspnDys */
		psnl0134Dto.setAcmpInspnNmCty(MSFSharedUtils.allowNulls(acmpInspnNmCty.getValue()));    								/** column 수행시찰국명 : acmpInspnNmCty */
		psnl0134Dto.setAcmpInspnPurCtnt(MSFSharedUtils.allowNulls(acmpInspnPurCtnt.getValue()));    							/** column 수행시찰목적내용 : acmpInspnPurCtnt */
		psnl0134Dto.setAcmpInspnRstCtnt(MSFSharedUtils.allowNulls(acmpInspnRstCtnt.getValue()));    							/** column 수행시찰성과내용 : acmpInspnRstCtnt */
		psnl0134Dto.setAcmpInspnEtcCtnt(MSFSharedUtils.allowNulls(acmpInspnEtcCtnt.getValue()));    							/** column 수행시찰기타내용 : acmpInspnEtcCtnt */
    	
    	
    	psnl0134Service.savePsnl0134(psnl0134Dto, actionDatabase, new AsyncCallback<Long> (){	
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.info("오류",   (actionDatabase  ==  ActionDatabase.DELETE ? "삭제처리가 " : "저장처리가 " ) +  "가 실패 하였습니다.\n" + caught.getMessage(), null);		
			}

			@Override
			public void onSuccess(Long result) {
				// TODO Auto-generated method stub
				if(result == 0) {
					MessageBox.info("알림", "처리된 데이터가 없습니다. 데이터를 확인해 주세요.", null);
				}else {
					
					if(result > 0) {
						MessageBox.info("알림",  (actionDatabase  ==  ActionDatabase.DELETE ? "삭제처리가 " : "저장처리가 " ) +  "가 완료되었습니다." , null);	
						dataReLoad();
					}
					
					// 신규등록 후 update 로 변경하여 수정할 수 있게끔 처리, 나머지도.
					if(actionDatabase  ==  ActionDatabase.INSERT) {
						actionDatabase = ActionDatabase.UPDATE;
					}else if(actionDatabase  ==  ActionDatabase.DELETE) {
						actionDatabase  =  ActionDatabase.INSERT;
					}else {
						actionDatabase = ActionDatabase.UPDATE;
					}
				}
			}
    	});
    }
    
    
    /** 데이터 재조회 **/
    private void dataReLoad() {
    	
    	psnl0134Dto = new Psnl0134DTO();
    	psnl0134Dto.setDpobCd(dpobCd.getValue());
    	psnl0134Dto.setSystemkey(systemkey.getValue());
    	psnl0134Dto.setAcmpInspnSeilNum(MSFSharedUtils.defaultNulls(acmpInspnSeilNum.getValue(), "0"));
//    	psnl0134Dto.setAcmpInspnDivCd(PersonalUtil.getSelectedComboValue(acmpInspnDivCd, "commCd"));
    	psnl0134Dto.setAcmpInspnDivCd(acmpInspnDivCdFld.getValue());
    	
    	psnl0134Service.selectPsnl0134Data(psnl0134Dto, new AsyncCallback<Psnl0134DTO> (){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.info("오류",  "데이터를 가져오는 중 오류 발생 " + caught.getMessage(), null);		
			}

			@Override
			public void onSuccess(Psnl0134DTO result) {
				// TODO Auto-generated method stub
				
				systemkey.setValue(result.getSystemkey());																	/** column SYSTEMKEY : systemkey */
		    	acmpInspnSeilNum.setValue(psnl0134Dto.getAcmpInspnSeilNum());												/** column 수행시찰일련번호 : acmpInspnSeilNum */
		    	PersonalUtil.setSelectedComboValue(acmpInspnDivCd, String.valueOf(result.getAcmpInspnDivCd()), "commCd");	/** column 수행시찰구분코드 : acmpInspnDivCd */
		    	acmpInspnDivCdFld.setValue(String.valueOf(result.getAcmpInspnDivCd()));
		    	acmpInspnTtl.setValue(result.getAcmpInspnTtl());															/** column 수행시찰제목 : acmpInspnTtl */
		    	acmpInspnBgnnDt.setValue(result.getAcmpInspnBgnnDt());														/** column 수행시찰시작일자 : acmpInspnBgnnDt */
		    	acmpInspnEndDt.setValue(result.getAcmpInspnEndDt());		  												/** column 수행시찰종료일자 : acmpInspnEndDt */
		    	
				acmpInspnDys.setValue(result.getAcmpInspnDys());   															/** column 수행시찰기간수 : acmpInspnDys */
				acmpInspnNmCty.setValue(result.getAcmpInspnNmCty());														/** column 수행시찰국명 : acmpInspnNmCty */
				acmpInspnPurCtnt.setValue(result.getAcmpInspnPurCtnt());	 												/** column 수행시찰목적내용 : acmpInspnPurCtnt */
				acmpInspnRstCtnt.setValue(result.getAcmpInspnRstCtnt());													/** column 수행시찰성과내용 : acmpInspnRstCtnt */
				acmpInspnEtcCtnt.setValue(result.getAcmpInspnEtcCtnt());													/** column 수행시찰기타내용 : acmpInspnEtcCtnt */
				
			}
		});
    }
    
    private void psnl0134Init() {
    	
     	acmpInspnSeilNum.setValue("");    						/** column 수행시찰일련번호 : acmpInspnSeilNum */
    	PersonalUtil.setSelectedComboValue(acmpInspnDivCd, acmpInspnDivCdFld.getValue(), "commCd");	/** column 수행시찰구분코드 : acmpInspnDivCd */
    	acmpInspnTtl.setValue("");					/** column 수행시찰제목 : acmpInspnTtl */
    	acmpInspnBgnnDt.reset();					/** column 수행시찰시작일자 : acmpInspnBgnnDt */
    	acmpInspnEndDt.reset();		  				/** column 수행시찰종료일자 : acmpInspnEndDt */
		acmpInspnNmCty.setValue("");				/** column 수행시찰국명 : acmpInspnNmCty */
		acmpInspnPurCtnt.setValue("");	 			/** column 수행시찰목적내용 : acmpInspnPurCtnt */
		acmpInspnRstCtnt.setValue("");				/** column 수행시찰성과내용 : acmpInspnRstCtnt */
		acmpInspnEtcCtnt.setValue("");				/** column 수행시찰기타내용 : acmpInspnEtcCtnt */
		acmpInspnDys.setValue("0");   				/** column 수행시찰기간수 : acmpInspnDys */
		
		actionDatabase  =  ActionDatabase.INSERT;
    	
    }
    
    // 기간 산정
    private void setAcmpInspnDys() {
    	
    	Long diffDays = 0L;
		
		String acmpInspnBgnnDtStr	= PersonalUtil.getConvertDateToString(acmpInspnBgnnDt	, "yyyyMMdd");
		String acmpInspnEndDtStr 	= PersonalUtil.getConvertDateToString(acmpInspnEndDt	, "yyyyMMdd");
		
		if(acmpInspnBgnnDtStr != null && acmpInspnBgnnDtStr.length() == 8
				&& acmpInspnEndDtStr != null && acmpInspnEndDtStr.length() == 8){
			
			diffDays = acmpInspnEndDt.getValue().getTime() - acmpInspnBgnnDt.getValue().getTime();
			diffDays = diffDays / (24 * 60 * 60 * 1000) + 1;
			
			acmpInspnDys.setValue( diffDays.toString() );
			
		}
    	
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
	
	

}
