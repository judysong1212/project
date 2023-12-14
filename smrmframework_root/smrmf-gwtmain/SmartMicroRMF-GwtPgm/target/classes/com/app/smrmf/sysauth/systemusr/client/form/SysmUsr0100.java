/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.sysauth.systemusr.client.form;

import java.util.HashMap;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.sysauth.systemusr.client.dto.SysmUsr0100DTO;
import com.app.smrmf.sysauth.systemusr.client.form.defs.SysUsrSysm0100Def;
import com.app.smrmf.sysauth.systemusr.client.languages.SysmUsrConstants;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0100Service;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0100ServiceAsync;
import com.app.smrmf.sysauth.systemusr.client.utils.SysmUsrUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
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
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysmUsr0100  extends MSFPanel { 
	
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
	 

	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/
	
	private SysmUsrConstants lblSysmConst = SysmUsrConstants.INSTANCE;
	
	private VerticalPanel vp;
	private FormPanel plFrmSysm0100;
	
	private SysUsrSysm0100Def  admSysm0100 = new SysUsrSysm0100Def("SYSMUSR0100"); 
//	private SysMtrSysm0100Def  admSysm0100 = new SysMtrSysm0100Def(""); 
	private MSFGridPanel msfGridPanel;
	
	
	//----------- 버튼
	private Button btnSysmUsr0100New;			// 신규
	private Button btnSysmUsr0100Save;			// 저장
	private Button btnSysmUsr100Sreach;			// 조회
	private Button btnSysmUsr100Exl;			// 엑셀
	

	// ---------- 검색 조건 
	private ComboBox<BaseModel> srhDeptCd; 		// 부서
	private ComboBox<BaseModel> srhUsrDivCd; 	// 사용자구분
	private TextField<String> srhUsrNm; 		// 성명
	
	
	// ---------- 상세정보
	private MSFComboBox<BaseModel> deptCd; 		// 부서
	private TextFieldWithButton<String> usrNm; 	// 성명
	private MSFTextField usrId;					// 아이디
	private MSFTextField pwd;					// 비밀번호
	private MSFComboBox<BaseModel> usrDivCd;	// 사용자 권한	
	private MSFTextField usrTel;				// 내선번호
	private MSFTextField email;					// 이메일	
	private CheckBox usrYn;						// 사용 
	private CheckBox lockat;						// 계정잠금 추가 / hieju_06.27
	
	private CheckBoxGroup ckAuthBox;	
	private CheckBox usrAuthEepnYn;				// 사용자권한제외여부 
	private CheckBox servcInptPrcsYn;			// 복무입력처리여부 
	private CheckBox yrtxInptPrcsYn;			// 연말정산입력처리여부 
	
	private CheckBoxGroup ckInsnBox;	
	private CheckBox pyspInsnYn;				// 호봉제포함여부 
	private CheckBox notPyspInsnYn;				// 비호봉제포함여부
	private CheckBox shttmInsnYn;				// 기간제포함여부 
	
	private HiddenField<String> yoobhMnthDay;	// 주민번호앞자리
	
	
	private ActionDatabase actionDatabase;
	
	
     
	private ListStore<BaseModel> lsDeptCd 	= new ListStore<BaseModel>();	// 부서
	private ListStore<BaseModel> lsUsrDivCd = new ListStore<BaseModel>();	// 사용자구분

	private SysIfBass0300DTO sysIfBass0300Dto; // 공통코드 dto
	private SysIfBass0400DTO sysIfBass0400Dto; // 부서코드
	    
	
	private SysmUsr0100ServiceAsync sysmUsr0100Service = SysmUsr0100Service.Util.getInstance();
  	
	   
	public ContentPanel getViewPanel() {
		if (panel == null) {

			panel = new ContentPanel();
			// panel.setLayout(new FitLayout());
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setScrollMode(Scroll.AUTO);
			panel.setHeaderVisible(false);

			vp = new VerticalPanel();
			vp.setSpacing(10);
			vp.setSize("1010px", "700px");

			createSysmUsr0100Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 		// 검색필드를 적용
			createStandardForm(); 		// 사용자관리  정보

			panel.add(vp);

		}
		return panel;
	}
	  
	/**
	 * @wbp.parser.constructor
	 */
	public SysmUsr0100() {

		setSize("1010px", "700px");
	}

	public SysmUsr0100(String txtForm) {

	}
	  
	private void createSysmUsr0100Form() {
		
		actionDatabase = ActionDatabase.UPDATE;

		plFrmSysm0100 = new FormPanel();
		plFrmSysm0100.setHeadingText("ExTerms Ver1.0 - " + lblSysmConst.main_TitleSysm0100());
		plFrmSysm0100.setIcon(Resources.APP_ICONS.text());
		plFrmSysm0100.setBodyStyleName("pad-text");
		plFrmSysm0100.setFrame(false);
        
		sysIfBass0300Dto = new SysIfBass0300DTO();
		sysIfBass0400Dto = new SysIfBass0400DTO();
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//고용구분
		sysIfBass0300Dto.setRpsttvCd("D001");
		lsUsrDivCd = SysifComServiceUtils.getSingleBass0300ComboData( sysIfBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysIfBass0400Dto.setDeptDspyYn("Y");
     	//--------------------부서 불러 오는 함수 ------------------------------------------------
		lsDeptCd = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
		//--------------------부서 불러 오는 함수 ------------------------------------------------
		 
		yoobhMnthDay = new HiddenField<String>();
		yoobhMnthDay.setName("yoobhMnthDay");
		plFrmSysm0100.add(yoobhMnthDay);
		 
		 
		 ButtonBar	topSysmUsr0100Bar = new ButtonBar();
		 topSysmUsr0100Bar.setAlignment(HorizontalAlignment.RIGHT);

		 btnSysmUsr0100New = new Button("신규");
		 btnSysmUsr0100New.setIcon(MSFMainApp.ICONS.new16());
		 topSysmUsr0100Bar.add(btnSysmUsr0100New);
		 btnSysmUsr0100New.addListener(Events.Select, new Listener<ButtonEvent>() {
			 public void handleEvent(ButtonEvent e) {
				 
				 // 입력폼 초기화
				 sysmUsr0100FormInit();
				 actionDatabase = ActionDatabase.INSERT;
			 }
		 });
		 
		 btnSysmUsr0100Save = new Button("저장");
		 btnSysmUsr0100Save.setIcon(MSFMainApp.ICONS.save16());
		// btnBass0100Save.addSelectionListener(selectionListener);
		 btnSysmUsr0100Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			 public void handleEvent(ButtonEvent e) {
				 
				 if(ActionDatabase.INSERT.equals(actionDatabase)) {
					 doAction(ActionDatabase.INSERT);
				 }else {
					 doAction(actionDatabase);
				 }
				 
				 actionDatabase = ActionDatabase.UPDATE;
				 
			 }
		 });
		 
		
		 topSysmUsr0100Bar.add(btnSysmUsr0100Save);

		 btnSysmUsr100Sreach = new Button("조회");
		 btnSysmUsr100Sreach.setIcon(MSFMainApp.ICONS.search16());
		 topSysmUsr0100Bar.add(btnSysmUsr100Sreach);
		 btnSysmUsr100Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			 public void handleEvent(ButtonEvent e) {
				 
				 // 입력폼 초기화
				 sysmUsr0100FormInit();
				 
				 reload();
			 }
		 });
		 
			
			
		  	
		 btnSysmUsr100Exl = new Button("엑셀");
		 btnSysmUsr100Exl.setIcon(MSFMainApp.ICONS.excel16());
		 btnSysmUsr100Exl.addListener(Events.Select, new Listener<ButtonEvent>() {
			 public void handleEvent(ButtonEvent e) {
				
				 //엑셀저장  
				 excelFileExport();

			 }
		 });
		 topSysmUsr0100Bar.add(btnSysmUsr100Exl);
		 plFrmSysm0100.add(topSysmUsr0100Bar);
		   
		 vp.add(plFrmSysm0100);
		 plFrmSysm0100.setSize("990px", "680px");
		
	}
	
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
//	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
//		public void componentSelected(ButtonEvent ce) {
//			if (ActionDatabase.INSERT.equals(actionDatabase)) {
//				
//				
//				actionDatabase = null;
//				if (ce.getButton() == btnSysmUsr0100New) {
//					doAction(ActionDatabase.INSERT);
//				}
//				
//				
//				
//			} else if (ce.getButton() == btnSysmUsr0100Save) {
//				doAction(ActionDatabase.UPDATE);
//				actionDatabase = null;
//			} 
//		}
//	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);

	}

	//저장
	public void save(final ActionDatabase actionDatabase) {
		
		
		SysmUsr0100DTO sysmUsr0100DTO = new SysmUsr0100DTO();
		
		sysmUsr0100DTO.setDeptCd(MSFSharedUtils.getSelectedComboValue(deptCd,"deptCd"));			// 부서
		sysmUsr0100DTO.setUsrNm(usrNm.getValue());													// 성명
		sysmUsr0100DTO.setUsrId(usrId.getValue());													// 아이디
		sysmUsr0100DTO.setPwd(pwd.getValue());														// 비밀번호
		sysmUsr0100DTO.setUsrDivCd(MSFSharedUtils.getSelectedComboValue(usrDivCd,"commCd"));		// 사용자 권한	
		sysmUsr0100DTO.setUsrTel(usrTel.getValue());												// 내선번호
		sysmUsr0100DTO.setEmail(email.getValue());													// 이메일	
		sysmUsr0100DTO.setUseYn(SysmUsrUtils.getCheckedCheckBoxYnValue(usrYn));						// 사용 
		sysmUsr0100DTO.setLockat(SysmUsrUtils.getCheckedCheckBoxYnValue(lockat));					// 계정잠금  / 추가_hieju_06.27
		sysmUsr0100DTO.setUsrAuthEepnYn(SysmUsrUtils.getCheckedCheckBoxYnValue(usrAuthEepnYn));		// 사용자권한제외여부 
		sysmUsr0100DTO.setServcInptPrcsYn(SysmUsrUtils.getCheckedCheckBoxYnValue(servcInptPrcsYn));	// 복무입력처리여부
		sysmUsr0100DTO.setYrtxInptPrcsYn(SysmUsrUtils.getCheckedCheckBoxYnValue(yrtxInptPrcsYn));	// 연말정산입력처리여부
		sysmUsr0100DTO.setPyspInsnYn(SysmUsrUtils.getCheckedCheckBoxYnValue(pyspInsnYn));			// 호봉제포함여부
		sysmUsr0100DTO.setNotPyspInsnYn(SysmUsrUtils.getCheckedCheckBoxYnValue(notPyspInsnYn));		// 비호봉제포함여부
		sysmUsr0100DTO.setShttmInsnYn(SysmUsrUtils.getCheckedCheckBoxYnValue(shttmInsnYn));			// 기간제포함여부
		
		
		if ("".equals(sysmUsr0100DTO.getUsrId()) ||sysmUsr0100DTO.getUsrId() == null) {
			MessageBox.info("", "아이디를 입력해 주세요.", null);
			usrId.focus();
			return;
		}
		
		if ("".equals(sysmUsr0100DTO.getPwd()) ||sysmUsr0100DTO.getPwd() == null) {
			MessageBox.info("", "비밀번호를 입력해 주세요.", null);
			pwd.focus();
			return;
		}
		
		if ("".equals(sysmUsr0100DTO.getUsrNm()) ||sysmUsr0100DTO.getUsrNm() == null) {
			MessageBox.info("", "성명을 입력해 주세요.", null);
			pwd.focus();
			return;
		}
		
		
		sysmUsr0100Service.saveSysmUsr0100(sysmUsr0100DTO, actionDatabase, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveSysmUsr0100(" + "저장에 실패하였습니다." + ") : " + caught), null);
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				
				if(result != 1) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장에 실패하였습니다. </BR>데이터를 확인해 주세요.", null);
				}else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장되었습니다.", null);
					
					reload();
				}
			}
		});
	}
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSearchForm() {
		
		//검색조건 
		LayoutContainer lycSreach = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		lycSreach.setLayout(frmlytStd);
		lycSreach.setHeight(30);
	    
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());
		layoutContainer_12.setStyleAttribute("paddingTop", "5px");
 	    
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_12.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
	    
		srhDeptCd = new ComboBox<BaseModel>();
		srhDeptCd.setForceSelection(true);
		srhDeptCd.setMinChars(1);
		srhDeptCd.setDisplayField("deptNmRtchnt");
		srhDeptCd.setValueField("deptCd");
		srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		srhDeptCd.setSelectOnFocus(true);
		srhDeptCd.setReadOnly(false);
		srhDeptCd.setEnabled(true);
		srhDeptCd.setStore(lsDeptCd);
		srhDeptCd.setFieldLabel("부서");
	   
	    layoutContainer_2.add(srhDeptCd, new FormData("100%")); 
	    layoutContainer_2.setBorders(false);
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(70); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_1.setLayout(frmlytSch);
	    
	    srhUsrDivCd =  new ComboBox<BaseModel>(); 
	    srhUsrDivCd.setForceSelection(true);
	    srhUsrDivCd.setMinChars(1);
	    srhUsrDivCd.setDisplayField("commCdNm");
	    srhUsrDivCd.setValueField("commCd");
	    srhUsrDivCd.setTriggerAction(TriggerAction.ALL);
	  //  usrDivCd.setAllowBlank(true);
	    srhUsrDivCd.setEmptyText("--사용자구분선택--");
	    srhUsrDivCd.setSelectOnFocus(true); 
	    srhUsrDivCd.setReadOnly(false);
	    srhUsrDivCd.setEnabled(true); 
	    srhUsrDivCd.setStore(lsUsrDivCd);
	    srhUsrDivCd.setFieldLabel("사용자구분"); 
	    srhUsrDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
          public void handleEvent(StoreEvent<BaseModel> be) {  

            //  usrDivCd.setValue(lsUsrDivCd.getAt(0));
          }
	    }); 
	  
	    layoutContainer_1.add(srhUsrDivCd, new FormData("100%"));
	    layoutContainer_1.setBorders(false);  
    
 	    LayoutContainer layoutContainer_13 = new LayoutContainer();
 	    frmlytStd = new FormLayout();  
 	    frmlytStd.setLabelWidth(60); 
 	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
 	    layoutContainer_13.setLayout(frmlytStd);
 	   
 	    srhUsrNm = new TextField<String>();
 	    srhUsrNm.setFieldLabel("성 명");
 	    srhUsrNm.addKeyListener(new KeyListener() {
			public void componentKeyUp(ComponentEvent event) {
				super.componentKeyUp(event);
				srhUsrNm.validate();
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					reload();
				}
			}
		});

 	    layoutContainer_13.add(srhUsrNm, new FormData("100%")); 
 	    layoutContainer_13.setBorders(false);
 	
 	    Button btnUsrSearch = new Button("검색");
 	    btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
  	    btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
 	    	public void handleEvent(ButtonEvent e) {
 	    		  
 	    		reload(); 
 	    	}
 	    });
	    
 	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
 	    layoutContainer_12.add(btnUsrSearch );
 	    lycSreach.add(layoutContainer_12);		
 	    
 	    
 	   plFrmSysm0100.add(lycSreach);
		
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
	
	private void createStandardForm() {
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		
		LayoutContainer lcLeft = new LayoutContainer();
		
		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("사용자정보");
//		gridFieldSet.setSize("950px", "600px");
		gridFieldSet.add(createGridForm(), new FormData("100%"));
		lcLeft.add(gridFieldSet);
		
		
		layoutContainer.add(lcLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer lcRigh = new LayoutContainer();
		
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("상세정보");
		fieldSet.setHeight(570);
//		fieldSet.setSize("950px", "600px");
		fieldSet.add(createStdSubFrom(), new FormData("100%"));
		lcRigh.add(fieldSet);
		
		layoutContainer.add(lcRigh, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		plFrmSysm0100.add(layoutContainer);
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
	
	private LayoutContainer createStdSubFrom() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
		
		FieldSet fieldSet01 = new FieldSet();
//		fieldSet01.setHeight("220px");
		fieldSet01.setBorders(false);
		fieldSet01.setHeadingHtml("");
//		gridFieldSet.setSize("950px", "600px");
		
		
		LayoutContainer lc = new LayoutContainer();
		
		LayoutContainer lc01 = new LayoutContainer();
		
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc01.setLayout(frmlytStd);
		
		deptCd = new MSFComboBox<BaseModel>();
		deptCd.setName("deptCd");
		deptCd.setFieldLabel("부 서");
		deptCd.setForceSelection(true);
		deptCd.setMinChars(1);
		deptCd.setDisplayField("deptNmRtchnt");
		deptCd.setValueField("deptCd");
		deptCd.setTriggerAction(TriggerAction.ALL);
		deptCd.setEmptyText("--부서선택--");
		deptCd.setSelectOnFocus(true);
//		deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//		deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		deptCd.setStore(lsDeptCd);
		deptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		deptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    			checkBassP05001Auth("deptCd", listStoredeptCd); 
				}   
		    	   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
			}
		});   
		lc01.add(deptCd, new FormData("100%"));
		
		
		
		LayoutContainer lc02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc02.setLayout(frmlytStd);
		
		Button btnUsrNm = new Button();
		btnUsrNm.setIcon(MSFMainApp.ICONS.search());
		btnUsrNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	if (MSFSharedUtils.allowNulls(usrNm.getValue()).trim().equals("")) {
            		usrNm.setValue("");
                }
            	
//            	if (Constants.SSO_USE_TYPE.equals(MSFMainApp.getMsg("PayGen.SsoUseType"))) { 
            		fnPopupCmmn0990();
//    			 };
            }
        });
		
		
		usrNm = new TextFieldWithButton<String>(btnUsrNm);
		usrNm.setFieldLabel("성명");
		usrNm.setName("usrNm");
		usrNm.addKeyListener(new KeyListener() {
			  @Override
            public void componentKeyDown(ComponentEvent event) {
                
				  usrNm.validate();
                if (MSFSharedUtils.allowNulls(usrNm.getValue()).trim().equals("")) {
                	usrNm.setValue("");
                }if (MSFSharedUtils.paramNull(usrNm.getValue())) {
                	usrNm.setValue("");
                }
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	usrNm.setValue("");
                	
//                	if (Constants.SSO_USE_TYPE.equals(MSFMainApp.getMsg("PayGen.SsoUseType"))) { 
                		fnPopupCmmn0990();
//        			 }
                }
                super.componentKeyDown(event);
            	}
         	});
		lc02.add(usrNm, new FormData("100%"));
		
		
		
		LayoutContainer lc03 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc03.setLayout(frmlytStd);
		
		usrId = new MSFTextField();
		usrId.setName("usrId");
		usrId.setFieldLabel("아이디");
		// srhDpobNm.setAllowBlank(false);
		lc03.add(usrId, new FormData("100%"));

		
		LayoutContainer lc04 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc04Fld = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc04Fld.setLayout(frmlytStd);
		
		pwd = new MSFTextField();
		pwd.setPassword(true);
		pwd.setName("pwd");
		pwd.setFieldLabel("패스워드");
		// srhDpobNm.setAllowBlank(false);
		lc04Fld.add(pwd, new FormData("100%"));
		
		lc04.add(lc04Fld, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
		
		
		Button btnPwdInit = new Button("초기화");
		btnPwdInit.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	
            	
            	if(usrId == null || "".equals(usrId)) {
            		
            		MessageBox.info("", "아이디를 입력해 주세요.", null);
            		usrId.focus();
            		
            		return;
            	}
            	
            	if(MSFSharedUtils.getSelectedComboValue(usrDivCd,"commCd") == null || "".equals(MSFSharedUtils.getSelectedComboValue(usrDivCd,"commCd"))) {
            		
            		MessageBox.info("", "사용자권한을 선택해주세요.", null);
            		usrDivCd.focus();
            		
            		return;
            	}
            	
            	resetPwd(MSFSharedUtils.getSelectedComboValue(usrDivCd,"commCd"));
            }
        });		
		lc04.add(btnPwdInit);
		

		
		LayoutContainer lc05 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc05.setLayout(frmlytStd);
		
		usrDivCd = new MSFComboBox<BaseModel>();
		usrDivCd.setName("usrDivCd");
		usrDivCd.setFieldLabel("사용자권한");
		usrDivCd.setForceSelection(true);
		usrDivCd.setMinChars(1);
		usrDivCd.setDisplayField("commCdNm");
		usrDivCd.setValueField("commCd");
		usrDivCd.setTriggerAction(TriggerAction.ALL);
		usrDivCd.setEmptyText("--권한선택--");
		usrDivCd.setSelectOnFocus(true);
		usrDivCd.setStore(lsUsrDivCd);
//		usrDivCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200); 
		usrDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    			checkBassP05001Auth("deptCd", listStoredeptCd); 
				}   
		    	   // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
			}
		});   
		lc05.add(usrDivCd, new FormData("100%"));
		
		
		
		LayoutContainer lc06 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc06.setLayout(frmlytStd);
		
		usrTel = new MSFTextField();
		usrTel.setName("usrTel");
		usrTel.setFieldLabel("내선번호");
		// srhDpobNm.setAllowBlank(false);
		lc06.add(usrTel, new FormData("100%"));
		
		
		LayoutContainer lc07 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc07.setLayout(frmlytStd);
		
		email = new MSFTextField();
		email.setName("email");
		email.setFieldLabel("이메일");
		// srhDpobNm.setAllowBlank(false);
		lc07.add(email, new FormData("100%"));
		
		
		LayoutContainer lc08 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc08.setLayout(frmlytStd);
		
		usrYn = new CheckBox();
		usrYn.setName("dpobFndtnUseYn");
		usrYn.setLabelSeparator("");
		usrYn.setBoxLabel("사용여부");
		usrYn.setHideLabel(false);
		usrYn.setValue(false);
		
		lc08.add(usrYn, new FormData("100%"));
		
		LayoutContainer lc09 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lc09.setLayout(frmlytStd);
		
		lockat = new CheckBox();
		lockat.setName("lockat");
		lockat.setLabelSeparator("");
		lockat.setBoxLabel("계정잠금");
		lockat.setHideLabel(false);
		lockat.setValue(false);
		
		lc09.add(lockat, new FormData("100%"));
		
		
		lc.add(lc01);
		lc.add(lc02);
		lc.add(lc03);
		lc.add(lc04);
		lc.add(lc05);
		lc.add(lc06);
		lc.add(lc07);
		lc.add(lc08);
		lc.add(lc09);
		
		
		fieldSet01.add(lc);
		
		
		
		FieldSet fieldSet02 = new FieldSet();
		fieldSet02.setHeadingHtml("사용권한");
//		fieldSet02.setHeight("120px");
		
		LayoutContainer lcCkBox = new LayoutContainer();
		
		ckAuthBox = new CheckBoxGroup();
		ckAuthBox.setLabelSeparator("");
		ckAuthBox.setName("ckAuthBox");
		ckAuthBox.setHideLabel(true);


		usrAuthEepnYn  = new CheckBox();
		usrAuthEepnYn.setBoxLabel("사용자권한제외");
		usrAuthEepnYn.setHideLabel(false);
		usrAuthEepnYn.setValueAttribute("Y");
		usrAuthEepnYn.addListener(Events.Change, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent be) {
				// TODO Auto-generated method stub
				// 사용자권한제외 체크시
				if(SysmUsrUtils.getCheckedCheckBoxYnValue(usrAuthEepnYn) == "Y" || "Y".equals(SysmUsrUtils.getCheckedCheckBoxYnValue(usrAuthEepnYn))) {
					
//					Window.alert("작동");
					
					// 사용권한 비활성화 및 선택 초기화 해줌
					servcInptPrcsYn.setValue(false);	
					yrtxInptPrcsYn.setValue(false);	
					pyspInsnYn.setValue(false);	
					notPyspInsnYn.setValue(false);	
					shttmInsnYn.setValue(false);
					
					servcInptPrcsYn.setReadOnly(true);
					yrtxInptPrcsYn.setReadOnly(true);
					pyspInsnYn.setReadOnly(true);
					notPyspInsnYn.setReadOnly(true);
					shttmInsnYn.setReadOnly(true);
					
					
				}else {
					
					servcInptPrcsYn.setReadOnly(false);
					yrtxInptPrcsYn.setReadOnly(false);
					
				}
			}
			
		});
		ckAuthBox.add(usrAuthEepnYn);
		
		
		servcInptPrcsYn  = new CheckBox();
		servcInptPrcsYn.setBoxLabel("복무관리");
		servcInptPrcsYn.setHideLabel(false);
		servcInptPrcsYn.setValueAttribute("Y");
		servcInptPrcsYn.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				
				checkBoxVaild(servcInptPrcsYn);
			}
			
		});
		ckAuthBox.add(servcInptPrcsYn);
		
		yrtxInptPrcsYn  = new CheckBox();
		yrtxInptPrcsYn.setBoxLabel("연말정산");
		yrtxInptPrcsYn.setHideLabel(false);
		yrtxInptPrcsYn.setValueAttribute("Y");
		yrtxInptPrcsYn.addListener(Events.Change, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				
				checkBoxVaild(yrtxInptPrcsYn);
			}
			
		});
		ckAuthBox.add(yrtxInptPrcsYn);
		fieldSet02.add(ckAuthBox);
		
		fieldSet02.add(lcCkBox);
		
		
		
		FieldSet fieldSet03 = new FieldSet();
		fieldSet03.setHeadingHtml("고용대상선택");
//		fieldSet03.setHeight("60px");
		
		LayoutContainer lcCkBox2 = new LayoutContainer();
		
		
		ckInsnBox = new CheckBoxGroup();
		ckInsnBox.setLabelSeparator("");
		ckInsnBox.setName("ckInsnBox");
		ckInsnBox.setHideLabel(true);


		pyspInsnYn  = new CheckBox();
		pyspInsnYn.setBoxLabel("호봉제(무기)");
		pyspInsnYn.setHideLabel(false);
		pyspInsnYn.setValueAttribute("Y");
		pyspInsnYn.setReadOnly(true);
		ckInsnBox.add(pyspInsnYn);
		
		
		notPyspInsnYn  = new CheckBox();
		notPyspInsnYn.setBoxLabel("비호봉제(전환)");
		notPyspInsnYn.setHideLabel(false);
		notPyspInsnYn.setValueAttribute("Y");
		notPyspInsnYn.setReadOnly(true);
		ckInsnBox.add(notPyspInsnYn);
		
		shttmInsnYn  = new CheckBox();
		shttmInsnYn.setBoxLabel("기간제");
		shttmInsnYn.setHideLabel(false);
		shttmInsnYn.setValueAttribute("Y");
		shttmInsnYn.setReadOnly(true);
		ckInsnBox.add(shttmInsnYn);
		
		lcCkBox2.add(ckInsnBox);
		fieldSet03.add(lcCkBox2);
		fieldSet02.add(fieldSet03);
		
		
		
		lcTabFormLayer.add(fieldSet01);
		lcTabFormLayer.add(fieldSet02);
		
		
		
		return lcTabFormLayer;
		
	}
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
	
	private LayoutContainer createGridForm() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "10px");
		lcTabFormLayer.setStyleAttribute("paddingRight", "10px");

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(460, 550);
		
	      //msfCustomForm.setHeaderVisible(false);
	      //Instantiate the GridPanel
		msfGridPanel = new MSFGridPanel(admSysm0100, false, false, false, false);
		msfGridPanel.setHeaderVisible(false);
		msfGridPanel.setBodyBorder(false);
		msfGridPanel.setBorders(true);
		
        final Grid sysm0100Grid = msfGridPanel.getMsfGrid().getGrid();
        sysm0100Grid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {  
        	   
        	   // 입력 폼 초기화
        	   sysmUsr0100FormInit();
        	   
        	   if (msfGridPanel.getCurrentlySelectedItem() != null) { 
        		   
        		   actionDatabase = ActionDatabase.UPDATE;
//         		 
        		   //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
        		   leftSysUsr0100Detail(msfGridPanel.getCurrentlySelectedItem());
        	   }
           }
        }); 	
	     
		cp01.add(msfGridPanel);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	   
	  @Override
	    public void reload() {
	    	
//	    	if ( MSFSharedUtils.paramNull(usrNm.getValue())) {
//	    		 MessageBox.alert("검색오류", 
//	    				 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("성명을 선택하십시요."), null); 
//	    		usrNm.focus();
//	    	} else {
	    		IColumnFilter filters = null;
	        	msfGridPanel.getTableDef().setTableColumnFilters(filters);
	    		 
	        	msfGridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	        	msfGridPanel.getTableDef().addColumnFilter("usrDivCd", MSFSharedUtils.getSelectedComboValue(srhUsrDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	        	msfGridPanel.getTableDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(srhUsrNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	        	msfGridPanel.getTableDef().addColumnFilter("searchKeyword", "Y", SimpleColumnFilter.OPERATOR_EQUALS); 
	            msfGridPanel.reload();
	    
	}
	  
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업 화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void fnPopupCmmn0990() {
		MSFFormPanel popCom0990 = SysmUsrUtils.lovPopUpMsfSysComP0990Form();
		final FormBinding popBindingCom0990 = popCom0990.getFormBinding();
		popBindingCom0990.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("userId"))) {
					
			    	SysmUsrUtils.setSelectedComboValue(deptCd, MSFSharedUtils.allowNulls(mapModel.get("deptCd")));	// 부서
			    	usrNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("userName")));							// 성명
			    	usrId.setValue(MSFSharedUtils.allowNulls(mapModel.get("userId")));								// 아이디
			    	email.setValue(MSFSharedUtils.allowNulls(mapModel.get("email")));								// 이메일
			    	usrTel.setValue(MSFSharedUtils.allowNulls(mapModel.get("tel")));								// 내선전화
			    	
				}
			}
		});
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업 화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	

	private SysmUsr0100 getThis() {
		return this;
	}
	
	private void sysmUsr0100FormInit() {
		
		deptCd.setValue(new BaseModel());			// 부서
		usrNm.setValue(""); 						// 성명
		usrId.setValue("");							// 아이디
		pwd.setValue("");							// 비밀번호
		usrDivCd.setValue(new BaseModel());			// 사용자 권한	
		usrTel.setValue("");						// 내선번호
		email.setValue("");							// 이메일	
		usrYn.setValue(false);						// 사용 
		lockat.setValue(false);                     // 계정잠금 / 추가_hieju/06.27
		usrAuthEepnYn.setValue(false);				// 사용자권한제외여부 
		servcInptPrcsYn.setValue(false);			// 복무입력처리여부 
		yrtxInptPrcsYn.setValue(false);				// 연말정산입력처리여부 
		pyspInsnYn.setValue(false);					// 호봉제포함여부 
		notPyspInsnYn.setValue(false);				// 비호봉제포함여부
		shttmInsnYn.setValue(false);				// 기간제포함여부 
		yoobhMnthDay.setValue("");					// 주민번호 앞자리
		
	}
	
	
    private void leftSysUsr0100Detail(BaseModel selRecord) {
    	
    	GWT.debugger();
    	
    	SysmUsrUtils.setSelectedComboValue(deptCd, (String)selRecord.get("deptCd$deptCd"), "deptCd");	// 부서
    	usrNm.setValue((String)selRecord.get("usrNm"));													// 성명
    	usrId.setValue((String)selRecord.get("usrId"));													// 아이디
    	pwd.setValue((String)selRecord.get("pwd"));														// 비밀번호
    	SysmUsrUtils.setSelectedComboValue(usrDivCd,(String)selRecord.get("usrDivCd$commCd"),"commCd");	// 사용자 권한		
    	usrTel.setValue((String)selRecord.get("usrTel"));												// 내선번호
    	email.setValue((String)selRecord.get("email"));													// 이메일	
    	usrYn.setValue((Boolean) selRecord.get("useYn"));												// 사용 
    	lockat.setValue((Boolean)selRecord.get("lockat"));                                               // 계정잠금 / hieju/06.27 추가
    	
    	
    	usrAuthEepnYn.setValue((Boolean) selRecord.get("usrAuthEepnYn"));								// 사용자권한제외여부 
    	servcInptPrcsYn.setValue((Boolean) selRecord.get("servcInptPrcsYn"));							// 복무입력처리여부 
    	yrtxInptPrcsYn.setValue((Boolean) selRecord.get("yrtxInptPrcsYn"));								// 연말정산입력처리여부
    	
    	pyspInsnYn.setValue((Boolean) selRecord.get("pyspInsnYn"));										// 호봉제포함여부 
    	notPyspInsnYn.setValue((Boolean) selRecord.get("notPyspInsnYn"));								// 비호봉제포함여부
    	shttmInsnYn.setValue((Boolean) selRecord.get("shttmInsnYn"));									// 기간제포함여부 
    	yoobhMnthDay.setValue((String)selRecord.get("yoobhMnthDay"));									// 주민번호 앞자리
    
    }
    	
	//엑셀 저장
	private void excelFileExport() {
		
		msfGridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    	msfGridPanel.getTableDef().addColumnFilter("usrDivCd", MSFSharedUtils.getSelectedComboValue(srhUsrDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
    	msfGridPanel.getTableDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(srhUsrNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
    	msfGridPanel.getTableDef().addColumnFilter("searchKeyword", "Y", SimpleColumnFilter.OPERATOR_EQUALS); 
	                     
		HashMap<String, String> param = new HashMap<String, String>(); 
	   
		param.put("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd"));
		param.put("usrDivCd", MSFSharedUtils.getSelectedComboValue(srhUsrDivCd,"commCd"));
		param.put("usrNm",  MSFSharedUtils.defaultNulls(srhUsrNm.getValue(),""));
		param.put("searchKeyword", "Y");
	                     
		msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileSysmUsr0100Export.do","extgwtFrame" ,param);   
	
	}	
	
	
	private void checkBoxVaild(CheckBox ckBox) {
		
		// 복무관리나 연말정산 체크시 고용대상선택 활성화
		if(SysmUsrUtils.getCheckedCheckBoxYnValue(ckBox) == "Y" || "Y".equals(SysmUsrUtils.getCheckedCheckBoxYnValue(ckBox))) {
		
			pyspInsnYn.setReadOnly(false);
			notPyspInsnYn.setReadOnly(false);
			shttmInsnYn.setReadOnly(false);
			
		}else {
			
			if(SysmUsrUtils.getCheckedCheckBoxYnValue(servcInptPrcsYn) == "Y" || "Y".equals(SysmUsrUtils.getCheckedCheckBoxYnValue(servcInptPrcsYn))
				||	SysmUsrUtils.getCheckedCheckBoxYnValue(yrtxInptPrcsYn) == "Y" || "Y".equals(SysmUsrUtils.getCheckedCheckBoxYnValue(yrtxInptPrcsYn))) {
				
			}else {
			// 복무관리나 연말정산 둘 중에 하나라도 체크되어 있으면 초기화 해주지 않음.	
				pyspInsnYn.setValue(false);
				notPyspInsnYn.setValue(false);
				shttmInsnYn.setValue(false);
			}
			
			pyspInsnYn.setReadOnly(true);
			notPyspInsnYn.setReadOnly(true);
			shttmInsnYn.setReadOnly(true);
			
		}
	}
	
	/** 비밀번호 초기화 **/
	private void resetPwd(String usrDivCd) {
		
		
		// 1. 공무직 / 기간제 -> [ paygen + 주민번호 앞6자리 ]
       	if("D0010070".equals(usrDivCd) || "D0010070" == usrDivCd
    			|| "D0010080".equals(usrDivCd) || "D0010080" == usrDivCd ) {
       		
       		
    		SysmUsr0100DTO sysmUsr0100Dto = new SysmUsr0100DTO();
    		sysmUsr0100Dto.setUsrId(usrId.getValue());													// 아이디
    		
    		
    		sysmUsr0100Service.getPwdInitUsrInfo(sysmUsr0100Dto, new AsyncCallback<SysmUsr0100DTO>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
							MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getPwdInitUsrInfo(" + "비밀번호 초기화 중 오류 발생" + ") : " + caught), null);
				}

				@Override
				public void onSuccess(SysmUsr0100DTO result) {
					
					// TODO Auto-generated method stub
					yoobhMnthDay.setValue(result.getYoobhMnthDay());
					pwd.setValue("paygen" + yoobhMnthDay.getValue());
				}
    		});
    	
    		
    	// 2. 공무원		   -> [ paygen + 아이디 ]
    	}else {
    		pwd.setValue("paygen" + usrId.getValue());
    	}
       	
	}

}
