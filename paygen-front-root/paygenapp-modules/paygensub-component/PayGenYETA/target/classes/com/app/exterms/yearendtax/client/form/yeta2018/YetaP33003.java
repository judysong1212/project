/**
 * 기부금내역등록
 */
package com.app.exterms.yearendtax.client.form.yeta2018;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye165010BM;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye165010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2018.Ye165010Def;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaP33003Service;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaP33003ServiceAsync;
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
public  class YetaP33003   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYeta23003; 
	  
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
	private MSFGridPanel YetaP33003GridPanel;
//	private Yeta0300Def yeta0300Def_08  = new Yeta0300Def("YETA03008");	//가족교육비 그리드 테이블 컬럼 define 
//	private Ye16Ta3180Def YetaP33003ToYe165010  = new Ye16Ta3180Def("YetaP33003");	//가족교육비 그리드 테이블 컬럼 define 
	private Ye165010Def YetaP33003ToYe165010  = new Ye165010Def("YetaP33003");	//가족교육비 그리드 테이블 컬럼 define 
	// -------------- grid 선언 종료  ---------------	

		  
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
  	private  ButtonBar topYetaBtnBar = new ButtonBar();
	private  Button btnYetaNew = new Button();	//신규
	private  Button btnYetaDel = new Button();	//삭제
	private  Button btnYetaSave = new Button();	//저장
	private  Button btnYetaClose = new Button();//닫기

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String> srhYrtxBlggYr;		// 년도
 	private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산년도 : yrtxBlggYr */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : clutSeptCd */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
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
//	private  ListStore<BaseModel> lsdacRvyyStore = new ListStore<BaseModel>(); 	// 년도
	private  ListStore<BaseModel> lsclutSeptCd = new ListStore<BaseModel>(); 		// 정산구분
	 // -------------- stroe 선언 종료 --------------
	 	
	// -------------- 서비스 호출 시작 --------------
	private YetaP33003ServiceAsync yetaP33003Service = YetaP33003Service.Util.getInstance();
	// -------------- 서비스 호출 종료 -------------- 	
	 	
	    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
 
	     
		/**
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부 시작
	     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	     */  
		
	// 버튼에 따른 Action
	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			YetaP33003FormSave();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			YetaP33003FormSave();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			YetaP33003FormSave();
			break;
		}
	}
		
		
	private void YetaP33003FormSave() {
		if (MSFSharedUtils.paramNotNull(records)) {

			Boolean dataChk = true;

			List<Ye165010DTO> listYe165010Dto = new ArrayList<Ye165010DTO>();
			Ye165010DTO ye165010Dto= new Ye165010DTO(); 
			
			while (records.hasNext()) {

				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();
	                      
				ye165010Dto= new Ye165010DTO();  
				
				ye165010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
				ye165010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    						/** column SYSTEMKEY : systemkey */
				ye165010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));   						/** column 귀속연도 : yrtxBlggYr */
				ye165010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    						/** column 연말정산구분코드 : clutSeptCd */
				ye165010Dto.setCnbtSeilNum((Long) bmMapModel.get("cnbtSeilNum"));    										/** column 기부금일련번호 : cnbtSeilNum */
				
				ye165010Dto.setConbCd(MSFSharedUtils.allowNulls(bmMapModel.get("conbCd$commCd")));    						/** column 기부유형 : conbCd */
				ye165010Dto.setConbChgCd(MSFSharedUtils.allowNulls(bmMapModel.get("conbChgCd")));   						/** column 기부코드 : conbChgCd */
				ye165010Dto.setYrsMateClCd(MSFSharedUtils.allowNulls(bmMapModel.get("yrsMateClCd$commCd")));				/** column 기부자료구분코드 : yrsMateClCd */
				ye165010Dto.setDntcntn(MSFSharedUtils.allowNulls(bmMapModel.get("dntcntn")));    							/** column 기부내용 : dntcntn */
				ye165010Dto.setCoplNm(MSFSharedUtils.allowNulls(bmMapModel.get("coplNm")));    								/** column 기부처_상호명 : coplNm */
				ye165010Dto.setBsnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("bsnoEncCntn")).replaceAll("-", ""));	/** column 기부처_사업자등록번호 : bsnoEncCntn */
				ye165010Dto.setCnbtRltClCd(MSFSharedUtils.allowNulls(bmMapModel.get("cnbtRltClCd$commCd")));				/** column 기부자관계코드 : cnbtRltClCd */
				ye165010Dto.setCnbtFnm(MSFSharedUtils.allowNulls(bmMapModel.get("cnbtFnm")));    							/** column 기부자성명 : cnbtFnm */
				ye165010Dto.setResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("resnoEncCntn")).replaceAll("-", ""));	/** column 기부자_주민등록번호 : resnoEncCntn */
				ye165010Dto.setDntScnt((Long) bmMapModel.get("dntScnt"));    												/** column 기부명세건수 : dntScnt */
				ye165010Dto.setUseSumAmt((Long) bmMapModel.get("useSumAmt"));   				 							/** column 기부명세합계금액 : useSumAmt */
				ye165010Dto.setDdcTrgtConbAmt((Long) bmMapModel.get("ddcTrgtConbAmt"));    									/** column 공제대상기부금액 : ddcTrgtConbAmt */
				ye165010Dto.setConbSumAmt((Long) bmMapModel.get("conbSumAmt"));    											/** column 기부장려금신청금 : conbSumAmt */			
				ye165010Dto.setCnbtEtc(MSFSharedUtils.defaultNulls(bmMapModel.get("cnbtEtc"), "0"));    					/** column 기부금기타 : cnbtEtc */
				
	                
	                
				/** 그리드에 있는 항목에 대해서 입력 체크 **/
				if (MSFSharedUtils.paramNull(ye165010Dto.getYrtxBlggYr())) {
					MessageBox.alert("경고", "연도를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getConbCd())) {
					MessageBox.alert("경고", "유형을 선택해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getDntcntn())) {
					MessageBox.alert("경고", "기부내용을 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getCoplNm())) {
					MessageBox.alert("경고", "기부처명을 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getYrsMateClCd())) {
					MessageBox.alert("경고", "자료구분을 선택해 주세요.", null);
					dataChk = false;
					return;
				}  else if (MSFSharedUtils.paramNull(ye165010Dto.getBsnoEncCntn()
						.replace("-", ""))) {
					MessageBox.alert("경고", "사업자번호를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getCnbtRltClCd())) {
					MessageBox.alert("경고", "기부자관계를 선택해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getCnbtFnm())) {
					MessageBox.alert("경고", "기부자성명을 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getResnoEncCntn()
						.replace("-", ""))) {
					MessageBox.alert("경고", "주민번호를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getDntScnt())) {
					MessageBox.alert("경고", "건수를 입력해 주세요.", null);
					dataChk = false;
					return;
				} else if (MSFSharedUtils.paramNull(ye165010Dto.getUseSumAmt())) {
					MessageBox.alert("경고", "기부금액을 입력해 주세요.", null);
					dataChk = false;
					return;
				}
//				else if (MSFSharedUtils.paramNull(ye165010Dto.getConbSumAmt())) {
//					MessageBox.alert("경고", "장려신청금액을 입력해 주세요.", null);
//					dataChk = false;
//					return;
//				}

				listYe165010Dto.add(ye165010Dto);
			}
				
			if (dataChk) {

				if (listYe165010Dto.size() <= 0) {
					MessageBox.alert(actionDatabase.name() + "저장",actionDatabase.name()+ "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
		                
				yetaP33003Service.activityOnYetaP33003ToYe165010(listYe165010Dto, actionDatabase, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP33003ToYe165010(" + actionDatabase.name() + ") : " + caught), null);
						}

							public void onSuccess(Long result) {
								if (result == 0) {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),actionDatabase+ "처리가 완료되지 않았습니다. 데이타를 확인하십시요.",
											null);
								} else {
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),actionDatabase + "처리가 완료되었습니다.",null);
									reload();
									actionDatabase = ActionDatabase.UPDATE;
								}
							}

						});

			} else {
				MessageBox.alert(actionDatabase.name() + "선택",actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
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
//		 private void checkYetaP13001Auth( String authAction, ListStore<BaseModel>bm) {
//			 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//				   
//				  if (!maskTracker) { unmask(); }  
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//					 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 //----------------------------------------------------
//				 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
//				 gwtAuthorization.formAuthFieldConfig(fldArrField);
//				 
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
//				 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//			 }
//		 }
//
//		   final Timer tmMask = new Timer()
//		     {
//		           public void run()
//		           {
//		              // if (maskTracker)
//		              // { 
//		           	    cancel();
//		               	unmask(); 
//		               	maskTracker  = true;
//		              // }
//		           }
//		     }; 
//		     
//		 private void initLoad() {
//		
//			 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//			 gwtAuthorization = GWTAuthorization.getInstance();
//			 gwtExtAuth = GWTExtAuth.getInstance();
//			
//			
//			 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
//				 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
//				 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
//				 authMapDef.put("srhDeptCd",Boolean.FALSE);
//				 // authMapDef.put("srhTypOccuCd",Boolean.FALSE);
//			
//			 gwtExtAuth.setCheckMapDef(authMapDef);
//			
//			 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//				 //권한 검색조건처리를 위해 추가된 부분
//				 mask("[화면로딩] 초기화 진행 중!");
//			 }	
//			 tmMask.scheduleRepeating(5000);
//		 }
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/	 
	  
	public YetaP33003(final ActionDatabase actionDatabase, final MSFPanel caller) {

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
//		this.actionDatabase = actionDatabase;
		this.actionDatabase = ActionDatabase.UPDATE;
		this.caller = caller;

		cpYeta23003 = new ContentPanel();

		createSearchForm(); // 기본정보 필드를 적용
		createMsfGridForm(); // 그리드필드
		createStandardForm(); // 기본정보필드

		cpYeta23003.setBodyBorder(false);
		cpYeta23003.setBorders(false);
		cpYeta23003.setHeaderVisible(false);
		cpYeta23003.setSize("790px", "490px");

		this.add(cpYeta23003);
		formBinding = new FormBinding(this, true);

		this.setSize("810px", "510px");
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

		systemkey = new HiddenField<String>();	/** column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta23003.add(systemkey);

		dpobCd = new HiddenField<String>();		/** column 사업장코드 : dpobCd */
		dpobCd.setName("dpobCd");
		cpYeta23003.add(dpobCd);

		yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
		yrtxBlggYr.setName("yrtxBlggYr");
		cpYeta23003.add(yrtxBlggYr);

		clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
		clutSeptCd.setName("clutSeptCd");
		cpYeta23003.add(clutSeptCd);

		deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		deptNm.setName("deptNm");
		cpYeta23003.add(deptNm);

		hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		hanNm.setName("hanNm");
		cpYeta23003.add(hanNm);

		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
			     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsclutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			     
			        

		cpYeta23003.setLayout(new FlowLayout());

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
					 
				YetaP33003GridPanel.getMsfGrid().clearData();
					 
				BaseModel bmData = YetaP33003GridPanel.getTableDef().getDefaultValues();  
				
				bmData.set("dpobCd"					, dpobCd.getValue());    	/** column 사업장코드 : dpobCd */
				bmData.set("systemkey"				, systemkey.getValue());    /** column SYSTEMKEY : systemkey */
				bmData.set("yrtxBlggYr"				, yrtxBlggYr.getValue());   /** column 귀속연도 : yrtxBlggYr */
				bmData.set("clutSeptCd"				, clutSeptCd.getValue()); 	/** column 연말정산구분코드 : clutSeptCd */
				bmData.set("cnbtSeilNum"			, 0L);    					/** column 기부금일련번호 : cnbtSeilNum */
				bmData.set("conbCd"					, "");    					/** column 기부유형 : conbCd */
				bmData.set("conbChgCd"				, "");    					/** column 기부코드 : conbChgCd */
				bmData.set("yrsMateClCd$commCd"		, "Y0140001");    			/** column 기부국세자료구분코드 : yrsMateClCd */
				bmData.set("yrsMateClCd$commCdNm"	, "기타자료");    				/** column 기부국세자료구분코드 : yrsMateClCd */
				
				bmData.set("dntcntn"				, "");    					/** column 기부내용 : dntcntn */
				bmData.set("coplNm"					, "");    					/** column 기부처_상호명 : coplNm */
				bmData.set("bsnoEncCntn"			, "");    					/** column 기부처_사업자등록번호 : bsnoEncCntn */
				bmData.set("cnbtRltClCd"			, "");    					/** column 기부자관계코드 : cnbtRltClCd */
				bmData.set("cnbtFnm"				, "");    					/** column 기부자성명 : cnbtFnm */
				bmData.set("resnoEncCntn"			, "");    					/** column 기부자_주민등록번호 : resnoEncCntn */
				bmData.set("dntScnt"				, 0L);    					/** column 기부명세건수 : dntScnt */
				bmData.set("useSumAmt"				, 0L);    					/** column 기부명세합계금액 : useSumAmt */
				bmData.set("ddcTrgtConbAmt"			, 0L);    					/** column 공제대상기부금액 : ddcTrgtConbAmt */
				bmData.set("conbSumAmt"				, 0L);    					/** column 기부장려금신청금 : conbSumAmt */				
				bmData.set("cnbtEtc"				, "");      				/** column 기부금기타 : cnbtEtc */
				
				YetaP33003GridPanel.getMsfGrid().getGrid().stopEditing();
				YetaP33003GridPanel.getMsfGrid().getGrid().getStore().insert(bmData, 0);
				YetaP33003GridPanel.getMsfGrid().getGrid().startEditing(YetaP33003GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);

//				actionDatabase = ActionDatabase.INSERT;
//
//				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
//					return;
//				}
//					
//				// TODO Auto-generated method stub
//				// 가족사항을 가지고 오는 팝업을 호출한다.
//				// 선택한 내용을 저장 후리스트에 보여준다.
//				// 저장은 업데이트로 처리한다.
//				fnPopupCommP160(); 
//			         
//				actionDatabase = ActionDatabase.INSERT;
			}
		});

		topYetaBtnBar.add(btnYetaNew);

		btnYetaDel = new Button("삭제");
		btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
		btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				MessageBox.confirm("삭제", "선택하신 기부금 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {
							
							Iterator<BaseModel> itBm = YetaP33003GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
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
				setListRecord(YetaP33003GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());

				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
				
				doAction(actionDatabase);
				
			}
		});

		topYetaBtnBar.add(btnYetaSave);
		cpYeta23003.add(topYetaBtnBar);

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
//					srhClutSeptCd.setValue(lsclutSeptCd.getAt(0));
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

		cpYeta23003.add(fieldSet);

	}
	 	 
	private void createStandardForm() {

		LayoutContainer lcFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(800, 300);

		LayoutContainer layoutContainer = new LayoutContainer();

		LayoutContainer layoutContainer_1 = new LayoutContainer();
	      
	      LabelField lblfldNewLabelfield = new LabelField("유형 항목을 선택하시면 콤보에서 선택 하는 화면이 나타 납니다.");
	      layoutContainer_1.add(lblfldNewLabelfield);
	      layoutContainer.add(layoutContainer_1);
	      layoutContainer_1.setBorders(false);
	      
//	      LayoutContainer layoutContainer_2 = new LayoutContainer();
//	      
//	      LabelField lblfldNewLabelfield_1 = new LabelField("기부자는 팝업에서 선택하도록 했습니다. 기부자성명 항목을 선택하면 팝업 버튼이 나타납니다.");
//	      layoutContainer_2.add(lblfldNewLabelfield_1);
//	      layoutContainer.add(layoutContainer_2);
//	      layoutContainer_2.setBorders(false);
	      
		cp01.add(layoutContainer);
		lcFormLayer.add(cp01);
		cpYeta23003.add(lcFormLayer);

		// return lcFormLayer;
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

	// private LayoutContainer createMsfGridForm() {
	private void createMsfGridForm() {

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(790, 360);

			
		YetaP33003GridPanel = new MSFGridPanel(YetaP33003ToYe165010, false, false, false, false, false);
		YetaP33003GridPanel.setHeaderVisible(false);  
		YetaP33003GridPanel.setBorders(false);
		YetaP33003GridPanel.setHeaderVisible(false);
		YetaP33003GridPanel.getBottomComponent().setVisible(true);
			
			
		/** --- 그리드 합계 부분  시작 --- **/
		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();
			
		payrSummaryRow.setHtml(Ye165010BM.ATTR_CNBTFNM, "합 계");
			 
		payrSummaryRow.setCellStyle(Ye165010BM.ATTR_DNTSCNT,"summary_color");				/** set 기부명세건수 : dntScnt */
		payrSummaryRow.setCellStyle(Ye165010BM.ATTR_USESUMAMT,"summary_color");				/** set 기부명세합계금액 : useSumAmt */
		payrSummaryRow.setCellStyle(Ye165010BM.ATTR_DDCTRGTCONBAMT,"summary_color");		/** set 공제대상기부금액 : ddcTrgtConbAmt */
		payrSummaryRow.setCellStyle(Ye165010BM.ATTR_CONBSUMAMT,"summary_color");			/** set 기부장려금신청금 : conbSumAmt */
		
								    
		payrSummaryRow.setSummaryType(Ye165010BM.ATTR_DNTSCNT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165010BM.ATTR_DNTSCNT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
		payrSummaryRow.setSummaryType(Ye165010BM.ATTR_USESUMAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165010BM.ATTR_USESUMAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
		
		payrSummaryRow.setSummaryType(Ye165010BM.ATTR_DDCTRGTCONBAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165010BM.ATTR_DDCTRGTCONBAMT, NumberFormat.getFormat("#,##0;(#,##0)")); 
		
		payrSummaryRow.setSummaryType(Ye165010BM.ATTR_CONBSUMAMT, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye165010BM.ATTR_CONBSUMAMT, NumberFormat.getFormat("#,##0;(#,##0)")); 
		
		YetaP33003GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
		/** --- 그리드 합계 부분  종료 --- **/
			

		cp01.add(YetaP33003GridPanel);

		cpYeta23003.add(cp01);

	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	@Override
	public void reload() {
			
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
				
		YetaP33003GridPanel.getTableDef().setTableColumnFilters(filters);
		YetaP33003GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
		YetaP33003GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
				, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		YetaP33003GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
			 
		YetaP33003GridPanel.reload();

		// actionDatabase = ActionDatabase.READ;
	}
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
	
	private void fnPopupCommP160() {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨. 
		
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

					List<Ye165010DTO> listYe165010Dto = new ArrayList<Ye165010DTO>();
					Ye165010DTO ye165010Dto= new Ye165010DTO(); 
					
					while (records.hasNext()) {

						Record record = (Record) records.next();
						BaseModel bmMapModel = (BaseModel) record.getModel();
			                      
						ye165010Dto= new Ye165010DTO();  
						
						ye165010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
						ye165010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    						/** column SYSTEMKEY : systemkey */
						ye165010Dto.setYrtxBlggYr(yrtxBlggYr.getValue());   						/** column 귀속연도 : yrtxBlggYr */
						ye165010Dto.setClutSeptCd(clutSeptCd.getValue());    						/** column 연말정산구분코드 : clutSeptCd */
						ye165010Dto.setCnbtSeilNum(bmMapModel.set("cnbtSeilNum",0L));    										/** column 기부금일련번호 : cnbtSeilNum */
						
						ye165010Dto.setConbCd("");    						/** column 기부유형 : conbCd */
						ye165010Dto.setConbChgCd("");   						/** column 기부코드 : conbChgCd */
						ye165010Dto.setYrsMateClCd("Y0140001");				/** column 기부자료구분코드 : yrsMateClCd */
						ye165010Dto.setDntcntn("");    							/** column 기부내용 : dntcntn */
						ye165010Dto.setCoplNm("");    								/** column 기부처_상호명 : coplNm */
						ye165010Dto.setBsnoEncCntn("");	/** column 기부처_사업자등록번호 : bsnoEncCntn */
						ye165010Dto.setCnbtRltClCd("");				/** column 기부자관계코드 : cnbtRltClCd */
						ye165010Dto.setCnbtFnm(MSFSharedUtils.allowNulls(bmMapModel.get("famyNm")));    							/** column 기부자성명 : cnbtFnm */
						ye165010Dto.setResnoEncCntn(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum")));	/** column 기부자_주민등록번호 : resnoEncCntn */
						ye165010Dto.setDntScnt((Long) bmMapModel.set("dntScnt",1L));    												/** column 기부명세건수 : dntScnt */
						ye165010Dto.setUseSumAmt((Long) bmMapModel.set("useSumAmt",0L));   				 							/** column 기부명세합계금액 : useSumAmt */
						ye165010Dto.setDdcTrgtConbAmt((Long) bmMapModel.set("ddcTrgtConbAmt",0L));    									/** column 공제대상기부금액 : ddcTrgtConbAmt */
						ye165010Dto.setConbSumAmt((Long) bmMapModel.set("conbSumAmt",0L));    											/** column 기부장려금신청금 : conbSumAmt */			
						ye165010Dto.setCnbtEtc(bmMapModel.get("cnbtEtc","0"));    					/** column 기부금기타 : cnbtEtc */
						
						listYe165010Dto.add(ye165010Dto);
					}
			                
					yetaP33003Service.activityOnYetaP33003ToYe165010(listYe165010Dto, actionDatabase, new AsyncCallback<Long>() {

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
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 종료
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/		
}
