package com.app.exterms.payroll.client.form;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.exterms.payroll.client.form.defs.Payr0416Def;
import com.app.exterms.payroll.client.lookup.LookupPayr0415PayYr;
import com.app.exterms.payroll.client.service.PayrP525002Service;
import com.app.exterms.payroll.client.service.PayrP525002ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PayrP525002  extends MSFFormPanel { 

	private ContentPanel payrP525002;

	
	private GWTExtAuth gwtExtAuth;
	private GWTAuthorization gwtAuthorization;
	
	

	private Payr0416Def pPayr525002LDef  = new Payr0416Def("PAYRP525002");   //그리드 테이블 컬럼 define
	private MSFGridPanel pPayr525002LGridPanel;
	

	private Payr0416Def pPayr525002RDef  = new Payr0416Def("PAYRP525002TARGET");   //그리드 테이블 컬럼 define
	private MSFGridPanel pPayr525002RGridPanel;
	
	
	private TextField<String> srhYear;             //적용년도 
	private TextField<String> srhItemNm;           //항목명
	private TextField<String> srhPayrImcd;         //항목코드 
	
	private ComboBox<BaseModel> srhPayCd;          //급여구분

	
	
	private ComboBox<BaseModel> srhPayrMangDeptCd; 	//단위기관
	private ComboBox<BaseModel> srhTypOccuCd; 	/** column 직종코드 : typOccuCd */


	private TextField<String> payrImcd ;  				/** column 급여항목코드 : payrImcd */
	private TextField<String> itemNm;   				/** column 항목명 : itemNm */ 
	private ComboBox<BaseModel> payCd;   				/** column 급여구분코드 : payCd */ 
	private ComboBox<BaseModel> dayMnthAmntDivCd;   	/** column 일월액구분코드 : dayMnthAmntDivCd */
	private CheckBox usalyAmntYn;   					/** column 통상임금여부 : usalyAmntYn */
	private CheckBox payItemUseYn;   					/** column 급여항목사용여부 : payItemUseYn */
	private ComboBox<BaseModel> pymtDducDivCd ;  		/** column 지급공제구분코드 : pymtDducDivCd */
	private ComboBox<BaseModel> pymtDducFrmCd;   		/** column 지급공제유형코드 : pymtDducFrmCd */
	private NumberField pymtDducSum;   					/** column 지급공제액 : pymtDducSum */
	private NumberField pymtDducRate;   				/** column 지급공제율 : pymtDducRate */
	private ComboBox<BaseModel> calcStdDivCd;   		/** column 계산기준구분코드 : calcStdDivCd */
	private ComboBox<BaseModel> txtnDivCd;   			/** column 과세구분코드 : txtnDivCd */
	private NumberField freeDtySum;   					/** column 비과세금액 : freeDtySum */
	private NumberField freeDtyRate ;  					/** column 비과세율 : freeDtyRate */

	private HiddenField<String> emymtDivCd;   			/** column 고용구분코드 : emymtDivCd */
	private CheckBox jan;   							/** column 1월 : jan */
	private CheckBox feb;   							/** column 2월 : feb */
	private CheckBox mar;   							/** column 3월 : mar */
	private CheckBox apr;   							/** column 4월 : apr */
	private CheckBox may;   							/** column 5월 : may */
	private CheckBox jun;   							/** column 6월 : jun */
	private CheckBox jul;   							/** column 7월 : jul */
	private CheckBox aug;   							/** column 8월 : aug */
	private CheckBox sep ;  							/** column 9월 : sep */
	private CheckBox oct;   							/** column 10월 : oct */
	private CheckBox nov;   							/** column 11월 : nov */
	private CheckBox dec;   							/** column 12월 : dec */
	private CheckBox chkAll;   							/** column 전체체크 : chkAll */
	private NumberField rngeOrd ;  						/** column 정렬순서 : rngeOrd */
	private DateField itemApptnBgnnDt ;  				/** column 항목적용시작일자 : itemApptnBgnnDt */
	private DateField itemApptnEndDt;   				/** column 항목적용종료일자 : itemApptnEndDt */
	private TextField<String> payItemNoteCtnt;   		/** column 급여항목비고내용 : payItemNoteCtnt */

	private ComboBox<BaseModel> payrMangDeptCd;   		/** column 급여관리부서코드 : payrMangDeptCd */

	private TextField<String> calcStdFunc;   			/** column 계산수식내용 : calcStdFunc */




	private ComboBox<BaseModel> createYr;				/** column 생성년도 : payYr */ 
	private ComboBox<BaseModel> targetYr;				/** column 생성년도 : payYr */ 
	public static Button btnUsrSearch;
	private SysCoCalendarDTO msfCoCalendarDto;
	public FormBinding formBinding;

	private ListStore<BaseModel> lsYrStore = new ListStore<BaseModel>();
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();
	private LookupPayr0415PayYr lkApptnYr = new LookupPayr0415PayYr();  
	private MSFGridPanel payYrGridPanel;



	private PrgmComBass0300DTO sysComBass0300Dto; 
	private PrgmComBass0150DTO sysComBass0150Dto;  

	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	private void setpayrP525002FormBinding() {
	}        

	private PayrP525002ServiceAsync payrp525002Service = PayrP525002Service.Util.getInstance();	 
	
	private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>();	//급여구분
	private ListStore<BaseModel> lsGdPymtDducDivCd 	= new ListStore<BaseModel>(); 	//지급공제구분코드
	private ListStore<BaseModel> lsPymtDducFrmCd 	= new ListStore<BaseModel>();  	/** column 지급공제유형코드 : pymtDducFrmCd */
	private ListStore<BaseModel> lsTxtnDivCd 		= new ListStore<BaseModel>(); 	/** column 과세구분코드 : txtnDivCd */
	private ListStore<BaseModel> lsDayMnthAmntDivCd = new ListStore<BaseModel>(); 	/** column 일월액구분코드 : dayMnthAmntDivCd */
	private ListStore<BaseModel> lsCalcStdDivCd 	= new ListStore<BaseModel>(); 	/** column 계산기준구분코드 : calcStdDivCd */
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관    
	

	private Button btnMove;
	private Button btnDelect;
	
/*	private void checkPayr1500Auth( String authAction, ListStore<BaseModel> bm) {   
		//MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 

		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

			if (!maskTracker) { unmask(); }  
			authExecEnabled() ;

			gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
		}
	}

	private void authExecEnabled() { 

		Field<?>[] fldArrField = {srhPayrMangDeptCd, srhTypOccuCd, payrMangDeptCd};

		gwtAuthorization.formAuthFieldConfig(fldArrField);
	}*/

	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		
		
		
		//hanNm.setValue((String) model.get("hanNm"));
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
				
				//tempDateFld1.setValue(InsrUtils.getConvertStringToDate((String) model.get("retryDt"), "yyyyMMdd"));
	            //reload();	

	            
			}
		});
	}
	
	public PayrP525002(ActionDatabase actionDatabase, MSFPanel caller) {
		// super();

		this.setBodyBorder(false);
		this.setHeaderVisible(false);

		this.actionDatabase = actionDatabase;
		// this.caller = caller;

		payrP525002 = new ContentPanel();
		createpayrP525002Form();
		createSearchForm();
		createStandardForm();

		payrP525002.setBodyBorder(false);
		payrP525002.setBorders(false);
		payrP525002.setHeaderVisible(false);

		this.add(payrP525002);
		formBinding = new FormBinding(this, true);
		this.setSize("996px", "640px"); // setSize("790px", "610px");

		formBinding = new FormBinding(this, true);

	}
	
	private  void createpayrP525002Form() { 
		payrP525002.setSize("976px", "640px");
	}
	
	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// {
			if (lsPayYrStore.getCount() > 0) {

				cancel();
				unmask();
				// authExecEnabled() ;
				maskTracker = true;

			} else {
				tmMask.scheduleRepeating(2000);
			}
			// }
		}
	};

    private void createSearchForm() {   

    	sysComBass0300Dto = new PrgmComBass0300DTO();
    	sysComBass0150Dto = new PrgmComBass0150DTO(); 
    	
    	//--------------------단위기관 불러 오는 함수 ------------------------------------------------
    	lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
    	//--------------------단위기관 불러 오는 함수 ------------------------------------------------




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
		

    	//LayoutContainer lcSchLeft = new LayoutContainer();
    	//lcSchLeft.setStyleAttribute("paddingRight", "10px");  
    	//lcSchLeft.setStyleAttribute("marginBottom", "5px");  



    	LayoutContainer layoutContainer01 = new LayoutContainer();
    	FormLayout frmlytSch = new FormLayout();  
    	frmlytSch.setLabelWidth(60); 
    	frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
    	layoutContainer01.setLayout(frmlytSch); 
    	srhYear = new TextField<String>();
    	srhYear.setName("payYr");
    	layoutContainer01.add(srhYear, new FormData("100%"));
    	srhYear.setFieldLabel("적용년도");
    	layoutContainer01.setBorders(false);



    	LayoutContainer layoutContainer02 = new LayoutContainer();
    	layoutContainer02.setLayout(new ColumnLayout());


    	LayoutContainer layoutContainer02_1 = new LayoutContainer();
    	frmlytSch = new FormLayout();  
    	frmlytSch.setLabelWidth(60); 
    	frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
    	layoutContainer02_1.setLayout(frmlytSch);
    	srhItemNm = new TextField<String>();
    	layoutContainer02_1.add(srhItemNm, new FormData("100%")); 
    	srhItemNm.setFieldLabel("항목");
    	srhItemNm.setReadOnly(true);
    	layoutContainer02_1.setBorders(false);

    	layoutContainer02.add(layoutContainer02_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));


    	Button btnHanNm = new Button("검색");
    	layoutContainer02.add(btnHanNm);
    	btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			pPayr525002LGridPanel.getMsfGrid().clearData();
    			fnPopupCommP600();
    		}
    	});



    	LayoutContainer layoutContainer02_2 = new LayoutContainer();
    	frmlytSch = new FormLayout();  
    	frmlytSch.setLabelWidth(0); 
    	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
    	layoutContainer02_2.setLayout(frmlytSch);
    	srhPayrImcd = new TextField<String>();
    	srhPayrImcd.setHideLabel(true);
    	srhPayrImcd.setReadOnly(true);
    	layoutContainer02_2.add(srhPayrImcd, new FormData("100%"));
    	layoutContainer02_2.setBorders(false);

    	layoutContainer02.add(layoutContainer02_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));




    	//lcSchLeft.setLayout(new ColumnLayout());

    	LayoutContainer layoutContainer03 = new LayoutContainer();
    	frmlytSch = new FormLayout();  
    	frmlytSch.setLabelWidth(60); 
    	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
    	layoutContainer03.setLayout(frmlytSch);
    	//--------------------공통 코드 불러 오는 함수 -------------------------------------------
    	sysComBass0300Dto.setRpsttvCd("B015");  //급여구분코드 
    	lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);

    	/** column 급여구분코드 : payCd */
    	srhPayCd = new ComboBox<BaseModel>(); 
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
    	
    	
    	srhPayCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
    			if (MSFSharedUtils.paramNull( srhYear.getValue())) {
    				/** column 급여구분코드 : payCd */ 
    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						"적용년도는 필수 항목입니다.", null);
    				return;
    			}
    			if (MSFSharedUtils.paramNull( srhPayrImcd.getValue())) {
    				/** column 급여구분코드 : payCd */ 
    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						"항목은 필수 선택 항목입니다.", null);
    				return;
    			}
    			PayrUtils.setSelectedComboValue(payCd, (String) se.getSelectedItem().get("commCd"), "commCd");	  
    			reload();
            } 
        });
    	
    	
    	layoutContainer03.add(srhPayCd, new FormData("100%")); 
    	//lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
    	layoutContainer03.setBorders(false);


    	LayoutContainer layoutContainer04 = new LayoutContainer();
    	frmlytSch = new FormLayout();  
    	frmlytSch.setLabelWidth(0); 
    	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
    	
    	
    	layoutContainer04.setLayout(frmlytSch);
    	Button btnSearch = new Button("조회");
    	btnSearch.setWidth(60);
    	layoutContainer04.setStyleAttribute("paddingLeft", "200px");
    	
    	layoutContainer04.add(btnSearch);
    	btnSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			if (MSFSharedUtils.paramNull( srhYear.getValue())) {
    				/** column 급여구분코드 : payCd */ 
    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						"적용년도는 필수 항목입니다.", null);
    				return;
    			}
    			if (MSFSharedUtils.paramNull( srhPayrImcd.getValue())) {
    				/** column 급여구분코드 : payCd */ 
    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						"항목은 필수 선택 항목입니다.", null);
    				return;
    			}
    			if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"))) {
    				/** column 급여구분코드 : payCd */ 
    				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
    						"급여구분은 필수 선택 항목입니다.", null);
    				return;
    			}
    			reload();
    		}
    	});


    	lcSchCol.add(layoutContainer01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
    	lcSchCol.add(layoutContainer02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    	lcSchCol.add(layoutContainer03,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
    	lcSchCol.add(layoutContainer04,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));


    	fieldSet.add(lcSchCol, new FormData("100%")); 
    	//lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
    	//lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
    	payrP525002.add(fieldSet); 
    	//vp.add(panel);   
    }  


    
    
    
	private  void createStandardForm() {

/*		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_2 = new FieldSet();
		//	fldstNewFieldset_2.setSize(528, 120);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("상실신고내역");
		fldstNewFieldset_2.setCollapsible(false);

		fldstNewFieldset_2.add(createCheckBoxGrid(),new FormData("100%"));

		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);

		
		
		payrP525002.add(layoutContainer);
		layoutContainer.setBorders(false); */
		
		
		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new FlowLayout());   
        FieldSet fldstNewFieldset1 = new FieldSet();
        fldstNewFieldset1.setSize(976, 150);
        layoutContainer1.add(fldstNewFieldset1);
        fldstNewFieldset1.setHeadingHtml("지급공제상세정보");
        fldstNewFieldset1.setCollapsible(false);
        fldstNewFieldset1.setStyleAttribute("marginTop", "5px");    
        fldstNewFieldset1.add(occupationalRBottom(),new FormData("100%"));
        
        payrP525002.add(layoutContainer1);
        layoutContainer1.setBorders(false);
		
        
        
        

        LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setLayout(new ColumnLayout());
		
		FieldSet fldstNewFieldset2 = new FieldSet();
		fldstNewFieldset2.setCollapsible(false);
		
		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		layoutContainer2_1.setStyleAttribute("paddingLeft", "10px");
		 
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_1.setLayout(frmlytStd);
		layoutContainer2_1.add(payrLeft01(),new FormData("100%"));
		fldstNewFieldset2.add(layoutContainer2_1,new FormData("100%"));
		layoutContainer2_1.setBorders(false);
		
		
		layoutContainer2.add(fldstNewFieldset2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset2.setHeadingHtml("직종세항목생성내역");
		
		
		
		FieldSet fldstNewFieldset3 = new FieldSet();
		
		LayoutContainer layoutContainer2_2 = new LayoutContainer();
		layoutContainer2_2.setStyleAttribute("paddingLeft", "10px");
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2_2.setLayout(frmlytStd);
		layoutContainer2_2.add(payrLeft02(),new FormData("100%"));
		fldstNewFieldset3.add(layoutContainer2_2,new FormData("100%"));
		layoutContainer2_2.setBorders(false);
		
		
		layoutContainer2.add(fldstNewFieldset3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		fldstNewFieldset3.setHeadingHtml("직종세항목생성대상");
		
		
		

        
        
        layoutContainer1.setBorders(false);
		
		
		 
		 payrP525002.add(layoutContainer2);
		
		 
			
			
			//fldstNewFieldset3.setCollapsible(false);
			
			
//			fldstNewFieldset3.setCollapsible(false);
//			fldstNewFieldset3.add(layoutContainer2_2);

		 LayoutContainer layoutContainer3 = new LayoutContainer();
		 layoutContainer3.setLayout(new FlowLayout());   
		 FieldSet fldstNewFieldset4 = new FieldSet();
		 fldstNewFieldset4.setSize(976, 40);
		
		 //fldstNewFieldset1.setHeadingHtml("지급공제상세정보");
		 fldstNewFieldset4.setCollapsible(false);
		 fldstNewFieldset4.setStyleAttribute("marginTop", "4px");  
		 fldstNewFieldset4.setBorders(false);
		 btnUsrSearch = new Button("일괄생성");
		 btnUsrSearch.setIcon(MSFMainApp.ICONS.allExec()); 
		 btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
			 public void handleEvent(ButtonEvent e) {
				 //조회버튼 클릭시 처리 
				 //reload();  
				 MessageBox.confirm("직종세항목생성대상", "직종세 지급항목 일괄설정시 선택된 직종세가 존재하는 경우 삭제 후 재생성 됩니다. 계속 진행 하시겠습니까?",new Listener<MessageBoxEvent>(){
					 @Override
					 public void handleEvent(MessageBoxEvent be) {
						// if("Yes".equals(be.getButtonClicked().getText())){
						 if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							 detailFormSave();
						 }
					 }
				 });
			 }
		 });

		 
		fldstNewFieldset4.add(btnUsrSearch, new FormData("100%"));
		layoutContainer3.add(fldstNewFieldset4);
		layoutContainer3.setStyleAttribute("paddingLeft", "900px");
		payrP525002.add(layoutContainer3);
		layoutContainer3.setBorders(false);
	}

	 
	   
	   
	private LayoutContainer payrLeft01() {
		   
		LayoutContainer lcStdGrid = new LayoutContainer();
		// lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdGrid.setLayout(frmlytStd);
		    
		final ContentPanel cpGridPayrR0540 = new ContentPanel();
		cpGridPayrR0540.setBodyBorder(false);
		cpGridPayrR0540.setHeaderVisible(false);
		cpGridPayrR0540.setLayout(new FitLayout());
		cpGridPayrR0540.setSize(460, 350);
		     
		pPayr525002LGridPanel = new MSFGridPanel(pPayr525002LDef, false, false, false, false, false);
		pPayr525002LGridPanel.setHeaderVisible(false);  
		pPayr525002LGridPanel.setBodyBorder(true);
		pPayr525002LGridPanel.setBorders(true);
		final Grid payr0540Grid = pPayr525002LGridPanel.getMsfGrid().getGrid(); 
		payr0540Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (pPayr525002LGridPanel.getCurrentlySelectedItem() != null) {  
		           		
				}
			}
		});  
		    
			   
		// 두번째 미사용직종정보 툴바 		            
		ToolBar bottomToolbar2 = new ToolBar();  
		bottomToolbar2.add(new FillToolItem());
		// ================전체선택버튼=========================
		
		btnMove = new Button("이동");
		btnMove.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(pPayr525002LGridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
					
					List<BaseModel> list = pPayr525002LGridPanel.getGrid().getSelectionModel().getSelectedItems();
					
					for(BaseModel bm : list){
						pPayr525002LGridPanel.getGrid().getStore().remove(bm);
					}
					
					pPayr525002RGridPanel.getGrid().getStore().add(list);
			        		 
				}
			}  
		});
			    
			 
		bottomToolbar2.add(btnMove);
		bottomToolbar2.add(new SeparatorMenuItem());
		// ====================================================admi
		pPayr525002LGridPanel.setBottomComponent(bottomToolbar2);

		cpGridPayrR0540.add(pPayr525002LGridPanel);

		lcStdGrid.add(cpGridPayrR0540);
		return lcStdGrid;
	}
	
	private LayoutContainer payrLeft02() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		// lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(460, 350);  
		    
		    
		pPayr525002RGridPanel = new MSFGridPanel(pPayr525002RDef, false, false, false, false, false);
		pPayr525002RGridPanel.setHeaderVisible(false);  
		pPayr525002RGridPanel.setBodyBorder(true);
		pPayr525002RGridPanel.setBorders(true);
		final Grid payr150002Target = pPayr525002RGridPanel.getMsfGrid().getGrid(); 
		payr150002Target.addListener(Events.Select,  new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (pPayr525002RGridPanel.getCurrentlySelectedItem() != null) {  
		           		
				}
			}
		});  
		    
		// 두번째 미사용직종정보 툴바
		ToolBar bottomToolbar2 = new ToolBar();
		bottomToolbar2.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnDelect = new Button("제거");
		btnDelect.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(pPayr525002RGridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
			        		 
					List<BaseModel> list = pPayr525002RGridPanel.getGrid().getSelectionModel().getSelectedItems();
					
					for(BaseModel bm : list){
						pPayr525002RGridPanel.getGrid().getStore().remove(bm);
					}
					
					pPayr525002LGridPanel.getGrid().getStore().add(list);
			        		 
				}
			}  
		});

		bottomToolbar2.add(btnDelect);
		bottomToolbar2.add(new SeparatorMenuItem());
		// ====================================================admi
		pPayr525002RGridPanel.setBottomComponent(bottomToolbar2);

		cpGrid.add(pPayr525002RGridPanel);

		lcStdGrid.add(cpGrid);

		return lcStdGrid;

	}
	   
	private LayoutContainer occupationalRBottom() {
		
		
		sysComBass0150Dto = new PrgmComBass0150DTO();
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
         
		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FlowLayout());
		cp01.setSize(960, 150);
	         
	       
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
	         
		/** column 급여항목코드 : payrImcd */
		payrImcd = new TextField<String>();
		layoutContainer_1.add(payrImcd, new FormData("100%"));
		payrImcd.setFieldLabel("항 목");
		layoutContainer_1.setBorders(false);
	    layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	            
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(5);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		/** column 항목명 : itemNm */
		itemNm = new TextField<String>();
		layoutContainer_2.add(itemNm, new FormData("100%"));
		itemNm.setLabelSeparator("");
		itemNm.setFieldLabel("");
		layoutContainer_2.setBorders(false);
	    layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	             
	          
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
	          
	          
	          
	    //--------------------공통 코드 불러 오는 함수 -------------------------------------------
	    sysComBass0300Dto.setRpsttvCd("B015");  //급여구분코드 
	    lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);

		/** column 급여구분코드 : payCd */
		payCd = new ComboBox<BaseModel>();
		payCd.setForceSelection(true);
		payCd.setMinChars(1);
		payCd.setDisplayField("commCdNm");
		payCd.setValueField("commCd");
		payCd.setTriggerAction(TriggerAction.ALL);
		payCd.setEmptyText("--급여구분선택--");
		payCd.setSelectOnFocus(true);
		payCd.setReadOnly(true);
		payCd.setEnabled(true);
		payCd.setStore(lsPayCd);
		payCd.setFieldLabel("급여구분");

		layoutContainer_3.add(payCd, new FormData("100%"));
		layoutContainer_3.setBorders(false);
		layoutContainer.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);
	        
	          
		//--------------------공통 코드 불러 오는 함수 -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B016");  //과세구분  
		lsDayMnthAmntDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
               
            
		/** column 일월액구분코드 : dayMnthAmntDivCd */
		dayMnthAmntDivCd = new ComboBox<BaseModel>();
		dayMnthAmntDivCd.setForceSelection(true);
		dayMnthAmntDivCd.setMinChars(1);
		dayMnthAmntDivCd.setDisplayField("commCdNm");
		dayMnthAmntDivCd.setValueField("commCd");
		dayMnthAmntDivCd.setTriggerAction(TriggerAction.ALL);
		dayMnthAmntDivCd.setEmptyText("--일월액구분선택--");
		dayMnthAmntDivCd.setSelectOnFocus(true);
		dayMnthAmntDivCd.setReadOnly(false);
		dayMnthAmntDivCd.setEnabled(true);
		dayMnthAmntDivCd.setStore(lsDayMnthAmntDivCd);
		dayMnthAmntDivCd.setFieldLabel("일월액구분");

		layoutContainer_4.add(dayMnthAmntDivCd, new FormData("100%"));
		layoutContainer_4.setBorders(false);
	          
		layoutContainer.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          
	          
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytStd);

		/** column 통상임금여부 : usalyAmntYn */
		usalyAmntYn = new CheckBox();
		usalyAmntYn.setBoxLabel("통상임금");
		usalyAmntYn.setHideLabel(true);
		layoutContainer_9.add(usalyAmntYn, new FormData("100%"));
		layoutContainer_9.setBorders(false);
		layoutContainer_9.setStyleAttribute("padding-left", "27px");
	          
	    layoutContainer_5.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	           
		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		/** column 급여항목사용여부 : payItemUseYn */
		payItemUseYn = new CheckBox();
		payItemUseYn.setBoxLabel("사용여부");
		payItemUseYn.setHideLabel(true);
		layoutContainer_10.add(payItemUseYn, new FormData("100%"));
		layoutContainer_10.setBorders(false);
		layoutContainer_10.setStyleAttribute("padding-left", "25px");
	          
		layoutContainer_5.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_5.setBorders(false);	          
		layoutContainer.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer.setBorders(false);

	          
		cp01.add(layoutContainer);

		LayoutContainer layoutContainer02 = new LayoutContainer();
		layoutContainer02.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytStd);
	          

		//--------------------공통 코드 불러 오는 함수 -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B008");  //지급공제구분코드  
		lsGdPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	            
	          
		/** column 지급공제구분코드 : pymtDducDivCd */
		pymtDducDivCd = new ComboBox<BaseModel>();
		pymtDducDivCd.setForceSelection(true);
		pymtDducDivCd.setMinChars(1);
		pymtDducDivCd.setDisplayField("commCdNm");
		pymtDducDivCd.setValueField("commCd");
		pymtDducDivCd.setTriggerAction(TriggerAction.ALL);
		pymtDducDivCd.setEmptyText("--지급공제구분선택--");
		pymtDducDivCd.setSelectOnFocus(true);
		pymtDducDivCd.setReadOnly(false);
		pymtDducDivCd.setEnabled(true);
		pymtDducDivCd.setStore(lsGdPymtDducDivCd);
		pymtDducDivCd.setFieldLabel("지급공제구분");

		layoutContainer_11.add(pymtDducDivCd, new FormData("100%"));
		layoutContainer_11.setBorders(false);
	          
		layoutContainer02.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          
	          
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytStd);
	          

		//--------------------공통 코드 불러 오는 함수 -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B017");  //지급공제유형코드  
		lsPymtDducFrmCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	             
	          
		/** column 지급공제유형코드 : pymtDducFrmCd */
		pymtDducFrmCd = new ComboBox<BaseModel>();
		pymtDducFrmCd.setForceSelection(true);
		pymtDducFrmCd.setMinChars(1);
		pymtDducFrmCd.setDisplayField("commCdNm");
		pymtDducFrmCd.setValueField("commCd");
		pymtDducFrmCd.setTriggerAction(TriggerAction.ALL);
		pymtDducFrmCd.setEmptyText("--지급공제유형선택--");
		pymtDducFrmCd.setSelectOnFocus(true);
		pymtDducFrmCd.setReadOnly(false);
		pymtDducFrmCd.setEnabled(true);
		pymtDducFrmCd.setStore(lsPymtDducFrmCd);
		pymtDducFrmCd.setFieldLabel("지급공제유형");
		layoutContainer_21.add(pymtDducFrmCd, new FormData("100%"));
		layoutContainer_21.setBorders(false);
	          
		layoutContainer02.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
	          
		LayoutContainer layoutContainer_31 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_31.setLayout(frmlytStd);
	          
		/** column 지급공제액 : pymtDducSum */
		pymtDducSum = new NumberField();
		pymtDducSum.setFieldLabel("지급공제금액");
		pymtDducSum.setAllowDecimals(true);
		pymtDducSum.setPropertyEditorType(Long.class);
		pymtDducSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_31.add(pymtDducSum, new FormData("100%"));
		layoutContainer_31.setBorders(false);
		layoutContainer02.add(layoutContainer_31, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          
	          
		LayoutContainer layoutContainer_41 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_41.setLayout(frmlytStd);

		/** column 지급공제율 : pymtDducRate */
		pymtDducRate = new NumberField();
		pymtDducRate.setFieldLabel("지급공제율");
		pymtDducRate.setAllowDecimals(true);
		pymtDducRate.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_41.add(pymtDducRate, new FormData("100%"));
		layoutContainer_41.setBorders(false);
	          
		layoutContainer02.add(layoutContainer_41, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
	          
		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytStd);

		// --------------------공통 코드 불러 오는 함수 -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B019"); // 급여게산기준코드
		lsCalcStdDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);

		/** column 계산기준구분코드 : calcStdDivCd */
		calcStdDivCd = new ComboBox<BaseModel>();
		calcStdDivCd.setForceSelection(true);
		calcStdDivCd.setMinChars(1);
		calcStdDivCd.setDisplayField("commCdNm");
		calcStdDivCd.setValueField("commCd");
		calcStdDivCd.setTriggerAction(TriggerAction.ALL);
		calcStdDivCd.setEmptyText("--계산기준선택--");
		calcStdDivCd.setSelectOnFocus(true);
		calcStdDivCd.setReadOnly(false);
		calcStdDivCd.setEnabled(true);
		calcStdDivCd.setStore(lsCalcStdDivCd);
		calcStdDivCd.setFieldLabel("계산기준");
	          
		layoutContainer_6.add(calcStdDivCd, new FormData("100%"));
		layoutContainer_6.setBorders(false);

		layoutContainer02.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer02.setBorders(false);
		cp01.add(layoutContainer02);

		LayoutContainer layoutContainer03 = new LayoutContainer();
		layoutContainer03.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytStd);
	          
		//--------------------공통 코드 불러 오는 함수 -------------------------------------------
		sysComBass0300Dto.setRpsttvCd("B005");  //과세구분  
		lsTxtnDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	             
	          
		/** column 과세구분코드 : txtnDivCd */
		txtnDivCd = new ComboBox<BaseModel>();
		txtnDivCd.setForceSelection(true);
		txtnDivCd.setMinChars(1);
		txtnDivCd.setDisplayField("commCdNm");
		txtnDivCd.setValueField("commCd");
		txtnDivCd.setTriggerAction(TriggerAction.ALL);
		txtnDivCd.setEmptyText("--과세구분선택--");
		txtnDivCd.setSelectOnFocus(true);
		txtnDivCd.setReadOnly(false);
		txtnDivCd.setEnabled(true);
		txtnDivCd.setStore(lsTxtnDivCd);
		txtnDivCd.setFieldLabel("과세구분");
		layoutContainer_12.add(txtnDivCd, new FormData("100%"));
		layoutContainer_12.setBorders(false);
	          
		layoutContainer03.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	          
	          
		LayoutContainer layoutContainer_22 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_22.setLayout(frmlytStd);

		/** column 비과세금액 : freeDtySum */
		freeDtySum = new NumberField();
		freeDtySum.setFieldLabel("비과세금액");
		freeDtySum.setAllowDecimals(true);
		freeDtySum.setPropertyEditorType(Long.class);
		freeDtySum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_22.add(freeDtySum, new FormData("100%"));
		layoutContainer_22.setBorders(false);
		layoutContainer03.add(layoutContainer_22, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	         
	          
		LayoutContainer layoutContainer_32 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_32.setLayout(frmlytStd);

		/** column 비과세율 : freeDtyRate */
		freeDtyRate = new NumberField();
		freeDtyRate.setFieldLabel("비과세율");
		freeDtyRate.setAllowDecimals(true);
		freeDtyRate.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_32.add(freeDtyRate, new FormData("100%"));
		layoutContainer03.add(layoutContainer_32,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_32.setBorders(false);
	          
		LayoutContainer layoutContainer_42 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytStd);

		/** column 항목적용시작일자 : itemApptnBgnnDt */
		itemApptnBgnnDt = new DateField();
		itemApptnBgnnDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat()));
		itemApptnBgnnDt.setName("itemApptnBgnnDt");
		itemApptnBgnnDt.setFieldLabel("시작일자");

		layoutContainer_42.add(itemApptnBgnnDt, new FormData("100%"));

		layoutContainer03.add(layoutContainer_42,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_42.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytStd);
	          
		/** column 항목적용종료일자 : itemApptnEndDt */
		itemApptnEndDt = new DateField();
		itemApptnEndDt.setName("itemApptnEndDt");
		itemApptnEndDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat()));
		itemApptnEndDt.setFieldLabel("종료일자");

		layoutContainer_7.add(itemApptnEndDt, new FormData("100%"));
		layoutContainer_7.setBorders(false);
		layoutContainer03.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer03.setBorders(false);
		cp01.add(layoutContainer03);

		LayoutContainer layoutContainer04 = new LayoutContainer();
		layoutContainer04.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(50);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);
	          
		Listener<BaseEvent> chkListener = new CheckboxListener();
		CheckBoxGroup chckbxgrpNewCheckboxgroup = new CheckBoxGroup();

		/** column 1월 : jan */
		jan = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(jan);
		jan.setBoxLabel("1월");
		jan.setHideLabel(true);

		/** column 2월 : feb */
		feb = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(feb);
		feb.setBoxLabel("2월");
		feb.setHideLabel(true);

		/** column 3월 : mar */
		mar = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(mar);
		mar.setBoxLabel("3월");
		mar.setHideLabel(true);

		/** column 4월 : apr */
		apr = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(apr);
		apr.setBoxLabel("4월");
		apr.setHideLabel(true);

		/** column 5월 : may */
		may = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(may);
		may.setBoxLabel("5월");
		may.setHideLabel(true);

		/** column 6월 : jun */
		jun = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(jun);
		jun.setBoxLabel("6월");
		jun.setHideLabel(true);

		/** column 7월 : jul */
		jul = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(jul);
		jul.setBoxLabel("7월");
		jul.setHideLabel(true);

		/** column 8월 : aug */
		aug = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(aug);
		aug.setBoxLabel("8월");
		aug.setHideLabel(true);

		/** column 9월 : sep */
		sep = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(sep);
		sep.setBoxLabel("9월");
		sep.setHideLabel(true);

		/** column 10월 : oct */
		oct = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(oct);
		oct.setBoxLabel("10월");
		oct.setHideLabel(true);

		/** column 11월 : nov */
		nov = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(nov);
		nov.setBoxLabel("11월");
		nov.setHideLabel(true);

		/** column 12월 : dec */
		dec = new CheckBox();

		chckbxgrpNewCheckboxgroup.add(dec);
		dec.setBoxLabel("12월");
		dec.setHideLabel(true);

		chkAll = new CheckBox();
		chckbxgrpNewCheckboxgroup.add(chkAll);
		chkAll.addListener(Events.OnClick, chkListener);
		chkAll.setBoxLabel("전체");
		chkAll.setHideLabel(true);
	          
		layoutContainer_13.add(chckbxgrpNewCheckboxgroup, new FormData("100%"));
		chckbxgrpNewCheckboxgroup.setFieldLabel("지급월");
		layoutContainer04.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		layoutContainer_13.setBorders(false);

		LayoutContainer layoutContainer_43 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(40);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_43.setLayout(frmlytStd);

		/** column 정렬순서 : rngeOrd */
		rngeOrd = new NumberField();
		rngeOrd.setFieldLabel("순서");
		rngeOrd.setPropertyEditorType(Long.class);
		rngeOrd.setAllowDecimals(true);
		rngeOrd.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_43.add(rngeOrd, new FormData("100%"));
		layoutContainer_43.setBorders(false);
		layoutContainer04.add(layoutContainer_43,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		layoutContainer04.setBorders(false);
		cp01.add(layoutContainer04);

		LayoutContainer layoutContainer04_1 = new LayoutContainer();
		layoutContainer04_1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytStd);
	         
		/** column 급여항목비고내용 : payItemNoteCtnt */
		payItemNoteCtnt = new TextField<String>();
		payItemNoteCtnt.setFieldLabel("비 고");
		layoutContainer_8.add(payItemNoteCtnt, new FormData("100%"));
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_8_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8_1.setLayout(frmlytStd);
           
		/** column 단위기관 : payrMangDeptCd */
		payrMangDeptCd = new ComboBox<BaseModel>();
		payrMangDeptCd.setName("payrMangDeptCd");
		payrMangDeptCd.setForceSelection(true);
		payrMangDeptCd.setMinChars(1);
		payrMangDeptCd.setDisplayField("payrMangDeptNm");
		payrMangDeptCd.setValueField("payrMangDeptCd");
		payrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		payrMangDeptCd.setEmptyText("--단위기관선택--");
		payrMangDeptCd.setSelectOnFocus(true);
		// payrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		// payrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
		payrMangDeptCd.setStore(lsPayrMangDeptCd);
		payrMangDeptCd.setFieldLabel("단위기관");
		payrMangDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  

//	                	payrMangDeptCd.setValue(lsPayrMangDeptCd.findModel("payrMangDeptCd",MSFMainApp.get().getUser().getPayrMangDeptCd() ));  
//	                	 EventType type = be.getType();
//				    	   if (type == Store.Add) { 
//		                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//				                	checkPayr1500Auth("PayrMangDeptCd", lsPayrMangDeptCd); 
//		                	 }
	                    
			}
		});   
		
		payrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

			}
		});

		layoutContainer_8_1.add(payrMangDeptCd, new FormData("100%"));
		layoutContainer_8_1.setBorders(false);

	    layoutContainer04_1.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    layoutContainer04_1.add(layoutContainer_8_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer04_1.setBorders(false);
		cp01.add(layoutContainer04_1);

		calcStdFunc = new TextField<String>();
		calcStdFunc.setFieldLabel("게산식");
		calcStdFunc.setVisible(false);
	         
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	 
	 
	
	/*private LayoutContainer createCheckBoxGrid() {    
		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();    
		lcStdGrid.setLayout(frmlytStd);  

		ContentPanel cpGrid = new ContentPanel();   
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());      
		cpGrid.setSize(560, 330);  

		pPayr150001GridPanel = new MSFGridPanel(pPayr1500Def, false, false, false, false);
		pPayr150001GridPanel.setHeaderVisible(false);  
		pPayr150001GridPanel.setBodyBorder(true);
		pPayr150001GridPanel.setBorders(true);
		//pPayr150001GridPanel.getBottomComponent().setVisible(false);

		


		final Grid pPayr150001Grid = pPayr150001GridPanel.getMsfGrid().getGrid(); 
		pPayr150001Grid.addListener(Events.CellClick,  new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (pPayr150001GridPanel.getCurrentlySelectedItem() != null) {  
					
					
					if(MSFSharedUtils.allowNulls(pPayr150001GridPanel.getCurrentlySelectedItem().get("transferYn")).equals("true")){
						//Window.alert("직종세이관 완료된 필드");

						//pPayr150001GridPanel.getMsfGrid().getTableDef().getColumnModel().getColumn(0).getId();
						//pPayr150001GridPanel.getMsfGrid().getGrid().getStore().commitChanges();

					}
				}
			}
		});
		
		
		cpGrid.add(pPayr150001GridPanel); 			    
		lcStdGrid.add(cpGrid);
		return lcStdGrid;  
	}   */
	 
	 
	 

	public void reload() {
		
		IColumnFilter filters = null;
		pPayr525002LGridPanel.getMsfGrid().clearData();
		pPayr525002LGridPanel.getTableDef().setTableColumnFilters(filters);			
		pPayr525002LGridPanel.getTableDef().addColumnFilter("payYr", srhYear.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);
		pPayr525002LGridPanel.getTableDef().addColumnFilter("payrImcd", srhPayrImcd.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);		
		pPayr525002LGridPanel.getTableDef().addColumnFilter("itemNm", srhItemNm.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);
		pPayr525002LGridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);	
		pPayr525002LGridPanel.reload();
	}
	
	

	public void reload2() {
		
		IColumnFilter filters = null;
		pPayr525002RGridPanel.getMsfGrid().clearData();
		pPayr525002RGridPanel.getTableDef().setTableColumnFilters(filters);	
		pPayr525002RGridPanel.reload();
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

	 //전체선택 체크박스 
    public class CheckboxListener implements Listener<BaseEvent>
    {
        public void handleEvent(BaseEvent be) {
            CheckBox checkBox = (CheckBox) be.getSource();
            if (checkBox.getValue()) {
               //전체선택
                jan.setValue(true);   /** column 1월 : jan */
                feb.setValue(true);   /** column 2월 : feb */
                mar.setValue(true);   /** column 3월 : mar */
                apr.setValue(true);   /** column 4월 : apr */
                may.setValue(true);   /** column 5월 : may */
                jun.setValue(true);   /** column 6월 : jun */
                jul.setValue(true);   /** column 7월 : jul */
                aug.setValue(true);   /** column 8월 : aug */
                sep.setValue(true) ;  /** column 9월 : sep */
                oct.setValue(true);   /** column 10월 : oct */
                nov.setValue(true);   /** column 11월 : nov */
                dec.setValue(true);   /** column 12월 : dec */
            } else {
               //전체해제  
                jan.setValue(false);   /** column 1월 : jan */
                feb.setValue(false);   /** column 2월 : feb */
                mar.setValue(false);   /** column 3월 : mar */
                apr.setValue(false);   /** column 4월 : apr */
                may.setValue(false);   /** column 5월 : may */
                jun.setValue(false);   /** column 6월 : jun */
                jul.setValue(false);   /** column 7월 : jul */
                aug.setValue(false);   /** column 8월 : aug */
                sep.setValue(false) ;  /** column 9월 : sep */
                oct.setValue(false);   /** column 10월 : oct */
                nov.setValue(false);   /** column 11월 : nov */
                dec.setValue(false);   /** column 12월 : dec */
            }
        }
    }   
    
    /**
     * 지급공제선택 
     */
   private void fnPopupCommP600() {

	   PrgmComP0500DTO sysComP0500Dto = new PrgmComP0500DTO();
       //지급공제구분코드 넘김.
       MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpPrgmCom0500Form(sysComP0500Dto);  //인사  
       
       final FormBinding popBindingCom0500 = popCom0500.getFormBinding();
      
       popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {
               List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
               if (mapModels != null) { 
            	   
            	   if(1 < mapModels.size()){
            		   Window.alert("하나의 수당만 선택가능 합니다.");
            	   }else{
            		   srhItemNm.setValue((String) mapModels.get(0).get("payExtpyNm"));
            		   srhPayrImcd.setValue((String) mapModels.get(0).get("payExtpyCd"));
            		   
            		   itemNm.setValue((String) mapModels.get(0).get("payExtpyNm"));
            		   payrImcd.setValue((String) mapModels.get(0).get("payExtpyCd"));
            		   
            	   }           	
               }  
           }
       });
   }
   
   
	   
   /**
    * form detail info data update 
    */
   public void detailFormSave() {

	   
	   if(pPayr525002RGridPanel.getMsfGrid().getGrid().getStore().getModels().size() > 0){

		   /** column 급여항목코드 : payItemCd */    
		   if (MSFSharedUtils.paramNull(payrImcd.getValue())) {
			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					   "급여항목이 존재하지 않습니다.", null);
			   return;
		   } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(payCd,"commCd"))) {
			   /** column 급여구분코드 : payCd */ 
			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					   "급여구분은 필수 선택 항목입니다.", null);
			   return;
		   } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd,"commCd"))) {
			   /** column 지급공제구분코드 : pymtDducDivCd */  
			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					   "지급공제구분은 필수 선택 항목입니다.", null);
			   return;
		   } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd,"commCd"))) {
			   /** column 지급공제유형코드 : pymtDducFrmCd */
			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					   "지급공제유형은 필수 선택 항목입니다.", null);
			   return;
		   } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(txtnDivCd,"commCd"))) {
			   /** column 과세구분코드 : txtnDivCd */ 
			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					   "과세구분은 필수 선택 항목입니다.", null);
			   return;
		   } else if (MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(calcStdDivCd,"commCd"))) {
			   /** column 계산기준구분코드 : calcStdDivCd */ 
			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					   "계산기준구분은 필수 선택 항목입니다.", null);
			   return;
		   } else if (MSFSharedUtils.paramNull( MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd,"commCd"))) {
			   /** column 일월액구분코드 : dayMnthAmntDivCd */
			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					   "일월액구분은 필수 선택 항목입니다.", null);
			   return;
		   }


		   Payr0417DTO payr0417Dto = new Payr0417DTO(); 

		   //payr0417Dto.setDpobCd(MSFSharedUtils.allowNulls(detailRecord.get("dpobCd")));
		   payr0417Dto.setPayYr(srhYear.getValue());

		   // payr0417Dto.setTypOccuGrdeMppgSeilNum((Long)detailRecord.get("typOccuGrdeMppgSeilNum"));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
		   // payr0417Dto.setPayrItemSeilNum((Long)detailRecord.get("payrItemSeilNum"));                  /** column 급여항목일련번호 : payrItemSeilNum */

		   //payr0417Dto.setTypOccuCd(MSFSharedUtils.allowNulls(detailRecord.get("typOccuCd"))) ;
		   //payr0417Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(detailRecord.get("dtilOccuInttnCd"))) ;
		   // payr0417Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(detailRecord.get("pyspGrdeCd"))); 

		   /** EMYMT_DIV_CD 고용구분코드*/
		   payr0417Dto.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD01); 
		   /** PAY_CD */
		   payr0417Dto.setPayCd(MSFSharedUtils.allowNulls(payCd.getValue().get("commCd")));

		   /** PAYR_IMCD */
		   payr0417Dto.setPayrImcd(payrImcd.getValue());

		   /** ITEM_NM */
		   payr0417Dto.setItemNm(itemNm.getValue());

		   /** PYMT_DDUC_DIV_CD */
		   payr0417Dto.setPymtDducDivCd(MSFSharedUtils.getSelectedComboValue(pymtDducDivCd, "commCd"));

		   /** PYMT_DDUC_FRM_CD */
		   payr0417Dto.setPymtDducFrmCd(MSFSharedUtils.getSelectedComboValue(pymtDducFrmCd, "commCd"));

		   /** PYMT_DDUC_RATE */
		   payr0417Dto.setPymtDducRate((Double) pymtDducRate.getValue());

		   /** PYMT_DDUC_SUM */
		   payr0417Dto.setPymtDducSum((Long) pymtDducSum.getValue());

		   /** TXTN_DIV_CD */
		   payr0417Dto.setTxtnDivCd(MSFSharedUtils.getSelectedComboValue(txtnDivCd, "commCd"));

		   /** FREE_DTY_RATE */
		   payr0417Dto.setFreeDtyRate((Double) freeDtyRate.getValue());

		   /** FREE_DTY_SUM */
		   payr0417Dto.setFreeDtySum((Long) freeDtySum.getValue());

		   /** JAN */
		   payr0417Dto.setJan(jan.getValue()?"Y":"N");

		   /** FEB */
		   payr0417Dto.setFeb(feb.getValue()?"Y":"N");

		   /** MAR */
		   payr0417Dto.setMar(mar.getValue()?"Y":"N");

		   /** APR */
		   payr0417Dto.setApr(apr.getValue()?"Y":"N");

		   /** MAY */
		   payr0417Dto.setMay(may.getValue()?"Y":"N");

		   /** JUN */
		   payr0417Dto.setJun(jun.getValue()?"Y":"N");

		   /** JUL */
		   payr0417Dto.setJul(jul.getValue()?"Y":"N");

		   /** AUG */
		   payr0417Dto.setAug(aug.getValue()?"Y":"N");

		   /** SEP */
		   payr0417Dto.setSep(sep.getValue()?"Y":"N");

		   /** OCT */
		   payr0417Dto.setOct(oct.getValue()?"Y":"N");

		   /** NOV */
		   payr0417Dto.setNov(nov.getValue()?"Y":"N");

		   /** DEC */
		   payr0417Dto.setDec(dec.getValue()?"Y":"N");

		   /** RNGE_ORD */
		   payr0417Dto.setRngeOrd((Long) rngeOrd.getValue());

		   /** PAY_ITEM_USE_YN */
		   payr0417Dto.setPayItemUseYn(payItemUseYn.getValue()?"Y":"N");

		   /** ITEM_APPTN_BGNN_DT */
		   payr0417Dto.setItemApptnBgnnDt(GWTUtils.getStringFromDate(itemApptnBgnnDt.getValue(), "yyyyMMdd"));

		   /** ITEM_APPTN_END_DT */
		   payr0417Dto.setItemApptnEndDt(GWTUtils.getStringFromDate(itemApptnEndDt.getValue(), "yyyyMMdd"));

		   /** DAY_MNTH_AMNT_DIV_CD */
		   payr0417Dto.setDayMnthAmntDivCd(MSFSharedUtils.getSelectedComboValue(dayMnthAmntDivCd, "commCd"));

		   /** CALC_STD_DIV_CD */
		   payr0417Dto.setCalcStdDivCd(MSFSharedUtils.getSelectedComboValue(calcStdDivCd, "commCd"));

		   /** USALY_AMNT_YN */
		   payr0417Dto.setUsalyAmntYn(usalyAmntYn.getValue()?"Y":"N");

		   /** PAY_ITEM_NOTE_CTNT */
		   payr0417Dto.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(payItemNoteCtnt.getValue()));

		   payr0417Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(payrMangDeptCd, "payrMangDeptCd"));
		   payr0417Dto.setCalcStdFunc(MSFSharedUtils.allowNulls(calcStdFunc.getValue()));

		   //------

		   payrp525002Service.activityOnPayr525002ToPayr0417Insert( pPayr525002RGridPanel.getMsfGrid().getGrid().getStore().getModels(), payr0417Dto, new AsyncCallback<Long>() {
			   public void onFailure(Throwable caught) {
				   MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						   MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr150002ToPayr0410Insert() : " + caught), null);
			   }
			   public void onSuccess(Long result) { 
				   if (result == 0) {
					   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), " 일괄생성 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				   } else {
					   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  " 일괄생성 처리가 완료되었습니다.", null);					   
					   reload();

					   List<BaseModel> list = pPayr525002RGridPanel.getMsfGrid().getGrid().getStore().getModels();
					   for(BaseModel bm : list){
						   pPayr525002RGridPanel.getGrid().getStore().remove(bm);
					   }
				   } 
			   } 
		   });
	   }else{
		   MessageBox.alert(null,  " 직종세항목생성대상이 없습니다.", null);
	   }
   } 
   
   
   
}
