package com.app.smrmf.sysauth.system.client.form;

import java.util.HashMap;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.sysauth.system.client.form.defs.Sysm0900Def;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Sysm0900  extends MSFPanel { 
	
	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 시작} 
	 * #######################################################
	 */

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################
	 */

	private VerticalPanel vp;
	private FormPanel plFrmSysm0900;
	private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

	
	// -- 검색조건 
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분 
	private ComboBox<BaseModel> srhDataType; 				// 조회구분 
	
	
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsDataType 		= new ListStore<BaseModel>();	
	
	private SysIfBass0300DTO sysIfBass0300Dto; 		//공통코드 dto
	
	private Sysm0900Def sysm090001Def  = new Sysm0900Def("Psnl0100");   //그리드 테이블 컬럼 define  
	private MSFGridPanel sysm090001GridPanel;
	
	private Sysm0900Def sysm090002Def  = new Sysm0900Def("Psnl0115");   //그리드 테이블 컬럼 define  
	private MSFGridPanel sysm090002GridPanel;
	
	private FieldSet fieldSetGrd01 = new FieldSet();
	private FieldSet fieldSetGrd02 = new FieldSet();	
	
	private LayoutContainer lcStdGrid01 = new LayoutContainer();
	private LayoutContainer lcStdGrid02 = new LayoutContainer();
	
	private ContentPanel cpGrid01 = new ContentPanel();
	private ContentPanel cpGrid02 = new ContentPanel();
	  
 
	  
    public ContentPanel getViewPanel() {
        if (panel == null) {
        	
            panel = new ContentPanel();
           // panel.setLayout(new FitLayout());  
            panel.setBodyBorder(false);
            panel.setBorders(false);
            panel.setHeaderVisible(false);
            panel.setScrollMode(Scroll.AUTO); 
            
		    vp = new VerticalPanel();
		    vp.setSpacing(10);
		    createSysm0900Form();  	// 화면 기본정보를 설정
		    createSearchForm();    	// 검색필드를 적용
		    createListGrdForm();    // 그리드 
		    vp.setSize("1010px", "700px");
            
         
            panel.add(vp);
        }
        return panel;
    } 	    
 		  
	/**
	 * @wbp.parser.constructor
	 */
	public Sysm0900() {
		setSize("1010px", "700px");
	}

	public Sysm0900(String txtForm) {
		this.txtForm = txtForm;
	}
			  
	private void createSysm0900Form() {

		plFrmSysm0900 = new FormPanel();
		plFrmSysm0900.setHeadingText("ExTerms Ver1.0 - 메뉴권한그룹관리");
		plFrmSysm0900.setIcon(Resources.APP_ICONS.text());
		plFrmSysm0900.setBodyStyleName("pad-text");
		plFrmSysm0900.setFrame(true);
		plFrmSysm0900.setSize("990px", "690px");
		
		
		lsDataType = new ListStore<BaseModel>();
		BaseModel exlTypeBaseModel = new BaseModel();
		exlTypeBaseModel.set("commCd", "PSNL0100");
		exlTypeBaseModel.set("commCdNm", "인사 기본");
		
		lsDataType.add(exlTypeBaseModel);
		exlTypeBaseModel = new BaseModel();
		exlTypeBaseModel.set("commCd", "PSNL0115");
		exlTypeBaseModel.set("commCdNm", "인사 가족");
		lsDataType.add(exlTypeBaseModel);
		
		sysIfBass0300Dto = new SysIfBass0300DTO();
		// 고용구분
		sysIfBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = SysifComServiceUtils.getSingleBass0300ComboData(sysIfBass0300Dto);
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		Button topBtn = new Button("조회");
		topBtn.setIcon(Resources.APP_ICONS.search16());
		topBtn.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				reload();
			}
		});
		buttonBar.add(topBtn);

		Button topBtn2 = new Button("엑셀");
		topBtn2.setIcon(Resources.APP_ICONS.excel16());
		topBtn2.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				excelFileExport();
			}
		});
		buttonBar.add(topBtn2);
		plFrmSysm0900.add(buttonBar);

		vp.add(plFrmSysm0900);
		
	}
	
			    
	/**
	 * 그리드 설정
	 */
	private void createListGrdForm() {
				
		fieldSetGrd01 = new FieldSet();
		fieldSetGrd01.setHeadingHtml("대상자정보");
//		fieldSetGrd.setSize(950, 500);

		lcStdGrid01 = new LayoutContainer();
		lcStdGrid01.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid01.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid01.setLayout(frmlytStd);

		cpGrid01 = new ContentPanel();
		cpGrid01.setBodyBorder(false);
		cpGrid01.setHeaderVisible(false);
		cpGrid01.setLayout(new FitLayout());
		cpGrid01.setSize(935, 545);
//		lcStdGrid01.hide();

		sysm090001GridPanel = new MSFGridPanel(sysm090001Def, false, false, false, false, false);
		sysm090001GridPanel.setHeaderVisible(false);
		sysm090001GridPanel.setBodyBorder(true);
		sysm090001GridPanel.setBorders(true);
//		final Grid psnl0126Grid = psnl0100GridPanel.getMsfGrid().getGrid();
//		psnl0126Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
//			public void handleEvent(BaseEvent be) {
//				if (psnl0100GridPanel.getCurrentlySelectedItem() != null) {
//					setRecord(psnl0100GridPanel.getCurrentlySelectedItem());
//				}
//			}
//		});
		cpGrid01.add(sysm090001GridPanel);
		lcStdGrid01.add(cpGrid01);
		fieldSetGrd01.add(lcStdGrid01);
		plFrmSysm0900.add(fieldSetGrd01, new FormData("100%"));
		
		
		
		fieldSetGrd02 = new FieldSet();
		fieldSetGrd02.setHeadingHtml("대상자정보");
		
		lcStdGrid02 = new LayoutContainer();
		lcStdGrid02.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid02.setStyleAttribute("paddingRight", "5px");
		frmlytStd = new FormLayout();
		lcStdGrid02.setLayout(frmlytStd);
//		lcStdGrid02.hide();
		
		cpGrid02 = new ContentPanel();
		cpGrid02.setBodyBorder(false);
		cpGrid02.setHeaderVisible(false);
		cpGrid02.setLayout(new FitLayout());
		cpGrid02.setSize(935, 545);

//		sysm090002GridPanel = new MSFGridPanel(sysm090001Def, false, false, false, false, false);
//		sysm090002GridPanel.setHeaderVisible(false);
//		sysm090002GridPanel.setBodyBorder(true);
//		sysm090002GridPanel.setBorders(true);
////		final Grid psnl0126Grid = psnl0100GridPanel.getMsfGrid().getGrid();
////		psnl0126Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
////			public void handleEvent(BaseEvent be) {
////				if (psnl0100GridPanel.getCurrentlySelectedItem() != null) {
////					setRecord(psnl0100GridPanel.getCurrentlySelectedItem());
////				}
////			}
////		});
//		cpGrid02.add(sysm090002GridPanel);
		sysm090002GridPanel = new MSFGridPanel(sysm090002Def, false, false, false, false, false);
		sysm090002GridPanel.setHeaderVisible(false);
		sysm090002GridPanel.setBodyBorder(true);
		sysm090002GridPanel.setBorders(true);
//		final Grid psnl0126Grid = psnl0100GridPanel.getMsfGrid().getGrid();
//		psnl0126Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
//			public void handleEvent(BaseEvent be) {
//				if (psnl0100GridPanel.getCurrentlySelectedItem() != null) {
//					setRecord(psnl0100GridPanel.getCurrentlySelectedItem());
//				}
//			}
//		});
		cpGrid02.add(sysm090002GridPanel);
		lcStdGrid02.add(cpGrid02);
		
		
		fieldSetGrd02.add(lcStdGrid02);
		plFrmSysm0900.add(fieldSetGrd02, new FormData("100%"));
//		fieldSetGrd02.hide();

	}
	
	
	private void showType() {
		
		if("PSNL0100".equals(MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) 
				|| "PSNL0100" == MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) {
			fieldSetGrd01.show();
			fieldSetGrd02.hide();
		}else if("PSNL0115".equals(MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) 
				|| "PSNL0115" == MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) {
			fieldSetGrd01.hide();
			fieldSetGrd02.show();
		}
		
	}
	
	/** 그리드 조회**/
	public void reload() {
		// TODO Auto-generated method stub
		if("".equals(MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"))){
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "조회구분을 선택해 주세요.", null);
			return;
		} 
		
		
		if("PSNL0100".equals(MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) 
				|| "PSNL0100" == MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) {
			
			IColumnFilter filters = null;
			sysm090001GridPanel.getTableDef().setTableColumnFilters(filters);
			sysm090001GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			sysm090001GridPanel.getTableDef().addColumnFilter("dataType", MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			sysm090001GridPanel.reload();
			
		}else if("PSNL0115".equals(MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) 
				|| "PSNL0115" == MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd")) {
			IColumnFilter filters = null;
			sysm090002GridPanel.getTableDef().setTableColumnFilters(filters);
			sysm090002GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			sysm090002GridPanel.getTableDef().addColumnFilter("dataType", MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			sysm090002GridPanel.reload();
		}
		
	}
	
    private Sysm0900 getThis(){
        return this;
    } 
    
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {

		plFrmSysm0900.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		// fieldSet.setCheckboxToggle(false);
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);
		
		srhDataType =  new ComboBox<BaseModel>(); 
		srhDataType.setName("srhDataType");
		srhDataType.setForceSelection(true);
        srhDataType.setMinChars(1);
        srhDataType.setDisplayField("commCdNm");
        srhDataType.setValueField("commCd");
        srhDataType.setTriggerAction(TriggerAction.ALL);
        srhDataType.setEmptyText("--조회구분선택--");
        srhDataType.setSelectOnFocus(true); 
//        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());//TODO
//        srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        srhDataType.setStore(lsDataType);
        srhDataType.setFieldLabel("조회구분");
        srhDataType.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	        	showType();
	    	} 
		}); 
        srhDataType.setValue(lsDataType.getAt(0));
        lcSchLeft.add(srhDataType, new FormData("100%"));

        
		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(100);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);
		
		srhEmymtDivCd =  new ComboBox<BaseModel>(); 
        srhEmymtDivCd.setName("srhEmymtDivCd");
        srhEmymtDivCd.setForceSelection(true);
        srhEmymtDivCd.setMinChars(1);
        srhEmymtDivCd.setDisplayField("commCdNm");
        srhEmymtDivCd.setValueField("commCd");
        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
        srhEmymtDivCd.setEmptyText("--고용구분선택--");
        srhEmymtDivCd.setSelectOnFocus(true); 
//        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());//TODO
//        srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
        srhEmymtDivCd.setStore(lsEmymtDivCd);
        srhEmymtDivCd.setFieldLabel("고용구분");
        
        lcSchRight.add(srhEmymtDivCd, new FormData("100%"));


		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmSysm0900.add(fieldSet);
		// vp.add(panel);
	}
	
	/** 엑셀 저장 **/
	private void excelFileExport() {
	                     
		HashMap<String, String> param = new HashMap<String, String>(); 
	   
		param.put("dataType", MSFSharedUtils.getSelectedComboValue(srhDataType,"commCd"));				// 접속시작시간
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));				// 접속시작시간                
	                     
				           
		if("".equals(srhDataType)){
			MessageBox.info("", "구분은 필수입니다.", null);
			return;
		}else{ 
			sysm090001GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsSysm0900Export.do","extgwtFrame" ,param);  
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

}
