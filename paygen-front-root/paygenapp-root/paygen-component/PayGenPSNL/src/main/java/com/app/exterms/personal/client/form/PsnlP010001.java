/**
 * 신규고용일괄등록
 */
package com.app.exterms.personal.client.form;
  

import java.util.Date;

import com.app.exterms.personal.client.dto.Psnl0131DTO;
import com.app.exterms.personal.client.service.PsnlP010001Service;
import com.app.exterms.personal.client.service.PsnlP010001ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextArea;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PsnlP010001   extends MSFFormPanel {  

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
 
//	private  ContentPanel cpPsnl0100; 
	private  FormPanel cpPsnl0100; 
	  
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
		
		private HiddenField<String> dpobCd;  		// 사업장코드
		private HiddenField<String> systemkey;		// 시스템키
		private HiddenField<String> refeSeilNum;	// 관련근거일련번호
		private HiddenField<String> refeFlSeilNum1;	// 관련근거파일일련번호
		private HiddenField<String> refeFlSeilNum2;	// 관련근거파일일련번호
		private HiddenField<String> refeFlSeilNum3;	// 관련근거파일일련번호
		private HiddenField<String> kybdr;	// 입력사
			
		
		
		private TextField<String> refeTitl;			// 관련근거제목
		private TextField<String> refePrchNm;		// 관련근거담당자명
		private TextField<String> refePrchTel;		// 관련근거담당전화번호
		private ComboBox<BaseModel> refeDivCd;		// 관련근거구분코드
		private DateField refeIndt;					// 관련근거등록일자
		private TextArea refeCtnt; 					// 관련근거내용
		
		private FileUploadField refeOrgFlnm1; 		// 파일업로드처리 부분 1 
		private FileUploadField refeOrgFlnm2; 		// 파일업로드처리 부분 2
		private FileUploadField refeOrgFlnm3; 		// 파일업로드처리 부분 3
		
		private String beforeRefeOrgFlnm1;			// 기존 파일명1
		private String beforeRefeOrgFlnm2;			// 기존 파일명2
		private String beforeRefeOrgFlnm3;			// 기존 파일명3
		
		
		private String refeFlnm1;					// 파일명1
		private String refeFlnm2;					// 파일명2
		private String refeFlnm3;					// 파일명3

		
		private String filePathStr;
	    private HiddenField<String> fileKeyCode;	// 업로드를 위해 추가 
		private Boolean picBoolFile;
		
		private Boolean fileBool1;
		private Boolean fileBool2;
		private Boolean fileBool3;
		
		
//		REFE_FL_SEIL_NUM	관련근거파일일련번호
//		DPOB_CD	사업장코드
//		SYSTEMKEY	SYSTEMKEY
//		REFE_SEIL_NUM	관련근거일련번호
//		REFE_FLNM	관련근거파일명
//		REFE_ORG_FLNM	관련근거원본파일명
//		REFE_FLCOS	관련근거파일경로
//		REFE_FLSZ	관련근거파일크기
//		
//		
//		DPOB_CD	사업장코드
//		SYSTEMKEY	SYSTEMKEY
//		REFE_SEIL_NUM	관련근거일련번호
//		REFE_INDT	관련근거등록일자
//		REFE_PRCH_NM	관련근거담당자명
//		REFE_PRCH_TEL	관련근거담당전화번호
//		REFE_DIV_CD	관련근거구분코드
//		REFE_TITL	관련근거제목
//		REFE_CTNT	관련근거내용
//		REFE_DEL_FG	
      
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
 
	    private PsnlP010001ServiceAsync psnlP010001Service = PsnlP010001Service.Util.getInstance();
	    private ListStore<BaseModel> listStoreA051 	= new ListStore<BaseModel>();  		// 관련근거구분 
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드  
  		private Psnl0131DTO psnl0131Dto;
	    
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
		
    	psnl0131Dto = new Psnl0131DTO();
    	
    	psnl0131Dto.setDpobCd(dpobCd.getValue());    											/** column 사업장코드 : dpobCd */
    	psnl0131Dto.setSystemkey(systemkey.getValue());    										/** column SYSTEMKEY : systemkey */
    	psnl0131Dto.setRefeSeilNum(refeSeilNum.getValue());    									/** column 관련근거일련번호 : refeSeilNum */
    	psnl0131Dto.setRefeIndt(refeIndt.getValue() );    										/** column 관련근거등록일자 : refeIndt */
    	psnl0131Dto.setRefePrchNm(refePrchNm.getValue());    									/** column 관련근거담당자명 : refePrchNm */
    	psnl0131Dto.setRefePrchTel(refePrchTel.getValue());    									/** column 관련근거담당전화번호 : refePrchTel */
    	psnl0131Dto.setRefeDivCd(MSFSharedUtils.getSelectedComboValue(refeDivCd, "commCd"));    /** column 관련근거구분코드 : refeDivCd */
    	
    	psnl0131Dto.setRefeTitl(refeTitl.getValue());    										/** column 관련근거제목 : refeTitl */
    	psnl0131Dto.setRefeCtnt(refeCtnt.getValue());    										/** column 관련근거내용 : refeCtnt */
    	
//    	psnl0131Dto.setRefeFlnm(DateTimeFormat.getFormat("yyyyMMddhhmiss").format(new Date())); 	/** column 관련근거파일명 : refeFlnm */    	
//    	psnl0131Dto.setRefeFlSeilNum(psnl0132Dto.getRefeFlSeilNum());    						/** column 관련근거파일일련번호 : refeFlSeilNum */

    	String filename = "";
    	String filename1 = "";
    	String filename2 = "";
    	String filename3 = "";
    	String flUpNm = "";
    	String fileSeilNum1= "";
    	String fileSeilNum2= "";
    	String fileSeilNum3= "";
    	
    	
    	if(refeOrgFlnm1.getValue() == beforeRefeOrgFlnm1 || refeOrgFlnm1.getValue().equals(beforeRefeOrgFlnm1)
    			|| refeOrgFlnm1.getValue() == null ||"".equals(refeOrgFlnm1.getValue())) {
    		flUpNm = MSFSharedUtils.allowNulls("");
    		fileBool1 = false;
    	}else {
    		flUpNm = MSFSharedUtils.allowNulls(refeOrgFlnm1.getValue());
    		fileSeilNum1 = ":" + MSFSharedUtils.defaultNulls(refeFlSeilNum1.getValue(), "0");
    		fileBool1 = true;
    	}
//    	flUpNm = MSFSharedUtils.allowNulls(refeOrgFlnm1.getValue());
    	if(MSFSharedUtils.paramNotNull(flUpNm) ) {
        	filename1 = flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    	}
    	
    	
    	
    	flUpNm = "";
    	if(refeOrgFlnm2.getValue() == beforeRefeOrgFlnm2 || refeOrgFlnm2.getValue().equals(beforeRefeOrgFlnm2)
    			|| refeOrgFlnm2.getValue() == null ||"".equals(refeOrgFlnm2.getValue())) {
    		
    		flUpNm = MSFSharedUtils.allowNulls("");
    		fileBool2 = false;
    	}else {
    		flUpNm = MSFSharedUtils.allowNulls(refeOrgFlnm2.getValue());
    		fileSeilNum2 = ":" + MSFSharedUtils.defaultNulls(refeFlSeilNum2.getValue(), "0");
    		fileBool2 = true;
    	}
//    	flUpNm = MSFSharedUtils.allowNulls(refeOrgFlnm2.getValue());
    	if(MSFSharedUtils.paramNotNull(flUpNm) ) {
    		filename2 = "?" +  flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    	}
    	
    	
    	flUpNm = "";
    	if(refeOrgFlnm3.getValue() == beforeRefeOrgFlnm3 || refeOrgFlnm3.getValue().equals(beforeRefeOrgFlnm3)
    			|| refeOrgFlnm3.getValue() == null ||"".equals(refeOrgFlnm3.getValue())) {
    		flUpNm = MSFSharedUtils.allowNulls("");
    		fileBool3 = false;
    	}else {
    		flUpNm = MSFSharedUtils.allowNulls(refeOrgFlnm3.getValue());
    		fileSeilNum3 = ":" + MSFSharedUtils.defaultNulls(refeFlSeilNum3.getValue(), "0");
    		
    		fileBool3 = true;
    	}
    	flUpNm = MSFSharedUtils.allowNulls(refeOrgFlnm3.getValue());
    	if(MSFSharedUtils.paramNotNull(flUpNm) ) {
    		filename3 = "?" +  flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    	}

    	
    	filename = filename1 + fileSeilNum1 + filename2 + fileSeilNum2 + filename3 + fileSeilNum3;
    	psnl0131Dto.setRefeOrgFlnm(filename);   												/** column 관련근거원본파일명 : refeOrgFlnm */
    	
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			savePsnl0131();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			savePsnl0131();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
				psnl0131Dto.setRefeDelFg("D");    /** column null : refeDelFg */
				savePsnl0131();
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
	public PsnlP010001(final ActionDatabase ad, final MSFPanel caller) {
		    
 
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

//		cpPsnl0100 = new ContentPanel();
		cpPsnl0100 = new FormPanel();
		
		fileKeyCode = new HiddenField<String>();
		fileKeyCode.setName("fileKeyCode");
		cpPsnl0100.add(fileKeyCode);
		
		/************************************************************************/


	  	//  SingleUploader single1 = new SingleUploaderModal();
	    //  single1.addOnFinishUploadHandler(onFinishUploaderHandler);
	    //  single1.add(form); 
	      // This enables php apc progress mechanism
	     // single1.add(new Hidden("APC_UPLOAD_PROGRESS", single1.getInputName()), 0);
	    //  single1.avoidEmptyFiles(false);
	  	  //   SingleUploader single2 = new SingleUploaderModal(FileInputType.ANCHOR, new ChismesUploadProgress(true));
	  	 //   single2.addOnFinishUploadHandler(onFinishUploaderHandler);
	  	 //   RootPanel.get("single2").add(single2);
	  	    
	   
	  	 //   RootPanel.get("thumbnails").add(panelImages);
	  		/************************************************************************/   
		createInfoForm(); 	// 검색필드를 적용

		cpPsnl0100.setBodyBorder(false);
		cpPsnl0100.setBorders(false);
		cpPsnl0100.setHeaderVisible(false);
		cpPsnl0100.setSize("680px", "530px");
	//	cpPsnl0100.add(single1);
		this.add(cpPsnl0100);
		formBinding = new FormBinding(this, true);

		this.setSize("910px", "710px");
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
		sysComBass0300Dto.setRpsttvCd("A051");
		listStoreA051 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); 		// 관련근거
		
		
		dpobCd = new HiddenField<String>();	
		dpobCd.setName("dpobCd");
		cpPsnl0100.add(dpobCd);
		
	    systemkey = new HiddenField<String>();	
		systemkey.setName("systemkey");
		cpPsnl0100.add(systemkey);
		
		refeSeilNum = new HiddenField<String>();	
		refeSeilNum.setName("refeSeilNum");
		cpPsnl0100.add(refeSeilNum);	
		
		refeFlSeilNum1 = new HiddenField<String>();	
		refeFlSeilNum1.setName("refeFlSeilNum1");
		cpPsnl0100.add(refeFlSeilNum1);	
		
		refeFlSeilNum2 = new HiddenField<String>();	
		refeFlSeilNum1.setName("refeFlSeilNum2");
		cpPsnl0100.add(refeFlSeilNum2);	
		
		refeFlSeilNum3 = new HiddenField<String>();	
		refeFlSeilNum3.setName("refeFlSeilNum3");
		cpPsnl0100.add(refeFlSeilNum3);	
		
		kybdr = new HiddenField<String>();	
		kybdr.setName("kybdr");
		cpPsnl0100.add(kybdr);	
		

		cpPsnl0100.setLayout(new FlowLayout());

		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setStyleAttribute("paddingRight", "40px");
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		refeTitl = new TextField<String>();
		refeTitl.setName("refeTitl");
		refeTitl.setFieldLabel("제목");
		
		layoutContainer_1.add(refeTitl, new FormData("100%"));
		layoutContainer.add(layoutContainer_1);
		
		LayoutContainer layoutContainer_2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_1.setLayout(frmlytStd);
		
		refePrchNm = new TextField<String>();
		refePrchNm.setName("refePrchNm");
		refePrchNm.setReadOnly(true);
		refePrchNm.setFieldLabel("담당자");
		
		layoutContainer_2_1.add(refePrchNm, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		
		LayoutContainer layoutContainer_2_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_2.setLayout(frmlytStd);
		
		refePrchTel = new TextField<String>();
		refePrchTel.setName("refePrchTel");
		refePrchTel.setFieldLabel("전화번호");
		
		layoutContainer_2_2.add(refePrchTel, new FormData("100%"));
		layoutContainer_2.add(layoutContainer_2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		layoutContainer.add(layoutContainer_2);
		
		
		
		
		LayoutContainer layoutContainer_3 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3_1.setLayout(frmlytStd);
		
		refeDivCd = new ComboBox<BaseModel>();
		refeDivCd.setName("refeDivCd");
		refeDivCd.setFieldLabel("근거구분");
		refeDivCd.setForceSelection(true);
		refeDivCd.setMinChars(1);
		refeDivCd.setDisplayField("commCdNm");
		refeDivCd.setValueField("commCd");
		refeDivCd.setTriggerAction(TriggerAction.ALL);
		refeDivCd.setEmptyText("--근거구분선택--");
		refeDivCd.setSelectOnFocus(true);
		refeDivCd.setStore(listStoreA051);
		
		layoutContainer_3_1.add(refeDivCd, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		
		LayoutContainer layoutContainer_3_2 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3_2.setLayout(frmlytStd);
		
		refeIndt = new DateField();
		refeIndt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		refeIndt.setFieldLabel("등록(계약)일자");
		new DateFieldMask(refeIndt, "9999.99.99");
//		frstEmymtDt.setReadOnly(true);
		//frstEmymtDt.setEnabled(false);
		
		layoutContainer_3_2.add(refeIndt, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer.add(layoutContainer_3);
		
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
		
		refeCtnt = new MSFTextArea();
		refeCtnt.setName("refeCtnt");
		refeCtnt.setFieldLabel("근거내용");
		refeCtnt.setSize(480, 300);
		
		layoutContainer_4.add(refeCtnt, new FormData("100%"));
		layoutContainer.add(layoutContainer_4);
		
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer_5.setLayout(frmlytStd);
		
		refeOrgFlnm1 = new FileUploadField();
		refeOrgFlnm1.setFieldLabel("첨부파일1");
		refeOrgFlnm1.setName("refeOrgFlnm1");
//		refeOrgFlnm1.setValidator(new Validator() {  
//			@Override 
//			public String validate(Field<?> field, String value) { 
//				value = value.toLowerCase();        
//				String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
//				if(value.endsWith(".xls") ){           
//					result = null;        
//             	}        
//				return result;  
//        	} 
//		});
		refeOrgFlnm1.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
//				excelGrid.getStore().removeAll();
			}
	    });
		layoutContainer_5.add(refeOrgFlnm1, new FormData("100%"));
		layoutContainer.add(layoutContainer_5);
		
		
		LayoutContainer layoutContainer_6 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);
		
		refeOrgFlnm2 = new FileUploadField();
		refeOrgFlnm2.setFieldLabel("첨부파일2");
		refeOrgFlnm2.setName("refeOrgFlnm2");
//		refeOrgFlnm1.setValidator(new Validator() {  
//			@Override 
//			public String validate(Field<?> field, String value) { 
//				value = value.toLowerCase();        
//				String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
//				if(value.endsWith(".xls") ){           
//					result = null;        
//             	}        
//				return result;  
//        	} 
//		});
		refeOrgFlnm2.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
//				excelGrid.getStore().removeAll();
			}
	    });
		
		layoutContainer_6.add(refeOrgFlnm2, new FormData("100%"));
		layoutContainer.add(layoutContainer_6);
		
		
		LayoutContainer layoutContainer_7 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(90);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);
		
		refeOrgFlnm3 = new FileUploadField();
		refeOrgFlnm3.setFieldLabel("첨부파일3");
		refeOrgFlnm3.setName("refeOrgFlnm3");
//		refeOrgFlnm1.setValidator(new Validator() {  
//			@Override 
//			public String validate(Field<?> field, String value) { 
//				value = value.toLowerCase();        
//				String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
//				if(value.endsWith(".xls") ){           
//					result = null;        
//             	}        
//				return result;  
//        	} 
//		});
		refeOrgFlnm3.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
//				excelGrid.getStore().removeAll();
			}
	    });
		
		layoutContainer_7.add(refeOrgFlnm3, new FormData("100%"));
		layoutContainer.add(layoutContainer_7);
		
		LayoutContainer layoutContainer_8 = new LayoutContainer();
		
		btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		layoutContainer_8.add(btnBar);
		
		btnReset = new Button("초기화"); 
		btnReset.setWidth("70px");
		btnReset.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//입력폼 초기화
    			refeTitl.setValue("");				// 관련근거제목                              
    			refePrchNm.setValue(MSFMainApp.get().getUser().getUsrNm());	// 관련근거담당자명      
    			
    			refePrchTel.setValue("");			// 관련근거담당전화번호                         
    			refeDivCd.setValue(new BaseModel());// 관련근거구분코드                               
    			refeIndt.setValue(new Date());		// 관련근거등록일자                   
    			refeCtnt.setValue(""); 				// 관련근거내용                      
    			                                                             
    			refeOrgFlnm1.setValue(""); 			// 파일업로드처리 부분 1                       
    			refeOrgFlnm2.setValue(""); 			// 파일업로드처리 부분 2                       
    			refeOrgFlnm3.setValue(""); 			// 파일업로드처리 부분 3                       
    			
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
//    						private FileUploadField refeOrgFlnm1; 		// 파일업로드처리 부분 1 
//    						private FileUploadField refeOrgFlnm2; 		// 파일업로드처리 부분 2
//    						private FileUploadField refeOrgFlnm3; 		// 파일업로드처리 부분 3
    						
    						if(refeOrgFlnm1.getValue() == null || "".equals(MSFSharedUtils.allowNulls(refeOrgFlnm1.getValue()))) {
    							
    							if(refeOrgFlnm2.getValue() != null ||  !"".equals(MSFSharedUtils.allowNulls(refeOrgFlnm2.getValue()))) {
    								refeOrgFlnm2.reset();
        							refeOrgFlnm3.reset();
        							
        							MessageBox.info("경고", "첨부파일1 부터 입력해 주세요.", null);
        							return;
    							}else {
    								doAction(actionDatabase);
    							}
    								
    						}else if(refeOrgFlnm2.getValue() == null || "".equals(MSFSharedUtils.allowNulls(refeOrgFlnm2.getValue()))) {
    							
    							if(refeOrgFlnm3.getValue() != null ||  !"".equals(MSFSharedUtils.allowNulls(refeOrgFlnm3.getValue()))){
    								refeOrgFlnm3.reset();
        							MessageBox.info("경고", "첨부파일2 부터 입력해 주세요.", null);
        							return;
    							}else {
        							doAction(actionDatabase);
    							}
    							
    						}else if(refeOrgFlnm1.getValue() == null || "".equals(MSFSharedUtils.allowNulls(refeOrgFlnm1.getValue())) ) {
    							
    							if(refeOrgFlnm2.getValue() == null || "".equals(MSFSharedUtils.allowNulls(refeOrgFlnm2.getValue()))) {
    								
    								if(refeOrgFlnm3.getValue() != null ||  !"".equals(MSFSharedUtils.allowNulls(refeOrgFlnm3.getValue()))) {
    									refeOrgFlnm2.reset();
            							refeOrgFlnm3.reset();
            							MessageBox.info("경고", "첨부파일1 부터 입력해 주세요.", null);
            							return;
    								}else {
    	    							doAction(actionDatabase);
    								}
    								
    							}else {
        							doAction(actionDatabase);
    							}
    							
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
    			
	    		// 마스터이거나 입력자가 아니면 삭제처리 하지 못하게 kybdr
	    		if((!"D0010090".equals(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getUsrDivCd())) || "D0010090" != MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getUsrDivCd())) 
	    			&& (!MSFMainApp.get().getUser().getUsrId().equals(kybdr.getValue()) || MSFMainApp.get().getUser().getUsrId() != kybdr.getValue())
	    		    )	 {
	    			MessageBox.info("오류", "마스터 관리자 또는 작성자 이외에는 삭제할 수 없습니다.", null);
					return;
//	    			if() {
//	    				MessageBox.info("오류", "마스터 관리자 또는 작성자 이외에는 삭제할 수 없습니다.", null);
//						return;
//					}
				}else {
					
	    			MessageBox.confirm("알림", "해당 정보를 삭제하시겠습니까?", new Listener<MessageBoxEvent>(){
	    				@Override
	    				public void handleEvent(MessageBoxEvent be) {
	    					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	    						if("0".equals(MSFSharedUtils.defaultNulls(refeSeilNum.getValue(), "0")) || MSFSharedUtils.defaultNulls(refeSeilNum.getValue(), "0") == "0") {
	    							MessageBox.info("알림", "삭제할 데이터가 없습니다.", null);
	    							return;
	    						}else{
	    							doAction(actionDatabase = ActionDatabase.DELETE);
	    						}
	    					}
	    				}
	    			});
					
				}
    		}
    	});
		btnBar.add(btnDelete);
		layoutContainer_8.add(btnBar);
		layoutContainer.add(layoutContainer_8);
		
		
		
	 	fieldSet.add(layoutContainer);
		cpPsnl0100.add(fieldSet);
		
	  } 
	  
	 
	  
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
				
				// 기존 데이터 수정일 경우 해당 데이터 가져와 보여준다.
				if(actionDatabase  ==  ActionDatabase.UPDATE) {
					dataReLoad();
				}else if(actionDatabase  ==  ActionDatabase.INSERT) {
					refePrchNm.setValue(MSFMainApp.get().getUser().getUsrNm());	// 관련근거담당자명      
					refeIndt.setValue(new Date());		// 관련근거등록일자   
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
	
    /** 관련근거내용, 파일 저장 **/
    private void savePsnl0131() {
    	
    	psnlP010001Service.savePsnl0131(psnl0131Dto, actionDatabase, new AsyncCallback<Long> (){	
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
					
					
					if(psnl0131Dto.getRefeOrgFlnm() == null || "".equals(psnl0131Dto.getRefeOrgFlnm())){
						MessageBox.info("알림",  (actionDatabase  ==  ActionDatabase.DELETE ? "삭제처리가 " : "저장처리가 " ) +  "가 완료되었습니다." , null);	
						dataReLoad();
					}else {
//						dataReLoad();
						fileUpload();
					}
					
					
					// 신규등록 후 update 로 변경하여 수정할 수 있게끔 처리, 나머지도.
					if(actionDatabase  ==  ActionDatabase.INSERT) {
						actionDatabase = ActionDatabase.UPDATE;
					}else {
						actionDatabase = ActionDatabase.UPDATE;
					}
				}
			}
    	});
    }
    
    
    /** 데이터 재조회 **/
    private void dataReLoad() {
    	
    	psnl0131Dto = new Psnl0131DTO();
    	psnl0131Dto.setDpobCd(dpobCd.getValue());
    	psnl0131Dto.setSystemkey(systemkey.getValue());
    	psnl0131Dto.setRefeSeilNum(refeSeilNum.getValue());
    	
    	psnlP010001Service.selectPsnl0131Data(psnl0131Dto, new AsyncCallback<Psnl0131DTO> (){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.info("오류",   "데이터를 가져오는 중 오류 발생" + caught.getMessage(), null);		
			}

			@Override
			public void onSuccess(Psnl0131DTO result) {
				// TODO Auto-generated method stub
				refeTitl.setValue(MSFSharedUtils.allowNulls(result.getRefeTitl()));    					/** column 관련근거제목 : refeTitl */
				refePrchNm.setValue(MSFSharedUtils.allowNulls(result.getRefePrchNm()));					/** column 관련근거담당자명 : refePrchNm */
				refePrchTel.setValue(MSFSharedUtils.allowNulls(result.getRefePrchTel()));				/** column 관련근거담당전화번호 : refePrchTel */
				PersonalUtil.setSelectedComboValue(refeDivCd, result.getRefeDivCd(), "commCd");			/** column 관련근거구분코드 : refeDivCd */
				refeIndt.setValue(result.getRefeIndt());												/** column 관련근거등록일자 : refeIndt */
		    	refeCtnt.setValue(MSFSharedUtils.allowNulls(result.getRefeCtnt()));    					/** column 관련근거내용 : refeCtnt */
		    	
				refeFlSeilNum1.setValue(MSFSharedUtils.defaultNulls(result.getRefeFlSeilNum1(), "0"));	// 관련근거파일일련번호
				refeFlSeilNum2.setValue(MSFSharedUtils.defaultNulls(result.getRefeFlSeilNum2(), "0"));	// 관련근거파일일련번호
				refeFlSeilNum3.setValue(MSFSharedUtils.defaultNulls(result.getRefeFlSeilNum3(), "0"));	// 관련근거파일일련번호
				
				beforeRefeOrgFlnm1 = MSFSharedUtils.allowNulls(result.getRefeOrgFlnm1());				// 기존 원본 파일명1
				beforeRefeOrgFlnm2 = MSFSharedUtils.allowNulls(result.getRefeOrgFlnm2());				// 기존 원본 파일명2
				beforeRefeOrgFlnm3 = MSFSharedUtils.allowNulls(result.getRefeOrgFlnm3());				// 기존 원본 파일명3
				
				refeOrgFlnm1.setValue(MSFSharedUtils.allowNulls(result.getRefeOrgFlnm1()));				// 기존  파일명1
				refeOrgFlnm2.setValue(MSFSharedUtils.allowNulls(result.getRefeOrgFlnm2()));				// 기존  파일명2
				refeOrgFlnm3.setValue(MSFSharedUtils.allowNulls(result.getRefeOrgFlnm3()));				// 기존  파일명3
				
				refeFlnm1 = MSFSharedUtils.allowNulls(result.getRefeFlnm1());							// db 파일명1
				refeFlnm2 = MSFSharedUtils.allowNulls(result.getRefeFlnm2());							// db 파일명2
				refeFlnm3 = MSFSharedUtils.allowNulls(result.getRefeFlnm3());							// db 파일명3
				
				kybdr.setValue(MSFSharedUtils.allowNulls(result.getKybdr()));							// 입력자 
				
			}
		});
    }
    
    
    /** 파일업로드 처리 부 **/
    private String fileUpload() {
    	
    	String resultStr = "";
    	
    	psnl0131Dto = new Psnl0131DTO();
    	psnl0131Dto.setDpobCd(dpobCd.getValue());
    	psnl0131Dto.setSystemkey(systemkey.getValue());
    	psnl0131Dto.setRefeSeilNum(refeSeilNum.getValue());
    	
    	psnlP010001Service.selectPsnl0131Data(psnl0131Dto, new AsyncCallback<Psnl0131DTO> (){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.info("오류",   "데이터를 가져오는 중 오류 발생" + caught.getMessage(), null);		
			}

			@Override
			public void onSuccess(Psnl0131DTO result) {
				
				// TODO Auto-generated method stub
				refeTitl.setValue(MSFSharedUtils.allowNulls(result.getRefeTitl()));    					/** column 관련근거제목 : refeTitl */
				refePrchNm.setValue(MSFSharedUtils.allowNulls(result.getRefePrchNm()));					/** column 관련근거담당자명 : refePrchNm */
				refePrchTel.setValue(MSFSharedUtils.allowNulls(result.getRefePrchTel()));				/** column 관련근거담당전화번호 : refePrchTel */
				PersonalUtil.setSelectedComboValue(refeDivCd, result.getRefeDivCd(), "commCd");			/** column 관련근거구분코드 : refeDivCd */
				refeIndt.setValue(result.getRefeIndt());												/** column 관련근거등록일자 : refeIndt */
		    	refeCtnt.setValue(MSFSharedUtils.allowNulls(result.getRefeCtnt()));    					/** column 관련근거내용 : refeCtnt */
		    	
				refeFlSeilNum1.setValue(MSFSharedUtils.defaultNulls(result.getRefeFlSeilNum1(), "0"));	// 관련근거파일일련번호
				refeFlSeilNum2.setValue(MSFSharedUtils.defaultNulls(result.getRefeFlSeilNum2(), "0"));	// 관련근거파일일련번호
				refeFlSeilNum3.setValue(MSFSharedUtils.defaultNulls(result.getRefeFlSeilNum3(), "0"));	// 관련근거파일일련번호
				
				beforeRefeOrgFlnm1 = MSFSharedUtils.allowNulls(result.getRefeOrgFlnm1());				// 기존 파일명1
				beforeRefeOrgFlnm2 = MSFSharedUtils.allowNulls(result.getRefeOrgFlnm1());				// 기존 파일명2
				beforeRefeOrgFlnm3 = MSFSharedUtils.allowNulls(result.getRefeOrgFlnm1());				// 기존 파일명3
				
				refeOrgFlnm1.setValue(MSFSharedUtils.allowNulls(result.getRefeOrgFlnm1()));				// 파일첨부 1
				refeOrgFlnm2.setValue(MSFSharedUtils.allowNulls(result.getRefeOrgFlnm2()));				// 파일첨부 2
				refeOrgFlnm3.setValue(MSFSharedUtils.allowNulls(result.getRefeOrgFlnm3()));				// 파일첨부3

				refeFlnm1 = MSFSharedUtils.allowNulls(result.getRefeFlnm1());							// db 파일명1
				refeFlnm2 = MSFSharedUtils.allowNulls(result.getRefeFlnm2());							// db 파일명2
				refeFlnm3 = MSFSharedUtils.allowNulls(result.getRefeFlnm3());							// db 파일명3
				
				kybdr.setValue(MSFSharedUtils.allowNulls(result.getKybdr()));							// 입력자 
		    	
				String resultStr = "";
				
				if(fileBool1) {
					resultStr += refeFlnm1 + ":" ;
				}
				if(fileBool2) {
					resultStr += refeFlnm2 + ":";
				}
				
				if(fileBool3) {
					resultStr += refeFlnm3;
				}
//				String resultStr = refeFlnm1 + ":" + refeFlnm2 + ":" + "refeFlnm3";						// db에 저장된 파일명들을 파일업로드시 같이 보내준다.
				fileKeyCode.setValue(resultStr);
				
//				Window.alert(resultStr);
				final Tracker tracker = new Tracker();
		        tracker.setStatus(false);
				
		        final MessageBox box = MessageBox.wait("업로드 중", "파일 업로드 중입니다....", "업로드 중...");
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
		        cpPsnl0100.setAction(GWT.getHostPageBaseURL() + "upload/fileUpload.do"); 
		        cpPsnl0100.setEncoding(Encoding.MULTIPART);
		        cpPsnl0100.setMethod(Method.POST);
		        cpPsnl0100.submit();
		        cpPsnl0100.onFrameLoad(); 
		        picBoolFile = true;
		        
		        cpPsnl0100.addListener(Events.Submit, new Listener<FormEvent>() {
		              public void handleEvent(FormEvent evt) {  
		            	  box.close();
		            	  
		            	  // 값이 여러번 리턴되는 현상을 막기 위해 picBoolFile 이용
		            	  if(picBoolFile) {
		            		  
			                  if ("success".endsWith(evt.getResultHtml().trim()) && picBoolFile) {
			                	  	cpPsnl0100.unmask(); 
//			                	  	box.close();
			              			MessageBox.alert("완료", "데이터 작업 및 파일 업로드 처리가 완료 되었습니다. ", null);
			              			picBoolFile = false;
			              			
			                  } else {
			                	  
			                	  MessageBox.alert("오류", "파일 업로드 중 오류가 발생했습니다. </br> 관리자에게 문의해주세요.", null);
			                	  picBoolFile = false;
			                	  
			                      //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
			                      evt.setResultHtml("");
			                  } 
			                  
		            	  }
		              };
		        });
			
				
			}
		});
    	
    	
    	return resultStr;
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
