/**
 * 이전사업이관
 */
package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.dto.Psnl2100DTO;
import com.app.exterms.basis.client.form.defs.Psnl2100Def;
import com.app.exterms.basis.client.service.Bass0310Service;
import com.app.exterms.basis.client.service.Bass0310ServiceAsync;
import com.app.exterms.basis.client.service.BassP031002Service;
import com.app.exterms.basis.client.service.BassP031002ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class BassP031002 extends MSFFormPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	private FormPanel cpBass031001;
	
	// -------------- grid 선언 시작 ---------------
	private MSFGridPanel BassP031002_01GridPanel;
	private MSFGridPanel BassP031002_02GridPanel;
	private MSFGridPanel BassP031002_03GridPanel;

	// private Bass0500Def bass0500Def = new Bass0500Def();
	private Psnl2100Def bass031001Def_01 = new Psnl2100Def("BASS0310_PSNL2100_COPY_3");
	private Psnl2100Def bass031001Def_02 = new Psnl2100Def("BASS0310_PSNL2100_COPY_1");
	// -------------- grid 선언 종료 ---------------

	// -------------- 공통코드 선언 시작 --------------
	private PrgmComBass0320DTO sysComBass0320Dto;
	private PrgmComBass0350DTO sysComBass0350Dto;
	// -------------- 공통코드 선언 종료--------------

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 상태처리
	 * 전역변수 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 화면
	 * 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	public FormBinding formBinding;
	private Date today = new Date();		// 오늘 날짜 가져오는 코드
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private Button btnBassSave = new Button(); // 선태 저장
	private Button btnBassSave2 = new Button(); // 미선택 저장
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 변수
	 * 선언 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 변수 시작 --------------
	private ListStore<BaseModel> stTypOccuCd = new ListStore<BaseModel>(); // 직종코드
	private ListStore<BaseModel> stDtilOccuInttnCd = new ListStore<BaseModel>();
	private ComboBox<BaseModel> basicTypOccuCd;		//기본 직종
	private ComboBox<BaseModel> basicDtilOccuClsDivCd;	// 기본직종세구분코드
	private ComboBox<BaseModel> targetTypOccuCd;	//대상 직종
	private DateField applicationDate;
	private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
	// -------------- 변수 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private Bass0310ServiceAsync bass0310Service = Bass0310Service.Util.getInstance();
	private BassP031002ServiceAsync bassP031002Service = BassP031002Service.Util.getInstance();

	// -------------- 서비스 호출 종료 --------------
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 입력
	 * 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	/** ComboBox 선택 이벤트 */
	private SelectionChangedListener<BaseModel> selectionChangeListener = new SelectionChangedListener<BaseModel>() {
        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        	//직종변경에 따른 직종세 값 가져오기
        	String strTypOccuCd2 =  MSFSharedUtils.getSelectedComboValue(basicTypOccuCd,"typOccuCd") ;
            if (MSFSharedUtils.paramNotNull(strTypOccuCd2)) { 
            	  sysComBass0350Dto = new PrgmComBass0350DTO();
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd2);	
                  sysComBass0350Dto.setDtilOccuClsUseYn("Y");
					if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {	
						stDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto);
						basicDtilOccuClsDivCd.setStore(stDtilOccuInttnCd);
                }
            }
        }
    };

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/
	
	public BassP031002(final ActionDatabase actionDatabase,	final MSFPanel caller) {

		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		this.setBorders(false);
		this.setAutoHeight(true);

		cpBass031001 = new FormPanel();

		createMsfGridForm();

		cpBass031001.setBodyBorder(false);
		cpBass031001.setBorders(false);
		cpBass031001.setHeaderVisible(false);
		cpBass031001.setSize("890px", "590px");

		this.add(cpBass031001);
		formBinding = new FormBinding(this, true);

		this.setSize("900px", "590px");
	}
	
	private void createMsfGridForm() {
		// private void createMsfGridForm() {
		LayoutContainer layoutContainer = new LayoutContainer();
		
		LayoutContainer layoutContainer1 = new LayoutContainer();
		layoutContainer1.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer1_1 = new LayoutContainer();
//		layoutContainer1.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer1_1.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer1_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		layoutContainer1_2.setLayout(new ColumnLayout());
				
		FieldSet fldstNewFieldset2 = new FieldSet();
		fldstNewFieldset2.setHeadingHtml("기본 직종세");
		fldstNewFieldset2.setSize("430px", "500px");
		fldstNewFieldset2.add(bassLeft01(), new FormData("100%"));
		layoutContainer1.add(fldstNewFieldset2);
		
		layoutContainer1.add(layoutContainer1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
				
		FieldSet fldstNewFieldset3 = new FieldSet();		
		fldstNewFieldset3.setHeadingHtml("대상 직종세");
		fldstNewFieldset3.setSize("430px", "500px");
		fldstNewFieldset3.add(bassRight01(), new FormData("100%"));
		layoutContainer1_2.add(fldstNewFieldset3);
		
		layoutContainer1.add(layoutContainer1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setStyleAttribute("paddingRight", "15px");
		layoutContainer2.setStyleAttribute("paddingTop", "10px");
		
		LayoutContainer layoutContainer2_1 = new LayoutContainer();	
		
		LayoutContainer layoutContainer2_2 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnBassSave = new Button("일괄복사");
		btnBassSave.setWidth(150);
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if( "".equals(BasisUtil.getSelectedComboValue(basicTypOccuCd,"typOccuCd")) || 
		    			"".equals(BasisUtil.getSelectedComboValue(targetTypOccuCd,"typOccuCd")) ){
					MessageBox.info("", "직종을 선택하여 주세요.", null);
				}else if("".equals(BasisUtil.getSelectedComboValue(basicDtilOccuClsDivCd,"dtilOccuInttnCd"))){
					MessageBox.info("", "직종세를 선택하여 주세요.", null);  
				}else{
					copyPkgEvent031001();
				}					
			}
			
		});

		btnBar.add(btnBassSave);
		layoutContainer2_2.add(btnBar);
		
		layoutContainer2.add(layoutContainer2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.6));
		layoutContainer2.add(layoutContainer2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.4));
		
		layoutContainer.add(layoutContainer1);
		layoutContainer.add(layoutContainer2);
		
		cpBass031001.add(layoutContainer);
	}

	private LayoutContainer bassLeft01() {
		sysComBass0320Dto = new PrgmComBass0320DTO();
		stTypOccuCd = new ListStore<BaseModel>();		
		stTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		
		stDtilOccuInttnCd = new ListStore<BaseModel>();
		stDtilOccuInttnCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		
		LayoutContainer lcStdGrid = new LayoutContainer();
//		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		lcStdGrid.setLayout(new ColumnLayout());
		
		LayoutContainer lcStdColStdFrm = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(50);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		lcStdColStdFrm.setLayout(frmlytStd);
		lcStdColStdFrm.setBorders(false);
		lcStdColStdFrm.setStyleAttribute("paddingBottom", "5px");
		
		basicTypOccuCd = new ComboBox<BaseModel>();
		basicTypOccuCd.setName("basicTypOccuCd");
		basicTypOccuCd.setForceSelection(true);
		basicTypOccuCd.setMinChars(1);
		basicTypOccuCd.setDisplayField("typOccuNm");
		basicTypOccuCd.setValueField("typOccuCd");
		basicTypOccuCd.setTriggerAction(TriggerAction.ALL);
		basicTypOccuCd.setEmptyText("--직종선택--");
		basicTypOccuCd.setSelectOnFocus(true);
		basicTypOccuCd.setReadOnly(false);
		basicTypOccuCd.setEnabled(true);
		basicTypOccuCd.setStore(stTypOccuCd);
		basicTypOccuCd.setFieldLabel("직종");
		basicTypOccuCd.addSelectionChangedListener(selectionChangeListener);
		lcStdColStdFrm.add(basicTypOccuCd, new FormData("100%"));
		
		basicDtilOccuClsDivCd = new ComboBox<BaseModel>();
		basicDtilOccuClsDivCd.setName("basicDtilOccuClsDivCd");
		basicDtilOccuClsDivCd.setForceSelection(true);
		basicDtilOccuClsDivCd.setMinChars(1);
		basicDtilOccuClsDivCd.setDisplayField("dtilOccuClsNm");
		basicDtilOccuClsDivCd.setValueField("dtilOccuInttnCd");
		basicDtilOccuClsDivCd.setTriggerAction(TriggerAction.ALL);
		basicDtilOccuClsDivCd.setEmptyText("--직종세 선택--");
		basicDtilOccuClsDivCd.setSelectOnFocus(true);
		basicDtilOccuClsDivCd.setReadOnly(false);
		basicDtilOccuClsDivCd.setEnabled(true);
		basicDtilOccuClsDivCd.setFieldLabel("직종세");
		basicDtilOccuClsDivCd.setStore(stDtilOccuInttnCd);
		basicDtilOccuClsDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		if( !"".equals(BasisUtil.getSelectedComboValue(basicTypOccuCd,"typOccuCd")) &&
	    				!"".equals(BasisUtil.getSelectedComboValue(basicDtilOccuClsDivCd,"dtilOccuInttnCd"))){
	    			reload();
				}	    		          
        } 
		}); 
		lcStdColStdFrm.add(basicDtilOccuClsDivCd, new FormData("100%"));

		ContentPanel cpGridBassP0310 = new ContentPanel();
		cpGridBassP0310.setBodyBorder(false);
		cpGridBassP0310.setHeaderVisible(false);
		cpGridBassP0310.setLayout(new FitLayout());
		cpGridBassP0310.setSize(410, 410);
		
		BassP031002_01GridPanel = new MSFGridPanel(bass031001Def_01, false, false,false, false, false);
		BassP031002_01GridPanel.setBorders(true);
		BassP031002_01GridPanel.setBodyBorder(true);
		BassP031002_01GridPanel.setHeaderVisible(false);
		BassP031002_01GridPanel.getBottomComponent().setVisible(true);	
		
		cpGridBassP0310.add(BassP031002_01GridPanel);

		lcStdGrid.add(lcStdColStdFrm);
		lcStdGrid.add(cpGridBassP0310);	
		
		return lcStdGrid;

	}

	private LayoutContainer bassRight01() {

		LayoutContainer lcStdGrid = new LayoutContainer();
//		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		lcStdGrid.setLayout(new ColumnLayout());
		
		LayoutContainer lcStdColStdFrm = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);		
		lcStdColStdFrm.setLayout(frmlytStd);
		lcStdColStdFrm.setStyleAttribute("paddingBottom", "5px");
		
		targetTypOccuCd = new ComboBox<BaseModel>();
		targetTypOccuCd.setName("targetTypOccuCd");
		targetTypOccuCd.setForceSelection(true);
		targetTypOccuCd.setMinChars(1);
		targetTypOccuCd.setDisplayField("typOccuNm");
		targetTypOccuCd.setValueField("typOccuCd");
		targetTypOccuCd.setTriggerAction(TriggerAction.ALL);
		targetTypOccuCd.setEmptyText("--직종선택--");
		targetTypOccuCd.setSelectOnFocus(true);
		targetTypOccuCd.setReadOnly(false);
		targetTypOccuCd.setEnabled(true);
		targetTypOccuCd.setStore(stTypOccuCd);
		targetTypOccuCd.setFieldLabel("직 종");
		targetTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		if(!"".equals(BasisUtil.getSelectedComboValue(targetTypOccuCd,"typOccuCd"))){
	    			reload1();
				}            
        } 
		});
		lcStdColStdFrm.add(targetTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		applicationDate = new DateField();
		applicationDate.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		applicationDate.setName("applicationDate");				 
		new DateFieldMask(applicationDate, "9999.99.99");
		applicationDate.setFieldLabel("적용일자");
		applicationDate.setMinLength(10);
		applicationDate.setMaxLength(10);
		applicationDate.setValue(today);
		lcStdColStdFrm.add(applicationDate, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

		ContentPanel cpGridBassP0310 = new ContentPanel();
		cpGridBassP0310.setBodyBorder(false);
		cpGridBassP0310.setHeaderVisible(false);
		cpGridBassP0310.setLayout(new FitLayout());
		cpGridBassP0310.setSize(410, 210);
		cpGridBassP0310.setStyleAttribute("paddingBottom", "10px");

		BassP031002_02GridPanel = new MSFGridPanel(bass031001Def_02, false, false,false, false, false);
//		BassP031002_02GridPanel.setSize(380, 450);
		BassP031002_02GridPanel.setBorders(false);
		BassP031002_02GridPanel.setBodyBorder(true);
		BassP031002_02GridPanel.setHeaderVisible(false);
		BassP031002_02GridPanel.getBottomComponent().setVisible(true);
		// 두번째 미사용직종정보 툴바 
		ToolBar bottomToolbar2 = new ToolBar(); 
		bottomToolbar2.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnBassSave = new Button("선택");
		btnBassSave.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(BassP031002_02GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
					
					List<BaseModel> list = BassP031002_02GridPanel.getGrid().getSelectionModel().getSelectedItems();
					for(BaseModel bm : list){
						
						BassP031002_02GridPanel.getGrid().getStore().remove(bm);
						}
					
					BassP031002_03GridPanel.getGrid().getStore().add(list);
					
					
				}
			}			
		});
	    
	 
	    bottomToolbar2.add(btnBassSave);
	    bottomToolbar2.add(new SeparatorMenuItem());
	    //====================================================admi
	    BassP031002_02GridPanel.setBottomComponent(bottomToolbar2);
	    cpGridBassP0310.add(BassP031002_02GridPanel);
	    
	    ContentPanel cpGridBassP0310_2 = new ContentPanel();
	    cpGridBassP0310_2.setBodyBorder(false);
	    cpGridBassP0310_2.setHeaderVisible(false);
	    cpGridBassP0310_2.setLayout(new FitLayout());
	    cpGridBassP0310_2.setSize(410, 210);
		
	    BassP031002_03GridPanel = new MSFGridPanel(bass031001Def_02, false, false,false, false, false);
	    BassP031002_03GridPanel.setBorders(false);
	    BassP031002_03GridPanel.setBodyBorder(true);
	    BassP031002_03GridPanel.setHeaderVisible(false);
	    BassP031002_03GridPanel.getBottomComponent().setVisible(true);
		// 두번째 미사용직종정보 툴바 
		ToolBar bottomToolbar3 = new ToolBar(); 
		bottomToolbar3.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnBassSave2 = new Button("미선택");
		btnBassSave2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(BassP031002_03GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
					
					List<BaseModel> list = BassP031002_03GridPanel.getGrid().getSelectionModel().getSelectedItems();
					for(BaseModel bm : list){
						
						BassP031002_03GridPanel.getGrid().getStore().remove(bm);
						}
					
					BassP031002_02GridPanel.getGrid().getStore().add(list);
					
					
				}
			}			
		});
	 
	    bottomToolbar3.add(btnBassSave2);
	    bottomToolbar3.add(new SeparatorMenuItem());
	    //====================================================admi
	    BassP031002_03GridPanel.setBottomComponent(bottomToolbar3);
	    	    
	    cpGridBassP0310_2.add(BassP031002_03GridPanel);

	    lcStdGrid.add(lcStdColStdFrm);
		lcStdGrid.add(cpGridBassP0310);
		lcStdGrid.add(cpGridBassP0310_2);	

		return lcStdGrid;

	}
	
	
	public void copyPkgEvent031001() {
		
		
		Iterator<BaseModel> itBm = BassP031002_03GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		
		List<Record>  lsRec  = new ArrayList<Record>();
        
		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next()); 
			lsRec.add(rec);
		} 
            
        Iterator<Record> iterRecords = lsRec.iterator() ;  
        List<Psnl2100DTO> listPsnl2100Dto = new ArrayList<Psnl2100DTO>(); 
		
        final int cnt = BassP031002_03GridPanel.getGrid().getSelectionModel().getSelectedItems().size();
        
        while (iterRecords.hasNext()) {
		 	       
        	Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
 	               
			Psnl2100DTO psnl2100Dto = new Psnl2100DTO();  
                    
			psnl2100Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
			psnl2100Dto.setTargetDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))); /** 직종세 코드 : dtilOccuInttnCd*/
			psnl2100Dto.setTargetTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));	/** 직종세 코드 : dtilOccuClsNm*/
			psnl2100Dto.setBasicTypOccuCd(BasisUtil.getSelectedComboValue(basicTypOccuCd,"typOccuCd"));
			psnl2100Dto.setBasicDtilOccuClsDivCd(BasisUtil.getSelectedComboValue(basicDtilOccuClsDivCd,"dtilOccuInttnCd"));
			psnl2100Dto.setApplicationDate(BasisUtil.getConvertDateToString(applicationDate, "yyyyMMdd"));
			listPsnl2100Dto.add(psnl2100Dto);			
		}          
        bassP031002Service.copyPkgHodyNumDysBass031002(listPsnl2100Dto ,new AsyncCallback<Integer>()  {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("copyPkgHodyNumDysBass031001(" + "일괄 복사가 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + cnt + "건중  " + " " + result + " " + "건이 완료되었습니다.", null);	
				basicTypOccuCd.setValue(new BaseModel());
				basicDtilOccuClsDivCd.setValue(new BaseModel());
				targetTypOccuCd.setValue(new BaseModel());
				reload2();
			}
        });
        
	}
	
	public void reload() {
		
		IColumnFilter filters = null;
		BassP031002_01GridPanel.getMsfGrid().clearData();	
		BassP031002_01GridPanel.getTableDef().setTableColumnFilters(filters);
		BassP031002_01GridPanel.getTableDef().addColumnFilter("typOccuCd", BasisUtil.getSelectedComboValue(basicTypOccuCd, "typOccuCd"), SimpleColumnFilter.OPERATOR_LIKE);	//직종명
		BassP031002_01GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(basicDtilOccuClsDivCd, "dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		BassP031002_01GridPanel.reload();
	}
	
	public void reload1() {
		
		IColumnFilter filters = null;
		BassP031002_02GridPanel.getMsfGrid().clearData();	
		BassP031002_02GridPanel.getTableDef().setTableColumnFilters(filters);
		BassP031002_02GridPanel.getTableDef().addColumnFilter("typOccuCd", BasisUtil.getSelectedComboValue(targetTypOccuCd, "typOccuCd"), SimpleColumnFilter.OPERATOR_LIKE);	//직종명
		BassP031002_02GridPanel.reload();
	}
	
	public void reload2() {		
		BassP031002_01GridPanel.getMsfGrid().clearData();
		BassP031002_02GridPanel.getMsfGrid().clearData();
		BassP031002_03GridPanel.getMsfGrid().clearData();
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
