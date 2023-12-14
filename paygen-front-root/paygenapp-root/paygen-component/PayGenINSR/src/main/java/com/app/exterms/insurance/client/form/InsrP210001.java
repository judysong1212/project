/**
 * 피부양자취득/상실신고 
 */
package com.app.exterms.insurance.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1550DTO;
import com.app.exterms.insurance.client.form.defs.Insr1500Def;
import com.app.exterms.insurance.client.service.InsrP210001Service;
import com.app.exterms.insurance.client.service.InsrP210001ServiceAsync;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.  
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class InsrP210001  extends MSFFormPanel {  

	private MSFPanel caller;
	private Boolean reading = false;
	public FormBinding formBinding;

	private HiddenField<String> dpobCd;  //사업장코드
	private HiddenField<String> systemkey;			/** column SYSTEMKEY : systemkey */ 
	private HiddenField<String> famyAqtnLssDt;  /** column 사회보험작성일자 : famyAqtnLssDt */ 
	private HiddenField<Long> 	famyAqtnLssNum;  /** column 사회보험취득_고용_일련번호 : famyAqtnLssNum */
	private HiddenField<String> payrMangDeptCd;   	/** column 단위기관코드 : payrMangDeptCd */
	private HiddenField<String> currAffnDeptCd ;  	/** column 부서코드 : deptCd */
	private HiddenField<String> businCd;   			/** column 사업코드 : businCd */
	private HiddenField<String> emymtDivCd;   		/** column 고용구분코드 : emymtDivCd */
	private HiddenField<String> dtilOccuInttnCd;	/**  column 직종세구분코드 : dtilOccuInttnCd */
	private HiddenField<String> typOccuCd;   		/** column 직종코드 : typOccuCd */
	
	private HiddenField<String> socInsrAqtnEmymtNum; //취득일련번호
	private HiddenField<String> soctyInsurCmptnDt; //취득일자
	
	//기본정보
	private TextField<String> hanNm;  			/** column 한글성명 : hanNm */
	private TextField<String> resnRegnNum;   	/** column 주민등록번호 : resnRegnNum */
	private HiddenField<String> secRegnNum;   		//원본 주민등록번호 
	private TextField<String> emymtDivNm;		/**  column 고용구분 : emymtDivNm */
    private TextField<String> currAffnDeptNm;  	/** column 부서 : deptNm */
    private TextField<String> typOccuNm;  		/** column 직종코드 : typOccuNm */ 
    private TextField<String> dtilOccuClsDivNm;	/**  column 직종세구분코드 : dtilOccuClsDivNm */

    private TextField<String> insrDpobPhnNum;   		/** column 건강보험사업장전화번호 : insrDpobPhnNum */
    private TextField<String> insrUsePhnNum; 	/**  column 건강보험가입자전화번호 : insrUsePhnNum */
      
    private HiddenField<String> payMangeDeptNm;   		//건강보험사업장명
    private HiddenField<String> hlthInsrSym;   		//건강보험사업장관리번호
    
    private ContentPanel cpInsr2101;
	private Insr1500Def insr1500Def = new Insr1500Def("INSRP210001"); // 그리드 테이블 컬럼 define
	private MSFGridPanel insr1500GridPanel;
	private ActionDatabase actionDatabase;
	
    private BaseModel record; 
	private Iterator<Record> records;
    
    private InsrP210001ServiceAsync insrP210001Service = InsrP210001Service.Util.getInstance();	    
        
    public InsrP210001(final ActionDatabase actionDatabase, final MSFPanel caller) {
    	
    	this.setBorders(false);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;
		  
		cpInsr2101 = new ContentPanel();
		createPayrP410002Form();  //화면 기본정보를 설정
		createInfoForm();    //검색필드를 적용
		createStandardForm();    //기본정보필드   
		
		cpInsr2101.setBodyBorder(false);
		cpInsr2101.setBorders(false);
		cpInsr2101.setHeaderVisible(false);
		    
		this.add(cpInsr2101);
		formBinding = new FormBinding(this, true);
		this.setSize("890px", "500px");  
	  } 

    private void createPayrP410002Form() {
		   
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button topBtn1 = new Button("가족선택");
		topBtn1.setIcon(MSFMainApp.ICONS.new16());
		buttonBar.add(topBtn1);
		topBtn1.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				actionDatabase = ActionDatabase.INSERT;
				insertInsr1550();  
	    	}
	    });

		Button topBtn = new Button("저장");
		topBtn.setIcon(MSFMainApp.ICONS.save16());
		buttonBar.add(topBtn);
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				int panelSize = insr1500GridPanel.getMsfGrid().getStore().getModifiedRecords().size();
				if (panelSize <1) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "변경된 내역이 없습니다.", null);
				}
				else {
					setListRecord(insr1500GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
					actionDatabase = ActionDatabase.UPDATE;
					insr15501600FormSave();
				}
			}
		});

		Button topBtn2 = new Button("삭제");
		topBtn2.setIcon(MSFMainApp.ICONS.delete16());
		buttonBar.add(topBtn2);
		topBtn2.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				Iterator<BaseModel> itBm  = insr1500GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				
				List<Record>  lsRec  = new ArrayList<Record>();
				
				while(itBm.hasNext()) {
					Record rec  = new Record(itBm.next()); 
					lsRec.add(rec);
				} 
				setListRecord(lsRec.iterator()); 
	                
				actionDatabase = ActionDatabase.DELETE;
				insr15501600FormSave();
	    	}
	    });
		  	
		cpInsr2101.add(buttonBar);
		cpInsr2101.setSize("875px", "500px");
	}
	  
	private  void createInfoForm() {   
	  
	   systemkey = new HiddenField<String>();  //시스템키 
       systemkey.setName("systemkey");
       cpInsr2101.add(systemkey);
       
       payrMangDeptCd = new  HiddenField<String>(); 
       payrMangDeptCd.setName("payrMangDeptCd");
       cpInsr2101.add(payrMangDeptCd); 
       
       businCd = new  HiddenField<String>(); 
       businCd.setName("businCd");
       cpInsr2101.add(businCd);
       
       dpobCd = new HiddenField<String>();  //사업장코드 
       dpobCd.setName("dpobCd");
       cpInsr2101.add(dpobCd);
       
       socInsrAqtnEmymtNum = new HiddenField<String>();  //사회보험취득_고용_일련번호 
       socInsrAqtnEmymtNum.setName("socInsrAqtnEmymtNum");
       cpInsr2101.add(socInsrAqtnEmymtNum);

       payMangeDeptNm = new HiddenField<String>();  //건강보험사업장명 
       payMangeDeptNm.setName("payMangeDeptNm");
       cpInsr2101.add(payMangeDeptNm);

       hlthInsrSym = new HiddenField<String>();  //건강보험사업장관리번호 
       hlthInsrSym.setName("hlthInsrSym");
       cpInsr2101.add(hlthInsrSym);
       
       soctyInsurCmptnDt = new HiddenField<String>();  //사회보험취득_작성일자
       soctyInsurCmptnDt.setName("soctyInsurCmptnDt");
       cpInsr2101.add(soctyInsurCmptnDt);
       
       famyAqtnLssDt = new HiddenField<String>();   /** column 사회보험작성일자 : famyAqtnLssDt */
       famyAqtnLssDt.setName("famyAqtnLssDt");
       cpInsr2101.add(famyAqtnLssDt);
       famyAqtnLssNum = new HiddenField<Long>();   /** column 사회보험취득_고용_일련번호 : famyAqtnLssNum */
       famyAqtnLssNum.setName("famyAqtnLssNum");
       cpInsr2101.add(famyAqtnLssNum);
       
       typOccuCd = new HiddenField<String>();  /**  column 직종코드 : typOccuCd */
       typOccuCd.setName("typOccuCd");
       cpInsr2101.add(typOccuCd);
       dtilOccuInttnCd = new HiddenField<String>();  //사업장코드 
       dtilOccuInttnCd.setName("dtilOccuInttnCd");
       cpInsr2101.add(dtilOccuInttnCd);
       currAffnDeptCd = new HiddenField<String>();  //사업장코드 
       currAffnDeptCd.setName("currAffnDeptCd");
       cpInsr2101.add(currAffnDeptCd);
       businCd = new HiddenField<String>();  //사업장코드 
       businCd.setName("businCd");
       cpInsr2101.add(businCd);

       emymtDivCd = new HiddenField<String>();
	   emymtDivCd.setName("emymtDivCd");
	   cpInsr2101.add(emymtDivCd);
	         
	      
	   FieldSet fieldSet1 = new FieldSet();  
	   fieldSet1.setHeadingHtml("기본정보");

	   LayoutContainer lcSchCol1 = new LayoutContainer();
	   lcSchCol1.setLayout(new ColumnLayout()); 

	   LayoutContainer layoutContainer_6 = new LayoutContainer();

	   FormLayout  frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_6.setLayout(frmlytStd);

	   hanNm = new TextField<String>(); 
	   hanNm.setName("hanNm");
	   hanNm.setReadOnly(true);
	   layoutContainer_6.add(hanNm, new FormData("100%"));
	   hanNm.setFieldLabel("성 명"); 
	   layoutContainer_6.setBorders(false);

	   LayoutContainer layoutContainer_7 = new LayoutContainer();

	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_7.setLayout(frmlytStd);

	   secRegnNum = new HiddenField<String>();
	   
	   resnRegnNum = new TextField<String>();
	   resnRegnNum.setName("resnRegnNum");
	   resnRegnNum.setReadOnly(true);
	   layoutContainer_7.add(resnRegnNum, new FormData("100%"));
	   resnRegnNum.setFieldLabel("주민번호"); 
	   layoutContainer_7.setBorders(false);

	   LayoutContainer layoutContainer_8 = new LayoutContainer();

	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_8.setLayout(frmlytStd);

	   emymtDivNm = new TextField<String>();
	   emymtDivNm.setName("emymtDivNm");
	   emymtDivNm.setReadOnly(true);
	   layoutContainer_8.add(emymtDivNm, new FormData("100%"));
	   emymtDivNm.setFieldLabel("고 용"); 
	   layoutContainer_8.setBorders(false);

	   LayoutContainer layoutContainer_10 = new LayoutContainer();

	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_10.setLayout(frmlytStd);

	   currAffnDeptNm = new TextField<String>(); 
	   currAffnDeptNm.setName("currAffnDeptNm");
	   currAffnDeptNm.setReadOnly(true);
	   layoutContainer_10.add(currAffnDeptNm, new FormData("100%"));
	   currAffnDeptNm.setFieldLabel("부 서"); 
	   layoutContainer_10.setBorders(false);

	   lcSchCol1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   lcSchCol1.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   lcSchCol1.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   lcSchCol1.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

	   fieldSet1.add(lcSchCol1, new FormData("100%"));

	   LayoutContainer layoutContainer_5 = new LayoutContainer();
	   layoutContainer_5.setLayout(new ColumnLayout());
	   layoutContainer_5.setBorders(false);

	   LayoutContainer layoutContainer_11 = new LayoutContainer();

	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_11.setLayout(frmlytStd);

	   typOccuNm = new TextField<String>();
	   typOccuNm.setName("typOccuNm");
	   typOccuNm.setReadOnly(true);
	   layoutContainer_11.add(typOccuNm, new FormData("100%"));
	   typOccuNm.setFieldLabel("직 종"); 
	   layoutContainer_11.setBorders(false);

	   LayoutContainer layoutContainer_17 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_17.setLayout(frmlytStd);

	   dtilOccuClsDivNm = new TextField<String>();
	   dtilOccuClsDivNm.setName("dtilOccuClsDivNm");
	   dtilOccuClsDivNm.setReadOnly(true);
	   layoutContainer_17.add(dtilOccuClsDivNm, new FormData("100%"));
	   dtilOccuClsDivNm.setFieldLabel("직종세"); 
	   layoutContainer_17.setBorders(false);

	   layoutContainer_5.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_5.add(layoutContainer_17, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   
	   LayoutContainer layoutContainer_12 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_12.setLayout(frmlytStd);

	   insrDpobPhnNum = new TextField<String>();
	   insrDpobPhnNum.setName("insrDpobPhnNum");
	   insrDpobPhnNum.setReadOnly(true);
	   layoutContainer_12.add(insrDpobPhnNum, new FormData("100%"));
	   insrDpobPhnNum.setFieldLabel("사업장전화"); 
	   layoutContainer_12.setBorders(false);

	   LayoutContainer layoutContainer_3_1 = new LayoutContainer();
	   frmlytStd = new FormLayout();  
	   frmlytStd.setLabelWidth(80); 
	   frmlytStd.setLabelAlign(LabelAlign.RIGHT);
	   layoutContainer_3_1.setLayout(frmlytStd);

	   insrUsePhnNum = new TextField<String>();
	   insrUsePhnNum.setName("insrUsePhnNum");
	   insrUsePhnNum.setReadOnly(true);
	   insrUsePhnNum.setFieldLabel("가입자전화");   
	   layoutContainer_3_1.add(insrUsePhnNum, new FormData("100%"));
	   layoutContainer_5.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   layoutContainer_5.add(layoutContainer_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	

	   fieldSet1.add(layoutContainer_5); 

	   cpInsr2101.add(fieldSet1); 
	}  
	 
	private void createStandardForm() {
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);

		FieldSet fldstNewFieldset_2 = new FieldSet();
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("피부양자정보");
		fldstNewFieldset_2.setCollapsible(false);

		fldstNewFieldset_2.add(createCheckBoxGrid(), new FormData("100%"));

		layoutContainer.add(layoutContainer_2,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		layoutContainer_2.setBorders(false);

		cpInsr2101.add(layoutContainer);
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
		cpGrid.setSize(864, 375);

		insr1500GridPanel = new MSFGridPanel(insr1500Def, false, false, false,false, false);
		insr1500GridPanel.setHeaderVisible(false);
		insr1500GridPanel.setBodyBorder(true);
		insr1500GridPanel.setBorders(true);
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("", 1, 7));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("장애인", 1, 3));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 11, new HeaderGroupConfig("외국인", 1, 3));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 14, new HeaderGroupConfig("", 1, 2));
		
		final Grid insr1400Grid = insr1500GridPanel.getMsfGrid().getGrid();
		insr1400Grid.addListener(Events.Select, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				if (insr1500GridPanel.getCurrentlySelectedItem() != null) {
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		});
		
		insr1400Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
	    	 public void handleEvent(BaseEvent be) {
	    		 if (insr1500GridPanel.getCurrentlySelectedItem() != null) {
	    			 
	    			 insr1500GridPanel.setGridRowFormBind(insr1500GridPanel.getCurrentlySelectedItem());
	    			 setRecord(insr1500GridPanel.getCurrentlySelectedItem());
	    			 setFormDataMapping();
				 }
			 }
		 }); 

		cpGrid.add(insr1500GridPanel);

		lcStdGrid.add(cpGrid);

		return lcStdGrid;

	}
	    
	private void setFormDataMapping() {
    }
	
	public void reload() {
		formInit();
		IColumnFilter filters = null;
		insr1500GridPanel.getTableDef().setTableColumnFilters(filters);

		insr1500GridPanel.getTableDef().addColumnFilter("dpobCd",MSFSharedUtils.allowNulls(dpobCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); // 사업장코드
		insr1500GridPanel.getTableDef().addColumnFilter("systemkey",MSFSharedUtils.allowNulls(systemkey.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); /** column SYSTEMKEY : systemkey */
		insr1500GridPanel.getTableDef().addColumnFilter("famyAqtnLssDt",MSFSharedUtils.allowNulls(famyAqtnLssDt.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); /** column 사회보험작성일자 : famyAqtnLssDt */
		insr1500GridPanel.getTableDef().addColumnFilter("famyAqtnLssNum",MSFSharedUtils.allowNulls(famyAqtnLssNum.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); /** column 사회보험취득_고용_일련번호 : famyAqtnLssNum */

		insr1500GridPanel.reload();

		actionDatabase = ActionDatabase.CUSTOM;
	}
			
	// 폼초기화 검색조건포함
	private void formInit() {

		insr1500GridPanel.getMsfGrid().clearData();
		actionDatabase = ActionDatabase.CUSTOM;
	}
	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// @Override
			public void handleEvent(BaseEvent be) {
				reload();
			}
		});
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public void onSuccessSave() {
	}

	public void setRecord(BaseModel record) {
	       this.record = record;
	}
	
	public void setListRecord(Iterator<Record> records) {
        this.records = records;
     } 
	
	//대상자 선택(insert)
	private void insertInsr1550() {
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
            return;
        }
		PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
		sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
		sysComPsnl0115Dto.setSystemkey(systemkey.getValue());

		MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto);  //인사  
		
		final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
		
		popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
				if (mapModels != null) { 
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
					List<Insr1550DTO> listInsr1550dto = new ArrayList<Insr1550DTO>();  
					
					while (iterRecords.hasNext()) {
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						Insr1550DTO insr1550Dto = new Insr1550DTO();  
						insr1550Dto.setFamyAqtnLssNum(Long.parseLong(socInsrAqtnEmymtNum.getValue())); // 취득일련번호
						insr1550Dto.setFamyAqtnLssDt(soctyInsurCmptnDt.getValue()); //사회보험 취득일자
						insr1550Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						insr1550Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						insr1550Dto.setFamySeilNum((Long)bmMapModel.get("famySeilNum"));    /** column 급여가족사항일련번호 : famySeilNum */
						insr1550Dto.setFamyResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum")));    /** column 급여가족주민번호 : famyResnRegnNum */
						insr1550Dto.setFamySecRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("famySecRegnNum")));    /** column 급여가족주민번호 : famyResnRegnNum */
						insr1550Dto.setFamyNm(MSFSharedUtils.allowNulls(bmMapModel.get("famyNm")));    /** column 한글성명 : hanNm */
						insr1550Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));    /** column 가족관계구분코드 : famyRelaDivCd */
						insr1550Dto.setDbpsnAssttnSgnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dabtyDivCd"))); //장애인 구분코드
						insr1550Dto.setDbpsnGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("dabtyGrdeCd"))); //장애인 등급코드
						insr1550Dto.setDbpsnNatnCd(MSFSharedUtils.allowNulls(bmMapModel.get("natnCd"))); //국적코드
						insr1550Dto.setAqtnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("aqtnDt"),"yyyyMMdd"));    /** column 피부양자취득일자 : aqtnDt */
						
						insr1550Dto.setInsrDpobNm(payMangeDeptNm.getValue()); //건강보험사업장명
						insr1550Dto.setInsrDpobNum(hlthInsrSym.getValue()); //건강보험사업장관리번호
						insr1550Dto.setInsrDpobPhnNum(insrDpobPhnNum.getValue()); //건강보험사업장전화번호
						insr1550Dto.setInsrUsePhnNum(insrUsePhnNum.getValue()); //건강보험가입자전화번호
						
						insr1550Dto.setAqtnDivCd("I0100001"); //취득구분 > 취득
						insr1550Dto.setAqtnReasCd("I0110005"); //취득사유 > 직장가입자취득
						
						listInsr1550dto.add(insr1550Dto);
					}
					
					actionDatabase = ActionDatabase.INSERT;
					insrP210001Service.activityOnInsr1500(listInsr1550dto, actionDatabase, new AsyncCallback<Long>() {
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
									MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1500(" + actionDatabase.name() + ") : " + caught), null);
                        }
                        public void onSuccess(Long result) {  
                        	reload();
                        }
                    });
					   
				}  
			}
		});
	}
	
	//insr15501600FormSave
	private void insr15501600FormSave() {
		
		boolean doActionYn = true;
		
		if (MSFSharedUtils.paramNotNull(records)) {
	         
            List<Insr1550DTO> listInsr1550dto = new ArrayList<Insr1550DTO>();  
             
             while (records.hasNext()) {
            	 
                 Record record = (Record) records.next(); 
                 BaseModel bmMapModel = (BaseModel)record.getModel();
                   
                 Insr1550DTO insr1550Dto = new Insr1550DTO();
                 
                 insr1550Dto.setFamySeilNum((Long)bmMapModel.get("famySeilNum"));    /** column 급여가족사항일련번호 : famySeilNum */
                 insr1550Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                 insr1550Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                 insr1550Dto.setFamyAqtnLssDt(MSFSharedUtils.allowNulls(bmMapModel.get("famyAqtnLssDt")));    /** column 피부양자취득상실신고작성일자 : famyAqtnLssDt */
                 insr1550Dto.setFamyAqtnLssNum((Long)bmMapModel.get("famyAqtnLssNum"));    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
                 
                 insr1550Dto.setAqtnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aqtnDivCd$commCd"))); //취득구분 > 취득

                 insr1550Dto.setAqtnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("aqtnDt"),"yyyyMMdd"));    /** column 피부양자취득일자 : aqtnDt */
                 insr1550Dto.setAqtnReasCd(MSFSharedUtils.allowNulls(bmMapModel.get("aqtnReasCd$commCd")));    /** column 피부양자취득사유코드 : aqtnReasCd */
                 insr1550Dto.setDbpsnAssttnSgnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dbpsnAssttnSgnCd$commCd")));    /** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
                 insr1550Dto.setDbpsnGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("dbpsnGrdeCd$commCd")));    /** column 장애인_등급코드 : dbpsnGrdeCd */
                 insr1550Dto.setDbpsnRgstnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("dbpsnRgstnDt"),"yyyyMMdd"));    /** column 장애인_등록일자 : dbpsnRgstnDt */                 
                 insr1550Dto.setFrgnrStyQftntCd(MSFSharedUtils.allowNulls(bmMapModel.get("frgnrStyQftntCd$commCd")));    /** column 외국인_체류자격코드 : frgnrStyQftntCd */
                 insr1550Dto.setFrgnrStyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("frgnrStyBgnnDt"),"yyyyMMdd"));    /** column 외국인_체류시작일자 : frgnrStyBgnnDt */
                 insr1550Dto.setFrgnrStyEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("frgnrStyEndDt"),"yyyyMMdd"));    /** column 외국인_체류종료일자 : frgnrStyEndDt */
                 
                 insr1550Dto.setSocrAqtnFamyYn(MSFSharedUtils.allowNulls(bmMapModel.get("socrAqtnFamyYn"))); //취득신고 여부
                 insr1550Dto.setSocrLssFamyYn(MSFSharedUtils.allowNulls(bmMapModel.get("socrLssFamyYn"))); //상실신고 여부
                 
                 //취득/상실 신고가 완료된 데이터는 수정/삭제 불가
                 if( "I0100001".equals(insr1550Dto.getAqtnDivCd()) ) {
                	 if( "Y".equals(insr1550Dto.getSocrAqtnFamyYn()) ) {
                		 doActionYn = false;
                	 }
                 }
                 else if( "I0100002".equals(insr1550Dto.getAqtnDivCd()) ) {
                	 if( "Y".equals(insr1550Dto.getSocrLssFamyYn()) ) {
                		 doActionYn = false;
                	 }                	 
                 }
                 
                 listInsr1550dto.add(insr1550Dto);
             }  
           
           if (doActionYn) {

        	   insrP210001Service.activityOnInsr1500(listInsr1550dto, actionDatabase, new AsyncCallback<Long>(){
        		   public void onFailure(Throwable caught) {
        			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
        					   MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr3200(" + actionDatabase.name() + ") : " + caught), null);
        		   }
        		   public void onSuccess(Long result) { 
        			   if (result == 0) {
        				   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
        						   actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
        			   } else {
		        		   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		        		   actionDatabase + "처리가 "+result+"건 완료 되었습니다.", null);
		        		   insr1500GridPanel.reload();
		        		   actionDatabase = ActionDatabase.UPDATE;
        			   } 
        		   } 
    		   }); 
           }
           else {
        	   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
					   actionDatabase + "신고 완료된 데이터는 수정/삭제를 할수없습니다. 데이타를 확인하십시요.", null);
        	   insr1500GridPanel.reload();
           }
       }
       else {
           MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
           return;
       }
		        
	}
}
