package com.app.exterms.yearendtax.client.form.yeta2017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.dto.InfcPkgBass0150DTO;
import com.app.exterms.basis.client.dto.InfcPkgBass0500DTO;
import com.app.exterms.basis.client.form.defs.InfcPkgBass0150Def;
import com.app.exterms.basis.client.form.defs.InfcPkgBass0500Def;
import com.app.exterms.basis.client.service.InfcPkgBass0150Service;
import com.app.exterms.basis.client.service.InfcPkgBass0150ServiceAsync;
import com.app.exterms.basis.client.service.InfcPkgBass0500Service;
import com.app.exterms.basis.client.service.InfcPkgBass0500ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.form.defs.yeta2017.Yeta2070Def;
import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2070Service;
import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2070ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Yeta2070  extends MSFPanel { 

	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/


	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/
	private ActionDatabase actionDatabase;

	private VerticalPanel vp;
	private FormPanel plFrmYeta2070;
	private FormData formData; 
	private String txtForm = "";
	private XTemplate detailTp;	  
	private Yeta2070ServiceAsync Yeta2070service = Yeta2070Service.Util.getInstance(); 
	private InfcPkgBass0150ServiceAsync pkgBass0150Service = InfcPkgBass0150Service.Util.getInstance(); 
	private InfcPkgBass0500ServiceAsync pkgBass0500Service = InfcPkgBass0500Service.Util.getInstance(); 
	private Yeta2070Def yeta2070MSDef = new Yeta2070Def("yeta2070MS");
	private InfcPkgBass0150Def yeta2070ToBass0150Def = new InfcPkgBass0150Def("yeta2070ToBass0150");
	private InfcPkgBass0500Def yeta2070ToBass0500OnDef = new InfcPkgBass0500Def("YETA2070_BASS0500_ON");
	private InfcPkgBass0500Def yeta2070ToBass0500OffDef = new InfcPkgBass0500Def("YETA2070_BASS0500_OFF");

	private MSFGridPanel msfGridPanelYeta2070MS; 
	private MSFGridPanel msfGridPanelBass0150;
	private MSFGridPanel msfGridPanelBass0500On;
	private MSFGridPanel msfGridPanelBass0500Off;

	private Button saveButton;
	private Button btnSelectBass0500On;
	private Button btnSelectBass0500Off;
	private Button btnUnSelectBass0500On;
	private Button btnUnSelectBass0500Off;
	
	private TextField<String> srhOnDeptCd; 	//부서코드
	private TextField<String> srhOnDeptNm; 	//부서명
	private TextField<String> srhOffDeptCd; 	//부서코드
	private TextField<String> srhOffDeptNm; 	//부서명

	private String untDpobCd;
	private Iterator<Record> records;

	public ContentPanel getViewPanel() {
		if (panel == null) {        	

			vp = new VerticalPanel();
			vp.setSpacing(10);
			createSysm0500Form();  //화면 기본정보를 설정
			vp.setSize("1010px", "700px");   

			msfGridPanelYeta2070MS.reload();
			msfGridPanelBass0150.reload();

			//			final RelationDef  relBass0360 = new RelationDef(yeta2070MSDef,false);
			//			relBass0360.addJoinDef("utDpobCd", "utDpobCd"); 
			//			relBass0360.setLinkedObject(msfGridPanelYeta2070MS);
			//			yeta2070ToBass0500OnDef.addRelation(relBass0360); 
			//
			//			/**
			//			 * Create the relations 
			//			 */
			//			final RelationDef  relBass0350 = new RelationDef(yeta2070MSDef,false);
			//			relBass0350.addJoinDef("utDpobCd", "utDpobCd"); 
			//			relBass0350.setLinkedObject(msfGridPanelYeta2070MS);
			//			yeta2070ToBass0500OffDef.addRelation(relBass0350); 
			//
			//
			//			// DETAILS 
			//			final Grid yeta2070ToBass0500OffDefGrid = msfGridPanelYeta2070MS.getMsfGrid().getGrid();
			//			yeta2070ToBass0500OffDefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
			//				public void handleEvent(BaseEvent be) {  
			//					if (msfGridPanelYeta2070MS.getCurrentlySelectedItem() != null) {  
			//
			//						yeta2070ToBass0500OnDef.synchronizeGridDetail(
			//								msfGridPanelYeta2070MS.getCurrentlySelectedItem(),
			//								msfGridPanelBass0500On );
			//
			//						yeta2070ToBass0500OffDef.synchronizeGridDetail(
			//								msfGridPanelYeta2070MS.getCurrentlySelectedItem(),
			//								msfGridPanelBass0500Off ); 
			//					}
			//
			//				}
			//			});

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
	 * @wbp.parser.constructor
	 */
	public Yeta2070() {
		setSize("1010px", "700px");  
	} 

	public Yeta2070(String txtForm) {
		this.txtForm = txtForm;
	}		  

	private void createSysm0500Form() {

		plFrmYeta2070 = new FormPanel();
		plFrmYeta2070.setHeadingText("PayGen Ver1.0 - 단위사업장사업관리");
		plFrmYeta2070.setIcon(Resources.APP_ICONS.text());
		plFrmYeta2070.setBodyStyleName("pad-text");
		plFrmYeta2070.setFrame(true); 
		plFrmYeta2070.setPadding(2);
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   

		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//로그 뷰화면 호출 메서드 
				funcLogMessage("단위사업장사업관리","Yeta2070");
			}
		});
		plFrmYeta2070.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta2070.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/



		HorizontalPanel inner = new HorizontalPanel();
		inner.setBorders(false);
		inner.setLayout(new FitLayout());	
		inner.setStyleAttribute("paddingLeft", "5px");
		inner.setStyleAttribute("paddingTop", "5px");
		yeta2070MSDef.setReadOnly(true);   
		msfGridPanelYeta2070MS = new MSFGridPanel(yeta2070MSDef, false, false, false, false,false); 
		msfGridPanelYeta2070MS.setSize(350, 620);
		msfGridPanelYeta2070MS.setBorders(true);
		msfGridPanelYeta2070MS.getGrid().setBorders(true);
		Grid grid = msfGridPanelYeta2070MS.getMsfGrid().getGrid();
		grid.addListener(Events.CellDoubleClick , new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {

				untDpobCd = MSFSharedUtils.allowNulls(msfGridPanelYeta2070MS.getMsfGrid().getCurrentlySelectedItem().get("utDpobCd"));

				OnReload(untDpobCd);
				OffReload();
			}					
		});
		inner.add(msfGridPanelYeta2070MS);

		msfGridPanelBass0150 = new MSFGridPanel(yeta2070ToBass0150Def, false, false, false, false, false); 
		msfGridPanelBass0150.setSize(600, 200);
		msfGridPanelBass0150.setBorders(true);
		msfGridPanelBass0150.getGrid().setBorders(true);

		// 두번째 컨테이너컬럼(사용사업정보)   
		msfGridPanelBass0500On = new MSFGridPanel(yeta2070ToBass0500OnDef, false, false, false, false, false); 
		msfGridPanelBass0500On.setSize(600, 200);
		msfGridPanelBass0500On.setBorders(true);
		msfGridPanelBass0500On.getGrid().setBorders(true);

		final Grid<BaseModel> grid2 = msfGridPanelBass0500On.getMsfGrid().getGrid();
		final ColumnModel columnModel =  grid2.getColumnModel();
		final List<ColumnConfig> columnConfigs = columnModel.getColumns();
		final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 35); 
		check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());  
		grid2.addPlugin(check);
		grid2.getView().setForceFit(false);
		
		LayoutContainer  lycSreach = new LayoutContainer(); 
        FormLayout frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(0);  
 	    lycSreach.setLayout(frmlytStd);
 	    lycSreach.setHeight(30); 
	    
        LayoutContainer layoutContainer_1 = new LayoutContainer();
        layoutContainer_1.setLayout(new ColumnLayout());
        layoutContainer_1.setStyleAttribute("paddingTop", "5px");
        layoutContainer_1.setBorders(true);
 	    
		LayoutContainer layoutContainer_1_1 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1_1.setLayout(frmlytStd);

		srhOnDeptCd = new TextField<String>();
		srhOnDeptCd.setVisible(false);
		srhOnDeptCd.setName("srhOnDeptCd");
		plFrmYeta2070.add(srhOnDeptCd);
        
        srhOnDeptNm = new TextField<String>();
        srhOnDeptNm.setFieldLabel("부서명");
        srhOnDeptNm.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				if (MSFSharedUtils.allowNulls(srhOnDeptNm.getValue()).trim().equals("")) {
        			srhOnDeptCd.setValue(""); 
        		}
        		if (MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(srhOnDeptNm.getValue()))) {
        			srhOnDeptCd.setValue(""); 
        		} 
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			srhOnDeptCd.setValue(""); 
        			fnPopupCommP150_Off(srhOnDeptNm.getValue()); 
        		}
        		super.componentKeyDown(event);
			}
		});

		layoutContainer_1_1.add(srhOnDeptNm, new FormData("100%"));
		layoutContainer_1_1.setBorders(false);

		Button btnUsrSearch2 = new Button("검색");
		btnUsrSearch2.setIcon(MSFMainApp.ICONS.search());
		btnUsrSearch2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				if (MSFSharedUtils.allowNulls(srhOnDeptNm.getValue()).trim().equals("")) {
					srhOnDeptCd.setValue(""); 
       		 	}
				if(msfGridPanelYeta2070MS.getCurrentlySelectedItem() == null)
				{
					MessageBox.info("경고", "단위사업장을 선택해 주세요.", null);
					return;
				}
				fnPopupCommP150_On(srhOnDeptNm.getValue()); 
			}
		});

		layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.add(btnUsrSearch2);
		lycSreach.add(layoutContainer_1);		     	     
		msfGridPanelBass0500On.setTopComponent(lycSreach);


		// 세번째 컨테이너컬럼(미사용사업정보)  
		msfGridPanelBass0500Off = new MSFGridPanel(yeta2070ToBass0500OffDef, false, false, false, false,false); 
		msfGridPanelBass0500Off.setSize(600, 200);
		msfGridPanelBass0500Off.setBorders(true);
		msfGridPanelBass0500Off.getGrid().setBorders(true);

		final Grid<BaseModel> grid3 = msfGridPanelBass0500Off.getMsfGrid().getGrid();
		final ColumnModel columnModel3 =  grid3.getColumnModel();
		List<ColumnConfig> columnConfigs3 = columnModel3.getColumns();
		final CheckColumnConfig check3 = new CheckColumnConfig("select", "선택", 35); 
		check3.setAlignment(Style.HorizontalAlignment.CENTER);
		check3.setEditor(columnConfigs3.get(0).getEditor());         
		columnConfigs3.set(0, check3);

		check3.setRenderer(columnConfigs3.get(0).getRenderer());  
		grid3.addPlugin(check3);
		grid3.getView().setForceFit(false);
		
		LayoutContainer  lycSreach2 = new LayoutContainer(); 
        frmlytStd = new FormLayout();  
        frmlytStd.setLabelWidth(0);  
        lycSreach2.setLayout(frmlytStd);
        lycSreach2.setHeight(30); 
	    
        LayoutContainer layoutContainer_2 = new LayoutContainer();
        layoutContainer_2.setLayout(new ColumnLayout());
        layoutContainer_2.setStyleAttribute("paddingTop", "5px");
        layoutContainer_2.setBorders(true);
 	    
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(70); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_1.setLayout(frmlytStd);

		srhOffDeptCd = new TextField<String>();
		srhOffDeptCd.setVisible(false);
		srhOffDeptCd.setName("srhOffDeptCd");
		plFrmYeta2070.add(srhOffDeptCd);
        
        srhOffDeptNm = new TextField<String>();
        srhOffDeptNm.setFieldLabel("부서명");
        srhOffDeptNm.addKeyListener(new KeyListener() {
        	public void componentKeyDown(ComponentEvent event) {
        		if (MSFSharedUtils.allowNulls(srhOffDeptNm.getValue()).trim().equals("")) {
        			srhOffDeptCd.setValue(""); 
        		}
        		if (MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(srhOffDeptNm.getValue()))) {
        			srhOffDeptCd.setValue(""); 
        		} 
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			srhOffDeptCd.setValue(""); 
        			fnPopupCommP150_Off(srhOffDeptNm.getValue()); 
        		}
        		super.componentKeyDown(event);
        	}
		});
        
		layoutContainer_2_1.add(srhOffDeptNm, new FormData("100%"));
		layoutContainer_2_1.setBorders(false);

		Button btnUsrSearch = new Button("검색");
		btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
		btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				if (MSFSharedUtils.allowNulls(srhOffDeptNm.getValue()).trim().equals("")) {
					srhOffDeptCd.setValue(""); 
       		 	}
				fnPopupCommP150_Off(srhOffDeptNm.getValue());
			}
		});

		layoutContainer_2.add(layoutContainer_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.add(btnUsrSearch);
		lycSreach2.add(layoutContainer_2);		     	     
		msfGridPanelBass0500Off.setTopComponent(lycSreach2);

		ToolBar bottomToolbar1 = new ToolBar();  
		bottomToolbar1.add(new FillToolItem());
		// ================전체선택버튼=========================
		saveButton = new Button("저장");
		saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("", "선택된 단위기관을 수정 하시겠습니까?<br>",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

							records = msfGridPanelBass0150.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
							InfcPkgBass0150DTO pkgBass0150Dto = new InfcPkgBass0150DTO();
							List<InfcPkgBass0150DTO> listPkgBass0150Dto = new ArrayList<InfcPkgBass0150DTO>();      

							if (MSFSharedUtils.paramNotNull(records)) {   

								while (records.hasNext()) {

									Record record = (Record) records.next(); 
									BaseModel bmMapModel = (BaseModel)record.getModel();

									// select에 null값이 들어가있으므로 널포인트에러뜸.
									// 그래서 null인것은 false로 강제변환시킴.

									pkgBass0150Dto = new InfcPkgBass0150DTO();

									pkgBass0150Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payrMangDeptCd")));
									pkgBass0150Dto.setUntDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("untDpobNm$utDpobCd")));

									listPkgBass0150Dto.add(pkgBass0150Dto);
								}
							}   


							if(listPkgBass0150Dto.size() <= 0 ) {
								MessageBox.info("경고", "단위기관을 선택해 주세요.", null);
								return;
							}

							pkgBass0150Service.yeta2070ToBass0150Update(listPkgBass0150Dto, actionDatabase, new AsyncCallback<Long>() {
								@Override
								public void onSuccess(Long result) {
									MessageBox.info("완료", "저장이 완료되었습니다.", null);
									msfGridPanelBass0150.reload();
								}

								@Override
								public void onFailure(Throwable caught) {
									caught.printStackTrace();
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
											MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta2060("+ actionDatabase.name()+ ") : "+ caught),null);
								}
							});

						}
					}
				});

			}  
		});

		bottomToolbar1.add(saveButton);
		bottomToolbar1.add(new SeparatorMenuItem());

		Button refresh1 = new Button();
		refresh1.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				msfGridPanelBass0150.reload();	                	
			}  
		});		            
		bottomToolbar1.add(refresh1);

		//툴바메뉴
		ToolBar bottomToolbar2 = new ToolBar();  
		bottomToolbar2.add(new FillToolItem());

		// 첫번째 사용직종정보 툴바
		// ================전체선택버튼=========================
		btnSelectBass0500On = new Button("전체선택");
		btnSelectBass0500On.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 

				int  lsCnt = msfGridPanelBass0500On.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					msfGridPanelBass0500On.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					msfGridPanelBass0500On.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				msfGridPanelBass0500On.getMsfGrid().getGrid().getView().refresh(true);
			}
		});


		bottomToolbar2.add(btnSelectBass0500On);
		bottomToolbar2.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnSelectBass0500On = new Button("전체해제");
		btnUnSelectBass0500On.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = msfGridPanelBass0500On.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					msfGridPanelBass0500On.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					msfGridPanelBass0500On.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				msfGridPanelBass0500On.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar2.add(btnUnSelectBass0500On);
		bottomToolbar2.add(new SeparatorMenuItem());
		//====================================================

		saveButton = new Button("미사용");
		saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {   

			public void componentSelected(ButtonEvent ce) {  
				InfcPkgBass0500DTO pkgBass0500Dto = new InfcPkgBass0500DTO();
				List<InfcPkgBass0500DTO> listPkgBass0500Dto = new ArrayList<InfcPkgBass0500DTO>();

				Iterator<BaseModel> itBm  = msfGridPanelBass0500On.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec  = new ArrayList<Record>();
				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				}  
				Iterator<Record> iterRecords = lsRec.iterator();

				while (iterRecords.hasNext()) {	    		            	  
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel)recData.getModel();		    		             

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if((Boolean)bmMapModel.get("select")==null){
						bmMapModel.set("select", false);
					}		    		              

					if ((Boolean)bmMapModel.get("select")) {
						pkgBass0500Dto = new InfcPkgBass0500DTO();

						pkgBass0500Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));
						pkgBass0500Dto.setUntDpobCd(MSFSharedUtils.allowNulls(msfGridPanelYeta2070MS.getMsfGrid().getCurrentlySelectedItem().get("utDpobCd")));

						listPkgBass0500Dto.add(pkgBass0500Dto);
					}
				} 		

				if(listPkgBass0500Dto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 소득공제를 선택해 주세요.", null);
					return;
				}
				actionDatabase = ActionDatabase.UPDATE;
				pkgBass0500Service.yeta2070ToBass0500OffUpdate(listPkgBass0500Dto, actionDatabase, new AsyncCallback<Long>() {

					@Override
					public void onSuccess(Long result) {
						// TODO Auto-generated method stub
						MessageBox.info("완료", "저장이 완료되었습니다.", null);
						msfGridPanelBass0500On.reload();
						msfGridPanelBass0500Off.reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"저장을 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}		                
		});
		bottomToolbar2.add(saveButton);
		bottomToolbar2.add(new SeparatorMenuItem());

		Button refresh2 = new Button();
		refresh2.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(msfGridPanelYeta2070MS.getCurrentlySelectedItem() == null)
				{
					MessageBox.info("경고", "단위사업장을 선택해 주세요.", null);
					return;
				}
				OnReload();
			}  
		});		            
		bottomToolbar2.add(refresh2);



		// 두번째 미사용직종정보 툴바 		            
		ToolBar bottomToolbar3 = new ToolBar();  
		bottomToolbar3.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnSelectBass0500Off = new Button("전체선택");
		btnSelectBass0500Off.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {

				int  lsCnt = msfGridPanelBass0500Off.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					msfGridPanelBass0500Off.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					msfGridPanelBass0500Off.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				msfGridPanelBass0500Off.getMsfGrid().getGrid().getView().refresh(true);

			}  
		});

		bottomToolbar3.add(btnSelectBass0500Off);
		bottomToolbar3.add(new SeparatorMenuItem());
		//====================================================

		// ================전체해제버튼=========================
		btnUnSelectBass0500Off  = new Button("전체해제");
		btnUnSelectBass0500Off.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = msfGridPanelBass0500Off.getMsfGrid().getGrid().getStore().getCount();

				for(int iCnt=0;iCnt < lsCnt;iCnt++) {

					msfGridPanelBass0500Off.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					msfGridPanelBass0500Off.getMsfGrid().getGrid().getStore().commitChanges();

				} 
				msfGridPanelBass0500Off.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar3.add(btnUnSelectBass0500Off);
		bottomToolbar3.add(new SeparatorMenuItem());
		//====================================================

		saveButton = new Button("사용");
		saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				InfcPkgBass0500DTO pkgBass0500Dto = new InfcPkgBass0500DTO();
				List<InfcPkgBass0500DTO> listPkgBass0500Dto = new ArrayList<InfcPkgBass0500DTO>();

				Iterator<BaseModel> itBm  = msfGridPanelBass0500Off.getMsfGrid().getGrid().getStore().getModels().listIterator();  //.getSelectionModel().getSelectedItems().listIterator();
				List<Record> lsRec  = new ArrayList<Record>();
				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				}  
				Iterator<Record> iterRecords = lsRec.iterator();

				while (iterRecords.hasNext()) {	    		            	  
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel)recData.getModel();		    		             

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if((Boolean)bmMapModel.get("select")==null){
						bmMapModel.set("select", false);
					}		    		              

					if ((Boolean)bmMapModel.get("select")) {
						pkgBass0500Dto = new InfcPkgBass0500DTO();

						pkgBass0500Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));
						pkgBass0500Dto.setUntDpobCd(MSFSharedUtils.allowNulls(msfGridPanelYeta2070MS.getMsfGrid().getCurrentlySelectedItem().get("utDpobCd")));

						listPkgBass0500Dto.add(pkgBass0500Dto);
					}
				} 		

				if(listPkgBass0500Dto.size() <= 0 ) {
					MessageBox.info("경고", "적용할 사업을 선택해 주세요.", null);
					return;
				}
				actionDatabase = ActionDatabase.UPDATE;
				pkgBass0500Service.yeta2070ToBass0500OnUpdate(listPkgBass0500Dto, actionDatabase, new AsyncCallback<Long>() {

					@Override
					public void onSuccess(Long result) {
						// TODO Auto-generated method stub
						MessageBox.info("완료", "저장이 완료되었습니다.", null);
						msfGridPanelBass0500On.reload();
						msfGridPanelBass0500Off.reload();
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
								"저장을 실패하였습니다. </br> 오류를 확인해주세요. " + caught, null);
					}
				});
			}						
		});

		bottomToolbar3.add(saveButton);
		bottomToolbar3.add(new SeparatorMenuItem());


		Button refresh3 = new Button();
		refresh3.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh3.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
				OffReload();
			}  
		});		            
		bottomToolbar3.add(refresh3);

		//툴바 넣어주는것
		msfGridPanelBass0150.setBottomComponent(bottomToolbar1);
		msfGridPanelBass0500On.setBottomComponent(bottomToolbar2);
		msfGridPanelBass0500Off.setBottomComponent(bottomToolbar3);

		// 중간사이 틈을 주기위한 컨테이너
		LayoutContainer space = new LayoutContainer();
		space.setHeight(10);
		space.setWidth(500);
		space.setId("space");
		space.setStyleAttribute("paddingLeft", "10px");

		LayoutContainer space2 = new LayoutContainer();
		space2.setHeight(10);
		space2.setWidth(500);
		space2.setId("space2");
		space2.setStyleAttribute("paddingLeft", "10px");

		LayoutContainer layoutContainer_16 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytStd);	
		layoutContainer_16.add(msfGridPanelBass0150);
		layoutContainer_16.add(space);
		layoutContainer_16.add(msfGridPanelBass0500On);
		layoutContainer_16.add(space2);
		layoutContainer_16.add(msfGridPanelBass0500Off);
		//
		inner.add(layoutContainer_16);		            

		plFrmYeta2070.add(inner);

		vp.add(plFrmYeta2070);
		plFrmYeta2070.setSize("990px", "680px");
	}	

	private Yeta2070 getThis(){
		return this;
	}

	public void OnReload(String untDpobCd) {
		IColumnFilter filters = null;

		msfGridPanelBass0500On.getTableDef().setTableColumnFilters(filters);
		msfGridPanelBass0500On.getTableDef().addColumnFilter("utDpobCd",MSFSharedUtils.allowNulls(untDpobCd), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanelBass0500On.reload();

	}

	private void fnPopupCommP150_On(String deptCd) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨. 
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
           
		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
          
		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("deptCd"))) {  
					srhOnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
					srhOnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 

				}
				IColumnFilter filters = null;

        		msfGridPanelBass0500On.getTableDef().setTableColumnFilters(filters);
        		Window.alert(""+srhOnDeptCd.getValue());
        		Window.alert(""+untDpobCd);
        		msfGridPanelBass0500On.getTableDef().addColumnFilter("utDpobCd",MSFSharedUtils.allowNulls(untDpobCd), SimpleColumnFilter.OPERATOR_LIKE);
        		msfGridPanelBass0500On.getTableDef().addColumnFilter("deptCd",MSFSharedUtils.allowNulls(srhOnDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
        		msfGridPanelBass0500On.reload();
			}
		});
	}	
	
	private void fnPopupCommP150_Off(String deptCd) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨. 
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
		
		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
		
		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("deptCd"))) {  
					srhOffDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
					srhOffDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
					
				}
				IColumnFilter filters = null;

        		msfGridPanelBass0500Off.getTableDef().setTableColumnFilters(filters);
        		msfGridPanelBass0500Off.getTableDef().addColumnFilter("deptCd",MSFSharedUtils.allowNulls(srhOffDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
        		msfGridPanelBass0500Off.reload();
			}
		});
	}	

	public void OnReload() {
		IColumnFilter filters = null;

		msfGridPanelBass0500On.getTableDef().setTableColumnFilters(filters);
		msfGridPanelBass0500On.getTableDef().addColumnFilter("utDpobCd",MSFSharedUtils.allowNulls(untDpobCd), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanelBass0500On.getTableDef().addColumnFilter("deptCd",MSFSharedUtils.allowNulls(srhOnDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		msfGridPanelBass0500On.reload();
	}
	
	public void OffReload() {
		IColumnFilter filters = null;

		msfGridPanelBass0500Off.getTableDef().setTableColumnFilters(filters);
		msfGridPanelBass0500Off.getTableDef().addColumnFilter("utDpobCd",MSFSharedUtils.allowNulls(untDpobCd), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanelBass0500Off.getTableDef().addColumnFilter("deptCd",MSFSharedUtils.allowNulls(srhOnDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		msfGridPanelBass0500Off.reload();

	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
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
