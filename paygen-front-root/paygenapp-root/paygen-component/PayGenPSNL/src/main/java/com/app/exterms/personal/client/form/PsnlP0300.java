package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.dto.InfcComBass0500DTO;
import com.app.exterms.personal.client.dto.Psnl0300DTO;
import com.app.exterms.personal.client.form.defs.Psnl0300Def;
import com.app.exterms.personal.client.service.InfcPkgPsnl0100Service;
import com.app.exterms.personal.client.service.InfcPkgPsnl0100ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0300Service;
import com.app.exterms.personal.client.service.Psnl0300ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0400Service;
import com.app.exterms.prgm.client.service.PrgmComBass0400ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
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
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class PsnlP0300  extends MSFPanel { 
	
	private static InfcPkgPsnl0100ServiceAsync psnl0100Service = InfcPkgPsnl0100Service.Util.getInstance();
	
	//발령후 시작
	private static ComboBox<BaseModel> afterCurrDeptCd;		//부서
	private static ComboBox<BaseModel> afterBusinCd;	  	//사업명
	private static ComboBox<BaseModel> afterTypOccuCd;  	//직종
	private static ComboBox<BaseModel> afterDtilOccuInttnCd;// 직종세
	private static ComboBox<BaseModel> afterLogSvcYrNumCd; 	//근속년수
	private static ComboBox<BaseModel> afterOdtyCd; 		//직책
	private static TextField<String> afterAppmtIstut;		//발령기관
	private static TextField<String> afterAppmtBssCtnt;  	//발령근거내용
	private static DateField afterAppmtDt;					//발령일자
	//발령후 끝
	private static boolean mutilCombo = false;
	private static Psnl0300Def psnl0300Def  = new Psnl0300Def("PSNLP0300");   //그리드 테이블 컬럼 define  
	private static MSFGridPanel psnl0300GridPanel;
    private static Iterator<Record> recordsIter;
	// -------------- 그리드 선언 끝 --------------
	
	private static HiddenField<String> appmtDivCdStr;
	private static HiddenField<String> emymtDivCdStr;
	private static HiddenField<String> deptCdStr;
	private static HiddenField<String> businCdStr;
	private static HiddenField<String> typOccuCdStr;
	private static PrgmComBass0350DTO sysComBass0350Dto; 		// 직종세
	private static ListStore<BaseModel> lsDtilOccuInttnCd 		= new ListStore<BaseModel>();	// 직종세
	
	private static PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();
	private static PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	
	//private static ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>(); //직종
	//private static ListStore<BaseModel> listStoreA015 = new ListStore<BaseModel>(); //직책
	//private static ListStore<BaseModel> listStoreA007 = new ListStore<BaseModel>(); //근속년수
	//private static ListStore<BaseModel> listStoreBass0400All = new ListStore<BaseModel>(); // 소속부서 전체 데이타
	
	private static Grid<Psnl0300DTO> psnl0300Grid;
	
	private static Psnl0300ServiceAsync psnl0300Service = Psnl0300Service.Util.getInstance();
	private static RpcProxy<BaseListLoadResult<Psnl0300DTO>> psnl0300Proxy = new RpcProxy<BaseListLoadResult<Psnl0300DTO>>() {
		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0300DTO>> callback) {
			
			BaseListLoadConfig config = (BaseListLoadConfig) loadConfig;
			
			Psnl0300DTO dto = new Psnl0300DTO();
			
			dto.setAppmtDivCd(config.get("appmtDivCd")+"");
			dto.setDeptCd(config.get("deptCd")+"");
			dto.setBusinCd(config.get("businCd")+"");
			dto.setTypOccuCd(config.get("typOccuCd")+"");
			
			psnl0300Service.selectPsnlP0300(config, dto, callback);
			
		}
		
	};
	private static BaseListLoader<BaseListLoadResult<ModelData>> loaderPsnl0300 = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0300Proxy);
	private static ListStore<Psnl0300DTO> storePsnl0300 = new ListStore<Psnl0300DTO>(loaderPsnl0300);
	


	
	public static Dialog getPsnlP0300Form(final String appmtDivCd,
										  final String emymtDivCd,
										  final String deptCd,
										  final String businCd,
										  final String typOccuCd, 
										  final String appmtDivCdNm,
										  final String emymtDivCdNm,
										  final String deptCdNm,
										  final String businCdNm,
										  final String typOccuCdNm,
										  final ListStore<BaseModel> listStoreA041,
										  final ListStore<BaseModel> listStoreA007,
										  final ListStore<BaseModel> listStoreA015,
										  final ListStore<BaseModel> listStoreBass0400All
			){
		 sysComBass0350Dto = new PrgmComBass0350DTO();
		 //--------------------직종 코드 불러 오는 함수 --------------------------------------------------
	     lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	     //--------------------직종 코드 불러 오는 함수 --------------------------------------------------
		
		/*
		List<String> arrRpsttvCd = new ArrayList<String>();
		arrRpsttvCd.add("A041");
		arrRpsttvCd.add("A015");
		arrRpsttvCd.add("A007");
		PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
		sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
		sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
			@Override
			public void onSuccess(HashMap<String, List<BaseModel>> result) {
				if(result != null && result.size() > 0){
					listStoreA041.add(result.get("A041"));
					listStoreA007.add(result.get("A007"));
					listStoreA015.add(result.get("A015"));
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("", "공통코드 에러!", null);
			}
		});
		
		sysComBass0400Service.getPrgmComDeptBass0400List(new PrgmComBass0400DTO(),new AsyncCallback<List<BaseModel>>() {
			@Override
			public void onSuccess(List<BaseModel> result) {
				listStoreBass0400All.add(result);
			}
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
		*/
		final Dialog complex = new Dialog();
		complex.setBodyBorder(false);
		//complex.setHeadingHtml("교육일괄등록");
		complex.setWidth(800);  
	    complex.setHeight(600);  
	    complex.setHideOnButtonClick(false);
	    complex.setButtons("저장");
	    complex.setStyleAttribute("padding", "10px");
	    
	    BorderLayout layout = new BorderLayout();
	    
	    complex.setLayout(layout); 
	    
	    
	    BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);  
	    
	    LayoutContainer lc = new LayoutContainer(new ColumnLayout());
	    
	    LayoutContainer lc1 = new LayoutContainer();
	    FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(70);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl1);
	    
		TextField<String> appmtDivCdText = new TextField<String>();
		appmtDivCdText.setFieldLabel("발령구분");
		appmtDivCdText.setReadOnly(true);
		appmtDivCdText.setEnabled(false);
		appmtDivCdText.setValue(appmtDivCdNm);
		
		lc1.add(appmtDivCdText, new FormData("100%"));
		
		LayoutContainer lc5 = new LayoutContainer();
	    FormLayout fl5 = new FormLayout();
		fl5.setLabelWidth(65);
		fl5.setLabelAlign(LabelAlign.RIGHT);
		lc5.setLayout(fl5);
		
		TextField<String> emymtDivCdText = new TextField<String>();
		emymtDivCdText.setFieldLabel("고용구분");
		emymtDivCdText.setReadOnly(true);
		emymtDivCdText.setEnabled(false); 
		emymtDivCdText.setValue(emymtDivCdNm);
		
		lc5.add(emymtDivCdText, new FormData("100%"));
		
		
		LayoutContainer lc2 = new LayoutContainer();
	    FormLayout fl2 = new FormLayout();
		fl2.setLabelWidth(60);
		fl2.setLabelAlign(LabelAlign.RIGHT);
		lc2.setLayout(fl2);
	    
		TextField<String> deptCdText = new TextField<String>();
		deptCdText.setFieldLabel("부서");
		deptCdText.setReadOnly(true);
		deptCdText.setEnabled(false);
		deptCdText.setValue(deptCdNm);
		
		lc2.add(deptCdText, new FormData("100%"));
		
		LayoutContainer lc3 = new LayoutContainer();
	    FormLayout fl3 = new FormLayout();
		fl3.setLabelWidth(60);
		fl3.setLabelAlign(LabelAlign.RIGHT);
		lc3.setLayout(fl3);
	    
		TextField<String> businCdText = new TextField<String>();
		businCdText.setFieldLabel("사업명");
		businCdText.setReadOnly(true);
		businCdText.setEnabled(false);
		businCdText.setValue(businCdNm);
		
		lc3.add(businCdText, new FormData("100%"));
		
		LayoutContainer lc4 = new LayoutContainer();
	    FormLayout fl4 = new FormLayout();
		fl4.setLabelWidth(60);
		fl4.setLabelAlign(LabelAlign.RIGHT);
		lc4.setLayout(fl4);
	    
		TextField<String> typOccuCdText = new TextField<String>();
		typOccuCdText.setFieldLabel("직종");
		typOccuCdText.setReadOnly(true);
		typOccuCdText.setEnabled(false);
		typOccuCdText.setValue(typOccuCdNm);
		
		lc4.add(typOccuCdText, new FormData("100%"));
		
		
		lc.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lc.add(lc5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
		lc.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		lc.add(lc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lc.add(lc4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	    
		lc.setBorders(true);
		
	    ContentPanel panel = new ContentPanel(); 
	    panel.setHeadingHtml("일괄발령");
//	    panel.setHeadingText("일괄발령");
	    panel.setStyleAttribute("padding", "10px");
	    
		appmtDivCdStr = new HiddenField<String>();
		appmtDivCdStr.setName("appmtDivCdStr");
		appmtDivCdStr.setValue(appmtDivCd);
		panel.add(appmtDivCdStr);
		
		emymtDivCdStr = new HiddenField<String>();
		emymtDivCdStr.setName("emymtDivCdStr");
		emymtDivCdStr.setValue(emymtDivCd);
		panel.add(emymtDivCdStr);
		
		deptCdStr = new HiddenField<String>();
		deptCdStr.setName("deptCdStr");
		deptCdStr.setValue(deptCd);
		panel.add(deptCdStr);
		
		businCdStr = new HiddenField<String>();
		businCdStr.setName("businCdStr");
		businCdStr.setValue(businCd);
		panel.add(businCdStr);
		
		typOccuCdStr = new HiddenField<String>();
		typOccuCdStr.setName("typOccuCdStr");
		typOccuCdStr.setValue(typOccuCd);
		panel.add(typOccuCdStr);
		
		
		
	    panel.add(lc, new BorderLayoutData(LayoutRegion.CENTER));
	    
	    FieldSet afterIssueFieldSet = new FieldSet();
		afterIssueFieldSet.setHeadingHtml("발령후");
		//afterIssueFieldSet.setSize(790, 110);
		
		LayoutContainer afterlc = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer afterlc1 = new LayoutContainer();
		FormLayout afterfl1 = new FormLayout();
		afterfl1.setLabelWidth(60);
		afterfl1.setLabelAlign(LabelAlign.RIGHT);
		afterlc1.setLayout(afterfl1);
		afterCurrDeptCd = new ComboBox<BaseModel>();
		afterCurrDeptCd.setFieldLabel("부서");
		afterCurrDeptCd.setForceSelection(true);
		afterCurrDeptCd.setMinChars(1);
		afterCurrDeptCd.setDisplayField("deptNmRtchnt");
		afterCurrDeptCd.setValueField("deptCd");
		afterCurrDeptCd.setTriggerAction(TriggerAction.ALL);
		afterCurrDeptCd.setEmptyText("--부서선택--");
		afterCurrDeptCd.setSelectOnFocus(true);
		afterCurrDeptCd.setStore(listStoreBass0400All);
		afterCurrDeptCd.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				if(MSFConfiguration.EMYMT_DIVCD01.equals(emymtDivCdStr.getValue())) {
//					afterBusinCd.setReadOnly(true);
					afterBusinCd.setEnabled(true);
				}else {
//					afterTypOccuCd.setReadOnly(true);
//					afterDtilOccuInttnCd.setReadOnly(true);
					
					afterTypOccuCd.setEnabled(true);
					afterDtilOccuInttnCd.setEnabled(true);
					
					if(afterCurrDeptCd.getValue() != null){
						InfcComBass0500DTO dto = new InfcComBass0500DTO();
						dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));
						dto.setDeptCd(String.valueOf(afterCurrDeptCd.getValue().get("deptCd")));
						
						psnl0100Service.getBusinList(dto, new AsyncCallback<List<BaseModel>>() {
							
							@Override
							public void onSuccess(List<BaseModel> result) {
								ListStore<BaseModel> ls = new ListStore<BaseModel>();
								ls.add(result);
								afterBusinCd.setStore(ls);
								afterBusinCd.setEmptyText("--사업명선택--");
								afterBusinCd.setValue(new BaseModel());
							}
							
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert("", "사업코드 에러!", null);
							}
						});
						
					}else{
						afterBusinCd.setStore(new ListStore<BaseModel>());
						afterBusinCd.setEmptyText("--부서선택--");
						afterBusinCd.setValue(new BaseModel());
					}
				}
				
			}
		});
		afterlc1.add(afterCurrDeptCd, new FormData("100%"));
		
		afterTypOccuCd = new ComboBox<BaseModel>();
		afterTypOccuCd.setFieldLabel("직종");
		afterTypOccuCd.setForceSelection(true);
		afterTypOccuCd.setMinChars(1);
		afterTypOccuCd.setDisplayField("typOccuNm");
		afterTypOccuCd.setValueField("typOccuCd");
		afterTypOccuCd.setTriggerAction(TriggerAction.ALL);
		afterTypOccuCd.setEmptyText("--직종선택--");
		afterTypOccuCd.setSelectOnFocus(true);
		afterTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
            	BaseModel bmPayYr =  se.getSelectedItem(); 
            	if (bmPayYr != null) {
    				if (MSFConfiguration.EMYMT_DIVCD01.equals(emymtDivCdStr.getValue())) {
    					
    					sysComBass0350Dto = new PrgmComBass0350DTO();
//    					sysComBass0350Dto.setPayrMangDeptCd(MSFMainApp.get().get);
    					//직종변경에 따른 직종세 값 가져오기
    					String strTypOccuCd = PersonalUtil.getSelectedComboValue(afterTypOccuCd,"typOccuCd"); 
    					sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
    					// sysComBass0350Dto.setPyspGrdeCd(RemtUtils.getStrValToBMMultiCombo(lsTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
    					sysComBass0350Dto.setDtilOccuClsUseYn("A");           
    					lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto); 
    					afterDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
    					sysComBass0350Dto.setDtilOccuClsUseYn("");
    					
    				} else {
    		                   
    				} 
            	}       
            } 
        });  
		afterTypOccuCd.setStore(listStoreA041);
		
		afterlc1.add(afterTypOccuCd, new FormData("100%"));
		
//		afterOdtyCd = new ComboBox<BaseModel>();
//		afterOdtyCd.setFieldLabel("직책");
//		afterOdtyCd.setForceSelection(true);
//		afterOdtyCd.setMinChars(1);
//		afterOdtyCd.setDisplayField("commCdNm");
//		afterOdtyCd.setValueField("commCd");
//		afterOdtyCd.setTriggerAction(TriggerAction.ALL);
//		afterOdtyCd.setEmptyText("--직책선택--");
//		afterOdtyCd.setSelectOnFocus(true);
//		afterOdtyCd.setStore(listStoreA015);
//		
//		afterlc1.add(afterOdtyCd, new FormData("100%"));
		
		afterAppmtIstut = new TextField<String>();
		afterAppmtIstut.setFieldLabel("발령기관");
		afterlc1.add(afterAppmtIstut, new FormData("100%"));
		
		LayoutContainer afterlc2 = new LayoutContainer();
		FormLayout afterfl2 = new FormLayout();
		afterfl2.setLabelWidth(80);
		afterfl2.setLabelAlign(LabelAlign.RIGHT);
		afterlc2.setLayout(afterfl2);
		afterBusinCd = new ComboBox<BaseModel>();
		afterBusinCd.setFieldLabel("사업");
		afterBusinCd.setForceSelection(true);
		afterBusinCd.setMinChars(1);
		afterBusinCd.setDisplayField("businYearNm");
		afterBusinCd.setValueField("businCd");
		afterBusinCd.setTriggerAction(TriggerAction.ALL);
		afterBusinCd.setEmptyText("--부서선택--");
		afterBusinCd.setSelectOnFocus(true);
		afterBusinCd.setStore(new ListStore<BaseModel>());
		afterlc2.add(afterBusinCd, new FormData("100%"));
		
		
		
		/** column 직종세코드 : dtilOccuInttnCd */
		afterDtilOccuInttnCd = new ComboBox<BaseModel>();
		afterDtilOccuInttnCd.setFieldLabel("직종세");
		afterDtilOccuInttnCd.setName("afterDtilOccuInttnCd");
		afterDtilOccuInttnCd.setEmptyText("--직종세선택--");
		afterDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
		afterDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
		afterDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
	    //creDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	    //creDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		afterDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	        @Override
	        public void handleEvent(ComponentEvent ce) {    
	            if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
	                mutilCombo = true;
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
	                mutilCombo = true;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
	                mutilCombo = false;
	              //  GWT.log(" b" + ce.getEvent().getType());
	            } else {
	               
	            }  
	        
	        } 
	    });		

	    afterlc2.add(afterDtilOccuInttnCd, new FormData("100%"));		
//		afterLogSvcYrNumCd = new ComboBox<BaseModel>();
//		afterLogSvcYrNumCd.setFieldLabel("근속년수");
//		afterLogSvcYrNumCd.setForceSelection(true);
//		afterLogSvcYrNumCd.setMinChars(1);
//		afterLogSvcYrNumCd.setDisplayField("commCdNm");
//		afterLogSvcYrNumCd.setValueField("commCd");
//		afterLogSvcYrNumCd.setTriggerAction(TriggerAction.ALL);
//		afterLogSvcYrNumCd.setEmptyText("--년수선택--");
//		afterLogSvcYrNumCd.setSelectOnFocus(true);
//		afterLogSvcYrNumCd.setStore(listStoreA007);
//		afterlc2.add(afterLogSvcYrNumCd, new FormData("100%"));
		
		afterAppmtBssCtnt = new TextField<String>();
		afterAppmtBssCtnt.setFieldLabel("발령근거내용");
		afterlc2.add(afterAppmtBssCtnt, new FormData("100%"));
		
		LayoutContainer afterlc3 = new LayoutContainer();
		FormLayout afterfl3 = new FormLayout();
		afterfl3.setLabelWidth(80);
		afterfl3.setLabelAlign(LabelAlign.RIGHT);
		afterlc3.setLayout(afterfl3);
		
		afterOdtyCd = new ComboBox<BaseModel>();
		afterOdtyCd.setFieldLabel("직책");
		afterOdtyCd.setForceSelection(true);
		afterOdtyCd.setMinChars(1);
		afterOdtyCd.setDisplayField("commCdNm");
		afterOdtyCd.setValueField("commCd");
		afterOdtyCd.setTriggerAction(TriggerAction.ALL);
		afterOdtyCd.setEmptyText("--직책선택--");
		afterOdtyCd.setSelectOnFocus(true);
		afterOdtyCd.setStore(listStoreA015);
		
		afterlc3.add(afterOdtyCd, new FormData("100%"));
		
//		afterTypOccuCd = new ComboBox<BaseModel>();
//		afterTypOccuCd.setFieldLabel("직종");
//		afterTypOccuCd.setForceSelection(true);
//		afterTypOccuCd.setMinChars(1);
//		afterTypOccuCd.setDisplayField("typOccuNm");
//		afterTypOccuCd.setValueField("typOccuCd");
//		afterTypOccuCd.setTriggerAction(TriggerAction.ALL);
//		afterTypOccuCd.setEmptyText("--직종선택--");
//		afterTypOccuCd.setSelectOnFocus(true);
//		afterTypOccuCd.setStore(listStoreA041);
//		
//		afterlc3.add(afterTypOccuCd, new FormData("100%"));
		
		afterLogSvcYrNumCd = new ComboBox<BaseModel>();
		afterLogSvcYrNumCd.setFieldLabel("근속년수");
		afterLogSvcYrNumCd.setForceSelection(true);
		afterLogSvcYrNumCd.setMinChars(1);
		afterLogSvcYrNumCd.setDisplayField("commCdNm");
		afterLogSvcYrNumCd.setValueField("commCd");
		afterLogSvcYrNumCd.setTriggerAction(TriggerAction.ALL);
		afterLogSvcYrNumCd.setEmptyText("--년수선택--");
		afterLogSvcYrNumCd.setSelectOnFocus(true);
		afterLogSvcYrNumCd.setStore(listStoreA007);
		afterlc3.add(afterLogSvcYrNumCd, new FormData("100%"));
		
//		afterAppmtDt = new DateField();
//		afterAppmtDt.setFieldLabel("발령일자");
//		afterAppmtDt.setValue(new Date());
//		new DateFieldMask(afterAppmtDt, "9999.99.99"); 
//		afterAppmtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		afterlc3.add(afterAppmtDt, new FormData("100%"));
		
		LayoutContainer afterlc31 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer afterlcDt = new LayoutContainer();
		
		afterfl3 = new FormLayout();
		afterfl3.setLabelWidth(80);
		afterfl3.setLabelAlign(LabelAlign.RIGHT);
		afterlcDt.setLayout(afterfl3);
		
		afterAppmtDt = new DateField();
		afterAppmtDt.setFieldLabel("발령일자");
		afterAppmtDt.setValue(new Date());
		new DateFieldMask(afterAppmtDt, "9999.99.99"); 
		afterAppmtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		afterlcDt.add(afterAppmtDt, new FormData("100%"));
		
		afterlc31.add(afterlcDt, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.81));
		
		
		LayoutContainer afterlcBtn = new LayoutContainer();
		
		ButtonBar buttonConfirm = new ButtonBar();
		buttonConfirm.setAlignment(HorizontalAlignment.RIGHT);
		Button confirm = new Button("확정");
		confirm.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				
				MessageBox.confirm("발령 확정", "선택한 인원을 발령하시겠습니까?",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
		                	Iterator<BaseModel> itBm  = psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
		                    
		                	List<Record>  lsRec  = new ArrayList<Record>();
		                	
//		                	if (itBm.size() <= 0) {
//		        				MessageBox.alert("확정",  "확정할 데이터를 선택해 주세요.", null);
//		        				return;
//		        			}else {
		        				
		        				while(itBm.hasNext()) {
		                    		Record rec  = new Record(itBm.next()); 
		                    		lsRec.add(rec);
		                    	} 
		                    	setListRecord(lsRec.iterator()); 
		                    	
		                    	
		                    	if(MSFSharedUtils.paramNotNull(recordsIter)) {
		                    		
		                    		List<Psnl0300DTO> list = new ArrayList<Psnl0300DTO>();  
		                    		
		                    		while(recordsIter.hasNext()) {
		                    			
		                    			Record record = (Record) recordsIter.next(); 
		                                BaseModel bmMapModel = (BaseModel)record.getModel();
		                    			
		                                Psnl0300DTO psnl0300Dto = new Psnl0300DTO();
		                                
		                                
		                                psnl0300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
		                                psnl0300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   	 		/** column SYSTEMKEY : systemkey */
		                                psnl0300Dto.setAppmtNum(MSFSharedUtils.allowNulls(bmMapModel.get("appmtNum")));    				/** column 발령번호 : appmtNum */
		                                psnl0300Dto.setAppmtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDivCd")));    			/** column 발령구분코드 : appmtDivCd */
		                                psnl0300Dto.setAppmtDt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDt")));    				/** column 발령일자 : appmtDt */
		                                psnl0300Dto.setAppmtBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtBssCtnt")));    		/** column 발령근거내용 : appmtBssCtnt */
		                                psnl0300Dto.setAppmtIstut(MSFSharedUtils.allowNulls(bmMapModel.get("appmtIstut")));    			/** column 발령기관 : appmtIstut */
		                                psnl0300Dto.setBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("bgnnDt")));    					/** column 시작일자 : bgnnDt */
		                                psnl0300Dto.setEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("endDt")));    					/** column 종료일자 : endDt */
		                                psnl0300Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    					/** column 부서코드 : deptCd */
		                                psnl0300Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    				/** column 사업코드 : businCd */
		                                psnl0300Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));   			/** column 직종코드 : typOccuCd */
		                                psnl0300Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    					/** column 직책코드 : odtyCd */
		                                psnl0300Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    					/** column 호봉코드 : pyspCd */
		                                psnl0300Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    			/** column 호봉등급코드 : pyspGrdeCd */
		                                psnl0300Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    	/** column 근속년수코드 : logSvcYrNumCd */
		                                psnl0300Dto.setDsnyActDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActDivCd")));    		/** column 징계구분코드 : dsnyActDivCd */
		                                psnl0300Dto.setCtwpMnthNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("ctwpMnthNum"), "0"))) ;	/** column 감봉월수 : ctwpMnthNum */
		                                psnl0300Dto.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pernAppmtNoteCtnt")));	/** column 인사발령비고내용 : pernAppmtNoteCtnt */
		                                psnl0300Dto.setAppmtSeilNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("appmtSeilNum"), "0")));	/** column 발령일련번호 : appmtSeilNum */
		                                psnl0300Dto.setTypOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuInttnCd")));    		/** column 직종통합코드 : typOccuInttnCd */
		                                psnl0300Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    	/** column 직종세구분코드 : dtilOccuClsDivCd */
		                                psnl0300Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    	/** column 직종세통합구분코드 : dtilOccuInttnCd */
		                                psnl0300Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    	/** column 근속월수코드 : logSvcMnthIcmCd */
		                                
		                                
		                                
		                                psnl0300Dto.setAftBusinCd(PersonalUtil.getSelectedComboValue(afterBusinCd, "businCd")); 						//사업 
		                                psnl0300Dto.setAftDeptCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd")); 						//부서
		                                psnl0300Dto.setAftTypOccuDivCd(PersonalUtil.getSelectedComboValue(afterTypOccuCd, "typOccuCd")); 				//직종
		                                psnl0300Dto.setAftDtilOccuInttnCd(PersonalUtil.getSelectedComboValue(afterDtilOccuInttnCd, "dtilOccuInttnCd"));	//직종세
		                                psnl0300Dto.setAftLogSvcYrNumCd(PersonalUtil.getSelectedComboValue(afterLogSvcYrNumCd)); 						//근속년수
		                                psnl0300Dto.setAftOdtyDivCd(PersonalUtil.getSelectedComboValue(afterOdtyCd)); 									//직책
		                                psnl0300Dto.setAppmtIstut(afterAppmtIstut.getValue());
		                                psnl0300Dto.setAppmtBssCtnt(afterAppmtBssCtnt.getValue());
										//후 호봉코드는 비워둠, 후 호봉등급은 전 호봉등급으로 같이 등록
		                                psnl0300Dto.setAppmtDt(PersonalUtil.getConvertDateToString(afterAppmtDt, "yyyyMMdd"));
		                                
		                                psnl0300Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    				/** column 고용구분코드 : emymtDivCd */
		                                
		                                
//		                                MessageBox.info("경고",  psnl0300Dto.getAftTypOccuDivCd() + "||" + psnl0300Dto.getAftDtilOccuInttnCd(), null);
		                                
		                                list.add(psnl0300Dto);
		                    		}
		                    		
		                    		if(list.size() > 0) {
		                    			
		                    			psnl0300Service.appointmentSaveList(list, new AsyncCallback<Integer>() {
											@Override
											public void onSuccess(Integer result) {
												
												if(result <= 0) {
													MessageBox.info("경고", "확정된 발령 데이터가 없습니다.", null);
												}else {
													MessageBox.info("알림", "총 " + result + " 건의 발령이 확정되었습니다.", null);
													psnl0300Gridreload();
												}
//												loadConfig.set("appmtDivCd", appmtDivCd);
//												loadConfig.set("deptCd", deptCd);
//												loadConfig.set("businCd", businCd);
//												loadConfig.set("typOccuCd", typOccuCd);
//												loaderPsnl0300.load(loadConfig);
												
											}
											@Override
											public void onFailure(Throwable caught) {
												MessageBox.alert("에러", "발령 확정 에러 : " + caught, null);
											}
										});
		                    			
		                    		}else {
		                    			MessageBox.alert("확정",  "확정할 데이터를 선택해 주세요.", null);
				        				return;
		                    		}
		                    		
		                    	}else {
		                    		MessageBox.alert("확정",  "확정할 데이터를 선택해 주세요.", null);
			        				return;
		                    	}
//		        			}
							
//							List<Psnl0300DTO> list = psnl0300Grid.getSelectionModel().getSelectedItems();
//							
//							if(list.size() > 0){
//								for(int i = 0; i < list.size(); i++){
//									list.get(i).setAppmtDivCd(appmtDivCd);
//									//발령전 데이터는 현재 데이터로 select into 처리
//									//발령후 시작
//									list.get(i).setAftBusinCd(PersonalUtil.getSelectedComboValue(afterBusinCd, "businCd")); 	//사업 
//									list.get(i).setAftDeptCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd")); 	//부서
//									list.get(i).setAftTypOccuDivCd(PersonalUtil.getSelectedComboValue(afterTypOccuCd)); 		//직종
//									list.get(i).setAftLogSvcYrNumCd(PersonalUtil.getSelectedComboValue(afterLogSvcYrNumCd)); 	//근속년수
//									list.get(i).setAftOdtyDivCd(PersonalUtil.getSelectedComboValue(afterOdtyCd)); 				//직책
//									
//									list.get(i).setAppmtIstut(afterAppmtIstut.getValue());
//									list.get(i).setAppmtBssCtnt(afterAppmtBssCtnt.getValue());
//									//후 호봉코드는 비워둠, 후 호봉등급은 전 호봉등급으로 같이 등록
//									list.get(i).setAppmtDt(PersonalUtil.getConvertDateToString(afterAppmtDt, "yyyyMMdd"));
//								}
//							}
//							
//							psnl0300Service.appointmentSaveList(list, new AsyncCallback<String>() {
//								@Override
//								public void onSuccess(String result) {
//									MessageBox.info("", "발령이 확정되었습니다.", null);
//									
//									BaseListLoadConfig loadConfig = new BaseListLoadConfig();
//									loadConfig.set("appmtDivCd", appmtDivCd);
//									loadConfig.set("deptCd", deptCd);
//									loadConfig.set("businCd", businCd);
//									loadConfig.set("typOccuCd", typOccuCd);
//									loaderPsnl0300.load(loadConfig);
//									
//								}
//								@Override
//								public void onFailure(Throwable caught) {
//									MessageBox.alert("", "발령 확정 에러", null);
//								}
//							});
						}
					}
					
				});
				
			}
		});
		buttonConfirm.add(confirm);
		afterlcBtn.add(buttonConfirm, new FormData("100%"));
		
		afterlc31.add(afterlcBtn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
		
		afterlc3.add(afterlc31, new FormData("100%"));
		
//		ButtonBar buttonConfirm = new ButtonBar();
//		buttonConfirm.setAlignment(HorizontalAlignment.RIGHT);
//		Button confirm = new Button("확정");
//		confirm.addListener(Events.Select, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				
//				
//				MessageBox.confirm("발령 확정", "선택한 인원을 발령하시겠습니까?",new Listener<MessageBoxEvent>(){
//					@Override
//					public void handleEvent(MessageBoxEvent be) {
//						//if("Yes".equals(be.getButtonClicked().getText())){
//						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//							
//		                	Iterator<BaseModel> itBm  = psnl0300GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
//		                    
//		                	List<Record>  lsRec  = new ArrayList<Record>();
//		                	
////		                	if (itBm.size() <= 0) {
////		        				MessageBox.alert("확정",  "확정할 데이터를 선택해 주세요.", null);
////		        				return;
////		        			}else {
//		        				
//		        				while(itBm.hasNext()) {
//		                    		Record rec  = new Record(itBm.next()); 
//		                    		lsRec.add(rec);
//		                    	} 
//		                    	setListRecord(lsRec.iterator()); 
//		                    	
//		                    	
//		                    	if(MSFSharedUtils.paramNotNull(recordsIter)) {
//		                    		
//		                    		List<Psnl0300DTO> list = new ArrayList<Psnl0300DTO>();  
//		                    		
//		                    		while(recordsIter.hasNext()) {
//		                    			
//		                    			Record record = (Record) recordsIter.next(); 
//		                                BaseModel bmMapModel = (BaseModel)record.getModel();
//		                    			
//		                                Psnl0300DTO psnl0300Dto = new Psnl0300DTO();
//		                                
//		                                
//		                                psnl0300Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
//		                                psnl0300Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));   	 		/** column SYSTEMKEY : systemkey */
//		                                psnl0300Dto.setAppmtNum(MSFSharedUtils.allowNulls(bmMapModel.get("appmtNum")));    				/** column 발령번호 : appmtNum */
//		                                psnl0300Dto.setAppmtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDivCd")));    			/** column 발령구분코드 : appmtDivCd */
//		                                psnl0300Dto.setAppmtDt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtDt")));    				/** column 발령일자 : appmtDt */
//		                                psnl0300Dto.setAppmtBssCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("appmtBssCtnt")));    		/** column 발령근거내용 : appmtBssCtnt */
//		                                psnl0300Dto.setAppmtIstut(MSFSharedUtils.allowNulls(bmMapModel.get("appmtIstut")));    			/** column 발령기관 : appmtIstut */
//		                                psnl0300Dto.setBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("bgnnDt")));    					/** column 시작일자 : bgnnDt */
//		                                psnl0300Dto.setEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("endDt")));    					/** column 종료일자 : endDt */
//		                                psnl0300Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    					/** column 부서코드 : deptCd */
//		                                psnl0300Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    				/** column 사업코드 : businCd */
//		                                psnl0300Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));   			/** column 직종코드 : typOccuCd */
//		                                psnl0300Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    					/** column 직책코드 : odtyCd */
//		                                psnl0300Dto.setPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspCd")));    					/** column 호봉코드 : pyspCd */
//		                                psnl0300Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    			/** column 호봉등급코드 : pyspGrdeCd */
//		                                psnl0300Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    	/** column 근속년수코드 : logSvcYrNumCd */
//		                                psnl0300Dto.setDsnyActDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dsnyActDivCd")));    		/** column 징계구분코드 : dsnyActDivCd */
//		                                psnl0300Dto.setCtwpMnthNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("ctwpMnthNum"), "0"))) ;	/** column 감봉월수 : ctwpMnthNum */
//		                                psnl0300Dto.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pernAppmtNoteCtnt")));	/** column 인사발령비고내용 : pernAppmtNoteCtnt */
//		                                psnl0300Dto.setAppmtSeilNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(bmMapModel.get("appmtSeilNum"), "0")));	/** column 발령일련번호 : appmtSeilNum */
//		                                psnl0300Dto.setTypOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuInttnCd")));    		/** column 직종통합코드 : typOccuInttnCd */
//		                                psnl0300Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    	/** column 직종세구분코드 : dtilOccuClsDivCd */
//		                                psnl0300Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    	/** column 직종세통합구분코드 : dtilOccuInttnCd */
//		                                psnl0300Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    	/** column 근속월수코드 : logSvcMnthIcmCd */
//		                                
//		                                
//		                                
//		                                psnl0300Dto.setAftBusinCd(PersonalUtil.getSelectedComboValue(afterBusinCd, "businCd")); 	//사업 
//		                                psnl0300Dto.setAftDeptCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd")); 	//부서
//		                                psnl0300Dto.setAftTypOccuDivCd(PersonalUtil.getSelectedComboValue(afterTypOccuCd)); 		//직종
//		                                psnl0300Dto.setAftLogSvcYrNumCd(PersonalUtil.getSelectedComboValue(afterLogSvcYrNumCd)); 	//근속년수
//		                                psnl0300Dto.setAftOdtyDivCd(PersonalUtil.getSelectedComboValue(afterOdtyCd)); 				//직책
//		                                psnl0300Dto.setAppmtIstut(afterAppmtIstut.getValue());
//		                                psnl0300Dto.setAppmtBssCtnt(afterAppmtBssCtnt.getValue());
//										//후 호봉코드는 비워둠, 후 호봉등급은 전 호봉등급으로 같이 등록
//		                                psnl0300Dto.setAppmtDt(PersonalUtil.getConvertDateToString(afterAppmtDt, "yyyyMMdd"));
//		                                
//		                                psnl0300Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    				/** column 고용구분코드 : emymtDivCd */
//		                                
//		                                list.add(psnl0300Dto);
//		                    		}
//		                    		
//		                    		if(list.size() > 0) {
//		                    			
//		                    			psnl0300Service.appointmentSaveList(list, new AsyncCallback<Integer>() {
//											@Override
//											public void onSuccess(Integer result) {
//												
//												if(result <= 0) {
//													MessageBox.info("경고", "확정된 발령 데이터가 없습니다.", null);
//												}else {
//													MessageBox.info("알림", "총 " + result + " 건의 발령이 확정되었습니다.", null);
//													psnl0300Gridreload();
//												}
////												loadConfig.set("appmtDivCd", appmtDivCd);
////												loadConfig.set("deptCd", deptCd);
////												loadConfig.set("businCd", businCd);
////												loadConfig.set("typOccuCd", typOccuCd);
////												loaderPsnl0300.load(loadConfig);
//												
//											}
//											@Override
//											public void onFailure(Throwable caught) {
//												MessageBox.alert("에러", "발령 확정 에러 : " + caught, null);
//											}
//										});
//		                    			
//		                    		}else {
//		                    			MessageBox.alert("확정",  "확정할 데이터를 선택해 주세요.", null);
//				        				return;
//		                    		}
//		                    		
//		                    	}else {
//		                    		MessageBox.alert("확정",  "확정할 데이터를 선택해 주세요.", null);
//			        				return;
//		                    	}
////		        			}
//							
////							List<Psnl0300DTO> list = psnl0300Grid.getSelectionModel().getSelectedItems();
////							
////							if(list.size() > 0){
////								for(int i = 0; i < list.size(); i++){
////									list.get(i).setAppmtDivCd(appmtDivCd);
////									//발령전 데이터는 현재 데이터로 select into 처리
////									//발령후 시작
////									list.get(i).setAftBusinCd(PersonalUtil.getSelectedComboValue(afterBusinCd, "businCd")); 	//사업 
////									list.get(i).setAftDeptCd(PersonalUtil.getSelectedComboValue(afterCurrDeptCd, "deptCd")); 	//부서
////									list.get(i).setAftTypOccuDivCd(PersonalUtil.getSelectedComboValue(afterTypOccuCd)); 		//직종
////									list.get(i).setAftLogSvcYrNumCd(PersonalUtil.getSelectedComboValue(afterLogSvcYrNumCd)); 	//근속년수
////									list.get(i).setAftOdtyDivCd(PersonalUtil.getSelectedComboValue(afterOdtyCd)); 				//직책
////									
////									list.get(i).setAppmtIstut(afterAppmtIstut.getValue());
////									list.get(i).setAppmtBssCtnt(afterAppmtBssCtnt.getValue());
////									//후 호봉코드는 비워둠, 후 호봉등급은 전 호봉등급으로 같이 등록
////									list.get(i).setAppmtDt(PersonalUtil.getConvertDateToString(afterAppmtDt, "yyyyMMdd"));
////								}
////							}
////							
////							psnl0300Service.appointmentSaveList(list, new AsyncCallback<String>() {
////								@Override
////								public void onSuccess(String result) {
////									MessageBox.info("", "발령이 확정되었습니다.", null);
////									
////									BaseListLoadConfig loadConfig = new BaseListLoadConfig();
////									loadConfig.set("appmtDivCd", appmtDivCd);
////									loadConfig.set("deptCd", deptCd);
////									loadConfig.set("businCd", businCd);
////									loadConfig.set("typOccuCd", typOccuCd);
////									loaderPsnl0300.load(loadConfig);
////									
////								}
////								@Override
////								public void onFailure(Throwable caught) {
////									MessageBox.alert("", "발령 확정 에러", null);
////								}
////							});
//						}
//					}
//					
//				});
//				
//			}
//		});
//		buttonConfirm.add(confirm);
//		afterlc3.add(buttonConfirm, new FormData("100%"));
		
		afterlc.add(afterlc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3) );
		afterlc.add(afterlc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4) );
		afterlc.add(afterlc3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3) );
		
		
		afterIssueFieldSet.add(afterlc, new FormData("100%"));
	    
	    
		panel.add(afterIssueFieldSet);
	 
		
		
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(730, 320);
		
		psnl0300GridPanel = new MSFGridPanel(psnl0300Def, false, false, false, false, false);
		psnl0300GridPanel.setHeaderVisible(false);  
		psnl0300GridPanel.setBodyBorder(false);
		psnl0300GridPanel.setBorders(true);
		
		final Grid psnl0300DefGrid = psnl0300GridPanel.getMsfGrid().getGrid();
		psnl0300DefGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				
			}
		});		
		
		psnl0300GridPanel.addListener(Events.Attach, new Listener<BaseEvent>()  {
		@Override
		public void handleEvent(BaseEvent be) {
			psnl0300Gridreload();
//			BaseListLoadConfig loadConfig = new BaseListLoadConfig();
//			loadConfig.set("appmtDivCd", appmtDivCd);
//			loadConfig.set("deptCd", deptCd);
//			loadConfig.set("businCd", businCd);
//			loadConfig.set("typOccuCd", typOccuCd);
//			loaderPsnl0300.load(loadConfig);
		}
	
	});		
		
		
		cp01.add(psnl0300GridPanel);
		
		
		

//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		final CheckBoxSelectionModel<Psnl0300DTO> sm = new CheckBoxSelectionModel<Psnl0300DTO>();
//
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("appmtDivCdNm");
//		column.setHeaderText("발령구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		/*column = new ColumnConfig();
//		column.setId("appmtDt");
//		column.setHeaderText("발령일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);*/
//
//		column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("resnRegnNum");
//		column.setHeaderText("주민번호");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("appmtFixYn");
//		column.setHeaderText("상태");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("bfrDeptCd");
//		column.setHeaderText("전부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(130);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("bfrBusinCd");
//		column.setHeaderText("전사업");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("bfrTypOccuDivCd");
//		column.setHeaderText("전직종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("bfrOdtyDivCd");
//		column.setHeaderText("전직책");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("bfrPyspCd");
//		column.setHeaderText("전호봉");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("aftDeptCd");
//		column.setHeaderText("후부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("aftBusinCd");
//		column.setHeaderText("후사업");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(110);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("aftTypOccuDivCd");
//		column.setHeaderText("후직종");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(90);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("aftOdtyDivCd");
//		column.setHeaderText("후직책");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("aftPyspCd");
//		column.setHeaderText("후호봉");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("appmtBssCtnt");
//		column.setHeaderText("발령근거사유");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(150);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("appmtIstut");
//		column.setHeaderText("발령기관");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setMenuDisabled(true);
//		column.setSortable(false);
//		configs.add(column);
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		ContentPanel cp01 = new ContentPanel();
//		cp01.setBodyBorder(false);
//		cp01.setHeaderVisible(false);
//		cp01.setLayout(new FitLayout());
//		cp01.setSize(730, 270);
//		
//		psnl0300Grid = new Grid<Psnl0300DTO>(storePsnl0300, cm);
//		psnl0300Grid.setStateful(true);
//		psnl0300Grid.setSelectionModel(sm);
//		psnl0300Grid.setBorders(true);
//		psnl0300Grid.setColumnReordering(true);
//		psnl0300Grid.setLoadMask(true);
//		psnl0300Grid.addPlugin(sm);
//		psnl0300Grid.addListener(Events.Attach, new Listener<GridEvent<Psnl0300DTO>>() {
//			@Override
//			public void handleEvent(GridEvent<Psnl0300DTO> be) {
//				
//				BaseListLoadConfig loadConfig = new BaseListLoadConfig();
//				loadConfig.set("appmtDivCd", appmtDivCd);
//				loadConfig.set("deptCd", deptCd);
//				loadConfig.set("businCd", businCd);
//				loadConfig.set("typOccuCd", typOccuCd);
//				loaderPsnl0300.load(loadConfig);
//			}
//		
//		});
//				
//		cp01.add(psnl0300Grid);
		
		lcTabFormLayer.add(cp01, new FormData("100%"));
		
		
		FieldSet gridField = new FieldSet();
		gridField.setHeadingHtml("발령내역");
		gridField.add(lcTabFormLayer);
		
		
		panel.add(gridField);
		
	    Button a = new Button("대상자선택",new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				fnPopupPsnl0110(appmtDivCd, appmtDivCdNm);
			}
		});
		
		panel.addButton(a);
		
		Button b = new Button("삭제",new SelectionListener<ButtonEvent>() {
			
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(psnl0300Grid.getSelectionModel().getSelectedItems().size() > 0){
					MessageBox.confirm("발령 삭제", "선택하신 발령정보를 삭제 하시겠습니까?<br>(미발령건만 삭제가능.)",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
						//	if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								
								List<Psnl0300DTO> list = psnl0300Grid.getSelectionModel().getSelectedItems();
								boolean chk = true;
								if(list != null && list.size() > 0){
									for(int i = 0; i < list.size(); i++){
										Psnl0300DTO dto = list.get(i);
										if(dto.getAppmtSeilNum() == null || "".equals(dto.getAppmtSeilNum())){ // 발령번호 시퀀스가 없을경우 인사마스터에서 가져온 데이터
											chk = false;
											MessageBox.info("", "선택하신 " + dto.getHanNm()+ " 님은 삭제할 수 없습니다.<br>(인사정보데이터) ", null);
											break;
										}
									}
								}
								
								if(chk){
									psnl0300Service.deletePsnl0300(psnl0300Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<Integer>(){
										@Override
										public void onSuccess(Integer result) {
											MessageBox.info("삭제완료", "발령정보("+result+")가 삭제되었습니다.", null);
											loaderPsnl0300.load();
										}
										@Override
										public void onFailure(Throwable caught) {
											MessageBox.info("삭제실패", "삭제실패!", null);
										}
									});
								}
								
							}
						}
						
					});
				}else{
					MessageBox.info("항목선택", "삭제할 항목을 선택하여주세요.", null);
				}
				
			}
		});
		
		panel.addButton(b);
		
		 Button c = new Button("닫기",new SelectionListener<ButtonEvent>() {
	            
	            @Override
	            public void componentSelected(ButtonEvent ce) {
	                complex.hide();
	            }
	        });
	        
	        panel.addButton(c);
	        
		
		complex.add(panel, data);
		
		return complex;
	}
	
	
	public static void psnl0300Gridreload() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		psnl0300GridPanel.getTableDef().setTableColumnFilters(filters);
		
		psnl0300GridPanel.getTableDef().addColumnFilter("appmtDivCd"	, appmtDivCdStr.getValue()	, SimpleColumnFilter.OPERATOR_EQUALS);	//발령구분
		psnl0300GridPanel.getTableDef().addColumnFilter("emymtDivCd"	, emymtDivCdStr.getValue()	, SimpleColumnFilter.OPERATOR_EQUALS);	//고용구분
		psnl0300GridPanel.getTableDef().addColumnFilter("deptCd"		, deptCdStr.getValue()		, SimpleColumnFilter.OPERATOR_EQUALS); 	//부서
		psnl0300GridPanel.getTableDef().addColumnFilter("businCd"		, businCdStr.getValue()		, SimpleColumnFilter.OPERATOR_EQUALS);	//사업
		psnl0300GridPanel.getTableDef().addColumnFilter("typOccuCd"		, typOccuCdStr.getValue()	, SimpleColumnFilter.OPERATOR_EQUALS);	//직종
		
		psnl0300GridPanel.reload();
	}
	
	public static void setListRecord(Iterator<Record> records) {
		recordsIter = records;
	 } 
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	public static void fnPopupPsnl0110(final String appmtDivCd, final String appmtDivCdNm) {
	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	       //검색.처리하면됨.
	       
		MSFFormPanel popCom0110 = PrgmComPopupUtils.lovPopUpPrgmCom0110Form();  //인사  
	       
		final FormBinding popBindingCom0110 = popCom0110.getFormBinding();
	      
		popBindingCom0110.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) { 
				List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
				if (mapModels != null) {
					
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
					while (iterRecords.hasNext()) {
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						
						
						
//						//건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
//						//save(bmMapModel);
//						Psnl0300DTO tempDto = new Psnl0300DTO();
//	                    tempDto.setDpobCd(bmMapModel.get("dpobCd") == null ? "" : String.valueOf(bmMapModel.get("dpobCd")));
//	                    tempDto.setSystemkey(bmMapModel.get("systemkey") == null ? "" : String.valueOf(bmMapModel.get("systemkey")));
//	                    tempDto.setAppmtDivCd(appmtDivCd);
//	                    tempDto.setAppmtDivCdNm(appmtDivCdNm);
//	                    tempDto.setAppmtDt(DateTimeFormat.getFormat("yyyy.MM.dd").format(new Date()));
//	                    tempDto.setHanNm(bmMapModel.get("hanNm") == null ? "" : String.valueOf(bmMapModel.get("hanNm")));
//	                    tempDto.setResnRegnNum(bmMapModel.get("resnRegnNum") == null ? "" : String.valueOf(bmMapModel.get("resnRegnNum")));
//	                    tempDto.setAppmtFixYn("미확정");
//	                       
//	                    boolean insertCheck = false;
//	                    for(Psnl0300DTO dto : psnl0300Grid.getStore().getModels()){
//	                    	if(dto.getResnRegnNum().equals(tempDto.getResnRegnNum()) && dto.getHanNm().equals(tempDto.getHanNm())){
//	                    		insertCheck = true;
//	                    	}
//	                    }
//	                    if(!insertCheck){
//	                    	psnl0300Grid.getStore().add(tempDto);
//	                    }
//	                    tempDto = new Psnl0300DTO();
					}
				}  
			}
		});
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	
	
	
	
}
