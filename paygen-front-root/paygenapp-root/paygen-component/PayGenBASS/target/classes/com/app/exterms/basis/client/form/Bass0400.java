package com.app.exterms.basis.client.form;

import java.util.Date;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0400DTO;
import com.app.exterms.basis.client.form.defs.Bass0400Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass0400Service;
import com.app.exterms.basis.client.service.Bass0400ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
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
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Bass04000.java
 * @Description : 부서관리
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
 * =========================================================================
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends
 * LayoutContainer implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리
 * 해야함. MSFPanel
 * =========================================================================
 **/
public class Bass0400 extends MSFPanel {

	
	private VerticalPanel vp;
	private FormPanel plFrmBass0400;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	
	final TabPanel tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab
	private Date today = new Date();
	// -- 검색 조건 시작
	private TextField<String> srhDeptNm;
	private CheckBox srhDeptUseYn;
	private CheckBoxGroup srhDeptUseGrp;
	// -- 검색 조건 끝
	
	// -- 상세정보 시작
	private MSFTextField dpobCd;
	private MSFTextField deptCd; 					// 부서코드
	private MSFTextField deptNmHan; 				//부서명(한글)
	private MSFTextField deptNmRtchnt; 				//부서명(단축)
	private MSFTextField deptNmEng; 				//부서명(영문)
	private MSFTextField tplvlDeptCd; 				//최상위 부서
	private MSFTextField tplvlDeptNm; 				//최상위 부서명
	private MSFComboBox<BaseModel> payrMangDeptCd; 	//단위기관
	private MSFTextField hhrkDeptCd; 				//상위부서	
	private MSFTextField hhrkDeptNm; 				//상위부서명
	private MSFTextField mangeDeptCd;	 			//관리부서
	private MSFTextField mangeDeptNm; 				//관리부서명
	private MSFTextField deptNoteCtnt; 				//비고내용
	private CheckBoxGroup deptUseGrp;				//체크박스 그룹
	private CheckBox deptUseYn; 					//부서사용여부
	private CheckBox deptDspyYn; 					//부서출력여부
	
	private MSFDateField deptCreDt;					//부서 생성일자
	private MSFDateField deptEndDt;					//부서 폐지일자
	
	private MSFTextField befDeptCd; 				//개편전부서코드
	private MSFTextField befDeptNm; 				//개편전부서명
	
	private MSFTextField befDeptCd02; 				//개편전부서코드2
	private MSFTextField befDeptNm02; 				//개편전부서명2
	
	// -- 상세정보 끝
	
	// -- 사업장 기호 시작
	private MSFTextField natPennSym;				//국민연금
	private MSFTextField hlthInsrSym; 		  		//건강보험
	private MSFTextField umytInsrSym; 		 		//고용보험
	private MSFTextField idtlAccdtInsurSym; 		//산재보험
	// -- 사업장 기호 끝
	
	// -- 상단 버튼 시작
	private ButtonBar topBass0400Bar;				
	private Button btnBass0400New;					//신규 버튼
	private Button btnBass0400Save;					//저장 버튼 
	private Button btnBass0400Del;					//삭제 버튼
	private Button btnBass0400Sreach;				//조회 버튼
	private Button btnBass0400Print;				//인쇄 버튼
	private Button btnBass0400Excel;				//엑셀 버튼	
	// -- 상단 버튼 종료
	
	// -- 상태 처리 전역 변수 시작
	private ActionDatabase actionDatabase;
	// -- 상태 처리 전역 변수 종료
	
	// ----------------------------------------------------------------------------
	private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
	private BaseModel record;
	private Bass0400Def bass0400Def = new Bass0400Def();
	private MSFGridPanel msfBass0400GridPanel;
	
	ListStore<BaseModel> listStorePayrMangDeptCd = new ListStore<BaseModel>();
	
	private Bass0400ServiceAsync bass0400Service = Bass0400Service.Util.getInstance();
		
	public ContentPanel getViewPanel() {
		if (panel == null) {
			
			bass0400Service.getBass0150List(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					listStorePayrMangDeptCd.add(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "코드 에러!", null);
				}
			});
			
			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createBass0400Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createListGrid(); 		// 그리드 정보
			createStandardForm(); 	// 사업장정보
//			createStdSubFrom(); 	// 사업장기호

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
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 서브 입력 폼 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~
	 **/	
	// TODO 사업장 기호
	private void createStdSubFrom() {

		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("사업장기호");
		fldstNewFieldset.setCollapsible(false);
		
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_1 = new LayoutContainer();
		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(85);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lc1_1.setLayout(fl1_1);
		natPennSym = new MSFTextField();
		natPennSym.setFieldLabel("국민연금");
		lc1_1.add(natPennSym, new FormData("100%"));
		
		lc1.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.25));
		
		LayoutContainer lc1_2 = new LayoutContainer();
		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(85);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lc1_2.setLayout(fl1_2);
		hlthInsrSym = new MSFTextField();
		hlthInsrSym.setFieldLabel("건강보험");
		lc1_2.add(hlthInsrSym, new FormData("100%"));
		
		lc1.add(lc1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.25));
		
		LayoutContainer lc1_3 = new LayoutContainer();
		FormLayout fl1_3 = new FormLayout();
		fl1_3.setLabelWidth(85);
		fl1_3.setLabelAlign(LabelAlign.RIGHT);
		lc1_3.setLayout(fl1_3);
		umytInsrSym = new MSFTextField();
		umytInsrSym.setFieldLabel("고용보험");
		lc1_3.add(umytInsrSym, new FormData("100%"));
		
		lc1.add(lc1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.25));
		
		LayoutContainer lc1_4 = new LayoutContainer();
		FormLayout fl1_4 = new FormLayout();
		fl1_4.setLabelWidth(85);
		fl1_4.setLabelAlign(LabelAlign.RIGHT);
		lc1_4.setLayout(fl1_4);
		idtlAccdtInsurSym = new MSFTextField();
		idtlAccdtInsurSym.setFieldLabel("산재보험");
		lc1_4.add(idtlAccdtInsurSym, new FormData("100%"));
		
		lc1.add(lc1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.25));
		
		fldstNewFieldset.add(lc1);
		
		plFrmBass0400.add(fldstNewFieldset, new FormData("100%"));
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 서브 입력 폼 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * @wbp.parser.constructor
	 */
	public Bass0400() {
		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Bass0400(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createBass0400Form() {

		plFrmBass0400 = new FormPanel();
		plFrmBass0400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 부서관리"));
		plFrmBass0400.setIcon(Resources.APP_ICONS.text());
		plFrmBass0400.setPadding(2);
		plFrmBass0400.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("부서관리","BASS0400");
				}
			});
		plFrmBass0400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0400.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmBass0400.setFrame(true);
		plFrmBass0400.setLayout(new FormLayout());
		
		ButtonBar buttonBarLeft = new ButtonBar();
		buttonBarLeft.setAlignment(HorizontalAlignment.LEFT);
		
		Button btnDept = new Button("부서코드동기화");
		btnDept.setIcon(Resources.APP_ICONS.refresh16());
		buttonBarLeft.add(btnDept);
		btnDept.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//세올과 연계된 부서코드 동기화함.
    			formBass0400DeptImport();   
    		}
    	});
		
		//ButtonBar buttonBar = new ButtonBar();
		topBass0400Bar = new ButtonBar();
		topBass0400Bar.setAlignment(HorizontalAlignment.RIGHT);
		

		//Button topBtn = new Button("신규");
		btnBass0400New = new Button("신규");
		btnBass0400New.setIcon(Resources.APP_ICONS.new16());
		btnBass0400New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//신규 버튼 클릭시 처리     
    			formBass0400Init();   
    		}
    	});
		
		/**
		topBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				dpobCd.setValue("");
				deptCd.setValue(""); 						// 부서코드
				deptNmHan.setValue(""); 					//부서명(한글)
				deptNmRtchnt.setValue(""); 					//부서명(단축)
				deptNmEng.setValue(""); 					//부서명(영문)
				tplvlDeptCd.setValue(""); 					//최상위 부서
				tplvlDeptNm.setValue(""); 					//최상위 부서명
				payrMangDeptCd.setValue(new BaseModel()); 	//단위기관
				hhrkDeptCd.setValue(""); 					//상위부서
				hhrkDeptNm.setValue(""); 					//상위부서명
				mangeDeptCd.setValue(""); 					//관리부서
				mangeDeptNm.setValue(""); 					//관리부서명
				deptNoteCtnt.setValue(""); 					//비고내용
				deptUseYn.setValue(false); 					//사용여부
				deptDspyYn.setValue(false);					//부서출력 여부
				
				natPennSym.setValue(""); 					//국민연금
				hlthInsrSym.setValue(""); 					//건강보험
				umytInsrSym.setValue(""); 					//고용보험
				idtlAccdtInsurSym.setValue(""); 			//산재보험
			}
		});
		
		*/
		topBass0400Bar.add(btnBass0400New);

		//topBtn = new Button("저장");
		btnBass0400Save = new Button("저장");
		btnBass0400Save.setIcon(Resources.APP_ICONS.save16());
		/**
		btnBass0400Save.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				save(ActionDatabase.UPDATE);
			}
		});*/
		btnBass0400Save.addSelectionListener(selectionListener);
		topBass0400Bar.add(btnBass0400Save);

		//topBtn = new Button("삭제");
		btnBass0400Del = new Button("삭제");
		btnBass0400Del.setIcon(Resources.APP_ICONS.delete16());
		btnBass0400Del.addSelectionListener(selectionListener);
		/**
		btnBass0400Del.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				save(ActionDatabase.DELETE);
			}
		});*/
		topBass0400Bar.add(btnBass0400Del);

		//topBtn = new Button("조회");
		btnBass0400Sreach = new Button("조회");
		btnBass0400Sreach.setIcon(Resources.APP_ICONS.search16());
		btnBass0400Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				dpobCd.setValue("");
				deptCd.setValue(""); 						// 부서코드
				deptNmHan.setValue(""); 					//부서명(한글)
				deptNmRtchnt.setValue(""); 					//부서명(단축)
				deptNmEng.setValue(""); 					//부서명(영문)
				tplvlDeptCd.setValue(""); 					//최상위 부서
				tplvlDeptNm.setValue(""); 					//최상위 부서명
				payrMangDeptCd.setValue(new BaseModel()); 	//단위기관
				hhrkDeptCd.setValue(""); 					//상위부서
				hhrkDeptNm.setValue(""); 					//상위부서명
				mangeDeptCd.setValue(""); 					//관리부서
				mangeDeptNm.setValue(""); 					//관리부서명
				deptNoteCtnt.setValue(""); 					//비고내용
				deptUseYn.setValue(false); 					//사용여부
				deptDspyYn.setValue(false);					//부서출력 여부
				
				befDeptCd.setValue("");						//개편전부서
				
//				natPennSym.setValue(""); 					//국민연금
//				hlthInsrSym.setValue(""); 					//건강보험
//				umytInsrSym.setValue(""); 					//고용보험
//				idtlAccdtInsurSym.setValue("");				//산재보험
				
				reload();
			}
		});
		topBass0400Bar.add(btnBass0400Sreach);

		//topBtn = new Button("인쇄");
		
		
		//btnBass0400Print = new Button("인쇄");
		//btnBass0400Print.setIcon(Resources.APP_ICONS.print16());
		//topBass0400Bar.add(btnBass0400Print);
		
		//topBtn = new Button("엑셀");
		//btnBass0400Excel = new Button("엑셀");
		//btnBass0400Excel.setIcon(Resources.APP_ICONS.excel16());
		//topBass0400Bar.add(btnBass0400Excel);
		
		LayoutContainer lc = new LayoutContainer(new ColumnLayout());
		lc.add(buttonBarLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));
		lc.add(topBass0400Bar, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.7));
		
		plFrmBass0400.add(lc);

		// 파일업로드 처리 - 사업장 직인 정보
		plFrmBass0400.setAction("myurl"); // url 정보 추가 할것.
		plFrmBass0400.setEncoding(Encoding.MULTIPART);
		plFrmBass0400.setMethod(Method.POST);

		vp.add(plFrmBass0400);
		//엣지변환
		//plFrmBass0400.setSize("990px", "680px");
		plFrmBass0400.setSize("990px", "730px");
	}
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			if (ActionDatabase.INSERT.equals(actionDatabase)) {
				//System.out.println("1단계");
				if (ce.getButton() == btnBass0400Save) {
					//System.out.println("2단계");
					doAction(ActionDatabase.INSERT);
					actionDatabase = null;
				}
			}else if (ce.getButton() == btnBass0400Save) {
				doAction(ActionDatabase.UPDATE);
			}else if (ce.getButton() == btnBass0400Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}
	
	public void save(final ActionDatabase actionDatabase){
		
		final Bass0400DTO dto = new Bass0400DTO();
		//if("".equals(dpobCd.getValue()) || dpobCd.getValue() == null){	
		if("".equals(deptCd.getValue()) || deptCd.getValue() == null){
			MessageBox.info("", "부서코드를 입력하여 주세요.", null);
			
		}else if(( ( GWTUtils.getStringFromDate(deptCreDt.getValue(), "yyyyMMdd") != null && !"".equals(GWTUtils.getStringFromDate(deptCreDt.getValue(), "yyyyMMdd" )))
				 && ( GWTUtils.getStringFromDate(deptEndDt.getValue(), "yyyyMMdd") != null && !"".equals(GWTUtils.getStringFromDate(deptEndDt.getValue(), "yyyyMMdd" )))
				 ) && GregorianCalendar.compareDate(deptCreDt.getValue(), deptEndDt.getValue()) < 0
				)  {
			
				MessageBox.info("", "기간 설정이 잘못되었습니다. 확인하십시요.", null); 
			
		}
		// 2017.12.12 
		// DAEUN, BAE
		// TODO 생성부서 및 폐지일자 필수일 경우 해당 부분에 조건 추가해줄 것. 
//		else if(GregorianCalendar.compareDate(deptCreDt.getValue(), deptEndDt.getValue()) < 0){
//			MessageBox.info("", "기간 설정이 잘못되었습니다. 확인하십시요.", null); 
//		}
		else{
			
			dto.setDpobCd(dpobCd.getValue());
			dto.setDeptCd(deptCd.getValue()); 										//부서코드
			dto.setDeptNmHan(deptNmHan.getValue()); 								//부서명(한글)
			dto.setDeptNmRtchnt(deptNmRtchnt.getValue()); 							//부서명(단축)
			dto.setDeptNmEng(deptNmEng.getValue()); 								//부서명(영문)
			dto.setTplvlDeptCd(tplvlDeptCd.getValue()); 							//최상위 부서
			dto.setTplvlDeptCd(tplvlDeptCd.getValue()); 							//최상위 부서명
			dto.setPayrMangDeptCd(BasisUtil.getSelectedComboValue(payrMangDeptCd)); //단위기관
			//dto.setPayrMangDeptCd(BasisUtil.getSelectedComboValue(payrMangDeptCd)); //단위기관
			dto.setHhrkDeptCd(hhrkDeptCd.getValue()); 								//상위부서
			dto.setMangeDeptCd(mangeDeptCd.getValue()); 							//관리부서
			dto.setDeptNoteCtnt(deptNoteCtnt.getValue()); 							//비고내용
			dto.setDeptUseYn(deptUseYn.getValue() ? "Y" : "N");						//사용 여부 
			dto.setDeptDspyYn(deptDspyYn.getValue() ? "Y" : "N");					//부서출력 여부
			
			dto.setBefDeptCd(befDeptCd.getValue());									//개편전 부서
			dto.setBefDeptCd02(befDeptCd02.getValue());									//개편전 부서2
			
			dto.setDeptCreDt(BasisUtil.getConvertDateToString(deptCreDt, "yyyyMMdd"));	//부서생성일자
			dto.setDeptEndDt(BasisUtil.getConvertDateToString(deptEndDt, "yyyyMMdd"));	//부서폐지일자
//			dto.setDeptCreDt(GWTUtils.getStringFromDate(deptCreDt.getValue(), "yyyyMMdd"));
//			dto.setDeptEndDt(GWTUtils.getStringFromDate(deptEndDt.getValue(), "yyyyMMdd"));
			
			
//			dto.setHlthInsrSym(hlthInsrSym.getValue()); 							//건강보험
//			dto.setNatPennSym(natPennSym.getValue()); 								//국민연금
//			dto.setUmytInsrSym(umytInsrSym.getValue()); 							//고용보험
//			dto.setIdtlAccdtInsurSym(idtlAccdtInsurSym.getValue()); 				//산재보험
			
			MessageBox.confirm("","DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
				//	if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						bass0400Service.saveBass0400(dto, actionDatabase, new AsyncCallback<String>() {
							@Override
							public void onSuccess(String result) {
								if("DELETE".equals(actionDatabase.name())){
									MessageBox.info("", "삭제 되었습니다.", null);
								}else{
									MessageBox.info("", "저장 되었습니다.", null);
								}
								//reload();
							}
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
				                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0400(" + actionDatabase.name() + ") : " + caught)
				                        , null);
							}
						});
					}
				}
			});
		}
		
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSearchForm() {

		LayoutContainer lcSchCol = new LayoutContainer(new ColumnLayout());
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		LayoutContainer lcSchLeft = new LayoutContainer();
		FormLayout frmlytSchLeft = new FormLayout();
		frmlytSchLeft.setLabelWidth(85);
		frmlytSchLeft.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft.setLayout(frmlytSchLeft);

		srhDeptNm = new TextField<String>();
		srhDeptNm.setFieldLabel("부서명");
		lcSchLeft.add(srhDeptNm, new FormData("100%"));
		
		LayoutContainer lcSchCenter = new LayoutContainer();
		srhDeptUseGrp = new CheckBoxGroup();
		srhDeptUseGrp.setName("srhDeptUseGrp");
		srhDeptUseGrp.setLabelSeparator("");
		
		FormLayout fl5_1 = new FormLayout();
		fl5_1.setLabelWidth(85);
		fl5_1.setLabelAlign(LabelAlign.RIGHT);
		lcSchCenter.setLayout(fl5_1);
		lcSchCenter.setStyleAttribute("text-align", "left");
		
		srhDeptUseYn = new CheckBox();
		srhDeptUseYn.setName("srhDeptUseYn");
		srhDeptUseGrp.add(srhDeptUseYn);
		srhDeptUseYn.setValue(true);
		srhDeptUseYn.setBoxLabel("사용유무");
		srhDeptUseYn.setHideLabel(true);
		lcSchCenter.add(srhDeptUseGrp, new FormData("100%"));
		
		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.3));
		lcSchCol.add(lcSchCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));
		
		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmBass0400.add(fieldSet);

	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 검색 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 기본등록화면 입력 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	// TODO 상세정보 설정
	private void createStandardForm() {

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");
		
		dpobCd = new MSFTextField();
		
		LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1_1 = new LayoutContainer();
		FormLayout fl1_1 = new FormLayout();
		fl1_1.setLabelWidth(85);
		fl1_1.setLabelAlign(LabelAlign.RIGHT);
		lc1_1.setLayout(fl1_1);
		deptCd = new MSFTextField();
		deptCd.setFieldLabel("부서코드");
		lc1_1.add(deptCd, new FormData("100%"));
		
		lc1.add(lc1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		LayoutContainer lc1_2 = new LayoutContainer();
		FormLayout fl1_2 = new FormLayout();
		fl1_2.setLabelWidth(85);
		fl1_2.setLabelAlign(LabelAlign.RIGHT);
		lc1_2.setLayout(fl1_2);
		deptNmHan = new MSFTextField();
		deptNmHan.setFieldLabel("부서명(한글)");
		lc1_2.add(deptNmHan, new FormData("100%"));
		
		lc1.add(lc1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		
		
		LayoutContainer lc2 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc2_1 = new LayoutContainer();
		FormLayout fl2_1 = new FormLayout();
		fl2_1.setLabelWidth(85);
		fl2_1.setLabelAlign(LabelAlign.RIGHT);
		lc2_1.setLayout(fl2_1);
		deptNmRtchnt = new MSFTextField();
		deptNmRtchnt.setFieldLabel("부서명(단축)");
		lc2_1.add(deptNmRtchnt, new FormData("100%"));
		
		lc2.add(lc2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		LayoutContainer lc2_2 = new LayoutContainer();
		FormLayout fl2_2 = new FormLayout();
		fl2_2.setLabelWidth(85);
		fl2_2.setLabelAlign(LabelAlign.RIGHT);
		lc2_2.setLayout(fl2_2);
		deptNmEng = new MSFTextField();
		deptNmEng.setFieldLabel("부서명(영문)");
		lc2_2.add(deptNmEng, new FormData("100%"));
		
		lc2.add(lc2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		
		LayoutContainer lc3 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc3_1 = new LayoutContainer();
		FormLayout fl3_1 = new FormLayout();
		fl3_1.setLabelWidth(85);
		fl3_1.setLabelAlign(LabelAlign.RIGHT);
		lc3_1.setLayout(fl3_1);
		tplvlDeptCd = new MSFTextField();
		tplvlDeptCd.setFieldLabel("최상위부서명");
		tplvlDeptCd.setReadOnly(true);
		tplvlDeptCd.setEnabled(false);
		lc3_1.add(tplvlDeptCd, new FormData("100%"));
		
		lc3.add(lc3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));
		
		LayoutContainer lc3_2 = new LayoutContainer();
		tplvlDeptNm = new MSFTextField();
		tplvlDeptNm.setWidth(180);
		lc3_2.add(tplvlDeptNm, new FormData("100%"));
		
		lc3.add(lc3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));
		
		LayoutContainer lc3_3 = new LayoutContainer();
		Button b = new Button("검색");
		b.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                fnPopupCommP140_1();
                  
            }
        });
        
		lc3_3.add(b, new FormData("100%"));
		
		lc3.add(lc3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.1));
		
		
		LayoutContainer lc3_4 = new LayoutContainer();
		FormLayout fl3_2 = new FormLayout();
		fl3_2.setLabelWidth(85);
		fl3_2.setLabelAlign(LabelAlign.RIGHT);
		lc3_4.setLayout(fl3_2);
		payrMangDeptCd = new MSFComboBox<BaseModel>();
		payrMangDeptCd.setFieldLabel("단위기관");
		payrMangDeptCd.setName("payrMangDeptCd");
		payrMangDeptCd.setForceSelection(true);
		payrMangDeptCd.setMinChars(1);
		payrMangDeptCd.setDisplayField("commCdNm");
		payrMangDeptCd.setValueField("commCd");
		payrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		payrMangDeptCd.setEmptyText("--부서선택--");
		payrMangDeptCd.setSelectOnFocus(true);
		payrMangDeptCd.setStore(listStorePayrMangDeptCd);
		//payrMangDeptCd.setReadOnly(true);
		lc3_4.add(payrMangDeptCd, new FormData("100%"));
		lc3.add(lc3_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		
		LayoutContainer lc4 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc4_1 = new LayoutContainer();
		FormLayout fl4_1 = new FormLayout();
		fl4_1.setLabelWidth(85);
		fl4_1.setLabelAlign(LabelAlign.RIGHT);
		lc4_1.setLayout(fl4_1);
		hhrkDeptCd = new MSFTextField();
		hhrkDeptCd.setFieldLabel("상위부서명");
		hhrkDeptCd.setReadOnly(true);
		hhrkDeptCd.setEnabled(false);
		lc4_1.add(hhrkDeptCd, new FormData("100%"));
		
		lc4.add(lc4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));
		
		LayoutContainer lc4_2 = new LayoutContainer();
		hhrkDeptNm = new MSFTextField();
		hhrkDeptNm.setWidth(180);
		lc4_2.add(hhrkDeptNm, new FormData("100%"));
		
		lc4.add(lc4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));
		
		LayoutContainer lc4_3 = new LayoutContainer();
		Button b4_1 = new Button("검색");
		b4_1.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                fnPopupCommP140_2();
                  
            }
        });
        
		lc4_3.add(b4_1, new FormData("100%"));
		
		lc4.add(lc4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.1));
		
				
		LayoutContainer lc4_4 = new LayoutContainer();
		FormLayout fl4_4 = new FormLayout();
		fl4_4.setLabelWidth(85);
		fl4_4.setLabelAlign(LabelAlign.RIGHT);
		lc4_4.setLayout(fl4_4);
		mangeDeptCd = new MSFTextField();
		mangeDeptCd.setFieldLabel("관리부서명");
		mangeDeptCd.setReadOnly(true);
		mangeDeptCd.setEnabled(false);
		lc4_4.add(mangeDeptCd, new FormData("100%"));
		
		lc4.add(lc4_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));
		
		LayoutContainer lc4_5 = new LayoutContainer();
		mangeDeptNm = new MSFTextField();
		mangeDeptNm.setWidth(180);
		lc4_5.add(mangeDeptNm, new FormData("100%"));
		
		lc4.add(lc4_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.2));
		
		LayoutContainer lc4_6 = new LayoutContainer();
		Button b4_2 = new Button("검색");
		b4_2.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                fnPopupCommP140_3();
                  
            }
        });
        
		lc4_6.add(b4_2, new FormData("100%"));
		
		lc4.add(lc4_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.1));
		
		/**-------------------------- 새로운 폼 추가 --------------------------*/
		
		befDeptCd = new MSFTextField();
		befDeptCd.setFieldLabel("개편전 부서명");
		befDeptCd.setReadOnly(true);
		befDeptCd.setEnabled(false);
		lc4_1.add(befDeptCd, new FormData("100%"));
		
		
		befDeptNm = new MSFTextField();
		befDeptNm.setWidth(180);
		lc4_2.add(befDeptNm, new FormData("100%"));
		
		
		Button b4_3 = new Button("검색");
		b4_3.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                fnPopupCommP140_4();
                  
            }
        });
        
		lc4_3.add(b4_3, new FormData("100%"));
		
		
		befDeptCd02 = new MSFTextField();
		befDeptCd02.setFieldLabel("개편전부서명2");
		befDeptCd02.setReadOnly(true);
		befDeptCd02.setEnabled(false);
		lc4_4.add(befDeptCd02, new FormData("100%"));
		
		befDeptNm02 = new MSFTextField();
		befDeptNm02.setWidth(180);
		lc4_5.add(befDeptNm02, new FormData("100%"));
		
		Button b4_4 = new Button("검색");
		b4_4.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                
                fnPopupCommP140_5();
                  
            }
        });        
		lc4_6.add(b4_4, new FormData("100%"));
		
		LayoutContainer lc6 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc6_1 = new LayoutContainer();
		FormLayout fl6_1 = new FormLayout();
		fl6_1.setLabelWidth(85);
		fl6_1.setLabelAlign(LabelAlign.RIGHT);
		lc6_1.setLayout(fl6_1);
		
		deptCreDt = new MSFDateField(); 
		deptCreDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		deptCreDt.setName("deptCreDt");				 
		new DateFieldMask(deptCreDt, "9999.99.99");
		deptCreDt.setFieldLabel("생성일자");
		deptCreDt.setMinLength(10);
		deptCreDt.setMaxLength(10);
		lc6_1.add(deptCreDt, new FormData("100%"));
		
		lc6.add(lc6_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		LayoutContainer lc6_2 = new LayoutContainer();
		FormLayout fl6_2 = new FormLayout();
		fl6_2.setLabelWidth(85);
		fl6_2.setLabelAlign(LabelAlign.RIGHT);
		lc6_2.setLayout(fl6_2);
		
		deptEndDt = new MSFDateField(); 
		deptEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		deptEndDt.setName("deptEndDt");				 
		new DateFieldMask(deptEndDt, "9999.99.99");
		deptEndDt.setFieldLabel("폐지일자");
		deptEndDt.setMinLength(10);
		deptEndDt.setMaxLength(10);
		lc6_2.add(deptEndDt, new FormData("100%"));
		
		lc6.add(lc6_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		/**--------------------------------------------------------------------------*/
		
		
		LayoutContainer lc5 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc5_1 = new LayoutContainer();
		deptUseGrp = new CheckBoxGroup();
		deptUseGrp.setName("deptUseGrp");
		deptUseGrp.setLabelSeparator("");
		
		FormLayout fl5_1 = new FormLayout();
		fl5_1.setLabelWidth(85);
		fl5_1.setLabelAlign(LabelAlign.RIGHT);
		lc5_1.setLayout(fl5_1);
		//deptUseYn = new CheckBox();
		//deptUseYn.setFieldLabel("사용");
		//lc5_1.add(deptUseYn, new FormData("23%"));
		lc5_1.setStyleAttribute("text-align", "left");
		
		deptUseYn = new CheckBox();
		deptUseYn.setName("deptUseYn");
		deptUseGrp.add(deptUseYn);
		deptUseYn.setBoxLabel("사용");
		deptUseYn.setHideLabel(true);
		

		deptDspyYn = new CheckBox();
		deptDspyYn.setName("deptDspyYn");
		deptUseGrp.add(deptDspyYn);
		deptDspyYn.setBoxLabel("부서출력");
		deptDspyYn.setHideLabel(true);

		lc5_1.add(deptUseGrp, new FormData("100%"));
		lc5.add(lc5_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		LayoutContainer lc5_2 = new LayoutContainer();
		FormLayout fl5_2 = new FormLayout();
		fl5_2.setLabelWidth(85);
		fl5_2.setLabelAlign(LabelAlign.RIGHT);
		lc5_2.setLayout(fl5_2);
		deptNoteCtnt = new MSFTextField();
		deptNoteCtnt.setFieldLabel("비고내용");
		lc5_2.add(deptNoteCtnt, new FormData("100%"));
		
		lc5.add(lc5_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(0.5));
		
		
		LayoutContainer middle_lc = new LayoutContainer();
		middle_lc.add(lc1, new FormData("100%"));
		middle_lc.add(lc2, new FormData("100%"));
		middle_lc.add(lc3, new FormData("100%"));
		middle_lc.add(lc4, new FormData("100%"));
		middle_lc.add(lc6, new FormData("100%"));
		middle_lc.add(lc5, new FormData("100%"));
		
		fieldSet.add(middle_lc);
		
		plFrmBass0400.add(fieldSet);
		// vp.add(panel);
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 기본등록화면 입력 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createListGrid() {
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("부서정보");
		
		LayoutContainer lcStdGrid = new LayoutContainer();
		// lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(955, 355);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		msfBass0400GridPanel = new MSFGridPanel(bass0400Def, false, false, false, true);
		msfBass0400GridPanel.setHeaderVisible(false);
		
		final Grid<BaseModel> grid = msfBass0400GridPanel.getMsfGrid().getGrid();
		grid.addListener(Events.RowClick, new Listener<GridEvent<BaseModel>>() {
			@Override
			public void handleEvent(GridEvent<BaseModel> be) {
				
				dpobCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd")+"");
				deptCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptCd")+""); // 부서코드
				deptNmHan.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNmHan") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNmHan")+""); //부서명(한글)
				deptNmRtchnt.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNmRtchnt") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNmRtchnt")+""); //부서명(단축)
				deptNmEng.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNmEng") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNmEng")+""); //부서명(영문)
				tplvlDeptCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("tplvlDeptCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("tplvlDeptCd")+""); //최상위 부서
				tplvlDeptNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("tplvlDeptCdNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("tplvlDeptCdNm")+""); //최상위 부서명
				
				BasisUtil.setSelectedComboValue(payrMangDeptCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payrMangDeptCd")+"");//단위기관
				
				
				hhrkDeptCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hhrkDeptCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hhrkDeptCd")+""); //상위부서
				hhrkDeptNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hhrkDeptCdNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hhrkDeptCdNm")+""); //상위부서명
				mangeDeptCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("mangeDeptCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("mangeDeptCd")+""); //관리부서
				mangeDeptNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("mangeDeptCdNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("mangeDeptCdNm")+""); //관리부서명
				deptNoteCtnt.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNoteCtnt") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptNoteCtnt")+""); //비고내용
				deptUseYn.setValue("Y".equals(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptUseYn")) ? true : false); //사용여부
				deptDspyYn.setValue("Y".equals(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("deptDspyYn")) ? true : false); //부서출력여부
//				hlthInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym")+""); //건강보험
//				natPennSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym")+""); //국민연금
//				umytInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym")+""); //고용보험
//				idtlAccdtInsurSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym")+""); //산재보험
				
				befDeptCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptCd")+""); //개편전 부서 코드
				befDeptNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptNm")+""); //개편전 부서명
				
				befDeptCd02.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptCd02") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptCd02")+""); //개편전 부서 코드2
				befDeptNm02.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptNm02") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("befDeptNm02")+""); //개편전 부서명2
				
				deptCreDt.setValue(BasisUtil.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("deptCreDt"), "yyyyMMdd"));	//부서생성일자
				deptEndDt.setValue(BasisUtil.getConvertStringToDate((String)grid.getSelectionModel().getSelectedItem().get("deptEndDt"), "yyyyMMdd"));	//부서폐지일자
			}
		});

		cpGrid.add(msfBass0400GridPanel);
		// grid.setHeight("147px");

		lcStdGrid.add(cpGrid);
		fieldSet.add(lcStdGrid);
		
		plFrmBass0400.add(fieldSet);
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void fnPopupCommP140_1() {
       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
       //검색.처리하면됨.
       
       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form();  //인사  
       
       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
      
       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {
               BaseModel mapModel = (BaseModel)be.getSource();
               if (!"".equals(mapModel.get("deptCd"))) { 
            	    tplvlDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
            	    tplvlDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));   //주민번호 
               }  
                    
           }
       });
   }
	private void fnPopupCommP140_2() {
       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
       //검색.처리하면됨.
       
       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form();  //인사  
       
       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
      
       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {
               BaseModel mapModel = (BaseModel)be.getSource();
               if (!"".equals(mapModel.get("deptCd"))) { 
                    
            	   hhrkDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
            	   hhrkDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));   //주민번호 
               }  
                    
           }
       });
   }
	private void fnPopupCommP140_3() {
       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
       //검색.처리하면됨.
       
       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form();  //인사  
       
       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
      
       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {
               BaseModel mapModel = (BaseModel)be.getSource();
               if (!"".equals(mapModel.get("deptCd"))) { 
                    
            	   mangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
            	   mangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));   //주민번호 
               }  
                    
           }
       });
   }
	
	private void fnPopupCommP140_4() {
	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	       //검색.처리하면됨.
	       
	       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form();  //인사  
	       
	       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
	      
	       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("deptCd"))) { 
	                    
	            	   befDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	            	   befDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));   //주민번호 
	               }  
	                    
	           }
	       });
	   }
	
	private void fnPopupCommP140_5() {
	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	       //검색.처리하면됨.
	       
	       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form();  //인사  
	       
	       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
	      
	       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("deptCd"))) { 
	                    
	            	   befDeptCd02.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	            	   befDeptNm02.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));   //주민번호 
	               }  
	                    
	           }
	       });
	   }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~ 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	@Override
	public void reload() {
		
		deptCd.setValue(""); 						//부서코드
		deptNmHan.setValue(""); 					//부서명(한글)
		deptNmRtchnt.setValue(""); 					//부서명(단축)
		deptNmEng.setValue(""); 					//부서명(영문)
		tplvlDeptCd.setValue(""); 					//최상위 부서
		tplvlDeptNm.setValue(""); 					//최상위 부서명
		payrMangDeptCd.setValue(new BaseModel()); 	//단위기관
		hhrkDeptCd.setValue(""); 					//상위부서
		hhrkDeptNm.setValue(""); 					//상위부서명
		mangeDeptCd.setValue(""); 					//관리부서
		mangeDeptNm.setValue(""); 					//관리부서명
		deptNoteCtnt.setValue(""); 					//비고내용
		deptUseYn.setValue(false); 					//사용여부
		deptDspyYn.setValue(false); 				//출력여부
		
		deptCreDt.setValue(null); 		// 시작일자
		deptCreDt.setReadOnly(false);
		
		deptEndDt.setValue(null); 		// 종료일
		deptEndDt.setReadOnly(false);
		
		befDeptCd.setValue("");						//개편전부서코드
		befDeptNm.setValue("");						//개편전부서명
		befDeptCd02.setValue("");						//개편전부서코드
		befDeptNm02.setValue("");						//개편전부서명
		
//		natPennSym.setValue(""); 					//국민연금
//		hlthInsrSym.setValue(""); 					//건강보험
//		umytInsrSym.setValue(""); 					//고용보험
//		idtlAccdtInsurSym.setValue(""); 			//산재보험
		
		IColumnFilter filters = null;
		msfBass0400GridPanel.getTableDef().setTableColumnFilters(filters);
		msfBass0400GridPanel.getTableDef().addColumnFilter("srhDeptNm", srhDeptNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfBass0400GridPanel.getTableDef().addColumnFilter("srhDeptUseYn", srhDeptUseYn.getValue()? "Y" : "N", SimpleColumnFilter.OPERATOR_LIKE);
		msfBass0400GridPanel.reload();
		
	}
	
	public void setRecord(BaseModel record){
		this.record = record;
	}
	
	public Bass0400 getThis(){
		return this;
	}
	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
				'<img src="{modPath}"><div class="details-info">',
				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
				.join("");
	}-*/;
	
	
	private void formBass0400Init() {
		dpobCd.setValue("");
		deptCd.setValue(""); 						//부서코드
		deptNmHan.setValue(""); 					//부서명(한글)
		deptNmRtchnt.setValue(""); 					//부서명(단축)
		deptNmEng.setValue(""); 					//부서명(영문)
		tplvlDeptCd.setValue(""); 					//최상위 부서
		tplvlDeptNm.setValue(""); 					//최상위 부서명
		payrMangDeptCd.setValue(new BaseModel()); 	//단위기관
		hhrkDeptCd.setValue(""); 					//상위부서
		hhrkDeptNm.setValue(""); 					//상위부서명
		mangeDeptCd.setValue(""); 					//관리부서
		mangeDeptNm.setValue(""); 					//관리부서명
		deptUseYn.setValue(false); 					//사용여부
		deptDspyYn.setValue(false);					//부서출력 여부
		deptNoteCtnt.setValue(""); 					//비고내용
		
		deptCreDt.setValue(today); 		// 시작일자
		deptCreDt.setReadOnly(false);
		
		deptEndDt.setValue(today); 		// 종료일
		deptEndDt.setReadOnly(false);
		
		befDeptCd.setValue("");						//개편전부서코드
		befDeptNm.setValue("");						//개편전부서명
		befDeptCd02.setValue("");						//개편전부서코드
		befDeptNm02.setValue("");						//개편전부서명
//		natPennSym.setValue(""); 					//국민연금
//		hlthInsrSym.setValue(""); 					//건강보험
//		umytInsrSym.setValue(""); 					//고용보험
//		idtlAccdtInsurSym.setValue(""); 			//산재보험
		
		actionDatabase = ActionDatabase.INSERT;
	}
	
	private void formBass0400DeptImport() {
		
		
		MessageBox.confirm("이관", "이관하시면 기존데이타 삭제후 이관됩니다.\n 이관 하시겠습니까?", new Listener<MessageBoxEvent>() {
			@Override
			public void handleEvent(MessageBoxEvent be) {
			//	if ("Yes".equals(be.getButtonClicked().getText())) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){					 
					bass0400Service.bass0400PiOrgCode(new AsyncCallback<Long>() {
						@Override
						public void onSuccess(Long result) {
							 if (result < 0) {
								 MessageBox.info("","오류발생!", null);
							 } else {
								 MessageBox.info("","이관 완료되었습니다.", null); 
							 }
						} 
						@Override
						public void onFailure(Throwable caught) {
							 ShowMessageBM smForm = new ShowMessageBM();
							 smForm.setWindowId("Bass0400");
							 smForm.setWindowNm("부서관리");
							 GWTUtils.messageExcepDlgEx(caught,smForm);
						}
					});
				}
			}
		});
		
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
