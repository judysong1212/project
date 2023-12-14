package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0410DTO;
import com.app.exterms.personal.client.service.Psnl0410Service;
import com.app.exterms.personal.client.service.Psnl0410ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Psnl0410 extends MSFPanel {

/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 시작} 
 * #######################################################
 */
	
	private HiddenField<String> srhSystemkey;		// 시스템키
	// -------------- 검색조건 시작 -------------- 
	private TextField<String> searchHanNm;			//성명
	private TextField<String> searchResnRegnNum; 	//주민번호
	private DateField searchCertcIssDtS; 			//발급기간 시작일자
	private DateField searchCertcIssDtE; 			//발급기간 종료일자
	private ComboBox<BaseModel> searchCertcDivCd; 	//증명서 구분
	// -------------- 검색조건 종료 -------------- 
	
	// -------------- store 선언 시작 --------------
	private ListStore<BaseModel> listStoreA038 = new ListStore<BaseModel>();
	// -------------- store 선언 종료 --------------
	
	// -------------- 서비스 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();	//공통코드 
	private Psnl0410ServiceAsync psnl0410Service = Psnl0410Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
	// -------------- grid 선언 시작 --------------
	private Grid<Psnl0410DTO> psnl0410Grid; 
	// -------------- grid 선언 종료 --------------
	
	
	private RpcProxy<BaseListLoadResult<Psnl0410DTO>> psnl0410Proxy = new RpcProxy<BaseListLoadResult<Psnl0410DTO>>() {

		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Psnl0410DTO>> callback) {
			
			Psnl0410DTO dto = new Psnl0410DTO();
			dto.setHanNm(searchHanNm.getValue());
			dto.setSystemkey(srhSystemkey.getValue());
			dto.setResnRegnNum(searchResnRegnNum.getValue());
			dto.setSearchCertcIssDtS(PersonalUtil.getConvertDateToString(searchCertcIssDtS, "yyyyMMdd"));
			dto.setSearchCertcIssDtE(PersonalUtil.getConvertDateToString(searchCertcIssDtE, "yyyyMMdd"));
			dto.setCertcDivCd(PersonalUtil.getSelectedComboValue(searchCertcDivCd, "commCd"));
			try{
				psnl0410Service.selectPsnl0410((BaseListLoadConfig) loadConfig,	dto, callback);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0410Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0410Proxy);
	private ListStore<Psnl0410DTO> psnl0410Store = new ListStore<Psnl0410DTO>(psnl0410Loader);
	
	
/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 종료} 
 * #######################################################
 */
	
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	print Service 선언부 시작
     *  rex 추가로 리포트 타입변경
     *  fileName : 출력파일명 
     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
	private void Psnl0410Print(String fileName, String repType) {
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			   RdaPrint(fileName);
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			   RexPrint(fileName);
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		   }
	    }	

	//rda
	private void RdaPrint(final String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PSNL";
		
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		
		
		// 보낼 파라미터
		String strParam ="";
		
		//검색조건
		String serarchParam = "";
		
        
		serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";	//$1 사업장코드
		serarchParam += "[" + MSFSharedUtils.defaultNulls(searchHanNm.getValue(), "") + "]";		//$2 성명
		serarchParam += "[" + MSFSharedUtils.allowNulls(srhSystemkey.getValue()) + "]";		   		//$3 시스템키
		serarchParam += "[" + MSFSharedUtils.allowNulls(searchResnRegnNum.getValue()) + "]";		//$4 주민등록번호
		serarchParam += "[" + MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchCertcIssDtS, "yyyyMMdd")) + "]";	//$5 발급 시작 일자
		serarchParam += "[" + MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchCertcIssDtE, "yyyyMMdd")) + "]";	//$6 발급 종료 일자
		serarchParam += "[" + MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchCertcDivCd, "commCd")) + "]";		//$7 증명서 구분
		
		strParam = "/rp " + serarchParam;
			
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	}
	
	//rex
	private void RexPrint(final String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PSNL";
		
		// reb 출력물
		String rexFileName = fileName+".reb";
		
		
		// 보낼 파라미터
		String strParam ="";
		
		//검색조건
		String serarchParam = "";
		
		serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";			//$1 사업장코드
		serarchParam += "" + MSFSharedUtils.defaultNulls(searchHanNm.getValue(), "") + "⊥";					//$2 성명
		serarchParam += "" + MSFSharedUtils.allowNulls(srhSystemkey.getValue()) + "⊥";		   				//$3 시스템키
		serarchParam += "" + MSFSharedUtils.allowNulls(searchResnRegnNum.getValue()) + "⊥";					//$4 주민등록번호
		serarchParam += "" + MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchCertcIssDtS, "yyyyMMdd")) + "⊥";	//$5 발급 시작 일자
		serarchParam += "" + MSFSharedUtils.allowNulls(PersonalUtil.getConvertDateToString(searchCertcIssDtE, "yyyyMMdd")) + "⊥";	//$6 발급 종료 일자
		serarchParam += "" + MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchCertcDivCd, "commCd")) + "⊥";		//$7 증명서 구분
		
		strParam = "" + serarchParam;
			
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
	}		
	
	
	

	private VerticalPanel vp;
	private FormPanel plFrmPsnl0500;
	private FormData formData;
	@SuppressWarnings("unused")
	private String txtForm = "";

	final TabPanel tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab

	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 공통 코드 가져오기
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add("A038"); //증명서구분
			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto,	new AsyncCallback<HashMap<String, List<BaseModel>>>() {
				@Override
				public void onSuccess(
						HashMap<String, List<BaseModel>> result) {
					if (result != null && result.size() > 0) {
						listStoreA038.add(result.get("A038"));
					}
				}

				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "공통코드 에러!", null);
				}

			});

			formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0410Form(); 	//화면 기본정보를 설정
			createSearchForm(); 	//검색필드를 적용
			createCheckBoxGrid(); 	//기본정보필드
			vp.setSize("1010px", "700px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.add(vp);

		}
		return panel;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Psnl0410() {
		setSize("1010px", "700px");
	}

	public Psnl0410(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0410Form() {
		
		plFrmPsnl0500 = new FormPanel();
		plFrmPsnl0500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 증명서발급대장"));
		plFrmPsnl0500.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0500.setBodyStyleName("pad-text");
		plFrmPsnl0500.setFrame(true);
		plFrmPsnl0500.setPadding(2);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("증명서발급대장","PSNL0410");
				}
			});
		plFrmPsnl0500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0500.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		srhSystemkey = new HiddenField<String>();
		srhSystemkey.setId("srhSystemkey");

		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button topBtn = new Button("조회");
		topBtn.setIcon(MSFMainApp.ICONS.search16());
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if(PersonalUtil.getDiffDateToDate(searchCertcIssDtS.getValue(),searchCertcIssDtE.getValue(),365)){
					psnl0410Loader.load();
				}else{
					MessageBox.info("", "발급기간이 1년이내에만 조회 가능합니다.", null);
				}
			}
		});
		buttonBar.add(topBtn);
		
		topBtn = new Button("인쇄");
		topBtn.setIcon(MSFMainApp.ICONS.print16());
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if(PersonalUtil.getDiffDateToDate(searchCertcIssDtS.getValue(),searchCertcIssDtE.getValue(),365)){
					psnl0410PrintButton();
				}else{
					MessageBox.info("", "발급기간이 1년이내에만 출력 가능합니다.", null);
				}
			}
		});
		buttonBar.add(topBtn);
		 
		plFrmPsnl0500.add(buttonBar);

		vp.add(plFrmPsnl0500);
		plFrmPsnl0500.setSize("990px", "690px");
	}

	
	// TODO 발급대상자 정보 시작
	private void createCheckBoxGrid() {
		
		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Psnl0410DTO> sm = new CheckBoxSelectionModel<Psnl0410DTO>();

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("hanNm");
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("deptCd");
		column.setHeaderText("소속");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig("hdofcCodtnCd", "재직상태", 80);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("issPrpseCtnt");
		column.setHeaderText("용 도");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(250);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("issNumCpis");
		column.setHeaderText("매수");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);

		configs.add(column);

		column = new ColumnConfig();
		column.setId("certcDivCd");
		column.setHeaderText("증명서구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);

		configs.add(column);

		column = new ColumnConfig();
		column.setId("prfIssNum");
		column.setHeaderText("발급번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);

		configs.add(column);

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.setFrame(true);
		cp.setIcon(MSFMainApp.ICONS.table());
		cp.setLayout(new FitLayout());
		cp.setSize(600, 300);

		psnl0410Grid = new Grid<Psnl0410DTO>(psnl0410Store, cm);
		psnl0410Grid.setStateId("psnl0410Grid");
		psnl0410Grid.setStateful(false);
		psnl0410Grid.setLoadMask(true); // 작업중표시
		psnl0410Grid.setBorders(true);
		psnl0410Grid.setSelectionModel(sm);
		psnl0410Grid.addPlugin(sm);
		psnl0410Grid.setColumnResize(true);
		psnl0410Grid.setAutoExpandColumn("prfIssNum");
		

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("발급대상자정보");

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
//		cpGrid.setSize(935, 480);
		cpGrid.setSize("945px", "500px");
		
		cpGrid.add(psnl0410Grid);
		lcStdGrid.add(cpGrid);
		fieldSet.add(lcStdGrid);

		plFrmPsnl0500.add(fieldSet);

	}

	
	// TODO 검색조건 시작
	private void createSearchForm() {
		formData = new FormData("100%");

		plFrmPsnl0500.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcSchCols = new LayoutContainer(new ColumnLayout());

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

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(85);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		frmlytSchRight.setDefaultWidth(100);
		lcSchRight.setLayout(frmlytSchRight);
		
		LayoutContainer lcSchLeft_1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcSch1_4_1 = new LayoutContainer();
		FormLayout frmlytSch1_4_1 = new FormLayout();
		frmlytSch1_4_1.setLabelWidth(85);
		frmlytSch1_4_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_4_1.setLayout(frmlytSch1_4_1);
		searchHanNm = new TextField<String>();
		searchHanNm.setFieldLabel("성 명");
		searchHanNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) { 
				searchHanNm.validate();
				if (MSFSharedUtils.allowNulls(searchHanNm.getValue()).trim().equals("")) {
					srhSystemkey.setValue("");
                    searchResnRegnNum.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					searchResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		});
		
//		searchHanNm.addKeyListener(new KeyListener() {
//			public void componentKeyUp(ComponentEvent event) {
//				super.componentKeyUp(event);
//                searchHanNm.validate();
//                
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                	srhSystemkey.setValue("");
//                	searchResnRegnNum.setValue(""); 
//                    fnPopupPsnl0100() ;
//                }
//			}
//		});
//		searchHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent be) {  
//				if (MSFSharedUtils.allowNulls(searchHanNm.getValue()).trim().equals("")) {
//				      srhSystemkey.setValue("");
//                    searchResnRegnNum.setValue("");
//				}
//			} 
//		}); 
		lcSch1_4_1.add(searchHanNm, new FormData("100%"));
		lcSchLeft_1.add(lcSch1_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		
		LayoutContainer lcSch1_4_2 = new LayoutContainer();
        Button btnHanNm = new Button("검색");
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
        	public void handleEvent(ButtonEvent e) {
                srhSystemkey.setValue("");
                searchResnRegnNum.setValue("");
                fnPopupPsnl0100() ;
            }
        });
        lcSch1_4_2.add(btnHanNm);
        lcSchLeft_1.add(lcSch1_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.08));
        
        LayoutContainer lcSch1_4_3 = new LayoutContainer();
		FormLayout frmlytSch1_4_3 = new FormLayout();
		frmlytSch1_4_3.setLabelWidth(0);
		frmlytSch1_4_3.setHideLabels(true);
		frmlytSch1_4_3.setLabelAlign(LabelAlign.LEFT);
		lcSch1_4_3.setLayout(frmlytSch1_4_3);
		searchResnRegnNum = new TextField<String>();
		searchResnRegnNum.setName("searchResnRegnNum");
		searchResnRegnNum.setLabelSeparator("");
		new TextFieldMask<String>(searchResnRegnNum, "999999-9999999");
		lcSch1_4_3.add(searchResnRegnNum, new FormData("90%"));
		lcSchLeft_1.add(lcSch1_4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		
//		LayoutContainer lcSchNm = new LayoutContainer();
//		FormLayout frmlytSchNm = new FormLayout();
//		frmlytSchNm.setLabelWidth(85);
//		frmlytSchNm.setLabelAlign(LabelAlign.RIGHT);
//		lcSchNm.setLayout(frmlytSchNm);
//		searchHanNm = new TextField<String>();
//		searchHanNm.setFieldLabel("성 명");
//		searchHanNm.setAllowBlank(false);
//		searchHanNm.addKeyListener(new KeyListener() {
//            public void componentKeyUp(ComponentEvent event) {
//                super.componentKeyUp(event);
//                searchHanNm.validate();
//                
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                    fnPopupPsnl0100() ;
//                }
//            }
//         });
//		lcSchNm.add(searchHanNm, new FormData("100%"));
//		
//		LayoutContainer lcSchJumin = new LayoutContainer();
//		FormLayout frmlytSchJumin= new FormLayout();
//		frmlytSchJumin.setLabelWidth(85);
//		frmlytSchJumin.setLabelAlign(LabelAlign.RIGHT);
//		lcSchJumin.setLayout(frmlytSchJumin);
//		
//		searchResnRegnNum = new TextField<String>();
//		searchResnRegnNum.setFieldLabel("주민등록번호");
//		new TextFieldMask<String>(searchResnRegnNum, "999999-9999999");
//		lcSchJumin.add(searchResnRegnNum, new FormData("74%"));
//		
//		lcSchLeft_1.add(lcSchNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
//		lcSchLeft_1.add(lcSchJumin, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		
		
		
		lcSchLeft.add(lcSchLeft_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		LayoutContainer lcSchLefts = new LayoutContainer();
		lcSchLefts.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytSchLefts = new FormLayout();
		frmlytSchLefts.setLabelWidth(85);
		frmlytSchLefts.setLabelAlign(LabelAlign.RIGHT);
		lcSchLefts.setLayout(frmlytSchLefts);

		LayoutContainer lcSchRights = new LayoutContainer();
		lcSchRights.setStyleAttribute("paddingRight", "80px");
		FormLayout frmlytSchRights = new FormLayout();
		frmlytSchRights.setLabelWidth(10);
		frmlytSchRights.setLabelAlign(LabelAlign.LEFT);
		lcSchRights.setLayout(frmlytSchRights);

		lcSchCols.add(lcSchLefts, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));
		lcSchCols.add(lcSchRights, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));

		searchCertcIssDtS = new DateField();
		searchCertcIssDtE = new DateField();
		
		Calendar  intiCal =  Calendar.getInstance(); 
		intiCal.setTime(new Date());
		searchCertcIssDtS.setValue(intiCal.getTime());
		
		
        new DateFieldMask(searchCertcIssDtS, "9999.99.99"); 
		searchCertcIssDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchCertcIssDtS.setFieldLabel("발급기간");
		searchCertcIssDtS.addListener(Events.Change, new Listener<FieldEvent>() {
			@Override
			public void handleEvent(FieldEvent be) {
				// TODO Auto-generated method stub
				
            	Calendar intiCal =  Calendar.getInstance(); 
        		intiCal.setTime(searchCertcIssDtS.getValue());
        		intiCal.add(Calendar.YEAR, +1);
        		intiCal.add(Calendar.DATE, -1);
        		
        		searchCertcIssDtE.setValue(intiCal.getTime());
			}
		});
		lcSchLefts.add(searchCertcIssDtS, formData);
		

		
//		searchCertcIssDtS.addListener(Events.Change, new Listener<FieldEvent>() {
////	        public void handleEvent(FieldEvent p_event) {
////	          Window.alert("change: " + p_event.value);
////	        }
//	      });
//		searchCertcIssDtS.addKeyListener(new KeyListener() {
//            public void componentKeyUp(ComponentEvent event) {
//                super.componentKeyUp(event);
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                	Calendar intiCal =  Calendar.getInstance(); 
//            		intiCal.setTime(new Date());
//            		intiCal.add(Calendar.YEAR, +1);
//            		intiCal.add(Calendar.DATE, -1);
//            		
//            		searchCertcIssDtE.setValue(intiCal.getTime());
//                }
//            }
//         });
		

//		searchCertcIssDtE = new DateField();
    	intiCal =  Calendar.getInstance(); 
		intiCal.setTime(new Date());
		intiCal.add(Calendar.YEAR, +1);
		intiCal.add(Calendar.DATE, -1);
		searchCertcIssDtE.setValue(intiCal.getTime());
		
		new DateFieldMask(searchCertcIssDtE, "9999.99.99"); 
		searchCertcIssDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchCertcIssDtE.setFieldLabel(" ~ ");
		searchCertcIssDtE.setLabelSeparator("");
		lcSchRights.add(searchCertcIssDtE, formData);

		lcSchLeft.add(lcSchCols, formData);
		
		// -- 
//		Calendar  intiCal =  Calendar.getInstance(); 
//		intiCal.setTime(new Date());
//		searchCertcIssDtS.setValue(intiCal.getTime());
//		
//		intiCal =  Calendar.getInstance(); 
//		intiCal.setTime(new Date());
//		intiCal.add(Calendar.YEAR, +1);
//		intiCal.add(Calendar.DATE, -1);
//		
//		searchCertcIssDtE.setValue(intiCal.getTime());
		// -- 

		searchCertcDivCd = new ComboBox<BaseModel>();
		searchCertcDivCd.setFieldLabel("증명서구분");
		searchCertcDivCd.setForceSelection(true);
		searchCertcDivCd.setMinChars(1);
		searchCertcDivCd.setDisplayField("commCdNm");
		searchCertcDivCd.setValueField("commCd");
		searchCertcDivCd.setTriggerAction(TriggerAction.ALL);
		searchCertcDivCd.setEmptyText("--증명서구분선택--");
		searchCertcDivCd.setSelectOnFocus(true);
		searchCertcDivCd.setStore(listStoreA038);
		
		lcSchRight.add(searchCertcDivCd, new FormData("70%"));

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));

		fieldSet.add(lcSchCol, formData);

		plFrmPsnl0500.add(fieldSet);
		// vp.add(panel);
	}
	
	
	private void psnl0410PrintButton () {
		Psnl0410Print("PSNLT0440", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
	};
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/	
	private void fnPopupPsnl0100() {
	       MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(searchHanNm.getRawValue());  //인사  
	       final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	      
	       popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("systemkey"))) { 
	                   //systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
	            	   srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
	            	   searchHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
	            	   searchResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
	               }  
	           }
	       });
	   }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/ 


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
