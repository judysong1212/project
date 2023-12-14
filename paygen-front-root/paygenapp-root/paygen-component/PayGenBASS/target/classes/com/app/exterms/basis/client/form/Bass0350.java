package com.app.exterms.basis.client.form;

import java.util.Date;
import java.util.HashMap;

import com.app.exterms.basis.client.dto.Bass0350DTO;
import com.app.exterms.basis.client.form.defs.Bass0350Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass0350Service;
import com.app.exterms.basis.client.service.Bass0350ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
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
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
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
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Bass0350.java
 * @Description : 직종세관리
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
public class Bass0350 extends MSFPanel {
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
	private BasisConstants lblBasisConst = BasisConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmBass0350;
	// private FormData formData;
	private String txtForm = ""; 

	public Bass0350DTO bass0350Dto = new Bass0350DTO();
	public FormBinding formBinding;
	public FormBinding srhFormBinding;

	private Bass0350Def bass0350Def = new Bass0350Def(); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;O
	private MSFGridPanel msfBass0350GridPanel;
	
	//파일업로드처리 부분  
    private FileUploadField bass0350flUp;
    private Boolean picBoolFile;

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
	private ButtonBar topBass0350Bar;
	private Button btnBass0350New;
	private Button btnBass0350Save;
	private Button btnBass0350Del;
	private Button btnBass0350Sreach;

	private Button btnBass0350Trnr;						//이관 버튼
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -- 검색 조건 시작
	private ComboBox<BaseModel> srhTypOccuCd; 		//직종명
	private TextField<String> srhDtilOccuClsNm; 	//직종세명
	private CheckBox srhDtilOccuClsUseYn; 					// 직종세사용여부
	private CheckBoxGroup srhDtilOccuClsUseGrp; 			// 체크박스그룹
	private CheckBoxGroup dtilTermUseYnGrp;
	// -- 검색 조건 끝
	

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	//-------------------------------------------------------- 하위 탭 시작
	private TabPanel tabsBass0350; // 하위 탭 정보
		
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
	
	private MSFComboBox<BaseModel> dtilOcclsApptnUcstCd; 	//  직종세적용단가구분코드
	private MSFNumberField dtilOcclsApptnUcstSum; 			//  직종세적용단가금액
	private MSFComboBox<BaseModel> chngTypOccuCd; 			//  개편전직종코드
	private MSFComboBox<BaseModel> chngDtilOccuInttnCd; 	// 	개편전직종세코드
	private MSFDateField dtilOccuInttnStdt;					//	직종세시작일자
	private MSFDateField dtilOccuInttnEddt;					//	직종세종료일자
	
	private MSFComboBox<BaseModel> dtilOccuInttnAccCd; 	// 	직종세회계코드
	private CheckBox dtilTermUseYn; 	// 	기간제사용여부
	private MSFTextField dtilOcclsApptnUcstDys;
	
	
	
	// -------------- 하위 탭 종료 --------------
 
	// -------------- 서비스 호출 시작 --------------
	private Bass0350ServiceAsync bass0350Service = Bass0350Service.Util.getInstance();	// 입력수정삭제처리 rpc 처리부
	// -------------- 서비스 호출 시작 --------------


	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto;
 	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	private PrgmComBass0350DTO sysComBass0350Dto; 	//직종세
	// -------------- DTO 선언 종료 --------------
	
	private BaseModel record;
	private Date today = new Date();
	
	private BaseModel bmData = new BaseModel();
	// -------------- store 선언 시작 ---------------
//	private ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>();	//직종
	private ListStore<BaseModel> listStoreA006 = new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> listStoreB032 = new ListStore<BaseModel>();	//단가코드
	private ListStore<BaseModel> listStoreB002 = new ListStore<BaseModel>();	//회계코드
//	private ListStore<BaseModel> lsTypOccuCd 	= new ListStore<BaseModel>();		//직종 
//	private ListStore<BaseModel> lsPyspGrdeCd 	= new ListStore<BaseModel>();		//호봉등급
	// 공통 코드 - 직종코드
//	private ListStore<BaseModel> srhTypOccuListStore = new ListStore<BaseModel>();
 	private ListStore<BaseModel> typOccuListStore = new ListStore<BaseModel>();
 	private ListStore<BaseModel> dtilOccuJbfmlDivCdStore = new ListStore<BaseModel>();  //직군 
 	private ListStore<BaseModel> bggLogSvcYrNumCdStore = new ListStore<BaseModel>();	//최대근속년수
 	
 	private ListStore<BaseModel> stTypOccuCd = new ListStore<BaseModel>();			//직종 상세
    private ListStore<BaseModel> stDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세 상세
 	
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
			if (ce.getButton() == btnBass0350Save) {
				if((ActionDatabase.INSERT).equals(actionDatabase)) {
					doAction(ActionDatabase.INSERT);
					actionDatabase = ActionDatabase.UPDATE;
				}else {
					doAction(ActionDatabase.UPDATE);
				}
				//actionDatabase = null;
			}else if (ce.getButton() == btnBass0350Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
	
//		public void componentSelected(ButtonEvent ce) {
//			if (ActionDatabase.INSERT.equals(actionDatabase)) {
//				//actionDatabase = null;
//				if (ce.getButton() == btnBass0350Save) {
//					doAction(ActionDatabase.INSERT);
//				}
//				actionDatabase = ActionDatabase.UPDATE;
//			}else if (ce.getButton() == btnBass0350Save) {
//				if("INSERT".equals(ActionDatabase.INSERT)) {
//					doAction(ActionDatabase.INSERT);
//				}else {
//					doAction(ActionDatabase.UPDATE);
//				}
//				
//				//actionDatabase = null;
//			}else if (ce.getButton() == btnBass0350Del) {
//				doAction(ActionDatabase.DELETE);
//			}
//		}
		/**
		public void componentSelected(ButtonEvent ce) {
			if (ce.getButton() == btnBass0350Save) {
				doAction(ActionDatabase.INSERT);
			} else if (ce.getButton() == btnBass0350Save) {
				doAction(ActionDatabase.UPDATE);
			} else if (ce.getButton() == btnBass0350Del) {
				doAction(ActionDatabase.DELETE);
			}

		}
		*/
	};
	
//	/** ComboBox 선택 이벤트_상세조건  한번에 직종세 못 물어오는 경우*/
//	private SelectionChangedListener<BaseModel> selectionChangeListener = new SelectionChangedListener<BaseModel>() {
//        public void selectionChanged(SelectionChangedEvent<BaseModel> se) { 
//            //직종변경에 따른 직종세 값 가져오기
//            String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(chngTypOccuCd,"typOccuCd");
//            if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//				if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
//					stDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
//					chngDtilOccuInttnCd.setStore(stDtilOccuInttnCd); 
//					stDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() { 							
//                		  public void handleEvent(StoreEvent<BaseModel> be) {  
//                			  
////                			  Window.alert(""+(String)bmData.get("chngDtilOccuInttnCd"));
//			    		  	  BasisUtil.setSelectedComboValue(chngDtilOccuInttnCd, (String)bmData.get("chngDtilOccuInttnCd"),"dtilOccuInttnCd");
//			    		  			    		  	 
//                		  }
//                	  }); 
//                }
//            }    
//        } 
//	};
	
	

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}
	
	public void save(final ActionDatabase actionDatabase){
		//|| "".equals(BasisUtil.getConvertDateToString(dtilOccuInttnEddt, "yyyyMMdd"))
		final Bass0350DTO dto = new Bass0350DTO();
		if( "".equals(BasisUtil.getSelectedComboValue(typOccuCd,"typOccuCd")) ){
			MessageBox.info("", "직종을 선택하여 주세요.", null);
		}else if(dtilOccuInttnStdt.getValue() == null || dtilOccuInttnEddt.getValue() == null){
			MessageBox.info("", "기간 설정이 잘못되었습니다. 확인하십시요.", null); 
		}else if(GregorianCalendar.compareDate(dtilOccuInttnStdt.getValue(), dtilOccuInttnEddt.getValue()) < 0){
			MessageBox.info("", "기간 설정이 잘못되었습니다. 확인하십시요.", null); 
		}else{
//			dto.setDpobCd(dpobCd.getValue());									
			dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());						//사업장코드
			dto.setTypOccuCd(BasisUtil.getSelectedComboValue(typOccuCd,"typOccuCd"));	//직종코드
			dto.setDtilOccuClsDivCd(dtilOccuClsDivCd.getValue());						//직종세구분코드
			dto.setPyspGrdeCd(BasisUtil.getSelectedComboValue(pyspGrdeCd));				//호봉등급코드
			
			dto.setDtilOccuJbfmlDivCd(BasisUtil.getSelectedComboValue(dtilOccuJbfmlDivCd));	//직군
			dto.setBggLogSvcYrNumCd(BasisUtil.getSelectedComboValue(bggLogSvcYrNumCd));		//최대근속년수
			
			
			dto.setDtilOccuClsNm(dtilOccuClsNm.getValue());								//직종세명
			dto.setDtilOccuClsCtnt(dtilOccuClsCtnt.getValue());							//직종세내용
			dto.setDtilOccuClsOrd(dtilOccuClsOrd.getValue());							//순서
			dto.setDtilOccuClsUseYn(dtilOccuClsUseYn.getValue() ? "Y" : "N");			//직종세사용여부
			
			dto.setDtilOccuInttnCd(dtilOccuClsDivCd.getValue());
//			dto.setDtilOccuInttnCd(dtilOccuClsDivCd.getValue() + BasisUtil.getSelectedComboValue(pyspGrdeCd));
			
			dto.setChngTgtYn(chngTgtYn.getValue() ? "Y" : "N");							//전환대상여부
			
			dto.setChngTypOccuCd(BasisUtil.getSelectedComboValue(chngTypOccuCd,"typOccuCd"));	/** column 개편전 직종 : chngTypOccuCd */
			dto.setChngDtilOccuInttnCd(BasisUtil.getSelectedComboValue(chngDtilOccuInttnCd,"dtilOccuInttnCd"));	/** column 개편전 직종세 : chngDtilOccuInttnCd */
			dto.setDtilOcclsApptnUcstCd(BasisUtil.getSelectedComboValue(dtilOcclsApptnUcstCd,"commCd"));	/** column 직종세 전용단가코드 : dtilOcclsApptnUcstCd */
			dto.setDtilOcclsApptnUcstSum((Long)dtilOcclsApptnUcstSum.getValue());	/** column 직종세 전용단가 : dtilOcclsApptnUcstSum */
			dto.setDtilOccuInttnStdt(BasisUtil.getConvertDateToString(dtilOccuInttnStdt, "yyyyMMdd"));	/** column 시작일자 : dtilOccuInttnStdt */
			dto.setDtilOccuInttnEddt(BasisUtil.getConvertDateToString(dtilOccuInttnEddt, "yyyyMMdd"));	/** column 종료일자 : dtilOccuInttnEddt */
					
			// 회계코드, 기간제 사용여부, 단가일수 우선 숨김
//			dto.setDtilOccuInttnAccCd(BasisUtil.getSelectedComboValue(dtilOccuInttnAccCd,"commCd")); /** column 직종제회계코드 : dtilOccuInttnAccCd */
//			dto.setDtilTermUseYn(dtilTermUseYn.getValue() ? "Y" : "N"); /** column 기간게사용여부 : dtilTermUseYn */
//			dto.setDtilOcclsApptnUcstDys(dtilOcclsApptnUcstDys.getValue()); /** column 직종세 단가일수 : dtilOcclsApptnUcstDys */ 
			
			MessageBox.confirm("","DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){						
						bass0350Service.saveBass0350(dto, actionDatabase, new AsyncCallback<String>() {
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
				                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0350(" + actionDatabase.name() + ") : " + caught)
				                        , null);
							}
						});
						formBass0350Init();
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
			//createStandardForm(); 	// 상세정보
			createTabForm();		// 탭 구성
			createSubForm();		// 엑셀업로드
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "750px");

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
	public Bass0350() {
		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Bass0350(String txtForm) {
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

		plFrmBass0350 = new FormPanel();
		plFrmBass0350.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - ") + lblBasisConst.title_Bass0350());
		plFrmBass0350.setIcon(Resources.APP_ICONS.text());
		plFrmBass0350.setPadding(2);
		plFrmBass0350.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblBasisConst.title_Bass0350(),"BASS0350");
				}
			});
		plFrmBass0350.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0350.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmBass0350.setFrame(true);
		//엣지변환
		//plFrmBass0350.setSize("990px", "680px");
		plFrmBass0350.setSize("990px", "730px");
		
		LayoutContainer lc = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1 = new LayoutContainer();
		LayoutContainer lc2 = new LayoutContainer();
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.LEFT);
		
		btnBass0350Trnr = new Button("개편 직종-직종세 이관");
		btnBass0350Trnr.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			
    			BassP035001 bassP03501Form = new BassP035001(ActionDatabase.READ, getThis());   
				    
				MSFFormWindows msFwBass03501 = new MSFFormWindows("개편 직종-직종세 이관", bassP03501Form, "닫기", "820px", "710px", true);
				msFwBass03501.show();
				bassP03501Form.setMSFFormWindows(msFwBass03501);
				
    		}
    	});
		
		btnBar.add(btnBass0350Trnr);
		lc1.add(btnBar);

		topBass0350Bar = new ButtonBar();
		topBass0350Bar.setAlignment(HorizontalAlignment.RIGHT);

		// 신규
		btnBass0350New = new Button("신규");
		btnBass0350New.setIcon(Resources.APP_ICONS.new16());
		topBass0350Bar.add(btnBass0350New);
		btnBass0350New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//신규 버튼 클릭시 처리     
    			formBass0350Init();  
    			pyspGrdeCd.setEnabled(true);
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
		btnBass0350Save = new Button("저장");
		btnBass0350Save.setIcon(Resources.APP_ICONS.save16());
		topBass0350Bar.add(btnBass0350Save);
		btnBass0350Save.addSelectionListener(selectionListener);

		// 삭제
		btnBass0350Del = new Button("삭제");
		btnBass0350Del.setIcon(Resources.APP_ICONS.delete16());
		topBass0350Bar.add(btnBass0350Del);
		btnBass0350Del.addSelectionListener(selectionListener);

		// 검색
		btnBass0350Sreach = new Button("조회");
		btnBass0350Sreach.setIcon(Resources.APP_ICONS.search16());
		topBass0350Bar.add(btnBass0350Sreach);
		btnBass0350Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
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

		lc2.add(topBass0350Bar);
		
		lc.add(lc1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lc.add(lc2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		plFrmBass0350.add(lc);

		vp.add(plFrmBass0350);
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
		lsTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);

		plFrmBass0350.setLayout(new FlowLayout());
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
//		lcSchLeftSrhFrm.setStyleAttribute("paddingRight", "200px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//		frmlytSch.setDefaultWidth(100);
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
		
		LayoutContainer lcSchCenterSrhFrm = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenterSrhFrm.setLayout(frmlytSch);
		srhDtilOccuClsNm = new TextField<String>();
		srhDtilOccuClsNm.setName("srhDtilOccuClsNm");
		srhDtilOccuClsNm.setFieldLabel("직종세명");
		lcSchCenterSrhFrm.add(srhDtilOccuClsNm, new FormData("100%"));
		
		LayoutContainer lcSchRightSrhFrm = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchRightSrhFrm.setLayout(frmlytSch);
		
		srhDtilOccuClsUseGrp = new CheckBoxGroup();
		srhDtilOccuClsUseGrp.setName("srhDtilOccuClsUseGrp");
		srhDtilOccuClsUseGrp.setLabelSeparator("");
		
		srhDtilOccuClsUseYn = new CheckBox();
		srhDtilOccuClsUseYn.setName("srhDtilOccuClsUseYn");
		srhDtilOccuClsUseYn.setBoxLabel("사용여부");
		srhDtilOccuClsUseYn.setValue(true);
		srhDtilOccuClsUseGrp.add(srhDtilOccuClsUseYn);
		srhDtilOccuClsUseYn.setHideLabel(true);
		lcSchRightSrhFrm.add(srhDtilOccuClsUseGrp, new FormData("100%"));

		lcSchColSrhFrm.add(lcSchLeftSrhFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcSchColSrhFrm.add(lcSchCenterSrhFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcSchColSrhFrm.add(lcSchRightSrhFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		fieldSetSrhFrm.add(lcSchColSrhFrm, new FormData("100%"));

		plFrmBass0350.add(fieldSetSrhFrm);
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
	private void createTabForm(){
		tabsBass0350 = new TabPanel(); // 인사탭정보설정을 위한 tab
		
		// tabsBass0350.setMinTabWidth(80);
		tabsBass0350.setAutoWidth(false);
		// tabsBass0350.setResizeTabs(true);
		tabsBass0350.setAnimScroll(true);
		tabsBass0350.setTabScroll(true);
		tabsBass0350.setPlain(true);
		tabsBass0350.setSize(970, 200);

		TabItem itemBass0350 = new TabItem();
		itemBass0350.setId("itemBass0350");
//		itemBass0350.setStyleAttribute("padding", "1"); 
		itemBass0350.setText("상세정보");
//		itemBass0350.addStyleName("pad-text");
		itemBass0350.setLayout(new FormLayout());
		itemBass0350.add(detailImfo01(), new FormData("100%"));
		tabsBass0350.add(itemBass0350);

		TabItem itemBass0351 = new TabItem();
		//itemBass0351.setStyleAttribute("padding", "10px");
		itemBass0351.setId("itemBass0351");
		itemBass0351.setText("설정정보");
		itemBass0351.setLayout(new FormLayout());
		itemBass0351.add(settingInfo01(), new FormData("100%"));
		tabsBass0350.add(itemBass0351);
		
		plFrmBass0350.add(tabsBass0350, new FormData("100%"));
	}
	
	// 상세정보 탭
	private LayoutContainer detailImfo01(){
		 
		sysComBass0300Dto = new PrgmComBass0300DTO();		        
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
		
		stTypOccuCd = new ListStore<BaseModel>();
		stTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		    
//		stDtilOccuInttnCd = new ListStore<BaseModel>();
		sysComBass0350Dto = new PrgmComBass0350DTO(); 
		sysComBass0350Dto.setDpobCd("20144050000001");
		stDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
		
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		sysComBass0300Dto.setRpsttvCd("B032");
		listStoreB032 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		sysComBass0300Dto.setRpsttvCd("B002");
		listStoreB002 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		dpobCd = new HiddenField<String>();
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel di01 = new ContentPanel();
		di01.setHeaderVisible(false);
		di01.setFrame(true);
		di01.setSize(968, 198);
		di01.setLayout(new FitLayout());
		
		LayoutContainer lcStd01 = new LayoutContainer();
		//lcStd01.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd1 = new FormLayout();
		frmlytStd1.setLabelWidth(100);
		frmlytStd1.setLabelAlign(LabelAlign.RIGHT);
		lcStd01.setLayout(frmlytStd1);
		
		LayoutContainer lcStdColFrm = new LayoutContainer();
		lcStdColFrm.setLayout(new ColumnLayout());
		
		LayoutContainer lcStdLeftFrm = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
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
		
		LayoutContainer lcStdColFrm2 = new LayoutContainer();
		lcStdColFrm2.setLayout(new ColumnLayout());		
		
		LayoutContainer lcStdLeftFrm2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm2.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm3.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm2.setLayout(frmlytStd);

		LayoutContainer lcStdRightFrm3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm3.setLayout(frmlytStd);
		
		LayoutContainer lcStdColFrm3 = new LayoutContainer();
		lcStdColFrm3.setLayout(new ColumnLayout());	
		
		LayoutContainer lcStdLeftFrm3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm3.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm4.setLayout(frmlytStd);
		
		LayoutContainer lcStdRightFrm4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm4.setLayout(frmlytStd);
		
		dtilOccuClsDivCd = new MSFTextField();
		dtilOccuClsDivCd.setReadOnly(true);
		dtilOccuClsDivCd.setName("dtilOccuClsDivCd");
		dtilOccuClsDivCd.setFieldLabel("직종세코드");
		lcStdLeftFrm.add(dtilOccuClsDivCd, new FormData("100%"));
		
		dtilOccuClsNm = new MSFTextField();
		dtilOccuClsNm.setName("dtilOccuClsNm");
		dtilOccuClsNm.setFieldLabel("직종세명");
		lcStdLeftFrm.add(dtilOccuClsNm, new FormData("100%"));
		
		dtilOccuClsCtnt = new MSFTextField();
		dtilOccuClsCtnt.setName("dtilOccuClsCtnt");
		dtilOccuClsCtnt.setFieldLabel("직종세내용");
		lcStdRightFrm2.add(dtilOccuClsCtnt, new FormData("100%"));
		
		ListStore<BaseModel> lsTypOccuCd 	= new ListStore<BaseModel>();		//직종 		
//		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		
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
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		sub03.setLayout(frmlytStd);
		
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
//                sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
//                    lsDtilOccuClsDivCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
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
//		dtilOccuClsOrd.setAllowDecimals(true);
//		dtilOccuClsOrd.setPropertyEditorType(Long.class); 
//		dtilOccuClsOrd.setFormat(NumberFormat.getDecimalFormat());
//		dtilOccuClsOrd.getMessages().setRegexText("숫자만 입력가능합니다.");
		sub02.add(dtilOccuClsOrd, new FormData("100%"));
		lcSub01.add(sub01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSub01.add(sub02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcStdRightFrm.add(lcSub01, new FormData("100%")); 
		
			
		dtilOccuInttnStdt = new MSFDateField(); 
		dtilOccuInttnStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		dtilOccuInttnStdt.setName("dtilOccuInttnStdt");				 
		new DateFieldMask(dtilOccuInttnStdt, "9999.99.99");
		dtilOccuInttnStdt.setFieldLabel("시작일자");
		dtilOccuInttnStdt.setMinLength(10);
		dtilOccuInttnStdt.setMaxLength(10);
		lcStdCenterFrm2.add(dtilOccuInttnStdt, new FormData("100%"));

		dtilOccuInttnEddt = new MSFDateField(); 
		dtilOccuInttnEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		dtilOccuInttnEddt.setName("dtilOccuInttnEddt");				 
		new DateFieldMask(dtilOccuInttnEddt, "9999.99.99");
		dtilOccuInttnEddt.setFieldLabel("종료일자");
		dtilOccuInttnEddt.setMinLength(10);
		dtilOccuInttnEddt.setMaxLength(10);
		lcStdRightFrm3.add(dtilOccuInttnEddt, new FormData("100%"));
		
		chngTypOccuCd = new MSFComboBox<BaseModel>(); 
		chngTypOccuCd.setName("chngTypOccuCd");
		chngTypOccuCd.setFieldLabel("개편전직종");
		chngTypOccuCd.setForceSelection(true);				 
		chngTypOccuCd.setMinChars(1);
		chngTypOccuCd.setDisplayField("typOccuNm");		
		chngTypOccuCd.setValueField("typOccuCd");		
		chngTypOccuCd.setTriggerAction(TriggerAction.ALL);
		chngTypOccuCd.setEmptyText("--개편전 직종선택--");
		chngTypOccuCd.setSelectOnFocus(true);
		chngTypOccuCd.setReadOnly(false);
		chngTypOccuCd.setEnabled(true);
		chngTypOccuCd.setStore(stTypOccuCd);
//		chngTypOccuCd.addSelectionChangedListener(selectionChangeListener);
		lcStdLeftFrm2.add(chngTypOccuCd, new FormData("100%"));
		
		chngDtilOccuInttnCd = new MSFComboBox<BaseModel>(); // 개편전 직종세를 가져와야 한다.
		chngDtilOccuInttnCd.setName("chngDtilOccuInttnCd");
		chngDtilOccuInttnCd.setFieldLabel("개편전직종세");
		chngDtilOccuInttnCd.setForceSelection(true);				 
		chngDtilOccuInttnCd.setMinChars(1);
		chngDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");		
		chngDtilOccuInttnCd.setValueField("dtilOccuInttnCd");		
		chngDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
		chngDtilOccuInttnCd.setEmptyText("--개편전 직종세선택--");
		chngDtilOccuInttnCd.setSelectOnFocus(true);
		chngDtilOccuInttnCd.setReadOnly(false);
		chngDtilOccuInttnCd.setEnabled(true);
		chngDtilOccuInttnCd.setStore(stDtilOccuInttnCd);
		lcStdCenterFrm3.add(chngDtilOccuInttnCd, new FormData("100%"));
		
		dtilOcclsApptnUcstCd = new MSFComboBox<BaseModel>(); 
		dtilOcclsApptnUcstCd.setName("dtilOcclsApptnUcstCd");
		dtilOcclsApptnUcstCd.setFieldLabel("적용단가");
		dtilOcclsApptnUcstCd.setForceSelection(true);				 
		dtilOcclsApptnUcstCd.setMinChars(1);
		dtilOcclsApptnUcstCd.setDisplayField("commCdNm");		
		dtilOcclsApptnUcstCd.setValueField("commCd");		
		dtilOcclsApptnUcstCd.setTriggerAction(TriggerAction.ALL);
		dtilOcclsApptnUcstCd.setEmptyText("--적용단가--");
		dtilOcclsApptnUcstCd.setSelectOnFocus(true);
		dtilOcclsApptnUcstCd.setReadOnly(false);
		dtilOcclsApptnUcstCd.setEnabled(true);
		dtilOcclsApptnUcstCd.setStore(listStoreB032);
		lcStdLeftFrm3.add(dtilOcclsApptnUcstCd, new FormData("100%"));
		
		dtilOcclsApptnUcstSum = new MSFNumberField();
		dtilOcclsApptnUcstSum.setName("dtilOcclsApptnUcstSum");
		dtilOcclsApptnUcstSum.setFieldLabel("단가");
		dtilOcclsApptnUcstSum.setReadOnly(true);
		dtilOcclsApptnUcstSum.setRegex("^[0-9]+$"); 
		dtilOcclsApptnUcstSum.setAllowDecimals(true);
		dtilOcclsApptnUcstSum.setPropertyEditorType(Long.class); 
		dtilOcclsApptnUcstSum.setFormat(NumberFormat.getDecimalFormat());
		dtilOcclsApptnUcstSum.getMessages().setRegexText("숫자만 입력가능합니다.");
		lcStdCenterFrm4.add(dtilOcclsApptnUcstSum, new FormData("100%"));
		
		// 회계코드, 기간제 사용여부, 단가일수 우선 숨김
		/*dtilOcclsApptnUcstDys = new MSFTextField();
		dtilOcclsApptnUcstDys.setName("dtilOcclsApptnUcstDys");
		dtilOcclsApptnUcstDys.setFieldLabel("단가일수");
		dtilOcclsApptnUcstDys.setRegex("^[0-9]+$");
		lcStdRightFrm4.add(dtilOcclsApptnUcstDys, new FormData("100%"));
		
		dtilOccuInttnAccCd = new MSFComboBox<BaseModel>(); 
		dtilOccuInttnAccCd.setName("dtilOccuInttnAccCd");
		dtilOccuInttnAccCd.setFieldLabel("회계코드");
		dtilOccuInttnAccCd.setForceSelection(true);				 
		dtilOccuInttnAccCd.setMinChars(1);
		dtilOccuInttnAccCd.setDisplayField("commCdNm");		
		dtilOccuInttnAccCd.setValueField("commCd");		
		dtilOccuInttnAccCd.setTriggerAction(TriggerAction.ALL);
		dtilOccuInttnAccCd.setEmptyText("--회계코드--");
		dtilOccuInttnAccCd.setSelectOnFocus(true);
		dtilOccuInttnAccCd.setReadOnly(false);
		dtilOccuInttnAccCd.setEnabled(true);
		dtilOccuInttnAccCd.setStore(listStoreB002);
		lcStdLeftFrm3.add(dtilOccuInttnAccCd, new FormData("100%"));
		
		dtilTermUseYnGrp = new CheckBoxGroup();
		dtilTermUseYnGrp.setName("dtilOccuClsUseGrp");
		dtilTermUseYnGrp.setLabelSeparator("");
		
		dtilTermUseYn = new CheckBox();
		dtilTermUseYn.setName("dtilTermUseYn");
		dtilTermUseYnGrp.add(dtilTermUseYn);
		dtilTermUseYn.setBoxLabel("기간제 사용여부");
		dtilTermUseYn.setHideLabel(true);
		lcStdCenterFrm4.add(dtilTermUseYnGrp, new FormData("100%"));*/
		
		
		lcStdColFrm.add(lcStdLeftFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm.add(lcStdCenterFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm.add(lcStdRightFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		lcStdColFrm2.add(lcStdLeftFrm2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
		lcStdColFrm2.add(lcStdCenterFrm3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm2.add(lcStdCenterFrm2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.175));
		lcStdColFrm2.add(lcStdRightFrm3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.175));
		
		lcStdColFrm3.add(lcStdLeftFrm3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm3.add(lcStdCenterFrm4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm3.add(lcStdRightFrm4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		lcStd01.add(lcStdColFrm, new FormData("100%"));		
		lcStd01.add(lcStdColFrm2, new FormData("100%"));
		lcStd01.add(lcStdColFrm3, new FormData("100%"));
		lcStd01.add(lcStdRightFrm2, new FormData("100%"));
		
		di01.add(lcStd01);
		lcTabFormLayer.add(di01);
		return lcTabFormLayer;
	}
	
	private LayoutContainer settingInfo01(){
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		ContentPanel si01 = new ContentPanel();
		si01.setHeaderVisible(false);
		si01.setFrame(true);
		si01.setSize(968, 198);
		si01.setLayout(new FitLayout());
		
		lcTabFormLayer.add(si01);
		return lcTabFormLayer;
	}
	/*
	// 상세정보
	private void createStandardForm() {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();		        
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
		
		stTypOccuCd = new ListStore<BaseModel>();
		stTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		    
//		stDtilOccuInttnCd = new ListStore<BaseModel>();
		sysComBass0350Dto = new PrgmComBass0350DTO(); 
		sysComBass0350Dto.setDpobCd("20144050000001");
		stDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
		
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		sysComBass0300Dto.setRpsttvCd("B032");
		listStoreB032 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		sysComBass0300Dto = new PrgmComBass0300DTO(); 
		sysComBass0300Dto.setRpsttvCd("B002");
		listStoreB002 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
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
		frmlytStd.setLabelWidth(80);
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
		
		LayoutContainer lcStdColFrm2 = new LayoutContainer();
		lcStdColFrm2.setLayout(new ColumnLayout());		
		
		LayoutContainer lcStdLeftFrm2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm2.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm3.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm2.setLayout(frmlytStd);

		LayoutContainer lcStdRightFrm3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm3.setLayout(frmlytStd);
		
		LayoutContainer lcStdColFrm3 = new LayoutContainer();
		lcStdColFrm3.setLayout(new ColumnLayout());	
		
		LayoutContainer lcStdLeftFrm3 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm3.setLayout(frmlytStd);
		
		LayoutContainer lcStdCenterFrm4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm4.setLayout(frmlytStd);
		
		LayoutContainer lcStdRightFrm4 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm4.setLayout(frmlytStd);
		
		dtilOccuClsDivCd = new MSFTextField();
		dtilOccuClsDivCd.setReadOnly(true);
		dtilOccuClsDivCd.setName("dtilOccuClsDivCd");
		dtilOccuClsDivCd.setFieldLabel("직종세코드");
		lcStdLeftFrm.add(dtilOccuClsDivCd, new FormData("100%"));
		
		dtilOccuClsNm = new MSFTextField();
		dtilOccuClsNm.setName("dtilOccuClsNm");
		dtilOccuClsNm.setFieldLabel("직종세명");
		lcStdLeftFrm.add(dtilOccuClsNm, new FormData("100%"));
		
		dtilOccuClsCtnt = new MSFTextField();
		dtilOccuClsCtnt.setName("dtilOccuClsCtnt");
		dtilOccuClsCtnt.setFieldLabel("직종세내용");
		lcStdRightFrm2.add(dtilOccuClsCtnt, new FormData("100%"));
		
		ListStore<BaseModel> lsTypOccuCd 	= new ListStore<BaseModel>();		//직종 		
//		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		
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
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		sub03.setLayout(frmlytStd);
		
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
//                sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
//                    lsDtilOccuClsDivCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
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
//		dtilOccuClsOrd.setAllowDecimals(true);
//		dtilOccuClsOrd.setPropertyEditorType(Long.class); 
//		dtilOccuClsOrd.setFormat(NumberFormat.getDecimalFormat());
//		dtilOccuClsOrd.getMessages().setRegexText("숫자만 입력가능합니다.");
		sub02.add(dtilOccuClsOrd, new FormData("100%"));
		lcSub01.add(sub01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSub01.add(sub02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcStdRightFrm.add(lcSub01, new FormData("100%")); 
		
			
		dtilOccuInttnStdt = new MSFDateField(); 
		dtilOccuInttnStdt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		dtilOccuInttnStdt.setName("dtilOccuInttnStdt");				 
		new DateFieldMask(dtilOccuInttnStdt, "9999.99.99");
		dtilOccuInttnStdt.setFieldLabel("시작일자");
		dtilOccuInttnStdt.setMinLength(10);
		dtilOccuInttnStdt.setMaxLength(10);
		lcStdCenterFrm2.add(dtilOccuInttnStdt, new FormData("100%"));

		dtilOccuInttnEddt = new MSFDateField(); 
		dtilOccuInttnEddt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		dtilOccuInttnEddt.setName("dtilOccuInttnEddt");				 
		new DateFieldMask(dtilOccuInttnEddt, "9999.99.99");
		dtilOccuInttnEddt.setFieldLabel("종료일자");
		dtilOccuInttnEddt.setMinLength(10);
		dtilOccuInttnEddt.setMaxLength(10);
		lcStdRightFrm3.add(dtilOccuInttnEddt, new FormData("100%"));
		
		chngTypOccuCd = new MSFComboBox<BaseModel>(); 
		chngTypOccuCd.setName("chngTypOccuCd");
		chngTypOccuCd.setFieldLabel("개편전직종");
		chngTypOccuCd.setForceSelection(true);				 
		chngTypOccuCd.setMinChars(1);
		chngTypOccuCd.setDisplayField("typOccuNm");		
		chngTypOccuCd.setValueField("typOccuCd");		
		chngTypOccuCd.setTriggerAction(TriggerAction.ALL);
		chngTypOccuCd.setEmptyText("--개편전 직종선택--");
		chngTypOccuCd.setSelectOnFocus(true);
		chngTypOccuCd.setReadOnly(false);
		chngTypOccuCd.setEnabled(true);
		chngTypOccuCd.setStore(stTypOccuCd);
//		chngTypOccuCd.addSelectionChangedListener(selectionChangeListener);
		lcStdLeftFrm2.add(chngTypOccuCd, new FormData("100%"));
		
		chngDtilOccuInttnCd = new MSFComboBox<BaseModel>(); // 개편전 직종세를 가져와야 한다.
		chngDtilOccuInttnCd.setName("chngDtilOccuInttnCd");
		chngDtilOccuInttnCd.setFieldLabel("개편전직종세");
		chngDtilOccuInttnCd.setForceSelection(true);				 
		chngDtilOccuInttnCd.setMinChars(1);
		chngDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");		
		chngDtilOccuInttnCd.setValueField("dtilOccuInttnCd");		
		chngDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
		chngDtilOccuInttnCd.setEmptyText("--개편전 직종세선택--");
		chngDtilOccuInttnCd.setSelectOnFocus(true);
		chngDtilOccuInttnCd.setReadOnly(false);
		chngDtilOccuInttnCd.setEnabled(true);
		chngDtilOccuInttnCd.setStore(stDtilOccuInttnCd);
		lcStdCenterFrm3.add(chngDtilOccuInttnCd, new FormData("100%"));
		
		dtilOcclsApptnUcstCd = new MSFComboBox<BaseModel>(); 
		dtilOcclsApptnUcstCd.setName("dtilOcclsApptnUcstCd");
		dtilOcclsApptnUcstCd.setFieldLabel("적용단가");
		dtilOcclsApptnUcstCd.setForceSelection(true);				 
		dtilOcclsApptnUcstCd.setMinChars(1);
		dtilOcclsApptnUcstCd.setDisplayField("commCdNm");		
		dtilOcclsApptnUcstCd.setValueField("commCd");		
		dtilOcclsApptnUcstCd.setTriggerAction(TriggerAction.ALL);
		dtilOcclsApptnUcstCd.setEmptyText("--적용단가--");
		dtilOcclsApptnUcstCd.setSelectOnFocus(true);
		dtilOcclsApptnUcstCd.setReadOnly(false);
		dtilOcclsApptnUcstCd.setEnabled(true);
		dtilOcclsApptnUcstCd.setStore(listStoreB032);
		lcStdLeftFrm3.add(dtilOcclsApptnUcstCd, new FormData("100%"));
		
		dtilOcclsApptnUcstSum = new MSFNumberField();
		dtilOcclsApptnUcstSum.setName("dtilOcclsApptnUcstSum");
		dtilOcclsApptnUcstSum.setFieldLabel("단가");
		dtilOcclsApptnUcstSum.setReadOnly(true);
		dtilOcclsApptnUcstSum.setRegex("^[0-9]+$"); 
		dtilOcclsApptnUcstSum.setAllowDecimals(true);
		dtilOcclsApptnUcstSum.setPropertyEditorType(Long.class); 
		dtilOcclsApptnUcstSum.setFormat(NumberFormat.getDecimalFormat());
		dtilOcclsApptnUcstSum.getMessages().setRegexText("숫자만 입력가능합니다.");
		lcStdCenterFrm4.add(dtilOcclsApptnUcstSum, new FormData("100%"));
		
		// 회계코드, 기간제 사용여부, 단가일수 우선 숨김
		dtilOcclsApptnUcstDys = new MSFTextField();
		dtilOcclsApptnUcstDys.setName("dtilOcclsApptnUcstDys");
		dtilOcclsApptnUcstDys.setFieldLabel("단가일수");
		dtilOcclsApptnUcstDys.setRegex("^[0-9]+$");
		lcStdRightFrm4.add(dtilOcclsApptnUcstDys, new FormData("100%"));
		
		dtilOccuInttnAccCd = new MSFComboBox<BaseModel>(); 
		dtilOccuInttnAccCd.setName("dtilOccuInttnAccCd");
		dtilOccuInttnAccCd.setFieldLabel("회계코드");
		dtilOccuInttnAccCd.setForceSelection(true);				 
		dtilOccuInttnAccCd.setMinChars(1);
		dtilOccuInttnAccCd.setDisplayField("commCdNm");		
		dtilOccuInttnAccCd.setValueField("commCd");		
		dtilOccuInttnAccCd.setTriggerAction(TriggerAction.ALL);
		dtilOccuInttnAccCd.setEmptyText("--회계코드--");
		dtilOccuInttnAccCd.setSelectOnFocus(true);
		dtilOccuInttnAccCd.setReadOnly(false);
		dtilOccuInttnAccCd.setEnabled(true);
		dtilOccuInttnAccCd.setStore(listStoreB002);
		lcStdLeftFrm3.add(dtilOccuInttnAccCd, new FormData("100%"));
		
		dtilTermUseYnGrp = new CheckBoxGroup();
		dtilTermUseYnGrp.setName("dtilOccuClsUseGrp");
		dtilTermUseYnGrp.setLabelSeparator("");
		
		dtilTermUseYn = new CheckBox();
		dtilTermUseYn.setName("dtilTermUseYn");
		dtilTermUseYnGrp.add(dtilTermUseYn);
		dtilTermUseYn.setBoxLabel("기간제 사용여부");
		dtilTermUseYn.setHideLabel(true);
		lcStdCenterFrm4.add(dtilTermUseYnGrp, new FormData("100%"));
		
		
		lcStdColFrm.add(lcStdLeftFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm.add(lcStdCenterFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm.add(lcStdRightFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		lcStdColFrm2.add(lcStdLeftFrm2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
		lcStdColFrm2.add(lcStdCenterFrm3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm2.add(lcStdCenterFrm2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.175));
		lcStdColFrm2.add(lcStdRightFrm3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.175));
		
		lcStdColFrm3.add(lcStdLeftFrm3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColFrm3.add(lcStdCenterFrm4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColFrm3.add(lcStdRightFrm4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		fieldSetFrm.add(lcStdColFrm, new FormData("100%"));		
		fieldSetFrm.add(lcStdColFrm2, new FormData("100%"));
		fieldSetFrm.add(lcStdColFrm3, new FormData("100%"));
		fieldSetFrm.add(lcStdRightFrm2, new FormData("100%"));
		

		plFrmBass0350.add(fieldSetFrm);
		// vp.add(panel);
	}*/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 종료
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
		cpGrid.setSize(940, 300);	

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		msfBass0350GridPanel = new MSFGridPanel(bass0350Def, false, false, false, true);
		msfBass0350GridPanel.setHeaderVisible(false);
		
		final Grid<BaseModel> grid = msfBass0350GridPanel.getMsfGrid().getGrid();
		grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {				
				if (msfBass0350GridPanel.getCurrentlySelectedItem() != null){
					
					bmData = new BaseModel();
	        		bmData = msfBass0350GridPanel.getCurrentlySelectedItem();
				
			
	        		BasisUtil.setSelectedComboValue(chngDtilOccuInttnCd, (String)bmData.get("chngDtilOccuInttnCd"),"dtilOccuInttnCd");/** column 개편전 직종세 : chngDtilOccuInttnCd */
	        		chngDtilOccuInttnCd.setEnabled(false);
	        	
	        		typOccuCd.setValue(typOccuCd.getStore().findModel("typOccuCd", (String)grid.getSelectionModel().getSelectedItem().get("typOccuCd"))); 
	        		pyspGrdeCd.setValue(pyspGrdeCd.getStore().findModel("commCd", (String)grid.getSelectionModel().getSelectedItem().get("pyspGrdeCd"))); 
	        		pyspGrdeCd.setEnabled(false);
					//BasisUtil.setSelectedComboValue(typOccuCd, grid.getSelectionModel().getSelectedItem().get("typOccuCd")+"");
	        		//BasisUtil.setSelectedComboValue(pyspGrdeCd, grid.getSelectionModel().getSelectedItem().get("pyspGrdeCd")+"");
				
	        		bggLogSvcYrNumCd.setValue(bggLogSvcYrNumCd.getStore().findModel("commCd", MSFSharedUtils.allowNulls(grid.getSelectionModel().getSelectedItem().get("bggLogSvcYrNumCd"))));
				
	        		dpobCd.setValue(grid.getSelectionModel().getSelectedItem().get("dpobCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dpobCd")+"");
	        		dtilOccuClsDivCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dtilOccuInttnCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dtilOccuInttnCd")+"");
				
	        		dtilOccuJbfmlDivCd.setValue(dtilOccuJbfmlDivCd.getStore().findModel("commCd", MSFSharedUtils.allowNulls(grid.getSelectionModel().getSelectedItem().get("dtilOccuJbfmlDivCd"))));
				
	        		dtilOccuClsNm.setValue(grid.getSelectionModel().getSelectedItem().get("dtilOccuClsNm") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dtilOccuClsNm")+"");
	        		dtilOccuClsCtnt.setValue(grid.getSelectionModel().getSelectedItem().get("dtilOccuClsCtnt") == null ? "" : grid.getSelectionModel().getSelectedItem().get("dtilOccuClsCtnt")+"");
//					Window.alert(""+(String)bmData.get("dtilOcclsApptnUcstCd"));
					dtilOccuClsOrd.setValue(MSFSharedUtils.allowNulls(bmData.get("dtilOccuClsOrd")));
				
				
					dtilOccuClsUseYn.setValue((Boolean) grid.getSelectionModel().getSelectedItem().get("dtilOccuClsUseYn"));
					chngTgtYn.setValue((Boolean) grid.getSelectionModel().getSelectedItem().get("chngTgtYn"));
				
				
					chngTypOccuCd.setEnabled(false);
					BasisUtil.setSelectedComboValue(chngTypOccuCd, (String)bmData.get("chngTypOccuCd"),"typOccuCd");/** column 개편전 직종 : chngTypOccuCd */
					dtilOcclsApptnUcstCd.setEnabled(false);
					BasisUtil.setSelectedComboValue(dtilOcclsApptnUcstCd, (String)bmData.get("dtilOcclsApptnUcstCd"),"commCd");/** column 직종세 전용단가코드 : dtilOcclsApptnUcstCd */
					dtilOcclsApptnUcstSum.setValue((Long)bmData.get("dtilOcclsApptnUcstSum"));/** column 직종세 전용단가 : dtilOcclsApptnUcstSum */
					dtilOccuInttnStdt.setValue(BasisUtil.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("dtilOccuInttnStdt"), "yyyyMMdd"));/** column 시작일자 : dtilOccuInttnStdt */
					dtilOccuInttnEddt.setValue(BasisUtil.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("dtilOccuInttnEddt"), "yyyyMMdd"));/** column 종료일자 : dtilOccuInttnEddt */
					
					// 회계코드, 기간제 사용여부, 단가일수 우선 숨김
//					BasisUtil.setSelectedComboValue(dtilOccuInttnAccCd, (String)bmData.get("dtilOccuInttnAccCd"),"commCd"); /** column 직종제회계코드 : dtilOccuInttnAccCd */
//					dtilTermUseYn.setValue((Boolean) grid.getSelectionModel().getSelectedItem().get("dtilTermUseYn"));  /** column 기간게사용여부 : dtilTermUseYn */
//					dtilOcclsApptnUcstDys.setValue(MSFSharedUtils.allowNulls(bmData.get("dtilOcclsApptnUcstDys"))); /** column 직종세단가일수 : dtilOcclsApptnUcstDys */
				}
			}
		});

		cpGrid.add(msfBass0350GridPanel);
		// grid.setHeight("147px");

		lcStdGrid.add(cpGrid);
		fieldSetGrd.add(lcStdGrid);

		plFrmBass0350.add(fieldSetGrd, new FormData("0% -475"));

	}
	
	/**
	 * Excel 
	 */
	  private void createSubForm() {
		  
		FieldSet fldstNewFieldset = new FieldSet();	
		fldstNewFieldset.setHeadingHtml("");
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
	    
	    bass0350flUp = new FileUploadField();
	    bass0350flUp.setName("bass0350flUp");
	    bass0350flUp.setValidator(new Validator() {  
                @Override  public String validate(Field<?> field, String value) { 
                    value = value.toLowerCase();        
                    String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
                    if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
                        result = null;        
                        }        
                    return result;  
                    } 
                });
		layoutContainer_2_1.add(bass0350flUp, new FormData("100%"));
		bass0350flUp.setFieldLabel("직종세");
		
		Button btnButton01 = new Button("양식업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  
              	xlsImportData(); 
                    
              }
          });
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		

		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  
                xlsExportData();
                    
              }
          }); 		
		layoutContainer_4.add(btnButton02, new FormData("100%"));
		
		layoutContainer_2.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);
		
		plFrmBass0350.add(fldstNewFieldset);
			
	  } 
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/* 엑셀 업로드 */
	  private void xlsImportData() {
		  MessageBox.confirm("직종세 생성", "직종세를 생성하시겠습니까?<br>",new Listener<MessageBoxEvent>(){
		      	@Override
		    	public void handleEvent(MessageBoxEvent be) {
		      		//if("Yes".equals(be.getButtonClicked().getText())){
		      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
		      			
		      			String filename = MSFSharedUtils.allowNulls(bass0350flUp.getValue());
	              		if (filename.length() == 0) {
	              			Window.alert("선택된 파일이 없습니다.");
	              			return;
	                	} else {
	                		//submit the form
	                		plFrmBass0350.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                		//파일업로드 처리
	                		plFrmBass0350.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadBass0350Import.do");
	                		plFrmBass0350.setEncoding(Encoding.MULTIPART);
	                		plFrmBass0350.setMethod(Method.POST);   
	                		plFrmBass0350.submit();  
	                		plFrmBass0350.onFrameLoad();  
	                    	picBoolFile = true;	 
	                    	
	                	}
	              		// reset and unmask the form 
                    	// after file upload 
	              		plFrmBass0350.addListener(Events.Submit, new Listener<FormEvent>() {
                    		public void handleEvent(FormEvent evt) {   
                    			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
                    				
                    				//업로드가  성공했으면 인서트 모듈을 태운다. 
                    				plFrmBass0350.unmask();  
//                                MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
                                	picBoolFile = false;
                                	evt.setResultHtml("");
                            	} else {
                            		if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
                            			plFrmBass0350.unmask();  
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
	    
	  /* 엑셀 다운로드 */
	  private void xlsExportData() {
		  
		  HashMap<String, String> param = new HashMap<String, String>();  
		  
		  param.put("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()) );	//사업장코드
		  param.put("typOccuCd", BasisUtil.getSelectedComboValue(srhTypOccuCd, "typOccuCd"));	//직종코드
		  param.put("dtilOccuClsUseYn", MSFSharedUtils.allowNulls(srhDtilOccuClsUseYn.getValue()? "Y" : "N")); 	//직종세사용여부
		  param.put("dtilOccuClsNm", MSFSharedUtils.allowNulls(srhDtilOccuClsNm.getValue()));						//직종세명		  
		
		  msfBass0350GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileBass0350Export.do","extgwtFrame" ,param);  
	  }
	
	@Override
	public void reload() {
		
		//폼 초기화
		formBass0350Init();
		
		//TODO 검색조건 수정하기
		IColumnFilter filters = null;
		msfBass0350GridPanel.getTableDef().setTableColumnFilters(filters);
		msfBass0350GridPanel.getTableDef().addColumnFilter("srhTypOccuCd", BasisUtil.getSelectedComboValue(srhTypOccuCd, "typOccuCd"), SimpleColumnFilter.OPERATOR_LIKE);	//직종명
		msfBass0350GridPanel.getTableDef().addColumnFilter("srhDtilOccuClsNm", srhDtilOccuClsNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfBass0350GridPanel.getTableDef().addColumnFilter("srhDtilOccuClsUseYn", srhDtilOccuClsUseYn.getValue()? "Y" : "N", SimpleColumnFilter.OPERATOR_LIKE); //사용여부 검색조건 추가
		msfBass0350GridPanel.reload();
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Bass0350 getThis() {
		return this;
	}	
	
	private void formBass0350Init() {

		dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd()); 
		dtilOccuClsDivCd.setValue("");			//직종세코드
		
		ListStore<BaseModel> lsTypOccuCd 	= new ListStore<BaseModel>();		//직종 	
		sysComBass0320Dto.setTypOccuUseYn("Y");
		lsTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		
		typOccuCd.setStore(lsTypOccuCd);
		typOccuCd.setValue(new BaseModel());	//직종명
		typOccuCd.setEnabled(true);
		
		pyspGrdeCd.setValue(new BaseModel());
		bggLogSvcYrNumCd.setValue(new BaseModel());
		dtilOccuJbfmlDivCd.setValue(new BaseModel());
		pyspGrdeCd.setEnabled(true);
		//pyspGrdeCd.select(0);					//호봉등급
		dtilOccuClsNm.setValue("");				//직종세명
		dtilOccuClsCtnt.setValue("");			//직종세내용
		dtilOccuClsOrd.reset();			//순서
		dtilOccuClsUseYn.setValue(false);		//직종세사용여부
		chngTgtYn.setValue(false);				//전환제외대상여부
		
		dtilOcclsApptnUcstSum.setValue(0);
		dtilOcclsApptnUcstCd.setEnabled(true);
		dtilOcclsApptnUcstCd.setValue(new BaseModel());
		chngTypOccuCd.setEnabled(true);	//  개편전직종코드
		chngTypOccuCd.setValue(new BaseModel());
		chngDtilOccuInttnCd.setEnabled(true); 	// 	개편전직종세코드
		chngDtilOccuInttnCd.setValue(new BaseModel());
		dtilOccuInttnStdt.setValue(today);					//	직종세시작일자
		dtilOccuInttnEddt.setValue(today);				//	직종세종료일자
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
