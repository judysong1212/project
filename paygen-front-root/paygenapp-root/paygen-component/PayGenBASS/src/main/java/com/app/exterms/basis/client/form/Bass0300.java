package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0300DTOMng;
import com.app.exterms.basis.client.service.Bass0300Service;
import com.app.exterms.basis.client.service.Bass0300ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Bass03000.java
 * @Description : 코드관리
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 **/

/** 
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Bass0300 extends MSFPanel {
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	private VerticalPanel vp;
	private FormPanel plFrmBassl0300;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;

	private FieldSet fldstNewFieldset;
	private ContentPanel cntntpnlNewContentpanel;
	private FormPanel frmpnlNewFormpanel;
	private TabPanel tabPanel;
	
	
	//-- 변수
	private Grid<Bass0300DTOMng> bass0300GridWork;
	private EditorGrid<Bass0300DTOMng> bass0300GridCode;
	private Grid<Bass0300DTOMng> bass0300GridCode2;
	private EditorGrid<Bass0300DTOMng> bass0300GridDtlCode;
	private ComboBox<BaseModel> comboBoxWorkList;
	
	// -- 서비스 시작
	private Bass0300ServiceAsync bass0300Service = Bass0300Service.Util.getInstance();
	
	
	//공통코드 업무리스트
	private RpcProxy<BaseListLoadResult<Bass0300DTOMng>> bass0300WorkProxy = new RpcProxy<BaseListLoadResult<Bass0300DTOMng>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Bass0300DTOMng>> callback) {
			bass0300Service.selectBass0300WorkList((BaseListLoadConfig) loadConfig, new Bass0300DTOMng(), callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<Bass0300DTOMng>> loaderBass0300Work =  new BaseListLoader<BaseListLoadResult<Bass0300DTOMng>>(bass0300WorkProxy);
	private ListStore<Bass0300DTOMng> storeBass0300Work = new ListStore<Bass0300DTOMng>(loaderBass0300Work);
	//공통코드 공통코드리스트
	private RpcProxy<BaseListLoadResult<Bass0300DTOMng>> bass0300CodeProxy = new RpcProxy<BaseListLoadResult<Bass0300DTOMng>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Bass0300DTOMng>> callback) {
			Bass0300DTOMng dto = new Bass0300DTOMng();
			dto.setRpsttvCd(bass0300GridWork.getSelectionModel().getSelectedItem().getDtlCd());
			bass0300Service.selectBass0300CodeList((BaseListLoadConfig) loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<Bass0300DTOMng>> loaderBass0300Code =  new BaseListLoader<BaseListLoadResult<Bass0300DTOMng>>(bass0300CodeProxy);
	private ListStore<Bass0300DTOMng> storeBass0300Code = new ListStore<Bass0300DTOMng>(loaderBass0300Code);
	//공통상세코드 공통코드리스트
	private RpcProxy<BaseListLoadResult<Bass0300DTOMng>> bass0300CodeProxy2 = new RpcProxy<BaseListLoadResult<Bass0300DTOMng>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Bass0300DTOMng>> callback) {
			Bass0300DTOMng dto = new Bass0300DTOMng();
			dto.setRpsttvCd(BasisUtil.getSelectedComboValue(comboBoxWorkList, "dtlCd"));
			bass0300Service.selectBass0300CodeList((BaseListLoadConfig) loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<Bass0300DTOMng>> loaderBass0300Code2 =  new BaseListLoader<BaseListLoadResult<Bass0300DTOMng>>(bass0300CodeProxy2);
	private ListStore<Bass0300DTOMng> storeBass0300Code2 = new ListStore<Bass0300DTOMng>(loaderBass0300Code2);
	//공통상세코드 공통상세코드
	private RpcProxy<BaseListLoadResult<Bass0300DTOMng>> bass0300DtlCodeProxy = new RpcProxy<BaseListLoadResult<Bass0300DTOMng>>() {
		@Override
		protected void load(Object loadConfig,AsyncCallback<BaseListLoadResult<Bass0300DTOMng>> callback) {
			Bass0300DTOMng dto = new Bass0300DTOMng();
			dto.setRpsttvCd(bass0300GridCode2.getSelectionModel().getSelectedItem().getDtlCd());
			bass0300Service.selectBass0300DtlCodeList((BaseListLoadConfig) loadConfig, dto, callback);
		}
	};
	private BaseListLoader<BaseListLoadResult<Bass0300DTOMng>> loaderBass0300DtlCode =  new BaseListLoader<BaseListLoadResult<Bass0300DTOMng>>(bass0300DtlCodeProxy);
	private ListStore<Bass0300DTOMng> storeBass0300DtlCode = new ListStore<Bass0300DTOMng>(loaderBass0300DtlCode);
	// -- 서비스 끝
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	
	public ContentPanel getViewPanel() {
		if (panel == null) {

			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createBass0300Form(); // 화면 기본정보를 설정
			createTabForm();

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
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 탭 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	private void createTabForm() {

		fldstNewFieldset = new FieldSet();

		cntntpnlNewContentpanel = new ContentPanel();
		// cntntpnlNewContentpanel.setHeadingText("New ContentPanel");
		cntntpnlNewContentpanel.setHeaderVisible(false);
		cntntpnlNewContentpanel.setCollapsible(false);

		frmpnlNewFormpanel = new FormPanel();
		// frmpnlNewFormpanel.setHeadingText("New FormPanel");
		frmpnlNewFormpanel.setCollapsible(false);
		frmpnlNewFormpanel.setHeaderVisible(false);
		frmpnlNewFormpanel.setBodyBorder(false);
		frmpnlNewFormpanel.setFrame(false);
		frmpnlNewFormpanel.setPadding(0);
		frmpnlNewFormpanel.setLayout(new FitLayout());

		tabPanel = new TabPanel();
		
		//TODO 탭클릭시....
		tabPanel.addListener(Events.Select, new Listener<TabPanelEvent>() {

			@Override
			public void handleEvent(TabPanelEvent be) {
				
				if("CODE".equals(tabPanel.getSelectedItem().getId())){
					loaderBass0300Work.load();
					bass0300GridCode.getStore().removeAll();
				}
				if("DTLCODE".equals(tabPanel.getSelectedItem().getId())){
					
					bass0300GridCode2.getStore().removeAll();
					bass0300GridDtlCode.getStore().removeAll();
					
					bass0300Service.getWorkList(new Bass0300DTOMng(),new AsyncCallback<List<BaseModel>>() {
						@Override
						public void onSuccess(List<BaseModel> result) {
							comboBoxWorkList.setValue(new BaseModel());
							comboBoxWorkList.getStore().removeAll();
							comboBoxWorkList.getStore().add(result);
						}
						@Override
						public void onFailure(Throwable caught) {
							caught.printStackTrace();
							MessageBox.info("콤보박스 에러", "콤보박스 실패!", null);
						}
					});
				}
			}
			
		});
		
		
		TabItem tbtmNewTabitem01 = new TabItem();
		tbtmNewTabitem01.setText("공통코드");
		tbtmNewTabitem01.setId("CODE");
		tbtmNewTabitem01.setStyleAttribute("padding", "10px");
		tbtmNewTabitem01.setLayout(new FormLayout());

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();

		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setSize("230px", "540px");
		fldstNewFieldset_1.setLayout(new FitLayout());
		fldstNewFieldset_1.add(createListGrid01Left(), new FormData("100%"));
		layoutContainer_1.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("업무리스트");
		fldstNewFieldset_1.setCollapsible(false);

		// createListGrid02();

		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FitLayout());

		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize("580px", "540px");
		fldstNewFieldset_2.setLayout(new FitLayout());
		fldstNewFieldset_2.add(createListGrid01Right(), new FormData("100%"));
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("공통코드");
		fldstNewFieldset_2.setCollapsible(false);

		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		layoutContainer_2.setBorders(false);

		tbtmNewTabitem01.add(layoutContainer, new FormData("100%"));
		layoutContainer.setBorders(false);

		tabPanel.add(tbtmNewTabitem01);
		tabPanel.setSize("1000px", "700px");
		TabItem tbtmNewTabitem02 = new TabItem();
		tbtmNewTabitem02.setId("DTLCODE");
		tbtmNewTabitem02.setText("공통상세코드");
		tbtmNewTabitem02.setStyleAttribute("padding", "10px");
		tbtmNewTabitem02.setLayout(new FormLayout());

		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer4 = new LayoutContainer();

		FieldSet fldstNewFieldset_1_2 = new FieldSet();
		fldstNewFieldset_1_2.setSize("230px", "540px");
		fldstNewFieldset_1_2.setLayout(new FitLayout());
		fldstNewFieldset_1_2.add(createListGrid02Left(), new FormData("100%"));
		layoutContainer4.add(fldstNewFieldset_1_2);
		fldstNewFieldset_1_2.setHeadingHtml("공통코드");
		fldstNewFieldset_1_2.setCollapsible(false);

		// createListGrid02();

		layoutContainer3.add(layoutContainer4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer4.setBorders(false);

		LayoutContainer layoutContainer5 = new LayoutContainer();
		layoutContainer5.setLayout(new FitLayout());

		FieldSet fldstNewFieldset_2_2 = new FieldSet();
		fldstNewFieldset_2_2.setSize("580px", "540px");
		fldstNewFieldset_2_2.setLayout(new FitLayout());
		fldstNewFieldset_2_2.add(createListGrid02Right(), new FormData("100%"));
		layoutContainer5.add(fldstNewFieldset_2_2);
		fldstNewFieldset_2_2.setHeadingHtml("공통상세코드");
		fldstNewFieldset_2_2.setCollapsible(false);

		layoutContainer3.add(layoutContainer5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		layoutContainer5.setBorders(false);

		tbtmNewTabitem02.add(layoutContainer3, new FormData("100%"));
		layoutContainer3.setBorders(false);

		tabPanel.add(tbtmNewTabitem02);

		fldstNewFieldset.add(tabPanel);
		fldstNewFieldset.setSize("590px", "600px");
		plFrmBassl0300.add(fldstNewFieldset, new FormData("100%"));
		fldstNewFieldset.setHeadingHtml("");
		fldstNewFieldset.setCollapsible(false);

	}
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 탭 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private LayoutContainer createListGrid02Right() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Bass0300DTOMng> sm = new CheckBoxSelectionModel<Bass0300DTOMng>();

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("rpsttvCd");
		column.setHeaderText("대표코드");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		
		TextField<String> dulText = new TextField<String>();
		CellEditor dulTextOnlyEditor = new CellEditor(dulText){  
			@Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return String.valueOf(value);  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          } 
	          
	          boolean chk = false;
	          
	          String v = "";
	          if(String.valueOf(value).length() > 4){
	        	  v = String.valueOf(value).substring(0, 4);
	          }else{
	        	  v = BasisUtil.LPAD(String.valueOf(value),4,"0");
	          }
	          
	          for(int i = 0; i < storeBass0300DtlCode.getCount(); i++){
	        	  if(v.equals(storeBass0300DtlCode.getAt(i).getDtlCd())){
	        		  chk = true;
	        	  }
	          }
	          if(chk){
	        	  MessageBox.info("", "세부코드가 중복됩니다.", null);
	        	  return "";
	          }else{
	        	  return v;
	        	   
	          }
	        }  
	    };
		
		column = new ColumnConfig();
		column.setId("dtlCd");
		column.setHeaderText("세부코드");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setEditor(dulTextOnlyEditor);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		

		column = new ColumnConfig("commCdNm", "코드명", 100);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("abbrNm");
		column.setHeaderText("약어명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("engNm");
		column.setHeaderText("영문명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem01");
		column.setHeaderText("항목01");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem02");
		column.setHeaderText("항목02");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem03");
		column.setHeaderText("항목03");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem04");
		column.setHeaderText("항목04");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem05");
		column.setHeaderText("항목05");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem06");
		column.setHeaderText("항목06");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem07");
		column.setHeaderText("항목07");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem08");
		column.setHeaderText("항목08");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem09");
		column.setHeaderText("항목09");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem10");
		column.setHeaderText("항목10");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem11");
		column.setHeaderText("항목11");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem12");
		column.setHeaderText("항목12");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem13");
		column.setHeaderText("항목13");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem14");
		column.setHeaderText("항목14");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem15");
		column.setHeaderText("항목15");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem16");
		column.setHeaderText("항목16");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem17");
		column.setHeaderText("항목17");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem18");
		column.setHeaderText("항목18");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem19");
		column.setHeaderText("항목19");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem20");
		column.setHeaderText("항목20");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		
		column = new ColumnConfig();
		column.setId("ord");
		column.setHeaderText("순서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		TextField<String> YNText = new TextField<String>();
		CellEditor YNTextOnlyEditor = new CellEditor(YNText){  
			@Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return String.valueOf(value);  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          } 
	          
	          if("y".equals(String.valueOf(value)) || "Y".equals(String.valueOf(value))
	        		  ||"n".equals(String.valueOf(value))||"N".equals(String.valueOf(value))	  
	        		  ){
	        	  return String.valueOf(value);
	          }else{
	        	  MessageBox.info("입력오류", " 'Y' 또는 'N' 만 입력하여주세요.", null);
	        	  return "";
	          }
	        }  
	    };
		
		column = new ColumnConfig();
		column.setId("opnYn");
		column.setHeaderText("오픈여부");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(YNTextOnlyEditor);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("useYn");
		column.setHeaderText("사용여부");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(YNTextOnlyEditor);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("note");
		column.setHeaderText("비고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(678, 503);
		
		bass0300GridDtlCode = new EditorGrid<Bass0300DTOMng>(storeBass0300DtlCode, cm);
		bass0300GridDtlCode.setStateful(true);
		bass0300GridDtlCode.setBorders(true);
		bass0300GridDtlCode.setColumnReordering(true);
		bass0300GridDtlCode.setLoadMask(true);
		bass0300GridDtlCode.setSelectionModel(sm);
		bass0300GridDtlCode.addPlugin(sm);
		
		cp01.add(bass0300GridDtlCode);
		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(bass0300GridCode2.getSelectionModel().getSelectedItem() == null){
					MessageBox.info("", "코드를 선택하여 주세요.", null);
				}else{
					Bass0300DTOMng tempData = new Bass0300DTOMng();
					
					//대표코드 세팅
					tempData.setRpsttvCd(bass0300GridCode2.getSelectionModel().getSelectedItem().getDtlCd());
					//세부코드 세팅
					//tempData.setDtlCd(BasisUtil.LPAD((storeBass0300DtlCode.getCount()+1)+"", 4, "0"));
					
					tempData.setOpnYn("Y");
					tempData.setUseYn("Y");
					tempData.setOrd((storeBass0300DtlCode.getCount()+1)+"");
					
					bass0300GridDtlCode.stopEditing();
					storeBass0300DtlCode.insert(tempData, 0);
					bass0300GridDtlCode.startEditing(storeBass0300DtlCode.indexOf(tempData), 3);
				}
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				final List<Bass0300DTOMng> changeDataList = new ArrayList<Bass0300DTOMng>();
				boolean chk = false;
				for(int i=0 ; i<storeBass0300DtlCode.getCount(); i++){
					if(storeBass0300DtlCode.getRecord(storeBass0300DtlCode.getAt(i)).isDirty()){ //변경된 정보가 있을경우
						if(storeBass0300DtlCode.getAt(i).getDtlCd() != null && !"".equals(storeBass0300DtlCode.getAt(i))){
							changeDataList.add(storeBass0300DtlCode.getAt(i));
						}else{
							chk = true;
						}
					}
				}
				if(chk){
					MessageBox.info("","세부코드를 확인하여주세요.",null);
				}else{
					if(changeDataList.size() > 0){
						MessageBox.confirm("", "공통코드를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
							@Override
							public void handleEvent(MessageBoxEvent be) {
								//if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){	
									bass0300Service.saveBass0300(changeDataList, new AsyncCallback<String>() {
											@Override
											public void onSuccess(String result) {
												MessageBox.info("저장완료", "공통코드("+result+")가 저장되었습니다.", null);
												loaderBass0300DtlCode.load();
											}
											@Override
											public void onFailure(Throwable caught) {
												MessageBox.info("저장실패", "공통코드 저장 실패!", null);
											}
									});
								}
							}
						});
					}
				}
				
			}
		}));

		cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(bass0300GridDtlCode.getSelectionModel().getSelectedItems().size() > 0){
					MessageBox.confirm("", "공통코드를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){	
								bass0300Service.deleteBass0300(bass0300GridDtlCode.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
									
									@Override
									public void onSuccess(Integer result) {
										MessageBox.info("삭제완료", "공통코드("+result+")가 삭제되었습니다.", null);
										loaderBass0300DtlCode.load();
									}
									
									@Override
									public void onFailure(Throwable caught) {
										MessageBox.info("삭제실패", "공통코드 삭제 실패!", null);
									}
								});
							}
						}
					});
				}
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	// TODO 공통 상세 코드 
	private LayoutContainer createListGrid02Left() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		ColumnConfig column = new ColumnConfig();
		column.setId("commCd");
		column.setHeaderText("코드");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("commCdNm");
		column.setHeaderText("코드명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		configs.add(column);

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(208, 503);

		bass0300GridCode2 = new Grid<Bass0300DTOMng>(storeBass0300Code2, cm);
		bass0300GridCode2.setStateful(true);
		bass0300GridCode2.setBorders(true);
		bass0300GridCode2.setColumnReordering(true);
		bass0300GridCode2.setLoadMask(true);
		bass0300GridCode2.addListener(Events.RowClick, new Listener<GridEvent<Bass0300DTOMng>>() {
			@Override
			public void handleEvent(GridEvent<Bass0300DTOMng> be) {
				loaderBass0300DtlCode.load();
			}
		});
		cp01.add(bass0300GridCode2);

		comboBoxWorkList = new ComboBox<BaseModel>();
		comboBoxWorkList.setForceSelection(true);
		comboBoxWorkList.setMinChars(1);
		comboBoxWorkList.setDisplayField("commCdNm");
		comboBoxWorkList.setValueField("commCd");
		comboBoxWorkList.setTriggerAction(TriggerAction.ALL);
		comboBoxWorkList.setEmptyText("--업무선택--");
		comboBoxWorkList.setSelectOnFocus(true);
		comboBoxWorkList.setStore(new ListStore<BaseModel>());
		comboBoxWorkList.setLabelSeparator("");
		comboBoxWorkList.setFieldLabel("");
		
		comboBoxWorkList.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				loaderBass0300Code2.load();
				storeBass0300DtlCode.removeAll();
			}
		});
		
		cp01.setTopComponent(comboBoxWorkList);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}

	
	// TODO 공통코드(공통코드)
	private LayoutContainer createListGrid01Right() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);
		
		final CheckBoxSelectionModel<Bass0300DTOMng> sm = new CheckBoxSelectionModel<Bass0300DTOMng>();
		
		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("rpsttvCd");
		column.setHeaderText("대표코드");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("dtlCd");
		column.setHeaderText("세부코드");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		

		column = new ColumnConfig("commCdNm", "코드명", 100);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("abbrNm");
		column.setHeaderText("약어명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("engNm");
		column.setHeaderText("영문명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem01");
		column.setHeaderText("항목01");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem02");
		column.setHeaderText("항목02");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem03");
		column.setHeaderText("항목03");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem04");
		column.setHeaderText("항목04");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem05");
		column.setHeaderText("항목05");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem06");
		column.setHeaderText("항목06");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem07");
		column.setHeaderText("항목07");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem08");
		column.setHeaderText("항목08");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem09");
		column.setHeaderText("항목09");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem10");
		column.setHeaderText("항목10");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem11");
		column.setHeaderText("항목11");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem12");
		column.setHeaderText("항목12");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem13");
		column.setHeaderText("항목13");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem14");
		column.setHeaderText("항목14");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem15");
		column.setHeaderText("항목15");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem16");
		column.setHeaderText("항목16");
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem17");
		column.setHeaderText("항목17");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem18");
		column.setHeaderText("항목18");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem19");
		column.setHeaderText("항목19");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("mangeItem20");
		column.setHeaderText("항목20");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		
		column = new ColumnConfig();
		column.setId("ord");
		column.setHeaderText("순서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		TextField<String> YNText = new TextField<String>();
		CellEditor YNTextOnlyEditor = new CellEditor(YNText){  
			@Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return String.valueOf(value);  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          } 
	          
	          if("y".equals(String.valueOf(value)) || "Y".equals(String.valueOf(value))
	        		  ||"n".equals(String.valueOf(value))||"N".equals(String.valueOf(value))	  
	        		  ){
	        	  return String.valueOf(value);
	          }else{
	        	  MessageBox.info("입력오류", " 'Y' 또는 'N' 만 입력하여주세요.", null);
	        	  return "";
	          }
	        }  
	    };
		
		column = new ColumnConfig();
		column.setId("opnYn");
		column.setHeaderText("오픈여부");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(YNTextOnlyEditor);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("useYn");
		column.setHeaderText("사용여부");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(YNTextOnlyEditor);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("note");
		column.setHeaderText("비고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(678, 503);

		bass0300GridCode = new EditorGrid<Bass0300DTOMng>(storeBass0300Code, cm);
		bass0300GridCode.setStateful(true);
		bass0300GridCode.setBorders(true);
		bass0300GridCode.setColumnReordering(true);
		bass0300GridCode.setLoadMask(true);
		bass0300GridCode.setSelectionModel(sm);
		bass0300GridCode.addPlugin(sm);

		cp01.add(bass0300GridCode);

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				if(bass0300GridWork.getSelectionModel().getSelectedItem() == null){
					MessageBox.info("", "업무를 선택하여 주세요.", null);
				}else{
					Bass0300DTOMng tempData = new Bass0300DTOMng();
					
					//대표코드 세팅
					tempData.setRpsttvCd(bass0300GridWork.getSelectionModel().getSelectedItem().getDtlCd());
					//세부코드 세팅
					tempData.setDtlCd(storeBass0300Code.getAt(0).getDtlCd() == null ? "A" : storeBass0300Code.getAt(0).getDtlCd().substring(0, 1)
							+ BasisUtil.LPAD((storeBass0300Code.getCount()+1)+"", 3, "0"));
					
					tempData.setOpnYn("Y");
					tempData.setUseYn("Y");
					tempData.setOrd((storeBass0300Code.getCount()+1)+"");
					
					
					bass0300GridCode.stopEditing();
					storeBass0300Code.insert(tempData, 0);
					bass0300GridCode.startEditing(storeBass0300Code.indexOf(tempData), 4);
				}
			}
		}));
		
		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				final List<Bass0300DTOMng> changeDataList = new ArrayList<Bass0300DTOMng>();
				for(int i=0 ; i<storeBass0300Code.getCount(); i++){
					if(storeBass0300Code.getRecord(storeBass0300Code.getAt(i)).isDirty()){ //변경된 정보가 있을경우
						changeDataList.add(storeBass0300Code.getAt(i));
					}
				}
				if(changeDataList.size() > 0){
					MessageBox.confirm("", "공통코드를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							// TODO 공통코드 저장 서비스 시작해야함.
								bass0300Service.saveBass0300(changeDataList, new AsyncCallback<String>() {
										@Override
										public void onSuccess(String result) {
											MessageBox.info("저장완료", "공통코드("+result+")가 저장되었습니다.", null);
											loaderBass0300Code.load();
										}
										@Override
										public void onFailure(Throwable caught) {
											MessageBox.info("저장실패", "공통코드 저장 실패!", null);
										}
								});
							}
						}
					});
				}
			}
		}));
		
		cp01.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(bass0300GridCode.getSelectionModel().getSelectedItems().size() > 0){
					MessageBox.confirm("", "공통코드를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								bass0300Service.deleteBass0300(bass0300GridCode.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>() {
									
									@Override
									public void onSuccess(Integer result) {
										MessageBox.info("삭제완료", "공통코드("+result+")가 삭제되었습니다.", null);
										loaderBass0300Code.load();
									}
									
									@Override
									public void onFailure(Throwable caught) {
										MessageBox.info("삭제실패", "공통코드 삭제 실패!", null);
									}
								});
							}
						}
					});
				}
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	// TODO 공통코드(업무리스트)
	private LayoutContainer createListGrid01Left() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		ColumnConfig column = new ColumnConfig();
		column.setId("commCd");
		column.setHeaderText("코드");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("commCdNm");
		column.setHeaderText("코드명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		configs.add(column);

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(208, 503);

		bass0300GridWork = new Grid<Bass0300DTOMng>(storeBass0300Work, cm);
		bass0300GridWork.setStateful(true);
		bass0300GridWork.setBorders(true);
		bass0300GridWork.setColumnReordering(true);
		bass0300GridWork.setLoadMask(true);
		
		bass0300GridWork.addListener(Events.Attach, new Listener<GridEvent<Bass0300DTOMng>>() {
			@Override
			public void handleEvent(GridEvent<Bass0300DTOMng> be) {
				loaderBass0300Work.load();
			}
		});
		bass0300GridWork.addListener(Events.RowClick, new Listener<GridEvent<Bass0300DTOMng>>() {
			@Override
			public void handleEvent(GridEvent<Bass0300DTOMng> be) {
				loaderBass0300Code.load();
			}
		});
		
		cp01.add(bass0300GridWork);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	
	public Bass0300() {
		setSize("1010px", "700px");
	}

	public Bass0300(String txtForm) {
		this.txtForm = txtForm;
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createBass0300Form() {

		plFrmBassl0300 = new FormPanel();
		plFrmBassl0300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 코드관리"));
		plFrmBassl0300.setIcon(Resources.APP_ICONS.text());
		plFrmBassl0300.setBodyStyleName("pad-text");
		plFrmBassl0300.setFrame(true);
		plFrmBassl0300.setLayout(new FormLayout());
		

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("코드관리","BASS0300");
				}
			});
		plFrmBassl0300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBassl0300.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/


		

		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		
		plFrmBassl0300.add(buttonBar);

		vp.add(plFrmBassl0300);
		plFrmBassl0300.setSize("990px", "680px");
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
	}-*/;
	
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
