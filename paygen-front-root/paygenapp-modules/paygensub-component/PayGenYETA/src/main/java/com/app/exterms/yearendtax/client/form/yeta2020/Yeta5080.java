package com.app.exterms.yearendtax.client.form.yeta2020;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.InfcPkgSysm0100DTO;
import com.app.exterms.yearendtax.client.form.defs.InfcPkgSysm0100Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2020.Yeta5080Def;
import com.app.exterms.yearendtax.client.service.InfcPkgSysm0100Service;
import com.app.exterms.yearendtax.client.service.InfcPkgSysm0100ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Yeta5080  extends MSFPanel { 

	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/


	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

	private VerticalPanel vp;
	private FormPanel plFrmYeta5080;
	private FormData formData; 
	private String txtForm = "";
	private XTemplate detailTp;	  
//	private Yeta5080ServiceAsync Yeta5080service = Yeta5080Service.Util.getInstance();
	private InfcPkgSysm0100ServiceAsync infcPkgSysm0100Service = InfcPkgSysm0100Service.Util.getInstance();
	
	private TextField<String> deptNmHan ;  	// 부서명
	private TextField<String> onUsrNm; 		// 선택된 사용자
	private TextField<String> offUsrNm; 	// 미선택된 사용자
	private HiddenField<String> deptCd;
	
	private Yeta5080Def Yeta5080Def 				= new Yeta5080Def("yeta5080ToBass0400");
//	private Yeta5080Def Yeta5080ToSysm0100OnDef 	= new Yeta5080Def("Yeta5080ToSysm0100On");
//	private Yeta5080Def Yeta5080ToSysm0100OffDef 	= new Yeta5080Def("Yeta5080ToSysm0100Off");	
	private InfcPkgSysm0100Def Yeta5080ToSysm0100OnDef 		= new InfcPkgSysm0100Def("yeta5080ToSysm0100On");
	private InfcPkgSysm0100Def Yeta5080ToSysm0100OffDef 	= new InfcPkgSysm0100Def("yeta5080ToSysm0100Off");
	
	private MSFGridPanel msfGridPanelYeta5080; 
	private MSFGridPanel msfGridPanelSysm0100On;
	private MSFGridPanel msfGridPanelSysm0100Off;
	
	private Button btnAddSysm0100On;
	private Button btnAllSelSysm0100On;
	private Button btnAllUnSelSysm0100On;
	private Button btndelSysm0100On;
	
	private Button btnAllSelSysm0100Off;
	private Button btnAllUnSelSysm0100Off;
	private Button btnAddSysm0100Off;
	
	
	private List<InfcPkgSysm0100DTO> lsInfcPkgSysm0100Dto = new ArrayList<InfcPkgSysm0100DTO>(); 
	private InfcPkgSysm0100DTO infcPkgSysm0100Dto;
	
	public ContentPanel getViewPanel() {
		if (panel == null) {

			vp = new VerticalPanel();
			vp.setSpacing(10);
			createSysm0500Form(); // 화면 기본정보를 설정
			vp.setSize("1010px", "700px");  

//			final RelationDef  relBass0360 = new RelationDef(Yeta5080MSDef,false);
//			relBass0360.addJoinDef("dpobCd", "dpobCd"); 
//			relBass0360.addJoinDef("deptCd", "deptCd"); 
//			relBass0360.setLinkedObject(msfGridPanelYeta5080MS);
//			Yeta5080ToBass0500OnDef.addRelation(relBass0360); 
//
//			/**
//			 * Create the relations 
//			 */
//			final RelationDef  relBass0350 = new RelationDef(Yeta5080MSDef,false);
//			relBass0350.addJoinDef("dpobCd", "dpobCd"); 
//			relBass0350.addJoinDef("deptCd", "deptCd"); 
//			relBass0350.setLinkedObject(msfGridPanelYeta5080MS);
//			Yeta5080ToBass0500OffDef.addRelation(relBass0350); 
//
//
//			// DETAILS 
//			final Grid Yeta5080ToBass0500OffDefGrid = msfGridPanelYeta5080MS.getMsfGrid().getGrid();
//			Yeta5080ToBass0500OffDefGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//				public void handleEvent(BaseEvent be) {  
//					if (msfGridPanelYeta5080MS.getCurrentlySelectedItem() != null) {  
//
//						Yeta5080ToBass0500OnDef.synchronizeGridDetail(
//								msfGridPanelYeta5080MS.getCurrentlySelectedItem(),
//								msfGridPanelBass0500On );
//
//						Yeta5080ToBass0500OffDef.synchronizeGridDetail(
//								msfGridPanelYeta5080MS.getCurrentlySelectedItem(),
//								msfGridPanelBass0500Off ); 
//					}
//
//				}
//			});

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
	 * @wbp.parser.constructor
	 */
	public Yeta5080() {
		setSize("1010px", "700px");  
	} 

	public Yeta5080(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createSysm0500Form() {
		  
//		listStoreA041 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);  
//		lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);

		
		plFrmYeta5080 = new FormPanel();
		plFrmYeta5080.setHeadingText("PayGen Ver1.0 - 연말정산등록담당자관리");
		plFrmYeta5080.setIcon(Resources.APP_ICONS.text());
		plFrmYeta5080.setBodyStyleName("pad-text");
		plFrmYeta5080.setFrame(true); 
		plFrmYeta5080.setPadding(2);
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("연말정산등록담당자관리","Yeta5080");
				}
			});
		plFrmYeta5080.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta5080.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		deptCd = new HiddenField<String>();
		deptCd.setName("deptCd");
		plFrmYeta5080.add(deptCd);
		
		HorizontalPanel inner = new HorizontalPanel();
		inner.setBorders(false);
		inner.setLayout(new FitLayout());
//		Yeta5080Def.setReadOnly(true);
		msfGridPanelYeta5080 = new MSFGridPanel(Yeta5080Def, false, false, false, true, false);
		msfGridPanelYeta5080.setSize(300, 610);
		msfGridPanelYeta5080.setBorders(true);
		msfGridPanelYeta5080.getGrid().setBorders(true);
		Grid grid = msfGridPanelYeta5080.getMsfGrid().getGrid();
		grid.addListener(Events.CellDoubleClick , new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				
				
				BaseModel bmData = msfGridPanelYeta5080.getCurrentlySelectedItem();  
				
				deptCd = new HiddenField<String>();
				deptCd.setValue(MSFSharedUtils.allowNulls(bmData.get("deptCd")));
				
              	onUserReload();
              	offUserReload();
              }					
          });
          
		// 부서명 검색조건
		LayoutContainer lycSreach = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		lycSreach.setLayout(frmlytStd);
		lycSreach.setHeight(30);

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		layoutContainer_12.setLayout(new ColumnLayout());
   	    layoutContainer_12.setStyleAttribute("paddingTop", "5px");
   	    
   	    
   	    LayoutContainer layoutContainer_13 = new LayoutContainer();
   	    frmlytStd = new FormLayout();  
   	    frmlytStd.setLabelWidth(60); 
   	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
   	    layoutContainer_13.setLayout(frmlytStd);

		deptNmHan = new TextField<String>();
		deptNmHan.setFieldLabel("부서명");
   	   	deptNmHan.addKeyListener(new KeyListener() {
  			public void componentKeyDown(ComponentEvent event) {
  				super.componentKeyDown(event);
				deptNmHan.validate();
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					reDeptload();
				}
  			}
  		});
   	    
   	    
   	    layoutContainer_13.add(deptNmHan, new FormData("100%"));
   	    layoutContainer_13.setBorders(false);
   	
   	    Button btnUsrSearch = new Button("검색");
   	    btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
    	    btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
   	    	public void handleEvent(ButtonEvent e) { 
   	    		reDeptload(); 
   	    	}
   	    });
   	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
   	    layoutContainer_12.add(btnUsrSearch);
   	    lycSreach.add(layoutContainer_12);		     	     
		msfGridPanelYeta5080.setTopComponent(lycSreach);
		inner.add(msfGridPanelYeta5080);
          
          
		// 선택된 사용자 
		msfGridPanelSysm0100On = new MSFGridPanel(Yeta5080ToSysm0100OnDef, false, false, false, false,false); 
		msfGridPanelSysm0100On.setSize(650, 300);
		msfGridPanelSysm0100On.getGrid().setBorders(true);
       
		final Grid<BaseModel> grid2 = msfGridPanelSysm0100On.getMsfGrid().getGrid();
        final ColumnModel columnModel =  grid2.getColumnModel();
        final List<ColumnConfig> columnConfigs = columnModel.getColumns();
        final CheckColumnConfig check = new CheckColumnConfig("select", "선택", 55); 
        check.setAlignment(Style.HorizontalAlignment.CENTER);		            
		check.setEditor(columnConfigs.get(0).getEditor());
		columnConfigs.set(0, check);

		check.setRenderer(columnConfigs.get(0).getRenderer());
		grid2.addPlugin(check);
		grid2.getView().setForceFit(true);
          
          
		LayoutContainer lycSreach2 = new LayoutContainer();
		FormLayout frmlytStd2 = new FormLayout();
		frmlytStd2.setLabelWidth(0);
		lycSreach2.setLayout(frmlytStd2);
		lycSreach2.setHeight(30);

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		layoutContainer_14.setLayout(new ColumnLayout());
		layoutContainer_14.setStyleAttribute("paddingTop", "5px");
		layoutContainer_14.setBorders(true);

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytStd2 = new FormLayout();
		frmlytStd2.setLabelWidth(70);
		frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytStd2);
   	   
		onUsrNm = new TextField<String>();
		onUsrNm.setFieldLabel("사용자명");
		onUsrNm.addKeyListener(new KeyListener() {
             public void componentKeyDown(ComponentEvent event) {
            	 onUsrNm.validate();
                 if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	 onUserReload(); 
                 }
                 super.componentKeyDown(event);
             }
         });
   	    
   	    layoutContainer_15.add(onUsrNm, new FormData("100%"));
   	
   	    Button btnUsrSearch2 = new Button("검색");
   	    btnUsrSearch2.setIcon(MSFMainApp.ICONS.search());
    	    btnUsrSearch2.addListener(Events.Select, new Listener<ButtonEvent>() {
   	    	public void handleEvent(ButtonEvent e) { 
   	    		onUserReload(); 
   	    	}
   	    });
    	    

		ToolBar bottomToolbar = new ToolBar();
		bottomToolbar.add(new FillToolItem());
            
		// 선택된 사용자 툴바
		btnAddSysm0100On = new Button("추가");
		btnAddSysm0100On.addSelectionListener(new SelectionListener<ButtonEvent>() {   
            	
			public void componentSelected(ButtonEvent ce) {
				
			}
		});
//		bottomToolbar.add(btnAddSysm0100On);
		bottomToolbar.add(new SeparatorMenuItem());		
		
		
		btnAllSelSysm0100On = new Button("전체선택");
		btnAllSelSysm0100On.addSelectionListener(new SelectionListener<ButtonEvent>() {		        
			public void componentSelected(ButtonEvent ce) { 
                	
				int  lsCnt = msfGridPanelSysm0100On.getMsfGrid().getGrid().getStore().getCount();
                	  
				for(int iCnt=0;iCnt < lsCnt;iCnt++) {
                		  
					msfGridPanelSysm0100On.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
					msfGridPanelSysm0100On.getMsfGrid().getGrid().getStore().commitChanges();
                		   
				} 
				msfGridPanelSysm0100On.getMsfGrid().getGrid().getView().refresh(true);
			}
		});

		bottomToolbar.add(btnAllSelSysm0100On);
		bottomToolbar.add(new SeparatorMenuItem());
            
		
		btnAllUnSelSysm0100On = new Button("전체해제");
		btnAllUnSelSysm0100On.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  
                	
				int  lsCnt = msfGridPanelSysm0100On.getMsfGrid().getGrid().getStore().getCount();
                	  
				for(int iCnt=0;iCnt < lsCnt;iCnt++) {
                		  
					msfGridPanelSysm0100On.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
					msfGridPanelSysm0100On.getMsfGrid().getGrid().getStore().commitChanges();
                		   
				} 
				msfGridPanelSysm0100On.getMsfGrid().getGrid().getView().refresh(true);
			}  
		});

		bottomToolbar.add(btnAllUnSelSysm0100On);
		bottomToolbar.add(new SeparatorMenuItem());

		
		btndelSysm0100On = new Button("미사용");
		btndelSysm0100On.addSelectionListener(new SelectionListener<ButtonEvent>() {   
            	
			public void componentSelected(ButtonEvent ce) {
				
				lsInfcPkgSysm0100Dto = new ArrayList<InfcPkgSysm0100DTO>(); 
				
				Iterator<BaseModel> itBm  = msfGridPanelSysm0100On.getMsfGrid().getGrid().getStore().getModels().listIterator(); 
            	  
            	  
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				}
				
				Iterator<Record> iterRecords = lsRec.iterator();
    			          
				while (iterRecords.hasNext()) {
					
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}
				
					if ((Boolean)bmMapModel.get("select")) { 
						
						infcPkgSysm0100Dto = new InfcPkgSysm0100DTO();
		    		            	  
						infcPkgSysm0100Dto.setSysDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("sysDivCd")));    			/** column 시스템구분코드 : sysDivCd */
						infcPkgSysm0100Dto.setUsrId(MSFSharedUtils.allowNulls(bmMapModel.get("usrId")));    				/** column 사용자아이디 : usrId */
						infcPkgSysm0100Dto.setUsrNm(MSFSharedUtils.allowNulls(bmMapModel.get("usrNm")));    				/** column 사용자성명 : usrNm */
						infcPkgSysm0100Dto.setUsrDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("usrDivCd")));    			/** column 사용자권한구분코드 : usrDivCd */
						infcPkgSysm0100Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    		/** column SYSTEMKEY : systemkey */
						infcPkgSysm0100Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));    				/** column 부서코드 : deptCd */
						infcPkgSysm0100Dto.setPayMangeDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payMangeDeptCd")));	/** column 단위기관코드 : payMangeDeptCd */  							
						
						infcPkgSysm0100Dto.setYrtxInptPrcsYn("N");    														/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
						
						lsInfcPkgSysm0100Dto.add(infcPkgSysm0100Dto);
						
						
//						infcPkgSysm0100Dto.setUsrTel(MSFSharedUtils.allowNulls(egovMap.get("usrTel")));    /** column 전화번호 : usrTel */
//						infcPkgSysm0100Dto.setEmail(MSFSharedUtils.allowNulls(egovMap.get("email")));    /** column 이메일 : email */
//						infcPkgSysm0100Dto.setPwd(MSFSharedUtils.allowNulls(egovMap.get("pwd")));    /** column 패스워드 : pwd */
//						infcPkgSysm0100Dto.setUseYn(MSFSharedUtils.allowNulls(egovMap.get("useYn")));    /** column 사용자사용여부 : useYn */
//						infcPkgSysm0100Dto.setKybdr(MSFSharedUtils.allowNulls(egovMap.get("kybdr")));    /** column 입력자 : kybdr */
//						infcPkgSysm0100Dto.setInptDt(MSFSharedUtils.allowNulls(egovMap.get("inptDt")));    /** column 입력일자 : inptDt */
//						infcPkgSysm0100Dto.setInptAddr(MSFSharedUtils.allowNulls(egovMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
//						infcPkgSysm0100Dto.setIsmt(MSFSharedUtils.allowNulls(egovMap.get("ismt")));    /** column 수정자 : ismt */
//						infcPkgSysm0100Dto.setRevnDt(MSFSharedUtils.allowNulls(egovMap.get("revnDt")));    /** column 수정일자 : revnDt */
//						infcPkgSysm0100Dto.setRevnAddr(MSFSharedUtils.allowNulls(egovMap.get("revnAddr")));    /** column 수정주소 : revnAddr */
//						infcPkgSysm0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(egovMap.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
//						infcPkgSysm0100Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(egovMap.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//						infcPkgSysm0100Dto.setUsrAuthEepnYn(MSFSharedUtils.allowNulls(egovMap.get("usrAuthEepnYn")));    /** column 사용자권한제외여부 : usrAuthEepnYn */
//						infcPkgSysm0100Dto.setPyspInsnYn(MSFSharedUtils.allowNulls(egovMap.get("pyspInsnYn")));    /** column 호봉제포함여부 : pyspInsnYn */
//						infcPkgSysm0100Dto.setNotPyspInsnYn(MSFSharedUtils.allowNulls(egovMap.get("notPyspInsnYn")));    /** column 비호봉제포함여부 : notPyspInsnYn */
//						infcPkgSysm0100Dto.setServcInptPrcsYn(MSFSharedUtils.allowNulls(egovMap.get("servcInptPrcsYn")));    /** column 복무입력처리여부 : servcInptPrcsYn */
//
//						infcPkgSysm0100Dto.setShttmInsnYn(MSFSharedUtils.allowNulls(egovMap.get("shttmInsnYn")));    /** column 기간제포함여부 : shttmInsnYn */
//						infcPkgSysm0100Dto.setUsrAuthDivCd(MSFSharedUtils.allowNulls(egovMap.get("usrAuthDivCd")));    /** column 사용자권한구분코드 : usrAuthDivCd */
//						infcPkgSysm0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(egovMap.get("dtilOccuInttnCd")));    /** column 직종세코드 : dtilOccuInttnCd */
//						infcPkgSysm0100Dto.setAuthInStdt(MSFSharedUtils.allowNulls(egovMap.get("authInStdt")));    /** column 권한적용시작일자 : authInStdt */
//						infcPkgSysm0100Dto.setAuthInEddt(MSFSharedUtils.allowNulls(egovMap.get("authInEddt")));    /** column 권한적용종료일자 : authInEddt */
//						infcPkgSysm0100Dto.setUsrLgnAccLckYn(MSFSharedUtils.allowNulls(egovMap.get("usrLgnAccLckYn")));    /** column 사용자계정잠김여부 : usrLgnAccLckYn */
//						infcPkgSysm0100Dto.setUntDpobCd(MSFSharedUtils.allowNulls(egovMap.get("untDpobCd")));    /** column 단위사업장코드 : untDpobCd */
							            	  

					}
				}
				
				if(lsInfcPkgSysm0100Dto.size() < 1) {
					MessageBox.alert("알림", "처리할 데이타가 존재하지 않습니다.", null);
	  	              	return;
				}else {
					updateSysm0100Yn(lsInfcPkgSysm0100Dto);
				}	
				
			}
		});
		bottomToolbar.add(btndelSysm0100On);
		bottomToolbar.add(new SeparatorMenuItem());

		Button refresh = new Button();
		refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				onUserReload();
			}
		});
		bottomToolbar.add(refresh);
    	    
   	    layoutContainer_14.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
   	    layoutContainer_14.add(btnUsrSearch2);
   	    lycSreach2.add(layoutContainer_14);		     	     
   	    msfGridPanelSysm0100On.setTopComponent(lycSreach2);

   	    Yeta5080ToSysm0100OffDef.setReadOnly(true);
   	    // ------------------------ 미선택된 사용자
   	    msfGridPanelSysm0100Off = new MSFGridPanel(Yeta5080ToSysm0100OffDef, false, false, false, false, false); 
   	    msfGridPanelSysm0100Off.setSize(650, 300);
   	    msfGridPanelSysm0100Off.setBorders(true);
	        
   	    final Grid<BaseModel> grid3 = msfGridPanelSysm0100Off.getMsfGrid().getGrid();
		final ColumnModel columnModel3 = grid3.getColumnModel();
		List<ColumnConfig> columnConfigs3 = columnModel3.getColumns();
		final CheckColumnConfig check3 = new CheckColumnConfig("select", "선택", 55);
		check3.setAlignment(Style.HorizontalAlignment.CENTER);
		check3.setEditor(columnConfigs3.get(0).getEditor());
		columnConfigs3.set(0, check3);
          
		check3.setRenderer(columnConfigs3.get(0).getRenderer());
		grid3.addPlugin(check3);
		grid3.getView().setForceFit(true);
          
          
		LayoutContainer lycSreach3 = new LayoutContainer();
		FormLayout frmlytStd3 = new FormLayout();
		frmlytStd3.setLabelWidth(0);
		lycSreach3.setLayout(frmlytStd3);
		lycSreach3.setHeight(30);

		LayoutContainer layoutContainer_17 = new LayoutContainer();
		layoutContainer_17.setLayout(new ColumnLayout());
		layoutContainer_17.setStyleAttribute("paddingTop", "5px");
		layoutContainer_17.setBorders(true);

		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytStd2 = new FormLayout();
		frmlytStd2.setLabelWidth(70);
		frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytStd2);
   	   
		offUsrNm = new TextField<String>();
		offUsrNm.setFieldLabel("사용자명");
		offUsrNm.addKeyListener(new KeyListener() {
             public void componentKeyDown(ComponentEvent event) {
                 
            	 offUsrNm.validate();
                 if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	 offUserReload(); 
                 }
                 super.componentKeyDown(event);
             }
         });
   	    
   	    layoutContainer_18.add(offUsrNm, new FormData("100%"));
   	    layoutContainer_18.setBorders(false);
   	
   	    Button btnUsrSearch3 = new Button("검색");
   	    btnUsrSearch3.setIcon(MSFMainApp.ICONS.search());
   	    btnUsrSearch3.addListener(Events.Select, new Listener<ButtonEvent>() {
   	    	public void handleEvent(ButtonEvent e) { 
   	    		offUserReload(); 
   	    	}
   	    });
    	    
   	    layoutContainer_17.add(layoutContainer_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
   	    layoutContainer_17.add(btnUsrSearch3);
   	    lycSreach3.add(layoutContainer_17);		     	     
   	    msfGridPanelSysm0100Off.setTopComponent(lycSreach3);
  
          
          
          
		// 미선택된 사용자 툴바
		ToolBar bottomToolbar2 = new ToolBar();
		bottomToolbar2.add(new FillToolItem());
		// ================전체선택버튼=========================
		btnAllSelSysm0100Off = new Button("전체선택");
    	btnAllSelSysm0100Off.addSelectionListener(new SelectionListener<ButtonEvent>() {
    		public void componentSelected(ButtonEvent ce) {
    			
    			int  lsCnt = msfGridPanelSysm0100Off.getMsfGrid().getGrid().getStore().getCount();
    			for(int iCnt=0;iCnt < lsCnt;iCnt++) {
              		  
    				msfGridPanelSysm0100Off.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.TRUE);
              		msfGridPanelSysm0100Off.getMsfGrid().getGrid().getStore().commitChanges();
              	  } 
    			msfGridPanelSysm0100Off.getMsfGrid().getGrid().getView().refresh(true);
    		}  
    	});

		bottomToolbar2.add(btnAllSelSysm0100Off);
		bottomToolbar2.add(new SeparatorMenuItem());


		btnAllUnSelSysm0100Off = new Button("전체해제");
		btnAllUnSelSysm0100Off.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {  

				int  lsCnt = msfGridPanelSysm0100Off.getMsfGrid().getGrid().getStore().getCount();
              	  
				for(int iCnt=0;iCnt < lsCnt;iCnt++) {
					msfGridPanelSysm0100Off.getMsfGrid().getGrid().getStore().getAt(iCnt).set("select", Boolean.FALSE);
              		msfGridPanelSysm0100Off.getMsfGrid().getGrid().getStore().commitChanges();
              	  } 
              	
				msfGridPanelSysm0100Off.getMsfGrid().getGrid().getView().refresh(true);
              }  
          });

		bottomToolbar2.add(btnAllUnSelSysm0100Off);
		bottomToolbar2.add(new SeparatorMenuItem());

		btnAddSysm0100Off = new Button("사용");
		btnAddSysm0100Off.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) { 
				
				lsInfcPkgSysm0100Dto = new ArrayList<InfcPkgSysm0100DTO>(); 
				
				Iterator<BaseModel> itBm  = msfGridPanelSysm0100Off.getMsfGrid().getGrid().getStore().getModels().listIterator(); 
            	  
            	  
				List<Record> lsRec = new ArrayList<Record>();
				while (itBm.hasNext()) {
					Record rec = new Record(itBm.next());
					lsRec.add(rec);
				}
				
				Iterator<Record> iterRecords = lsRec.iterator();
    			          
				while (iterRecords.hasNext()) {
					
					Record recData = (Record) iterRecords.next();
					BaseModel bmMapModel = (BaseModel) recData.getModel();

					// select에 null값이 들어가있으므로 널포인트에러뜸.
					// 그래서 null인것은 false로 강제변환시킴.
					if ((Boolean) bmMapModel.get("select") == null) {
						bmMapModel.set("select", false);
					}	    		              
	    		                
					if ((Boolean)bmMapModel.get("select")) { 
						
						infcPkgSysm0100Dto = new InfcPkgSysm0100DTO();
		    		            	  
						infcPkgSysm0100Dto.setSysDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("sysDivCd")));    			/** column 시스템구분코드 : sysDivCd */
						infcPkgSysm0100Dto.setUsrId(MSFSharedUtils.allowNulls(bmMapModel.get("usrId")));    				/** column 사용자아이디 : usrId */
						infcPkgSysm0100Dto.setUsrNm(MSFSharedUtils.allowNulls(bmMapModel.get("usrNm")));    				/** column 사용자성명 : usrNm */
						infcPkgSysm0100Dto.setUsrDivCd(MSFSharedUtils.defaultNulls(bmMapModel.get("usrDivCd"), "D0010910"));/** column 사용자권한구분코드 : usrDivCd */
						infcPkgSysm0100Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    		/** column SYSTEMKEY : systemkey */
						infcPkgSysm0100Dto.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd$deptCd")));    		/** column 부서코드 : deptCd */
						infcPkgSysm0100Dto.setPayMangeDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("payMangeDeptCd")));	/** column 단위기관코드 : payMangeDeptCd */  							
						infcPkgSysm0100Dto.setYrtxInptPrcsYn("Y");    														/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
						
						lsInfcPkgSysm0100Dto.add(infcPkgSysm0100Dto);
						
						
//						infcPkgSysm0100Dto.setUsrTel(MSFSharedUtils.allowNulls(egovMap.get("usrTel")));    /** column 전화번호 : usrTel */
//						infcPkgSysm0100Dto.setEmail(MSFSharedUtils.allowNulls(egovMap.get("email")));    /** column 이메일 : email */
//						infcPkgSysm0100Dto.setPwd(MSFSharedUtils.allowNulls(egovMap.get("pwd")));    /** column 패스워드 : pwd */
//						infcPkgSysm0100Dto.setUseYn(MSFSharedUtils.allowNulls(egovMap.get("useYn")));    /** column 사용자사용여부 : useYn */
//						infcPkgSysm0100Dto.setKybdr(MSFSharedUtils.allowNulls(egovMap.get("kybdr")));    /** column 입력자 : kybdr */
//						infcPkgSysm0100Dto.setInptDt(MSFSharedUtils.allowNulls(egovMap.get("inptDt")));    /** column 입력일자 : inptDt */
//						infcPkgSysm0100Dto.setInptAddr(MSFSharedUtils.allowNulls(egovMap.get("inptAddr")));    /** column 입력주소 : inptAddr */
//						infcPkgSysm0100Dto.setIsmt(MSFSharedUtils.allowNulls(egovMap.get("ismt")));    /** column 수정자 : ismt */
//						infcPkgSysm0100Dto.setRevnDt(MSFSharedUtils.allowNulls(egovMap.get("revnDt")));    /** column 수정일자 : revnDt */
//						infcPkgSysm0100Dto.setRevnAddr(MSFSharedUtils.allowNulls(egovMap.get("revnAddr")));    /** column 수정주소 : revnAddr */
//						infcPkgSysm0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(egovMap.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
//						infcPkgSysm0100Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(egovMap.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//						infcPkgSysm0100Dto.setUsrAuthEepnYn(MSFSharedUtils.allowNulls(egovMap.get("usrAuthEepnYn")));    /** column 사용자권한제외여부 : usrAuthEepnYn */
//						infcPkgSysm0100Dto.setPyspInsnYn(MSFSharedUtils.allowNulls(egovMap.get("pyspInsnYn")));    /** column 호봉제포함여부 : pyspInsnYn */
//						infcPkgSysm0100Dto.setNotPyspInsnYn(MSFSharedUtils.allowNulls(egovMap.get("notPyspInsnYn")));    /** column 비호봉제포함여부 : notPyspInsnYn */
//						infcPkgSysm0100Dto.setServcInptPrcsYn(MSFSharedUtils.allowNulls(egovMap.get("servcInptPrcsYn")));    /** column 복무입력처리여부 : servcInptPrcsYn */
//
//						infcPkgSysm0100Dto.setShttmInsnYn(MSFSharedUtils.allowNulls(egovMap.get("shttmInsnYn")));    /** column 기간제포함여부 : shttmInsnYn */
//						infcPkgSysm0100Dto.setUsrAuthDivCd(MSFSharedUtils.allowNulls(egovMap.get("usrAuthDivCd")));    /** column 사용자권한구분코드 : usrAuthDivCd */
//						infcPkgSysm0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(egovMap.get("dtilOccuInttnCd")));    /** column 직종세코드 : dtilOccuInttnCd */
//						infcPkgSysm0100Dto.setAuthInStdt(MSFSharedUtils.allowNulls(egovMap.get("authInStdt")));    /** column 권한적용시작일자 : authInStdt */
//						infcPkgSysm0100Dto.setAuthInEddt(MSFSharedUtils.allowNulls(egovMap.get("authInEddt")));    /** column 권한적용종료일자 : authInEddt */
//						infcPkgSysm0100Dto.setUsrLgnAccLckYn(MSFSharedUtils.allowNulls(egovMap.get("usrLgnAccLckYn")));    /** column 사용자계정잠김여부 : usrLgnAccLckYn */
//						infcPkgSysm0100Dto.setUntDpobCd(MSFSharedUtils.allowNulls(egovMap.get("untDpobCd")));    /** column 단위사업장코드 : untDpobCd */
							            	  

					}
				} 
				
				
				if(lsInfcPkgSysm0100Dto.size() < 1) {
					MessageBox.alert("알림", "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}else {
					updateSysm0100Yn(lsInfcPkgSysm0100Dto);
				}
				
			}						
		});

		bottomToolbar2.add(btnAddSysm0100Off);
		bottomToolbar2.add(new SeparatorMenuItem());

		Button refresh2 = new Button();
		refresh2.setIcon(MSFMainApp.ICONS.actionRefresh());
		refresh2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				offUserReload();
			}
		});
		bottomToolbar2.add(refresh2);

		// 툴바 넣어주는것
		msfGridPanelSysm0100On.setBottomComponent(bottomToolbar);
		msfGridPanelSysm0100Off.setBottomComponent(bottomToolbar2);

		// 중간사이 틈을 주기위한 컨테이너
		LayoutContainer space = new LayoutContainer();
		space.setHeight(10);
		space.setWidth(500);
		space.setId("space");
		space.setStyleAttribute("paddingLeft", "10px");

		LayoutContainer layoutContainer_16 = new LayoutContainer();
		frmlytStd2 = new FormLayout();
		frmlytStd2.setLabelWidth(100);
		frmlytStd2.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytStd2);
		layoutContainer_16.add(msfGridPanelSysm0100On);
		layoutContainer_16.add(space);
		layoutContainer_16.add(msfGridPanelSysm0100Off);
   	    
		inner.add(layoutContainer_16);

		plFrmYeta5080.add(inner);

		vp.add(plFrmYeta5080);
		plFrmYeta5080.setSize("990px", "680px");
	}

	private Yeta5080 getThis() {
		return this;
	}
	
    /** 부서 조회 **/
    public void reDeptload() {
    	
    	IColumnFilter filters = null;
    	
    	msfGridPanelYeta5080.getTableDef().setTableColumnFilters(filters);   
    	msfGridPanelYeta5080.getTableDef().addColumnFilter("deptNmHan", MSFSharedUtils.defaultNulls(deptNmHan.getValue(),""), SimpleColumnFilter.OPERATOR_LIKE); 
    	msfGridPanelYeta5080.reload();
    	
    }	
    
    /** 선택된 사용자 조회 **/
	public void onUserReload() {
		
		IColumnFilter filters = null;
		
	   	msfGridPanelSysm0100On.getTableDef().setTableColumnFilters(filters); 	    
	   	msfGridPanelSysm0100On.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(deptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
	   	msfGridPanelSysm0100On.getTableDef().addColumnFilter("yrtxInptPrcsYn", "Y", SimpleColumnFilter.OPERATOR_EQUALS); 
	   	msfGridPanelSysm0100On.getTableDef().addColumnFilter("usrNm", MSFSharedUtils.allowNulls(onUsrNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
	   	msfGridPanelSysm0100On.reload();
	   	
	}
	
	/** 미선택된 사용자 조회 **/
	public void offUserReload() {

		IColumnFilter filters = null;
		
		msfGridPanelSysm0100Off.getTableDef().setTableColumnFilters(filters);  
		msfGridPanelSysm0100Off.getTableDef().addColumnFilter("deptCd",  MSFSharedUtils.allowNulls(deptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		msfGridPanelSysm0100Off.getTableDef().addColumnFilter("yrtxInptPrcsYn", "N", SimpleColumnFilter.OPERATOR_EQUALS); 
		msfGridPanelSysm0100Off.getTableDef().addColumnFilter("usrNm", MSFSharedUtils.allowNulls(offUsrNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		msfGridPanelSysm0100Off.reload();
		   
	}
    
	
	public void updateSysm0100Yn(List<InfcPkgSysm0100DTO> infcPkgSysm0100Liar) {
		
		// 서비스 호출
		infcPkgSysm0100Service.updateInfcPkgSysm0100Yn(infcPkgSysm0100Liar , new AsyncCallback<Integer>() {

			public void onFailure(Throwable caught) {
				MessageBox.alert( MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
									, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta4300ToYe161030("+ " 오류 : " + ") : " + caught)
									, null);
				}

				public void onSuccess(Integer result) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "총 " + result + "건의 처리가 완료되었습니다.", null);
					onUserReload();
					offUserReload();
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
