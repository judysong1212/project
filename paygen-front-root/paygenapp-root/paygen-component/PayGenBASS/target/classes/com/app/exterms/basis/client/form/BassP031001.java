/**
 * 이전사업이관
 */
package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.app.exterms.basis.client.form.defs.Psnl2100Def;
import com.app.exterms.basis.client.service.Bass0310Service;
import com.app.exterms.basis.client.service.Bass0310ServiceAsync;
import com.app.exterms.basis.client.service.BassP031001Service;
import com.app.exterms.basis.client.service.BassP031001ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;

/**
 * ==================================================== 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class BassP031001 extends MSFFormPanel {
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++ 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++++++++++
	 **/

	private FormPanel cpBass031001;
	private HiddenField json;

	// -------------- grid 선언 시작 ---------------
	private MSFGridPanel bassP031001_01GridPanel;
	private MSFGridPanel bassP031001_02GridPanel;

	// private Bass0500Def bass0500Def = new Bass0500Def();
	private Psnl2100Def bass031001_1Def = new Psnl2100Def("BASS0310_PSNL2100_COPY_1");
	private Psnl2100Def bass031001_2Def = new Psnl2100Def("BASS0310_PSNL2100_COPY_2");
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

	//파일업로드처리 부분  
	private FileUploadField bassP031001flUp;
	private Boolean picBoolFile;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 검색변수
	 * 선언 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 검색 조건 시작 --------------
	private ListStore<BaseModel> stTypOccuCd = new ListStore<BaseModel>(); // 직종코드
	private ComboBox<BaseModel> basicTypOccuCd;		//기본 직종
	private ComboBox<BaseModel> targetTypOccuCd;	//대상 직종

	private HiddenField<String> dpobCd;		/** column 사업장코드 : dpobCd */
	// -------------- 검색 조건 종료 --------------

	// -------------- 서비스 호출 시작 --------------
	private Bass0310ServiceAsync bass0310Service = Bass0310Service.Util.getInstance();
	private BassP031001ServiceAsync bassP031001Service = BassP031001Service.Util.getInstance();

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
	public BassP031001(final ActionDatabase actionDatabase,	final MSFPanel caller) {

		this.setBodyBorder(false);
		this.setHeaderVisible(false);
		this.setFrame(false);
		this.actionDatabase = actionDatabase;
		this.setBorders(false);
		this.setAutoHeight(true);

		cpBass031001 = new FormPanel();

		createSearchForm();
		createExcelForm();

		cpBass031001.setBodyBorder(false);
		cpBass031001.setBorders(false);
		cpBass031001.setHeaderVisible(false);
		cpBass031001.setSize("790px", "640px");

		this.add(cpBass031001);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "730px");
	}

	/**
	 * 검색 정보 설정
	 */
	private void createSearchForm() {

		dpobCd = new HiddenField<String>();	/** column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpBass031001.add(dpobCd);
		
		/* json값을 받기위한 hiddenField */
		json = new HiddenField();
		json.setName("json");

		cpBass031001.add(json);

		sysComBass0320Dto = new PrgmComBass0320DTO();
		stTypOccuCd = new ListStore<BaseModel>();
		sysComBass0320Dto.setTypOccuUseYn("Y");
		stTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);

		cpBass031001.setLayout(new FlowLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("생성");

		LayoutContainer lcSchCol = new LayoutContainer();

		LayoutContainer lcSchCol1 = new LayoutContainer();
		lcSchCol1.setLayout(new ColumnLayout());

		LayoutContainer lcSchCol1_1 = new LayoutContainer();

		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(80);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_1.setLayout(fl1_1);

		basicTypOccuCd = new ComboBox<BaseModel>();
		basicTypOccuCd.setName("basicTypOccuCd");
		basicTypOccuCd.setFieldLabel("직종");
		basicTypOccuCd.setForceSelection(true);
		basicTypOccuCd.setMinChars(1);
		basicTypOccuCd.setDisplayField("typOccuNm");
		basicTypOccuCd.setValueField("typOccuCd");
		basicTypOccuCd.setTriggerAction(TriggerAction.ALL);
		basicTypOccuCd.setEmptyText("--직종선택--");
		basicTypOccuCd.setSelectOnFocus(true);
		basicTypOccuCd.setStore(stTypOccuCd);
		basicTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				reload();            
			} 
		}); 
		basicTypOccuCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200);
		lcSchCol1_1.add(basicTypOccuCd, new FormData("100%"));

		LayoutContainer lcSchCol1_2 = new LayoutContainer();

		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(80);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol1_2.setLayout(fl1_2);

		/*targetTypOccuCd = new ComboBox<BaseModel>();
		targetTypOccuCd.setName("targetTypOccuCd");
		targetTypOccuCd.setFieldLabel("대상 직종");
		targetTypOccuCd.setForceSelection(true);
		targetTypOccuCd.setMinChars(1);
		targetTypOccuCd.setDisplayField("typOccuNm");
		targetTypOccuCd.setValueField("typOccuCd");
		targetTypOccuCd.setTriggerAction(TriggerAction.ALL);
		targetTypOccuCd.setEmptyText("--직종선택--");
		targetTypOccuCd.setSelectOnFocus(true);
		targetTypOccuCd.setStore(stTypOccuCd);		
		targetTypOccuCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200);
		lcSchCol1_2.add(targetTypOccuCd, new FormData("100%"));*/

		lcSchCol1.add(lcSchCol1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		lcSchCol1.add(lcSchCol1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));

		lcSchCol.add(lcSchCol1, new FormData("100%"));

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpBass031001.add(fieldSet);		
		cpBass031001.add(createMsfGridForm(), new FormData("100%"));		

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
		fldstNewFieldset2.setHeadingHtml("직종세 정보");		
		layoutContainer2.add(fldstNewFieldset2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));

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
		fldstNewFieldset3.setHeadingHtml("일괄처리대상");
		layoutContainer2.add(fldstNewFieldset3,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));

		LayoutContainer layoutContainer3 = new LayoutContainer();
		layoutContainer3.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer3_1 = new LayoutContainer();
		layoutContainer3_1.setStyleAttribute("paddingLeft", "10px");

		lcTabFormLayer.add(layoutContainer2);
		lcTabFormLayer.add(layoutContainer3);

		return lcTabFormLayer;
	}

	private LayoutContainer bassLeft01() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGridBassP0310 = new ContentPanel();
		cpGridBassP0310.setBodyBorder(false);
		cpGridBassP0310.setHeaderVisible(false);
		cpGridBassP0310.setLayout(new FitLayout());

		bassP031001_01GridPanel = new MSFGridPanel(bass031001_1Def, false, false,false, false, false);
		bassP031001_01GridPanel.setSize(470, 450);

		bassP031001_01GridPanel.setBorders(true);
		bassP031001_01GridPanel.setBodyBorder(true);
		bassP031001_01GridPanel.setHeaderVisible(false);
		bassP031001_01GridPanel.getBottomComponent().setVisible(true);	

		// 두번째 미사용직종정보 툴바 		            
		ToolBar bottomToolbar1 = new ToolBar();  
		bottomToolbar1.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnBassSave = new Button("선택");
		btnBassSave.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(bassP031001_01GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){

					List<BaseModel> list = bassP031001_01GridPanel.getGrid().getSelectionModel().getSelectedItems();
					for(BaseModel bm : list){

						bassP031001_01GridPanel.getGrid().getStore().remove(bm);
					}

					bassP031001_02GridPanel.getGrid().getStore().add(list);
				}
			}  
		});	 	    
		bottomToolbar1.add(btnBassSave);
		bottomToolbar1.add(new SeparatorMenuItem());
		//====================================================admi
		bassP031001_01GridPanel.setBottomComponent(bottomToolbar1);

		cpGridBassP0310.add(bassP031001_01GridPanel);


		lcStdGrid.add(cpGridBassP0310);
		return lcStdGrid;

	}

	private LayoutContainer bassRight01() {

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGridBassP0310 = new ContentPanel();
		cpGridBassP0310.setBodyBorder(false);
		cpGridBassP0310.setHeaderVisible(false);
		cpGridBassP0310.setLayout(new FitLayout());

		bassP031001_02GridPanel = new MSFGridPanel(bass031001_2Def, false, false,false, false, false);
		bassP031001_02GridPanel.setSize(380, 450);
		bassP031001_02GridPanel.setBorders(false);
		bassP031001_02GridPanel.setBodyBorder(true);
		bassP031001_02GridPanel.setHeaderVisible(false);
		bassP031001_02GridPanel.getBottomComponent().setVisible(true);
		// 두번째 미사용직종정보 툴바 
		ToolBar bottomToolbar2 = new ToolBar(); 
		bottomToolbar2.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnBassSave2 = new Button("미선택");
		btnBassSave2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				if(bassP031001_02GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){

					List<BaseModel> list = bassP031001_02GridPanel.getGrid().getSelectionModel().getSelectedItems();
					for(BaseModel bm : list){

						bassP031001_02GridPanel.getGrid().getStore().remove(bm);
					}

					bassP031001_01GridPanel.getGrid().getStore().add(list);


				}
			}			
		});		

		bottomToolbar2.add(btnBassSave2);
		bottomToolbar2.add(new SeparatorMenuItem());
		//====================================================admi
		bassP031001_02GridPanel.setBottomComponent(bottomToolbar2);

		cpGridBassP0310.add(bassP031001_02GridPanel);		
		lcStdGrid.add(cpGridBassP0310);			
		return lcStdGrid;

	}

	/** Excel */
	private void createExcelForm(){
		FieldSet fldstNewFieldset = new FieldSet();	
		fldstNewFieldset.setHeadingHtml("일괄 처리");
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout()); 

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);

		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		layoutContainer_2_1.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2_1.setLayout(frmlytSch);
		layoutContainer_2_1.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer(); 
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_4.setLayout(frmlytSch);
		layoutContainer_4.setBorders(false);

		bassP031001flUp = new FileUploadField();
		bassP031001flUp.setName("bassP031001flUp");
		bassP031001flUp.setValidator(new Validator() {  
			@Override  public String validate(Field<?> field, String value) { 
				value = value.toLowerCase();        
				String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
				if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
					result = null;        
				}        
				return result;  
			} 
		});
		layoutContainer_2_1.add(bassP031001flUp, new FormData("100%"));
		bassP031001flUp.setFieldLabel("휴가일수");

		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {                  
				xlsExportData();
			}
		}); 		
		layoutContainer_3.add(btnButton02, new FormData("100%"));

		Button btnButton01 = new Button("일괄 처리");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {                  
				xlsImportData();
			}
		});
		layoutContainer_4.add(btnButton01, new FormData("100%"));


		layoutContainer_2.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);

		cpBass031001.add(fldstNewFieldset);					
	}	
	/* 엑셀 업로드 */
	private void xlsImportData() {
		MessageBox.confirm("휴가일수 생성", "휴가일수를 일괄 생성하시겠습니까?<br>/n 등록되어 있는 정보는 삭제 후 저장합니다.",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					
					Map<String, Object> map = new HashMap<String, Object>();
					HashMap<String, Object> objMap = new HashMap<String, Object>(); 
					String jsonMap;
					
					//그리드 데이터 가져오기
					Iterator<BaseModel> itBm = bassP031001_02GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
					List<Record>  lsRec  = new ArrayList<Record>();
					while(itBm.hasNext()) {
						Record rec  = new Record(itBm.next()); 
						lsRec.add(rec);
					} 

					Iterator<Record> iterRecords = lsRec.iterator() ;  

					final int cnt = bassP031001_02GridPanel.getGrid().getSelectionModel().getSelectedItems().size();
					int i =0;
					while (iterRecords.hasNext()) {
						map = new HashMap<String, Object>(); 
						Record recData = (Record) iterRecords.next(); 
						BaseModel bmMapModel = (BaseModel)recData.getModel();	

						/* 그리드에서 받아온 값 map에 담기 */
						map.put("typOccuCd", MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));
						map.put("dtilOccuInttnCd", MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));

						/* string으로 변환된 map 값 다시 담기 : 순서를 주기 위함 */
						objMap.put(String.valueOf(i), toJson(map));

						i++;						
					}	

					/* 위에서 받은 objMap을 다시 json(string)으로 변형 */
					jsonMap = toJson(objMap);

					/* 변현된 json(string)값 HiddenField에 담기 */
					json.setValue(jsonMap);

					//엑셀업로드 진행
					String filename = MSFSharedUtils.allowNulls(bassP031001flUp.getValue());

					if (filename.length() == 0) {
						Window.alert("선택된 파일이 없습니다.");
						return;
					}else {
						//submit the form
						cpBass031001.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
						//파일업로드 처리

						cpBass031001.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadBassP031001Import.do");
						cpBass031001.setEncoding(Encoding.MULTIPART);
						cpBass031001.setMethod(Method.POST);  						
						cpBass031001.submit();  
						cpBass031001.onFrameLoad();  
						picBoolFile = true;	 

					}
					// reset and unmask the form 
					// after file upload 
					cpBass031001.addListener(Events.Submit, new Listener<FormEvent>() {
						public void handleEvent(FormEvent evt) {   
							if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {

								//업로드가  성공했으면 인서트 모듈을 태운다. 
								cpBass031001.unmask();  
								//MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
								picBoolFile = false;
								evt.setResultHtml("");
							} else {
								if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
									cpBass031001.unmask();  
									MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
									picBoolFile = false;
									evt.setResultHtml("");
								} else {
									//실패 메시지나 에러 메시지 처리 . 
									evt.setResultHtml("");
								} 
							}
						};
					});

				}  
			}		      	
		}); 	     	 
	} 

	/* 그리드에서 받은 값 json으로 변형 */
	public static String toJson(Map<String, Object> map) {
		String json = "";
		if (map != null && !map.isEmpty()) {
			JSONObject jsonObj = new JSONObject();
			for (Map.Entry<String, Object> entry: map.entrySet()) {
				jsonObj.put(entry.getKey(), new JSONString(entry.getValue().toString()));
			}
			json = jsonObj.toString();
		}
		return json;
	}

	/* 엑셀 다운로드 */
	private void xlsExportData() {

		HashMap<String, String> param = new HashMap<String, String>();
		bassP031001_02GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileBassP031001Export.do","extgwtFrame" ,param);  
	}

	public void reload() {

		IColumnFilter filters = null;

		bassP031001_01GridPanel.getMsfGrid().clearData();	
		bassP031001_01GridPanel.getTableDef().setTableColumnFilters(filters);
		bassP031001_01GridPanel.getTableDef().addColumnFilter("typOccuCd", BasisUtil.getSelectedComboValue(basicTypOccuCd, "typOccuCd"), SimpleColumnFilter.OPERATOR_LIKE);	//직종명
		bassP031001_01GridPanel.reload();
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
