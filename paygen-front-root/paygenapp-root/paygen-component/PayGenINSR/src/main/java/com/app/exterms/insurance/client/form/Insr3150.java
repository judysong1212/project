package com.app.exterms.insurance.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr4100BM;
import com.app.exterms.insurance.client.dto.Insr4200BM;
import com.app.exterms.insurance.client.dto.Insr4200DTO;
import com.app.exterms.insurance.client.form.defs.Insr4200Def;
import com.app.exterms.insurance.client.service.Insr3150Service;
import com.app.exterms.insurance.client.service.Insr3150ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
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
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Insr3150  extends MSFPanel {   

	private VerticalPanel vp;
	private FormPanel plFrmInsr3150;
	private String txtForm = "";
	private XTemplate detailTp; 
	
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	
	//국민연금
	private Insr4200Def insr4200Def  = new Insr4200Def("INSR3150");   //그리드 테이블 컬럼 define  
	private MSFGridPanel insr4200GridPanel;
	private ActionDatabase actionDatabase;
	private ButtonBar topInsr31500Bar;
	private Button btnInsr3150Init;
	private Button btnInsr3150Save;
	private Button btnInsr3150Del;
	private Button btnInsr3150Sreach;
	private Button btnInsr3150TotInCome;
	private Button btnInsr3150Excel;
	
	/** column  년도 : year */
	private ComboBox<BaseModel> srhDeductYr; //공제년
	private ComboBox<BaseModel> srhDeductMnth;    //공제월 
	private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
	private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

	private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
	private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; //재직상태  
	private ComboBox<BaseModel> srhBusinCd;    //사업
	private TextField<String> srhHanNm;         //성명
	private TextField<String> srhResnRegnNum;   //주민번호 
	private HiddenField<String> srhSystemkey;   //시스템키
	private ComboBox<BaseModel> srhPymtDducDivCd;
	private List<ModelData> mDtalistHdofcCodtnCd ;
	private List<ModelData> mDtalistDeptCd ;
	private List<ModelData> mDtalistTypOccuCd ;
	private List<ModelData> mDtalistDtilOccuInttnCd ;
	private boolean mutilCombo = false;
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
	private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
	private ComboBox<BaseModel> srhUploadDivCd; //업로드 구분 코드 
 
	private Boolean emptyCheck = false ;
	
	/**
	* 권한설정 처리 체크 
	* AuthAction 
	*/
	private void checkInsr3150Auth( String authAction, ListStore<BaseModel> bm) {   
		
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			//----------------------------------------------------
			if (!maskTracker) { unmask(); }  
			//MSFMainApp.unmaskMainPage();
			authExecEnabled() ;
			gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
			}
	}
	
	private void authExecEnabled() { 
		Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
		gwtAuthorization.formAuthFieldConfig(fldArrField);
		
		srhDeductYr.setValue(lsDeductYrStore.findModel("year",PayGenConst.ACC_CURR_YEAR));
		srhDeductMnth.setValue(lsDeductMnthStore.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
		srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
		srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		* 권한설정을 위한 콤보처리를 위한 메서드 종료
		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	}
	
	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker)
			// 	{ 
			if (lsEmymtDivCd.getCount() > 0 ) {
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
		authMapDef.put("srhDeductYr",Boolean.FALSE);
		authMapDef.put("srhHdofcCodtnCd",Boolean.FALSE);
		authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
		authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
		authMapDef.put("srhDeptCd",Boolean.FALSE);
		
		gwtExtAuth.setCheckMapDef(authMapDef);
		
		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
		//권한 검색조건처리를 위해 추가된 부분 
		mask("[화면로딩] 초기화 진행 중!");
		}
		tmMask.scheduleRepeating(5000);
	}
	
	//입력수정삭제처리 rpc 처리부     srhDeductYr
	private Insr3150ServiceAsync insr3150Service = Insr3150Service.Util.getInstance();	    
	private ListStore<BaseModel> lsDeductYrStore = new ListStore<BaseModel>();  //년도 
	private ListStore<BaseModel> lsDeductMnthStore = new ListStore<BaseModel>();  //월
	private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
	private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
	private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
	private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
	private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
	
	private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
	private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드
	private ListStore<BaseModel>  lsUploadDivCd = new ListStore<BaseModel>();//업로드구분코드
 
	private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
	private SysCoCalendarDTO msfCoCalendarDto;  
	private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	private BaseModel record;
	private  Iterator<Record> records;
	
	//파일업로드처리 부분  
    private FileUploadField insr3150flUp;
    private Boolean picBoolFile;
    
    
    private void insr3150MnthUpdate(String monthDiv) {  
    	
    	Iterator<BaseModel> itBm = insr4200GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
        
        if (MSFSharedUtils.paramNotNull(itBm)) {
        	  
        	  List<Insr4200DTO> listInsr4200dto = new ArrayList<Insr4200DTO>();
        	  List<Record>  lsRec  = new ArrayList<Record>();
        	  
        	  while(itBm.hasNext()) {
        		  Record rec  = new Record(itBm.next());
        		  lsRec.add(rec);
    		  }
        	  
        	  Iterator<Record> iterRecords = lsRec.iterator();
                
                while (iterRecords.hasNext()) {

                	actionDatabase = ActionDatabase.UPDATE;
                    Record record = (Record)iterRecords.next();
    				BaseModel bmMapModel = (BaseModel)record.getModel();
                      
                    Insr4200DTO insr4200dto = new Insr4200DTO();   
					
                    insr4200dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */ 
                    insr4200dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */ 
                    insr4200dto.setEmymtSeilNum((Long)bmMapModel.get("emymtSeilNum"));    /** column 고용일련번호 : emymtSeilNum */ 
                    insr4200dto.setDducYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("dducYrMnth")));    /** column 공제년월 : dducYrMnth */
                    insr4200dto.setNatInsrPrmmSrd(MSFSharedUtils.allowNulls(bmMapModel.get("natInsrPrmmSrd")));    /** column 국민연금차액 : NatInsrPrmmSrd */     

                    if ( monthDiv.equals("Next") ){
                    	insr4200dto.setNatPayrDducYrMnth("Next");   
                    }else if( monthDiv.equals("This"))  {
                    	insr4200dto.setNatPayrDducYrMnth("This");
                    }else if( monthDiv.equals("Cancel"))  {
                    	insr4200dto.setNatPayrDducYrMnth("Cancel");
                    }else if( monthDiv.equals("Pay"))  {
                    	insr4200dto.setNatPayrDducYrMnth("Pay");
                    }

                    listInsr4200dto.add(insr4200dto);
                  
                }  
                
                if (listInsr4200dto.size() <= 0) {
                    MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
                    return;
                }
                
                
               // MessageBox.info("", "건강보험 가입자 고지(산출)내역서를 다운받아 업로드 하시면됩니다.\n(엑셀형식만 적용가능)", null);
                
              insr3150Service.insr3150MnthUpdate(listInsr4200dto, actionDatabase, new AsyncCallback<Long>(){
            	  
                  public void onFailure(Throwable caught) {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("insr3150MnthUpdate(" + actionDatabase.name() + ") : " + caught), null);
                  }
                  public void onSuccess(Long result) { 
                     if (result == 0) {
                         MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                 actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                     } else {
                    	 
                        if(result == -99L){
                        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "미마감된 급여월 대상자는 정산대사가 불가합니다.",null);
                        }else if(result == -88L){
                        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "마감된 급여월 대상자는 당월반영이 불가합니다.",null);
                        }else{
                        	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                            actionDatabase + "처리가 완료되었습니다.", null);
	                        reload();
	                        actionDatabase = ActionDatabase.UPDATE;
                        }
                     } 
                  } 
                   
              }); 
              
          } else {
              MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
              return;
          }

  }
    
	private void InsrP3150Print(String fileName) {
	
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "INSR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		//검색조건
		String serarchParam = ""; 
		
		//신고인경우에만 출력 가능하도록 처리
		/*
		String chkAntyDeinYr = InsrUtils.getSelectedComboValue(srhDeductMnth,"chkAntyDeinYr");
		
		if ("01".equals(chkAntyDeinYr)) {
			MessageBox.info("", "결정년도가 확정된 내역 조회시에는 소득총액신고내역을 인쇄하실 수 없습니다.", null);
		return;
		}
		*/
		
		String antyDeinYr = InsrUtils.getSelectedComboValue(srhDeductYr,"year");
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			
			for (int i=0; i<ray.length; i++){ 
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd")+","; 
			}
			strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		}  
		
		String payrMangDeptCd =  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
		String typOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");
		String pyspGrdeCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");
		//String dtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
		String hdofcCodtnCd = strHdofcCodtnCd;
		String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
		String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
		String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
		
		serarchParam += "["+antyDeinYr+"]";
		serarchParam += "["+payrMangDeptCd+"]";
		serarchParam += "["+emymtDivCd+"]";
		serarchParam += "["+typOccuCd+"]";
		serarchParam += "["+pyspGrdeCd+"]";
		serarchParam += "[]";
		serarchParam += "["+businCd+"]";
		serarchParam += "["+hdofcCodtnCd+"]";
		String checkedSystemKeys = "";
		serarchParam += "["+systemkey+"]";
		String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	}
	
	public ContentPanel getViewPanel() {
		
		if(panel == null) {
		
			//콤보 권한초기화
			initLoad(); 
			detailTp = XTemplate.create(getDetailTemplate()); 
			
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createInsr3150Form();  //화면 기본정보를 설정
			createSearchForm();    //검색필드를 적용
			createCheckBoxGrid();   
			createSubForm(); //엑셀업로드
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
	*  @wbp.parser.constructor
	*/
	public Insr3150() { 
		//엣지변환
		//setSize("1010px", "700px"); 
		setSize("1010px", "750px");  
	} 
	
	public Insr3150(String txtForm) {
		this.txtForm = txtForm;
	} 
	
	private void createInsr3150Form() {
	
		plFrmInsr3150 = new FormPanel();
		plFrmInsr3150.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 국민연금월별대사"));
		plFrmInsr3150.setIcon(Resources.APP_ICONS.text());
		plFrmInsr3150.setBodyStyleName("pad-text");
		plFrmInsr3150.setPadding(2);
		plFrmInsr3150.setFrame(true);  
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("국민연금월별대사","INSR3150");
				}
			});
		plFrmInsr3150.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmInsr3150.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		//멀티콤보박스 닫기 
		plFrmInsr3150.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
						srhDeptCd.showClose(ce);
						mutilCombo = false;
					} else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
						srhHdofcCodtnCd.showClose(ce);
						mutilCombo = false;
					} else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
						//직종
						srhTypOccuCd.showClose(ce);
						mutilCombo = false;
						//  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
					} else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
						//직종세
						srhDtilOccuInttnCd.showClose(ce);
						mutilCombo = false;
					}  
				}
			} 
		});
		
		topInsr31500Bar = new ButtonBar();    
		topInsr31500Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnInsr3150Init = new Button("초기화");  
		btnInsr3150Init.setIcon(Resources.APP_ICONS.new16());
		topInsr31500Bar.add(btnInsr3150Init);
		btnInsr3150Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//초기화 
				formInit();
			}
		});  
		
		btnInsr3150Sreach = new Button("조회"); 
		btnInsr3150Sreach.setIcon(Resources.APP_ICONS.search16());
		topInsr31500Bar.add(btnInsr3150Sreach);
		btnInsr3150Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//조회버튼 클릭시 처리 
				reload();  
			}
		});
		
		btnInsr3150Excel = new Button("엑셀"); 
		btnInsr3150Excel.setIcon(Resources.APP_ICONS.excel16()); 
		topInsr31500Bar.add(btnInsr3150Excel);  
		btnInsr3150Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//엑셀저장  
				xlsExportData();
			}
		});
		plFrmInsr3150.add(topInsr31500Bar);    
		
		//파일업로드 처리
		plFrmInsr3150.setAction("bizform");
		plFrmInsr3150.setEncoding(Encoding.MULTIPART);
		plFrmInsr3150.setMethod(Method.POST);

		vp.add(plFrmInsr3150);
		//엣지변환
		//plFrmInsr3150.setSize("990px", "680px");
		plFrmInsr3150.setSize("990px", "730px");
	}
	
	/**
	* 검색필드 설정
	*/
	private void createSearchForm() {   
	
	//  srhPyspGrdeCd = new HiddenField<String>(); 
	srhSystemkey = new HiddenField<String>();  //시스템키 
	sysComBass0150Dto = new PrgmComBass0150DTO();
	sysComBass0300Dto = new PrgmComBass0300DTO();
	sysComBass0400Dto = new PrgmComBass0400DTO();
	sysComBass0500Dto = new PrgmComBass0500DTO();
	msfCoCalendarDto = new SysCoCalendarDTO();
	sysComBass0350Dto = new PrgmComBass0350DTO();
	sysComBass0320Dto = new PrgmComBass0320DTO();
	//--------------------단위기관 불러 오는 함수 ------------------------------------------------
	lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	//--------------------단위기관 불러 오는 함수 ------------------------------------------------
	
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	//재직상태  
	sysComBass0300Dto.setRpsttvCd("A003");
	lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
			mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
			srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		}
	});   
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	//고용구분
	sysComBass0300Dto.setRpsttvCd("A002");
	lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	
	//--------------------급여년도 불러 오는 함수 ------------------------------------------------
	lsDeductYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
	//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	lsDeductMnthStore = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	// lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
	//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	
	sysComBass0300Dto.setRpsttvCd("A048");
	lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	  
/*	sysComBass0300Dto.setRpsttvCd("I030");
	lsUploadDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);  */
	//--------------------업로드구분 코드 생성 --------------------------------------------------
	BaseModel uploadDivCdBaseModel = new BaseModel();
	uploadDivCdBaseModel.                set("commCd", "I0300001");
	uploadDivCdBaseModel.set("commCdNm", "기본명세");
	lsUploadDivCd.add(uploadDivCdBaseModel);
	
	uploadDivCdBaseModel = new BaseModel(); 
	uploadDivCdBaseModel.set("commCd", "I0300002");
	uploadDivCdBaseModel.set("commCdNm", "상세명세");
	lsUploadDivCd.add(uploadDivCdBaseModel);
	//--------------------업로드구분 코드 생성 --------------------------------------------------	
	
	 //-------------------관리부서 추가  
	sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
	lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
	
	//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
	sysComBass0400Dto.setDeptDspyYn("Y");
	sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
	sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
	lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
			mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
			srhDeptCd.getInitStore().add(mDtalistDeptCd);
		}
	});     
	//--------------------급여부서 불러 오는 함수 ------------------------------------------------
	
	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
			mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		}
	});  
	
	plFrmInsr3150.setLayout(new FlowLayout());
	srhSystemkey = new HiddenField<String>(); 
	LayoutContainer lcSchCol = new LayoutContainer();
	//lcSchCol.setStyleAttribute("background-color","red");
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
	LayoutContainer lcSchLeft = new LayoutContainer();
	
	fieldSet.add(lcSchCol, new FormData("100%"));  
	lcSchLeft.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_8 = new LayoutContainer();
	FormLayout frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_8.setLayout(frmlytSch);
		
	srhDeductYr = new ComboBox<BaseModel>();
	srhDeductYr.setName("srhDeductYr");
	srhDeductYr.setForceSelection(true);
	srhDeductYr.setMinChars(1);
	srhDeductYr.setDisplayField("yearDisp");
	srhDeductYr.setValueField("year");
	srhDeductYr.setTriggerAction(TriggerAction.ALL);
	// srhDeductYr.setEmptyText("--년도선택--");
	srhDeductYr.setSelectOnFocus(true); 
	srhDeductYr.setReadOnly(false);
	srhDeductYr.setEnabled(true); 
	srhDeductYr.setStore(lsDeductYrStore);
	srhDeductYr.setFieldLabel("공제년월"); 
	srhDeductYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
			checkInsr3150Auth("srhDeductYr", lsDeductYrStore); 
		}
	});
	srhDeductYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
			//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
			BaseModel bmAntyDeinYr =  se.getSelectedItem(); 
			if (bmAntyDeinYr != null) {
			
				if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
			
					if (srhDeptCd.getListView().getChecked().size() > 0) {  
			
						sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhDeductYr,"year"));
						List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
						sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
					}      
			
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					srhBusinCd.setStore(lsBusinCd); 
					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
						public void handleEvent(StoreEvent<BaseModel> be) {  
							//   searchBusinCd.setValue(lsBusinCd.getAt(0));  
						}
					});
				} else {
					// MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
					//         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
					// return;
				}
			}       
		} 
	});  
	
	layoutContainer_8.add(srhDeductYr, new FormData("100%"));
	lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
	layoutContainer_8.setBorders(false);
	
	LayoutContainer layoutContainer_9 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(0); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_9.setLayout(frmlytSch);
	
   srhDeductMnth = new ComboBox<BaseModel>();
   srhDeductMnth.setName("srhDeductMnth");
   srhDeductMnth.setForceSelection(true);
   srhDeductMnth.setMinChars(1);
   srhDeductMnth.setDisplayField("monthDisp");
   srhDeductMnth.setValueField("month");
   srhDeductMnth.setTriggerAction(TriggerAction.ALL);
  // srhDeductMnth.setEmptyText("--월선택--");
   srhDeductMnth.setSelectOnFocus(true); 
   srhDeductMnth.setReadOnly(false);
   srhDeductMnth.setEnabled(true); 
   srhDeductMnth.setStore(lsDeductMnthStore);
   srhDeductMnth.setHideLabel(true);
   srhDeductMnth.getStore().addStoreListener( new StoreListener<BaseModel>() {   
       public void handleEvent(StoreEvent<BaseModel> be) {  
    	   checkInsr3150Auth("srhDeductMnth",lsDeductMnthStore);  
       }
   });
   layoutContainer_9.add(srhDeductMnth, new FormData("100%"));
   lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
   layoutContainer_9.setBorders(false);
	
	LayoutContainer layoutContainer = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	layoutContainer.setLayout(frmlytSch);
	
	/** column 단위기관 : payrMangDeptCd */
	srhPayrMangDeptCd = new ComboBox<BaseModel>();
	srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
	srhPayrMangDeptCd.setForceSelection(true);
	srhPayrMangDeptCd.setMinChars(1);
	srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
	srhPayrMangDeptCd.setValueField("payrMangDeptCd");
	srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
	srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
	srhPayrMangDeptCd.setSelectOnFocus(true); 
	srhPayrMangDeptCd.setReadOnly(false);
	srhPayrMangDeptCd.setEnabled(true); 
	srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
	srhPayrMangDeptCd.setFieldLabel("단위기관"); 
	lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	
		public void handleEvent(StoreEvent<BaseModel> be) {
			EventType type = be.getType();
			if (type == Store.Add) { 
				/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				checkInsr3150Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
			}   
		}
	});    
	srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
			sysComBass0400Dto = new PrgmComBass0400DTO();
	    	  
			srhDeptCd.reset();  //2015.12.07 추가 
			sysComBass0400Dto.setDeptDspyYn("Y");
			sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
			//--------------------부서 불러 오는 함수 ------------------------------------------------
			lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
			//--------------------부서 불러 오는 함수 ------------------------------------------------
			lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
				public void handleEvent(StoreEvent<BaseModel> be) {  
					mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
					srhDeptCd.getInitStore().add(mDtalistDeptCd);
				}
			});  
		} 
	});
	layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
	layoutContainer.setBorders(false);
	
	
	LayoutContainer layoutContainer_1 = new LayoutContainer();
	layoutContainer_1.setLayout(new ColumnLayout());
	
	LayoutContainer layoutContainer_101 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_101.setLayout(frmlytSch);
	
	srhEmymtDivCd =  new ComboBox<BaseModel>(); 
	srhEmymtDivCd.setName("srhEmymtDivCd");
	srhEmymtDivCd.setForceSelection(true);
	srhEmymtDivCd.setMinChars(1);
	srhEmymtDivCd.setDisplayField("commCdNm");
	srhEmymtDivCd.setValueField("commCd");
	srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
	srhEmymtDivCd.setEmptyText("--고용구분선택--");
	srhEmymtDivCd.setSelectOnFocus(true); 
	srhEmymtDivCd.setReadOnly(false);
	srhEmymtDivCd.setEnabled(true); 
	srhEmymtDivCd.setStore(lsEmymtDivCd);
	srhEmymtDivCd.setFieldLabel("고용구분");
	lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
			EventType type = be.getType();
			if (type == Store.Add) { 
				/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				* 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				* 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				* "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				checkInsr3150Auth("srhEmymtDivCd", lsEmymtDivCd); 
			}
		}
	});    
	srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
			//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
			BaseModel bmPayCd =  se.getSelectedItem(); 
			if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
		
				srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
				srhBusinCd.setEnabled(true);
				srhTypOccuCd.reset();
				srhTypOccuCd.setEnabled(false);
				srhDtilOccuInttnCd.reset();
				srhDtilOccuInttnCd.setEnabled(false);
			} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
				//20151130 추가 수정 
				srhDeptCd.getListView().fireEvent(Events.CheckChanged);
				srhBusinCd.reset();
				srhBusinCd.setEnabled(false);   
				if (gwtExtAuth.getEnableTypOccuCd()) {
					srhTypOccuCd.setEnabled(true);
					srhDtilOccuInttnCd.setEnabled(true); 
				} else {
					srhTypOccuCd.setEnabled(false);
					srhDtilOccuInttnCd.setEnabled(false);
				}
			}  
		} 
	});
	layoutContainer_101.add(srhEmymtDivCd, new FormData("100%"));
	layoutContainer_101.setBorders(false); 
	
	  LayoutContainer layoutContainer_102 = new LayoutContainer();
	   frmlytSch = new FormLayout();  
	   frmlytSch.setLabelWidth(1); 
	   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	   frmlytSch.setDefaultWidth(0);
	   layoutContainer_102.setLayout(frmlytSch);
	   
	   
	   
	   srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	   srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	   srhRepbtyBusinDivCd.setForceSelection(true);
	   srhRepbtyBusinDivCd.setAllowBlank(false);
	   srhRepbtyBusinDivCd.setMinChars(1);
	   srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	   srhRepbtyBusinDivCd.setValueField("commCd");
	   srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	   srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	   srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	   srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	   srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	   srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	   srhRepbtyBusinDivCd.setHideLabel(true);
	   //srhRepbtyBusinDivCd.setLabelSeparator("");
	  // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	   lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	       public void handleEvent(StoreEvent<BaseModel> be) {  

//	       	  EventType type = be.getType();
//		    	   if (type == Store.Add) { 
//	           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//	           	 }  
	         
	       }
	   });  
	   
	   layoutContainer_102.add(srhRepbtyBusinDivCd, new FormData("100%"));
	   layoutContainer_102.setBorders(false); 
	   
	   
	   layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	   layoutContainer_1.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	   layoutContainer_1.setBorders(false); 
	
	
	

	
	
	
	  lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
      lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
      lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	    //lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));//
	
	LayoutContainer layoutContainer_13 = new LayoutContainer();
	layoutContainer_13.setLayout(new ColumnLayout());
	
	//관리부서 
	LayoutContainer lcSch2_1 = new LayoutContainer();
	FormLayout frmlytSch2_1 = new FormLayout();
	frmlytSch2_1.setLabelWidth(60);
	frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
	lcSch2_1.setLayout(frmlytSch2_1);
		
			srhMangeDeptCd = new ComboBox<BaseModel>();
			srhMangeDeptCd.setName("srhMangeDeptCd"); 
			srhMangeDeptCd.setEmptyText("--관리부서선택--");
			srhMangeDeptCd.setDisplayField("deptNmRtchnt");
			srhMangeDeptCd.setStore(lsMangeDeptCd); 
			srhMangeDeptCd.setWidth(100);
			srhMangeDeptCd.setFieldLabel("관리부서");
			srhMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
	        srhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
	        srhMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	            	EventType type = be.getType();
	            	if (type == Store.Add) { 
	            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	            		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
	            	}
	            }
	        });  
	        srhMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
		    		sysComBass0400Dto = new PrgmComBass0400DTO();
	  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
	  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
	  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	  	    		
	  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	  	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
	  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	  	    			}
	  	    		});  
	  	    		emptyCheck = true;
		    	} 
		    });
	        srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) {    
	            	
	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
	                	
	                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
		                	sysComBass0400Dto = new PrgmComBass0400DTO();
		      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
		      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
		      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
		      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
		      	    		
		      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
		      	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
		      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
		      	    			} 
		      	    			
		      	    		}); 
		      	    		emptyCheck = false;
	                	}
	                 }  
	            } 
	        });   
	       
	        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
	
	LayoutContainer layoutContainer_2 = new LayoutContainer();
	
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_2.setLayout(frmlytSch);
	
	srhDeptCd = new MSFMultiComboBox<ModelData>();
	srhDeptCd.setName("srhDeptCd");
	srhDeptCd.setEmptyText("--부서선택--");
	srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
	srhDeptCd.getStore().add(mDtalistDeptCd);
	srhDeptCd.setWidth(100);
	srhDeptCd.setFieldLabel("부서");
	srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
		public void handleEvent(StoreEvent<ModelData> be) {  
			EventType type = be.getType();
			if (type == Store.Add) { 
				/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				* 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
				* 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
				* "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
				++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
				checkInsr3150Auth("srhDeptCd", lsDeptCd); 
			}
		}
	});    
	
	srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
		@Override
		public void handleEvent(ComponentEvent ce) {
			if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
				if (srhDeptCd.getListView().getChecked().size() > 0) {  
					sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhDeductYr,"year"));    
					List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
					sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
				}      
		
				//	--------------------사업 불러 오는 함수 -------------------------------------------------
				lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
				//	--------------------사업 불러 오는 함수 -------------------------------------------------
				srhBusinCd.setStore(lsBusinCd); 
				srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						//   searchBusinCd.setValue(lsBusinCd.getAt(0));  
					}
				}); 
			} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
				//2015.11.30 권한 직종가져오기  추가 
				sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				sysComBass0320Dto.setDeptCd(strDeptCd);
				lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
				lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						
						mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
						srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
					}
				});  
			} else {
				sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
				String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
				sysComBass0320Dto.setDeptCd(strDeptCd);
				lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
				lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						
						mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
						srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
					}
				});   
			}
		}  
	});  
	
	srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
		@Override
		public void handleEvent(ComponentEvent ce) {   
			
			if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
				// 	GWT.log(" a" + ce.getEvent().getType());
				mutilCombo = true;
			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
				mutilCombo = true;
				//  	GWT.log(" b" + ce.getEvent().getType());
			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
				mutilCombo = false;
				//  	GWT.log(" b" + ce.getEvent().getType());
			} 
		} 
	});
	
	layoutContainer_2.add(srhDeptCd, new FormData("100%"));
	layoutContainer_2.setBorders(false);
	
	LayoutContainer layoutContainer_10 = new LayoutContainer();
	
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(60); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	layoutContainer_10.setLayout(frmlytSch);
	
	
	
	
	LayoutContainer lcTypOccuCd = new LayoutContainer();
	lcTypOccuCd.setLayout(new ColumnLayout());
	
	 LayoutContainer layoutContainer_20 = new LayoutContainer();
	   frmlytSch = new FormLayout();  
	   frmlytSch.setLabelWidth(60); 
	   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	   layoutContainer_20.setLayout(frmlytSch); 
	   
	   
	   srhDeptGpCd  =  new ComboBox<BaseModel>(); 
	   srhDeptGpCd.setName("srhDeptGpCd");
	   srhDeptGpCd.setForceSelection(true);
	   srhDeptGpCd.setAllowBlank(false);
	   srhDeptGpCd.setMinChars(1);
	   srhDeptGpCd.setDisplayField("commCdNm");
	   srhDeptGpCd.setValueField("commCd");
	   srhDeptGpCd.setTriggerAction(TriggerAction.ALL);
	   srhDeptGpCd.setEmptyText("--그룹--");
	   srhDeptGpCd.setSelectOnFocus(true); 
	   srhDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	   srhDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	   srhDeptGpCd.setStore(lsDeptGpCd);
	   srhDeptGpCd.setFieldLabel("직종"); 
	   layoutContainer_20.add(srhDeptGpCd, new FormData("100%")); 
	
	LayoutContainer layoutContainer_21 = new LayoutContainer();
	frmlytSch = new FormLayout();  
	   frmlytSch.setLabelWidth(1); 
	   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	   frmlytSch.setDefaultWidth(0);
	   layoutContainer_21.setLayout(frmlytSch);
	
	srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	srhTypOccuCd.setName("srhTypOccuCd"); 
	srhTypOccuCd.setEmptyText("--직종선택--"); 
	srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	srhTypOccuCd.setWidth(100);
	srhTypOccuCd.setHideLabel(true);
	//srhTypOccuCd.setFieldLabel("직종");
	srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
		public void handleEvent(StoreEvent<ModelData> be) {  
			EventType type = be.getType();
			if (type == Store.Add) { 
				//	2015.11.30 추가 
				if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
					if (!gwtExtAuth.getEnableTypOccuCd()) {
						ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
						srhTypOccuCd.getListView().setChecked(mdSelect, true); 
						srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
						// }  
					}  
					// srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					* 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					* 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					* "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
					++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					//checkInsr3150Auth("srhTypOccuCd", lsTypOccuCd); 
				}
			} 
		}
	});     
	
	srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
		@Override
		public void handleEvent(ComponentEvent ce) { 
	
			//2015.11.30 추가 
			displayDtilOccuInttnCd(); 
		}  
	});  
	
	srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
		@Override
		public void handleEvent(ComponentEvent ce) {   
	
			if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
				// GWT.log(" a" + ce.getEvent().getType());
				mutilCombo = true;
			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
				mutilCombo = true;
				//  GWT.log(" b" + ce.getEvent().getType());
			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
				mutilCombo = false;
				//  GWT.log(" b" + ce.getEvent().getType());
			}  
		} 
	});

	//2015.11.30 추가 
	srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
		@Override
		public void handleEvent(BaseEvent ce) {   
			displayDtilOccuInttnCd();
		} 
	}); 
	
	layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
	
	LayoutContainer lcSchRight = new LayoutContainer();
	frmlytSch = new FormLayout();  
	frmlytSch.setLabelWidth(1); 
	frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	frmlytSch.setDefaultWidth(0);
	lcSchRight.setLayout(frmlytSch);
	
	srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
	srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
	srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
	srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
	srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
	srhDtilOccuInttnCd.setWidth(100);
	srhDtilOccuInttnCd.setHideLabel(true);
	srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
	srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
	srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
		@Override
		public void handleEvent(ComponentEvent ce) {    
			if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
				mutilCombo = true;
			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
				mutilCombo = true;
				//  GWT.log(" b" + ce.getEvent().getType());
			} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
				mutilCombo = false;
				//  GWT.log(" b" + ce.getEvent().getType());
			} else {
			}  
		} 
	});
	
	lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%")); 
	
	lcTypOccuCd.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
	   lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
	   lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
	   layoutContainer_21.setBorders(false);
	
	layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
	layoutContainer_10.setBorders(false);
	
	
	fieldSet.add(layoutContainer_13);
	layoutContainer_13.setBorders(false);
	
	layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
	//layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));
	
	 LayoutContainer lcSchCol3 = new LayoutContainer();
	    lcSchCol3.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_4 = new LayoutContainer();

	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_4.setLayout(frmlytSch);
	    
	    srhBusinCd = new ComboBox<BaseModel>();
	    srhBusinCd.setName("srhBusinCd");
	    srhBusinCd.setForceSelection(true);
	    srhBusinCd.setMinChars(1);
	    srhBusinCd.setDisplayField("businNm");
	    srhBusinCd.setValueField("businCd");
	    srhBusinCd.setTriggerAction(TriggerAction.ALL);
	    srhBusinCd.setEmptyText("--사업선택--");
	    srhBusinCd.setSelectOnFocus(true); 
	    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
	    srhBusinCd.setStore(lsBusinCd);
	    srhBusinCd.setFieldLabel("사업");
	    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
	    layoutContainer_4.setBorders(false);
	    
	    
	    
	    
	    LayoutContainer layoutContainer_5 = new LayoutContainer();
	    layoutContainer_5.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_6 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_6.setLayout(frmlytSch);
	    
	    srhHanNm = new TextField<String>();
	    srhHanNm.setName("srhHanNm");
	    srhHanNm.setFieldLabel("성명");
	    layoutContainer_6.add(srhHanNm, new FormData("100%"));
	    srhHanNm.addKeyListener(new KeyListener() {
	    	 @Override
	        public void componentKeyDown(ComponentEvent event) {
	            
	            srhHanNm.validate();
	            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
	                srhSystemkey.setValue("");
	                srhResnRegnNum.setValue("");
	            }
	            if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	                srhSystemkey.setValue("");
	                srhResnRegnNum.setValue(""); 
	                fnPopupPsnl0100() ;
	            } 
	            super.componentKeyDown(event);
	            		
	        }
	     });
//	    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	        @Override
//	        public void handleEvent(BaseEvent be) {  
//	            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                srhSystemkey.setValue("");
//	                srhResnRegnNum.setValue("");
//	            }
//	         
//	        } 
//	   }); 
	    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	    layoutContainer_6.setBorders(false);
	    
	    Button btnHanNm = new Button("검색");
	    layoutContainer_5.add(btnHanNm);
	    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
	        public void handleEvent(ButtonEvent e) {
	            srhSystemkey.setValue("");
	            srhResnRegnNum.setValue("");   
	          fnPopupPsnl0100() ;
	              
	        }
	    });
	    
	    LayoutContainer layoutContainer_7 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_7.setLayout(frmlytSch);
	    
	    /** column 주민등록번호 : resnRegnNum */
	    srhResnRegnNum = new TextField<String>();
	    srhResnRegnNum.setName("srhResnRegnNum");
	    new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
	    srhResnRegnNum.setHideLabel(true);
	    srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
	        @Override
	        public void handleEvent(BaseEvent be) {  
	            if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
	                srhSystemkey.setValue("");
	                srhHanNm.setValue("");
	            }
	         
	        } 
	  }); 
	    layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
	    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.41));
	    layoutContainer_7.setBorders(false); 
	    layoutContainer_5.setBorders(false);
	    
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		layoutContainer_14.setLayout(frmlytSch);
		
		srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
		srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
		srhHdofcCodtnCd.setEmptyText("--재직선택--");
		srhHdofcCodtnCd.setReadOnly(true);
		srhHdofcCodtnCd.setEnabled(true); 
		srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
		srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		srhHdofcCodtnCd.setWidth(100);
		srhHdofcCodtnCd.setFieldLabel("재직상태");
		srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {  
				checkInsr3150Auth("srhHdofcCodtnCd", lsHdofcCodtnCd);  
			}
		}); 
		srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});
		
		layoutContainer_14.add(srhHdofcCodtnCd, new FormData("100%"));
		layoutContainer_14.setBorders(false);
		
	    lcSchCol3.setBorders(false);
 	    lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	    lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	    
 	    fieldSet.add(lcSchCol3);
	    
	plFrmInsr3150.add(fieldSet); 
	//vp.add(panel);   
	}  
	
	private void  displayDtilOccuInttnCd() {
	
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
			sysComBass0350Dto.setDeptCd(strDeptCd);
			List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
			String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
			sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
			
			// sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
			
			if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
				lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
				//  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
				lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistDtilOccuInttnCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
						srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
						
						if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
							ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
							srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
							srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
						} 
					}
				});     
			} 
		} else {
		} 
	}		  
	
	private void createCheckBoxGrid() {   
		FieldSet fieldSet = new FieldSet();  
		fieldSet.setHeadingHtml("월정산대사내역");
		fieldSet.setStyleAttribute("marginTop", "10px");

		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		lcStdGrid.setLayout(frmlytStd);  
	
		ContentPanel cpGrid = new ContentPanel();   
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());      
		cpGrid.setSize(950, 395);    
	
		insr4200GridPanel = new MSFGridPanel(insr4200Def, false, false, false, false, false);
		insr4200GridPanel.getMsfGrid().setCellModel(true);
		insr4200GridPanel.setHeaderVisible(false);  
		insr4200GridPanel.setBodyBorder(true);
		insr4200GridPanel.setBorders(true);
		insr4200GridPanel.getBottomComponent().setVisible(true);
		
		
//	    GWTUtils.findColumnConfig(insr4200GridPanel, Insr4200BM.ATTR_HANNM).setStyle("background-color:#F5F6CE;");
		     
		AggregationRowConfig<BaseModel> insr4200SummaryRow = new AggregationRowConfig<BaseModel>();  
		 
		insr4200SummaryRow.setCellStyle(Insr4100BM.ATTR_DEPTNM,"summary_color");
		insr4200SummaryRow.setCellStyle(Insr4200BM.ATTR_NATINSRPRMMSRD,"summary_color");
		    
		insr4200SummaryRow.setHtml(Insr4100BM.ATTR_DEPTNM, "합 계");   
		    
		// with summary type and format  
		insr4200SummaryRow.setSummaryType(Insr4200BM.ATTR_NATINSRPRMMSRD, SummaryType.SUM);   
		insr4200SummaryRow.setSummaryFormat(Insr4200BM.ATTR_NATINSRPRMMSRD, NumberFormat.getFormat("#,##0;(#,##0)"));  
		    
		      
		insr4200GridPanel.getGrid().getColumnModel().addAggregationRow(insr4200SummaryRow);  		
		
		
		
		/* 2줄파싱 */
//		insr4200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 10,  new HeaderGroupConfig("공단산출액",	1, 4));
//		insr4200GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 9, new HeaderGroupConfig("급여산출액",	1, 1));
	
		cpGrid.add(insr4200GridPanel);  
		lcStdGrid.add(cpGrid);   
		fieldSet.add(lcStdGrid);   
	
		plFrmInsr3150.add(fieldSet);
	
	}   
	
	private void createSubForm() {
		 
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("국민연금월별대사내역업로드");
		fldstNewFieldset.setStyleAttribute("marginTop", "20px");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout());
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);
		layoutContainer_21.setBorders(false);
		
		insr3150flUp = new FileUploadField();
		insr3150flUp.setName("insr3150flUp");
		insr3150flUp.setValidator(new Validator() {
			@Override
			public String validate(Field<?> field, String value) {
				value = value.toLowerCase();
				String result = "xls 파일이 아닙니다., 다시선택하십시요.";
				if(value.endsWith(".xls") || value.endsWith(".xlsx")) {
					result = null;
				}
				return result;
			}
		});
		layoutContainer_21.add(insr3150flUp, new FormData("100%"));
		insr3150flUp.setFieldLabel("양식선택");
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		layoutContainer_3.setStyleAttribute("paddingLeft", "5px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSch);
		
		Button btnButton01 = new Button("업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsImportData();
			}
		});
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		layoutContainer_3.setBorders(false);
		
		srhUploadDivCd  =  new ComboBox<BaseModel>(); 
		srhUploadDivCd.setName("srhRepbtyBusinDivCd");
		srhUploadDivCd.setForceSelection(true);
		srhUploadDivCd.setAllowBlank(false);
		srhUploadDivCd.setMinChars(1);
		srhUploadDivCd.setDisplayField("commCdNm");
		srhUploadDivCd.setValueField("commCd");
		srhUploadDivCd.setTriggerAction(TriggerAction.ALL);
		srhUploadDivCd.setEmptyText("--업로드구분--");
		srhUploadDivCd.setSelectOnFocus(true); 
		srhUploadDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		srhUploadDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		srhUploadDivCd.setStore(lsUploadDivCd);
		srhUploadDivCd.setHideLabel(true);
		lsUploadDivCd.addStoreListener( new StoreListener<BaseModel>() {   
		public void handleEvent(StoreEvent<BaseModel> be) {  
		

			EventType type = be.getType();
			if (type == Store.Add) { 
				lsUploadDivCd.getAt(0);
			 }  
			
		
		}
		}); 
		
		LayoutContainer layoutContainer_43 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_43.setLayout(frmlytSch);
		
		layoutContainer_43.add(srhUploadDivCd, new FormData("90%"));
		layoutContainer_43.setBorders(false); 
		
		
		LayoutContainer layoutContainer_42 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_42.setLayout(frmlytSch);
		
		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportTmep();
			}
		});
		layoutContainer_42.add(btnButton02, new FormData("100%"));
		layoutContainer_42.setBorders(false);
		
		layoutContainer_2.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.add(layoutContainer_43, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_2.add(layoutContainer_3,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		layoutContainer_2.add(layoutContainer_42, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		
		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.0);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
		layoutContainer.add(layoutContainer_1);
		layoutContainer_1.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSch);
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button topBtn032 = new Button("정산대사");
		buttonBar.add(topBtn032);
		topBtn032.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				insr3150MnthUpdate("Pay");
			}
		});
		
		
		Button topBtn03 = new Button("당월반영");
		buttonBar.add(topBtn03);
		topBtn03.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				insr3150MnthUpdate("This");
			}
		});
		
		Button topBtn02 = new Button("차월반영");
		buttonBar.add(topBtn02);
		topBtn02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				insr3150MnthUpdate("Next");				
			}
		});
		
		
		Button topBtn031 = new Button("반영취소");
		buttonBar.add(topBtn031);
		topBtn031.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				insr3150MnthUpdate("Cancel");				
			}
		});
		

		
		layoutContainer_4.add(buttonBar, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_4, hbld_layoutContainer_2);
		layoutContainer_4.setBorders(false);
		
		plFrmInsr3150.add(fldstNewFieldset);
		LabelField lbFld = new LabelField();
		lbFld.setValue("※ 정산대사는 급여마감 후에 처리 가능합니다.");
		plFrmInsr3150.add(lbFld);
	}
	
	/* 엑셀 업로드 */
	 private void xlsImportData() {
		 
		 MessageBox.confirm("국민연금 월별대사내역-업로드", "국민연금월별대사내역을 업데이트 하시겠습니까?<br>(등록되어있는 월별대사 내역은 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){

			 @Override
	 		public void handleEvent(MessageBoxEvent be) {
	 			//if("Yes".equals(be.getButtonClicked().getText())) {
				 if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	           		/* get the filename to be uploaded */
					String filename = MSFSharedUtils.allowNulls(insr3150flUp.getValue());
					if(filename.length() == 0) {
						Window.alert("선택된 파일이 없습니다.");
					} else {
				   		if("".equals( MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd")) )){
							MessageBox.info("", "업로드구분은 필수 입니다.", null);
							return;
						}
						
						/* submit the form */
						plFrmInsr3150.mask("엑셀 데이타 업데이트 중입니다. 업로드 중...");
						
					    // Create a new timer that calls Window.alert().
					    Timer t = new Timer() {
					      @Override
					      public void run() {
					    	  plFrmInsr3150.unmask();
					    	
					      }
					    };
						
					    // Schedule the timer to run once in 4 seconds.
					    t.schedule(4000);
						
					    String strUpDivCd =  MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd"));
		 
					    String rtnRequestUrl = "";
					    
					    if("I0300002".equals(strUpDivCd)){  //세부업로드
				        	
					    	rtnRequestUrl = "imp/XlsReadInsr3150Import.do";
				        }else{  // 간단업로드 
				        	
				        	rtnRequestUrl = "imp/XlsReadInsr3150_1Import.do";
				        }
					    
						/* 파일업로드 처리 */
						plFrmInsr3150.setAction(GWT.getHostPageBaseURL() + rtnRequestUrl);
						// System.out.println(GWT.getHostPageBaseURL() + "imp/XlsReadInsr3150Import.do");
						plFrmInsr3150.setEncoding(Encoding.MULTIPART);
						plFrmInsr3150.setMethod(Method.POST);
						plFrmInsr3150.submit();
						plFrmInsr3150.onFrameLoad();
						picBoolFile = true;
						
						
					}
					
	                 /* reset and unmask the form */
	                 /* after file upload */
					plFrmInsr3150.addListener(Events.Submit, new Listener<FormEvent>() {
						public void handleEvent(FormEvent evt) {
							if("success".endsWith(evt.getResultHtml()) && picBoolFile) {
								/* 업로드가  성공했으면 인서트 모듈을 태운다. */
								//plFrmInsr3150.unmask();
								//MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null);
								picBoolFile = false;
								evt.setResultHtml("");
							} else {
								if("error".endsWith(evt.getResultHtml()) && picBoolFile) {
									/* 업로드가 성공했으면 인서트 모듈을 태운다. */
									//MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
									picBoolFile = false;
									evt.setResultHtml("");
								} else {
									/* 실패 메시지나 에러 메시지 처리. */
									// MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
									evt.setResultHtml("");
								}
							}
						};
					});
	 			}
	 		}
	 	});
	 } 
	
	public void reload() {
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		insr4200GridPanel.getTableDef().setTableColumnFilters(filters);
		String deductYrMnth = (MSFSharedUtils.getSelectedComboValue(srhDeductYr,"year")) + (MSFSharedUtils.getSelectedComboValue(srhDeductMnth,"month")) ;  
		
		insr4200GridPanel.getTableDef().addColumnFilter("deductYrMnth", deductYrMnth, SimpleColumnFilter.OPERATOR_EQUALS);  /* 공제년월 */
		insr4200GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);  /*단위기관*/ 
		insr4200GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); /*고용구분*/
		
		String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		insr4200GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS); /*부서*/
		//20180305추가 
		insr4200GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr4200GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 		
				
		String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		insr4200GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); /*직종*/ 
		String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"); /*직종세*/  
		insr4200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		insr4200GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); /*사업*/
		insr4200GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); /*사번*/
		insr4200GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    /*성명*/
		insr4200GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); /*주민번호*/  
		
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			for (int i=0; i<ray.length; i++){ 
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd")+","; 
			}
			strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		} 
		insr4200GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		insr4200GridPanel.reload();
		
		actionDatabase = ActionDatabase.READ; 
	}
	
	//폼초기화 검색조건포함 
	private void formInit() {
		authExecEnabled();

//		srhHdofcCodtnCd.clear();
//		srhPayrMangDeptCd.clear();
//		srhEmymtDivCd.clear();
//		srhDeptCd.clear();
//		srhTypOccuCd.clear();
//		srhDtilOccuInttnCd.clear();
//		srhBusinCd.clear();
		srhHanNm.clear(); /* 성명 */
		srhResnRegnNum.clear(); /* 주민번호 */
		
		insr3150flUp.clear(); /* 파일업로드 필드  */
		
		insr4200GridPanel.getMsfGrid().clearData();
	}		 
	
	public void setRecord(BaseModel record) {
		this.record = record;
	}
	
	 public void setListRecord(Iterator<Record> records) {
		    this.records = records;
	 } 
	
	private Insr3150 getThis(){
		return this;
	}
	
	private void fnPopupPsnl0100()  {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
		//  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();  //우편번호 
		
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
		
		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) { 
		
				srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
				srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
				srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호 
				}  
			}
		});
	}
	
	public native String getDetailTemplate() /*-{
	return ['<div class="details">',
	'<tpl for=".">',
	'<img src="{modPath}"><div class="details-info">',
	'<b>Image Name:</b>',
	'<span>{name}</span>',
	'<b>Size:</b>',
	'<span>{sizeString}</span>',
	'<b>Last Modified:</b>',
	'<span>{dateString}</span></div>',
	'</tpl>',
	'</div>'].join("");
	}-*/;
	
	private void xlsExportData() { 

		HashMap<String, String> param = new HashMap<String, String>(); 
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
			String chkkey = "";
			
			for (int i=0; i<ray.length; i++){ 
				BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd")+","; 
			}
			strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		} 
	
		
	    String deductYrMnth = (MSFSharedUtils.getSelectedComboValue(srhDeductYr,"year")) + (MSFSharedUtils.getSelectedComboValue(srhDeductMnth,"month")) ;  

		param.put("pymtYrMnth", deductYrMnth);
		
		param.put("antyDeinYr", InsrUtils.getSelectedComboValue(srhDeductYr,"year"));
		//신고인경우에만 출력 가능하도록 처리 
		param.put("chkAntyDeinYr", InsrUtils.getSelectedComboValue(srhDeductMnth,"chkAntyDeinYr"));
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
		param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		param.put("hdofcCodtnCd", strHdofcCodtnCd);
		param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
		param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
	
		if("".equals(InsrUtils.getSelectedComboValue(srhDeductYr,"year")) ){
			MessageBox.info("", "결정년도는 필수 입니다.", null);
		}else{  
			insr4200GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr3150Export.do","extgwtFrame" ,param);  
		}
	}
	
	private void xlsExportTmep() { 
		
		HashMap<String, String> param = new HashMap<String, String>(); 
		
		
		
	//	Window.alert(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd"));
		
		if("".equals(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd")) ){
			MessageBox.info("", "업로드구분은 필수 입니다.", null);
			return;
		}
		
		 param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
         param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
         param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
         param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
       //  param.put("pyspGrdeCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"));
         param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
         param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
         param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
         param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
         param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
         param.put("uploadDivCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhUploadDivCd,"commCd"))); 
         
		insr4200GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr3150TempExport.do","extgwtFrame" ,param);  
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
