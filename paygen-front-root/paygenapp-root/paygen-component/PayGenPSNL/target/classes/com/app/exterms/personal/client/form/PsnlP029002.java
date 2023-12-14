/**
 * 신규고용일괄등록
 */
package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.PsnlP029002DTO;
import com.app.exterms.personal.client.form.defs.Psnl0126Def;
import com.app.exterms.personal.client.service.PsnlP029002Service;
import com.app.exterms.personal.client.service.PsnlP029002ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
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
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class PsnlP029002 extends MSFFormPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	private FormPanel cpPsnlP029002;

	private PsnlP029002ServiceAsync psnlP029002Service = PsnlP029002Service.Util.getInstance();

	// -------------- grid 선언 시작 ---------------
	private Psnl0126Def psnl0126Def  = new Psnl0126Def("PSNLP029002");   //그리드 테이블 컬럼 define  
	private MSFGridPanel psnlP0126GridPanel;
	// -------------- grid 선언 종료 ---------------	

	// -------------- 휴가일수 생성 폼 시작 --------------
	private ComboBox<BaseModel> creYear;        				//작업년도
	private CheckBox creHodyFixYn;								//확정여부

	// -------------- 휴가일수 생성 폼 종료 --------------

	// -------------- DTO 선언 시작 --------------
	private SysCoCalendarDTO  msfCoCalendarDto;  
	private PsnlP029002DTO psnlP029002Dto;
	// -------------- DTO 선언 종료 --------------

	// --------------------------------------------------------------------------------------
	private ListStore<BaseModel> lscrPayYr				= new ListStore<BaseModel>();	//년도 
	// -------------- store 선언 종료  ---------------
	private FileUploadField psnlP029002flUp; 									//파일업로드처리 부분  
	private Boolean picBoolFile;
	private HiddenField<String> fileKeyCode;			// 업로드를 위해 추가
	private String filePathStr;
	private static EditorGrid<PsnlP029002DTO> excelGrid;
	private List<PsnlP029002DTO> psnlP029002List = new ArrayList<PsnlP029002DTO>();
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 상태처리 전역변수 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * ^^^^^^^^^^^^
	 */

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 화면 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	public FormBinding formBinding;

	public PsnlP029002(final ActionDatabase actionDatabase,	final MSFPanel caller) {

		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		this.setBorders(false);
		this.setAutoHeight(true);
		
		

		cpPsnlP029002 = new FormPanel();
		
		fileKeyCode = new HiddenField<String>();
		fileKeyCode.setName("fileKeyCode");
		cpPsnlP029002.add(fileKeyCode);
		
		createForm();
		createStandardForm();

		cpPsnlP029002.setBodyBorder(false);
		cpPsnlP029002.setBorders(false);
		cpPsnlP029002.setHeaderVisible(false);
		cpPsnlP029002.setSize("770px", "590px");

		this.add(cpPsnlP029002);
		formBinding = new FormBinding(this, true);

		this.setSize("800px", "600px");
	}

	/**
	 * 휴가 일수 생성
	 */
	private void createForm() {


		msfCoCalendarDto = new SysCoCalendarDTO();

		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lscrPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 

		FieldSet fldstNewFieldset = new FieldSet(); 
		fldstNewFieldset.setHeadingHtml("휴가일수-생성");

		LayoutContainer lcSchCol = new LayoutContainer(new ColumnLayout());	

		LayoutContainer lcSchCol01 = new LayoutContainer();		
		FormLayout frmlytSch = new FormLayout(); 
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);

		creYear = new ComboBox<BaseModel>();
		creYear.setName("creYear");
		creYear.setFieldLabel("적용년도");
		creYear.setForceSelection(true);
		creYear.setMinChars(1);
		creYear.setDisplayField("yearDisp");
		creYear.setValueField("year");
		creYear.setTriggerAction(TriggerAction.ALL);
		creYear.setEmptyText("--년도--");
		creYear.setSelectOnFocus(true);
		creYear.setStore(lscrPayYr);
		creYear.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {   
				creYear.setValue(lscrPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
			}
		});		
		lcSchCol01.add(creYear, new FormData("100%"));	

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout()); 

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2.setLayout(frmlytSch);

		psnlP029002flUp = new FileUploadField();
		psnlP029002flUp.setName("psnlP029002flUp");
		psnlP029002flUp.setFieldLabel("휴가일수");
		psnlP029002flUp.setValidator(new Validator() {  
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
		psnlP029002flUp.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
				excelGrid.getStore().removeAll();
			}
	    });

		layoutContainer_2.add(psnlP029002flUp, new FormData("100%"));
		

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

		Button btnDlgn0250Save = new Button("일수업로드");
		layoutContainer_4.add(btnDlgn0250Save, new FormData("100%"));
		btnDlgn0250Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
						xlsImportData(); 
			}
		});
		layoutContainer_1.add(layoutContainer_4, new FormData("100%"));
		layoutContainer_4.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_1.add(layoutContainer_3, new FormData("100%"));
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");

		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(100); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);

		Button btnPsnl0290down = new Button("양식다운로드");
		btnPsnl0290down.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
						xlsExportData();
									}
		}); 

		layoutContainer_3.add(btnPsnl0290down, new FormData("100%"));
		layoutContainer_3.setBorders(false);
		
		LayoutContainer lcSchCol02= new LayoutContainer();		
		lcSchCol02.setStyleAttribute("text-align","right");
		LabelField lblfldNewLabelfield = new LabelField("※ 산정결과가 입력되지 않는 경우 업로드를 재시도 해주시기 바랍니다.");
		lblfldNewLabelfield.setStyleAttribute("color","#ff0055");
		lcSchCol02.add(lblfldNewLabelfield, new FormData("100%"));

		lcSchCol.add(lcSchCol01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		fldstNewFieldset.add(lcSchCol,new FormData("100%"));
		fldstNewFieldset.add(layoutContainer_1,new FormData("100%"));

		cpPsnlP029002.add(fldstNewFieldset);  
//		cpPsnlP029002.add(createMsfGridForm(),new FormData("100%") );
	}

//	private LayoutContainer createMsfGridForm() {
//		// private void createMsfGridForm() {
//
//		FieldSet fldstNewFieldset2 = new FieldSet();		
//		fldstNewFieldset2.setHeadingHtml("산정결과");	
//
//		LayoutContainer layoutContainer2_1 = new LayoutContainer();
//		FormLayout frmlytStd = new FormLayout();
//		frmlytStd.setLabelWidth(0);
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
//		layoutContainer2_1.setLayout(frmlytStd);		
//		layoutContainer2_1.setBorders(false);
//
//		ContentPanel cpGridPsnlP029001 = new ContentPanel();
//		cpGridPsnlP029001.setBodyBorder(false);
//		cpGridPsnlP029001.setHeaderVisible(false);
//		cpGridPsnlP029001.setLayout(new FitLayout());
//		cpGridPsnlP029001.setSize(735, 425);
//
////		psnlP0126GridPanel = new MSFGridPanel(psnl0126Def, false, false, false, false);
////		psnlP0126GridPanel.setBorders(false);
////		psnlP0126GridPanel.setBodyBorder(true);
////		psnlP0126GridPanel.setHeaderVisible(false);
////		psnlP0126GridPanel.getBottomComponent().setVisible(false);
//
////		cpGridPsnlP029001.add(psnlP0126GridPanel);
//		cpGridPsnlP029001.add(psnlModiListInfo());
//
//		layoutContainer2_1.add(cpGridPsnlP029001);
//
//		fldstNewFieldset2.add(layoutContainer2_1, new FormData("100%"));
//
//		return fldstNewFieldset2;
//	}
	
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
		fldstNewFieldset_1.setHeadingHtml("산정결과");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.add(psnlModiListInfo(), new FormData("100%"));

//		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		
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
		
		layoutContainer_3.add(btnBar);

		layoutContainer.add(layoutContainer_3);
		 

		cpPsnlP029002.add(layoutContainer);
		layoutContainer.setBorders(false);

	}
	
	/** 고용일괄데이터 그리드**/
	private LayoutContainer psnlModiListInfo() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(735, 425);
		cp01.setScrollMode(Scroll.AUTO);  
		
	    //그리드 작업
	    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
	    
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setId("dateChk");
		checkColumn.setHeaderText("선택");
		checkColumn.setWidth(35);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    checkColumn.setFixed(true);
	    columns.add(checkColumn);
	    
	    ColumnConfig column = new ColumnConfig();
		column.setId("hodyApptnYr");
		column.setHeaderText("년도");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(50);
		column.setMenuDisabled(true);
		column.setSortable(false);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("deptNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("부서");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("hanNm");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
//		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("resnRegnGbn");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("주민등록구분");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(130);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("yoobhMnthDay");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("생년월일");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(130);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
//		
		column = new ColumnConfig();
		column.setId("hodyApptnNumDys");
		column.setEditor(new CellEditor(new TextField<Double>()));
		column.setHeaderText("기본");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
//		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("spclHodyNumDys");
		column.setEditor(new CellEditor(new TextField<Double>()));
		column.setHeaderText("특별");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
//		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("hodyUseNumDys");
		column.setEditor(new CellEditor(new TextField<Double>()));
		column.setHeaderText("휴가");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
//		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("spclHodyUseDys");
		column.setEditor(new CellEditor(new TextField<Double>()));
		column.setHeaderText("특별휴가");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
//		column.setHidden(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("hodyRstNumDys");
		column.setEditor(new CellEditor(new TextField<Double>()));
		column.setHeaderText("잔여일수");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("hodyNoteCtnt");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("비고내용");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(110);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		column = new ColumnConfig();
		column.setId("hodyNumDysUseYn");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setHeaderText("존재여부");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(80);
		column.setSortable(false);
//		column.setHidden(true);
		column.setMenuDisabled(true);
		columns.add(column);
		
		ColumnModel cm = new ColumnModel(columns);
		excelGrid = new EditorGrid<PsnlP029002DTO>(new ListStore<PsnlP029002DTO>(), cm);
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
		
		excelGrid.getColumnModel().addHeaderGroup(0, 6, new HeaderGroupConfig("휴가일수", 1, 2));
		excelGrid.getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("사용일수", 1, 2));
		  
		excelGrid.setView(view);  

		cp01.add(excelGrid);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	//일수업로드
	private void xlsImportData() { 
		String flUpNm = MSFSharedUtils.allowNulls(psnlP029002flUp.getValue());
	  	
  		if (flUpNm.length() == 0) {
  			Window.alert("선택된 파일이 없습니다.");
    	} else {
    		flUpNm = flUpNm.substring(flUpNm.lastIndexOf("\\")+1);
    		int pos = flUpNm.lastIndexOf(".");		// 기존파일명에서 확장자의 위치를 가져온다.
    		flUpNm = flUpNm.substring(pos + 1);												// 확장자만 잘라서 당아줌.
    		
    		final String filename = MSFMainApp.get().getUser().getUsrId() + "_" + DateTimeFormat.getFormat("yyyyMMddhhmiss").format(new Date()) + "." + flUpNm;
    		fileKeyCode.setValue(filename);
    		
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
//                        psnlP029002flUp.reset();
                    }
                }
            };
            
            cpPsnlP029002.setAction(GWT.getHostPageBaseURL() + "upload/XlsFileUpload.do"); 
            cpPsnlP029002.setEncoding(Encoding.MULTIPART);
            cpPsnlP029002.setMethod(Method.POST);
            cpPsnlP029002.submit();
            cpPsnlP029002.onFrameLoad(); 
            picBoolFile = true;
            t.scheduleRepeating(5000);
            
            cpPsnlP029002.addListener(Events.Submit, new Listener<FormEvent>() {
	              public void handleEvent(final FormEvent evt) {  
//	                  plFrmPsnl0100.unmask(); 
	                  if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                	  
	                	  filePathStr = "";
	                	  
	              		// 데이터 업로드
	                	  psnlP029002Service.getPsnlP029002ExcelData(filename, new AsyncCallback<List<HashMap<String,String>>>() {

	          				@Override
	          				public void onFailure(Throwable caught) {
//	          					cpPsnl0200.unmask();
	          					tracker.setStatus(true);
	          					evt.setResultHtml("");  
	          					// TODO Auto-generated method stub
	          					MessageBox.alert("", "Excel파일이 아니거나 데이터에 형식이 잘못되었습니다. " + caught, null);
	          				}

	          				@Override
	          				public void onSuccess(List<HashMap<String, String>> result) {
	          					// TODO Auto-generated method stub
	          					if(result.size() > 0){
	          						excelGrid.getStore().removeAll();
	          						//Info.display("REMOVE = excelGrid.getStore().getCount()", excelGrid.getStore().getCount()+"");
	          						excelGrid.stopEditing(false);
//	          						box.close();
	          						
	          						psnlP029002List = new ArrayList<PsnlP029002DTO>();
	          						
	          						for(int i = 0; i < result.size(); i++){
	          							psnlP029002Dto = new PsnlP029002DTO();
	          							
	          							psnlP029002Dto.setDateChk(true);
	          							psnlP029002Dto.setSystemkey(result.get(i).get("systemkey"));
	          							psnlP029002Dto.setHodyApptnYr(result.get(i).get("hodyApptnYr"));
	          							psnlP029002Dto.setDeptNm(result.get(i).get("currAffnDeptNm"));
	          							psnlP029002Dto.setHanNm(result.get(i).get("hanNm"));
	          							psnlP029002Dto.setYoobhMnthDay(result.get(i).get("yoobhMnthDay"));
	          							psnlP029002Dto.setResnRegnGbn(result.get(i).get("resnRegnGbn"));
	          							psnlP029002Dto.setResnRegnNum(result.get(i).get("resnRegnNum"));
	          							psnlP029002Dto.setHodyApptnNumDys(Double.valueOf(result.get(i).get("hodyApptnNumDys")).doubleValue());
	          							psnlP029002Dto.setSpclHodyNumDys(Double.valueOf(result.get(i).get("spclHodyNumDys")).doubleValue());
	          							psnlP029002Dto.setHodyUseNumDys(Double.valueOf(result.get(i).get("hodyUseNumDys")).doubleValue());
	          							psnlP029002Dto.setSpclHodyUseDys(Double.valueOf(result.get(i).get("spclHodyUseDys")).doubleValue());
	          							psnlP029002Dto.setHodyRstNumDys(Double.valueOf(result.get(i).get("hodyRstNumDys")).doubleValue());	
	          							psnlP029002Dto.setHodyNumDysUseYn(result.get(i).get("hodyNumDysUseYn"));
	          							psnlP029002Dto.setHodyNoteCtnt(result.get(i).get("hodyNoteCtnt"));
	          							
	          							psnlP029002List.add(psnlP029002Dto);	          							
	          							
	          							filePathStr = MSFSharedUtils.allowNulls(result.get(i).get("filaPath"));
	          							
	          							excelGrid.getStore().insert(psnlP029002Dto, i);
	          						}
	          						
	          						excelGrid.getStore().commitChanges();
	          						tracker.setStatus(true);	        						
	        	              		picBoolFile = false;        	              		
	        	              		evt.setResultHtml("");  

	          					}
	          					
	          				}
	          			}); 
	                	  
                            
	                  } else {
	                      //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
	                	  tracker.setStatus(true);
	                      evt.setResultHtml("");
	                  }
	              };
            });
    	}  		
	}
	
	//급여일괄조정 업로드
	private void xlsSaveData() {

		String filename = MSFSharedUtils.allowNulls(psnlP029002flUp.getValue());
		if (filename.length() == 0) {
			Window.alert("선택된 파일이 없습니다.");
		} else {

			MessageBox.confirm("일수 생성", "휴가일수를 생성하시겠습니까?<br>(등록되어있는 일수가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {

					ArrayList<PsnlP029002DTO> insertPsnlP029002List = new ArrayList<PsnlP029002DTO>();
					for ( int i = 0; i < excelGrid.getStore().getCount(); i++){
						insertPsnlP029002List.add(excelGrid.getStore().getAt(i));
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
								psnlP029002flUp.reset();
								excelGrid.getStore().removeAll();
							}
						}
					};
					t2.scheduleRepeating(500);

					psnlP029002Service.updateXlsPsnl0126ToP029002(insertPsnlP029002List, new AsyncCallback<Long>() {
						@Override
						public void onSuccess(Long result) {
							// TODO Auto-generated method stub
							
							if(0L== result){
								tracker.setStatus(true);
								MessageBox.info("저장실패", "저장에 실패 하였습니다. \n 데이터를 확인해주세요.", null);
							}else{
								tracker.setStatus(true);
								excelGrid.getStore().removeAll();
								excelGrid.stopEditing(false);
								MessageBox.info("저장완료", "정상적으로 저장되었습니다.", null);
							}
						}
						@Override
						public void onFailure(Throwable caught) {
							tracker.setStatus(true);
							// TODO Auto-generated method stub
							MessageBox.info("저장실패", "휴가 일괄등록 저장이 실패 하였습니다.  \n <엑셀에 입력한 정보의 이상유무를 확인해주세요.(ex: 주민등록번호)>", null);
						}
					}); 
				}
			});
		}    	
	}

	//엑셀 양식 저장
	private void xlsExportData() {

		HashMap<String, String> param = new HashMap<String, String>(); 
		
//		psnlP0126GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPsnl0290Export.do","extgwtFrame" ,param);  
		
		GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "exp/XlsPsnl0290Export.do", "extgwtFrame", JsUtil.toJavaScriptObject(param)); 
	}	

	public void reload() {

	}
	
	class Tracker 
	{
		public boolean status = false;
		public boolean getStatus(){return status;}
		public void setStatus(boolean stat){status = stat;}
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
}
