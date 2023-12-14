/**
 * 인사정보 검색 팝업 화면 구현 
 */

package com.app.exterms.statistics.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100BM;
import com.app.exterms.prgm.client.form.defs.PrgmComPsnl0100Def;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SttsP02002  extends Lov implements PrgmComDaoConstants { 

	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
	 
	//권한 설정 객체 
	private static GWTAuthorization gwtAuthorization;
	private static GWTExtAuth gwtExtAuth;
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

	private SysComConstants SysComLabel = SysComConstants.INSTANCE; 
	   
	private static ListStore<BaseModel> lsEmymtDivCd = new ListStore<BaseModel>();		// 고용구분 
	private static ListStore<BaseModel> lsHdofcCodtnCd = new ListStore<BaseModel>(); 	// 재직상태 
      
	
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private static ListStore<BaseModel> lsDeptCd = new ListStore<BaseModel>();			// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
        
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private static ListStore<BaseModel> lsBusinCd = new ListStore<BaseModel>();			// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------

     
	private static PrgmComBass0300DTO sysComBass0300Dto; // 공통코드
	private static PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private static PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	
	private static HiddenField<String> systemkey; 		// 시스템키
      
	private static ComboBox<BaseModel> emymtDivCd; 		// 고용구분
	private static ComboBox<BaseModel> deptCd; 			// 부서
	private static ComboBox<BaseModel> businCd; 		// 사업
	private static TextField<String> hanNm; 			// 성명
	private static TextField<String> resnRegnNum; 		// 주민번호

	private static ComboBox<BaseModel> hdofcCodtnCd; 	// 재직상태
	public  static Button btnUsrSearch;					// 검색버튼
      

	public static ComboBox<BaseModel> getEmymtDivCd() {
		return emymtDivCd;
	}

	public static void setEmymtDivCd(ComboBox<BaseModel> emymtDivCd) {
		SttsP02002.emymtDivCd = emymtDivCd;
	}

	public static ComboBox<BaseModel> getDeptCd() {
		return deptCd;
	}

	public static void setDeptCd(ComboBox<BaseModel> deptCd) {
		SttsP02002.deptCd = deptCd;
	}

	public static ComboBox<BaseModel> getBusinCd() {
		return businCd;
	}

	public static void setBusinCd(ComboBox<BaseModel> businCd) {
		SttsP02002.businCd = businCd;
	}

	public static TextField<String> getHanNm() {
		return hanNm;
	}

	public static void setHanNm(TextField<String> hanNm) {
		SttsP02002.hanNm = hanNm;
	}

	public static TextField<String> getResnRegnNum() {
		return resnRegnNum;
	}

	public static void setResnRegnNum(TextField<String> resnRegnNum) {
		SttsP02002.resnRegnNum = resnRegnNum;
	}

	public static HiddenField<String> getSystemkey() {
		return systemkey;
	}

	public static void setSystemkey(HiddenField<String> systemkey) {
		SttsP02002.systemkey = systemkey;
	}

	public static ComboBox<BaseModel> getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	public static void setHdofcCodtnCd(ComboBox<BaseModel> hdofcCodtnCd) {
		SttsP02002.hdofcCodtnCd = hdofcCodtnCd;
	}

	public SttsP02002(int width, int height) {
		this();
		this.width = width;
		this.height = height;
	}

	public SttsP02002() {
	    	 
		// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		lovDef = new LovDef();
		lovDef.setTitle("기간제 근로자 검색 "); // 팝업상단의 타이틀
		lovDef.setDaoClass("");
		lovDef.setAutoFillGrid(false);
		lovDef.setCheckBoxOnGridRows(true);
		lovDef.showFilterForm();
		lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_PSNL0100_List);
	        
	       
		// ------------------------------ 그리드 구현 ------------------------------
	       
		List<ColumnLovDef> listColumnLovDefs = new ArrayList<ColumnLovDef>();


		/** column 사업장코드 : dpobCd */
		listColumnLovDefs.add(new ColumnLovDef("사업장코드", PrgmComPsnl0100BM.ATTR_DPOBCD  , PrgmComPsnl0100BM.ATTR_DPOBCD , ColumnDef.TYPE_STRING , 90){
			{
				 setIsVisibleInGrid(false);
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnLovDefs.add(new ColumnLovDef("SYSTEMKEY", PrgmComPsnl0100BM.ATTR_SYSTEMKEY , PrgmComPsnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90){
			{
				 setIsVisibleInGrid(false);
			}
		});
		/** column 한글성명 : hanNm */
		listColumnLovDefs.add(new ColumnLovDef("성명", PrgmComPsnl0100BM.ATTR_HANNM , PrgmComPsnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90){
			{

			}
		});

		/** column 주민등록번호 : resnRegnNum */
		listColumnLovDefs.add(new ColumnLovDef("주민등록번호", PrgmComPsnl0100BM.ATTR_RESNREGNNUM , PrgmComPsnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90){
			{

			}
		});

		/** column 현소속부서코드 : currAffnDeptCd */
		listColumnLovDefs.add(new ColumnLovDef("현소속부서코드", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD , PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTCD, ColumnDef.TYPE_STRING , 90){
			{
				 setIsVisibleInGrid(false);
			}
		});

		/** column 현소속부서코드 : currAffnDeptCd */
		listColumnLovDefs.add(new ColumnLovDef("부서", PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM , PrgmComPsnl0100BM.ATTR_CURRAFFNDEPTNM, ColumnDef.TYPE_STRING , 90){
			{

			}
		});

		/** column 재직상태코드 : hdofcCodtnCd */
		listColumnLovDefs.add(new ColumnLovDef("재직상태코드", PrgmComPsnl0100BM.ATTR_HDOFCCODTNCD, PrgmComPsnl0100BM.ATTR_HDOFCCODTNCD, ColumnDef.TYPE_STRING , 90){
			{
				 setIsVisibleInGrid(false);
			}
		});

		/** column 재직상태코드 : hdofcCodtnCd */
		listColumnLovDefs.add(new ColumnLovDef("재직", PrgmComPsnl0100BM.ATTR_HDOFCCODTNNM, PrgmComPsnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 60){
			{

			}
		});

		/** column 최초고용일자 : frstEmymtDt */
		listColumnLovDefs.add(new ColumnLovDef("최초고용일자", PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT, PrgmComPsnl0100BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_DATE , 90){
			{

			}
		});


		/** column 고용시작일자 : emymtBgnnDt */
		listColumnLovDefs.add(new ColumnLovDef("고용시작일자", PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT, PrgmComPsnl0100BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_DATE , 90){
			{

			}
		});
		/** column 고용종료일자 : emymtEndDt */
		listColumnLovDefs.add(new ColumnLovDef("고용종료일자", PrgmComPsnl0100BM.ATTR_EMYMTENDDT, PrgmComPsnl0100BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_DATE , 90){
			{

			}
		});
	        
		lovDef.setListColumns(listColumnLovDefs);

		lovDef.addHiddenColumn(new PrgmComPsnl0100Def().getColumnsDefinition());
		// ------------------------------ 그리드 구현 ------------------------------
		
		lovDef.setCustomLayoutContainer(getMsfComP0100Filter());
		
		

	}


	public static final LayoutContainer getMsfComP0100Filter() {
            
		final Date today = new Date();
		// A custom date format
		final DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy");

		systemkey = new HiddenField<String>();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
          
          
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        //고용구분
		sysComBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
           
           
		//--------------------부서 불러 오는 함수 ------------------------------------------------
		lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
		//--------------------부서 불러 오는 함수 ------------------------------------------------
              
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//재직상태  
		sysComBass0300Dto.setRpsttvCd("A003");
		lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
            

		final FormPanel fp03 = new FormPanel();
		fp03.setBodyBorder(false);
		fp03.setHeaderVisible(false);
		fp03.setLayout(new FlowLayout(1));
		fp03.setSize(630, 95);
              
		LayoutContainer frmSearchLayer = new LayoutContainer();
		FormLayout layout = new FormLayout();
		layout.setDefaultWidth(630);
		layout.setLabelWidth(70);
		frmSearchLayer.setLayout(layout); 
                
		/** 여기화면 추가 */
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("");
                
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_4 = new LayoutContainer();

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		layoutContainer_6.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		FormLayout frmLyout = new FormLayout();
		frmLyout.setLabelWidth(70);
		frmLyout.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmLyout);
                
		hanNm = new TextField<String>();
		hanNm.setName("hanNm");
		hanNm.setFieldLabel("성 명");
		layoutContainer_7.add(hanNm, new FormData("100%"));
		hanNm.setAllowBlank(false);
		layoutContainer_6.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));
		layoutContainer_7.setBorders(false);
                
		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmLyout = new FormLayout();
		frmLyout.setLabelWidth(10);
		frmLyout.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmLyout);
                
		resnRegnNum = new TextField<String>();
		resnRegnNum.setName("resnRegnNum");
		layoutContainer_8.add(resnRegnNum, new FormData("100%"));
		resnRegnNum.setFieldLabel("");
		resnRegnNum.setLabelSeparator("");
		layoutContainer_6.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_8.setBorders(false);
		layoutContainer_4.add(layoutContainer_6);
		layoutContainer_6.setBorders(false);
		layoutContainer_3.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		layoutContainer_4.setBorders(false);
                
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		frmLyout = new FormLayout();
		frmLyout.setLabelWidth(80);
		frmLyout.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmLyout);
                
		emymtDivCd = new ComboBox<BaseModel>();
		emymtDivCd.setName("emymtDivCd");
		emymtDivCd.setForceSelection(true);
		emymtDivCd.setMinChars(1);
		emymtDivCd.setDisplayField("commCdNm");
		emymtDivCd.setValueField("commCd");
		emymtDivCd.setTriggerAction(TriggerAction.ALL);
		emymtDivCd.setEmptyText("--고용구분선택--");
		emymtDivCd.setSelectOnFocus(true);
		emymtDivCd.setReadOnly(true);
//                emymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//                emymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		emymtDivCd.setStore(lsEmymtDivCd);
		emymtDivCd.setFieldLabel("고용구분");
		emymtDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				emymtDivCd.setValue(lsEmymtDivCd.findModel("commCd",MSFConfiguration.EMYMT_DIVCD02));
			}
		});
		emymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					businCd.setEnabled(true);
				} else {
					businCd.setEnabled(false);
				}
			}
		});
		layoutContainer_5.add(emymtDivCd, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
		layoutContainer_5.setBorders(false);
                
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmLyout = new FormLayout();
		frmLyout.setLabelWidth(80);
		frmLyout.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmLyout); 
                
                
		hdofcCodtnCd = new ComboBox<BaseModel>();
		hdofcCodtnCd.setName("hdofcCodtnCd");
		hdofcCodtnCd.setForceSelection(true);
		hdofcCodtnCd.setMinChars(1);
		hdofcCodtnCd.setDisplayField("commCdNm");
		hdofcCodtnCd.setValueField("commCd");
		hdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
		hdofcCodtnCd.setEmptyText("--재직선택--");
		hdofcCodtnCd.setSelectOnFocus(true);
		hdofcCodtnCd.setReadOnly(false);
		hdofcCodtnCd.setEnabled(true);
		hdofcCodtnCd.setStore(lsHdofcCodtnCd);
		hdofcCodtnCd.setFieldLabel("재직상태");
		hdofcCodtnCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				hdofcCodtnCd.setValue(lsHdofcCodtnCd.getAt(0));
			}
		});
		layoutContainer_9.add(hdofcCodtnCd, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_9.setBorders(false);

//		LayoutContainer layoutContainer_13 = new LayoutContainer();
//		FormLayout frmlytStd = new FormLayout();
//		frmlytStd.setLabelWidth(60);
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		layoutContainer_13.setLayout(frmlytStd);
//		layoutContainer_13.setBorders(false);
//		layoutContainer_3.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
                   
                
		fieldSet.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		LayoutContainer lcSchLeft = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);
                 
		deptCd = new ComboBox<BaseModel>();
		deptCd.setName("deptCd");
		deptCd.setForceSelection(true);
		deptCd.setMinChars(1);
		deptCd.setDisplayField("deptNmRtchnt");
		deptCd.setValueField("deptCd");
		deptCd.setTriggerAction(TriggerAction.ALL);
		deptCd.setEmptyText("--부서선택--");
		deptCd.setSelectOnFocus(true);
		deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		deptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		deptCd.setStore(lsDeptCd);
		deptCd.setFieldLabel("부서");
		deptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서 : 단위기관 ,고용구분, 부서,
				 * 직종, 사업 순으로 없으면 ""
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 */
				// gwtAuthorization.formAuthConfig(fp03,
				// "","emymtDivCd","deptCd","typOccuCd","businCd");
				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * ++++++++++++ 권한설정을 위한 콤보처리를 위한 메서드 종료
				 * ++++++++++++++++++++++++
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++
				 */

			}
		});
		deptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmDeptCd = se.getSelectedItem();
				if (bmDeptCd != null&& MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd.getValue().get("commCd"))) {
					if (bmDeptCd != null) {
						sysComBass0500Dto.setDeptCd((String) bmDeptCd.get("deptCd"));
						sysComBass0500Dto.setBusinApptnYr(fmt.format(today).toString());
					}
					// --------------------사업 불러 오는 함수
					// -------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					// --------------------사업 불러 오는 함수
					// -------------------------------------------------
					businCd.setStore(lsBusinCd);
					businCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
						public void handleEvent(StoreEvent<BaseModel> be) {
							businCd.setValue(lsBusinCd.getAt(0));
						}
					});
				}
			}
		});
		lcSchLeft.add(deptCd, new FormData("100%"));

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		layoutContainer.setBorders(false);
		
		LayoutContainer lcSchRight = new LayoutContainer();
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(70);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);
                
		businCd = new ComboBox<BaseModel>();
		businCd.setName("businCd");
		businCd.setForceSelection(true);
		businCd.setMinChars(1);
		businCd.setDisplayField("businNm");
		businCd.setValueField("businCd");
		businCd.setTriggerAction(TriggerAction.ALL);
		businCd.setEmptyText("--사업선택--");
		businCd.setSelectOnFocus(true);
		businCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		businCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		businCd.setStore(lsBusinCd);
		businCd.setFieldLabel("사업");
		lcSchRight.add(businCd, new FormData("95%"));
		
		lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer.add(lcSchCol, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.83));

		LayoutContainer layoutContainer_51 = new LayoutContainer();
		frmlytSch = new FormLayout();
//		frmlytSch.setLabelWidth(10);
		frmlytSch.setLabelAlign(LabelAlign.LEFT);
		layoutContainer_51.setLayout(frmlytSch);
               
		btnUsrSearch = new Button("검색");
		btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
		layoutContainer.add(btnUsrSearch);
		layoutContainer_51.setBorders(false);

		fieldSet.add(layoutContainer, new FormData("100%"));

		fp03.add(fieldSet);

		frmSearchLayer.add(fp03);

		return frmSearchLayer;
	}
}
