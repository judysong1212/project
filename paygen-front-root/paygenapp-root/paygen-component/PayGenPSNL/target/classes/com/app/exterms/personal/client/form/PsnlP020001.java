/**
 * 신규고용일괄등록
 */
package com.app.exterms.personal.client.form;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.form.defs.Psnl0110Def;
import com.app.exterms.personal.client.service.PsnlP020001Service;
import com.app.exterms.personal.client.service.PsnlP020001ServiceAsync;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.BufferView;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PsnlP020001   extends MSFFormPanel {  

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
 
//	private  ContentPanel cpPsnl0200; 
	private  FormPanel cpPsnl0200; 
	    
	//인사정보  
	private Psnl0110Def psnl0110Def  = new Psnl0110Def("PSNLP020001");   //그리드 테이블 컬럼 define  
	// private MSFCustomForm msfCustomForm; 
	private MSFGridPanel psnl0110GridPanel;
	
	private static EditorGrid<Psnl0110DTO> excelGrid;
	private List<Psnl0110DTO> psnl0110List = new ArrayList<Psnl0110DTO>();
	  
	//지급년도 
// 	private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
// 	private MSFGridPanel payYrGridPanel;

    
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
//		private ButtonBar topPayr4200Bar;
//		// private Button btnPayr4200Init;
//		// private Button btnPayr4200Save;
//		// private Button btnPayr4200Del;
//		private Button btnPayr4200Sreach;
//		// private Button btnPayr4200Print;
//		private Button btnPayr4200Excel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	* 검색변수 선언 
	* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	*/
      
		private HiddenField<String> systemkey;
		
		private HiddenField<String> dpobCd;  //사업장코드
		private HiddenField<String> srhSystemkey; // 시스템키
		
//	    private HiddenField<String> payYr;   			/** column 지급년월 : pymtYrMnth */
//	    private HiddenField<String> payMonth;   		/** column 지급년월 : pymtYrMnth */
//	    private HiddenField<String> payCd;  			/** column 급여구분코드 : payCd */
//	    private HiddenField<String> payrMangDeptCd; 	/** column 단위기관코드 : payrMangDeptCd */	      
//	    private HiddenField<String> emymtDivCd;   		/** column 고용구분코드 : emymtDivCd */
//		private HiddenField<String> repbtyBusinDivCd; 	// 호봉제구분코드
	    private HiddenField<String> deptCd;  			/** column 부서코드 : deptCd */
	    private HiddenField<String> emymtTypCd;  		/** column 고용유형코드 : emymtTypCd */
	    private HiddenField<String> businCd;   			/** column 사업코드 : businCd */
//		private HiddenField<String> deptGpCd; 			// 부서직종그룹코드
//	    private HiddenField<String> typOccuCd;   		/** column 직종코드 : typOccuCd */
//	    private HiddenField<String> dtilOccuInttnCd;	/**  column 직종세구분코드 : dtilOccuInttnCd */

	    
	    
		private TextField<String> emymtDivNm; 		// 고용구분명
		
	    private TextField<String> deptNm; 			// 부서코드
	    private TextField<String> emymtTypNm; 		// 고용유형코드
	    private TextField<String> businNm; 			// 사업코드	  
	    
		private Button btnSrhDeptCd;				// 부서 검색 버튼
		private Button btnSrhEmymtTypCd;			// 고용유형 검색 버튼
		private Button btnSrhbusinCd;				// 사업 검색 버튼
		
		private ComboBox<BaseModel> emymtNewTypCd;	// 신규구분
//		private ComboBox<BaseModel> srhPayMonth;		// 지급월
//		private ComboBox<BaseModel> srhPayCd; 			// 급여구분
//		private TextField<String> srhPayrMangDeptCd; 	// 단위기관
//		private TextField<String> srhHanNm; 			// 성명
//		private TextField<String> srhResnRegnNum; 		// 주민번호
//		private TextField<String> srhEmymtDivCd; 		// 고용구분
//		private TextField<String> srhRepbtyBusinDivCd; 	// 호봉제구분코드
//		private TextField<String> srhDeptCd; 			// 부서
//		private TextField<String> srhDeptGpCd; 			// 부서직종그룹코드
//		private TextField<String> srhTypOccuCd; 		// 직종
//		private TextField<String> srhDtilOccuInttnCd; 	// 직종세
//		private TextField<String> srhBusinCd; 			// 사업

//		private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
//		private ComboBox<BaseModel> srhPayDducExtpyCd;
		
		private FileUploadField psnlP020001flUp; 		// 파일업로드처리 부분  
		private String filePathStr;
	    private HiddenField<String> fileKeyCode;			// 업로드를 위해 추가 
		private Boolean picBoolFile;
      
      
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
 
	    private PsnlP020001ServiceAsync psnlP020001Service = PsnlP020001Service.Util.getInstance();
	    
	    private ListStore<BaseModel> lsPayYrStore 	= new ListStore<BaseModel>();  //년도 
  		private ListStore<BaseModel> lsPayMonth 	= new ListStore<BaseModel>();  //급여월   
  		private ListStore<BaseModel> lsPayCd 		= new ListStore<BaseModel>(); 	//급여구분 
  		
	    private ListStore<BaseModel> lsEmymtTypCd 	= new ListStore<BaseModel>();  //신규구분 
  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드  
  		private SysCoCalendarDTO msfCoCalendarDto;   
  		
  		private Psnl0100DTO psnl0100Dto;
  		private Psnl0110DTO psnl0110Dto;
  		
	    
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
	public PsnlP020001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

//		cpPsnl0200 = new ContentPanel();
		cpPsnl0200 = new FormPanel();
		
		fileKeyCode = new HiddenField<String>();
		fileKeyCode.setName("fileKeyCode");
		cpPsnl0200.add(fileKeyCode);
		
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
		createSearchForm(); 	// 검색필드를 적용
		createInfoForm(); 		// 파일 업로드부 적용
		createStandardForm(); 	// 그리드 필드
		// createPayrP410001Form(); //화면 기본정보를 설정

		cpPsnl0200.setBodyBorder(false);
		cpPsnl0200.setBorders(false);
		cpPsnl0200.setHeaderVisible(false);
		cpPsnl0200.setSize("890px", "640px");
	//	cpPsnl0200.add(single1);
		this.add(cpPsnl0200);
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
	  
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();

		
		lsEmymtTypCd = new ListStore<BaseModel>();
		
		BaseModel emymtTypCdBaseModel = new BaseModel();
		emymtTypCdBaseModel.set("commCd", "01");
		emymtTypCdBaseModel.set("commCdNm", "신규대상");
		lsEmymtTypCd.add(emymtTypCdBaseModel);
		
		emymtTypCdBaseModel = new BaseModel();
		emymtTypCdBaseModel.set("commCd", "02");
		emymtTypCdBaseModel.set("commCdNm", "기존대상");
		lsEmymtTypCd.add(emymtTypCdBaseModel);
		
		
		
	    systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpPsnl0200.add(systemkey);
		
		dpobCd = new HiddenField<String>();	
		dpobCd.setName("dpobCd");
		cpPsnl0200.add(dpobCd);
		
		
		srhSystemkey = new HiddenField<String>();	
		srhSystemkey.setName("srhSystemkey");
		cpPsnl0200.add(srhSystemkey);
		
		
//		payYr = new HiddenField<String>();	
//		payYr.setName("payYr");
//		cpPsnl0200.add(payYr);
//		
//		payMonth = new HiddenField<String>();	
//		payMonth.setName("payMonth");
//		cpPsnl0200.add(payMonth);
//		
//		payCd = new HiddenField<String>();	
//		payCd.setName("payCd");
//		cpPsnl0200.add(payCd);
//		
//		payrMangDeptCd = new HiddenField<String>();	
//		payrMangDeptCd.setName("payrMangDeptCd");
//		cpPsnl0200.add(payrMangDeptCd);
//		
//		emymtDivCd = new HiddenField<String>();	
//		emymtDivCd.setName("emymtDivCd");
//		cpPsnl0200.add(emymtDivCd);
//		
//		deptCd = new HiddenField<String>();	
//		deptCd.setName("deptCd");
//		cpPsnl0200.add(deptCd);
//		
//		typOccuCd = new HiddenField<String>();	
//		typOccuCd.setName("typOccuCd");
//		cpPsnl0200.add(typOccuCd);
//		
//		dtilOccuInttnCd = new HiddenField<String>();	
//		dtilOccuInttnCd.setName("dtilOccuInttnCd");
//		cpPsnl0200.add(dtilOccuInttnCd);
//		
//		businCd = new HiddenField<String>();	
//		businCd.setName("businCd");
//		cpPsnl0200.add(businCd);
		

		cpPsnl0200.setLayout(new FlowLayout());

		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		emymtDivNm = new TextField<String>();
		emymtDivNm.setValue("기간제근로자");
		emymtDivNm.setFieldLabel("고용구분");
		layoutContainer_1.add(emymtDivNm, new FormData("30%"));
		layoutContainer.add(layoutContainer_1);
		
		
		LayoutContainer layoutContainer_2 = new LayoutContainer(new ColumnLayout());	
		
		
		LayoutContainer lcSchCol_01 = new LayoutContainer();
		
		
        LayoutContainer lccmDeptNm = new LayoutContainer();
        lccmDeptNm.setLayout(new ColumnLayout());
        
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcDeptNm.setLayout(frmlytStd);
		
		deptNm = new TextField<String>(); 
		deptNm.setName("deptNm");
		deptNm.setFieldLabel("부서찾기");   
      //  currAffnDeptNm.setLabelSeparator("");
		deptNm.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {

				if (MSFSharedUtils.allowNulls(deptNm.getValue()).trim().equals("")) {
					deptNm.setValue("");
				}
				
				if (MSFSharedUtils.paramNull(deptNm)) {
					deptNm.setValue("");
				} 
				
				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	 deptNm.setValue("");
                	 fnPopupCommP140(deptNm.getValue());
				}
				super.componentKeyDown(event);
             }
         });
   
		lcDeptNm.add(deptNm, new FormData("100%"));
		lccmDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
		
		
		btnSrhDeptCd = new Button();
		btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
		btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) { 
                if (MSFSharedUtils.allowNulls(deptNm.getValue()).trim().equals("")) {
                	deptNm.setValue("");
                }
                fnPopupCommP140(deptNm.getValue()); 
            }
        });
        
		lccmDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
        lcSchCol_01.add(lccmDeptNm);
        
		
        
		LayoutContainer lcSchCol_02 = new LayoutContainer();
		
        LayoutContainer lccmEmymtTypNm = new LayoutContainer();
        lccmEmymtTypNm.setLayout(new ColumnLayout());
        
        LayoutContainer lcEmymtTypNm = new LayoutContainer(); 
        
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcEmymtTypNm.setLayout(frmlytStd);
		
		emymtTypNm = new TextField<String>(); 
		emymtTypNm.setName("emymtTypNm");
		emymtTypNm.setFieldLabel("고용유형찾기");   
      //  currAffnDeptNm.setLabelSeparator("");
		emymtTypNm.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {

				if (MSFSharedUtils.allowNulls(emymtTypNm.getValue()).trim().equals("")) {
					emymtTypNm.setValue("");
				}
				
				if (MSFSharedUtils.paramNull(emymtTypNm)) {
					emymtTypNm.setValue("");
				} 
				
				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
					emymtTypNm.setValue("");
					fnPopupBass0300("A042");
				}
				super.componentKeyDown(event);
             }
         });
   
		lcEmymtTypNm.add(emymtTypNm, new FormData("100%"));
		lccmEmymtTypNm.add(lcEmymtTypNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
		
        
		btnSrhEmymtTypCd = new Button();
		btnSrhEmymtTypCd.setIcon(MSFMainApp.ICONS.search()); 
		btnSrhEmymtTypCd.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) { 
                if (MSFSharedUtils.allowNulls(emymtTypNm.getValue()).trim().equals("")) {
                	emymtTypNm.setValue("");
                }
                fnPopupBass0300("A042");
            }
        });
        
		lccmEmymtTypNm.add(btnSrhEmymtTypCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
        lcSchCol_02.add(lccmEmymtTypNm);
		
        
        
		LayoutContainer lcSchCol_03 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol_03.setLayout(frmlytStd);
		
        LayoutContainer lccmBusinNm = new LayoutContainer();
        lccmBusinNm.setLayout(new ColumnLayout());
        
        LayoutContainer lcBusinNm = new LayoutContainer(); 
        
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcBusinNm.setLayout(frmlytStd);
		
		businNm = new TextField<String>(); 
		businNm.setName("businNm");
		businNm.setFieldLabel("사업찾기");   
      //  currAffnDeptNm.setLabelSeparator("");
		businNm.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {

				if (MSFSharedUtils.allowNulls(businNm.getValue()).trim().equals("")) {
					businNm.setValue("");
				}
				
				if (MSFSharedUtils.paramNull(businNm)) {
					businNm.setValue("");
				} 
				
				if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
					businNm.setValue("");
					PrgmComBass0500DTO bass0500Dto = new PrgmComBass0500DTO();
					fnPopupBass0500(bass0500Dto);
				}
				super.componentKeyDown(event);
             }
         });
   
		lcBusinNm.add(businNm, new FormData("100%"));
		lccmBusinNm.add(lcBusinNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
		
        
		btnSrhbusinCd = new Button();
		btnSrhbusinCd.setIcon(MSFMainApp.ICONS.search()); 
		btnSrhbusinCd.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) { 
                if (MSFSharedUtils.allowNulls(businNm.getValue()).trim().equals("")) {
                	businNm.setValue("");
                }
                
                 PrgmComBass0500DTO bass0500Dto = new PrgmComBass0500DTO();
                 fnPopupBass0500(bass0500Dto);
            }
        });
        
		lccmBusinNm.add(btnSrhbusinCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
        lcSchCol_03.add(lccmBusinNm);
		
		
		
		LayoutContainer lcSchCol_04 = new LayoutContainer();
		
		
		
		layoutContainer_2.add(lcSchCol_01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_2.add(lcSchCol_02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_2.add(lcSchCol_03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		layoutContainer_2.add(lcSchCol_04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		layoutContainer.add(layoutContainer_2);
	 	
	 	
	 	fieldSet.add(layoutContainer);
	 	
		
		cpPsnl0200.add(fieldSet);
		
	  } 
	  
	private void createInfoForm() {
		  
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("");
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout());
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_22 = new LayoutContainer();
		
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_22.setLayout(frmlytSch);
	    layoutContainer_22.setBorders(false);
	    
	    
	    emymtNewTypCd = new ComboBox<BaseModel>();
	    emymtNewTypCd.setFieldLabel("신규구분");
	    emymtNewTypCd.setForceSelection(true);
	    emymtNewTypCd.setMinChars(1);
	    emymtNewTypCd.setDisplayField("commCdNm");
	    emymtNewTypCd.setValueField("commCd");
	    emymtNewTypCd.setTriggerAction(TriggerAction.ALL);
		emymtNewTypCd.setEmptyText("--신규구분선택--");
		emymtNewTypCd.setSelectOnFocus(true);
		emymtNewTypCd.setName("emymtNewTypCd");
		emymtNewTypCd.setStore(lsEmymtTypCd);
		emymtNewTypCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	emymtNewTypCd.setValue(lsEmymtTypCd.getAt(0));  
            }
        }); 
	    layoutContainer_22.add(emymtNewTypCd, new FormData("100%"));
	    
	    
		    
		LayoutContainer layoutContainer_21 = new LayoutContainer();
	 
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_21.setLayout(frmlytSch);
	    layoutContainer_21.setBorders(false);
	    
		psnlP020001flUp = new FileUploadField();
	//	psnlP020001flUp.el().getSize();
		psnlP020001flUp.setHideLabel(true);
//		psnlP020001flUp.setFieldLabel("신규고용내역");
		psnlP020001flUp.setName("psnlP020001flUp");
		psnlP020001flUp.setValidator(new Validator() {  
			@Override 
			public String validate(Field<?> field, String value) { 
				value = value.toLowerCase();        
				String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
				if(value.endsWith(".xls") ){           
					result = null;        
             	}        
				return result;  
        	} 
		});
		psnlP020001flUp.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
				excelGrid.getStore().removeAll();
			}
	    });
		
		
		layoutContainer_21.add(psnlP020001flUp, new FormData("100%"));

		  
		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
//		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		
		Button btnButton01 = new Button("업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
               	xlsImportData(); 
			}
		});
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_42 = new LayoutContainer(); 
		//layoutContainer_42.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_42.setLayout(frmlytSch);
		
		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportData();
			}
		}); 
		layoutContainer_42.add(btnButton02, new FormData("100%"));
		layoutContainer_42.setBorders(false);
		
		layoutContainer_2.add(layoutContainer_22,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		layoutContainer_2.add(layoutContainer_42,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		
		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.0);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
//		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
		layoutContainer.add(layoutContainer_1);
		fldstNewFieldset.add(layoutContainer);
		
		cpPsnl0200.add(fldstNewFieldset);
	  
	}
	 
	private void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
//		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_1 = new FieldSet();
		// fldstNewFieldset_1.setSize(628, 320);

		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("고용일괄데이터정보");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.add(psnlModiListInfo(), new FormData("100%"));

//		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		
		LabelField lblfldNewLabelfield = new LabelField("※ [ 데이터 ] 업로드 시 -> 정상 : 'Y' 비정상 : 'N' (고용유형/관리부서/소속부서/주민등록번호/사업코드 순으로 검증됩니다.) / 저장 -> 정상 : V 비정상 :X)");
//		lblfldNewLabelfield.setStyleAttribute("textAlign", "RIGHT");
		layoutContainer_3_1.add(lblfldNewLabelfield);
		
		
		layoutContainer_3.add(layoutContainer_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		
		LayoutContainer layoutContainer_3_2 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button button = new Button("저 장");
		button.setWidth(150);
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(excelGrid.getStore().getCount() <= 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"저장할 데이터가 없습니다.</BR> 먼저 엑셀 파일을 업로드 해주세요.", null);
		        	return;
				}else {
					xlsSaveData();  
				}
			}
		}); 
		btnBar.add(button);
		
		button = new Button("결과엑셀");
		button.setWidth(150);
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
			
				// 저장된 데이터 엑셀로 출력
				xlsPsnl0200ExportData();
			}
		}); 
		//TODO 200건 이상 엑셀 저장 시 오류나서 일단 사용X
		btnBar.add(button);
		
		layoutContainer_3_2.add(btnBar);
		layoutContainer_3.add(layoutContainer_3_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		

		
		layoutContainer.add(layoutContainer_3);
		 

		cpPsnl0200.add(layoutContainer);
		layoutContainer.setBorders(false);

	}
	  
	/** 고용일괄데이터 그리드**/
	private LayoutContainer psnlModiListInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(870, 410);
		cp01.setScrollMode(Scroll.AUTO);  
		
	    //그리드 작업
	    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
	    
		CheckColumnConfig checkColumn = new CheckColumnConfig();
//		checkColumn.setId("dateChk");
//		checkcolumn.setHeaderText("데이터");
//		checkColumn.setWidth(40);
//		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
//		checkColumn.setEditor(checkBoxEditor);
//	    checkColumn.setMenuDisabled(true);
//	   // checkColumn.setFixed(true);
//	    columns.add(checkColumn);
	    
	    
	    ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("순번");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setMenuDisabled(true);
		column.setSortable(false);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("dataChk");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("데이터");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("emymtNewTypCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("신규구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("emymtNewTypNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("신규구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("emymtTypCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("고용유형");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("emymtTypNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("고용유형");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("mangeDeptCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("관리부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setHidden(true);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("mangeDeptNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("관리부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		column = new ColumnConfig();
		column.setId("currAffnDeptCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("소속부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("currAffnDeptNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("소속부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		

		column = new ColumnConfig();
		column.setId("hanNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(false);
		columns.add(column);
		
		
		column = new ColumnConfig();
		column.setId("chinCharNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("성명(한자)");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(false);
		columns.add(column);
		
		
		column = new ColumnConfig();
		column.setId("resnRegnNum");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("주민등록번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		DateField emymtBgnnDtDateField = new DateField();
		new DateFieldMask(emymtBgnnDtDateField, "9999.99.99"); 
		emymtBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("emymtBgnnDt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(emymtBgnnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    columns.add(column);
		
	    DateField emymtEndDtDateField = new DateField();
	    new DateFieldMask(emymtEndDtDateField, "9999.99.99"); 
	    emymtEndDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
	    column = new ColumnConfig();
		column.setId("emymtEndDt");
		column.setHeaderText("종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(emymtEndDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    columns.add(column);
	    
		column = new ColumnConfig();
		column.setId("businApptnYr");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("사업년도");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("businCd");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("사업");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("businNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("사업");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("currPaeWorkNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("현근무지");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		column = new ColumnConfig();
		column.setId("emymtReasCtnt");
		column.setHeaderText("고용사유내용");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(150);
		TextField<String> emymtReasCtntText = new TextField<String>();
		column.setEditor(new CellEditor(emymtReasCtntText));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		// psnl0111
		column = new ColumnConfig();
		column.setId("husRoadNmZpcd");
		column.setHeaderText("우편번호");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(60);
		TextField<String> husRoadNmZpcd = new TextField<String>();
		column.setEditor(new CellEditor(husRoadNmZpcd));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		column = new ColumnConfig();
		column.setId("husRoadNmFndtnAddr");
		column.setHeaderText("기본주소");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(150);
		TextField<String> husRoadNmFndtnAddr = new TextField<String>();
		column.setEditor(new CellEditor(husRoadNmFndtnAddr));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("husRoadNmDtlPatrAddr");
		column.setHeaderText("상세주소");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(150);
		TextField<String> husRoadNmDtlPatrAddr = new TextField<String>();
		column.setEditor(new CellEditor(husRoadNmDtlPatrAddr));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("husPhnNum");
		column.setHeaderText("전화번호");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		TextField<String> husPhnNum = new TextField<String>();
		column.setEditor(new CellEditor(husPhnNum));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("cellPhneNum");
		column.setHeaderText("핸드폰번호");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		TextField<String> cellPhneNum = new TextField<String>();
		column.setEditor(new CellEditor(cellPhneNum));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		// psnl0113
		column = new ColumnConfig();
		column.setId("dabtyDivCd");
		column.setHeaderText("장애구분");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(100);
		TextField<String> dabtyDivCd = new TextField<String>();
		column.setEditor(new CellEditor(dabtyDivCd));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("dabtyGrdeCd");
		column.setHeaderText("장애등급");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(100);
		TextField<String> dabtyGrdeCd = new TextField<String>();
		column.setEditor(new CellEditor(dabtyGrdeCd));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("dabtyAjmtDt");
		column.setHeaderText("장애판정일자");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(100);
		TextField<String> dabtyAjmtDt = new TextField<String>();
		column.setEditor(new CellEditor(dabtyAjmtDt));
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		ColumnModel cm = new ColumnModel(columns);
		excelGrid = new EditorGrid<Psnl0110DTO>(new ListStore<Psnl0110DTO>(), cm);
		excelGrid.setLoadMask(true);
		excelGrid.setBorders(true);
		excelGrid.isDisableTextSelection();
		excelGrid.setStateful(false);
//		excelGrid.setAutoExpandColumn("resnRegnNum");
		excelGrid.setHeight(485);
		//excelGrid.getView().setAutoFill(true);
		// 로컬에 있는 메모리 사용
		BufferView view = new BufferView();  
		view.setRowHeight(28);  
		  
		excelGrid.setView(view);  

		cp01.add(excelGrid);
		
//	    psnl0110GridPanel = new MSFGridPanel(psnl0110Def, false, false, false, false);
//	    psnl0110GridPanel.setHeaderVisible(false);  
//	    psnl0110GridPanel.setBodyBorder(true);
//	    psnl0110GridPanel.setBorders(true);
//	    cp01.add(psnl0110GridPanel); 
		

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
	  
	  
		   
	public void reload() {
		// TODO Auto-generated method stub
		formInit();
		IColumnFilter filters = null;
		psnl0110GridPanel.getTableDef().setTableColumnFilters(filters);
				 
//		psnl0110GridPanel.getTableDef().addColumnFilter("pymtYrMnth", (MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")), SimpleColumnFilter.OPERATOR_EQUALS); 
//		psnl0110GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//		psnl0110GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.allowNulls( payrMangDeptCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 
//		psnl0110GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.allowNulls( emymtDivCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 		
//		psnl0110GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls( deptCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 				
//		psnl0110GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.allowNulls( typOccuCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS); 	
//		psnl0110GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls( dtilOccuInttnCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);		
//		psnl0110GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.allowNulls( businCd.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);	
//		psnl0110GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls( srhHanNm.getValue() ), SimpleColumnFilter.OPERATOR_EQUALS);	
//		psnl0110GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//		psnl0100GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", MSFSharedUtils.getSelectedComboValue(srhPymtDducDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
//		psnl0100GridPanel.getTableDef().addColumnFilter("payItemCd", MSFSharedUtils.getSelectedComboValue(srhPayDducExtpyCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		psnl0110GridPanel.reload();

		actionDatabase = ActionDatabase.READ;
	}
			
			
	// 폼초기화 검색조건포함
	private void formInit() {

		// grid init
		psnl0110GridPanel.getMsfGrid().clearData();

		actionDatabase = ActionDatabase.READ;

	}
	
	
	//엑셀 양식 저장
	private void xlsExportData() {
			                    
		HashMap<String, String> param = new HashMap<String, String>(); 
			   
		
        if("".equals( MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(emymtNewTypCd,"commCd"))) ){
        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"신규구분을 선택해 주세요.", null);
        	return;
        }
		
//		psnl0110GridPanel = new MSFGridPanel(psnl0110Def, false, false, false,false);
		
//        
//		param.put("pymtYrMnth", MSFSharedUtils.allowNulls(( MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")+ MSFSharedUtils.getSelectedComboValue(srhPayMonth,"month")))); 
//		param.put("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd") ); 
//		param.put("payrMangDeptCd", MSFSharedUtils.allowNulls( payrMangDeptCd.getValue() )); 
//		param.put("emymtDivCd", MSFSharedUtils.allowNulls( emymtDivCd.getValue() )); 		
//		param.put("deptCd", MSFSharedUtils.allowNulls( deptCd.getValue() )); 				
//		param.put("typOccuCd", MSFSharedUtils.allowNulls( typOccuCd.getValue() )); 	
//		param.put("dtilOccuInttnCd", MSFSharedUtils.allowNulls( dtilOccuInttnCd.getValue() ));		
//		param.put("businCd", MSFSharedUtils.allowNulls( businCd.getValue() ));	
//		param.put("hanNm", MSFSharedUtils.allowNulls( srhHanNm.getValue() ));	
//		param.put("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()));
		
//		psnl0110GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPsnlP020002Export.do","extgwtFrame", param); 
		
		param.put("emymtNewTypCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(emymtNewTypCd,"commCd")));
	
		GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnlP020002Export.do", "extgwtFrame", JsUtil.toJavaScriptObject(param)); 
        
	}	
	
	
	//고용일괄조정 업로드
	private void xlsImportData() {
		
		String flUpNm = MSFSharedUtils.allowNulls(psnlP020001flUp.getValue());
  	
  		if (flUpNm.length() == 0) {
  			Window.alert("선택된 파일이 없습니다.");
    	} else {
    		flUpNm = flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    		int pos = flUpNm.lastIndexOf(".");		// 기존파일명에서 확장자의 위치를 가져온다.
    		flUpNm = flUpNm.substring(pos + 1);												// 확장자만 잘라서 당아줌.
    		
//    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
//    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + DateTimeFormat.getFormat("yyyyMMddhhmiss").format(new Date()) + "_" + flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + DateTimeFormat.getFormat("yyyyMMddhhmiss").format(new Date()) + "." + flUpNm;
    		fileKeyCode.setValue(filename);
//    		Window.alert("파일명은 : " +  filename);
    		
    		final Tracker tracker = new Tracker();
            tracker.setStatus(false);
    		
            final MessageBox box = MessageBox.wait("업로드 중", "엑셀 데이터 업로드 중입니다....", "업로드 중...");
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
          	cpPsnl0200.setAction(GWT.getHostPageBaseURL() + "upload/XlsFileUpload.do"); 
			cpPsnl0200.setEncoding(Encoding.MULTIPART);
			cpPsnl0200.setMethod(Method.POST);
          	cpPsnl0200.submit();
          	cpPsnl0200.onFrameLoad(); 
            picBoolFile = true;
            
            cpPsnl0200.addListener(Events.Submit, new Listener<FormEvent>() {
	              public void handleEvent(FormEvent evt) {  
//	                  plFrmPsnl0100.unmask(); 
	                  if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                	  
	                	  box.close();
	                	  
	                	  filePathStr = "";
//	                	  cpPsnl0200.reset();
//	                	  psnlP020001flUp.getFileInput().removeFromParent();
//	                	  psnlP020001flUp.reset();
	                	  
	              		// 데이터 업로드
	              		psnlP020001Service.getPsnlP020002ExcelData(filename, new AsyncCallback<List<HashMap<String,String>>>() {

	          				@Override
	          				public void onFailure(Throwable caught) {
//	          					cpPsnl0200.unmask();
	          					box.close();
	          					tracker.setStatus(true);
	          					
	          					// TODO Auto-generated method stub
	          					MessageBox.alert("", "Excel파일이 아니거나 데이터에 형식이 잘못되었습니다. " + caught, null);
	          				}

	          				@Override
	          				public void onSuccess(List<HashMap<String, String>> result) {
	          					// TODO Auto-generated method stub
	          					if(result.size() > 0){
	          						excelGrid.getStore().removeAll();
	          						//Info.display("REMOVE = excelGrid.getStore().getCount()", excelGrid.getStore().getCount()+"");
	          						excelGrid.stopEditing(true);
	          						box.close();
	          						
	          						psnl0110List = new ArrayList<Psnl0110DTO>();
	          						
	          						for(int i = 0; i < result.size(); i++){
	          							
	          							DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
	          							
	          							psnl0110Dto = new Psnl0110DTO();
	          							
	          							psnl0110Dto.setRnum(result.get(i).get("rnum"));
	          							psnl0110Dto.setSystemkey(result.get(i).get("systemkey"));
	          							psnl0110Dto.setDataChk(result.get(i).get("dataChk"));
	          							psnl0110Dto.setEmymtNewTypCd(result.get(i).get("emymtNewTypCd"));
	          							psnl0110Dto.setEmymtNewTypNm(result.get(i).get("emymtNewTypNm"));
	          							psnl0110Dto.setEmymtTypCd(result.get(i).get("emymtTypCd"));
	          							psnl0110Dto.setEmymtTypNm(result.get(i).get("emymtTypNm"));
	          							psnl0110Dto.setMangeDeptCd(result.get(i).get("mangeDeptCd"));
	          							psnl0110Dto.setMangeDeptNm(result.get(i).get("mangeDeptNm"));
	          							psnl0110Dto.setResnRegnNum(result.get(i).get("resnRegnNum"));
	          							psnl0110Dto.setCurrAffnDeptCd(result.get(i).get("currAffnDeptCd"));
	          							psnl0110Dto.setCurrAffnDeptNm(result.get(i).get("currAffnDeptNm"));
	          							psnl0110Dto.setHanNm(result.get(i).get("hanNm"));
	          							psnl0110Dto.setChinCharNm(result.get(i).get("chinCharNm"));
	          							psnl0110Dto.setEmymtBgnnDt(dateTimeFormat.parse(result.get(i).get("emymtBgnnDt")));
	          							psnl0110Dto.setEmymtEndDt(dateTimeFormat.parse(result.get(i).get("emymtEndDt")));
	          							psnl0110Dto.setBusinApptnYr(result.get(i).get("businApptnYr"));
	          							psnl0110Dto.setBusinCd(result.get(i).get("businCd"));
	          							psnl0110Dto.setBusinNm(result.get(i).get("businNm"));
	          							psnl0110Dto.setCurrPaeWorkNm(result.get(i).get("currPaeWorkNm"));
	          							psnl0110Dto.setEmymtReasCtnt(result.get(i).get("emymtReasCtnt"));
	          							
	          							
	          							psnl0110Dto.setHusRoadNmZpcd(result.get(i).get("husRoadNmZpcd"));
	          							psnl0110Dto.setHusRoadNmFndtnAddr(result.get(i).get("husRoadNmFndtnAddr"));
	          							psnl0110Dto.setHusRoadNmDtlPatrAddr(result.get(i).get("husRoadNmDtlPatrAddr"));
	          							psnl0110Dto.setHusPhnNum(result.get(i).get("husPhnNum"));
	          							psnl0110Dto.setCellPhneNum(result.get(i).get("cellPhneNum"));
	          							psnl0110Dto.setDabtyDivCd(result.get(i).get("dabtyDivCd"));
	          							psnl0110Dto.setDabtyGrdeCd(result.get(i).get("dabtyGrdeCd"));
	          							psnl0110Dto.setDabtyAjmtDt(result.get(i).get("dabtyAjmtDt"));
	          							
	          							
	          							psnl0110List.add(psnl0110Dto);
	          							
	          							filePathStr = MSFSharedUtils.allowNulls(result.get(i).get("filaPath"));
	          							
	          							excelGrid.getStore().insert(psnl0110Dto, i);
	          							
	          						}
	          						
//	          						cpPsnl0200.unmask();
	          						
	          						excelGrid.getStore().commitChanges();
	          						
	          						tracker.setStatus(true);
	          						

	          					}else{
//	          						cpPsnl0200.unmask();
	          						tracker.setStatus(true);
	          						MessageBox.alert("", "Excel파일이 아니거나 업로드 할 데이터가 없습니다.", null);
//	          						psnlP020001flUp.setValue("");
	          						
	          					}
	          				}
	          				
	          				
	          			
	          			}); 
	              		picBoolFile = false;
                           
                            
	                  } else {
	                      //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
	                      evt.setResultHtml("");
	                  }
	              };
            });
    	}  
  		
  		
  		
  		
	}
	
	
	//급여일괄조정 업로드
	private void xlsSaveData() {
		
  		String filename = MSFSharedUtils.allowNulls(psnlP020001flUp.getValue());
  		if (filename.length() == 0) {
  			Window.alert("선택된 파일이 없습니다.");
    	} else {
    		
    		MessageBox.confirm("일괄 등록", "고용 내역을 저장합니다.",new Listener<MessageBoxEvent>(){
    			@Override
    			public void handleEvent(MessageBoxEvent be) {
                	  
    				// TODO Auto-generated method stub
//    				Info.display("", excelGrid.getStore().getCount()+"");
    				
        			ArrayList<Psnl0110DTO> insertPsnl0110List = new ArrayList<Psnl0110DTO>();
        			for ( int i = 0; i < excelGrid.getStore().getCount(); i++){
        				insertPsnl0110List.add(excelGrid.getStore().getAt(i));
        			}
        			
        			
            		final Tracker tracker = new Tracker();
                    tracker.setStatus(false);
        			
                    final MessageBox box2 = MessageBox.wait("저장 중", "업로드 된 정상 엑셀 데이터를 저장 중입니다....", "저장 중...");
                    final Timer t2 = new Timer()
                    {
                        public void run()
                        {
                            if (tracker.getStatus())
                            {
                                cancel();
                                box2.close();
                            }
                        }
                    };
                    t2.scheduleRepeating(500);
        				
        			psnlP020001Service.updateXlsPsnl0110ToP020002(insertPsnl0110List, new AsyncCallback<List<Psnl0110DTO>>() {
       					@Override
       					public void onSuccess(List<Psnl0110DTO> result) {
       						// TODO Auto-generated method stub
       						if(0 >= result.size()){
       							
       							box2.close();
       							tracker.setStatus(true);
       							
       							MessageBox.info("저장실패", "고용 내역 저장에 실패 하였습니다. \n 데이터를 확인해주세요.", null);
//       							psnlP020001flUp.setValue("");
       							psnlP020001flUp.reset();
       						}else{
       							
       							box2.close();
       							
       							excelGrid.getStore().removeAll();
       							//Info.display("REMOVE = excelGrid.getStore().getCount()", excelGrid.getStore().getCount()+"");
       							excelGrid.stopEditing(false);
       							
       							psnl0110List = new ArrayList<Psnl0110DTO>();   
       							
       							for(int i = 0; i < result.size(); i++){
       								
       								
       								psnl0110Dto.setRnum(MSFSharedUtils.allowNulls(result.get(i).get("rnum")));
       								psnl0110Dto.setSystemkey(MSFSharedUtils.allowNulls(result.get(i).get("systemkey")));
       								psnl0110Dto.setDataChk(MSFSharedUtils.allowNulls(result.get(i).get("dataChk")));
       								psnl0110Dto.setEmymtNewTypCd(MSFSharedUtils.allowNulls(result.get(i).get("emymtNewTypCd")));
       								psnl0110Dto.setEmymtNewTypNm(MSFSharedUtils.allowNulls(result.get(i).get("emymtNewTypNm")));
       								psnl0110Dto.setEmymtTypCd(MSFSharedUtils.allowNulls(result.get(i).get("emymtTypCd")));
       								psnl0110Dto.setEmymtTypNm(MSFSharedUtils.allowNulls(result.get(i).get("emymtTypNm")));
       								psnl0110Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(result.get(i).get("mangeDeptCd")));
       								psnl0110Dto.setMangeDeptNm(MSFSharedUtils.allowNulls(result.get(i).get("mangeDeptNm")));
       								psnl0110Dto.setResnRegnNum(MSFSharedUtils.allowNulls(result.get(i).get("resnRegnNum")));
       								psnl0110Dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(result.get(i).get("currAffnDeptCd")));
       								psnl0110Dto.setCurrAffnDeptNm(MSFSharedUtils.allowNulls(result.get(i).get("currAffnDeptNm")));
       								psnl0110Dto.setHanNm(MSFSharedUtils.allowNulls(result.get(i).get("hanNm")));
       								psnl0110Dto.setChinCharNm(MSFSharedUtils.allowNulls(result.get(i).get("chinCharNm")));
//       								psnl0110Dto.setEmymtBgnnDt(PersonalUtil.getConvertStringToDate(result.get(i).get("emymtBgnnDt").toString(), "yyyyMMdd"));
//       								psnl0110Dto.setEmymtEndDt(PersonalUtil.getConvertStringToDate(result.get(i).get("emymtEndDt").toString(), "yyyyMMdd"));
       								//Window.alert(""+result.get(i).get("emymtBgnnDt"));
       								//Window.alert(""+dateTimeFormat.parseStrict(result.get(i).get("emymtBgnnDt").toString())); 
       								
       								
       								psnl0110Dto.setEmymtBgnnDt((Date) result.get(i).get("emymtBgnnDt"));
       								psnl0110Dto.setEmymtEndDt((Date) result.get(i).get("emymtEndDt"));
//       								psnl0110Dto.setEmymtBgnnDt(PersonalUtil.getConvertStringToDate(result.get(i).get("emymtBgnnDt").toString(), "yyyyMMdd"));
//       								psnl0110Dto.setEmymtEndDt(PersonalUtil.getConvertStringToDate(result.get(i).get("emymtEndDt").toString(), "yyyyMMdd"));
       								psnl0110Dto.setBusinApptnYr(MSFSharedUtils.allowNulls(result.get(i).get("businApptnYr")));
       								psnl0110Dto.setBusinCd(MSFSharedUtils.allowNulls(result.get(i).get("businCd")));
       								psnl0110Dto.setBusinNm(MSFSharedUtils.allowNulls(result.get(i).get("businNm")));
       								psnl0110Dto.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(result.get(i).get("currPaeWorkNm")));
       								psnl0110Dto.setEmymtReasCtnt(MSFSharedUtils.allowNulls(result.get(i).get("emymtReasCtnt")));
       								
       								
          							psnl0110Dto.setHusRoadNmZpcd(MSFSharedUtils.allowNulls(result.get(i).get("husRoadNmZpcd")));
          							psnl0110Dto.setHusRoadNmFndtnAddr(MSFSharedUtils.allowNulls(result.get(i).get("husRoadNmFndtnAddr")));
          							psnl0110Dto.setHusRoadNmDtlPatrAddr(MSFSharedUtils.allowNulls(result.get(i).get("husRoadNmDtlPatrAddr")));
          							psnl0110Dto.setHusPhnNum(MSFSharedUtils.allowNulls(result.get(i).get("husPhnNum")));
          							psnl0110Dto.setCellPhneNum(MSFSharedUtils.allowNulls(result.get(i).get("cellPhneNum")));
          							psnl0110Dto.setDabtyDivCd(MSFSharedUtils.allowNulls(result.get(i).get("dabtyDivCd")));
          							psnl0110Dto.setDabtyGrdeCd(MSFSharedUtils.allowNulls(result.get(i).get("dabtyGrdeCd")));
          							psnl0110Dto.setDabtyAjmtDt(MSFSharedUtils.allowNulls(result.get(i).get("dabtyAjmtDt")));
       								
       								psnl0110List.add(psnl0110Dto);
       								
       								excelGrid.getStore().insert(psnl0110Dto, i);
       								
       							}
       							
       							excelGrid.getStore().commitChanges();
       							excelGrid.stopEditing(true);
       							
       							MessageBox.info("저장완료", "고용 내역이 총("+result.size()+")건이 저장되었습니다.", null);
//       							psnlP020001flUp.setValue("");
       							
       						}
       						
       					}
       					
       					@Override
       					public void onFailure(Throwable caught) {
       						
       						box2.close();
   							tracker.setStatus(true);
       						// TODO Auto-generated method stub
       						MessageBox.info("저장실패", "고용일괄등록 저장이 실패 하였습니다.", null);
       						psnlP020001flUp.reset();
       					}
       				}); 
    			}
    		});
    	}    	
	}
	
	
	/** 결과 엑셀 저장 **/
	private void xlsPsnl0200ExportData() {
		
		HashMap<String, String> map = new HashMap<String, String> ();
		
		final HashMap<String, String> param = new HashMap<String, String> (); 
//		
		if(excelGrid.getStore().getCount() <= 0) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"저장할 데이터가 없습니다.</BR> 먼저 엑셀 파일을 업로드 해주세요.", null);
        	return;
		}
		
		if(psnl0110List.size() <= 0) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"저장할 데이터가 없습니다.</BR> 업로드 한 엑셀파일을 저장 해주세요.</BR> (저장된 데이터만 엑셀 다운 가능)", null);
        	return;
		}
		
//		if(psnl0110List.size() > 150) {
//			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),"150건 이상은 저장할 수 없습니다. 데이터를 조정하여 재업로드 해주세요.", null);
//        	return;
//		}
		
		
		
		MessageBox.confirm("엑셀 저장", "엑셀은 150건 까지만 저장됩니다. 저장하시겠습니까?",new Listener<MessageBoxEvent>(){

			@Override
			public void handleEvent(MessageBoxEvent be) {
				
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					
					StringBuffer sbList = new StringBuffer();
					StringBuffer sb = new StringBuffer();
					
//					int totalCount = psnl0110List.size();
					int dataCount = 0;						
					
					
					for(int i = 0; i < psnl0110List.size(); i++){
						
						dataCount = dataCount + 1;
						
						String dataChkStr 				= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("dataChk"), " - ");
						String emymtNewTypCdStr 		= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("emymtNewTypCd"), " - ");
						String emymtNewTypNmStr 		= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("emymtNewTypNm"), " - ");
						String emymtTypCdStr 			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("emymtTypCd"), " - ");
						String emymtTypNmStr 			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("emymtTypNm"), " - ");
						String mangeDeptCdStr 			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("mangeDeptCd"), " - ");
						String mangeDeptNmStr 			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("mangeDeptNm"), " - ");
						String resnRegnNumStr 			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("resnRegnNum"), " - ");
						String currAffnDeptCdStr 		= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("currAffnDeptCd"), " - ");
						String currAffnDeptNmStr 		= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("currAffnDeptNm"), " - ");
						String hanNmStr 				= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("hanNm"), " - ");
						String chinCharNmStr 			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("chinCharNm"), " - ");
						String emymtBgnnDtStr 			= MSFSharedUtils.defaultNulls(  GWTUtils.getStringFromDate((Date) psnl0110List.get(i).get("emymtBgnnDt"), "yyyyMMdd") , " - ");
						String emymtEndDtStr 			= MSFSharedUtils.defaultNulls(  GWTUtils.getStringFromDate((Date) psnl0110List.get(i).get("emymtEndDt"), "yyyyMMdd") , " - ");
						String businApptnYrStr 			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("businApptnYr"), " - ");
						String businCdStr 				= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("businCd"), " - ");
						String businNmStr 				= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("businNm"), " - ");
						String currPaeWorkNmStr 		= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("currPaeWorkNm"), " - ");
						String emymtReasCtntStr 		= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("emymtReasCtnt"), " - ");
						
						
						String husRoadNmZpcdStr			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("husRoadNmZpcd"), " - ");
						String husRoadNmFndtnAddrStr	= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("husRoadNmFndtnAddr"), " - ");
						String husRoadNmDtlPatrAddrStr	= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("husRoadNmDtlPatrAddr"), " - ");
						String husPhnNumStr				= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("husPhnNum"), " - ");
						String cellPhneNumStr			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("cellPhneNum"), " - ");
						
						String dabtyDivCdStr			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("dabtyDivCd"), " - ");
						String dabtyGrdeCdStr			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("dabtyGrdeCd"), " - ");
						String dabtyAjmtDtStr			= MSFSharedUtils.defaultNulls(psnl0110List.get(i).get("dabtyAjmtDt"), " - ");
						
						
						
						sb = new StringBuffer();
						
						sb.append("dataChk=" 				+ dataChkStr				+ 	",");
						sb.append("emymtNewTypCd="			+ emymtNewTypCdStr  		+ 	",");
						sb.append("emymtNewTypNm="			+ emymtNewTypNmStr  		+ 	",");
						sb.append("emymtTypCd="				+ emymtTypCdStr  			+ 	",");
						sb.append("emymtTypNm="				+ emymtTypNmStr  			+ 	",");
						sb.append("mangeDeptCd="			+ mangeDeptCdStr 			+ 	",");
						sb.append("mangeDeptNm="			+ mangeDeptNmStr  			+ 	",");
						sb.append("resnRegnNum="			+ resnRegnNumStr  			+ 	",");
						sb.append("currAffnDeptCd="			+ currAffnDeptCdStr  		+ 	",");
						sb.append("currAffnDeptNm="			+ currAffnDeptNmStr  		+ 	",");
						sb.append("hanNm="					+ hanNmStr  				+ 	",");
						sb.append("chinCharNm="				+ chinCharNmStr  			+ 	",");
						sb.append("emymtBgnnDt="			+ emymtBgnnDtStr  			+ 	",");
						sb.append("emymtEndDt="				+ emymtEndDtStr  			+ 	",");
						sb.append("businApptnYr="			+ businApptnYrStr  			+ 	",");
						sb.append("businCd="				+ businCdStr  				+ 	",");
						sb.append("businNm="				+ businNmStr  				+ 	",");
						sb.append("currPaeWorkNm="			+ currPaeWorkNmStr  		+ 	",");
						
						
						sb.append("husRoadNmZpcd="			+ husRoadNmZpcdStr  		+ 	",");
						sb.append("husRoadNmFndtnAddr="		+ husRoadNmFndtnAddrStr  	+ 	",");
						sb.append("husRoadNmDtlPatrAddr="	+ husRoadNmDtlPatrAddrStr  	+ 	",");
						sb.append("husPhnNum="				+ husPhnNumStr  			+ 	",");
						sb.append("cellPhneNum="			+ cellPhneNumStr  			+ 	",");
						
						
						sb.append("dabtyDivCd="				+ dabtyDivCdStr  			+ 	",");
						sb.append("dabtyGrdeCd="			+ dabtyGrdeCdStr  			+ 	",");
						sb.append("dabtyAjmtDt="			+ dabtyAjmtDtStr  			+ 	",");
						
						
						sb.append("emymtReasCtnt="		+ emymtReasCtntStr);
						
						
						if(psnl0110List.size()-1 == i) {
							sbList.append(sb);
						}else {
							sbList.append(sb + ";");
						}
						
						// 데이터가 150건 이상일 경우는 150건만 담아주고 그 미만일 경우는 전부 담아줌
						//if(psnl0110List.size() > 150) {
							
							//if(dataCount == 150 ) {
								
							//	param.put("dataList", sbList.toString());
							//}	
							
						//}else {
							if(dataCount == psnl0110List.size() ) {
								
								param.put("dataList", sbList.toString());
								
							}
						//}					
						
						
					}
				}
				
				GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0200Export.do", "extgwtFrame", JsUtil.toJavaScriptObject(param)); 
				
			}
		});
		
	}	
	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {

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
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
    //부서
	private void fnPopupCommP140(String deptCd) {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.

		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd); 		// 부서

		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();

		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("deptCd"))) {
					deptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//					srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));
//					srhDeptCd.fireEvent(Events.Add);
				}
			}
		});
	}
	
	// 고용유형 검색
	private void fnPopupBass0300(final String itemValue) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
		MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통  
	       
		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
	      
		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("commCd"))) { 
//					if ("emymtTypNm".equals(itemValue)) {
						emymtTypNm.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCd")));
//						natnNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
//						natnItem.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeItem12")));
//					} 
				}   
			}
		});
	}
	
	
	// 사업 검색
	private void fnPopupBass0500(final PrgmComBass0500DTO bass0500DTO) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
		MSFFormPanel popComP0150 = PrgmComPopupUtils.lovPopUpPrgmCom0150Form(bass0500DTO);  //공통  
	       
		final FormBinding popBindingCom0150 = popComP0150.getFormBinding();
	      
		popBindingCom0150.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("businCd"))) {
					businNm.setValue( MSFSharedUtils.allowNulls(mapModel.get("businCd")));
				}
			}
		});
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	

}
