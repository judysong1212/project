package com.app.exterms.payroll.client.form;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.exterms.payroll.client.form.defs.Payr0415Def;
import com.app.exterms.payroll.client.lookup.LookupPayr0415PayYr;
import com.app.exterms.payroll.client.service.Payr1500Service;
import com.app.exterms.payroll.client.service.Payr1500ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
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
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PayrP150001  extends MSFFormPanel { 

	private ContentPanel payrP150001;
	private MSFPanel caller;

	private Payr0415Def pPayr1500Def  = new Payr0415Def("PAYRP150001");   //그리드 테이블 컬럼 define
	private MSFGridPanel pPayr150001GridPanel;

	private ComboBox<BaseModel> createYr;	/** column 생성년도 : payYr */ 
	private ComboBox<BaseModel> targetYr;	/** column 생성년도 : payYr */ 
	public static Button btnUsrSearch;
	private SysCoCalendarDTO msfCoCalendarDto;
	public FormBinding formBinding;

	private ListStore<BaseModel> lsYrStore = new ListStore<BaseModel>();
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();
	 private LookupPayr0415PayYr lkApptnYr = new LookupPayr0415PayYr();  
     private MSFGridPanel payYrGridPanel;
     
     
     
     private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	private void setPayrP150001FormBinding() {
	}        

	private Payr1500ServiceAsync payr1500Service = Payr1500Service.Util.getInstance();	 
	
	
	
	public PayrP150001(ActionDatabase actionDatabase, MSFPanel caller) {
		//super();

		this.setBodyBorder(false);
		this.setHeaderVisible(false);

		this.actionDatabase = actionDatabase;
		this.caller = caller;

		payrP150001 = new ContentPanel();
		createPayrP150001Form();
		createSearchForm();
		createStandardForm();

		payrP150001.setBodyBorder(false);
		payrP150001.setBorders(false);
		payrP150001.setHeaderVisible(false);

		this.add(payrP150001);
		formBinding = new FormBinding(this, true);
		this.setSize("600px", "400px");  //setSize("790px", "610px");  

		formBinding = new FormBinding(this, true);

	}
	private  void createPayrP150001Form() { 
		payrP150001.setSize("600px", "400px");
	}
	
	final Timer tmMask = new Timer()
    {
          public void run()
          {
             // if (maskTracker)
             // { 
       	   if (lsPayYrStore.getCount() > 0 ) {
       		   
	           	    cancel();
	               	unmask(); 
	               	//authExecEnabled() ;
	                maskTracker  = true;
	        	
	        	   } else {
	        		   tmMask.scheduleRepeating(2000);
	        	   }
             // }
          }
    }; 

	private  void createSearchForm() {

		 
		 ContentPanel payYrGrid = new ContentPanel();  
         payYrGrid.setVisible(false);
         
         //년도 콤보처리 
        payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
        payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
                public void handleEvent(ComponentEvent be) {  
                  payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
                   public void handleEvent(StoreEvent<BaseModel> be) {  
                      lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
                       String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());	
                       int yyyy = Integer.parseInt(fmt.toString()) - 1;                    
   					   targetYr.setValue(lsPayYrStore.findModel("payYr",String.valueOf(yyyy)));
                   }  
                 });  
               }  
             });  
   
     payYrGrid.add(payYrGridPanel); 
     payrP150001.add(payYrGrid);	
		
		msfCoCalendarDto = new SysCoCalendarDTO();
		lsYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);



		LayoutContainer  lycSreach = new LayoutContainer(); 
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0);  
		lycSreach.setLayout(frmlytStd);
		lycSreach.setHeight(30); 

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());
		layoutContainer_12.setStyleAttribute("paddingTop", "5px");

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_12.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(70); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_2.setLayout(frmlytSch);

		targetYr = new ComboBox<BaseModel>();
		targetYr.setForceSelection(true);
		targetYr.setMinChars(1);
		targetYr.setDisplayField("payYrDisp");
		targetYr.setValueField("payYr");
		targetYr.setTriggerAction(TriggerAction.ALL);
		targetYr.setEmptyText("--직종선택--");
		targetYr.setSelectOnFocus(true); 
		targetYr.setReadOnly(false);
		targetYr.setEnabled(true); 
		targetYr.setStore(lsPayYrStore );
		targetYr.setFieldLabel("이전년도");
		targetYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			@Autowired
			public void handleEvent(StoreEvent<BaseModel> be) {

				EventType type = be.getType();
				if (type == Store.Add) { 
					/*String fmt = DateTimeFormat.getFormat("yyyy").format(new Date());		    		
					int yyyy = Integer.parseInt(fmt.toString()) - 1;	                  
					targetYr.setValue(lsPayYrStore.findModel("payYr",String.valueOf(yyyy)));*/
				} 
			}
		});
		
		
		
		targetYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

            	reload();
            } 
        });
		
		
		layoutContainer_2.add(targetYr, new FormData("100%")); 
		layoutContainer_2.setBorders(false);

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(70); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_1.setLayout(frmlytSch);

		createYr = new ComboBox<BaseModel>();
		createYr.setForceSelection(true);
		createYr.setMinChars(1);
		createYr.setDisplayField("yearDisp");
		createYr.setValueField("year");
		createYr.setTriggerAction(TriggerAction.ALL);
		createYr.setEmptyText("--등급선택--");
		createYr.setSelectOnFocus(true); 
		createYr.setReadOnly(false);
		createYr.setEnabled(true); 
		createYr.setStore(lsYrStore );
		createYr.setFieldLabel("생성년도"); 

		createYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {

				EventType type = be.getType();
				if (type == Store.Add) { 
					createYr.setValue(lsYrStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
				} 

			}
		});    
		
		createYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

            	reload();
            } 
        });
		
		
		
		
		layoutContainer_1.add(createYr, new FormData("100%"));
		layoutContainer_1.setBorders(false);  

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(60); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytStd);


		// dtilOccuClsNm = new TextField<String>(); 
		//dtilOccuClsNm.setFieldLabel("직종세"); 
		// layoutContainer_13.add(dtilOccuClsNm, new FormData("100%")); 
		//layoutContainer_13.setBorders(false);

		
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button btnUsrNew = new Button("직종세이관");
		//btnUsrNew.setStyleAttribute("marginTop", "3px");
		btnUsrNew.setStyleAttribute("marginLeft", "50px");
		
		buttonBar.add(btnUsrNew);
		
		btnUsrNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				MessageBox.confirm("직종세이관", "선택하신 직종세를 이관 하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							BaseModel bm = new BaseModel();
							bm.set("createYr", MSFSharedUtils.getSelectedComboValue(createYr,"year"));
							if(pPayr150001GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){							
								payr1500Service.activityOnPayr0415Copy(pPayr150001GridPanel.getGrid().getSelectionModel().getSelectedItems(), bm, new AsyncCallback<Long>() {
									@Override
									public void onSuccess(Long result) {
										MessageBox.info("", "저장 되었습니다.", null);
										reload();											
									}
									@Override
									public void onFailure(Throwable caught) {
										caught.printStackTrace();
										MessageBox.info("", "저장 오류", null);
									}
								});
							}else{
								MessageBox.info("", "직종세를 선택하여주세요.", null);
							}
						}
					}
				});

			}
		});
		
		layoutContainer_12.add(buttonBar );
		
		
//		btnUsrSearch = new Button("검색");
//		btnUsrSearch.setIcon(MSFMainApp.ICONS.search()); 
//		btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				//조회버튼 클릭시 처리 
//			    reload();  
//			}
//		});
		//layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		//layoutContainer_12.add(btnUsrSearch );
		lycSreach.add(layoutContainer_12);

		payrP150001.add(lycSreach);
	}

	private  void createStandardForm() {

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_2 = new FieldSet();
		//	fldstNewFieldset_2.setSize(528, 120);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("직종세이관내역");
		fldstNewFieldset_2.setCollapsible(false);

		fldstNewFieldset_2.add(createCheckBoxGrid(),new FormData("100%"));

		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);

		
		
//		LayoutContainer layoutContainer_3 = new LayoutContainer();
//		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(0); 
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT); 
//		layoutContainer_3.setLayout(frmlytStd);
//		
//		ButtonBar buttonBar = new ButtonBar();
//		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
//
//		Button btnUsrNew = new Button("직종세이관");
//		btnUsrNew.setStyleAttribute("marginTop", "3px");
//		btnUsrNew.setStyleAttribute("marginRight", "50px");
//		
//		buttonBar.add(btnUsrNew);
//		
//		btnUsrNew.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				MessageBox.confirm("직종세이관", "선택하신 직종세를 이관 하시겠습니까?",new Listener<MessageBoxEvent>(){
//					@Override
//					public void handleEvent(MessageBoxEvent be) {
//						if("Yes".equals(be.getButtonClicked().getText())){
//							BaseModel bm = new BaseModel();
//							bm.set("createYr", MSFSharedUtils.getSelectedComboValue(createYr,"year"));
//							if(pPayr150001GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){							
//								payr1500Service.activityOnPayr0415Copy(pPayr150001GridPanel.getGrid().getSelectionModel().getSelectedItems(), bm, new AsyncCallback<Long>() {
//									@Override
//									public void onSuccess(Long result) {
//										MessageBox.info("", "저장 되었습니다.", null);
//										reload();											
//									}
//									@Override
//									public void onFailure(Throwable caught) {
//										caught.printStackTrace();
//										MessageBox.info("", "저장 오류", null);
//									}
//								});
//							}else{
//								MessageBox.info("", "직종세를 선택하여주세요.", null);
//							}
//						}
//					}
//				});
//
//			}
//		});
//		
//		layoutContainer_3.add(buttonBar );
//		
//		layoutContainer.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		payrP150001.add(layoutContainer);
		layoutContainer.setBorders(false); 
		
		
	} 

	private LayoutContainer createCheckBoxGrid() {    
		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();    
		lcStdGrid.setLayout(frmlytStd);  

		ContentPanel cpGrid = new ContentPanel();   
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());      
		cpGrid.setSize(560, 330);  

		pPayr150001GridPanel = new MSFGridPanel(pPayr1500Def, false, false, false, false, false);
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
	}   

	public void reload() {
		
		IColumnFilter filters = null;
		pPayr150001GridPanel.getMsfGrid().clearData();
		pPayr150001GridPanel.getTableDef().setTableColumnFilters(filters);			
		pPayr150001GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(targetYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS);
		pPayr150001GridPanel.getTableDef().addColumnFilter("createYr", MSFSharedUtils.getSelectedComboValue(createYr,"year"), SimpleColumnFilter.OPERATOR_EQUALS);
		pPayr150001GridPanel.reload();
	
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
