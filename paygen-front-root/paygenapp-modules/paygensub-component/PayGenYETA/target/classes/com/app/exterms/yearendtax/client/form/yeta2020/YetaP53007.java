/**
 * 연금저축소득공제
 */
package com.app.exterms.yearendtax.client.form.yeta2020;
  

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye162010BM;
import com.app.exterms.yearendtax.client.dto.yeta2020.Ye162010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2020.Ye162010Def;
import com.app.exterms.yearendtax.client.service.yeta2020.YetaP53007Service;
import com.app.exterms.yearendtax.client.service.yeta2020.YetaP53007ServiceAsync;
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
import com.app.smrmf.syscom.client.languages.SysComConstants;
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
public  class YetaP53007   extends MSFFormPanel {  

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
 
	private ContentPanel cpYeta23007;

	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
		 
	// 권한 설정 객체
	private static GWTAuthorization gwtAuthorization;
	private static GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

	private SysComConstants SysComLabel = SysComConstants.INSTANCE; 
		  
	// -------------- grid 선언 시작  ---------------	  
	private MSFGridPanel YetaP53007GridPanel;
//	private Ye16Ta3100Def YetaP53007ToYe162010Def  = new Ye16Ta3100Def("YETAP13007");	//종전근무지내역 그리드 테이블 컬럼 define 
	private Ye162010Def ye162010Def  = new Ye162010Def("YetaP53007");	//종전근무지내역 그리드 테이블 컬럼 define 
	// -------------- grid 선언 종료  ---------------

		  
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private SysCoCalendarDTO msfCoCalendarDto;
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
	private  Button btnYetaNew = new Button();		//신규
	private  Button btnYetaDel = new Button();		//삭제
	private  Button btnYetaSave = new Button();		//저장
	private  Button btnYetaClose = new Button();	//닫기

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String>  	srhYrtxBlggYr;	// 년도
 	private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분
 	private TextField<String> 	srhDeptCd; 		// 부서
 	private TextField<String> 	srhHanNm; 		// 성명
 	
 	
    private HiddenField<String> dpobCd;			/**  column 사업장코드 : dpobCd */
 	private HiddenField<String> systemkey;		/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> yrtxBlggYr;		/** column 정산년도 : yrtxBlggYr */
    private HiddenField<String> clutSeptCd;		/** column 정산구분코드 : clutSeptCd */
    private HiddenField<String> deptNm;  		/**  column 부서명 : deptNm */
	private HiddenField<String>	hanNm;			/**  column 성명 : hanNm */
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
	private  ListStore<BaseModel> lsClutSeptCd = new ListStore<BaseModel>(); 	// 정산구분
	// -------------- stroe 선언 종료 --------------
	 	
	// -------------- 서비스 호출 시작 --------------
	private YetaP53007ServiceAsync yetaP53007Service = YetaP53007Service.Util.getInstance();
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
		//버튼에 따른 Action
		private void doAction(ActionDatabase actionDatabase) {
			switch (actionDatabase) {
				case INSERT:
					this.actionDatabase = ActionDatabase.INSERT;
					YetaP53007FormSave();
					break;
				case UPDATE:
					this.actionDatabase = ActionDatabase.UPDATE;
					YetaP53007FormSave();
					break;
				case DELETE:
					this.actionDatabase = ActionDatabase.DELETE;
					YetaP53007FormSave();
					break;
			}
		}
		
		
		private void YetaP53007FormSave() {  
			if (MSFSharedUtils.paramNotNull(records)) { 
				
				Boolean dataChk = true;
	              
				List<Ye162010DTO> listYe162010Dto = new ArrayList<Ye162010DTO>();  
	                
				while (records.hasNext()) {
	              
					Record record = (Record) records.next(); 
	                BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
	                Ye162010DTO ye162010Dto= new Ye162010DTO();  
	                
	                ye162010Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    									/** column 사업장코드 : dpobCd */
	                ye162010Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    							/** column 귀속년도 : yrtxBlggYr */
	                ye162010Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    							/** column 연말정산구분코드 : clutSeptCd */
	                ye162010Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    							/** column SYSTEMKEY : systemkey */
	                ye162010Dto.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("taxVvalKrnCd")));    						/** column 국세청자료구분코드 : taxVvalKrnCd */
	                ye162010Dto.setPnsnSvngAccAccno(MSFSharedUtils.allowNulls(bmMapModel.get("pnsnSvngAccAccno")).replace("-", ""));/** column 계좌번호_증권번호 : pnsnSvngAccAccno */
	                ye162010Dto.setPnsnSvngAccPnsnSvngCl(MSFSharedUtils.allowNulls(bmMapModel.get("pnsnSvngAccPnsnSvngCl$commCd")));/** column 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
	                ye162010Dto.setPnsnSvngFnnOrgnCd(MSFSharedUtils.allowNulls(bmMapModel.get("pnsnSvngFnnOrgnCd$commCd")));    	/** column 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
	                ye162010Dto.setPnsnSvngAccFnnCmp(MSFSharedUtils.allowNulls(bmMapModel.get("pnsnSvngAccFnnCmp")));    			/** column 굼융회사등명 : pnsnSvngAccFnnCmp */
	                ye162010Dto.setPnsnSvngAccPymAmt((Long) bmMapModel.get("pnsnSvngAccPymAmt"));    								/** column 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
	                ye162010Dto.setIpnsnSvngAccddcAmt((Long)bmMapModel.get("ipnsnSvngAccddcAmt"));    								/** column 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
	                      
	                
	                /** 그리드에 있는 항목에 대해서 입력 체크 **/
	                if(MSFSharedUtils.paramNull( ye162010Dto.getPnsnSvngAccAccno())) {
	                	MessageBox.alert("경고", "연금저축구분을 선택해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if(MSFSharedUtils.paramNull( ye162010Dto.getPnsnSvngFnnOrgnCd())) {
	                	MessageBox.alert("경고", "금융기관을 선택해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if(MSFSharedUtils.paramNull( ye162010Dto.getPnsnSvngAccAccno().replace("-", ""))) {
	                	MessageBox.alert("경고", "계좌번호를 입력해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if(MSFSharedUtils.paramNull( ye162010Dto.getPnsnSvngAccPymAmt())) {
	                	MessageBox.alert("경고", "납입금액을 입력해 주세요.", null);
	                	dataChk = false;
						return; 
	                }else if("Y0140000".equals(ye162010Dto.getTaxVvalKrnCd())) {
	                	MessageBox.alert("경고", "국세청 자료는 수정이 불가합니다.", null);
	                	dataChk = false;
						return; 
	                }
	                
	                listYe162010Dto.add(ye162010Dto);
				}  
				
				
				
				if(dataChk) {
					if (listYe162010Dto.size() <= 0) {
						MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
						return;
					}
		                
					yetaP53007Service.activityOnYetaP53007ToYe162010(listYe162010Dto, actionDatabase, new AsyncCallback<Long>(){
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP13007ToYeta3100(" + actionDatabase.name() + ") : " + caught), null);
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
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
	  public YetaP53007(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
			//콤보 권한초기화
//			initLoad(); 
			
		    this.setFrame(false);
	        this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	        //FormLayout layout = new FormLayout();
	        //layout.setDefaultWidth(600);
	       // layout.setLabelWidth(0);  
	       // this.setLayout(layout);   
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.caller = caller;
		   
	        cpYeta23007 = new ContentPanel();  
	        
	        createSearchForm();			//검색필드를 적용
	        createMsfGridForm();		//그리드필드
		   
	           
		   cpYeta23007.setBodyBorder(false);
		   cpYeta23007.setBorders(false);
		   cpYeta23007.setHeaderVisible(false);
		   cpYeta23007.setSize("790px", "530px");
		   
		   this.add(cpYeta23007);
		   formBinding = new FormBinding(this, true);
		    
		   this.setSize("810px", "550px");  
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
			cpYeta23007.add(systemkey);
			
		    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
		    dpobCd.setName("dpobCd");
		    cpYeta23007.add(dpobCd);
		    
		    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
		    yrtxBlggYr.setName("yrtxBlggYr");
		    cpYeta23007.add(yrtxBlggYr);
		    
		    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
		    clutSeptCd.setName("clutSeptCd");
		    cpYeta23007.add(clutSeptCd);
		    
		    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
		    deptNm.setName("deptNm");
		    cpYeta23007.add(deptNm);
		    
		    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
		    hanNm.setName("hanNm");
		    cpYeta23007.add(hanNm);
		    
				
			sysComBass0300Dto = new PrgmComBass0300DTO();
			msfCoCalendarDto = new SysCoCalendarDTO();
			     
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			sysComBass0300Dto.setRpsttvCd("Y002");
			lsClutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
			//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			     
			     
			//--------------------급여년도 불러 오는 함수 ------------------------------------------------
//			lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
			//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
			     
			     // sysComBass0400Dto.setDeptDspyYn("Y");
//			     sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
//			     sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
			     
//			     lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//			     
//			     lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//			    	 public void handleEvent(StoreEvent<BaseModel> be) {  
//			    		 mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
//			    		 srhDeptCd.getStore().add(mDtalistDeptCd);
//			    	 }
//			     });     
			        

			cpYeta23007.setLayout(new FlowLayout());

			topYetaBtnBar = new ButtonBar();
			topYetaBtnBar.setAlignment(HorizontalAlignment.RIGHT);

			btnYetaNew = new Button("신규");
			btnYetaNew.setIcon(MSFMainApp.ICONS.new16());
			btnYetaNew.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					
					 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		 	    		 return;
		      	     }
					 
					 YetaP53007GridPanel.getMsfGrid().clearData();
					 
					 BaseModel bmData = YetaP53007GridPanel.getTableDef().getDefaultValues();  
			              
			         bmData.set("dpobCd", dpobCd.getValue()); 			/** column 사업장코드 : dpobCd */
			         bmData.set("systemkey", systemkey.getValue()); 	/** column SYSTEMKEY : systemkey */
			         bmData.set("yrtxBlggYr", yrtxBlggYr.getValue());	/** column 연말정산귀속년도 : yrtxBlggYr */
			         bmData.set("clutSeptCd", clutSeptCd.getValue());   /** column 정산구분코드 : clutSeptCd */
			         bmData.set("taxVvalKrnNm", "기타자료");     	 		/** column 국세자료구분코드 : taxVvalKrnCd */
			         bmData.set("taxVvalKrnCd", "Y0140001");     	 	/** column 국세자료구분코드 : taxVvalKrnCd */

			         
			         bmData.set("pnsnSvngAccAccno", "");    			/** column 계좌번호_증권번호 : pnsnSvngAccAccno */
			         bmData.set("pnsnSvngAccPnsnSvngCl", "");   	 	/** column 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
			         bmData.set("pnsnSvngFnnOrgnCd", "");    			/** column 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
			         bmData.set("pnsnSvngAccFnnCmp", "");    			/** column 굼융회사등명 : pnsnSvngAccFnnCmp */
			         bmData.set("pnsnSvngAccPymAmt", 0L);    			/** column 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
			         bmData.set("ipnsnSvngAccddcAmt", 0L);    			/** column 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
			         
			              
			         YetaP53007GridPanel.getMsfGrid().getGrid().stopEditing();      
			         YetaP53007GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
			         YetaP53007GridPanel.getMsfGrid().getGrid().startEditing(YetaP53007GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
					
			         actionDatabase = ActionDatabase.INSERT;
					
				}
			});
				
			topYetaBtnBar.add(btnYetaNew);

			btnYetaDel = new Button("삭제");
			btnYetaDel.setIcon(MSFMainApp.ICONS.save16());
			btnYetaDel.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					
					
					MessageBox.confirm("삭제", "선택하신 연금저축 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
						
						@Override
						public void handleEvent(MessageBoxEvent be) {
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								
								Iterator<BaseModel> itBm = YetaP53007GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
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
					
					setListRecord(YetaP53007GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
					doAction(actionDatabase);

				}
			});

			topYetaBtnBar.add(btnYetaSave);
					
			
			cpYeta23007.add(topYetaBtnBar);
			  	
			  	
			LayoutContainer lcSchCol = new LayoutContainer();
			lcSchCol.setLayout(new ColumnLayout());

			FieldSet fieldSet = new FieldSet();
			fieldSet.setHeadingHtml("기본정보");

			LayoutContainer lcSchCol01 = new LayoutContainer();

			FormLayout frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(60);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			lcSchCol01.setLayout(frmlytSch);
				
			srhYrtxBlggYr = new TextField<String> ();
			srhYrtxBlggYr.setName("yrtxBlggYr");
//			srhyrtxBlggYr.setForceSelection(true);
//			srhyrtxBlggYr.setMinChars(1);
//			srhyrtxBlggYr.setDisplayField("yearDisp");
//			srhyrtxBlggYr.setValueField("year");
//			srhyrtxBlggYr.setTriggerAction(TriggerAction.ALL);
			// srhyrtxBlggYr.setEmptyText("--년도선택--");
			srhYrtxBlggYr.setSelectOnFocus(true);
			srhYrtxBlggYr.setReadOnly(true);
			srhYrtxBlggYr.setEnabled(true);
//			srhyrtxBlggYr.setStore(lsdacRvyyStore);
			srhYrtxBlggYr.setFieldLabel("년도");
//			srhyrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
//				public void handleEvent(StoreEvent<BaseModel> be) {
//					srhyrtxBlggYr.setValue(lsdacRvyyStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
//				}
//			});
				
			lcSchCol01.add(srhYrtxBlggYr, new FormData("100%"));

			LayoutContainer lcSchCol02 = new LayoutContainer();

			frmlytSch = new FormLayout();
			frmlytSch.setLabelWidth(60);
			frmlytSch.setLabelAlign(LabelAlign.RIGHT);
			lcSchCol02.setLayout(frmlytSch);

			srhClutSeptCd = new ComboBox<BaseModel>();
			srhClutSeptCd.setName("srhclutSeptCd");
			srhClutSeptCd.setForceSelection(true);
			srhClutSeptCd.setMinChars(1);
			srhClutSeptCd.setDisplayField("commCdNm");
			srhClutSeptCd.setValueField("commCd");
			srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
			srhClutSeptCd.setEmptyText("--정산구분선택--");
			srhClutSeptCd.setSelectOnFocus(true);
			srhClutSeptCd.setReadOnly(true);
			srhClutSeptCd.setEnabled(true);
			srhClutSeptCd.setStore(lsClutSeptCd);
			srhClutSeptCd.setFieldLabel("정산구분");
			srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
				public void handleEvent(StoreEvent<BaseModel> be) {
					YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd");
//					srhclutSeptCd.setValue(lsclutSeptCd.getAt(0));
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

			cpYeta23007.add(fieldSet);
		}    
		
		public void setListRecord(Iterator<Record> records) {
		    this.records = records;
		}
	 	 
			
   	
	  @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            @Override
	            public void handleEvent(BaseEvent be) {
	            	
	            	srhDeptCd.setValue(deptNm.getValue());
	    			srhHanNm.setValue(hanNm.getValue());
	    			
//	            	reload();
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
		
		private void createMsfGridForm() {
			
			ContentPanel cp01 = new ContentPanel();   
			cp01.setBodyBorder(false);
			cp01.setHeaderVisible(false);
			cp01.setLayout(new FitLayout());
			cp01.setSize(790, 455);
			
			YetaP53007GridPanel = new MSFGridPanel(ye162010Def, false, false, false, false, false);
//			YetaP53007GridPanel.setSize("790px", "300px");
			YetaP53007GridPanel.setBorders(false);
			YetaP53007GridPanel.setHeaderVisible(false);
			
			
			/** --- 그리드 합계 부분  시작 --- **/
			AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
			payrSummaryRow.setHtml(Ye162010BM.ATTR_PNSNSVNGACCACCNO, "합 계"); 
			payrSummaryRow.setCellStyle(Ye162010BM.ATTR_PNSNSVNGACCACCNO,"summary_color");	
								    
			payrSummaryRow.setSummaryType(Ye162010BM.ATTR_PNSNSVNGACCPYMAMT, SummaryType.SUM);   
			payrSummaryRow.setSummaryFormat(Ye162010BM.ATTR_PNSNSVNGACCPYMAMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
			
			YetaP53007GridPanel.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
			/** --- 그리드 합계 부분  시작 --- **/
			
			cpYeta23007.add(YetaP53007GridPanel);
			
//			LayoutContainer layoutContainer = new LayoutContainer();
//		      
//			LabelField lblfldNewLabelfield = new LabelField("장기주식형저축의 경우에만 납입연차를 1,2,3년차로 구분하여 적는다. 숫자만 기입");
//			layoutContainer.add(lblfldNewLabelfield);
//			layoutContainer.setBorders(false);
			
			cp01.add(YetaP53007GridPanel);
			
			cpYeta23007.add(cp01);
			
			
//			cpYeta23007.add(layoutContainer);
	}
		
	public void reload() {

		// TODO Auto-generated method stub
		IColumnFilter filters = null;
				
		YetaP53007GridPanel.getTableDef().setTableColumnFilters(filters);
		
		YetaP53007GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
															, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
		YetaP53007GridPanel.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
															, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		YetaP53007GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
															, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
			 
		YetaP53007GridPanel.reload();
			
//			actionDatabase = ActionDatabase.READ;
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
