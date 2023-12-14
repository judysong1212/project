package com.app.exterms.personal.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0500DTO;
import com.app.exterms.personal.client.service.Psnl0100Service;
import com.app.exterms.personal.client.service.Psnl0100ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0500Service;
import com.app.exterms.personal.client.service.Psnl0500ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Psnl0500 extends MSFPanel {

/**
 * ###################################################### 
 * { 시스템 기본설정파일 선언부 시작}  
 * #######################################################
 */
	
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnl0500Bar;	
	private Button btnPsnl0500Sreach;				//조회 버튼
	private Button btnPsnl0500Issue;				//발급 버튼
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색조건 시작 -------------- 
	private TextField<String> searchHanNm;			//성명
	private TextField<String> searchResnRegnNum; 	//주민번호
	private ComboBox<BaseModel> searchEmymtDivCd; 	//고용구분
	private ComboBox<BaseModel> searchHdofcCodtnCd;	//재직구분
	private TextField<String> srhDeptCd; 			//부서코드
    private TextField<String> srhDeptNm; 			//부서명  
    private Button btnSrhDeptCd;
    private TextField<String> srhMangeDeptCd; 		//관리부서 수정
    private TextField<String> srhMangeDeptNm; 		//관리부서 수정 
	private ComboBox<BaseModel> searchBusinCd; 		//사업명
	// -------------- 검색조건 종료 -------------- 
	
	// -------------- store 선언 시작 --------------
	private ListStore<BaseModel> listStoreA002 	= new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA003 	= new ListStore<BaseModel>();
	private ListStore<BaseModel> lsBusinCd 		= new ListStore<BaseModel>();
//	private ListStore<BaseModel> listStoreBass0400 = new ListStore<BaseModel>();
	// -------------- store 선언 종료 --------------


	// -------------- 서비스 호출 시작 --------------
	private Psnl0100ServiceAsync psnl0100Service = Psnl0100Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();// 공통코드 호출
	//private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();
	private Psnl0500ServiceAsync psnl0500Service = Psnl0500Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------
	
	
	// -------------- grid 선언 시작 --------------
	private Grid<Psnl0500DTO> psnl0500Grid;
	// -------------- grid 선언 종료 --------------
	
	
	private RpcProxy<BaseListLoadResult<Psnl0500DTO>> psnl0500Proxy = new RpcProxy<BaseListLoadResult<Psnl0500DTO>>() {
		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0500DTO>> callback) {
			
			Psnl0500DTO dto = new Psnl0500DTO();
			dto.setHanNm(searchHanNm.getValue());
			dto.setResnRegnNum(searchResnRegnNum.getValue());
			dto.setEmymtDivCd(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"));
			dto.setHdofcCodtnCd(PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"));
			dto.setDeptCd(MSFSharedUtils.allowNulls(srhMangeDeptCd.getValue()));
			dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(srhDeptCd.getValue()));
			dto.setBusinCd(PersonalUtil.getSelectedComboValue(searchBusinCd, "businCd"));
			try{
				psnl0500Service.selectPsnl0500((BaseListLoadConfig) loadConfig,	dto, callback);
			}catch(Exception e){
			    GWT.log(e.toString()); 
			}
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0500Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0500Proxy);
	private ListStore<Psnl0500DTO> psnl0500Store = new ListStore<Psnl0500DTO>(psnl0500Loader);
	 
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/
	   // 검색 폼 바인딩 처리 함수 
	 // private AuthAction authAction;  
	//  private Boolean boolChkAuth;  
	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	  /**
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	  private void checkPsnl0500Auth( String authAction, ListStore<BaseModel> bm) {   
    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
		   
			   
			   if (!maskTracker) { unmask(); }   
               //MSFMainApp.unmaskMainPage();
			   authExecEnabled() ;
              
		   }
	  }
		 private void authExecEnabled() { 
			   //------------------
			 //----------------------------------------------------
             Field<?>[] fldArrField = {searchEmymtDivCd, srhDeptCd, srhDeptNm, searchBusinCd};
             
             gwtAuthorization.formAuthFieldConfig(fldArrField);
             gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             * 권한설정을 위한 콤보처리를 위한 메서드 시작 
             * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
             ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
              //String[] strArrDeptCd = { "srhDeptCd","srhDeptNm"};
              //gwtAuthorization.formAuthPopConfig(plFrmPsnl0500, "","searchEmymtDivCd",strArrDeptCd,"","searchBusinCd");
              //gwtAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
            /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             * 권한설정을 위한 콤보처리를 위한 메서드 종료
             ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
              srhDeptCd.fireEvent(Events.Add);
	          
              
			 }
			 
//		  private AuthAction authAction;
//		  private int checkCntDef = 1;   //체크 값 갯수 
//		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//		  /**
//		   * 권한설정 처리 체크 
//		   * AuthAction 
//		   */
//		  private void checkPsnl0500Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//			 
//			   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//			   
//			     
//			       
//	                //----------------------------------------------------
//	                unmask(); 
//	                //MSFMainApp.unmaskMainPage();
//	                 
//			   }
//		  }

	   final Timer tmMask = new Timer()
	     {
	           public void run()
	           {
	              // if (maskTracker)
	              // { 
	        	   if (listStoreA002.getCount() > 0 ) {
	        		   
		           	    cancel();
		               	unmask(); 
		               	authExecEnabled() ;
		                maskTracker  = true;
		        	
		        	   } else {
		        		   tmMask.scheduleRepeating(2000);
		        	   }
	              // }
	           }
	     }; 
	     
		  private void initLoad() { 
			// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
			     gwtAuthorization = GWTAuthorization.getInstance();
			     gwtExtAuth = GWTExtAuth.getInstance();
			     
			     
			     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
			     
			     authMapDef.put("searchEmymtDivCd",Boolean.FALSE); 
				 
			     gwtExtAuth.setCheckMapDef(authMapDef);
		        
		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
		        	  //권한 검색조건처리를 위해 추가된 부분 
					  mask("[화면로딩] 초기화 진행 중!");
	         	}
		        tmMask.scheduleRepeating(5000);
		  }  
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/	
	
	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################
	 */
 

	private VerticalPanel vp;
	private FormPanel plFrmPsnl0500;
	// private FormData formData;
	@SuppressWarnings("unused")
	private String txtForm = "";

	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// // formData = new FormData("-650");
	// vp = new VerticalPanel();
	// vp.setSpacing(10);
	// createPsnl0100Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createCheckBoxGrid(); //기본정보필드
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }

	public ContentPanel getViewPanel() {
		if (panel == null) {
			 //권한 검색조건처리를 위해 추가된 부분 
			initLoad();
			
		//	listStoreBass0400 = PrgmComComboUtils.getMangDeptBass0400ComboData(new PrgmComBass0400DTO());
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add("A002"); //고용구분
			arrRpsttvCd.add("A003"); //재직구분
			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String, List<BaseModel>>>() {
				@Override
				public void onSuccess(
						HashMap<String, List<BaseModel>> result) {
					if (result != null && result.size() > 0) {
						listStoreA002.add(result.get("A002"));
						listStoreA003.add(result.get("A003"));
					}
				}

				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "공통코드 에러!", null);
				}
			});
			
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPsnl0500Form();	//화면 기본정보를 설정
			createSearchForm(); 	//검색필드를 적용
			createCheckBoxGrid(); 	//기본정보필드
			vp.setSize("1010px", "700px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.add(vp);

		}
		return panel;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Psnl0500() {
		setSize("1010px", "700px");
	}

	public Psnl0500(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0500Form() {

		plFrmPsnl0500 = new FormPanel();
		plFrmPsnl0500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 신분증 발급"));
		// plFrmPsnl0500.setIcon(Resources.ICONS.text());
		plFrmPsnl0500.setBodyStyleName("pad-text");
		plFrmPsnl0500.setFrame(true);
		plFrmPsnl0500.setPadding(2);
		
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("신분증 발급","PSNL0500");
				}
			});
		plFrmPsnl0500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0500.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

//		ButtonBar buttonBar = new ButtonBar();
		topPsnl0500Bar = new ButtonBar();
		topPsnl0500Bar.setAlignment(HorizontalAlignment.RIGHT);
		// buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));
		// buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));

//		Button topBtn = new Button("조회");
		btnPsnl0500Sreach = new Button("조회");
		btnPsnl0500Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0500Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				psnl0500Loader.load();
			}
		});
		topPsnl0500Bar.add(btnPsnl0500Sreach);

//		topBtn = new Button("발급");
		btnPsnl0500Issue = new Button("발급", psnl0500ButtonListener);
		btnPsnl0500Issue.setIcon(MSFMainApp.ICONS.print16());
		/**
		btnPsnl0500Issue.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				
				if(psnl0500Grid.getSelectionModel().getSelectedItems() != null 
						&& psnl0500Grid.getSelectionModel().getSelectedItems().size() > 0){
					MessageBox.confirm("발급", "신분증을 발급 하시겠습니까?", new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							if("Yes".equals(be.getButtonClicked().getText())){
								psnl0500Service.insertPsnl0560(psnl0500Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<List<String>>() {
									
									@Override
									public void onSuccess(List<String> result) {
										String strParam = "/rp ";
										
										String checkedSystemkeys = "";
										String chkkey = "";
										for(Psnl0500DTO dto : psnl0500Grid.getSelectionModel().getSelectedItems()){
											chkkey += "'"+dto.getSystemkey()+"',";
										}
										checkedSystemkeys = chkkey.substring(0,chkkey.length()-1);
										strParam += "["+checkedSystemkeys+"]";
										
										String psptIssNums = "";
										chkkey = "";
										for(String num : result){
											chkkey += "'"+num+"',";
										}
										psptIssNums = chkkey.substring(0,chkkey.length()-1);
										strParam += "["+psptIssNums+"]";
										
										//도장 출력을 위해 추가 2014-11-06
										String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
										if(MSFSharedUtils.paramNull(myImgUrl)) {
										   // myImgUrl = "http://105.19.10.32:8080";
											//링크오류메시지 출력 
										}
										strParam += "['"+  myImgUrl  +"']";
										
										PrintUtils.setPostCall(true);
										PrintUtils.rdaPrint("PSNL", "PSNLT0500.mrd", strParam);
									}
									
									@Override
									public void onFailure(Throwable caught) {
										caught.printStackTrace();
										MessageBox.info("", "발급정보 등록오류", null);
									}
								});
							}
						}
					});
				}else{
					MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
					return;
				}
			}
		});
		*/
		
		
		topPsnl0500Bar.add(btnPsnl0500Issue);

		plFrmPsnl0500.add(topPsnl0500Bar);

		vp.add(plFrmPsnl0500);
		plFrmPsnl0500.setSize("990px", "690px");
	}
	
	
	private SelectionListener<ButtonEvent> psnl0500ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			if(psnl0500Grid.getSelectionModel().getSelectedItems() != null 
					&& psnl0500Grid.getSelectionModel().getSelectedItems().size() > 0){
				MessageBox.confirm("발급", "신분증을 발급 하시겠습니까?", new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							psnl0500Service.insertPsnl0560(psnl0500Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<List<String>>() {
								
								@Override
								public void onSuccess(List<String> result) {
									Psnl0500Print("PSNLT0500", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
								}
								
								@Override
								public void onFailure(Throwable caught) {
									caught.printStackTrace();
									MessageBox.info("", "발급정보 등록오류", null);
								}
							});
						}
					}
				});
			}else{
				MessageBox.info("", "발급 받으실 항목을 선택하여 주세요.", null);
				return;
			}
		}
	};	
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	print Service 선언부 시작
     *  rex 추가로 리포트 타입변경
     *  fileName : 출력파일명 
     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
	private void Psnl0500Print(String fileName, String repType) {
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			   RdaPrint(fileName);
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			   RexPrint(fileName);
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		   }
	    }
	
	
	//rda
	private void RdaPrint(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		final String strDirPath = "PSNL";
				
		// mrd 출력물
		final String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		    		
		psnl0500Service.insertPsnl0560(psnl0500Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<List<String>>() {
			
			@Override
			public void onSuccess(List<String> result) {
				
				String strParam = "/rp ";
				
				String checkedSystemkeys = "";
				String chkkey = "";
				for(Psnl0500DTO dto : psnl0500Grid.getSelectionModel().getSelectedItems()){
					chkkey += "'"+dto.getSystemkey()+"',";
				}
				checkedSystemkeys = chkkey.substring(0,chkkey.length()-1);
				strParam += "["+checkedSystemkeys+"]";
				
				String psptIssNums = "";
				chkkey = "";
				for(String num : result){
					chkkey += "'"+num+"',";
				}
				psptIssNums = chkkey.substring(0,chkkey.length()-1);
				strParam += "["+psptIssNums+"]";
				
				//도장 출력을 위해 추가 2014-11-06
				String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
				if(MSFSharedUtils.paramNull(myImgUrl)) {
				   // myImgUrl = "http://105.19.10.32:8080";
					//링크오류메시지 출력 
				}
				strParam += "["+  myImgUrl  +"]";
				
				PrintUtils.setPostCall(true);
//				PrintUtils.rdaPrint("PSNL", "PSNLT0500.mrd", strParam);
				PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				MessageBox.info("", "발급정보 등록오류", null);
			}
		});
	}
	
	
	//rex
	private void RexPrint(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
		final String strDirPath = "PSNL";
				
		// reb 출력물
		final String rexFileName = fileName+".crf";
		// 보낼 파라미터
				    		
		psnl0500Service.insertPsnl0560(psnl0500Grid.getSelectionModel().getSelectedItems(), new AsyncCallback<List<String>>() {
					
			@Override
			public void onSuccess(List<String> result) {
						
				String strParam = "";
							
				String checkedSystemkeys = "";
				String chkkey = "";
				for(Psnl0500DTO dto : psnl0500Grid.getSelectionModel().getSelectedItems()){
					chkkey += "'"+dto.getSystemkey()+"',";
				}
				
				checkedSystemkeys = chkkey.substring(0,chkkey.length()-1);
				strParam += ""+checkedSystemkeys+"⊥";
							
				String psptIssNums = "";
				chkkey = "";
				for(String num : result){
					chkkey += "'"+num+"',";
				}
				
				psptIssNums = chkkey.substring(0,chkkey.length()-1);
				strParam += ""+psptIssNums+"⊥";
							
				//도장 출력을 위해 추가 2014-11-06
				String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
				if(MSFSharedUtils.paramNull(myImgUrl)) {
					// myImgUrl = "http://105.19.10.32:8080";
					//링크오류메시지 출력 
					MessageBox.info("", "발급정보 이미지 등록오류", null);
				}
//				strParam += "'"+  myImgUrl  +"'⊥";
				strParam += ""+  myImgUrl  +"⊥";
							
				PrintUtils.setPostCall(true);
	//			PrintUtils.rdaPrint("PSNL", "PSNLT0500.mrd", strParam);
				PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
			}
					
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				MessageBox.info("", "발급정보 등록오류", null);
			}
		});		
	}
	
	
	
	
	

	private void createCheckBoxGrid() {
		
		RowNumberer r = new RowNumberer();

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		configs.add(r);

		final CheckBoxSelectionModel<Psnl0500DTO> sm = new CheckBoxSelectionModel<Psnl0500DTO>();
		// selection model supports the SIMPLE selection mode
		// sm.setSelectionMode(SelectionMode.SIMPLE);

		configs.add(sm.getColumn());

		ColumnConfig column = new ColumnConfig();
		column.setId("hanNm");
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("resnRegnNum");
		column.setHeaderText("주민번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("emymtDivCd");
		column.setHeaderText("고용구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("deptCdNm");
		column.setHeaderText("부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(250);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("businCd");
		column.setHeaderText("사업명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(250);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("typOccuCdNm");
		column.setHeaderText("직종");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("dtilOccuInttnCd");
		column.setHeaderText("직종세");
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		configs.add(column);


		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.setFrame(true);
		// cp.setIcon(Resources.ICONS.table());
		cp.setLayout(new FitLayout());
		cp.setSize(600, 300);

		psnl0500Grid = new Grid<Psnl0500DTO>(psnl0500Store, cm);
		psnl0500Grid.setStateId("psnl0500Grid");
		psnl0500Grid.setStateful(false);
		psnl0500Grid.setLoadMask(true); // 작업중표시
		psnl0500Grid.setBorders(true);
		psnl0500Grid.setSelectionModel(sm);
		psnl0500Grid.addPlugin(sm);
		psnl0500Grid.setColumnResize(true);
		//psnl0500Grid.setAutoExpandColumn("dtilOccuInttnCd");

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("발급대상자정보");

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setStyleAttribute("paddingLeft", "5px");
		cpGrid.setStyleAttribute("paddingRight", "5px");
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
//		cpGrid.setSize(935, 480);
		cpGrid.setSize("950px", "500px");

		cpGrid.add(psnl0500Grid);
		lcStdGrid.add(cpGrid);
		fieldSet.add(lcStdGrid);

		plFrmPsnl0500.add(fieldSet);

	}

	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {

		// FormPanel panel = new FormPanel();
		// panel.setFrame(true);
		// panel.setHeaderVisible(false);
		// panel.setIcon(Resources.ICONS.form());
		// panel.setHeadingText("FormPanel");
		// panel.setSize(600, -1);
		// panel.setLabelAlign(LabelAlign.TOP);
		// panel.setButtonAlign(HorizontalAlignment.CENTER);

		// FormPanel form2 = new FormPanel();
		// form2.setFrame(true);
		// form2.setHeadingHtml("Simple Form with FieldSets");
		// form2.setWidth(350);
		plFrmPsnl0500.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		
		// fieldSet.setCheckboxToggle(false);

		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(70);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSch);
		
		
		searchHanNm = new TextField<String>();
		searchHanNm.setFieldLabel("성명");
		searchHanNm.addKeyListener(new KeyListener(){
			@Override
			public void componentKeyDown(ComponentEvent event) {
				if(event.getKeyCode() == KeyCodes.KEY_ENTER){
					searchHanNm.validate();
					fnPopupPsnl0100();
				}
			}
		});
		//searchHanNm.setAllowBlank(false);
		layoutContainer_4.add(searchHanNm, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		layoutContainer_4.setBorders(false);

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_5.setLayout(frmlytSch);

		searchResnRegnNum = new TextField<String>();
		searchResnRegnNum.setFieldLabel("주민번호");
		layoutContainer_5.add(searchResnRegnNum, new FormData("95%"));
		layoutContainer_3.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytSch);

		
		searchEmymtDivCd = new ComboBox<BaseModel>();
		searchEmymtDivCd.setFieldLabel("고용구분");
		searchEmymtDivCd.setForceSelection(true);
		searchEmymtDivCd.setMinChars(1);
		searchEmymtDivCd.setDisplayField("commCdNm");
		searchEmymtDivCd.setValueField("commCd");
		searchEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		searchEmymtDivCd.setEmptyText("--고용구분선택--");
		searchEmymtDivCd.setSelectOnFocus(true);
		searchEmymtDivCd.setStore(listStoreA002);
		searchEmymtDivCd.setName("searchEmymtDivCd");
		searchEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		searchEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		listStoreA002.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) { 
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPsnl0500Auth("searchEmymtDivCd", listStoreA002); 
              	 }
		    }
		});
		
		layoutContainer_6.add(searchEmymtDivCd, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSch);

		searchHdofcCodtnCd = new ComboBox<BaseModel>();
		searchHdofcCodtnCd.setFieldLabel("재직구분");
		searchHdofcCodtnCd.setForceSelection(true);
		searchHdofcCodtnCd.setMinChars(1);
		searchHdofcCodtnCd.setDisplayField("commCdNm");
		searchHdofcCodtnCd.setValueField("commCd");
		searchHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
		searchHdofcCodtnCd.setEmptyText("--재직구분선택--");
		searchHdofcCodtnCd.setSelectOnFocus(true);
		searchHdofcCodtnCd.setStore(listStoreA003);
		
		layoutContainer_7.add(searchHdofcCodtnCd, new FormData("100%"));
		layoutContainer_3.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer_7.setBorders(false);

		fieldSet.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(85);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);

		//검색 소속부서 코드 처리  
        LayoutContainer lccmlcDeptNm = new LayoutContainer();
        lccmlcDeptNm.setLayout(new ColumnLayout());
        //부서 
        srhDeptCd = new TextField<String>();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setVisible(false);
        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
        	@Override
            public void handleEvent(BaseEvent be) { 
        		if(srhDeptCd.getValue() != null){
        			if (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") ))) {
        				PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
        				dto.setBusinApptnYr("");  //DateTimeFormat.getFormat("yyyy").format(new Date())
        				dto.setDeptCd(srhDeptCd.getValue()); 
                  
        				//--------------------사업 불러 오는 함수 -------------------------------------------------
        				lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
        				//--------------------사업 불러 오는 함수 -------------------------------------------------
        				searchBusinCd.setStore(lsBusinCd); 
        				searchBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        					public void handleEvent(StoreEvent<BaseModel> be) {  
                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
        					}
        				});    
        			}
              	} 
            }
        });
        plFrmPsnl0500.add(srhDeptCd);
        srhMangeDeptCd = new TextField<String>();
        srhMangeDeptCd.setName("srhMangeDeptCd");
        srhMangeDeptCd.setVisible(false);
        plFrmPsnl0500.add(srhMangeDeptCd);
        srhMangeDeptNm = new TextField<String>();
        srhMangeDeptNm.setName("srhMangeDeptNm");
        srhMangeDeptNm.setVisible(false);
        plFrmPsnl0500.add(srhMangeDeptNm);
  
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcDeptNm.setLayout(frmlytSch);
      
        srhDeptNm = new TextField<String>();
        srhDeptNm.setName("srhDeptNm");
        srhDeptNm.setFieldLabel("부서");  
        srhDeptNm.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
        srhDeptNm.setEnabled(gwtExtAuth.getEnableDeptCd());
        srhDeptNm.addKeyListener(new KeyListener() {
        	@Override
        	public void componentKeyDown(ComponentEvent event) {
        		if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
        			srhDeptCd.setValue("");
        			srhMangeDeptCd.setValue("");
        		}
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			//if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
        				srhDeptCd.setValue("");
        				srhMangeDeptCd.setValue("");
        			//}
        			fnPopupCommP140(srhDeptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
         
//        srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//        	@Override
//        	public void handleEvent(BaseEvent be) { 
//        		if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//        			srhDeptCd.setValue("");
//        			srhMangeDeptCd.setValue("");
//        		}
//        	} 
//        });        
        lcDeptNm.add(srhDeptNm, new FormData("100%"));  
          
        btnSrhDeptCd = new Button();
        btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
        btnSrhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
        btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
        	public void handleEvent(ButtonEvent e) { 
        		if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
        			srhDeptCd.setValue("");
        			srhMangeDeptCd.setValue("");
        		}
        		fnPopupCommP140(srhDeptNm.getValue()); 
        	}
        });
            
        lccmlcDeptNm.add(lcDeptNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
        lccmlcDeptNm.add(btnSrhDeptCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
             
		lcSchLeft.add(lccmlcDeptNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));

		
		LayoutContainer layoutContainer = new LayoutContainer();

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(85);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSchRight);

	    searchBusinCd = new ComboBox<BaseModel>();
        searchBusinCd.setFieldLabel("사업명");
        searchBusinCd.setForceSelection(true);
        searchBusinCd.setMinChars(1);
        searchBusinCd.setDisplayField("businNm");
        searchBusinCd.setValueField("businCd");
        searchBusinCd.setTriggerAction(TriggerAction.ALL);
        searchBusinCd.setEmptyText("--소속부서선택--");
        searchBusinCd.setSelectOnFocus(true);
        searchBusinCd.setName("searchBusinCd");
        searchBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
        searchBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
        searchBusinCd.setStore(new ListStore<BaseModel>());
        
		layoutContainer_1.add(searchBusinCd, new FormData("100%"));
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(85);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSchRight);
 
		
		//layoutContainer_8.add(searchBusinCd, new FormData("100%"));
		layoutContainer.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_8.setBorders(false);
		lcSchRight.add(layoutContainer, new FormData("100%"));
		layoutContainer.setLayout(new ColumnLayout());
		layoutContainer.setBorders(false);

		// TextField<String> company = new TextField<String>();
		// company.setFieldLabel("주민등록번호");
		// fieldSet.add(company, new FormData("100%"));
		//
		// TextField<String> email = new TextField<String>();
		// email.setFieldLabel("Email");
		// fieldSet.add(email, new FormData("100%"));

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmPsnl0500.add(fieldSet);
		// vp.add(panel);
	}
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 시작
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/	
	private void fnPopupPsnl0100() {
	       MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(searchHanNm.getRawValue());  //인사  
	       final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
	      
	       popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("systemkey"))) { 
	                   //systemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
	            	   searchHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
	            	   searchResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
	               }  
	           }
	       });
	   }
	   //부서 
	   private void fnPopupCommP140(String deptCd) {
	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	       //검색.처리하면됨.
	       
	       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
	       
	       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
	      
	       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
	           public void handleEvent(BaseEvent be) {
	               BaseModel mapModel = (BaseModel)be.getSource();
	               if (!"".equals(mapModel.get("deptCd"))) { 
	                  // srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
	                  // srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
	                   srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	                   srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
	                   srhDeptCd.fireEvent(Events.Add);
	               }  
	           }
	       });
	   }
	/**
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	* 팝업화면 종료
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	**/ 
	   


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
