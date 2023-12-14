package com.app.exterms.payroll.client.form;


import com.app.exterms.payroll.client.dto.Bass0300DTO;
import com.app.exterms.payroll.client.form.defs.Bass0300Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr5010Service;
import com.app.exterms.payroll.client.service.Payr5010ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Bass0350.java
 * @Description : 직종세부관리
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
 * 디자인화면 수정시 extends 부분을
 * 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends LayoutContainer
 * implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Payr5010 extends MSFPanel {
	/**
	 * ########################################################################## 
	 * { 시스템 기본설정파일 선언부 시작}
	 * ##########################################################################
	 **/

	/**
	 * ########################################################################## 
	 * { 시스템 기본설정파일 선언부 종료}
	 * ##########################################################################
	 **/

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;
	private VerticalPanel vp;
	private FormPanel plFrmPayr5010;
	
	public Bass0300DTO payr5010Dto = new Bass0300DTO();
	public FormBinding formBinding;
	public FormBinding srhFormBinding;
	
	private Bass0300Def bass0300Def = new Bass0300Def("PAYR5010"); // 그리드 테이블 컬럼 define
	private MSFGridPanel msfBass0300GridPanel;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 화면 렌더링 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private FieldSet fieldSetFrm;
	private FieldSet fieldSetGrd;
	private FieldSet fieldSetSrhFrm;
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ButtonBar topBass0300Bar;
	private Button btnBass0300New;
	private Button btnBass0300Save;
	private Button btnBass0300Del;
	private Button btnBass0300Sreach;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -- 검색 조건 시작

	
	private ComboBox<BaseModel> srhRpsttvCd; 		//대표코드
	private TextField<String> srhCommCdNm; 	        //직군명
	
	// -- 검색 조건 끝
	

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 상세정보 시작 --------------
	
	private ComboBox<BaseModel> rpsttvCd; 		//대표코드
	private MSFTextField dtlCd;                 //직군(세부)코드
	private MSFTextField commCdNm;               //직군명    
	
	private MSFTextField abbrNm;                //약어명
	private CheckBox useYn;                     //사용여부
	private CheckBox opnYn;                     //표시여부
	private MSFNumberField ord;                 //순서	
	private MSFTextField note;                  //비고
	private CheckBoxGroup dtilOccuClsUseGrp; 			// 체크박스그룹
	
	
	private HiddenField<String> dpobCd;

	
	// -------------- 상세정보 종료 --------------
 
	// -------------- 서비스 호출 시작 --------------
	private Payr5010ServiceAsync payr5010Service = Payr5010Service.Util.getInstance();	// 입력수정삭제처리 rpc 처리부
	// -------------- 서비스 호출 시작 --------------


	// -------------- DTO 선언 시작 --------------
	//private PrgmComBass0300DTO sysComBass0300Dto;

	// -------------- DTO 선언 종료 --------------
	
	private BaseModel record;
	
	// -------------- store 선언 시작 ---------------
	private ListStore<BaseModel> listStoreC002 = new ListStore<BaseModel>();	//직종세

 	
	// -------------- store 선언 종료 ---------------
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 상태처리 전역변수
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
	private ActionDatabase actionDatabase;
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			if (ce.getButton() == btnBass0300Save) {
				if((ActionDatabase.INSERT).equals(actionDatabase)) {
					doAction(ActionDatabase.INSERT);
					actionDatabase = ActionDatabase.UPDATE;
				}else {
					doAction(ActionDatabase.UPDATE);
				}
			}else if (ce.getButton() == btnBass0300Del) {
				MessageBox.confirm("경고", "단가직군코드를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							doAction(ActionDatabase.DELETE);
						}
					}
				});
			}
		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}
	
	public void save(final ActionDatabase actionDatabase){

		final Bass0300DTO dto = new Bass0300DTO();

		if( "".equals(PayrUtils.getSelectedComboValue(rpsttvCd,"rpsttvCd")) ){
			MessageBox.info("", "대표코드를 선택하여 주세요.", null);
		}else{

			dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));
			dto.setRpsttvCd(MSFSharedUtils.getSelectedComboValue(rpsttvCd,"rpsttvCd"));
			if(dtlCd.getValue() == null || dtlCd.getValue().equals("")){
				MessageBox.info("", "직군코드를 입력해 주세요.", null);
				return;
			}else{
				dto.setDtlCd(MSFSharedUtils.allowNulls(dtlCd.getValue()));
			}
			dto.setCommCd(dto.getRpsttvCd()+dto.getDtlCd());
			dto.setCommCdNm(MSFSharedUtils.allowNulls(commCdNm.getValue()));
			dto.setAbbrNm(MSFSharedUtils.allowNulls(abbrNm.getValue()));
			dto.setUseYn(useYn.getValue() ? "Y" : "N");
			dto.setOpnYn(opnYn.getValue() ? "Y" : "N");
			if(null == ord.getValue()){
				MessageBox.info("", "순서를 입력해 주세요.", null);
				return;
			}else{
				dto.setOrd(ord.getValue().longValue());
			}
			dto.setNote(MSFSharedUtils.allowNulls(note.getValue()));


			if("DELETE".equals(actionDatabase.name())){
				payr5010Service.activityOnDeleteBass0300(dto, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnDeleteBass0300 : " + caught), null);
					}
					public void onSuccess(String result) {  
						if(result.equals("2")){
							MessageBox.info("", "해당 직군에 대한 사용중인 직종세가 존재합니다.", null);
						}else{
							MessageBox.info("", "삭제 되었습니다.", null);					
						}
						reload();
					}
				});
			}else{
				payr5010Service.activityOnSaveBass0300(dto, actionDatabase, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
								MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnSaveBass0300 : " + caught), null);
					}
					public void onSuccess(String result) {  

						if("UPDATE".equals(actionDatabase.name())){
							MessageBox.info("", "수정 되었습니다.", null);
						}else{
							MessageBox.info("", "저장 되었습니다.", null);
						}

						reload();
					}
				});
			}
		}

	}

	public ContentPanel getViewPanel() {
		if (panel == null) {
			
//			List<String> arrRpsttvCd = new ArrayList<String>();
//			arrRpsttvCd.add("A041");
//			arrRpsttvCd.add("A006");
//			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
//			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
//			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
//				
//				@Override
//				public void onSuccess(HashMap<String, List<BaseModel>> result) {
//					// TODO 콤보 데이터 저장하는곳
//					if(result != null && result.size() > 0){
//						listStoreA041.add(result.get("A041"));
//						listStoreA006.add(result.get("A006"));
//					}
//					if(listStoreA006.getCount() > 0){
//						pyspGrdeCd.setValue(listStoreA006.getAt(0));
//					}
//				}
//				@Override
//				public void onFailure(Throwable caught) {
//					MessageBox.alert("", "공통코드 에러!", null);
//				}
//			});
			

			
			
			
		
			//detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPayr5010Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createListGrdForm();	// 직종 세부정보 그리드
			createStandardForm(); 	// 상세정보
			vp.setSize("1010px", "700px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.setScrollMode(Scroll.AUTO);
			panel.add(vp);
			reload();
		}
		return panel;
	}

	/**
	 * ############################################################################# 
	 * 프로그램 종료
	 * #############################################################################
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	/**
	 * @wbp.parser.constructor
	 */
	public Payr5010() {
		setSize("1010px", "700px");
	}

	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createPayr5010Form() {

		plFrmPayr5010 = new FormPanel();
		plFrmPayr5010.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - ") + lblPayrConst.title_Payr5010());
		plFrmPayr5010.setIcon(Resources.APP_ICONS.text());
		plFrmPayr5010.setPadding(2);
		plFrmPayr5010.setBodyStyleName("pad-text");
		plFrmPayr5010.setFrame(true);
		plFrmPayr5010.setSize("990px", "680px");

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr5010(),"PAYR5010");
				}
			});
		plFrmPayr5010.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr5010.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		topBass0300Bar = new ButtonBar();
		topBass0300Bar.setAlignment(HorizontalAlignment.RIGHT);

		// 신규
		btnBass0300New = new Button("신규");
		btnBass0300New.setIcon(Resources.APP_ICONS.new16());
		topBass0300Bar.add(btnBass0300New);
		btnBass0300New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//신규 버튼 클릭시 처리     
    			formBass0300Init();  
    			//pyspGrdeCd.setEnabled(true);
    			actionDatabase = ActionDatabase.INSERT;
    		}
    	});
		/**
		btnBass0350New.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				dpobCd.setValue("");				
				dtilOccuClsDivCd.setValue("");			//직종세코드
				
				typOccuCd.setValue(new BaseModel());	//직종명
				//pyspGrdeCd.setValue(new BaseModel());
				pyspGrdeCd.select(0);					//호봉등급
				dtilOccuClsNm.setValue("");				//직종세명
				dtilOccuClsCtnt.setValue("");			//직종세내용
				dtilOccuClsOrd.setValue("");			//순서
				dtilOccuClsUseYn.setValue(false);		//직종세사용여부
				chngTgtYn.setValue(false);				//전환제외대상여부
			}
		});
		*/
		
		// 저장 -신규/수정 동시 처리 부분으로 나뉨
		btnBass0300Save = new Button("저장");
		btnBass0300Save.setIcon(Resources.APP_ICONS.save16());
		topBass0300Bar.add(btnBass0300Save);
		btnBass0300Save.addSelectionListener(selectionListener);

		// 삭제
		btnBass0300Del = new Button("삭제");
		btnBass0300Del.setIcon(Resources.APP_ICONS.delete16());
		topBass0300Bar.add(btnBass0300Del);
		btnBass0300Del.addSelectionListener(selectionListener);

		// 검색
		btnBass0300Sreach = new Button("조회");
		btnBass0300Sreach.setIcon(Resources.APP_ICONS.search16());
		topBass0300Bar.add(btnBass0300Sreach);
		btnBass0300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						
						reload();
					}
				});

		plFrmPayr5010.add(topBass0300Bar);

		vp.add(plFrmPayr5010);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSearchForm() {
			
		BaseModel bm  = new BaseModel();
		bm.set("rpsttvCd", "C002");
		bm.set("rpsttvCdNm", "C002");
		listStoreC002.add(bm);
		
		plFrmPayr5010.setLayout(new FlowLayout());


		fieldSetSrhFrm = new FieldSet();
		fieldSetSrhFrm.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSetSrhFrm.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		
		// fieldSet.setCheckboxToggle(false);

		LayoutContainer lcSchColSrhFrm = new LayoutContainer();
		lcSchColSrhFrm.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeftSrhFrm = new LayoutContainer();
		lcSchLeftSrhFrm.setStyleAttribute("paddingRight", "200px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(100);
		lcSchLeftSrhFrm.setLayout(frmlytSch);

		srhRpsttvCd = new ComboBox<BaseModel>();
		srhRpsttvCd.setName("srhRpsttvCd");
		srhRpsttvCd.setForceSelection(true);
		srhRpsttvCd.setMinChars(1);
		srhRpsttvCd.setDisplayField("rpsttvCdNm");
		srhRpsttvCd.setValueField("rpsttvCd");
		
		
		srhRpsttvCd.setTriggerAction(TriggerAction.ALL);
		srhRpsttvCd.setEmptyText("-- 코드선택--");
		srhRpsttvCd.setSelectOnFocus(false);
		srhRpsttvCd.setStore(listStoreC002);
		lcSchLeftSrhFrm.add(srhRpsttvCd, new FormData("100%"));
		srhRpsttvCd.setFieldLabel("대표코드");
		
		PayrUtils.setSelectedComboValue(srhRpsttvCd, "C002", "rpsttvCd");
		
		
		LayoutContainer lcSchLeftSrhFrm2 = new LayoutContainer();
		FormLayout frmlytSch2 = new FormLayout();
		frmlytSch2.setLabelWidth(85);
		frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeftSrhFrm2.setLayout(frmlytSch2);
		srhCommCdNm = new TextField<String>();
		srhCommCdNm.setName("srhCommCdNm");
		srhCommCdNm.setFieldLabel("직군명");
		lcSchLeftSrhFrm2.add(srhCommCdNm, new FormData("100%"));

		lcSchColSrhFrm.add(lcSchLeftSrhFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchColSrhFrm.add(lcSchLeftSrhFrm2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		fieldSetSrhFrm.add(lcSchColSrhFrm, new FormData("100%"));

		plFrmPayr5010.add(fieldSetSrhFrm);
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	// 상세정보
	private void createStandardForm() {
		
		dpobCd = new HiddenField<String>();
		 
		fieldSetFrm = new FieldSet();
		fieldSetFrm.setHeadingHtml("상세정보");

		LayoutContainer lcStdColFrm = new LayoutContainer();
		lcStdColFrm.setLayout(new ColumnLayout());

		LayoutContainer lcStdLeftFrm = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm.setLayout(frmlytStd);

		LayoutContainer lcStdRightFrm = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm.setLayout(frmlytStd);
		
		LayoutContainer lcStdRightFrm2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm2.setLayout(frmlytStd);
		
		

		rpsttvCd = new MSFComboBox<BaseModel>();
		rpsttvCd.setName("rpsttvCd");
		rpsttvCd.setForceSelection(true);
		rpsttvCd.setMinChars(1);
		rpsttvCd.setDisplayField("rpsttvCd");
		rpsttvCd.setValueField("rpsttvCdNm");
		rpsttvCd.setTriggerAction(TriggerAction.ALL);
		rpsttvCd.setEmptyText("--코드선택--");
		rpsttvCd.setSelectOnFocus(true);
		rpsttvCd.setReadOnly(false);
		rpsttvCd.setEnabled(true);
		rpsttvCd.setStore(listStoreC002);
		rpsttvCd.setFieldLabel("대표코드");
		lcStdLeftFrm.add(rpsttvCd, new FormData("100%"));

		PayrUtils.setSelectedComboValue(rpsttvCd, "C002", "rpsttvCd");
		
		
		commCdNm = new MSFTextField();
		commCdNm.setName("commCdNm");
		commCdNm.setFieldLabel("직군명");
		lcStdLeftFrm.add(commCdNm, new FormData("100%"));
		
		note = new MSFTextField();
		note.setName("note");
		note.setFieldLabel("비고");
		lcStdRightFrm2.add(note, new FormData("100%"));
		
		
		
		dtlCd = new MSFTextField();
		dtlCd.setName("dtlCd");
		dtlCd.setFieldLabel("직군코드");
		lcStdCenterFrm.add(dtlCd, new FormData("100%"));
		
		
		
		LayoutContainer lcSub02 = new LayoutContainer();
		lcSub02.setLayout(new ColumnLayout());

		LayoutContainer sub03 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		sub03.setLayout(frmlytStd);
	
		
		abbrNm = new MSFTextField();
		abbrNm.setName("abbrNm");
		abbrNm.setFieldLabel("약어명");
		lcStdCenterFrm.add(abbrNm, new FormData("100%"));
		
		

		dtilOccuClsUseGrp = new CheckBoxGroup();
		dtilOccuClsUseGrp.setName("dtilOccuClsUseGrp");
		dtilOccuClsUseGrp.setLabelSeparator("");

		useYn = new CheckBox();
		useYn.setName("opnYn");
		dtilOccuClsUseGrp.add(useYn);
		useYn.setBoxLabel("사용여부");
		useYn.setHideLabel(true);

		opnYn = new CheckBox();
		opnYn.setName("opnYn");
		dtilOccuClsUseGrp.add(opnYn);
		opnYn.setBoxLabel("표시여부");
		opnYn.setHideLabel(true);

		lcStdRightFrm.add(dtilOccuClsUseGrp, new FormData("100%"));

		
		ord = new MSFNumberField ();
		ord.setName("dtilOccuClsOrd");
		ord.setFieldLabel("순서");
		ord.setWidth("50px");
		ord.setRegex("^[0-9]+$");
		ord.getMessages().setRegexText("숫자만 입력가능합니다.");
	
		
		lcStdRightFrm.add(ord, new FormData("100%")); 

		lcStdColFrm.add(lcStdLeftFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm.add(lcStdCenterFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm.add(lcStdRightFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		fieldSetFrm.add(lcStdColFrm, new FormData("100%"));
		fieldSetFrm.add(lcStdRightFrm2, new FormData("100%"));
		

		plFrmPayr5010.add(fieldSetFrm);
		// vp.add(panel);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	// 직종 세부정보 그리드
	private void createListGrdForm() {
		
		fieldSetGrd = new FieldSet();
		fieldSetGrd.setHeadingHtml("상세정보");


		LayoutContainer lcStdGrid = new LayoutContainer();
		// lcStdGrid.setStyleAttribute("paddingRight", "10px");
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(940, 410);

		msfBass0300GridPanel = new MSFGridPanel(bass0300Def, false, false, false, true);
		msfBass0300GridPanel.setHeaderVisible(false);

		final Grid<BaseModel> grid = msfBass0300GridPanel.getMsfGrid().getGrid();
		grid.addListener(Events.RowClick, new Listener<GridEvent<BaseModel>>() {
			
			@Override
			public void handleEvent(GridEvent<BaseModel> be) {
				actionDatabase = ActionDatabase.UPDATE;
				
				if (msfBass0300GridPanel.getCurrentlySelectedItem() != null) {  
					PayrUtils.setSelectedComboValue(rpsttvCd, (String) msfBass0300GridPanel.getCurrentlySelectedItem().get("rpsttvCd"), "rpsttvCd");
					dtlCd.setValue(MSFSharedUtils.allowNulls(msfBass0300GridPanel.getCurrentlySelectedItem().get("dtlCd")));
					commCdNm.setValue(MSFSharedUtils.allowNulls(msfBass0300GridPanel.getCurrentlySelectedItem().get("commCdNm")));
					abbrNm.setValue(MSFSharedUtils.allowNulls(msfBass0300GridPanel.getCurrentlySelectedItem().get("abbrNm")));
					
					ord.setValue((Long) msfBass0300GridPanel.getCurrentlySelectedItem().get("ord"));
					note.setValue(MSFSharedUtils.allowNulls(msfBass0300GridPanel.getCurrentlySelectedItem().get("note")));
				}		
			}
		});

		cpGrid.add(msfBass0300GridPanel);

		lcStdGrid.add(cpGrid);
		fieldSetGrd.add(lcStdGrid);

		plFrmPayr5010.add(fieldSetGrd, new FormData("0% -475"));

	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	@Override
	public void reload() {
		//폼 초기화
		formBass0300Init();
		
		//TODO 검색조건 수정하기
		IColumnFilter filters = null;
		msfBass0300GridPanel.getTableDef().setTableColumnFilters(filters);
		msfBass0300GridPanel.getTableDef().addColumnFilter("rpsttvCd", MSFSharedUtils.getSelectedComboValue(srhRpsttvCd,"rpsttvCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		msfBass0300GridPanel.getTableDef().addColumnFilter("commCdNm", srhCommCdNm.getValue(), SimpleColumnFilter.OPERATOR_EQUALS);		
		msfBass0300GridPanel.reload();
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Payr5010 getThis() {
		return this;
	}	
	
	private void formBass0300Init() {
		dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd()); 
		dtlCd.setValue("");			//직종세코드
		commCdNm.setValue("");
		abbrNm.setValue("");
		useYn.setValue(false);
		opnYn.setValue(false);
		ord.clear();
		note.setValue("");
	}
	private Long longToNullChk(Object val){
		if(val == null){
			return 0L;
		}else{
			return (Long) val;
		}
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
