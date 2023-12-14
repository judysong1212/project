package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr4700DTO;
import com.app.exterms.payroll.client.service.Payr4700Service;
import com.app.exterms.payroll.client.service.Payr4700ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Payr4700 extends MSFPanel {

	/**
	 * ###################################################### { 시스템 기본설정파일 선언부
	 * 시작} #######################################################
	 */

	// 검색조건
	private TextField<String> searchHanNm; // 성명
	private TextField<String> searchResnRegnNum; // 주민번호
	private DateField searchIssAppyDtS; // 발급기간 시작일자
	private DateField searchIssAppyDtE; // 발급기간 종료일자
	//private ComboBox<BaseModel> searchCertcDivCd; // 증명서 구분
	private ComboBox<BaseModel> searchIssCodtnDivCd; //증명서 발급구분

	private ListStore<BaseModel> listStoreA038 = new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA039 = new ListStore<BaseModel>();

	// 공통코드 호출
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();

	private Grid<Payr4700DTO> payr4700Grid; 
	
	private Payr4700ServiceAsync payr4700Service = Payr4700Service.Util.getInstance();
	
	private RpcProxy<BaseListLoadResult<Payr4700DTO>> payr4700Proxy = new RpcProxy<BaseListLoadResult<Payr4700DTO>>() {

		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Payr4700DTO>> callback) {
			
			Payr4700DTO dto = new Payr4700DTO();
			dto.setHanNm(searchHanNm.getValue());
			dto.setResnRegnNum(searchResnRegnNum.getValue());
			dto.setSearchIssAppyDtS(PayrUtils.getConvertDateToString(searchIssAppyDtS, "yyyyMMdd"));
			dto.setSearchIssAppyDtE(PayrUtils.getConvertDateToString(searchIssAppyDtE, "yyyyMMdd"));
			//dto.setCertcDivCd(PayrUtils.getSelectedComboValue(searchCertcDivCd, "commCd"));
			dto.setIssCodtnDivCd(PayrUtils.getSelectedComboValue(searchIssCodtnDivCd, "commCd"));
			
			try{
				payr4700Service.selectPayr4700((BaseListLoadConfig) loadConfig,	dto, callback);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> payr4700Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(payr4700Proxy);
	private ListStore<Payr4700DTO> payr4700Store = new ListStore<Payr4700DTO>(payr4700Loader);
	
	
	/**
	 * ###################################################### { 시스템 기본설정파일 선언부
	 * 종료} #######################################################
	 */

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
			arrRpsttvCd.add("A039"); //발급구분
			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto,	new AsyncCallback<HashMap<String, List<BaseModel>>>() {
				@Override
				public void onSuccess(
						HashMap<String, List<BaseModel>> result) {
					if (result != null && result.size() > 0) {
						listStoreA038.add(result.get("A038"));
						listStoreA039.add(result.get("A039"));
						if(listStoreA039.getCount()>0){
							searchIssCodtnDivCd.setValue(listStoreA039.getAt(0));
							payr4700Loader.load();
						}
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
			createPsnl0100Form(); // 화면 기본정보를 설정
			createSearchForm(); // 검색필드를 적용
			createCheckBoxGrid(); // 기본정보필드
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
	public Payr4700() {
		setSize("1010px", "700px");
	}

	public Payr4700(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0100Form() {

		plFrmPsnl0500 = new FormPanel();
		plFrmPsnl0500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 원천징수영수증발급승인"));
		plFrmPsnl0500.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0500.setBodyStyleName("pad-text");
		plFrmPsnl0500.setPadding(2);
		plFrmPsnl0500.setFrame(true);

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("원천징수영수증발급승인","PAYR4700");
				}
			});
		plFrmPsnl0500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0500.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button topBtn = new Button("조회");
		topBtn.setIcon(MSFMainApp.ICONS.search16());
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				payr4700Loader.load();
			}
		});
		buttonBar.add(topBtn);

		topBtn = new Button("일괄승인");
		topBtn.setIcon(MSFMainApp.ICONS.confirm());
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if(payr4700Grid.getStore() != null && payr4700Grid.getStore().getCount() > 0){
					
					MessageBox.confirm("원천징수영수증발급일괄승인", "조회하신 모든 인원을 발급승인 처리하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								List<Payr4700DTO> list = new ArrayList<Payr4700DTO>();
								for(int i = 0; i < payr4700Grid.getStore().getCount(); i++){
									list.add(payr4700Grid.getStore().getAt(i));
								}
								payr4700Service.updateIssueOk(list, new AsyncCallback<Integer>() {
									@Override
									public void onSuccess(Integer result) {
										if(result > 0){
											MessageBox.info("성공!", result+"명 승인처리 되었습니다.", null);
											payr4700Loader.load();
										}
									}
									@Override
									public void onFailure(Throwable caught) {
										caught.printStackTrace();
										MessageBox.info("실패", "승인이 실패되었습니다.", null);
									}
								});
							}
						}
						
					});
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

		//final CheckBoxSelectionModel<Payr4700DTO> sm = new CheckBoxSelectionModel<Payr4700DTO>();
		//configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("confirmYn");
		column.setHeaderText("승인");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setRenderer(new GridCellRenderer<Payr4700DTO>() {

			@Override
			public Object render(Payr4700DTO model, String property,
					ColumnData config, final int rowIndex, int colIndex,
					final ListStore<Payr4700DTO> store, Grid<Payr4700DTO> grid) {
				
				if("Y".equals(store.getAt(rowIndex).getConfirmYn())){
					Button b = new Button("승인", new SelectionListener<ButtonEvent>() {
						@Override
						public void componentSelected(ButtonEvent ce) {
							MessageBox.confirm("원천징수영수증 발급승인", store.getAt(rowIndex).getHanNm()+"님의 원천징수영수증 발급을 승인하시겠습니까?",new Listener<MessageBoxEvent>(){
								@Override
								public void handleEvent(MessageBoxEvent be) {
									//if("Yes".equals(be.getButtonClicked().getText())){
									if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
										List<Payr4700DTO> list = new ArrayList<Payr4700DTO>();
										list.add(store.getAt(rowIndex));
										payr4700Service.updateIssueOk(list, new AsyncCallback<Integer>() {
											@Override
											public void onSuccess(Integer result) {
												if(result > 0){
													MessageBox.info("성공!", "승인처리 되었습니다.", null);
													payr4700Loader.load();
												}
											}
											@Override
											public void onFailure(Throwable caught) {
												caught.printStackTrace();
												MessageBox.info("실패", "승인이 실패되었습니다.", null);
											}
										});
									}
								}
							});
						}
					});
					b.setWidth(grid.getColumnModel().getColumnWidth(colIndex)-10);
					b.setHeight(19);
					return b;
				}else{
					return "";
				}
				
				
			}
			
		});
		column.setSortable(false);
		column.setMenuDisabled(true);
		
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("hanNm");
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("deptCd");
		column.setHeaderText("부서");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(200);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
/*
		column = new ColumnConfig("hdofcCodtnCd", "재직상태", 80);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
*/
		column = new ColumnConfig("whdgTxIssAppyDt", "신청일자", 100);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("whdgTxIssPrpseCtnt");
		column.setHeaderText("용 도");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(250);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("whdgTxIssNumCpis");
		column.setHeaderText("매수");
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setWidth(50);

		configs.add(column);
/*
		column = new ColumnConfig();
		column.setId("certcDivCd");
		column.setHeaderText("증명서구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);

		configs.add(column);
*/	
		column = new ColumnConfig();
		column.setId("whdgTxIssCodTNDivCd");
		column.setHeaderText("발급구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("whdgTxIssNum");
		column.setHeaderText("발급번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);

		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("whdgTxIssDt");
		column.setHeaderText("발급일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		
		
		configs.add(column);

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.setFrame(true);
		cp.setIcon(MSFMainApp.ICONS.table());
		cp.setLayout(new FitLayout());
		cp.setSize(625, 400);

		payr4700Grid = new Grid<Payr4700DTO>(payr4700Store, cm);
		payr4700Grid.setStateId("payr4700Grid");
		payr4700Grid.setStateful(false);
		payr4700Grid.setLoadMask(true); // 작업중표시
		payr4700Grid.setBorders(true);
		//payr4700Grid.setSelectionModel(sm);
		//payr4700Grid.addPlugin(sm);
		payr4700Grid.setColumnResize(true);
		//payr4700Grid.setAutoExpandColumn("issPrpseCtnt");
		

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("발급대상자정보");
		fieldSet.setStyleAttribute("marginTop", "10px");
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
		cpGrid.setSize(935, 500);
		

		cpGrid.add(payr4700Grid);
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
		FormLayout frmlytSchLeft = new FormLayout();
		frmlytSchLeft.setLabelWidth(85);
		frmlytSchLeft.setLabelAlign(LabelAlign.RIGHT);
		frmlytSchLeft.setDefaultWidth(100);
		lcSchLeft.setLayout(frmlytSchLeft);

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(85);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		frmlytSchRight.setDefaultWidth(100);
		lcSchRight.setLayout(frmlytSchRight);
		
		
		searchHanNm = new TextField<String>();
		searchHanNm.setName("searchHanNm");
		searchHanNm.setFieldLabel("성 명");
		searchHanNm.setAllowBlank(false);
		lcSchLeft.add(searchHanNm, new FormData("50%"));

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

		lcSchCols.add(lcSchLefts,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));
		lcSchCols.add(lcSchRights,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));

		searchIssAppyDtS = new DateField();
		searchIssAppyDtS.setName("searchIssAppyDtS");
		searchIssAppyDtS.setFieldLabel("신청기간");
		searchIssAppyDtS.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		searchIssAppyDtS.setValue(new Date());
		lcSchLefts.add(searchIssAppyDtS, formData);

		searchIssAppyDtE = new DateField();
		searchIssAppyDtE.setName("searchIssAppyDtE");
		searchIssAppyDtE.setFieldLabel(" ~ ");
		searchIssAppyDtE.setLabelSeparator("");
		searchIssAppyDtE.setValue(new Date());
		searchIssAppyDtE.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		lcSchRights.add(searchIssAppyDtE, formData);

		lcSchLeft.add(lcSchCols, formData);

		searchResnRegnNum = new TextField<String>();
		searchResnRegnNum.setName("searchResnRegnNum");
		searchResnRegnNum.setFieldLabel("주민등록번호");
		lcSchRight.add(searchResnRegnNum, new FormData("70%"));
		/*
		LayoutContainer lcSchRights2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcSchRights2_2 = new LayoutContainer();
		FormLayout frmlytSchRights_1 = new FormLayout();
		frmlytSchRights_1.setLabelWidth(85);
		frmlytSchRights_1.setLabelAlign(LabelAlign.LEFT);
		lcSchRights2_2.setLayout(frmlytSchRights_1);
		
		
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
		
		lcSchRights2_2.add(searchCertcDivCd, new FormData("100%"));
		
		LayoutContainer lcSchRights2_3 = new LayoutContainer();
		FormLayout frmlytSchRights_2 = new FormLayout();
		frmlytSchRights_2.setLabelWidth(85);
		frmlytSchRights_2.setLabelAlign(LabelAlign.LEFT);
		lcSchRights2_3.setLayout(frmlytSchRights_2);
		*/
		searchIssCodtnDivCd = new ComboBox<BaseModel>();
		searchIssCodtnDivCd.setName("searchIssCodtnDivCd");
		searchIssCodtnDivCd.setFieldLabel("발급구분");
		searchIssCodtnDivCd.setForceSelection(true);
		searchIssCodtnDivCd.setMinChars(1);
		searchIssCodtnDivCd.setDisplayField("commCdNm");
		searchIssCodtnDivCd.setValueField("commCd");
		searchIssCodtnDivCd.setTriggerAction(TriggerAction.ALL);
		searchIssCodtnDivCd.setEmptyText("--발급구분선택--");
		searchIssCodtnDivCd.setSelectOnFocus(true);
		searchIssCodtnDivCd.setEditable(false);
		searchIssCodtnDivCd.setStore(listStoreA039);
		/*		
		lcSchRights2_3.add(searchIssCodtnDivCd, new FormData("100%"));
		
		lcSchRights2.add(lcSchRights2_2,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));
		lcSchRights2.add(lcSchRights2_3,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));
		*/
		lcSchRight.add(searchIssCodtnDivCd, new FormData("70%"));

		lcSchCol.add(lcSchLeft,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5d));

		fieldSet.add(lcSchCol, formData);

		plFrmPsnl0500.add(fieldSet);
		// vp.add(panel);
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
