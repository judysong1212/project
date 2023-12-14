/**
 * 의료비내역등록
 */
package com.app.exterms.yearendtax.client.form.yeta2019;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0320;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye164010BM;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye164010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2019.Ye164010Def;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaP43002Service;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaP43002ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP43002 extends MSFFormPanel {  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/
  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
 
	private  ContentPanel cpYeta23002; 
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
		 
	//권한 설정 객체 
	private static  GWTAuthorization gwtAuthorization;
	private static  GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

	  
	// -------------- grid 선언 시작  ---------------	  
	private MSFGridPanel YetaP43002GridPanel;
	private Ye164010Def YetaP43002ToYe164010Def  = new Ye164010Def("YetaP43002");//의료비내역 그리드 테이블 컬럼 define 
	// -------------- grid 선언 종료  ---------------	

	//직종콤보
	private  LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
	private  MSFGridPanel typOccuCdGridPanel;

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	    
	
	    
		
    
   /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 상태처리 전역변수
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  private ActionDatabase actionDatabase;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 화면 렌더링 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
  private MSFPanel caller;
  private Boolean  reading = false;
  public  FormBinding formBinding;
  
  private Iterator<Record> records;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
  	private ButtonBar topYetaBtnBar = new ButtonBar();
	private Button btnYetaNew = new Button();			//신규
	private Button btnYetaDel = new Button();			//삭제
	private Button btnYetaSave = new Button();			//저장

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String> srhYrtxBlggYr;	// 년도
 	private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산년도 : yrtxBlggYr */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : clutSeptCd */
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	hanNm;		/**  column 성명 : hanNm */
 	// -------------- 검색 조건 종료 --------------
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr410001FormBinding() {
	 	 
	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	   
	    }        
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/ 
	// -------------- stroe 선언 시작 --------------
	private  ListStore<BaseModel> lsdacRvyyStore = new ListStore<BaseModel>(); 	// 년도
	private  ListStore<BaseModel> lsclutSeptCd = new ListStore<BaseModel>(); 		// 정산구분
	// -------------- stroe 선언 종료 --------------
	 	
	// -------------- 서비스 호출 시작 --------------
	private YetaP43002ServiceAsync yetaP43002Service = YetaP43002Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------	 	
	    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
 
	     
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
	// 버튼에 따른 Action
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			YetaP43002FormSave();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			YetaP43002FormSave();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			YetaP43002FormSave();
			break;
		}
	}
		
		
	private void YetaP43002FormSave() {

		if (MSFSharedUtils.paramNotNull(records)) {

			Boolean dataChk = true;

			List<Ye164010DTO> listYe164010Dto = new ArrayList<Ye164010DTO>();
			
			Ye164010DTO ye164010Dto = new Ye164010DTO();

			while (records.hasNext()) {

				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();

				ye164010Dto = new Ye164010DTO();
				
				ye164010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
				ye164010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    						/** column 귀속연도 : yrtxBlggYr */
				ye164010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    						/** column 연말정산구분코드 : clutSeptCd */
				ye164010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    						/** column SYSTEMKEY : systemkey */
				ye164010Dto.setMdxpsSeilNum((Long)bmMapModel.get("mdxpsSeilNum"));    										/** column 의료비지급일련번호 : mdxpsSeilNum */
				ye164010Dto.setMdxpsVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("mdxpsVvalKrnCd")));    				/** column 의료비국세자료구분코드 : mdxpsVvalKrnCd */
				
				
				ye164010Dto.setResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("resnoEncCntn")).replaceAll("-", "")); /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
				ye164010Dto.setYn( MSFSharedUtils.defaultNulls(bmMapModel.get("yn"), "1") );    							/** column 본인등해당여부 : yn */
				ye164010Dto.setBsnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("bsnoEncCntn")).replaceAll("-", ""));   /** column 지급처사업자등록번호 : bsnoEncCntn */
				ye164010Dto.setPlymNm(MSFSharedUtils.allowNulls(bmMapModel.get("plymNm")));    								/** column 의료비_상호명 : plymNm */
				ye164010Dto.setMdxpsPrfClCd(MSFSharedUtils.allowNulls(bmMapModel.get("mdxpsPrfClCd$commCd")));    			/** column 의료비_의료증빙코드 : mdxpsPrfClCd */
				ye164010Dto.setScnt( MSFSharedUtils.defaultNulls((Long)bmMapModel.get("scnt"), "0") );   					/** column 의료비_건수 : scnt */
				ye164010Dto.setUseAmt( MSFSharedUtils.defaultNulls((Long)bmMapModel.get("useAmt"), "0") );    				/** column 의료비_금액 : useAmt */
				ye164010Dto.setYn2( MSFSharedUtils.defaultNulls(bmMapModel.get("yn2"), "0") );    							/** column 의료비_난임시술비해당여부 : yn2 */	
				ye164010Dto.setYn3( MSFSharedUtils.defaultNulls(bmMapModel.get("yn3"), "0") );    							/** column 의료비_산후조리원비용여부 : yn3 */
				ye164010Dto.setYn4( MSFSharedUtils.defaultNulls(bmMapModel.get("yn4"), "0") );    							/** column 의료비_실손보험금보전금액여부 : yn4 */
				
	                
	                
				/** 그리드에 있는 항목에 대해서 입력 체크 **/
				if (MSFSharedUtils.paramNull(ye164010Dto.getResnoEncCntn().replace("-", ""))) {
					MessageBox.alert("경고", "주민번호를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if ("Y0140000".equals(ye164010Dto.getMdxpsVvalKrnCd())) {
					MessageBox.alert("경고", "국세청 자료는 수정이 불가능 합니다.", null);
					dataChk = false;
					return;
				} else if ( (!"1".equals(ye164010Dto.getYn()) || ye164010Dto.getYn() != "1" ) && (!"2".equals(ye164010Dto.getYn()) || ye164010Dto.getYn() != "2") ) {
					MessageBox.alert("경고", "본인 여부는 1 또는 2만 입력 가능합니다.", null);
					dataChk = false;
					return;
				} else if ( (!"1".equals(ye164010Dto.getYn2()) || ye164010Dto.getYn2() != "1" ) && (!"0".equals(ye164010Dto.getYn2()) || ye164010Dto.getYn2() != "0") ) {
					MessageBox.alert("경고", "난임 여부는 1 또는 0만 입력 가능합니다.", null);
					dataChk = false;
					return;
				
				} else if ( (!"1".equals(ye164010Dto.getYn3()) || ye164010Dto.getYn3() != "1" ) && (!"0".equals(ye164010Dto.getYn3()) || ye164010Dto.getYn3() != "0") ) {
					MessageBox.alert("경고", "산후조리원 여부는 1 또는 0만 입력 가능합니다.", null);
					dataChk = false;
					return;
				
				} else if ( (!"1".equals(ye164010Dto.getYn4()) || ye164010Dto.getYn4() != "1" ) && (!"0".equals(ye164010Dto.getYn4()) || ye164010Dto.getYn4() != "0") ) {
					MessageBox.alert("경고", "실손보험금 보전여부는 1 또는 0만 입력 가능합니다.", null);
					dataChk = false;
					return;
				
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getBsnoEncCntn().replace("-", ""))) {
					MessageBox.alert("경고", "사업자번호를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getPlymNm())) {
					MessageBox.alert("경고", "상호명을 입력해주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getMdxpsPrfClCd())) {
					MessageBox.alert("경고", "의료증빙구분을 입력해주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getScnt())) {
					MessageBox.alert("경고", "지급건수를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye164010Dto.getUseAmt())) {
					MessageBox.alert("경고", "지급금액을 입력해 주세요.", null);
					dataChk = false;
					return;
				}

				listYe164010Dto.add(ye164010Dto);
			}
				
				
			if (dataChk) {

				if (listYe164010Dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "저장",actionDatabase.name()+ "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
					
				yetaP43002Service.activityOnYetaP43002ToYe164010(listYe164010Dto, actionDatabase, new AsyncCallback<Long>(){
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
								, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP43002ToYe164010(" + actionDatabase.name() + ") : " + caught), null);
						}
					
						public void onSuccess(Long result) { 
							if (result == 0) {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
							} else {
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
								reload();
								actionDatabase = ActionDatabase.UPDATE;
								}
							}

						});

			} else {
					MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
				return;
			}

		}

	}	 	
 
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	Rpc Service 선언부 종료
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**

	/**
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/ 
 
	/**
	 *############################################################################# 
	 * 프로그램 종료  	  
	 *############################################################################# 
	 **/	  

	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/ 		    
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++ 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++
		 * ++++++++++++++++++++++++++++++++++++++++
		 **/
		/**
		 * 권한설정 처리 체크 AuthAction
		 */

		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/	 
	  
	public YetaP43002(final ActionDatabase actionDatabase, final MSFPanel caller) {

		// 콤보 권한초기화
		// initLoad();

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.caller = caller;

		cpYeta23002 = new ContentPanel();

		createSearchForm(); // 기본정보 필드를 적용
		createStandardForm(); // 기본정보필드
		createMsfGridForm(); // 그리드필드

		cpYeta23002.setBodyBorder(false);
		cpYeta23002.setBorders(false);
		cpYeta23002.setHeaderVisible(false);
		cpYeta23002.setSize("790px", "640px");

		this.add(cpYeta23002);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "710px");
	}
	    
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 생성자 함수 선언부 종료
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/		 
	    
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 폼 생성시 기본 처리 함수 선언부 시작
	   * 1. 폼 생성 선언
	   * 2. 공통 버튼 처리 선언
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/	
	  
		/**
		 * 기본정보 설정
		 */
	private void createSearchForm() {

		actionDatabase = ActionDatabase.UPDATE;
				
		    systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
			systemkey.setName("systemkey");
			cpYeta23002.add(systemkey);
			
		    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		    dpobCd.setName("dpobCd");
		    cpYeta23002.add(dpobCd);
		    
		    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
		    yrtxBlggYr.setName("yrtxBlggYr");
		    cpYeta23002.add(yrtxBlggYr);
		    
		    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
		    clutSeptCd.setName("clutSeptCd");
		    cpYeta23002.add(clutSeptCd);
		    
		    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		    deptNm.setName("deptNm");
		    cpYeta23002.add(deptNm);
		    
		    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		    hanNm.setName("hanNm");
		    cpYeta23002.add(hanNm);
				
			sysComBass0300Dto = new PrgmComBass0300DTO();
			msfCoCalendarDto = new SysCoCalendarDTO();
			     
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			sysComBass0300Dto.setRpsttvCd("Y002");
			lsclutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			     
			     
			//--------------------급여년도 불러 오는 함수 ------------------------------------------------
			lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
			//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
			     
			        

		cpYeta23002.setLayout(new FlowLayout());

		topYetaBtnBar = new ButtonBar();
		topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

		btnYetaNew = new Button("신규");
		btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
		btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				actionDatabase = ActionDatabase.INSERT;

				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
					return;
				}

				// TODO Auto-generated method stub
				// 가족사항을 가지고 오는 팝업을 호출한다.
				// 선택한 내용을 저장 후리스트에 보여준다.
				// 저장은 업데이트로 처리한다.
				fnPopupCommP160(); 
			         
				actionDatabase = ActionDatabase.INSERT;
			}
		});
				
		topYetaBtnBar.add(btnYetaNew);

		btnYetaDel = new Button("삭제");
		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				MessageBox.confirm("삭제", "선택하신 의료비 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							Iterator<BaseModel> itBm = YetaP43002GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
							List<Record> lsRec = new ArrayList<Record>();
								
							while (itBm.hasNext()) {
								Record rec = new Record(itBm.next());
								lsRec.add(rec);
							}
							setListRecord(lsRec.iterator());

							actionDatabase = ActionDatabase.DELETE;
							doAction(actionDatabase);
							
						}
					}
				});
			}
		});
		topYetaBtnBar.add(btnYetaDel);

		btnYetaSave = new Button("저장");
		btnYetaSave.setIcon(MSFMainApp.ICONS.save16());
		btnYetaSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(YetaP43002GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());

				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}

				doAction(actionDatabase);
			}
		});

		topYetaBtnBar.add(btnYetaSave);

		// btnYetaClose = new Button("닫기");
		// topYetaBtnBar.add(btnYetaClose);

		cpYeta23002.add(topYetaBtnBar);

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);

		srhYrtxBlggYr = new TextField<String>();
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setName("yrtxBlggYr");
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
		// srhYrtxBlggYr.setStore(lsdacRvyyStore);
		srhYrtxBlggYr.setFieldLabel("년도");

		lcSchCol01.add(srhYrtxBlggYr, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhClutSeptCd = new ComboBox<BaseModel>();
		srhClutSeptCd.setReadOnly(true);
		srhClutSeptCd.setName("srhClutSeptCd");
		srhClutSeptCd.setForceSelection(true);
		srhClutSeptCd.setMinChars(1);
		srhClutSeptCd.setDisplayField("commCdNm");
		srhClutSeptCd.setValueField("commCd");
		srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
		srhClutSeptCd.setEmptyText("--정산구분선택--");
		srhClutSeptCd.setSelectOnFocus(true);
		srhClutSeptCd.setReadOnly(true);
		srhClutSeptCd.setEnabled(true);
		srhClutSeptCd.setStore(lsclutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
			srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
				public void handleEvent(StoreEvent<BaseModel> be) {
					YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd");
					reload();
				}
			});
			lcSchCol02.add(srhClutSeptCd, new FormData("100%"));
				
			LayoutContainer lcSchCol03 = new LayoutContainer();

			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(60);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			lcSchCol03.setLayout(frmlytSch);

			srhDeptCd = new TextField<String>();
			srhDeptCd.setReadOnly(true);
			srhDeptCd.setName("srhDeptCd");
			srhDeptCd.setWidth(100);
			srhDeptCd.setFieldLabel("부서");

			lcSchCol03.add(srhDeptCd, new FormData("100%"));
				
				
			LayoutContainer lcSchCol04 = new LayoutContainer();
			
			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(60);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			lcSchCol04.setLayout(frmlytSch);

			srhHanNm = new TextField<String>();
			srhHanNm.setReadOnly(true);
			srhHanNm.setName("srhHanNm");
			srhHanNm.setFieldLabel("성명");

			lcSchCol04.add(srhHanNm, new FormData("100%"));
				
			lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
			lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
			lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
				
		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYeta23002.add(fieldSet);
	}
	 	 
	private void createStandardForm() {
		
		LayoutContainer lcFormLayer = new LayoutContainer();
		  
		ContentPanel cp01 = new ContentPanel();   
		cp01.setBodyBorder(false); 
		cp01.setHeaderVisible(false);   
		cp01.setLayout(new FitLayout()); 
		cp01.setSize("820px", "140px");
		  
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		
	      
		LayoutContainer layoutContainer_4 = new LayoutContainer();
	      
		LabelField lblfldNewLabelfield_2 = new LabelField(" *본인 : 1, 아닐 경우 : 2 ");
		layoutContainer_4.add(lblfldNewLabelfield_2);
		layoutContainer_3.add(layoutContainer_4);
		layoutContainer_4.setBorders(false);
	      
		LayoutContainer layoutContainer_5 = new LayoutContainer();
	      
		LabelField lblfldNewLabelfield_3 = new LabelField(" *해당사항 : 본인 *65세이상 *장애인인경우");
		layoutContainer_5.add(lblfldNewLabelfield_3);
		layoutContainer_3.add(layoutContainer_5);
		layoutContainer_5.setBorders(false);
	      
	    LayoutContainer layoutContainer_6 = new LayoutContainer();
	      
	    LabelField lblfldNewLabelfield_4 = new LabelField(" *미해당사항 : 그 밖의 기본공제대상자");
	    layoutContainer_6.add(lblfldNewLabelfield_4);
	    layoutContainer_3.add(layoutContainer_6);
	    layoutContainer_6.setBorders(false);
	      
	    LayoutContainer layoutContainer_7 = new LayoutContainer();
	      
	    LabelField lblfldNewLabelfield_5 = new LabelField("");
	    layoutContainer_7.add(lblfldNewLabelfield_5);
	    layoutContainer_3.add(layoutContainer_7);
	    layoutContainer_7.setBorders(false);
	      
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	      
	    LabelField lblfldNewLabelfield_6 = new LabelField(" * 의료비 내역 등록 합계는 소득공제에 등록된 의료비와 반드시 같아야 합니다. 입력확인");
	    layoutContainer_8.add(lblfldNewLabelfield_6);
	    layoutContainer_3.add(layoutContainer_8);
	    layoutContainer_8.setBorders(false);
	      
	    LayoutContainer layoutContainer_9 = new LayoutContainer();
	    
	    LabelField lblfldNewLabelfield_7 = new LabelField(" * 의료증빙구분이 국세청장이 제공하는 의료비 자료인 경우, 사업자 번호와 지급건수를 입력하지 않아도 됩니다.");
	    layoutContainer_9.add(lblfldNewLabelfield_7);
	    layoutContainer_3.add(layoutContainer_9);
	    layoutContainer_9.setBorders(false);
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	    
	    LabelField lblfldNewLabelfield_8 = new LabelField(" * 실손보험금 보전금액은 숫자앞에 '-'입력해야 합니다.");
	    layoutContainer_10.add(lblfldNewLabelfield_8);
	    layoutContainer_3.add(layoutContainer_10);
	    layoutContainer_10.setBorders(false);
	      
	    layoutContainer_3.setBorders(false);
	      
	    cp01.add(layoutContainer_3);
	    lcFormLayer.add(cp01);
	    cpYeta23002.add(lcFormLayer);  
	  } 
	  
	  @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            @Override
	            public void handleEvent(BaseEvent be) {
	            	
	            	srhDeptCd.setValue(deptNm.getValue());
					srhHanNm.setValue(hanNm.getValue());
					
	            }
	        });
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
		
		@Override
		public void reload() {
			
//			BaseModel bmData = YetaP43002GridPanel.getMsfGrid().getStore().getModels().get(0);  
//			if (MSFSharedUtils.paramNotNull(bmData)){
				// TODO Auto-generated method stub
				IColumnFilter filters = null;
				
				YetaP43002GridPanel.getTableDef().setTableColumnFilters(filters);
				YetaP43002GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
	//			yetaP13001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhYrtxBlggYr, "year")
	//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
				YetaP43002GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
						, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
				YetaP43002GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
						, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
			 
				YetaP43002GridPanel.reload();
				
//			}
			
//			actionDatabase = ActionDatabase.READ;
		}
		
	private void createMsfGridForm() {

		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("의료비내역");
		gridFieldSet.setBorders(true);
			
		YetaP43002GridPanel = new MSFGridPanel(YetaP43002ToYe164010Def, false,false, false, false, false);
		YetaP43002GridPanel.setSize("780px", "390px");
		YetaP43002GridPanel.setBorders(true);
		YetaP43002GridPanel.setBodyBorder(false);
		YetaP43002GridPanel.setHeaderVisible(false);
		YetaP43002GridPanel.getBottomComponent().setVisible(true);
			
			
		/** --- 그리드 합계 부분  시작 --- **/
		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
		payrSummaryRow.setHtml(Ye164010BM.ATTR_RESNOENCCNTN, "합 계"); 
		 
		payrSummaryRow.setCellStyle(Ye164010BM.ATTR_SCNT,"summary_color");		//의료비건수
		payrSummaryRow.setCellStyle(Ye164010BM.ATTR_USEAMT,"summary_color");	//의료비금액
			
								    
		payrSummaryRow.setSummaryType(Ye164010BM.ATTR_SCNT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye164010BM.ATTR_USEAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
		payrSummaryRow.setSummaryType(Ye164010BM.ATTR_SCNT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye164010BM.ATTR_USEAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								      
		YetaP43002GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
		/** --- 그리드 합계 부분  시작 --- **/
			
		gridFieldSet.add(YetaP43002GridPanel);

		cpYeta23002.add(gridFieldSet);

		// 초기 조회
		// reloadYetaP13002Grid();
		
	}
	
	private void fnPopupCommP160() {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
//		
		
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
		
			
		PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
		sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
		sysComPsnl0115Dto.setSystemkey(systemkey.getValue());// systemKey 넘김.
		      
		MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto); // 인사

		final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
		      
		popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();
		               
				if (mapModels != null) {
					actionDatabase = ActionDatabase.INSERT;

					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
					List<Ye164010DTO> listYe164010Dto = new ArrayList<Ye164010DTO>();
					
					Ye164010DTO ye164010Dto = new Ye164010DTO();
					
					while (iterRecords.hasNext()) {
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						// 건별로 그리드 처리를 하든지 인서트처리등을 한다. 함수를 이용하든지 알아서...
						ye164010Dto = new Ye164010DTO();
	                        
						ye164010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
						ye164010Dto.setYrtxBlggYr(yrtxBlggYr.getValue());    						/** column 귀속연도 : yrtxBlggYr */
						ye164010Dto.setClutSeptCd(clutSeptCd.getValue());    						/** column 연말정산구분코드 : clutSeptCd */
						ye164010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    						/** column SYSTEMKEY : systemkey */
						ye164010Dto.setMdxpsSeilNum(bmMapModel.set("mdxpsSeilNum",0L));    										/** column 의료비지급일련번호 : mdxpsSeilNum */
						ye164010Dto.setMdxpsVvalKrnCd("Y0140001");    				/** column 의료비국세자료구분코드 : mdxpsVvalKrnCd */
						
						ye164010Dto.setResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum"))); /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
						ye164010Dto.setYn( bmMapModel.set("yn", "1") );    							/** column 본인등해당여부 : yn */
						ye164010Dto.setBsnoEncCntn(bmMapModel.set("bsnoEncCntn",""));   /** column 지급처사업자등록번호 : bsnoEncCntn */
						ye164010Dto.setPlymNm(bmMapModel.set("plymNm",""));    								/** column 의료비_상호명 : plymNm */
						ye164010Dto.setMdxpsPrfClCd(bmMapModel.set("mdxpsPrfClCd$commCd",""));    			/** column 의료비_의료증빙코드 : mdxpsPrfClCd */
						ye164010Dto.setScnt( bmMapModel.get("scnt", "1"));   					/** column 의료비_건수 : scnt */
						ye164010Dto.setUseAmt(bmMapModel.set("useAmt", "0"));    				/** column 의료비_금액 : useAmt */
						ye164010Dto.setYn2(bmMapModel.set("yn2", "0") );    							/** column 의료비_난임시술비해당여부 : yn2 */		
						ye164010Dto.setYn3(bmMapModel.set("yn3", "0") );    							/** column 의료비_산후조리원비용여부 : yn3 */		
						ye164010Dto.setYn4(bmMapModel.set("yn4", "0") );    							/** column 의료비_실손보험금보전금액여부 : yn4 */		
							
						listYe164010Dto.add(ye164010Dto);
					}

					yetaP43002Service.activityOnYetaP43002ToYe164010(listYe164010Dto, actionDatabase, new AsyncCallback<Long>() {
						
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
									MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveYeta2300ToYe161090tabItem08_3(" + actionDatabase.name() + ") : " + caught), null);
						}

						public void onSuccess(Long result) {  

							reload();
							actionDatabase = ActionDatabase.UPDATE;

						}
					});
				}
			}
		});
	}
		
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
		

		
	 
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 종료
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/		
}
