package com.app.exterms.payroll.client.form;

import com.app.exterms.payroll.client.dto.Bass0350DTO;
import com.app.exterms.payroll.client.form.defs.Bass0350Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr5220Service;
import com.app.exterms.payroll.client.service.Payr5220ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
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
 * @Class Name : Payr5220.java
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
public class Payr5220 extends MSFPanel {
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
	private FormPanel plFrmPayr5220;
	// private FormData formData;
	private String txtForm = ""; 

	public Bass0350DTO bass0350Dto = new Bass0350DTO();
	public FormBinding formBinding;
	public FormBinding srhFormBinding;

	private Bass0350Def bass0350Def = new Bass0350Def("PAYR5220"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;O
	private MSFGridPanel msfPayr5220GridPanel;
	

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
	private ButtonBar topPayr5220Bar;
	private Button btnPayr5220New;
	private Button btnPayr5220Save;
	private Button btnPayr5220Del;
	private Button btnPayr5220Sreach;

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -- 검색 조건 시작
	private ComboBox<BaseModel> srhTypOccuCd; 		//직종명
	private TextField<String> srhDtilOccuClsNm; 	//직종세명
	// -- 검색 조건 끝
	

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 상세정보 시작 --------------
	private HiddenField<String> dpobCd;
	private HiddenField<String> dtilOccuInttnCd;    	//직종세 통합코드 
	private MSFTextField dtilOccuClsDivCd;				// 직종세코드
	private MSFComboBox<BaseModel> typOccuCd; 			// 직종명
	private MSFComboBox<BaseModel> dtilOccuJbfmlDivCd; 	//  직군 
	private MSFComboBox<BaseModel> pyspGrdeCd; 			//  등급
	private MSFComboBox<BaseModel> bggLogSvcYrNumCd; 	//  최대근속년수
	
	private MSFTextField dtilOccuClsNm; 				// 직종세명
	private MSFTextField dtilOccuClsCtnt; 				// 직종세내용
	private MSFTextField dtilOccuClsOrd; 				// 정렬순서
	private CheckBoxGroup dtilOccuClsUseGrp; 			// 체크박스그룹
	private CheckBox dtilOccuClsUseYn; 					// 직종세사용여부
	private CheckBox chngTgtYn; 						// 전환제외대상여부
	
	// -------------- 상세정보 종료 --------------
 
	// -------------- 서비스 호출 시작 --------------
	private Payr5220ServiceAsync payr5220Service = Payr5220Service.Util.getInstance();	// 입력수정삭제처리 rpc 처리부
	// -------------- 서비스 호출 시작 --------------


	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto;
 	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	private PrgmComBass0350DTO sysComBass0350Dto; 	//직종세
	// -------------- DTO 선언 종료 --------------
	
	private BaseModel record;
	
	// -------------- store 선언 시작 ---------------
//	private ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>();	//직종
	private ListStore<BaseModel> listStoreA006 = new ListStore<BaseModel>();	//직종세
//	private ListStore<BaseModel> lsTypOccuCd 	= new ListStore<BaseModel>();		//직종 
//	private ListStore<BaseModel> lsPyspGrdeCd 	= new ListStore<BaseModel>();		//호봉등급
	// 공통 코드 - 직종코드
//	private ListStore<BaseModel> srhTypOccuListStore = new ListStore<BaseModel>();
 	private ListStore<BaseModel> typOccuListStore = new ListStore<BaseModel>();
 	private ListStore<BaseModel> dtilOccuJbfmlDivCdStore = new ListStore<BaseModel>();  //직군 
 	private ListStore<BaseModel> bggLogSvcYrNumCdStore = new ListStore<BaseModel>();	//최대근속년수
 	
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
			if (ce.getButton() == btnPayr5220Save) {
				if((ActionDatabase.INSERT).equals(actionDatabase)) {
					doAction(ActionDatabase.INSERT);
					actionDatabase = ActionDatabase.UPDATE;
				}else {
					doAction(ActionDatabase.UPDATE);
				}
				//actionDatabase = null;
			}else if (ce.getButton() == btnPayr5220Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
		
//		public void componentSelected(ButtonEvent ce) {
//			if (ActionDatabase.INSERT.equals(actionDatabase)) {
//				//actionDatabase = null;
//				if (ce.getButton() == btnPayr5220Save) {
//					doAction(ActionDatabase.INSERT);
//				}
//				actionDatabase = ActionDatabase.UPDATE;
//			}else if (ce.getButton() == btnPayr5220Save) {
//				if("INSERT".equals(ActionDatabase.INSERT)) {
//					doAction(ActionDatabase.INSERT);
//				}else {
//					doAction(ActionDatabase.UPDATE);
//				}
//				
//				//actionDatabase = null;
//			}else if (ce.getButton() == btnPayr5220Del) {
//				doAction(ActionDatabase.DELETE);
//			}
//		}
		/**
		public void componentSelected(ButtonEvent ce) {
			if (ce.getButton() == btnPayr5220Save) {
				doAction(ActionDatabase.INSERT);
			} else if (ce.getButton() == btnPayr5220Save) {
				doAction(ActionDatabase.UPDATE);
			} else if (ce.getButton() == btnPayr5220Del) {
				doAction(ActionDatabase.DELETE);
			}

		}
		*/
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}
	
	public void save(final ActionDatabase actionDatabase){
		
		final Bass0350DTO dto = new Bass0350DTO();
		
		if( "".equals(PayrUtils.getSelectedComboValue(typOccuCd,"typOccuCd")) ){
			MessageBox.info("", "직종을 선택하여 주세요.", null);
		}else{
//			dto.setDpobCd(dpobCd.getValue());									
			dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());						//사업장코드
			dto.setTypOccuCd(PayrUtils.getSelectedComboValue(typOccuCd,"typOccuCd"));	//직종코드
			dto.setDtilOccuClsDivCd(dtilOccuClsDivCd.getValue());						//직종세구분코드
			dto.setPyspGrdeCd(PayrUtils.getSelectedComboValue(pyspGrdeCd));				//호봉등급코드
			
			dto.setDtilOccuJbfmlDivCd(PayrUtils.getSelectedComboValue(dtilOccuJbfmlDivCd));	//직군
			dto.setBggLogSvcYrNumCd(PayrUtils.getSelectedComboValue(bggLogSvcYrNumCd));		//최대근속년수
			
			
			dto.setDtilOccuClsNm(dtilOccuClsNm.getValue());								//직종세명
			dto.setDtilOccuClsCtnt(dtilOccuClsCtnt.getValue());							//직종세내용
			//dto.setDtilOccuClsOrd(dtilOccuClsOrd.getValue());							//순서
			dto.setDtilOccuClsUseYn(dtilOccuClsUseYn.getValue() ? "Y" : "N");			//직종세사용여부
			
			dto.setDtilOccuInttnCd(dtilOccuClsDivCd.getValue());
//			dto.setDtilOccuInttnCd(dtilOccuClsDivCd.getValue() + PayrUtils.getSelectedComboValue(pyspGrdeCd));
			
			dto.setChngTgtYn(chngTgtYn.getValue() ? "Y" : "N");							//전환대상여부
			
			
			MessageBox.confirm("","DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						payr5220Service.saveBass0350(dto, actionDatabase, new AsyncCallback<String>() {
							@Override
							public void onSuccess(String result) {
								if("DELETE".equals(actionDatabase.name())){
									MessageBox.info("", "삭제 되었습니다.", null);
								}else{
									MessageBox.info("", "저장 되었습니다.", null);
								}
								reload();
							}
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr5220(" + actionDatabase.name() + ") : " + caught)
				                        , null);
							}
						});
					}
				}
			});
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
			

			
			sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setRpsttvCd("A006");
			sysComBass0300Dto.setMangeItem03("Y");
			listStoreA006 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
			
		
			//detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0350Form(); 	// 화면 기본정보를 설정
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
	public Payr5220() {
		setSize("1010px", "700px");
	}

	public Payr5220(String txtForm) {
		this.txtForm = txtForm;
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
	private void createPsnl0350Form() {

		plFrmPayr5220 = new FormPanel();
		plFrmPayr5220.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - ") + "직종직종세설정관리");
		plFrmPayr5220.setIcon(Resources.APP_ICONS.text());
		plFrmPayr5220.setPadding(2);
		plFrmPayr5220.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("직종직종세설정관리","PAYR5220");
				}
			});
		plFrmPayr5220.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr5220.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmPayr5220.setFrame(true);
		plFrmPayr5220.setSize("990px", "680px");

		topPayr5220Bar = new ButtonBar();
		topPayr5220Bar.setAlignment(HorizontalAlignment.RIGHT);

		// 신규
		btnPayr5220New = new Button("신규");
		btnPayr5220New.setIcon(Resources.APP_ICONS.new16());
		topPayr5220Bar.add(btnPayr5220New);
		btnPayr5220New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//신규 버튼 클릭시 처리     
    			formPayr5220Init();  
    			pyspGrdeCd.setEnabled(true);
    			actionDatabase = ActionDatabase.INSERT;
    		}
    	});
		/**
		btnPayr5220New.addSelectionListener(new SelectionListener<ButtonEvent>() {
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
		btnPayr5220Save = new Button("저장");
		btnPayr5220Save.setIcon(Resources.APP_ICONS.save16());
		topPayr5220Bar.add(btnPayr5220Save);
		btnPayr5220Save.addSelectionListener(selectionListener);

		// 삭제
		btnPayr5220Del = new Button("삭제");
		btnPayr5220Del.setIcon(Resources.APP_ICONS.delete16());
		topPayr5220Bar.add(btnPayr5220Del);
		btnPayr5220Del.addSelectionListener(selectionListener);

		// 검색
		btnPayr5220Sreach = new Button("조회");
		btnPayr5220Sreach.setIcon(Resources.APP_ICONS.search16());
		topPayr5220Bar.add(btnPayr5220Sreach);
		btnPayr5220Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						// 조회버튼 클릭시 처리
						reload();
//						dpobCd.setValue("");
//						dtilOccuClsDivCd.setValue("");
//						typOccuCd.setValue(new BaseModel());
//						dtilOccuClsNm.setValue("");
//						dtilOccuClsCtnt.setValue("");
//						dtilOccuClsOrd.setValue("");
//						dtilOccuClsUseYn.setValue(false);
//						chngTgtYn.setValue(false);
//						System.out.println("직종명" + srhTypOccuCd.getValue());
//						System.out.println("직종세명" + srhDtilOccuClsNm.getValue());
						
					}
				});

		plFrmPayr5220.add(topPayr5220Bar);

		vp.add(plFrmPayr5220);
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSearchForm() {
		
		sysComBass0320Dto = new PrgmComBass0320DTO(); 
		//sysComBass0300Dto.setRpsttvCd("A041");
		ListStore<BaseModel> lsTypOccuCd 	= new ListStore<BaseModel>();		//직종 
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);

		plFrmPayr5220.setLayout(new FlowLayout());
//		sysComBass0300Dto = new PrgmComBass0300DTO();

		fieldSetSrhFrm = new FieldSet();
		fieldSetSrhFrm.setHeadingHtml("검색조건");
		// fieldSet.setCheckboxToggle(false);
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSetSrhFrm.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		LayoutContainer lcSchColSrhFrm = new LayoutContainer();
		lcSchColSrhFrm.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeftSrhFrm = new LayoutContainer();
		lcSchLeftSrhFrm.setStyleAttribute("paddingRight", "200px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(100);
		lcSchLeftSrhFrm.setLayout(frmlytSch);


		srhTypOccuCd = new ComboBox<BaseModel>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setForceSelection(true);
		srhTypOccuCd.setMinChars(1);
//		srhTypOccuCd.setDisplayField("typOccuNm");
//		srhTypOccuCd.setValueField("typOccuCd");
		srhTypOccuCd.setDisplayField("typOccuNm");
		srhTypOccuCd.setValueField("typOccuCd");
		srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.setSelectOnFocus(true);
		srhTypOccuCd.setStore(lsTypOccuCd);
		lcSchLeftSrhFrm.add(srhTypOccuCd, new FormData("100%"));
		srhTypOccuCd.setFieldLabel("직종명");
		
		LayoutContainer lcSchLeftSrhFrm2 = new LayoutContainer();
		FormLayout frmlytSch2 = new FormLayout();
		frmlytSch2.setLabelWidth(85);
		frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeftSrhFrm2.setLayout(frmlytSch2);
		srhDtilOccuClsNm = new TextField<String>();
		srhDtilOccuClsNm.setName("srhDtilOccuClsNm");
		srhDtilOccuClsNm.setFieldLabel("직종세명");
		lcSchLeftSrhFrm2.add(srhDtilOccuClsNm, new FormData("100%"));

		lcSchColSrhFrm.add(lcSchLeftSrhFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchColSrhFrm.add(lcSchLeftSrhFrm2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		fieldSetSrhFrm.add(lcSchColSrhFrm, new FormData("100%"));

		plFrmPayr5220.add(fieldSetSrhFrm);
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
		
		
//		dtilOccuClsDivCd = new MSFTextField();
		
		dtilOccuClsDivCd = new MSFTextField();
		dtilOccuClsDivCd.setReadOnly(true);
		dtilOccuClsDivCd.setName("dtilOccuClsDivCd");
		dtilOccuClsDivCd.setFieldLabel("직종세코드");
		lcStdLeftFrm.add(dtilOccuClsDivCd, new FormData("100%"));

//		typOccuCd = new MSFComboBox<BaseModel>();
//		typOccuCd.setName("typOccuCd");
//		typOccuCd.setForceSelection(true);
//		typOccuCd.setMinChars(1);
//		typOccuCd.setDisplayField("typOccuNm");
//		typOccuCd.setValueField("typOccuCd");
//		typOccuCd.setTriggerAction(TriggerAction.ALL);
//		typOccuCd.setEmptyText("--직종선택--");
//		typOccuCd.setSelectOnFocus(true);
//		typOccuCd.setReadOnly(false);
//		typOccuCd.setEnabled(true);
//		typOccuCd.setStore(lsTypOccuCd);
//		lcStdLeftFrm.add(typOccuCd, new FormData("100%"));
//		typOccuCd.setFieldLabel("직종명");

		
		dtilOccuClsNm = new MSFTextField();
		dtilOccuClsNm.setName("dtilOccuClsNm");
		dtilOccuClsNm.setFieldLabel("직종세명");
		lcStdLeftFrm.add(dtilOccuClsNm, new FormData("100%"));
		
		dtilOccuClsCtnt = new MSFTextField();
		dtilOccuClsCtnt.setName("dtilOccuClsCtnt");
		dtilOccuClsCtnt.setFieldLabel("직종세내용");
		lcStdRightFrm2.add(dtilOccuClsCtnt, new FormData("100%"));
		
		ListStore<BaseModel> lsTypOccuCd 	= new ListStore<BaseModel>();		//직종 
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		
		typOccuCd = new MSFComboBox<BaseModel>();
		typOccuCd.setName("typOccuCd");
		typOccuCd.setForceSelection(true);
		typOccuCd.setMinChars(1);
		typOccuCd.setDisplayField("typOccuNm");
		typOccuCd.setValueField("typOccuCd");
		typOccuCd.setTriggerAction(TriggerAction.ALL);
		typOccuCd.setEmptyText("--직종선택--");
		typOccuCd.setSelectOnFocus(true);
		typOccuCd.setStore(lsTypOccuCd);
		lcStdCenterFrm.add(typOccuCd, new FormData("100%"));
		typOccuCd.setFieldLabel("직종명");
		
		
		
		LayoutContainer lcSub02 = new LayoutContainer();
		lcSub02.setLayout(new ColumnLayout());

		LayoutContainer sub03 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		sub03.setLayout(frmlytStd);
		

//		dtilOccuClsDivCd = new MSFTextField();
//		dtilOccuClsDivCd.setReadOnly(true);
//		dtilOccuClsDivCd.setName("dtilOccuClsDivCd");
//		dtilOccuClsDivCd.setFieldLabel("직종세코드");
//		lcStdCenterFrm.add(dtilOccuClsDivCd, new FormData("100%"));
		
		pyspGrdeCd = new MSFComboBox<BaseModel>();
		pyspGrdeCd.setName("pyspGrdeCd");
		pyspGrdeCd.setForceSelection(true);
		pyspGrdeCd.setMinChars(1);
		pyspGrdeCd.setDisplayField("commCdNm");
		pyspGrdeCd.setValueField("commCd");
		pyspGrdeCd.setTriggerAction(TriggerAction.ALL);
		pyspGrdeCd.setEmptyText("--등급선택--");
		pyspGrdeCd.setSelectOnFocus(true);
		pyspGrdeCd.setReadOnly(false);
		pyspGrdeCd.setEnabled(false);
		pyspGrdeCd.setEditable(true);
		pyspGrdeCd.setStore(listStoreA006);
		pyspGrdeCd.setFieldLabel("등급");  
//		pyspGrdeCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	    		//직종변경에 따른 직종세 값 가져오기
//                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd, "typOccuCd") ;
//                sysComPayr5220Dto.setTypOccuCd(strTypOccuCd);
//                if (MSFSharedUtils.paramNotNull(sysComPayr5220Dto.getTypOccuCd())) {
//                    lsDtilOccuClsDivCd = PrgmComComboUtils.getSinglePayr5220ComboData(sysComPayr5220Dto);
//                }
//            } 
//        }); 
		
		sub03.add(pyspGrdeCd, new FormData("100%"));
		
		LayoutContainer sub04 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		sub04.setLayout(frmlytStd);
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("A007");
		sysComBass0300Dto.setMangeItem03("");
		bggLogSvcYrNumCdStore = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		
		
		bggLogSvcYrNumCd = new MSFComboBox<BaseModel>();
		bggLogSvcYrNumCd.setName("bggLogSvcYrNumCd");
		bggLogSvcYrNumCd.setForceSelection(true);
		bggLogSvcYrNumCd.setMinChars(1);
		bggLogSvcYrNumCd.setDisplayField("commCdNm");
		bggLogSvcYrNumCd.setValueField("commCd");
		bggLogSvcYrNumCd.setTriggerAction(TriggerAction.ALL);
		bggLogSvcYrNumCd.setEmptyText("--근속년수선택--");
		bggLogSvcYrNumCd.setSelectOnFocus(true); 
		bggLogSvcYrNumCd.setStore(bggLogSvcYrNumCdStore);
		bggLogSvcYrNumCd.setFieldLabel("근속년수");  
		
		sub04.add(bggLogSvcYrNumCd, new FormData("100%"));
		
		lcSub02.add(sub03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSub02.add(sub04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		 
		lcStdCenterFrm.add(lcSub02, new FormData("100%"));
		pyspGrdeCd.select(0); 
		
		

		dtilOccuClsUseGrp = new CheckBoxGroup();
		dtilOccuClsUseGrp.setName("dtilOccuClsUseGrp");
		dtilOccuClsUseGrp.setLabelSeparator("");

		dtilOccuClsUseYn = new CheckBox();
		dtilOccuClsUseYn.setName("dtilOccuClsUseYn");
		dtilOccuClsUseGrp.add(dtilOccuClsUseYn);
		dtilOccuClsUseYn.setBoxLabel("사용여부");
		dtilOccuClsUseYn.setHideLabel(true);

		chngTgtYn = new CheckBox();
		chngTgtYn.setName("chngTgtYn");
		dtilOccuClsUseGrp.add(chngTgtYn);
		chngTgtYn.setBoxLabel("전환대상");
		chngTgtYn.setHideLabel(true);

		lcStdRightFrm.add(dtilOccuClsUseGrp, new FormData("100%"));
		
		
		
		LayoutContainer lcSub01 = new LayoutContainer();
		lcSub01.setLayout(new ColumnLayout());

		LayoutContainer sub01 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		sub01.setLayout(frmlytStd);
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("C002");
		sysComBass0300Dto.setMangeItem03("");
		dtilOccuJbfmlDivCdStore = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		dtilOccuJbfmlDivCd = new MSFComboBox<BaseModel>();
		dtilOccuJbfmlDivCd.setName("dtilOccuJbfmlDivCd");
		dtilOccuJbfmlDivCd.setForceSelection(true);
		dtilOccuJbfmlDivCd.setMinChars(1);
		dtilOccuJbfmlDivCd.setDisplayField("commCdNm");
		dtilOccuJbfmlDivCd.setValueField("commCd");
		dtilOccuJbfmlDivCd.setTriggerAction(TriggerAction.ALL);
		dtilOccuJbfmlDivCd.setEmptyText("--직군선택--");
		dtilOccuJbfmlDivCd.setSelectOnFocus(true); 
		dtilOccuJbfmlDivCd.setStore(dtilOccuJbfmlDivCdStore);
		dtilOccuJbfmlDivCd.setFieldLabel("직군");  
		
		sub01.add(dtilOccuJbfmlDivCd, new FormData("100%"));
		
		LayoutContainer sub02 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		sub02.setLayout(frmlytStd);
		
		
		
		dtilOccuClsOrd = new MSFTextField();
		dtilOccuClsOrd.setName("dtilOccuClsOrd");
		dtilOccuClsOrd.setFieldLabel("순서");
		dtilOccuClsOrd.setRegex("^[0-9]+$");
		dtilOccuClsOrd.getMessages().setRegexText("숫자만 입력가능합니다.");
		
		sub02.add(dtilOccuClsOrd, new FormData("100%"));
		
		lcSub01.add(sub01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSub01.add(sub02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		lcStdRightFrm.add(lcSub01, new FormData("100%")); 

		lcStdColFrm.add(lcStdLeftFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm.add(lcStdCenterFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm.add(lcStdRightFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		fieldSetFrm.add(lcStdColFrm, new FormData("100%"));
		fieldSetFrm.add(lcStdRightFrm2, new FormData("100%"));
		

		plFrmPayr5220.add(fieldSetFrm);
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
		fieldSetGrd.setHeadingHtml("직종세부정보");

//		ContentPanel cp = new ContentPanel();
//		cp.setHeaderVisible(false);
//		cp.setFrame(true);
//		cp.setIcon(Resources.APP_ICONS.table());
//		cp.setLayout(new FitLayout());
//		cp.setSize(600, 300);

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
		cpGrid.setSize(940, 440);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		msfPayr5220GridPanel = new MSFGridPanel(bass0350Def, false, false, false, true);
		msfPayr5220GridPanel.setHeaderVisible(false);
		
		final Grid<BaseModel> grid = msfPayr5220GridPanel.getMsfGrid().getGrid();
		grid.addListener(Events.RowClick, new Listener<GridEvent<BaseModel>>() {
			
			@Override
			public void handleEvent(GridEvent<BaseModel> be) {
				actionDatabase = ActionDatabase.UPDATE;
				
//				PayrUtils.setSelectedComboValue(typOccuCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("typOccuCd")+"");
//				PayrUtils.setSelectedComboValue(pyspGrdeCd,grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("pyspGrdeCd")+"");
//				
//				dpobCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd")+"");
//				dtilOccuClsDivCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsDivCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsDivCd")+"");
//				
//				dtilOccuClsNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsNm")+"");
//				dtilOccuClsCtnt.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsCtnt") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsCtnt")+"");
//				dtilOccuClsOrd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsOrd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsOrd")+"");
//				
//				
//				dtilOccuClsUseYn.setValue((Boolean)grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuClsUseYn"));
//				chngTgtYn.setValue((Boolean) grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("chngTgtYn"));
				
				typOccuCd.setValue(typOccuCd.getStore().findModel("typOccuCd", (String)grid.getSelectionModel().getSelectedItem().get("typOccuCd"))); 
				pyspGrdeCd.setValue(pyspGrdeCd.getStore().findModel("commCd", (String)grid.getSelectionModel().getSelectedItem().get("pyspGrdeCd"))); 
				pyspGrdeCd.setEnabled(false);
				//PayrUtils.setSelectedComboValue(typOccuCd, grid.getSelectionModel().getSelectedItem().get("typOccuCd")+"");
				//PayrUtils.setSelectedComboValue(pyspGrdeCd, grid.getSelectionModel().getSelectedItem().get("pyspGrdeCd")+"");
				
				bggLogSvcYrNumCd.setValue(bggLogSvcYrNumCd.getStore().findModel("commCd", MSFSharedUtils.allowNulls(grid.getSelectionModel().getSelectedItem().get("bggLogSvcYrNumCd"))));
				
				dpobCd.setValue(grid.getSelectionModel().getSelectedItem().get("dpobCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dpobCd")+"");
				dtilOccuClsDivCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuInttnCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dtilOccuInttnCd")+"");
				
				dtilOccuJbfmlDivCd.setValue(dtilOccuJbfmlDivCd.getStore().findModel("commCd", MSFSharedUtils.allowNulls(grid.getSelectionModel().getSelectedItem().get("dtilOccuJbfmlDivCd"))));
				
				dtilOccuClsNm.setValue(grid.getSelectionModel().getSelectedItem().get("dtilOccuClsNm") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dtilOccuClsNm")+"");
				dtilOccuClsCtnt.setValue(grid.getSelectionModel().getSelectedItem().get("dtilOccuClsCtnt") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dtilOccuClsCtnt")+"");
				dtilOccuClsOrd.setValue(grid.getSelectionModel().getSelectedItem().get("dtilOccuClsOrd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dtilOccuClsOrd")+"");
				
				
				dtilOccuClsUseYn.setValue((Boolean) grid.getSelectionModel().getSelectedItem().get("dtilOccuClsUseYn"));
				chngTgtYn.setValue((Boolean) grid.getSelectionModel().getSelectedItem().get("chngTgtYn"));
					
			}
		});

		cpGrid.add(msfPayr5220GridPanel);
		// grid.setHeight("147px");

		lcStdGrid.add(cpGrid);
		fieldSetGrd.add(lcStdGrid);

		plFrmPayr5220.add(fieldSetGrd, new FormData("0% -475"));

	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	@Override
	public void reload() {
		
		//폼 초기화
		formPayr5220Init();
//		dpobCd.setValue("");
//		dtilOccuClsDivCd.setValue("");
//		
//		typOccuCd.setValue(new BaseModel());
//		//pyspGrdeCd.setValue(new BaseModel());
//		pyspGrdeCd.select(0);
//		dtilOccuClsNm.setValue("");
//		dtilOccuClsCtnt.setValue("");
//		dtilOccuClsOrd.setValue("");
//		dtilOccuClsUseYn.setValue(false);
//		chngTgtYn.setValue(false);
		
		//TODO 검색조건 수정하기
		IColumnFilter filters = null;
		msfPayr5220GridPanel.getTableDef().setTableColumnFilters(filters);
//		String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//		msfPayr5220GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS);
		msfPayr5220GridPanel.getTableDef().addColumnFilter("srhTypOccuCd", PayrUtils.getSelectedComboValue(srhTypOccuCd, "typOccuCd"), SimpleColumnFilter.OPERATOR_LIKE);	//직종명
		msfPayr5220GridPanel.getTableDef().addColumnFilter("srhDtilOccuClsNm", srhDtilOccuClsNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);					//직종세명
		
		msfPayr5220GridPanel.reload();
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Payr5220 getThis() {
		return this;
	}	
	
	private void formPayr5220Init() {
//		dpobCd.setValue("");
		dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd()); 
		dtilOccuClsDivCd.setValue("");			//직종세코드
		
		typOccuCd.setValue(new BaseModel());	//직종명
		typOccuCd.setEnabled(true);
		pyspGrdeCd.setValue(new BaseModel());
		bggLogSvcYrNumCd.setValue(new BaseModel());
		dtilOccuJbfmlDivCd.setValue(new BaseModel());
		pyspGrdeCd.setEnabled(true);
		//pyspGrdeCd.select(0);					//호봉등급
		dtilOccuClsNm.setValue("");				//직종세명
		dtilOccuClsCtnt.setValue("");			//직종세내용
		dtilOccuClsOrd.setValue("");			//순서
		dtilOccuClsUseYn.setValue(false);		//직종세사용여부
		chngTgtYn.setValue(false);				//전환제외대상여부
		//actionDatabase = ActionDatabase.INSERT;
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
