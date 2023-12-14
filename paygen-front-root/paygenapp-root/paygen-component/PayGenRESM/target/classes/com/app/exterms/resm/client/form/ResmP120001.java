/**
 * 이전사업이관
 */
package com.app.exterms.resm.client.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.resm.client.dto.Bass0350DTO;
import com.app.exterms.resm.client.form.defs.Bass0350Def;
import com.app.exterms.resm.client.service.Resm1200Service;
import com.app.exterms.resm.client.service.Resm1200ServiceAsync;
import com.app.exterms.resm.client.service.ResmP120001Service;
import com.app.exterms.resm.client.service.ResmP120001ServiceAsync;
import com.app.exterms.resm.client.utils.ResmUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
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
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class ResmP120001 extends MSFFormPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	private ContentPanel cpBass035001;
	
	// -------------- grid 선언 시작 ---------------
	private MSFGridPanel bassP035001_01GridPanel;
	private MSFGridPanel bassP035001_02GridPanel;

	// private Bass0500Def bass0500Def = new Bass0500Def();
	private Bass0350Def bass035001Def = new Bass0350Def("BASS0350_BEF");
	private Bass0350Def bass035002Def = new Bass0350Def("BASS0350_CRE");
	// -------------- grid 선언 종료 ---------------

	// -------------- 공통코드 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto;
	private PrgmComBass0320DTO sysComBass0320Dto;
	private PrgmComBass0350DTO sysComBass0350Dto;
	// -------------- 공통코드 선언 종료--------------

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 상태처리
	 * 전역변수 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 화면
	 * 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	public FormBinding formBinding;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private Button btnBassSave = new Button(); // 선태 저장
	private Button btnBassSave2 = new Button(); // 미선택 저장

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 검색변수
	 * 선언 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 검색 조건 시작 --------------
	private ListStore<BaseModel> stTypOccuCd = new ListStore<BaseModel>(); // 직종코드
	private ComboBox<BaseModel> chngTypOccuCdBe;	//직종코드 콤보박스
	private ComboBox<BaseModel> chngTypOccuCdAf;	//직종코드 콤보박스
	
	private DateField typOccuStDt; 			// 시작일자
	private DateField typOccuEdDt; 			// 종료일자

	private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
	// -------------- 검색 조건 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private Resm1200ServiceAsync bass0350Service = Resm1200Service.Util.getInstance();
	private ResmP120001ServiceAsync bassP035001Service = ResmP120001Service.Util.getInstance();

	// -------------- 서비스 호출 종료 --------------
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 입력
	 * 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/
	public ResmP120001(final ActionDatabase actionDatabase,	final MSFPanel caller) {

		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		this.setBorders(false);
		this.setAutoHeight(true);

		cpBass035001 = new ContentPanel();

		createSearchForm();

		cpBass035001.setBodyBorder(false);
		cpBass035001.setBorders(false);
		cpBass035001.setHeaderVisible(false);
		cpBass035001.setSize("790px", "640px");

		this.add(cpBass035001);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "730px");
	}

	/**
	 * 검색 정보 설정
	 */
	private void createSearchForm() {

		dpobCd = new HiddenField<String>();	/** column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpBass035001.add(dpobCd);

		sysComBass0320Dto = new PrgmComBass0320DTO();
		stTypOccuCd = new ListStore<BaseModel>();
		stTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		
		cpBass035001.setLayout(new FlowLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("직종세 이관");

		LayoutContainer lcSchCol = new LayoutContainer();

		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());

		LayoutContainer lcSchCol1_1 = new LayoutContainer();

		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(80);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_1.setLayout(fl1_1);

		chngTypOccuCdBe = new ComboBox<BaseModel>();
		chngTypOccuCdBe.setName("chngTypOccuCdBe");
		chngTypOccuCdBe.setFieldLabel("개편전 직종");
		chngTypOccuCdBe.setForceSelection(true);
		chngTypOccuCdBe.setMinChars(1);
		chngTypOccuCdBe.setDisplayField("typOccuNm");
		chngTypOccuCdBe.setValueField("typOccuCd");
		chngTypOccuCdBe.setTriggerAction(TriggerAction.ALL);
		chngTypOccuCdBe.setEmptyText("--직종선택--");
		chngTypOccuCdBe.setSelectOnFocus(true);
		chngTypOccuCdBe.setStore(stTypOccuCd);
		chngTypOccuCdBe.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		reload1();            
        } 
		}); 
		chngTypOccuCdBe.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200);
		lcSchCol1_1.add(chngTypOccuCdBe, new FormData("100%"));
		
		LayoutContainer lcSchCol1_2 = new LayoutContainer();

		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(80);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_2.setLayout(fl1_2);
		
		chngTypOccuCdAf = new ComboBox<BaseModel>();
		chngTypOccuCdAf.setName("chngTypOccuCdAf");
		chngTypOccuCdAf.setFieldLabel("개편후 직종");
		chngTypOccuCdAf.setForceSelection(true);
		chngTypOccuCdAf.setMinChars(1);
		chngTypOccuCdAf.setDisplayField("typOccuNm");
		chngTypOccuCdAf.setValueField("typOccuCd");
		chngTypOccuCdAf.setTriggerAction(TriggerAction.ALL);
		chngTypOccuCdAf.setEmptyText("--직종선택--");
		chngTypOccuCdAf.setSelectOnFocus(true);
		chngTypOccuCdAf.setStore(stTypOccuCd);
		chngTypOccuCdAf.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		reload2();            
        } 
		}); 
		chngTypOccuCdAf.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200);
		lcSchCol1_2.add(chngTypOccuCdAf, new FormData("100%"));

		lcSchCol1.add(lcSchCol1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		lcSchCol1.add(lcSchCol1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		/* 어디에 사용할지 몰라서 우선 숨김
		 * LayoutContainer lcSchCol2 = new LayoutContainer();
		lcSchCol2.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchCol2_1 = new LayoutContainer();
		lcSchCol2_1.setLayout(new ColumnLayout());
		
		LayoutContainer lcSchCol2_1_1 = new LayoutContainer();
		FormLayout fl2_1_1 = new FormLayout();
		fl2_1_1.setLabelWidth(80);
		fl2_1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol2_1_1.setLayout(fl2_1_1);
		
		typOccuStDt = new DateField();
		new DateFieldMask(typOccuStDt, "9999.99.99"); 
		typOccuStDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		typOccuStDt.setFieldLabel("기간");
		lcSchCol2_1_1.add(typOccuStDt, new FormData("100%"));		
		lcSchCol2_1.add(lcSchCol2_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.6));
		
		LayoutContainer lcSchCol2_1_2 = new LayoutContainer();
		FormLayout fl2_1_2 = new FormLayout();
		fl2_1_2.setLabelWidth(10);
		fl2_1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol2_1_2.setLayout(fl2_1_2);
		
		typOccuEdDt = new DateField();
		new DateFieldMask(typOccuEdDt, "9999.99.99"); 
		typOccuEdDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		typOccuEdDt.setLabelSeparator("~");
		lcSchCol2_1_2.add(typOccuEdDt, new FormData("100%"));		
		lcSchCol2_1.add(lcSchCol2_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.4));
		
		lcSchCol2.add(lcSchCol2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));	// 기간
*/		
		

		lcSchCol.add(lcSchCol1, new FormData("100%"));
		//lcSchCol.add(lcSchCol2, new FormData("100%"));

		fieldSet.add(lcSchCol, new FormData("100%"));
		
		cpBass035001.add(fieldSet);		
		cpBass035001.add(createMsfGridForm(), new FormData("100%"));

	}

	private LayoutContainer createMsfGridForm() {
		// private void createMsfGridForm() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		lcTabFormLayer.setLayout(frmlytStd);

		LayoutContainer layoutContainer2 = new LayoutContainer();
		layoutContainer2.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer2_1 = new LayoutContainer();
		layoutContainer2_1.setStyleAttribute("paddingLeft", "10px");

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer2_1.setLayout(frmlytStd);
		layoutContainer2_1.add(bassLeft01(), new FormData("100%"));		
		layoutContainer2_1.setBorders(false);
		
		FieldSet fldstNewFieldset2 = new FieldSet();
		fldstNewFieldset2.add(layoutContainer2_1, new FormData("100%"));
		fldstNewFieldset2.setHeadingHtml("개편전 직종세");		
		layoutContainer2.add(fldstNewFieldset2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer2_2 = new LayoutContainer();
		layoutContainer2_2.setStyleAttribute("paddingLeft", "10px");

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		
		layoutContainer2_2.setLayout(frmlytStd);
		layoutContainer2_2.add(bassRight01(), new FormData("100%"));		
		layoutContainer2_2.setBorders(false);
		
		FieldSet fldstNewFieldset3 = new FieldSet();
		fldstNewFieldset3.add(layoutContainer2_2, new FormData("100%"));
		fldstNewFieldset3.setHeadingHtml("개편후 직종세");
		layoutContainer2.add(fldstNewFieldset3,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer3_1 = new LayoutContainer();
		layoutContainer3_1.setStyleAttribute("paddingLeft", "10px");
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnBassSave = new Button("선택");
		btnBassSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if(MSFSharedUtils.getSelectedComboValue(chngTypOccuCdBe,"typOccuCd") == MSFSharedUtils.getSelectedComboValue(chngTypOccuCdAf,"typOccuCd")){
					MessageBox.alert("", "직종 선택에 오류가 있습니다.(같은 직종이거나 입력하지 않을 경우 발생)", null);
				}else{
					trnrBass035001();
				}				
			}
		});

		btnBar.add(btnBassSave);
		layoutContainer3_1.add(btnBar);
		
		ButtonBar btnBar2 = new ButtonBar();
		btnBar2.setAlignment(HorizontalAlignment.RIGHT);
		
		LayoutContainer layoutContainer3_2 = new LayoutContainer();
		layoutContainer3_2.setStyleAttribute("paddingLeft", "10px");

		btnBassSave2 = new Button("미선택");
		btnBassSave2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if(MSFSharedUtils.getSelectedComboValue(chngTypOccuCdBe,"typOccuCd") == MSFSharedUtils.getSelectedComboValue(chngTypOccuCdAf,"typOccuCd")){
					MessageBox.alert("", "직종 선택에 오류가 있습니다.(같은 직종이거나 입력하지 않을 경우 발생)", null);
				}else{
					trnrBass035002();
				}				
			}
		});

		btnBar2.add(btnBassSave2);
		layoutContainer3_2.add(btnBar2);
		
		layoutContainer3.add(layoutContainer3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		layoutContainer3.add(layoutContainer3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		lcTabFormLayer.add(layoutContainer2);
		lcTabFormLayer.add(layoutContainer3);
		
		return lcTabFormLayer;
	}

	private LayoutContainer bassLeft01() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGridBassP0350 = new ContentPanel();
		cpGridBassP0350.setBodyBorder(false);
		cpGridBassP0350.setHeaderVisible(false);
		cpGridBassP0350.setLayout(new FitLayout());

		bassP035001_01GridPanel = new MSFGridPanel(bass035001Def, false, false,	false, false);
		bassP035001_01GridPanel.setSize(420, 450);

		bassP035001_01GridPanel.setBorders(false);
		bassP035001_01GridPanel.setBodyBorder(true);
		bassP035001_01GridPanel.setHeaderVisible(false);
		bassP035001_01GridPanel.getBottomComponent().setVisible(false);

		cpGridBassP0350.add(bassP035001_01GridPanel);

		lcStdGrid.add(cpGridBassP0350);

		return lcStdGrid;

	}

	private LayoutContainer bassRight01() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGridBassP0350 = new ContentPanel();
		cpGridBassP0350.setBodyBorder(false);
		cpGridBassP0350.setHeaderVisible(false);
		cpGridBassP0350.setLayout(new FitLayout());

		bassP035001_02GridPanel = new MSFGridPanel(bass035002Def, false, false,	false, false);
		bassP035001_02GridPanel.setSize(420, 450);
		bassP035001_02GridPanel.setBorders(false);
		bassP035001_02GridPanel.setBodyBorder(true);
		bassP035001_02GridPanel.setHeaderVisible(false);
		bassP035001_02GridPanel.getBottomComponent().setVisible(false);

		cpGridBassP0350.add(bassP035001_02GridPanel);

		lcStdGrid.add(cpGridBassP0350);

		return lcStdGrid;

	}
	
	public void trnrBass035001() {
		
		
		Iterator<BaseModel> itBm = bassP035001_01GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		
		List<Record>  lsRec  = new ArrayList<Record>();
        
		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next()); 
			lsRec.add(rec);
		} 
            
        Iterator<Record> iterRecords = lsRec.iterator() ;  
        List<Bass0350DTO> listBass0350Dto = new ArrayList<Bass0350DTO>(); 
		
        final int cnt = bassP035001_01GridPanel.getGrid().getSelectionModel().getSelectedItems().size();
        
        while (iterRecords.hasNext()) {
		 	       
        	Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
 	               
			Bass0350DTO bass0350Dto = new Bass0350DTO();  
                    
			bass0350Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    										/** column 사업장코드 : dpobCd */
			bass0350Dto.setChngTypOccuCdBe(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(chngTypOccuCdBe,"typOccuCd")));     	/** 개편전 직종코드 : chngTypOccuCdBe */   
			bass0350Dto.setChngTypOccuCdAf(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(chngTypOccuCdAf,"typOccuCd")));     	/** 개편전 직종코드 : chngTypOccuCdBe */
			bass0350Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))); /** 직종세 코드 : dtilOccuInttnCd*/
			bass0350Dto.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsNm")));	/** 직종세 코드 : dtilOccuClsNm*/		
			listBass0350Dto.add(bass0350Dto);			
		}  
        bassP035001Service.trnrBeDtilOccuClsDivBass0350(listBass0350Dto ,new AsyncCallback<Integer>()  {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("trnrDtilOccuClsDivBass0350(" + "직종세이관이 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + cnt + "건중  " + " " + result + " " + "건이 완료되었습니다. 데이터를 확인해 주세요.", null);
				
				reload1();
				reload2();
				
			}
        });
	}
	
	public void trnrBass035002() {
		
		
		Iterator<BaseModel> itBm = bassP035001_02GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		
		List<Record>  lsRec  = new ArrayList<Record>();
        
		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next()); 
			lsRec.add(rec);
		} 
            
        Iterator<Record> iterRecords = lsRec.iterator() ;  
        List<Bass0350DTO> listBass0350Dto = new ArrayList<Bass0350DTO>(); 
		
        final int cnt = bassP035001_02GridPanel.getGrid().getSelectionModel().getSelectedItems().size();
        
        while (iterRecords.hasNext()) {
		 	       
        	Record recData = (Record) iterRecords.next(); 
			BaseModel bmMapModel = (BaseModel)recData.getModel();
 	               
			Bass0350DTO bass0350Dto = new Bass0350DTO();  
                    
			bass0350Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    										/** column 사업장코드 : dpobCd */
			bass0350Dto.setChngTypOccuCdBe(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(chngTypOccuCdBe,"typOccuCd")));     	/** 개편전 직종코드 : chngTypOccuCdBe */   
			bass0350Dto.setChngTypOccuCdAf(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(chngTypOccuCdAf,"typOccuCd")));     	/** 개편전 직종코드 : chngTypOccuCdBe */
			bass0350Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))); /** 직종세 코드 : dtilOccuInttnCd*/
			bass0350Dto.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsNm")));	/** 직종세 코드 : dtilOccuClsNm*/		
			listBass0350Dto.add(bass0350Dto);			
		}  
        bassP035001Service.trnrAfDtilOccuClsDivBass0350(listBass0350Dto ,new AsyncCallback<Integer>()  {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("trnrDtilOccuClsDivBass0350(" + "직종세이관이 실패하였습니다. <br>관리자에게 문의해주세요." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + cnt + "건중  " + " " + result + " " + "건이 완료되었습니다. 데이터를 확인해 주세요.", null);
				
				reload1();
				reload2();
				
			}
        });
	}

	public void reload2() {
		
		IColumnFilter filters = null;
		
		bassP035001_02GridPanel.getMsfGrid().clearData();	
		bassP035001_02GridPanel.getTableDef().setTableColumnFilters(filters);
		bassP035001_02GridPanel.getTableDef().addColumnFilter("srhTypOccuCd", ResmUtils.getSelectedComboValue(chngTypOccuCdAf, "typOccuCd"), SimpleColumnFilter.OPERATOR_LIKE);	//직종명
		bassP035001_02GridPanel.reload();
	}

	public void reload1() {
		
		IColumnFilter filters = null;
		
		bassP035001_01GridPanel.getMsfGrid().clearData();	
		bassP035001_01GridPanel.getTableDef().setTableColumnFilters(filters);
		bassP035001_01GridPanel.getTableDef().addColumnFilter("srhTypOccuCd", ResmUtils.getSelectedComboValue(chngTypOccuCdBe, "typOccuCd"), SimpleColumnFilter.OPERATOR_LIKE);	//직종명
		bassP035001_01GridPanel.reload();
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
